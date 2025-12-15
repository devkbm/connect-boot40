package com.like.hrm.staffsalary.domain.model;

import java.time.LocalDate;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "HRMSALARYTABLE")
public class SalaryTable {
	
	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="ID", nullable = false, comment="식별자")
	Long id;
		
	@Column(name="BASE_DT", comment="기준일")
	LocalDate baseDate;
		
	@Embedded
	SalaryAppointmentInformation appointmentInfo;
				
	@Column(name="AMOUNT", comment="금액")
	BigDecimal amount;
		
	public SalaryTable(
			LocalDate baseDate,
			SalaryAppointmentInformation appointmentInfo,
			BigDecimal amount
			) {
		this.baseDate = baseDate;
		this.appointmentInfo = appointmentInfo;		
		this.amount = amount;		
	}
		
}
