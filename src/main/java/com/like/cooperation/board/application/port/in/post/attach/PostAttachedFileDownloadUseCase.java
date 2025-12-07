package com.like.cooperation.board.application.port.in.post.attach;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface PostAttachedFileDownloadUseCase {

	PostAttachedFileDownloadDTO download(Long postFileId);
}
