package com.onefactor.epdsm.user.repository;

import com.onefactor.epdsm.user.entity.SiteUser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteUserRepository extends JpaRepository<SiteUser, Integer> {

	Optional<SiteUser> findByUsername(String username);

	SiteUser findByEmail(String email);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);
}
