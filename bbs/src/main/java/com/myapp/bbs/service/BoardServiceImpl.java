package com.myapp.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.bbs.dao.BoardMapper;
import com.myapp.bbs.model.BoardVO;
import com.myapp.bbs.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	
	private BoardMapper boardMapper;
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	// 게시글 등록
	@Override
	public void enroll(BoardVO board) {
		boardMapper.enroll(board);
		
	}
	
	// 게시글 목록
	@Override
	public List<BoardVO> getList() {
		return boardMapper.getList();
	}

	// 게시글 조회
	@Override
	public BoardVO getPage(int bno) {
		return boardMapper.getPage(bno);
	}
	
	// 게시글 조회수 카운트
	@Override
	public int updateViewCount(int bno) {
		return boardMapper.updateViewCount(bno);
	}
	
	// 게시글 수정
	@Override
	public int modify(BoardVO board) {
		return boardMapper.modify(board);
	}

	// 게시글 삭제
	@Override
	public int delete(int bno) {
		return boardMapper.delete(bno);
	}

	// 페이지네이션 게시글 목록
	@Override
	public List<BoardVO> getListPaging(Criteria cri) {
		return boardMapper.getListPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return boardMapper.getTotal(cri);
	}





}
