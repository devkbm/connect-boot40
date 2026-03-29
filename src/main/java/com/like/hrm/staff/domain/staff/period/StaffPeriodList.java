package com.like.hrm.staff.domain.staff.period;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class StaffPeriodList {

	@OrderBy("seq asc")
	@OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
	Set<StaffPeriod> periodList = new LinkedHashSet<>();
	
	public Stream<StaffPeriod> getStream() {
		return this.periodList.stream();
	}
	
	public StaffPeriod get(Staff staff, String periodType, Long seq) {
		return this.periodList
				.stream()
				.filter(e -> e.id().equals(new StaffPeriodId(staff, periodType, seq)))
				.findFirst()
				.orElse(null);
	}
	
	public StaffPeriod getMax(Staff staff, String periodType) {
		return this.periodList
				.stream()			
				.filter(e -> e.id().periodType().equals(periodType))
				.max((s1, s2) -> Long.compare(s1.id().seq(), s2.id().seq()))				
				.orElse(null);
	}
	
	
	public void add(StaffPeriod period) {
		this.periodList.add(period);
	}
	
	
	long nextSequence() {
		long maxSeq = 0;
		
		if (this.periodList == null || this.periodList.isEmpty()) {
			maxSeq = 0;
		} else {			
			maxSeq = this.periodList.stream()
							  		.mapToLong(e -> e.id().seq())
							  		.max()
							  		.getAsLong();							 
		}
					
		return maxSeq + 1;
	}
	
}
