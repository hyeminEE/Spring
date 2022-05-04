package com.myapp.bbs.model;

import java.time.LocalDateTime;


import lombok.Data;

// 공지사항 게시판!!

@Data  //@Data는 @Getter, @Setter, @ToString 이 3가지를 다 포함하고 있어서 @Data만 사용하면 된다
public class NoticeBoardVO {

	/* 게시판 번호 */
	private int nobno;
	
	/* 게시판 제목 */
	private String title;
	
	/* 게시글 작성자 */
	private String writer;

	/* 게시판 내용 */
	private String content;		
	
	/* 등록 날짜 */
	private LocalDateTime regdate;			// timestamp에서 날짜,시간을 가져오는 java 날짜,시간 데이터
	
	/* 수정 날짜 */
	private LocalDateTime updateDate;
	
	/* 게시글 조회 기능 */
	private int hit;
	

}
