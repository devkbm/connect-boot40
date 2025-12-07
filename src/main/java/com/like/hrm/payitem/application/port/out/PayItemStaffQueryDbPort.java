package com.like.hrm.payitem.application.port.out;

import java.util.List;

import com.like.hrm.payitem.application.port.in.payitemstaff.query.PayItemStaffQueryDTO;
import com.like.hrm.payitem.application.port.in.payitemstaff.query.PayItemStaffQueryResultDTO;

public interface PayItemStaffQueryDbPort {

	List<PayItemStaffQueryResultDTO> query(PayItemStaffQueryDTO dto);
	
}
