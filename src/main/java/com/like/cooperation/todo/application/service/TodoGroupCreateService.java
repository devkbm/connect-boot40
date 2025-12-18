package com.like.cooperation.todo.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.todo.application.port.in.group.TodoGroupCreateResultDTO;
import com.like.cooperation.todo.application.port.in.group.TodoGroupCreateUseCase;
import com.like.cooperation.todo.application.port.out.TodoGroupCommandDbPort;
import com.like.cooperation.todo.domain.TodoGroup;

@Transactional
@Service
public class TodoGroupCreateService implements TodoGroupCreateUseCase {

	TodoGroupCommandDbPort dbPort;
	
	TodoGroupCreateService(TodoGroupCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public TodoGroupCreateResultDTO create(String userId) {
		TodoGroup todoGroup = new TodoGroup(userId);
		dbPort.save(todoGroup);
		
		return TodoGroupCreateResultDTO.toDTO(todoGroup);
	}

}
