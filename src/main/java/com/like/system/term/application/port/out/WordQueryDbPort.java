package com.like.system.term.application.port.out;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.term.domain.WordDictionary;

@SecondaryPort
public interface WordQueryDbPort {
	List<WordDictionary> select();
}
