package com.like.hrm.payitem.application.port.out;

import java.util.Optional;

import com.like.hrm.payitem.domain.payinfo.PayStaffItem;

public interface PayStaffItemCommandDbPort {

	Optional<PayStaffItem> select(String id);
	
	void save(PayStaffItem entity);
	
	void delete(String id);
	
}
