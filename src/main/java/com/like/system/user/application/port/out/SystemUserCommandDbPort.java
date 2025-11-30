package com.like.system.user.application.port.out;

import java.util.List;
import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.user.domain.SystemUser;

@SecondaryPort
public interface SystemUserCommandDbPort {
	
	boolean isExists(String userId);
	
	Optional<SystemUser> select(String userId);
	
	List<SystemUser> select(List<String> userIds);
	
	void save(SystemUser entity);
	
	void delete(String userId);
}
