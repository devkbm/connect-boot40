package com.like.cooperation.board.domain.board;

import java.util.*;

import jakarta.persistence.*;

import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.cooperation.board.domain.post.Post;
import com.like.core.jpa.domain.AbstractAuditEntity;

import io.hypersistence.utils.hibernate.id.Tsid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <p>게시판 클래스</p>
 * 
 * [상세내용] <br>
 *   1. <br>
 * [제약조건] <br>
 *   1. <br>
*/
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper=true, includeFieldNames=true)
@Entity
@Table(name = "GRWBOARD")
@EntityListeners(AuditingEntityListener.class)
public class Board extends AbstractAuditEntity {		
		
	@Id	
	@Tsid	
	@Column(name="BOARD_ID", comment="게시판 ID")
	Long boardId;
	    		
	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE}, optional = true)
	@JoinColumn(name="BOARD_P_ID", comment="상위게시판 ID")
	Board parent;
				
	//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	@Enumerated(EnumType.STRING)	
	@Column(name="BOARD_TYPE", comment="게시판_타입")
    BoardType boardType;
			
	@Column(name="BOARD_NAME", comment="게시판 명")
    String boardName;             
        	
	@Column(name="BOARD_DESC", comment="게시판_설명")
	String description;    	
	    			
	@Column(name="USE_YN", comment="사용여부")
	Boolean useYn;        		      		
			
	/**
	 * 게시글 리스트
	 */	
    @OneToMany(mappedBy = "board")          
    List<Post> articles;           
        
    /**
     * 즐겨찾기     
     */
    @OneToMany(mappedBy = "board") 
    @OrderBy("seq asc")
    Set<BoardBookmark> bookmarks;
    
	public Board(
			String appUrl,
			@Nullable Board parent,
			BoardType boardType,
			String boardName,
			String description
			) {
		this.createdAppUrl(appUrl);
		this.parent = parent;
		this.boardType = boardType;
		this.boardName = boardName;
		this.description = description; 
		this.useYn = true;		
	}
	
	public void modify(
			String appUrl,
			@Nullable Board parent,
		    BoardType boardType,
		    String boardName,
		    String description,						    
		    Boolean useYn,
		    long sequence) {
		this.createdAppUrl(appUrl);
		this.parent = parent;
		this.boardType = boardType;
		this.boardName = boardName;
		this.description = description;		
		this.useYn = useYn;			
	}
	               
	/*
	public void addArticle(ArticleContents content
					      ,ArticlePassword password
						  ,List<ArticleAttachedFile> files) {
		if (this.articles == null) this.articles = new ArrayList<>();
		
		this.articles.add(new Article(this, content, password, files));					
	}
	*/
	
	public void addBookmark(String userId) {
		if (this.bookmarks == null) this.bookmarks = new LinkedHashSet<>();
		
		this.bookmarks.add(new BoardBookmark(this, userId));
	}
		
	
}