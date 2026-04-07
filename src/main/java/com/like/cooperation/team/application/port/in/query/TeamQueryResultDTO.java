package com.like.cooperation.team.application.port.in.query;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TeamQueryResultDTO {
	LocalDateTime createdDt;
	String createdBy;
	LocalDateTime modifiedDt;
	String modifiedBy;
	String clientAppUrl;
	String companyCode;
	String teamId;
	String teamName;
	
	public TeamQueryResultDTO() {}
}
