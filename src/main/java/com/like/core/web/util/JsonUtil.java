package com.like.core.web.util;

import java.io.IOException;
import java.util.List;

import tools.jackson.databind.json.JsonMapper;

public abstract class JsonUtil {

	private static final JsonMapper mapper = JsonMapper.builder().build();
	
	/**
	 * Json 스트링을 List 형태로 변환한다.
	 * @param jsonStr
	 * @param target
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static <T> List<T> toBeanList(String jsonStr, Class<?> target) throws IOException, ClassNotFoundException {
		if (jsonStr == null)
			return null;					
		return mapper.readValue(jsonStr, mapper.getTypeFactory().constructCollectionType(List.class, Class.forName(target.getName())));	
	}	
	
}
