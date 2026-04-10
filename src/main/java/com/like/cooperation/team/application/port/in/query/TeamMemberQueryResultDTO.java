package com.like.cooperation.team.application.port.in.query;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamMemberQueryResultDTO {

	
	LocalDateTime createdDt;
	String createdBy;
	LocalDateTime modifiedDt;
	String modifiedBy;
	String clientAppUrl;
	String companyCode;	
	String teamId;
	String teamName;
	String userId;
	List<String> list;
}
