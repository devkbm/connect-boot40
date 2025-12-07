package com.like.hrm.payitem.adapter.out.db.paytable;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.adapter.out.db.paytable.data.PayTableJpaRepository;
import com.like.hrm.payitem.application.port.out.PayTableCommandDbPort;

import com.like.hrm.payitem.domain.paytable.PayTable;
import com.like.hrm.payitem.domain.paytable.QPayTable;

@Repository
public class PayTableCommandDbAdapter implements PayTableCommandDbPort {

	PayTableJpaRepository repository;
	
	PayTableCommandDbAdapter(PayTableJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<PayTable> select(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(PayTable entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	public boolean checkDuplication(PayTable entity) {
		QPayTable qEntity = QPayTable.payTable;
		
		return this.repository.exists(
				qEntity.effectiveDate.eq(entity.getEffectiveDate())
			.and(qEntity.occupationCode.eq(entity.getOccupationCode()))
			.and(qEntity.jobGradeCode.eq(entity.getJobGradeCode()))
			.and(qEntity.payStepCode.eq(entity.getPayStepCode()))
				);
			
	}

}
