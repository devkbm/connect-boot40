package com.like.system.bizcode.adapter.out.db;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.bizcode.adapter.out.db.data.BizCodeRepository;
import com.like.system.bizcode.adapter.out.db.data.BizCodeTypeJpaRepository;
import com.like.system.bizcode.adapter.out.db.entity.JpaBizCode;
import com.like.system.bizcode.adapter.out.db.entity.JpaBizCodeId;
import com.like.system.bizcode.adapter.out.db.entity.JpaBizCodeMapper;
import com.like.system.bizcode.adapter.out.db.entity.JpaBizCodeType;
import com.like.system.bizcode.adapter.out.db.entity.JpaBizCodeTypeId;
import com.like.system.bizcode.adapter.out.db.entity.JpaBizCodeTypeMapper;
import com.like.system.bizcode.application.port.out.BizCodeCommandDbPort;
import com.like.system.bizcode.domain.BizCode;

@SecondaryAdapter
@Repository
@Transactional
public class BizCodeCommandDbAdapter implements BizCodeCommandDbPort {
	
	BizCodeRepository repository;
	BizCodeTypeJpaRepository bizCodeTypeJpaRepository;
	
	public BizCodeCommandDbAdapter(BizCodeRepository repository, BizCodeTypeJpaRepository bizCodeTypeJpaRepository) {
		this.repository = repository;
		this.bizCodeTypeJpaRepository = bizCodeTypeJpaRepository;
	}
	
	@Override
	public Optional<BizCode> select(String companyCode, String typeId, String code) {
		JpaBizCodeType jpaBizCodeType = bizCodeTypeJpaRepository.findById(new JpaBizCodeTypeId(companyCode, typeId)).orElse(null);
		JpaBizCode jpaEntity = this.repository.findById(new JpaBizCodeId(companyCode, typeId, code)).orElse(null);
		
		return Optional.ofNullable(JpaBizCodeMapper.toDomainEntity(jpaEntity, JpaBizCodeTypeMapper.toDomainEntity(jpaBizCodeType)));
	}
	
	@Override
	public void save(BizCode entity) {
		JpaBizCodeType jpaBizCodeType = bizCodeTypeJpaRepository.findById(new JpaBizCodeTypeId(entity.getId().getBizCodeTypeId().getCompanyCode()
																							  ,entity.getId().getBizCodeTypeId().getTypeId())).orElse(null);
		
		this.repository.save(JpaBizCodeMapper.toJPAEntity(entity, jpaBizCodeType));		
	}
	
	@Override
	public void delete(String companyCode, String typeId, String code) {
		this.repository.deleteById(new JpaBizCodeId(companyCode, typeId, code));		
	}

}
