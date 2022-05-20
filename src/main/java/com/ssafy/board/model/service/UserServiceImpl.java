package com.ssafy.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.exception.PWIncorrectException;
import com.ssafy.board.exception.UserNotFoundException;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.User;
import com.ssafy.board.util.SHA256;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private BoardDao boardDao;
	
	@Transactional
	@Override
	public void join(User user) throws Exception {
		// TODO Auto-generated method stub
		user.setPw( new SHA256().getHash(user.getPw()) );
		userDao.insertUser(user);
	}

	@Override
	public User login(String userId, String pw) throws Exception {
		// TODO Auto-generated method stub
		//id로 select해와서
		User user = userDao.selectByUserId(userId);
		if( user == null )
			throw new UserNotFoundException();
		if( !user.getPw().equals( new SHA256().getHash(pw) ) )
			throw new PWIncorrectException();
		else
			return user;
	}
}
