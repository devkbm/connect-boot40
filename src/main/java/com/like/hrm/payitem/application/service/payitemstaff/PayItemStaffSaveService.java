package com.like.hrm.payitem.application.service.payitemstaff;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payitemstaff.save.PayItemStaffSaveDTO;
import com.like.hrm.payitem.application.port.in.payitemstaff.save.PayItemStaffSaveDTOMapper;
import com.like.hrm.payitem.application.port.in.payitemstaff.save.PayItemStaffSaveUseCase;
import com.like.hrm.payitem.application.port.out.PayItemStaffCommandDbPort;
import com.like.hrm.payitem.domain.payitemstaff.PayItemStaff;

import jakarta.persistence.EntityExistsException;

@Service
public class PayItemStaffSaveService implements PayItemStaffSaveUseCase {

	PayItemStaffCommandDbPort dbPort;
	
	PayItemStaffSaveService(PayItemStaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(PayItemStaffSaveDTO dto) {
		String id = dto.id();
		PayItemStaff entity = null;
		
		if (id == null) {
			entity = PayItemStaffSaveDTOMapper.newEnity(dto);
			
			if (dbPort.checkDuplication(entity)) {
				throw new EntityExistsException("중복된 데이터가 존재합니다."); 
			}
			
		} else {
			entity = this.dbPort.select(Long.parseLong(id)).orElse(null);
			
			entity = PayItemStaffSaveDTOMapper.modify(entity, dto);
		}
			
		this.dbPort.save(entity);		
	}

}
