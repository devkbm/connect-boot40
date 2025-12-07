package com.like.cooperation.board.application.port.in.post.upload;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface PostExcelUploadUseCase {

	void upload(List<PostExcelUploadDTO> dto, String userId);
}
