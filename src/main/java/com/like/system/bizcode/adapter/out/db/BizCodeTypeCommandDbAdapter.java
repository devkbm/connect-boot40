package com.like.system.bizcode.adapter.out.db;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.bizcode.adapter.out.db.data.BizCodeTypeJpaRepository;
import com.like.system.bizcode.adapter.out.db.entity.JpaBizCodeType;
import com.like.system.bizcode.adapter.out.db.entity.JpaBizCodeTypeId;
import com.like.system.bizcode.adapter.out.db.entity.JpaBizCodeTypeMapper;
import com.like.system.bizcode.application.port.out.BizCodeTypeCommandDbPort;
import com.like.system.bizcode.domain.BizCodeType;

@SecondaryAdapter
@Repository
@Transactional
public class BizCodeTypeCommandDbAdapter implements BizCodeTypeCommandDbPort {

	BizCodeTypeJpaRepository repository;
	
	public BizCodeTypeCommandDbAdapter(BizCodeTypeJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<BizCodeType> select(String companyCode, String typeId) {
		JpaBizCodeType jpaEntity = this.repository.findById(new JpaBizCodeTypeId(companyCode, typeId)).orElse(null);
		
		return Optional.ofNullable(JpaBizCodeTypeMapper.toDomainEntity(jpaEntity));
	}	
	
	@Override
	public void Save(BizCodeType entity) {
		this.repository.save(JpaBizCodeTypeMapper.toJPAEntity(entity));		
	}
	
	@Override
	public void delete(String companyCode, String typeId) {
		this.repository.deleteById(new JpaBizCodeTypeId(companyCode, typeId));		
	}
	
}
