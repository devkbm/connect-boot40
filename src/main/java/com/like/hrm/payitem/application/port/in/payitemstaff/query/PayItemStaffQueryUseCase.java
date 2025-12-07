package com.like.hrm.payitem.application.port.in.payitemstaff.query;

import java.util.List;

public interface PayItemStaffQueryUseCase {

	List<PayItemStaffQueryResultDTO> query(PayItemStaffQueryDTO dto);
}
