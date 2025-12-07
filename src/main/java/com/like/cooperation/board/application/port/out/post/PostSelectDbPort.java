package com.like.cooperation.board.application.port.out.post;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.cooperation.board.application.port.in.post.select.PostSelectDTO;

@SecondaryPort
public interface PostSelectDbPort {

	PostSelectDTO get(String readerUserId, Long articleId);
}
