package com.like.cooperation.board.application.port.out.post;

import java.util.List;
import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.cooperation.board.domain.post.Post;

@SecondaryPort
public interface PostCommandDbPort {
	Optional<Post> select(Long id);
	
	void save(Post entity);	
	
	void save(List<Post> entities);
	
	void delete(Long id);
}
