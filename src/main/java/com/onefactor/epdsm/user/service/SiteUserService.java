package com.onefactor.epdsm.user.service;

 
import com.onefactor.epdsm.user.entity.SiteUser;

import java.util.List;
import java.util.Optional;

public interface SiteUserService {
    SiteUser save(SiteUser user);
    Optional<SiteUser> findById(Integer id);
    List<SiteUser> findAll();
    void deleteById(Integer id);
    Optional<SiteUser> findByUsername(String username);
    Optional<SiteUser> findByEmail(String email);
}
