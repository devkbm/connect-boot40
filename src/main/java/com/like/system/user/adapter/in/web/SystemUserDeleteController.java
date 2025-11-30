package com.like.system.user.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.user.application.port.in.delete.SystemUserDeleteUseCase;

@PrimaryAdapter
@RestController
public class SystemUserDeleteController {		
				
	private SystemUserDeleteUseCase useCase;
		
	public SystemUserDeleteController(SystemUserDeleteUseCase useCase) {
		this.useCase = useCase;
	}
	
	@DeleteMapping("/api/system/user/{userId}")
	public ResponseEntity<?> deleteUser(@RequestParam String companyCode, @PathVariable String userId) {
										
		useCase.delete(userId);															
								 					
		return toList(null, MessageUtil.getDeleteMessage(1));
	}		
			
}
