package com.myapp.bbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data				// get,set,toString을 자동으로 생성하는 어노테이션
@AllArgsConstructor	// 모든 필드변수로 생성자 생성 
public class User {
	
	private String id;
	private String password;
	private String name;
	private String userName;
	private String email;


	

}
