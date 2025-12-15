package com.like.hrm.staffsalary.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.like.core.jpa.domain.AbstractAuditEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "HRMSTAFFSALARYITEM")
public class StaffSalaryItem extends AbstractAuditEntity {

	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", nullable = false)
	Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "ID", nullable=false, updatable=false)
	StaffSalary staffSalary;
				
	@Column(name="SALARY_ITEM_CODE", comment="급여항목")
	String salaryItemCode;
	
	@Column(name="CALC_DAY", comment="계산일수")
	Integer calcDays;
		
	@Column(name="CALC_FOMULA", comment="계산식")
	String calcFomula;
		
	@Column(name="AMOUNT", comment="금액")
	BigDecimal amount;
		
	public StaffSalaryItem(
			StaffSalary staffSalary,
			String salaryItemCode,
			Integer calcDays,
			String calcFomula,
			BigDecimal amount
			) {
		this.staffSalary = staffSalary;
		this.salaryItemCode = salaryItemCode;
		this.calcDays = calcDays;
		this.calcFomula = calcFomula;
		this.amount = amount;
	}
}
