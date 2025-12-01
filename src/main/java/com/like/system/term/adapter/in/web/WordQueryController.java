package com.like.system.term.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.term.application.port.in.word.WordQueryUseCase;
import com.like.system.term.application.port.in.word.WordSaveDTO;

@PrimaryAdapter
@RestController
public class WordQueryController {

	WordQueryUseCase useCase;
	
	public WordQueryController(WordQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/system/word")
	public ResponseEntity<?> getWordList() {
		
		List<WordSaveDTO> dto = useCase.select();
		
		return toList(dto, MessageUtil.getQueryMessage(dto.size()));
	}			
		
	
					

	
}
