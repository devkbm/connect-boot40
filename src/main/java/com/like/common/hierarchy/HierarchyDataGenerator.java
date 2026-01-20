package com.like.common.hierarchy;

import java.util.List;

public class HierarchyDataGenerator<T extends AbstractHierarchy<T, ID>, ID> {

    List<T> allFlattenNodes;

    public HierarchyDataGenerator(List<T> allFlattenNodes) {
        this.allFlattenNodes = allFlattenNodes;
    }

    public List<T> getTreeNodes() {
        List<T> rootNodeList = getRootList();
						
		return addChildren(rootNodeList);
    }

    private List<T> addChildren(List<T> nodes) {
		List<T> children = null;
		
		for ( T node : nodes ) {
			children = getChildren(node.id());
			
			if (children.isEmpty()) {
				node.setLeaf(true);
				continue;
			} else {							
				node.setChildren(children);
				node.setLeaf(false);
								
				this.addChildren(children); 	//recursive call
			}
		}
				
		return nodes;
	}
	
	private List<T> getRootList() {
		return this.allFlattenNodes
							.stream()
							.filter(e -> e.parentId() == null)
							.toList();
	}	
	
	private List<T> getChildren(ID parentId) {
		return this.allFlattenNodes
							.stream()
							.filter(e -> parentId != null && parentId.equals(e.parentId()))
							.toList();
	}
}
