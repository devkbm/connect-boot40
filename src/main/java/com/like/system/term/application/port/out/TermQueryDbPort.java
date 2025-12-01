package com.like.system.term.application.port.out;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.term.application.port.in.term.TermQueryDTO;
import com.like.system.term.domain.TermDictionary;

@SecondaryPort
public interface TermQueryDbPort {
	List<TermDictionary> select(TermQueryDTO dto);
}
