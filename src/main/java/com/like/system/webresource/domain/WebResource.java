package com.like.system.webresource.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.core.jpa.domain.AbstractAuditEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "comresource")
@EntityListeners(AuditingEntityListener.class)
public class WebResource extends AbstractAuditEntity implements Serializable{	
	
	private static final long serialVersionUID = 4402275274864737663L;

	@Id	
	@Column(name="RESOURCE_ID", comment="리소스ID")
	String id;
		
	@Column(name="RESOURCE_NAME", comment="리소스명")
	String name; 
			
	@Column(name="RESOURCE_TYPE", comment="리소스분류")
	String type; 
		
	@Column(name="URL")
	String url;
		
	@Column(name="DESCRIPTION", comment="설명")
	String description;	
		
	@Builder
	public WebResource(			
			String resourceId,
			String resourceName,
			String resourceType,
			String url,
			String description
			) {				
		this.id = resourceId;
		this.name = resourceName;
		this.type = resourceType;
		this.url = url;
		this.description = description;
	}	
		
	@Builder(builderMethodName = "modifyBuilder", buildMethodName = "modify")
	public void modify(			
			String resourceName,
			String resourceType,
			String url,
			String description
			) {		
		this.name = resourceName;
		this.type = resourceType;
		this.url = url;
		this.description = description;
	}
		
}
