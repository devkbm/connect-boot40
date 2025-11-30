package com.like.system.user.application.port.out;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.user.domain.SystemUserCompany;
import com.like.system.user.domain.SystemUserCompanyId;

@SecondaryPort
public interface SystemUserCompanyCommandDbPort {
	
	Optional<SystemUserCompany> find(SystemUserCompanyId id); 
	
	void save(SystemUserCompany entity);
	
	void delete(SystemUserCompanyId id);
}
