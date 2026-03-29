package com.like.system.holiday.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class HolidayId implements Serializable {
	
	private static final long serialVersionUID = 7009267129126381191L;

	@Column(name="ORG_CD")
	String companyCode;
	
	@Column(name="HOLIDAY_DT")
	private LocalDate date;
	
	protected HolidayId() {}

	public HolidayId(String companyCode, LocalDate date) {		
		this.companyCode = companyCode;
		this.date = date;
	}

	public String companyCode() {
		return companyCode;
	}

	public LocalDate date() {
		return date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyCode, date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HolidayId other = (HolidayId) obj;
		return Objects.equals(companyCode, other.companyCode) && Objects.equals(date, other.date);
	}
	
	
}
