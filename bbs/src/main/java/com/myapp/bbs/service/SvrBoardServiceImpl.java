package com.myapp.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.bbs.dao.BoardMapper;
import com.myapp.bbs.dao.SvrBoardMapper;
import com.myapp.bbs.model.BoardVO;
import com.myapp.bbs.model.Criteria;
import com.myapp.bbs.model.SvrBoardVO;

@Service
public class SvrBoardServiceImpl implements SvrBoardService {

	
	private SvrBoardMapper svrboardMapper;
	
	public SvrBoardServiceImpl(SvrBoardMapper svrboardMapper) {
		this.svrboardMapper = svrboardMapper;
	}

	// 게시글 등록
	@Override
	public void enroll(SvrBoardVO svrboard) {
		svrboardMapper.enroll(svrboard);
		
	}
	
	// 게시글 목록
	@Override
	public List<SvrBoardVO> getList() {
		return svrboardMapper.getList();
	}

	// 게시글 조회
	@Override
	public SvrBoardVO getPage(int svbno) {
		return svrboardMapper.getPage(svbno);
	}
	
	// 게시글 조회수 카운트
	@Override
	public int updateViewCount(int svbno) {
		return svrboardMapper.updateViewCount(svbno);
	}
	
	// 게시글 수정
	@Override
	public int modify(SvrBoardVO svrboard) {
		return svrboardMapper.modify(svrboard);
	}

	// 게시글 삭제
	@Override
	public int delete(int svbno) {
		return svrboardMapper.delete(svbno);
	}

	// 페이지네이션 게시글 목록
	@Override
	public List<SvrBoardVO> getListPaging(Criteria cri) {
		return svrboardMapper.getListPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return svrboardMapper.getTotal(cri);
	}





}
