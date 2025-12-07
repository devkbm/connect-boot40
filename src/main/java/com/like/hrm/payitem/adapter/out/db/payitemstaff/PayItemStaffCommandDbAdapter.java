package com.like.hrm.payitem.adapter.out.db.payitemstaff;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.adapter.out.db.payitemstaff.data.PayItemStaffJpaRepository;
import com.like.hrm.payitem.application.port.out.PayItemStaffCommandDbPort;

import com.like.hrm.payitem.domain.payitemstaff.PayItemStaff;
import com.like.hrm.payitem.domain.payitemstaff.QPayItemStaff;

@Repository
public class PayItemStaffCommandDbAdapter implements PayItemStaffCommandDbPort {

	PayItemStaffJpaRepository repository;
	
	PayItemStaffCommandDbAdapter(PayItemStaffJpaRepository repository) {
		this.repository = repository;				
	}
	
	@Override
	public boolean checkDuplication(PayItemStaff entity) {
		QPayItemStaff qEntity = QPayItemStaff.payItemStaff;
		
		return this.repository.exists(
				qEntity.companyCode.eq(entity.getCompanyCode())
				.and(qEntity.staffNo.eq(entity.getStaffNo()))
				.and(qEntity.payItemCode.eq(entity.getPayItemCode()))				
				);
	}

	@Override
	public Optional<PayItemStaff> select(Long id) {
		return this.repository.findById(id);	
	}

	@Override
	public void save(PayItemStaff entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}
