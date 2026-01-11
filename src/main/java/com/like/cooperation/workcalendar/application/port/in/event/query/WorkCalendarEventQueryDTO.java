package com.like.cooperation.workcalendar.application.port.in.event.query;

import org.jspecify.annotations.Nullable;

public record WorkCalendarEventQueryDTO(		
		String fkWorkCalendar,		
		String fromDate,		
		String toDate,
		@Nullable String title
		) {
		
}