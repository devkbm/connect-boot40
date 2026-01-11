package com.like.cooperation.board.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.application.port.in.board.query.BoardHierarchyQueryResultDTO;
import com.like.cooperation.board.domain.board.QBoard;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class BoardTreeQuerydsl {

	private JPAQueryFactory queryFactory;
	private final QBoard qBoard = QBoard.board;
	
	BoardTreeQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<BoardHierarchyQueryResultDTO> selectHierarchy() {
		List<BoardHierarchyQueryResultDTO> rootList = getBoardHierarchyRootList();
		
		List<BoardHierarchyQueryResultDTO> rtn =  setLinkBoardHierarchy(rootList);
		
		return rtn;
	}
	
	List<BoardHierarchyQueryResultDTO> setLinkBoardHierarchy(List<BoardHierarchyQueryResultDTO> list) {
		List<BoardHierarchyQueryResultDTO> children = null;
		
		for ( BoardHierarchyQueryResultDTO dto : list) {
			
			children = getBoardHierarchyChildrenList(Long.parseLong(dto.getKey()));
			
			if (children.isEmpty()) {	// leaf 노드이면 다음 리스트 검색
				dto.setLeaf(true);
				continue;
			} else {
				
				dto.setChildren(children);
				dto.setLeaf(false);
				
				setLinkBoardHierarchy(children);
			}
		}
		
		return list;
	}
	
	
	List<BoardHierarchyQueryResultDTO> getBoardHierarchyRootList() {									
						
		//Expression<String> boardParentId = new CaseBuilder().when(qBoard.parent.boardId.isNull()).then("").otherwise(qBoard.parent.boardId.stringValue()).as("boardParentId");			
		
		JPAQuery<BoardHierarchyQueryResultDTO> query = queryFactory
				//.select(projections(qBoard))
				.select(Projections.fields(BoardHierarchyQueryResultDTO.class,
						qBoard.boardId.stringValue().as("key"),
						qBoard.parent.boardId.stringValue().as("boardParentId"),						
						qBoard.boardType,
						qBoard.boardName.as("title"),
						qBoard.description.as("boardDescription"),
						Expressions.FALSE.as("expanded"),
						Expressions.FALSE.as("selected"),
						Expressions.FALSE.as("active")
						)
				)
				.from(qBoard)
				.where(qBoard.isRootNode());
																			
		return query.fetch();	
	}
	
	List<BoardHierarchyQueryResultDTO> getBoardHierarchyChildrenList(Long boardParentId) {
		
		JPAQuery<BoardHierarchyQueryResultDTO> query = queryFactory
				//.select(projections(qBoard))
				.select(Projections.fields(BoardHierarchyQueryResultDTO.class,
						qBoard.boardId.stringValue().as("key"),
						qBoard.parent.boardId.stringValue().as("boardParentId"),						
						qBoard.boardType,
						qBoard.boardName.as("title"),
						qBoard.description.as("boardDescription"),
						Expressions.FALSE.as("expanded"),
						Expressions.FALSE.as("selected"),
						Expressions.FALSE.as("active")
						)
				)
				.from(qBoard)
				.where(qBoard.parent.boardId.eq(boardParentId));								
		
		return query.fetch();	
	}
	
}
