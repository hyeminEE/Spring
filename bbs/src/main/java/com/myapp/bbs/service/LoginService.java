package com.myapp.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.bbs.dao.UserMapper;
import com.myapp.bbs.model.Login;
import com.myapp.bbs.model.User;

@Service
public class LoginService {

	@Autowired
	private UserMapper userMapper;
	
	public void authenticate(Login login) {
		// id로 검색해서 유저 찾기
		User user = userMapper.selectById(login.getId());
		
		if(user == null) {
			login.setError("아이디가 존재하지 않습니다.");
		}else {
			if(!user.getPassword().equals(login.getPassword())) {
				login.setError("패스워드가 틀립니다.");
			}else {
				login.setError(null); 	// 에러없음(인증됨)
			}
		}
	}
	
	/* 유저 찾기 메소드 : 아이디로 유저 찾기 */
	public User findUserById(String id) {
		User user = userMapper.selectById(id);
		return user;
	}
	
}
























