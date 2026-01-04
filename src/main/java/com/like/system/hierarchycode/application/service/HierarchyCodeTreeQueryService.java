package com.like.system.hierarchycode.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryDTO;
import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryResultDTO;
import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryUseCase;
import com.like.system.hierarchycode.application.port.out.HierarchyCodeTreeQueryDbPort;


@Transactional(readOnly=true)
@Service
public class HierarchyCodeTreeQueryService implements HierarchyCodeTreeQueryUseCase {

	HierarchyCodeTreeQueryDbPort repository;
	
	private List<HierarchyCodeTreeQueryResultDTO> allList;
	
	HierarchyCodeTreeQueryService(HierarchyCodeTreeQueryDbPort repository) {
		this.repository = repository;
	}
	
	public List<HierarchyCodeTreeQueryResultDTO> getCodeHierarchyList(HierarchyCodeTreeQueryDTO dto) {		
						
		allList = repository.getCodeHierarchyList(dto);
		
		List<HierarchyCodeTreeQueryResultDTO> rootList = getRootList(); 					
		
		return addChildren(rootList);
	}
	
	private List<HierarchyCodeTreeQueryResultDTO> getRootList() {
		return allList.stream().filter(e -> !StringUtils.hasText(e.getParentId())).toList();
	}
	
	private List<HierarchyCodeTreeQueryResultDTO> getChildren(String parentId) {
		return allList.stream().filter(e -> parentId.equals(e.getParentId())).toList();
	}
	
	private List<HierarchyCodeTreeQueryResultDTO> addChildren(List<HierarchyCodeTreeQueryResultDTO> nodeList) {
		
		List<HierarchyCodeTreeQueryResultDTO> children = null;
		
		for (HierarchyCodeTreeQueryResultDTO node : nodeList) {					
			children = getChildren(node.getId());
			
			if (children.isEmpty()) {
				node.setLeaf(true);
				continue;
			} else { 					
				node.setLeaf(false);
				node.setChildren(children);
				
				addChildren(children);
			} 				
		}
		
		return nodeList;		
	}
	
	
}
