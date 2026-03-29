package com.like.system.term.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.core.jpa.converter.StringListConverter;
import com.like.core.jpa.domain.AbstractAuditEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>용어사전 엔티티<p/>
 * 
 * 1. 단일단어로 구성 <br>
 * 2. 복합단어로 구성 <br>
 *   - 복합단어일 경우 _(under-bar)로 결합 <br>
 */
@Accessors(fluent = true) @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "COMTERM")
@EntityListeners(AuditingEntityListener.class)
public class TermDictionary extends AbstractAuditEntity {	
		
	@Id	
	@Column(name="TERM", unique = true)
	String term;		
	
	@Column(name="TERM_ENG")
	String termEng;
	
	@Column(name="DEFINITION")
	String definition;
		
	@Column(name="STATUS")
	String status;
					
	@Convert(converter = StringListConverter.class)
	@Column(name="SYSTEM")
	List<String> system;
	
	@Column(name="COLUMN_NAME")
	String columnName;
	
	@Column(name="SIZE")
	String size;
	
	@Column(name="CMT")
	String comment;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}  )
    @JoinColumn(name = "domain_id", referencedColumnName = "domain_id")
	DataDomainDictionary dataDomain;
	
	@Builder
	public TermDictionary(			
			String term,
			String termEng,
			String definition,
			String status,
			List<String> system,
			String columnName,
			String size,
			DataDomainDictionary dataDomain,					
			String comment
			) {		
		
		this.term = term;		
		this.termEng = termEng;
		this.definition = definition;
		this.status = status;
		this.system = system;
		this.columnName = columnName;
		this.size = size;
		this.dataDomain = dataDomain; 			
		this.comment = comment;
	}	
		
	public void modifyEntity(
			String termEng,			
			String definition,
			String status,
			List<String> system,
			String columnName,
			String size,
			DataDomainDictionary dataDomain,					
			String comment
			) {			
		this.termEng = termEng;
		this.definition = definition;
		this.status = status;
		this.system = system;
		this.columnName = columnName;
		this.size = size;
		this.dataDomain = dataDomain; 			
		this.comment = comment;
	}
	
}
