package com.like.cooperation.board.application.port.in.board.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.like.cooperation.board.domain.board.BoardType;

import lombok.Data;

@Data
public class BoardHierarchyQueryResultDTO implements Serializable {
	
	private static final long serialVersionUID = -1211211842381004404L;

	String key;
	
	String boardParentId;
	
	BoardType boardType;
	
	String title;
	
	String boardDescription;			
	
	List<BoardHierarchyQueryResultDTO> children = new ArrayList<BoardHierarchyQueryResultDTO>();
	
	public void setChildren(List<BoardHierarchyQueryResultDTO> children) {
		this.children = children;	
	}
	
	@JsonProperty(value="isLeaf")
	boolean isLeaf;
	
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	boolean expanded;
	
	boolean selected;
		
	boolean active;				
	
}
