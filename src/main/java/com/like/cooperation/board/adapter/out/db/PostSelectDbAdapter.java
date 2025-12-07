package com.like.cooperation.board.adapter.out.db;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.data.PostAttachedFileRepository;
import com.like.cooperation.board.adapter.out.db.querydsl.PostSelectQuerydsl;
import com.like.cooperation.board.application.port.in.post.select.PostSelectDTO;
import com.like.cooperation.board.application.port.out.post.PostSelectDbPort;
import com.like.cooperation.board.domain.post.PostAttachedFile;
import com.like.cooperation.board.domain.post.QPostAttachedFile;

@SecondaryAdapter
@Repository
public class PostSelectDbAdapter implements PostSelectDbPort {

	PostSelectQuerydsl repository;
	PostAttachedFileRepository fileRepository;
	
	private final QPostAttachedFile qArticleAttachedFile = QPostAttachedFile.postAttachedFile;
	
	PostSelectDbAdapter(
			PostSelectQuerydsl repository, 
			PostAttachedFileRepository fileRepository
			) {
		this.repository = repository;
		this.fileRepository = fileRepository;		
	}
	
	@Override
	public PostSelectDTO get(String readerUserId, Long articleId) {
		 PostSelectDTO dto = this.repository.get(readerUserId, articleId);
		 
		 List<PostAttachedFile> files = this.fileRepository.findAll(qArticleAttachedFile.post.postId.eq(articleId));
		 
		 if (!files.isEmpty()) {
			 dto.addFileList(files);
		 }
		 		 
		return dto;
	}

}
