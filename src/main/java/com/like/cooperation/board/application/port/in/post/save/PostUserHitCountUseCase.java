package com.like.cooperation.board.application.port.in.post.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface PostUserHitCountUseCase {

	void plusHitCount(Long postId, String userId);
}
