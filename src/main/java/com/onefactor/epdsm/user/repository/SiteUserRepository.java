package com.onefactor.epdsm.user.repository;

 
import com.onefactor.epdsm.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteUserRepository extends JpaRepository<SiteUser, Integer> {
    // Custom query methods can be added here
    SiteUser findByUsername(String username);
    SiteUser findByEmail(String email);
}
