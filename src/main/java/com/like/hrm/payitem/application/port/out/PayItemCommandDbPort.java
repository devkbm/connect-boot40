package com.like.hrm.payitem.application.port.out;

import java.util.Optional;

import com.like.hrm.payitem.domain.payitem.PayItem;
import com.like.hrm.payitem.domain.payitem.PayItemId;

public interface PayItemCommandDbPort {
	
	Optional<PayItem> select(PayItemId id);
	
	void save(PayItem entity);
	
	void delete(PayItemId id);	
}
