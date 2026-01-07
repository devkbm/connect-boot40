package com.like.system.hierarchycode.application.port.in.treequery;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data		
public class HierarchyCodeTreeQueryResultDTO implements Serializable {	
		
	private static final long serialVersionUID = -6718790962885573030L;

	String parentId;
	String id;	
	String companyCode;						
	String code;	
	String codeName;	
	String codeNameAbbreviation;
	String cmt;
	LocalDateTime fromDate;	
	LocalDateTime toDate;				
	int seq;			
		
	List<HierarchyCodeTreeQueryResultDTO> children = new ArrayList<>();
	
	public void addChilren(List<HierarchyCodeTreeQueryResultDTO> children) {
		this.children = children;
	}
		
	/**
	* NzTreeNode property 
	*/
	String title;
	
	String key;
		
	@JsonProperty(value="isLeaf") 
	boolean isLeaf;
		
}
