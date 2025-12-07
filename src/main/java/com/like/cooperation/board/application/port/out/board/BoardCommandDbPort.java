package com.like.cooperation.board.application.port.out.board;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.cooperation.board.domain.board.Board;

@SecondaryPort
public interface BoardCommandDbPort {
	boolean exists(Long id);
	
	Optional<Board> select(Long id);
	
	void save(Board entity);
	
	void delete(Long id);
}
