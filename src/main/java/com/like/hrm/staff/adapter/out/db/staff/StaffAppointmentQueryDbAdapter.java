package com.like.hrm.staff.adapter.out.db.staff;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.querydsl.StaffAppointmentQuerydsl;
import com.like.hrm.staff.application.port.in.staff.appointment.query.StaffAppointmentQueryResultDTO;
import com.like.hrm.staff.application.port.out.staff.StaffAppointmentQueryDbPort;

@SecondaryAdapter
@Repository
public class StaffAppointmentQueryDbAdapter implements StaffAppointmentQueryDbPort {

	StaffAppointmentQuerydsl repository;
	
	StaffAppointmentQueryDbAdapter(StaffAppointmentQuerydsl repository) {
		this.repository = repository;
	}
	
	@Override
	public List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo) {
		return this.repository.select(companyCode, staffNo);	
	}	

}
