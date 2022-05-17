package com.ssafy.board.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("list")
	public String list() {
		return "board/list";
	}

	@GetMapping("writeForm")
	public String writeForm() {
		return "board/writeform";// 파일명은 소문자네요
	}

	@PostMapping("write")
	public String write(Board board) {
		boardService.writeBoard(board);
		return "redirect:/board/list";
	}

	@GetMapping("detail")
	public String detail(Model model, int id) {
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		return "board/detail";
	}

	@GetMapping("updateForm")
	public String updateForm(Model model, int id) {
		Board board = boardService.getBoardById(id);
		model.addAttribute("board", board);
		return "board/updateform";
	}

	@GetMapping("delete")
	public String delete(int id) {
		boardService.deleteBoard(id);
		return "redirect:/board/list";
	}

	@PostMapping("update")
	public String update(Board board) {
		boardService.modifyBoard(board);
		return "redirect:/board/detail?id=" + board.getId();
	}
}
