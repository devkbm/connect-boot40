package com.like.hrm.payitem.application.port.out;

import java.util.Optional;

import com.like.hrm.payitem.domain.payinfo.PayStaffInfo;

public interface PayStaffInfoCommandDbPort {

	Optional<PayStaffInfo> select(String id);
	
	void save(PayStaffInfo entity);
	
	void delete(String id);
}
