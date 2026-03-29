package com.like.system.user.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SystemUserPassword implements Serializable {
	
	private static final long serialVersionUID = 5831655386795107265L;
	
	private static final String INIT_PASSWORD = "12345678";	
	public static String getInitPassword() {
		return INIT_PASSWORD;
	}
	
	@Column(name="pwd")
	String password;		
	
	protected SystemUserPassword() {}	
	
	void set(PasswordEncoder encoder, String rawPassword) {
		this.password = encoder.encode(rawPassword);
	}
	
	void change(PasswordEncoder encoder, String beforePassword, String afterPassword) {				
		if (encoder.matches(beforePassword, this.password)) {
			this.set(encoder, afterPassword);
		}
	}

	public String password() {
		return password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemUserPassword other = (SystemUserPassword) obj;
		return Objects.equals(password, other.password);
	}
	
	
	
	
			
}
