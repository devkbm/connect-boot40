package com.like.system.hierarchycode.adapter.out.db;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;

import com.like.system.hierarchycode.adapter.out.db.data.HierarchyCodeJpaRepository;
import com.like.system.hierarchycode.application.port.out.HierarchyCodeCommandDbPort;
import com.like.system.hierarchycode.domain.Code;
import com.like.system.hierarchycode.domain.CodeId;

@Repository
@SecondaryAdapter
public class HierarchyCodeCommandDbAdapter implements HierarchyCodeCommandDbPort {

	HierarchyCodeJpaRepository repository;
	
	HierarchyCodeCommandDbAdapter(HierarchyCodeJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public boolean exists(CodeId id) {
		return this.repository.existsById(id);
	}

	@Override
	public Optional<Code> select(CodeId id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(Code entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(CodeId id) {
		this.repository.deleteById(id);
	}

}
