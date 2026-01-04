package com.like.system.hierarchycode.application.port.in.treequery;

import java.util.List;

public interface HierarchyCodeTreeQueryUseCase {

	List<HierarchyCodeTreeQueryResultDTO> getCodeHierarchyList(HierarchyCodeTreeQueryDTO dto);
}
