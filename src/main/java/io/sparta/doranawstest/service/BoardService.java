package io.sparta.doranawstest.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.sparta.doranawstest.controller.dto.BoardResponse;
import io.sparta.doranawstest.domain.Board;
import io.sparta.doranawstest.domain.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;

	@Transactional
	public void create(String title, String content) {
		Board board = new Board(title, content);
		boardRepository.save(board);
	}

	@Cacheable(cacheNames = "board", key = "#id")
	public BoardResponse getBoardById(Long id) {
		Board board = boardRepository.findById(id).orElseThrow();

		return new BoardResponse(
			board.getId(),
			board.getTitle(),
			board.getContent()
		);
	}
}
