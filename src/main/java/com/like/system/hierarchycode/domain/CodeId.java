package com.like.system.hierarchycode.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = {"companyCode", "codeId"})
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
public class CodeId implements Serializable {
	
	private static final long serialVersionUID = 5066344742442647534L;

	@Column(name="ORG_CD")
	String companyCode;
	
	@Column(name="CODE_ID")
	String codeId;
	
	public CodeId(String companyCode, String codeId) {
		this.companyCode = companyCode;		
		this.codeId = codeId;		
	}
	
	public CodeId(String companyCode, Code parentCode, String code) {
		this.companyCode = companyCode;		
		
		if ( parentCode == null ) {
			this.codeId = code;			
		} else {
			this.codeId = parentCode.getId().getCodeId() + code;
		}
	}
}
