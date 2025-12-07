package com.like.cooperation.board.application.port.in.board.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BoardSaveUseCase {
	void save(BoardSaveDTO dto);
}
