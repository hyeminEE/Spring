package com.myapp.bbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Login {
	
	private String id;
	private String email;
	private String password;
	private String error;	// 오류 메세지를 저장하는 문자열
}
