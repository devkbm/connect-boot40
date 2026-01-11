package com.like.cooperation.board.application.port.out.board;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.cooperation.board.application.port.in.board.query.BoardHierarchyQueryResultDTO;
import com.like.cooperation.board.application.port.in.board.query.BoardQueryDTO;
import com.like.cooperation.board.application.port.in.board.query.BoardQueryResultDTO;

@SecondaryPort
public interface BoardQueryDbPort {
	
	List<BoardQueryResultDTO> selectList(BoardQueryDTO dto);
	
	List<BoardHierarchyQueryResultDTO> selectHierarchy();
}
