package com.like.cooperation.board.adapter.out.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.mybatis.PostQueryH2;
import com.like.cooperation.board.adapter.out.db.mybatis.PostQueryOracle;
import com.like.cooperation.board.application.port.in.post.query.PostQueryResultDTO;
import com.like.cooperation.board.application.port.in.post.query.PostQueryDTO;
import com.like.cooperation.board.application.port.out.post.PostQueryBySliceDbPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SecondaryAdapter
@Repository
public class PostQueryBySliceDbAdapter implements PostQueryBySliceDbPort {	
	
	@Value("${mybatis.configuration.database-id}")
	String databaseId;
	
	PostQueryH2 h2;	
	PostQueryOracle oracle;

	PostQueryBySliceDbAdapter(
			PostQueryH2 h2,
			PostQueryOracle oracle
			) {
		this.h2 = h2;
		this.oracle = oracle;
	}
		
	@Override
	public Slice<PostQueryResultDTO> getPostSlice(String userId, PostQueryDTO dto, Pageable pageable) {
		log.info(databaseId);		
		
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("data", dto);
		//params.put("pageable", pageable );
		params.put("pagenumber",  pageable.getPageNumber() );
		params.put("pagesize", pageable.getPageSize() );
		
		List<PostQueryResultDTO> contents = Collections.emptyList();
		
		if (databaseId == "h2") {
			h2.getPostSlice(params);			
		} else {
			oracle.getPostSlice(params);
		}		
		
		// 마지막 데이터인지 여부를 확인하기 위해 +1개를 조회한후 데이터 제거
		boolean hasNext = false;
		if (contents.size() > pageable.getPageSize()) {
			contents.remove(pageable.getPageSize());
			hasNext = true;
		}
		
		return new SliceImpl<>(contents, pageable, hasNext);
	}
	
	
}
