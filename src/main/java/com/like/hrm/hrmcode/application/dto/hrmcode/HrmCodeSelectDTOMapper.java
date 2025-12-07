package com.like.hrm.hrmcode.application.dto.hrmcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import tools.jackson.core.type.TypeReference;
import com.like.hrm.hrmcode.domain.HrmCode;
import com.like.hrm.hrmcode.domain.HrmCodeType;

import tools.jackson.databind.json.JsonMapper;

public class HrmCodeSelectDTOMapper {

		
	public static Map<String, Object> stringToMap(String str) {
		if (!StringUtils.hasText(str)) return null;
		
		JsonMapper mapper = JsonMapper.builder().build();
					
		return mapper.readValue(str, new TypeReference<HashMap<String, Object>>() {});
	}
	
	public static HrmCodeSelectDTO toDTO(HrmCode entity, HrmCodeType codeType) {
		if (entity == null) return null;
									
		Map<String, Object> extraInfo = new HashMap<>();
		
		if (StringUtils.hasText(entity.getExtraInfo())) {
			extraInfo = stringToMap(entity.getExtraInfo());
		}
									
		return HrmCodeSelectDTO
				.builder()
				.typeId(entity.getId().getTypeId())
				.code(entity.getId().getCode())
				.codeName(entity.getCodeName())
				.useYn(entity.isUseYn())
				.sequence(entity.getSequence())
				.comment(entity.getComment())
				.extraInfo(extraInfo)
				.fieldConfig(codeType.getFieldConfig())
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
