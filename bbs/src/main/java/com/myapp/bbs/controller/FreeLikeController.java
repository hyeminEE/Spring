package com.myapp.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.bbs.dao.FreeLikeMapper;

@Controller
public class FreeLikeController {
	
	private FreeLikeMapper freelikeMapper;
	
	@ResponseBody
	@RequestMapping(value = "/board/updateLike", method = RequestMethod.POST)
	public int updateLike(@RequestParam(value = "bno", defaultValue = "0") int bno, String id, String writer) {
		
		System.out.println(bno);
		System.out.println(id);
		System.out.println(writer);

		
		int likeCheck = freelikeMapper.likeCheck(bno, id);
		if(likeCheck == 0) {
			// 좋아요 처음 눌렀을 경우
			freelikeMapper.insertLike(bno, id); // like테이블에 삽입
			freelikeMapper.updateLike(bno);	// 게시판 테이블 +1
			freelikeMapper.updateLikeCheck(bno, id);	// like 테이블 구분자 1
		} else if(likeCheck == 1) {
			freelikeMapper.updateLikeCheckCancel(bno, id);	//like테이블 구분자 0
			freelikeMapper.updateLikeCancel(bno);	//게시판 테이블 -1
			freelikeMapper.deleteLike(bno, id);	// like테이블 삭제

		}
		
		return likeCheck; 
		
	}

}
