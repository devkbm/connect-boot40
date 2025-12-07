package com.like.hrm.payitem.domain.paytable;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.core.jpa.domain.AbstractAuditEntity;

import io.hypersistence.utils.hibernate.id.Tsid;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 급여테이블
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "HRMPAYTABLE")
@EntityListeners(AuditingEntityListener.class)
public class PayTable extends AbstractAuditEntity {
	
	@Id
	@Tsid
	@Column(name="PAY_TABLE_ID")	
	Long id;
	
	@Column(name="ORG_CD")
	String companyCode;
	
	@Column(name="PAY_ITEM_CODE")
	String payItemCode;
	
	@Column(name="EFFECTIVE_DT")
	LocalDate effectiveDate;

	@Comment("직종코드")
	@Column(name="OCCUPATION_CODE")
	String occupationCode;
		
	@Comment("직급코드")
	@Column(name="JOB_GRADE_CODE")
	String jobGradeCode;
		
	@Comment("호봉코드")
	@Column(name="PAY_STEP_CODE")
	String payStepCode;
	
	@Column(name="WAGE_AMOUNT")
	BigDecimal wageAmount;
	
	@Column(name="ENABLE_YN")
	Boolean isEnable;	
				
	@Column(name="CMT")
	String comment;
			
	public PayTable(
			String companyCode,
			String payItemCode,
			LocalDate effectiveDate,
			String occupationCode,
			String jobGradeCode,
			String payStepCode,
			BigDecimal wageAmount,
			Boolean isEnable,
			String comment
			)	{		
		this.companyCode = companyCode;
		this.payItemCode = payItemCode;
		this.effectiveDate = effectiveDate;
		this.occupationCode = occupationCode;
		this.jobGradeCode = jobGradeCode;
		this.payStepCode = payStepCode;
		this.wageAmount = wageAmount;
		this.isEnable = isEnable;
		this.comment = comment;		
	}
	
	public void modify(
			BigDecimal wageAmount,
			Boolean isEnable,
			String comment
			) {
		this.wageAmount = wageAmount;
		this.isEnable = isEnable;
		this.comment = comment;
	}
		
}
