package com.like.system.user.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SystemUserId implements Serializable {

	private static final long serialVersionUID = -8544637739358675046L;
	
	@Column(name="USER_ID")
	String userId;	
	
	public SystemUserId(String userId) {		
		this.userId = userId;
	}
	
	protected SystemUserId() {}

	public String userId() {
		return userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemUserId other = (SystemUserId) obj;
		return Objects.equals(userId, other.userId);
	} 
			
}
