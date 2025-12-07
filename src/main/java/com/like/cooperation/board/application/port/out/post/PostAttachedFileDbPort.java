package com.like.cooperation.board.application.port.out.post;

import java.util.List;
import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.cooperation.board.domain.post.PostAttachedFile;

@SecondaryPort
public interface PostAttachedFileDbPort {
	
	Optional<PostAttachedFile> select(Long postFileId);
	
	void save(List<PostAttachedFile> files);
	
	void delete(Long postFileId);
	
	void deleteAll(Long postId);
	
	void deleteNotMatched(List<PostAttachedFile> files);
	
	
}
