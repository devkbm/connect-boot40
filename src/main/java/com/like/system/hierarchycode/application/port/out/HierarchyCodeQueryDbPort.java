package com.like.system.hierarchycode.application.port.out;

import java.util.List;

import com.like.system.hierarchycode.application.port.in.query.HierarchyCodeQueryResultDTO;

public interface HierarchyCodeQueryDbPort {

	List<HierarchyCodeQueryResultDTO> query();
}
