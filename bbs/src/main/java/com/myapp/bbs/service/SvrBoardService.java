package com.myapp.bbs.service;

import java.util.List;


import com.myapp.bbs.model.BoardVO;
import com.myapp.bbs.model.Criteria;
import com.myapp.bbs.model.SvrBoardVO;

public interface SvrBoardService {
	
	/* 게시판 등록 */
    public void enroll(SvrBoardVO svrboard);

	/* 게시판 목록 */
	public List<SvrBoardVO> getList();
	
    /* 게시판 목록(페이징 적용) */
    public List<SvrBoardVO> getListPaging(Criteria cri);

	 /* 게시판 조회 */
    public SvrBoardVO getPage(int svbno);

    /* 게시판 수정 */
    public int modify(SvrBoardVO svrboard);

    /* 게시판 삭제 */
    public int delete(int svbno);
    
    /* 게시판 총 개수 */
    public int getTotal(Criteria cri);
    
    /* 조회수 기능 */
	public int updateViewCount(int svbno);

}
