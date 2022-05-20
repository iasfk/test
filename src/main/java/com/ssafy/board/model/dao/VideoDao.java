package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Video;

public interface VideoDao {
	List<Video> getLikeListByUserID(int userid);
	boolean deleteLikeVideo(int id);
	boolean addLikeVideo(Video video);
}
