package com.like.cooperation.board.domain.board;

import java.util.List;

import com.like.core.jpa.converter.StringListConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Embeddable
public class BoardCategory {

	@Column(name="CATEGORY_YN", comment="사용여부")
	Boolean use;
	
	@Convert(converter = StringListConverter.class)
	@Column(name="CATEGORY", comment="분류")
	List<String> category;
	
}
