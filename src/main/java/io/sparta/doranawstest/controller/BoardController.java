package io.sparta.doranawstest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.sparta.doranawstest.controller.dto.BoardResponse;
import io.sparta.doranawstest.controller.dto.CreateBoardRequest;
import io.sparta.doranawstest.service.BoardService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/board")
@RestController
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;

	@PostMapping
	public ResponseEntity<Void> create(
		@RequestBody CreateBoardRequest createBoardRequest
	) {
		boardService.create(
			createBoardRequest.getTitle(), createBoardRequest.getContent()
		);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<BoardResponse> getBoardById(@PathVariable("id") Long id) {
		BoardResponse boardResponse = boardService.getBoardById(id);

		return ResponseEntity.ok(boardResponse);
	}
}
