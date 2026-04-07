package com.like.cooperation.team.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.boot.restclient.autoconfigure.RestClientSsl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.like.cooperation.team.application.port.in.query.TeamQueryDTO;
import com.like.cooperation.team.application.port.in.query.TeamQueryResultDTO;
import com.like.cooperation.team.application.port.in.query.TeamQueryUseCase;
import com.like.cooperation.team.domain.TeamMember;
import com.like.core.message.MessageUtil;
import com.like.core.web.response.ApiResponseList;
import com.like.system.user.application.port.in.query.SystemUserQueryDTO;

@RestController
public class TeamQueryController {

	private TeamQueryUseCase service;
	
	RestClient restClient = RestClient.create();
	
	public TeamQueryController(
			TeamQueryUseCase service, 
			RestClientSsl ssl) {
		restClient = RestClient.builder()
				.baseUrl("https://localhost:8090")
				//.apply(ssl.fromBundle("sslbundle"))
				.build();
		this.service = service;
	}
	
	@GetMapping("/api/grw/team")
	public ResponseEntity<?> getTeamList(@ModelAttribute TeamQueryDTO searchCondition) {
						
		List<TeamQueryResultDTO> list = service.selectTeamList(searchCondition);				
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));												
	}
	
	
	
	@GetMapping("/api/grw/team/allmember")
	public ResponseEntity<?> getAllMemberList(SystemUserQueryDTO condition) {
				
		//List<SystemUserSaveDTO> list = service.selectAllMemberList(condition);						 				
		List<?> list = null;
		ResponseEntity entity = restClient.get()
								 //.header("Content-Type", "application/json")								 
								 .uri("/api/system/user")	
								 
								 .retrieve()
								 .toEntity(ApiResponseList.class);
		
		
		return entity;
		
		//return toList(list, MessageUtil.getQueryMessage(0));
	}
	
}
