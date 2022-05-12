package com.myapp.bbs.service;

import com.myapp.bbs.dao.BoardMapper;
import com.myapp.bbs.dao.FreeLikeMapper;

public class FreeLikeServiceImpl implements FreeLikeService {

	private FreeLikeMapper freelikeMapper;
	
	@Override
	public void updateLike(int bno) {
		freelikeMapper.updateLike(bno);
		
	}

	@Override
	public void updateLikeCancel(int bno) {
		freelikeMapper.updateLikeCancel(bno);
		
	}

	@Override
	public void insertLike(int bno, String id) {
		freelikeMapper.insertLike(bno, id);
		
	}

	@Override
	public void deleteLike(int bno, String id) {
		freelikeMapper.deleteLike(bno, id);
		
	}

	@Override
	public int likeCheck(int bno, String id) {
		return freelikeMapper.likeCheck(bno, id);
	}

	@Override
	public void updateLikeCheck(int bno, String id) {
		freelikeMapper.updateLikeCheck(bno, id);
		
	}

	@Override
	public void updateLikeCheckCancel(int bno, String id) {
		freelikeMapper.updateLikeCancel(bno);
		
	}

}
