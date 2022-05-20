package com.ssafy.board.model.service;

import com.ssafy.board.model.dto.Video;

public interface VideoService {
	boolean addLikeVideo(Video video);
	boolean deleteLikeVideo(int id);
}
