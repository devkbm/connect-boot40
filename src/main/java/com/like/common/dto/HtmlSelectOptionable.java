package com.like.common.dto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * HTML Select Tag의 Option Tag에 활용 
 */
public interface HtmlSelectOptionable {	
	public String label();
	public String value();
	public Long sequence();
	
	public static List<HtmlSelectOptionRecord> fromEnum(Class<? extends HtmlSelectOptionable> obj) {
		return Arrays.stream(obj.getEnumConstants())
					 // sequence가 null인 경우 우선 표시
					 .sorted(Comparator.comparing(HtmlSelectOptionable::sequence, Comparator.nullsLast(Comparator.naturalOrder())))
					 .map(e -> new HtmlSelectOptionRecord(e.label(), e.value()))
					 .toList();
	}
}
