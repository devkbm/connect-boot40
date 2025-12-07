package com.like.hrm.staff.application.port.out.staff;

import java.util.List;
import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.staff.domain.staff.contact.ContactInfo;
import com.like.hrm.staff.domain.staff.contact.ContactInfoId;

@SecondaryPort
public interface StaffContactInfoCommandDbPort {

	Optional<ContactInfo> select(ContactInfoId id);	

	ContactInfo save(ContactInfo entity);
	
	void save(List<ContactInfo> entityList);
	
	void delete(ContactInfoId id);
}
