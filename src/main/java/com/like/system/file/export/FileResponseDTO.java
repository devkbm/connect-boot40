package com.like.system.file.export;

import com.like.system.file.adapter.out.file.FileServerRepository;
import com.like.system.file.domain.FileInfo;

public record FileResponseDTO(
		String uid,
		String name,
		Long size,
		String contentType,
		String status,
		String response,
		String url
		) {
	
	public static FileResponseDTO convert(FileInfo entity) {
		
		// url 예시 - http://localhost:8090/common/file/"+info.getPkFile()
		
		return new FileResponseDTO(entity.id().toString()
								  ,entity.fileName()
								  ,entity.size()
								  ,entity.contentType()
								  ,"done"
								  ,"success"
								  ,FileServerRepository.fileDownLoadUrl+entity.id().toString());
	}
	
	public static FileResponseDTO convert(FileInfoDTO info) {
		
		// url 예시 - http://localhost:8090/common/file/"+info.getPkFile()
		
		return new FileResponseDTO(info.fildId()
								  ,info.fileName()								  
								  ,info.size()
								  ,info.contentType()
								  ,"done"
								  ,"success"
								  ,FileServerRepository.fileDownLoadUrl+info.fildId());
	}
}
