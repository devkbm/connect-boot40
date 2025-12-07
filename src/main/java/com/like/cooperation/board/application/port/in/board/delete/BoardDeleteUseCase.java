package com.like.cooperation.board.application.port.in.board.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BoardDeleteUseCase {
	void delete(Long id);
}
