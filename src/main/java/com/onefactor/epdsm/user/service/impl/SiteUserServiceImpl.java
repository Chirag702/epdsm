package com.onefactor.epdsm.user.service.impl;

import com.onefactor.epdsm.user.entity.SiteUser;
import com.onefactor.epdsm.user.repository.SiteUserRepository;
import com.onefactor.epdsm.user.service.SiteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class SiteUserServiceImpl implements SiteUserService {

	@Autowired
	private SiteUserRepository siteUserRepository;

	@Override
	public SiteUser save(SiteUser user) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		user.setJoinDate(currentTimestamp);
		// You might want to handle password hashing here before saving
 		return siteUserRepository.save(user);
	}

	@Override
	public Optional<SiteUser> findById(Integer id) {
		return siteUserRepository.findById(id);
	}

	@Override
	public List<SiteUser> findAll() {
		return siteUserRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		siteUserRepository.deleteById(id);
	}

	@Override
	public Optional<SiteUser> findByUsername(String username) {
		return siteUserRepository.findByUsername(username);
	}

	@Override
	public Optional<SiteUser> findByEmail(String email) {
		return Optional.ofNullable(siteUserRepository.findByEmail(email));
	}
}
