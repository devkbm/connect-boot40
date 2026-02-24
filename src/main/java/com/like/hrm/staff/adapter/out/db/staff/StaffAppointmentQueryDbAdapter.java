package com.like.hrm.staff.adapter.out.db.staff;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.mybatis.StaffAppointmentQueryOracle;
import com.like.hrm.staff.adapter.out.db.staff.querydsl.StaffAppointmentQuerydsl;
import com.like.hrm.staff.application.port.in.staff.appointment.query.StaffAppointmentQueryDTO;
import com.like.hrm.staff.application.port.in.staff.appointment.query.StaffAppointmentQueryResultDTO;
import com.like.hrm.staff.application.port.out.staff.StaffAppointmentQueryDbPort;

@SecondaryAdapter
@Repository
public class StaffAppointmentQueryDbAdapter implements StaffAppointmentQueryDbPort {

	@Value("${mybatis.configuration.database-id}")
	String databaseId;
	
	StaffAppointmentQuerydsl repository;
	StaffAppointmentQueryOracle oracle;
	
	
	StaffAppointmentQueryDbAdapter(
			StaffAppointmentQuerydsl repository,
			StaffAppointmentQueryOracle oracle
			) {
		this.repository = repository;
		this.oracle = oracle;
	}
	
	@Override
	public List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo) {
		
		List<StaffAppointmentQueryResultDTO> list;
		
		
		if (databaseId == "oracle") {
			list = oracle.query(new StaffAppointmentQueryDTO(companyCode, staffNo, null, null, null));
		} else {
			//list = this.repository.select(companyCode, staffNo);
			list = this.repository.query(new StaffAppointmentQueryDTO(companyCode, staffNo, null, null, null));
		}
					
		return list;
				
	}

	@Override
	public List<StaffAppointmentQueryResultDTO> query(StaffAppointmentQueryDTO dto) {
		
		List<StaffAppointmentQueryResultDTO> list;
		
		if (databaseId == "oracle") {
			list = oracle.query(dto);
		} else {
			list = this.repository.query(dto);
		}
					
		return list;
	}	

}
