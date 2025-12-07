package com.like.hrm.payitem.domain.payexpression;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.core.jpa.domain.AbstractAuditEntity;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
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
@Table(name = "HRMPAYEXPRESSION")
@EntityListeners(AuditingEntityListener.class)
public class PayExpression extends AbstractAuditEntity {
	
	@Id
	@Tsid
	@Column(name="PAY_EXPR_ID")	
	Long id;
	
	@Column(name="ORG_CD")
	String companyCode;
	
	@Column(name="PAY_ITEM_CODE")
	String payItemCode;
	
	@Column(name="PAY_CONDITION")
	String payCondition;
	
	@Column(name="FORMULA")
	String formula;
	
	@Column(name="SEQ")
	Long seq;

	@Column(name="CMT")
	String comment;
	
	public PayExpression(
			String companyCode,
			String payItemCode,
			String payCondition,
			String formula,
			Long seq,
			String comment
			) {
		this.companyCode = companyCode;
		this.payItemCode = payItemCode;
		this.payCondition = payCondition;
		this.formula = formula;
		this.seq = seq;
		this.comment = comment;
	}
	
	public void modify(
			String payCondition,
			String formula,
			Long seq,
			String comment
			) {
		this.payCondition = payCondition;
		this.formula = formula;
		this.seq = seq;
		this.comment = comment;
	}
	
}
