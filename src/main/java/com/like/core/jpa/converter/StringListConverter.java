package com.like.core.jpa.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

	private static final String SEPARATOR = ",";
	 
	@Override
	public String convertToDatabaseColumn(List<String> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        
		return String.join(SEPARATOR, attribute); 
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return Collections.emptyList();
        }
        
		return new ArrayList<>(Arrays.asList(dbData.split(SEPARATOR)));
	}
	
}
