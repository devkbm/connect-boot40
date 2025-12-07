package com.like.hrm.hrmcode.application.dto.hrmcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import tools.jackson.core.type.TypeReference;
import com.like.hrm.hrmcode.domain.HrmCode;
import com.like.hrm.hrmcode.domain.HrmCodeId;

import lombok.AccessLevel;
import lombok.Builder;
import tools.jackson.databind.json.JsonMapper;

@Builder(access = AccessLevel.PRIVATE)
public record HrmCodeSaveDTO(
		String companyCode,
		String clientAppUrl,
		String typeId,
		String code,
		String codeName,
		boolean useYn,
		Integer sequence,
		String comment,
		Map<String, Object> extraInfo
		) {
	
	public HrmCode newEntity() {
						
		return new HrmCode(
				new HrmCodeId(typeId, code),										
				this.codeName,
		  		this.useYn,
		   		this.sequence,
		   		this.comment,
		   		mapToString(this.extraInfo)
				);
	}
		
	public HrmCode modify(HrmCode entity) {		
		
		entity.modify(
				this.codeName,
				this.useYn,
				this.sequence,
				this.comment,
				mapToString(this.extraInfo)
				);
		return entity;
	}
	
	private String mapToString(Map<String, Object> mapValue)  {
		JsonMapper mapper = JsonMapper.builder().build();
				
		return mapper.writeValueAsString(mapValue);
	}
	
	public static Map<String, Object> stringToMap(String str)  {
		if (!StringUtils.hasText(str)) return null;
		
		JsonMapper mapper = JsonMapper.builder().build();
					
		//return new ObjectMapper().readValue(str, new TypeReference<HashMap<String, Object>>() {});
		return mapper.readValue(str, new TypeReference<HashMap<String, Object>>() {});
	}

	public static HrmCodeSaveDTO toDTO(HrmCode entity) {
		if (entity == null) return null;
									
		Map<String, Object> extraInfo = new HashMap<>();
		
		if (StringUtils.hasText(entity.getExtraInfo())) {
			extraInfo = stringToMap(entity.getExtraInfo());
		}
									
		return HrmCodeSaveDTO
				.builder()
				.typeId(entity.getId().getTypeId())
				.code(entity.getId().getCode())
				.codeName(entity.getCodeName())
				.useYn(entity.isUseYn())
				.sequence(entity.getSequence())
				.comment(entity.getComment())
				.extraInfo(extraInfo)				
				/*
				.fieldConfig(
						"""
					   	[
					   	{
					   		"key" 	: "the1AddInfo",
					   		"type"	: "input",
					   		"props" : {				   			
					   			"label" : "Input",
					   			"placeholder" : "Placeholder",
					   			"description" : "Description"				   			
					   		}
					   	},
					   	{
					   		"key" 	: "the2AddInfo",
					   		"type"	: "input",
					   		"props" : {				   			
					   			"label" : "Input2",
					   			"placeholder" : "Placeholder2",
					   			"description" : "Description2"				   			
					   		}
					   	}
					   	]
					   	"""
						)	
				*/			
				.build();			
	}
}