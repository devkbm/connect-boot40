package com.like.system.user.adapter.out.db;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;

import com.like.system.user.adapter.out.db.mybatis.SystemUserMapper;
import com.like.system.user.application.port.in.query.SystemUserQueryDTO;
import com.like.system.user.application.port.in.query.SystemUserQueryResultDTO;
import com.like.system.user.application.port.out.SystemUserQueryDbPort;

@SecondaryAdapter
@Repository
public class SystemUserQueryDbAdapter implements SystemUserQueryDbPort {

	SystemUserMapper mapper;
		
	SystemUserQueryDbAdapter(SystemUserMapper mapper) {		
		this.mapper = mapper;
	}

	@Override
	public List<SystemUserQueryResultDTO> selectList(SystemUserQueryDTO dto) {
		return this.mapper.selectList(dto);		
	}
		
}
