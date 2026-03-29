package com.like.hrm.staff.application.port.in.staff.contact.select;

import java.util.Optional;

import com.like.common.vo.Address;
import com.like.common.vo.PhoneNumber;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.contact.ContactInfo;

public class StaffContactSelectDTOMapper {
		
	public static StaffContactSelectDTO toDTO(Staff staff) {
	
		Optional<ContactInfo> home = staff.contactInfoList().get("A1");		
		Optional<ContactInfo> extensionNumber = staff.contactInfoList().get("P1");		
		Optional<ContactInfo> mobileNumber = staff.contactInfoList().get("P2");
		
							
		return StaffContactSelectDTO.builder()
				  .companyCode(staff.id().companyCode())	
		 		  .staffNo(staff.id().staffNo())
		 		  .homeAddressType(home.map(ContactInfo::address).map(Address::addressType).orElse(null))
		 		  .homePostNumber(home.map(ContactInfo::address).map(Address::postNumber).orElse(null))
		 		  .homeMainAddress(home.map(ContactInfo::address).map(Address::mainAddress).orElse(null))
		 		  .homeSubAddress(home.map(ContactInfo::address).map(Address::subAddress).orElse(null))
		 		  .extensionNumber(extensionNumber.map(ContactInfo::phoneNumber).map(PhoneNumber::number).orElse(null))
		 		  .mobileNumber(mobileNumber.map(ContactInfo::phoneNumber).map(PhoneNumber::number).orElse(null))		 		  					 		  					 		  					 		  				
				  .build();
	}
}
