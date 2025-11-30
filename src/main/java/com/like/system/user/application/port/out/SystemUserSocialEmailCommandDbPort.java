package com.like.system.user.application.port.out;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.user.domain.oauth2.SystemUserSocialEmail;
import com.like.system.user.domain.oauth2.SystemUserSocialEmailId;

@SecondaryPort
public interface SystemUserSocialEmailCommandDbPort {

	Optional<SystemUserSocialEmail> select(SystemUserSocialEmailId id);
	
	void save(SystemUserSocialEmail entity);
	
	void delete(SystemUserSocialEmailId id);
	
}
