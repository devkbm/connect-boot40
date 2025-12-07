package com.like.cooperation.board.adapter.out.db.querydsl;

import static org.springframework.util.StringUtils.hasText;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.application.port.in.board.query.BoardQueryDTO;
import com.like.cooperation.board.application.port.in.board.query.BoardQueryResultDTO;
import com.like.cooperation.board.domain.board.BoardType;
import com.like.cooperation.board.domain.board.QBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class BoardListQuerydsl {

	private JPAQueryFactory queryFactory;
	private final QBoard qBoard = QBoard.board;
	
	BoardListQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<BoardQueryResultDTO> selectList(BoardQueryDTO dto) {
 		
		return queryFactory				
				.select(Projections.fields(BoardQueryResultDTO.class,
						qBoard.modifiedAppUrl.as("clientAppUrl"),
						qBoard.boardId,
						qBoard.parent.boardId.as("boardParentId"),
						qBoard.boardType.as("boardType"),
						qBoard.boardName,
						qBoard.description.as("boardDescription"),
						qBoard.useYn						
					)
				)
				.from(qBoard)
				.where(getBooleanBuilder(dto))
				.fetch();				
	}
	
	public BooleanBuilder getBooleanBuilder(BoardQueryDTO dto) {							
		return new BooleanBuilder() 
				.and(likeBoardName(dto.boardName()))
				.and(equalBoardType(dto.boardType()));
	}
	
	private BooleanExpression likeBoardName(String boardName) {
		return hasText(boardName) ? qBoard.boardName.like("%"+boardName+"%") : null;					
	}
	
	private BooleanExpression equalBoardType(String boardType) {
		return hasText(boardType) ? qBoard.boardType.eq(BoardType.valueOf(boardType)) : null;			
	}
}
