package com.like.hrm.payitem.domain.payinfo;

import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.core.jpa.domain.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "HRMPAYSTAFF")
@EntityListeners(AuditingEntityListener.class)
public class PayStaffInfo extends AbstractAuditEntity {
	
	// companyCode + payYm + paySeq + staffNo 
	@Id
	@Column(name="PAY_STAFF_ID")
	String id;
	
	@Column(name="ORG_CD")
	String companyCode;
		
	@Column(name="PAY_YYYYMM")
	String payYm;
	
	@Column(name="PAY_SEQ")
	Long paySeq;
	
	@Column(name="STAFF_NO")
	String staffNo;
	
	@Comment("마감여부")
	@Column(name="CLOSE_YN")
	Boolean isClose;
	
	@Embedded
	PayStaffAppointment appointment;
	
	public PayStaffInfo(
			String companyCode,
			String payYm,
			Long paySeq,
			String staffNo,
			PayStaffAppointment appointment
			) {
		this.id = companyCode + payYm + paySeq + staffNo;  
		this.companyCode = companyCode;
		this.payYm = payYm;
		this.paySeq = paySeq;
		this.appointment = appointment;
	}
	
}
