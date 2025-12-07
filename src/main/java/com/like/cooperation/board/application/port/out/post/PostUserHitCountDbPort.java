package com.like.cooperation.board.application.port.out.post;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.cooperation.board.domain.post.Post;

@SecondaryPort
public interface PostUserHitCountDbPort {
	void plusHitCount(Post article, String userId);
}
