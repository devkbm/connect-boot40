package com.like.cooperation.board.domain.post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.cooperation.board.domain.board.Board;
import com.like.core.jpa.domain.AbstractAuditEntity;

import io.hypersistence.utils.hibernate.id.Tsid;

/**
 * <p>게시글 클래스</p>
 * 
 * [상세내용] <br>
 *   1. <br>
 * [제약조건] <br>
 *   1. <br>
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Table(name = "GRWPOST")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Post extends AbstractAuditEntity {		

	/**
	 * 게시글 키
	 */
	@Id	
	@Tsid
	@Column(name="POST_ID")
	Long postId;	
			
	@Column(name="POST_P_ID", comment="게시글 부모ID")
	Long postParentId;		
			
	@Column(name="USER_ID")
	String userId;
	
	@Embedded
	PostContents content;
	
	@Embedded
	PostPassword password;
		       	
	@Column(name="DEPTH_LEVEL", comment="계층 레벨")
    int depth;
		
	@Column(name="HIT_CNT", comment="조회 수")
    int hitCount;	
	
	@Column(name="TOP_FIXED_YN")
	boolean isFixedTop;
		    
	/**
	 * 게시판 외래키
	 */           
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOARD_ID", nullable=false, updatable=false)
	Board board;
    	                              
    @OneToMany(mappedBy = "post")
    List<PostAttachedFile> files;
			    			
	@Transient
	Boolean editable;
	
	public Post(
			String appUrl,
			String userId,
			Board board,		    
		    PostContents content
		    ) {
		
		if (board == null) throw new IllegalArgumentException("게시판이 존재하지 않습니다.");
		
		this.createdAppUrl(appUrl);
		this.userId = userId;
		this.board = board;
		this.content = content;
	}
	
	public Post(
			String appUrl,
			Board board,
		    String userId,
		    PostContents content,
		    PostPassword password,
			List<PostAttachedFile> files
			) {
		
		if (board == null) throw new IllegalArgumentException("게시판이 존재하지 않습니다.");
		
		this.createdAppUrl(appUrl);
		this.board = board;
		this.content = content;
		this.password = password;
		this.files = files;				
	}
	
	public void modify(String appUrl, PostContents content, boolean isFiexedTop) {
		this.createdAppUrl(appUrl);
		this.content = content;				
		this.isFixedTop = isFiexedTop;
	}
	
	public Long getId() {
		return this.postId;
	}
				
	public void setBoard(Board board) {
		this.board = board;
		
		if (!board.getArticles().contains(this)) {
			board.getArticles().add(this);
		}
	}
	
	public boolean hasParentArticle() {		
		return this.postParentId != this.postId ? true : false;
	}
						
	public void updateHitCnt() {
		this.hitCount = this.hitCount + 1;	
	}	
		
	public List<PostAttachedFile> getAttachedFileInfoList() {
		if (this.files == null) this.files = new ArrayList<>();
		
		return this.files;				  		 					 
	}
	
	public List<String> getFileIds() {
		if (this.files == null) return Collections.emptyList();
		
		return this.files.stream().map(e -> e.getFileInfo().toString()).toList();
	}
	
	public void setFiles(List<PostAttachedFile> files) {
		this.files = files;
	}	
	
	public void clearFiles() {
		this.files = new ArrayList<>();
	}
			
}