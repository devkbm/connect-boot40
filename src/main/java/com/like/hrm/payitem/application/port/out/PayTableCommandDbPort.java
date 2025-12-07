package com.like.hrm.payitem.application.port.out;

import java.util.Optional;

import com.like.hrm.payitem.domain.paytable.PayTable;

public interface PayTableCommandDbPort {	
	
	boolean checkDuplication(PayTable entity);
	
	Optional<PayTable> select(Long id);
	
	void save(PayTable entity);
	
	void delete(Long id);
}
