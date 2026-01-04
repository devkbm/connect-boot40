package com.like.system.hierarchycode.application.port.out;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.hierarchycode.domain.Code;
import com.like.system.hierarchycode.domain.CodeId;

@SecondaryPort
public interface HierarchyCodeCommandDbPort {

	boolean exists(CodeId id);
	
	Optional<Code> select(CodeId id);
	
	void save(Code entity);
	
	void delete(CodeId id);
}
