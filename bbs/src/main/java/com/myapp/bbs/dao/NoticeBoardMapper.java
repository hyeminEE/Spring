package com.myapp.bbs.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.myapp.bbs.model.Criteria;
import com.myapp.bbs.model.NoticeBoardVO;

@Mapper
public interface NoticeBoardMapper {
	
	/* 공지사게시판 등록*/
	public void enroll(NoticeBoardVO noticeboard);
	
	/* 게시판 목록 */
	public List<NoticeBoardVO> getList();
	
	/* 게시판 목록(페이징 적용) */
	public List<NoticeBoardVO> getListPaging(Criteria cri);	// pageNum, amount를 입력받아 객체 cri 생성, 없으면 기본(1,10)이 입력 됨, keyword도 추가
	
	/* 게시판 조회 */
	public NoticeBoardVO getPage(int nobno);
	
	/* 게시판 수정 */
	public int modify(NoticeBoardVO noticeboard);
	
	/* 게시판 삭제 */
	public int delete(int nobno);	
	
	/* 게시판 총 개수*/
	public int getTotal(Criteria cri); // 검색 페이지네이션을 적용하려면 여기에도cri를 추가
	
	/* 조회수 기능 */
	public int updateViewCount(int nobno);
}
