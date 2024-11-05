package com.onefactor.epdsm.user.controller;

import com.onefactor.epdsm.user.entity.SiteUser;
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

    @PostMapping
    public ResponseEntity<SiteUser> createUser(@RequestBody SiteUser user) {
        SiteUser createdUser = siteUserService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiteUser> getUserById(@PathVariable Integer id) {
        Optional<SiteUser> user = siteUserService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<SiteUser>> getAllUsers() {
        List<SiteUser> users = siteUserService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        siteUserService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<SiteUser> getUserByUsername(@PathVariable String username) {
        Optional<SiteUser> user = siteUserService.findByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<SiteUser> getUserByEmail(@PathVariable String email) {
        Optional<SiteUser> user = siteUserService.findByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
