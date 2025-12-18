package com.like.cooperation.todo.application.port.in.group;

import com.like.cooperation.todo.domain.TodoGroup;

public record TodoGroupCreateResultDTO(
		String groupId,
		String userId,
		String todoGroupName
		) {

	public static TodoGroupCreateResultDTO toDTO(TodoGroup entity) {
		return new TodoGroupCreateResultDTO(
				entity.getGroupId().toString(), 
				entity.getUserId(), 
				entity.getTodoGroupName()
				);
	}
}
