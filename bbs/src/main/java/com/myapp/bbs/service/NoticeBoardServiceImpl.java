package com.myapp.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.bbs.dao.BoardMapper;
import com.myapp.bbs.dao.NoticeBoardMapper;
import com.myapp.bbs.model.BoardVO;
import com.myapp.bbs.model.Criteria;
import com.myapp.bbs.model.NoticeBoardVO;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {

	
	private NoticeBoardMapper noticeBoardMapper;
	
	public NoticeBoardServiceImpl(NoticeBoardMapper noticeBoardMapper) {
		this.noticeBoardMapper = noticeBoardMapper;
	}

	// 게시글 등록
	@Override
	public void enroll(NoticeBoardVO noticeboard) {
		noticeBoardMapper.enroll(noticeboard);
		
	}

	// 게시글 목록
	@Override
	public List<NoticeBoardVO> getList() {
		return noticeBoardMapper.getList();
	}

	@Override
	public List<NoticeBoardVO> getListPaging(Criteria cri) {
		return noticeBoardMapper.getListPaging(cri);
	}

	@Override
	public NoticeBoardVO getPage(int nobno) {
		return noticeBoardMapper.getPage(nobno);
	}
	
	// 조회수 기능
		@Override
		public int updateViewCount(int nobno) {
			return noticeBoardMapper.updateViewCount(nobno);
		}

	@Override
	public int modify(NoticeBoardVO noticeboard) {
		return noticeBoardMapper.modify(noticeboard);
	}

	@Override
	public int delete(int nobno) {
		return noticeBoardMapper.delete(nobno);
	}

	@Override
	public int getTotal(Criteria cri) {
		return noticeBoardMapper.getTotal(cri);
	}

	

	



}
