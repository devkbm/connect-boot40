package com.like.cooperation.board.application.port.in.board.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BoardSelectUseCase {
	BoardSelectDTO select(Long boardId);
}
