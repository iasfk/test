package com.ssafy.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.VideoDao;
import com.ssafy.board.model.dto.Video;

@Service("videoService")
public class VideoServicelmpl implements VideoService {

	@Autowired
	private VideoDao videoDao;
		
	@Override
	public boolean addLikeVideo(Video video) {
		return videoDao.addLikeVideo(video) == true;
	}
	@Override
	public boolean deleteLikeVideo(int id) {
		// TODO Auto-generated method stub
		return videoDao.deleteLikeVideo(id) == true;
	}
	

	
	
}
