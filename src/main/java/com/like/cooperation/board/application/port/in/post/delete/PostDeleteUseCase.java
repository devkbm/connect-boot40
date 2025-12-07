package com.like.cooperation.board.application.port.in.post.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface PostDeleteUseCase {
	void delete(Long id);
}
