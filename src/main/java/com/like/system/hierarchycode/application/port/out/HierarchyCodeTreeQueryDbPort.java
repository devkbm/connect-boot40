package com.like.system.hierarchycode.application.port.out;

import java.util.List;

import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryDTO;
import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryResultDTO;

public interface HierarchyCodeTreeQueryDbPort {

	List<HierarchyCodeTreeQueryResultDTO> getCodeHierarchyList(HierarchyCodeTreeQueryDTO dto);
}
