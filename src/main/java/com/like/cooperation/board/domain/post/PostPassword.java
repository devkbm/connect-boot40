package com.like.cooperation.board.domain.post;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
public class PostPassword {
	
	@Column(name="PWD", comment="비밀번호")
    String password;
	
	public PostPassword(String password) {
		this.password = password;		
	}
}
