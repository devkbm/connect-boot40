package com.like.common.vo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LocalDatePeriod implements Serializable {
	
	private static final long serialVersionUID = -5440169980662476619L;

	@Column(name="FROM_DT")
	private LocalDate from;
	
	@Column(name="TO_DT")
	private LocalDate to;
	
	protected LocalDatePeriod() {}
	
	public LocalDatePeriod(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
		
		if (!isValid()) {
			throw new IllegalArgumentException(		
				String.format(
						"시작일시[%s]가 종료일시[%s]보다 클 수 없습니다.",
						from.toString(),
						to.toString()
						)
			);
		}	
	}
	
	public LocalDate from() {
		return from;
	}

	public LocalDate to() {
		return to;
	}
		
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LocalDatePeriod [from=");
		builder.append(from);
		builder.append(", to=");
		builder.append(to);
		builder.append("]");
		return builder.toString();
	}

	private boolean isValid() {		
		return from.isAfter(to) ? false : true;
	}	
		
	public static void main(String[] args) {
		LocalDatePeriod p1 = new LocalDatePeriod(LocalDate.of(1991, 1, 1), LocalDate.of(1991, 1, 2));
		LocalDatePeriod p2 = new LocalDatePeriod(LocalDate.of(1990, 1, 1), LocalDate.of(1991, 1, 2));
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}


}
