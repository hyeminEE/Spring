package com.myapp.bbs.service;

public interface FreeLikeService {

	public void updateLike(int bno);
	
	public void updateLikeCancel(int bno);
	
	public void insertLike(int bno, String id);
	
	public void deleteLike(int bno, String id);
	
	public int likeCheck(int bno, String id);
	
	public void updateLikeCheck(int bno, String id);
	
	public void updateLikeCheckCancel(int bno, String id);

}

