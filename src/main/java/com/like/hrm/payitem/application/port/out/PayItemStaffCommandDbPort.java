package com.like.hrm.payitem.application.port.out;

import java.util.Optional;

import com.like.hrm.payitem.domain.payitemstaff.PayItemStaff;

public interface PayItemStaffCommandDbPort {

	boolean checkDuplication(PayItemStaff entity);
	
	Optional<PayItemStaff> select(Long id);
	
	void save(PayItemStaff entity);
	
	void delete(Long id);
}
