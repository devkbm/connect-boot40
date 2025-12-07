package com.like.cooperation.board.application.service.board;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.cooperation.board.application.port.in.board.save.BoardSaveDTO;
import com.like.cooperation.board.application.port.in.board.save.BoardSaveDTOMapper;
import com.like.cooperation.board.application.port.in.board.save.BoardSaveUseCase;
import com.like.cooperation.board.application.port.out.board.BoardCommandDbPort;
import com.like.cooperation.board.domain.board.Board;

@Application
@Service
public class BoardSaveService implements BoardSaveUseCase {

	BoardCommandDbPort dbPort;
	
	BoardSaveService(BoardCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(BoardSaveDTO dto) {
		Board entity = null;
		Board parentBoard = dto.boardParentId() == null ? null : getParentBoard(Long.parseLong(dto.boardParentId()));
				
		if (dto.boardId() == null) {
			entity = BoardSaveDTOMapper.toEntity(dto, parentBoard);
		} else {
			entity = this.dbPort.select(Long.parseLong(dto.boardId())).orElse(null);
			BoardSaveDTOMapper.modifyBoard(dto, entity, parentBoard); 
		}
		
		this.dbPort.save(entity);		
	}
	
	private Board getParentBoard(Long boardParentId) {
		return this.dbPort.select(boardParentId).orElse(null); 
	}

}
