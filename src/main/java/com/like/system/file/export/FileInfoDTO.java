package com.like.system.file.export;

import com.like.system.file.domain.FileInfo;

import lombok.Builder;

@Builder
public record FileInfoDTO(
		String fildId,
		String appUrl,
		String userId,
		String contentType,
		String uuid,
		String path,
		String fileName,
		long size,
		long downloadCount
		) {

	public static FileInfoDTO toDTO(FileInfo entity) {
		return FileInfoDTO
				.builder()
				.fildId(entity.id().toString())
				.appUrl(entity.appUrl())
				.userId(entity.userId())
				.contentType(entity.contentType())
				.uuid(entity.uuid())
				.path(entity.path())
				.fileName(entity.fileName())
				.size(entity.size())
				.downloadCount(entity.downloadCount())
				.build();
	}
}
