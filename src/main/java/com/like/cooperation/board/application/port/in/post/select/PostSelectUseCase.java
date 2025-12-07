package com.like.cooperation.board.application.port.in.post.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface PostSelectUseCase {
	PostSelectDTO select(String readerUserId, Long postId);	
}
