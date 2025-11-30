package com.like.system.term.adapter.out.db;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;

import com.like.system.term.adapter.out.db.data.WordDictionaryJpaRepository;
import com.like.system.term.application.port.out.WordCommandDbPort;
import com.like.system.term.domain.WordDictionary;

@SecondaryAdapter
@Repository
public class WordDbAdapter implements WordCommandDbPort {

	WordDictionaryJpaRepository repository;
	
	WordDbAdapter(WordDictionaryJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public WordDictionary select(String id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public void save(WordDictionary entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(String id) {
		this.repository.deleteById(id);		
	}

}
