package com.ssafy.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Board {
	private int id;
	private String writer;
	private String title;
	private String content;
	private int viewCnt;
	private String regDate;
	
}
