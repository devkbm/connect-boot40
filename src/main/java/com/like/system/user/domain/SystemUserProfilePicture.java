package com.like.system.user.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SystemUserProfilePicture implements Serializable {
	
	private static final long serialVersionUID = 42161337448472145L;

	@Column(name="FK_FILE")
	String image;
			
	protected SystemUserProfilePicture() {} 
		
	public String image() {
		return image;
	}

	public void setImagePath(String path) {
		this.image = path;
	}

	@Override
	public int hashCode() {
		return Objects.hash(image);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemUserProfilePicture other = (SystemUserProfilePicture) obj;
		return Objects.equals(image, other.image);
	}
			
}
