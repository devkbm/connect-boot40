package com.like.cooperation.board.application.port.in.post.query;

import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

@PrimaryPort
public interface PostQueryBySliceUseCase {
	
	Slice<PostQueryResultDTO> getAritlceSlice(String userId, PostQueryDTO dto, Pageable pageable);
}
