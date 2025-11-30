package com.like.system.user.application.port.in.social;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface SelectSystemUserSocialUseCase {

	List<SelectSystemUserSocialDTO> select(String userId); 
}
