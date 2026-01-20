package com.like.common.hierarchy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractHierarchyTest {

	@DisplayName("dd")
	@Test
	void test() {
		List<SampleTree> tree = new ArrayList<>();
		
		tree.add(new SampleTree("1", "A", null));
		tree.add(new SampleTree("2", "B", null));
		tree.add(new SampleTree("3", "C", "1"));
		
		HierarchyDataGenerator<SampleTree, String> generator = new HierarchyDataGenerator<>(tree);
		
		List<SampleTree> result = generator.getTreeNodes();
		
		//log.info(result.toString());
		
		assertThat(result.get(0).id()).isEqualTo("1");
	}

}
