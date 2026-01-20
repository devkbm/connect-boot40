package com.like.common.hierarchy;

import java.util.List;

public abstract class AbstractHierarchy<T, ID> {

    List<T> children;
	
	boolean isLeaf;

	public abstract ID parentId();

    public void setChildren(List<T> children) {
		this.children = children;
	}
	
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
}
