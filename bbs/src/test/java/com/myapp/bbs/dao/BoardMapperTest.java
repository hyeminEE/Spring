package com.myapp.bbs.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

import com.myapp.bbs.model.BoardVO;
import com.myapp.bbs.model.Criteria;

import lombok.extern.java.Log;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // 테스트를 할때 연결되어 있는 DB로 테스트
@Rollback(value = false)						   // 테스트 할 때 롤백 하지 않음
@Log
public class BoardMapperTest {
	// JUNIT 5버전으로 테스트
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void test() {
//		BoardVO vo = new BoardVO();
//		
//		vo.setTitle("제목테스트");
//		vo.setContent("내용테스트");
//		vo.setWriter("글쓴이");
//		
//		boardMapper.enroll(vo);
////		
//		List<BoardVO> list = boardMapper.getList();
		// 반복문을 사용하여 테스트
		/* for문 반복문 */
//		for(int i=0; i < list.size(); i++) {
//			log.info("" + list.get(i));
//		}
//		
		/* for each 반복문*/
//		for(BoardVO vo : list) {
//			log.info("" + vo);
//		}
//		
		/* for each 메소드와 람다식 */
//		list.forEach(board -> log.info(""+board));
	
		/* 게시판 조회*/
//		int bno = 1;
//		log.info(""+boardMapper.getPage(bno));
		
		/* 게시판 수정*/
//		BoardVO board = new BoardVO();
//		board.setBno(1);
//		board.setTitle("수정된 제목");
//		board.setContent("수정된 게시글 내용");
//		
//		int result = boardMapper.modify(board);
//			log.info("결과: "+result);

		/* 게시판 삭제*/
//		int result = boardMapper.delete(1);
//		log.info("결과: " +result);
//		
	
		/* 페이징 리스트*/
//		Criteria cri = new Criteria(); // 기본생성자 생성(1,10)(pageNum, amount)
//		
//		cri.setPageNum(2); // 2페이지 출력 
//		cri.setAmount(5);	// 한 페이지에 5개만 출력
//		
//		List<BoardVO> list = boardMapper.getListPaging(cri);
//		
//		list.forEach(board -> log.info(""+board));
		
		/* 총 게시물 숫자 */
		
//		int result = boardMapper.getTotal();
//		log.info("결과 : " +result);
	}
}
