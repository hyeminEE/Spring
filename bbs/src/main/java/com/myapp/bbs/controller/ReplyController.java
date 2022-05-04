package com.myapp.bbs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.bbs.model.ReplyVO;
import com.myapp.bbs.service.ReplyService;

import lombok.Getter;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	// ReplyService객체를 가지고 와야하기 때문에 생성자 주입
	private ReplyService replyService;
	
	// 생성자 객체 주입시에는 @Autowired가 필요없음
	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	@PostMapping
	public ReplyVO replyEnrollPOST(@RequestBody ReplyVO reply) {
		// 입력 된 json 타입 데이터를 받아서 reply객체를 리턴(json타입으로)
		replyService.enroll(reply);	// DB에 저장
		return reply;	// json 타입
	}
	
	@GetMapping("/{bno}") // 게시글에 달린 댓글들을 불러옴
	public List<ReplyVO> replyListGET(@PathVariable int bno) {
		return replyService.getReplyList(bno);	//bno를 넣으면 그 bno에 해당하는 댓글들 List<ReplyVo>를 불러온다
		
	}
	
	@PutMapping
	public ReplyVO replyUpdatePUT(@RequestBody ReplyVO reply) {
		replyService.modify(reply);	// DB에 댓글 데이터가 수정됨 
		return reply;				// 테스트로 reply 리턴
		
	}
	
	@DeleteMapping("/{id}")
	public void replyDELETE(@PathVariable("id") int reply_no) {
		replyService.delete(reply_no);
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
