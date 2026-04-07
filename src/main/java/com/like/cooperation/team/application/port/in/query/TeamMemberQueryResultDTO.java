package com.like.cooperation.team.application.port.in.query;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

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
