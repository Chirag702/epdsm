package com.onefactor.epdsm.user.controller;

import com.onefactor.epdsm.user.entity.SiteUser;
import com.onefactor.epdsm.user.security.jwt.JwtUtils;
import com.onefactor.epdsm.user.service.SiteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class SiteUserController {

    @Autowired
    private SiteUserService siteUserService;

    @Autowired
    private JwtUtils jwtUtils;

    // Helper method to extract and validate the JWT token
    private String extractUsernameFromToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwtToken = authorizationHeader.substring(7);
            if (jwtUtils.validateJwtToken(jwtToken)) {
                return jwtUtils.getUserNameFromJwtToken(jwtToken);
            }
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestHeader("Authorization") String authorizationHeader, @RequestBody SiteUser user) {
        String username = extractUsernameFromToken(authorizationHeader);
        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
        }

        SiteUser createdUser = siteUserService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@RequestHeader("Authorization") String authorizationHeader, @PathVariable Integer id) {
        String username = extractUsernameFromToken(authorizationHeader);
        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
        }

        Optional<SiteUser> user = siteUserService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(@RequestHeader("Authorization") String authorizationHeader) {
        String username = extractUsernameFromToken(authorizationHeader);
        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
        }

        List<SiteUser> users = siteUserService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@RequestHeader("Authorization") String authorizationHeader, @PathVariable Integer id) {
        String username = extractUsernameFromToken(authorizationHeader);
        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
        }

        siteUserService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUserByUsername(@RequestHeader("Authorization") String authorizationHeader, @PathVariable String username) {
        String authenticatedUsername = extractUsernameFromToken(authorizationHeader);
        if (authenticatedUsername == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
        }

        Optional<SiteUser> user = siteUserService.findByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@RequestHeader("Authorization") String authorizationHeader, @PathVariable String email) {
        String username = extractUsernameFromToken(authorizationHeader);
        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
        }

        Optional<SiteUser> user = siteUserService.findByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
