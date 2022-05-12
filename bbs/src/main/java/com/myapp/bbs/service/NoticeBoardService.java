package com.myapp.bbs.service;

import java.util.List;



import com.myapp.bbs.model.Criteria;
import com.myapp.bbs.model.NoticeBoardVO;

public interface NoticeBoardService {
	
	/* 게시판 등록 */
    public void enroll(NoticeBoardVO noticeboard);

	/* 게시판 목록 */
	public List<NoticeBoardVO> getList();
	
    /* 게시판 목록(페이징 적용) */
    public List<NoticeBoardVO> getListPaging(Criteria cri);

	 /* 게시판 조회 */
    public NoticeBoardVO getPage(int nobno);

    /* 게시판 수정 */
    public int modify(NoticeBoardVO noticeboard);

    /* 게시판 삭제 */
    public int delete(int nobno);
    
    /* 게시판 총 개수 */
    public int getTotal(Criteria cri);
    
    /* 조회수 기능 */
	public int updateViewCount(int nobno);


}
