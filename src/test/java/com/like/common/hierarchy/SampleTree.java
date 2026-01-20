package com.like.common.hierarchy;

public class SampleTree extends AbstractHierarchy<SampleTree, String> {

	String id;
	
	String label;
	
	String parentId;
	
	@Override
	public String id() {
		return this.id;
	}
	
	@Override
	public String parentId() {
		return this.parentId;
	}
	
	public SampleTree(String id, String label, String parentId) {
		this.id = id;
		this.label = label;
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "SampleTree [id=" + id + ", label=" + label + ", parentId=" + parentId + ", children=" + children
				+ ", isLeaf=" + isLeaf + "]";
	}

	


}
