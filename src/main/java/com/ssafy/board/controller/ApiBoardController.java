package com.ssafy.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;

@RestController
@RequestMapping("/api")
public class ApiBoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public ResponseEntity<List<Board>> list(
			@RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword) {
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("key", keyword); //아까 mapper에서 key라고...해놨어서..
		return new ResponseEntity<List<Board>>(
				boardService.getBoardList(params), HttpStatus.OK
		);
	}
}






