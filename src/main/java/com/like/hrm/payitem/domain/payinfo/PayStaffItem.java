package com.like.hrm.payitem.domain.payinfo;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.core.jpa.domain.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "HRMPAYSTAFFITEM")
@EntityListeners(AuditingEntityListener.class)
public class PayStaffItem extends AbstractAuditEntity {

	// PAY_STAFF_ID + PAY_ITEM_CODE  
	@Id
	@Column(name="PAY_STAFF_ITEM_ID")
	String id;
	
	@Column(name="PAY_ITEM_CODE")
	String payItemCode;
		
	@Column(name="WAGE_AMOUNT", comment="금액")
	BigDecimal wageAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAY_STAFF_ID", nullable=false, updatable=false)
	PayStaffInfo payStaffInfo;
	
	public PayStaffItem(
			PayStaffInfo payStaffInfo,
			String payItemCode,
			BigDecimal wageAmount
			) {
		this.id = payStaffInfo.id + payItemCode;
		this.payStaffInfo = payStaffInfo;
		this.payItemCode = payItemCode;
		this.wageAmount = wageAmount;				
	}
		
}
