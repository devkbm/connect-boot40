package com.like.system.menu_role.domain.menu_role;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.core.jpa.domain.AbstractAuditEntity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

@Entity
@Table(name = "commenurole")
@EntityListeners(AuditingEntityListener.class)
public class MenuRoleMapping extends AbstractAuditEntity {

	@EmbeddedId
	MenuRoleMappingId id;
			
	public MenuRoleMapping(MenuRoleMappingId id) {
		this.id = id;
	}
	
	protected MenuRoleMapping() {}

	public MenuRoleMappingId id() {
		return id;
	}
	
}
