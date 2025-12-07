package com.like.cooperation.board.application.port.in.board.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BoardQueryUseCase {	
	
	List<BoardQueryResultDTO> selectList(BoardQueryDTO dto);
	
	List<BoardHierarchy> selectHierarchy();
}
