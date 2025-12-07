package com.like.cooperation.todo.application.port.in.todo;

import java.time.LocalDate;

public class TodoQueryDTO {
	
	String userId;
	
	String todo;		
		
	Boolean isCompleted;
		
    LocalDate dueDate;	
}
