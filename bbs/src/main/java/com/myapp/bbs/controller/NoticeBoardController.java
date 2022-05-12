package com.myapp.bbs.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myapp.bbs.model.BoardVO;
import com.myapp.bbs.model.Criteria;
import com.myapp.bbs.model.NoticeBoardVO;
import com.myapp.bbs.model.PageMakerDTO;
import com.myapp.bbs.service.BoardService;
import com.myapp.bbs.service.NoticeBoardService;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/noticeboard")
@Log		// 콘솔의 로그 출력 (print out 대신 사용)
public class NoticeBoardController {
	
	private NoticeBoardService noticeBoardService;	// 생성자 주입
	
	public NoticeBoardController(NoticeBoardService noticeBoardService) {
		this.noticeBoardService = noticeBoardService;
	}
	
	@GetMapping("/enroll")
	public String noticeboardEnrollGet(Model model) {
		model.addAttribute("noticeboard", new NoticeBoardVO());
		return "/notice/enroll";
	}
	
	@PostMapping("/enroll")
	public String noticeboardEnrollPost(NoticeBoardVO noticeboard, RedirectAttributes attr) {
		// log.info("FreeBoardVO : " + freeboard);
		noticeBoardService.enroll(noticeboard);		// DB에 저장
		attr.addFlashAttribute("message", "게시물 등록 성공");
		return "redirect:/noticeboard/list";	// post 다음에 redirect하기
	}
	
//	@GetMapping("/list")
//	public String boardListGET(Model model) {
//		model.addAttribute("boardList", boardService.getList());	//43번줄 redirect를 해서 46번줄 list로 넘어오면 DB에 있는 모든 list를 가지고 와서 
//		return "list";												// 48번줄 boardList에 담아 model에 전달
//	}
	
    /* 게시판 목록 페이지 접속(페이징 적용) */
	@GetMapping("/list")
	public String boardListGET(Criteria cri, Model model) {// requestParam 어노테이션이 있으면 i값이 무조ㅓ건 넘어와야됨 ,없으면 i값이 없어도 됨
		// boardList에 페이징처리 된 게시글을 전달
		model.addAttribute("noticeboardList", noticeBoardService.getListPaging(cri));	
		
		int total = noticeBoardService.getTotal(cri);
		PageMakerDTO pmk = new PageMakerDTO(total, cri); //객체 생성시 모든 변수가 계산됨
		
		model.addAttribute("pmk", pmk); // 페이지네이션을 위한 pmk객체 전달
		
		return "/notice/list";												
	}
	
	// 게시글 조회
	@GetMapping("/get")
	public String noticeboardPageGET(@RequestParam("nobno") int nobno, Model model, Criteria cri) {
		model.addAttribute("noticeboard", noticeBoardService.getPage(nobno));
		noticeBoardService.updateViewCount(nobno);
		model.addAttribute("cri", cri); 
		return "/notice/get";
	}
	
	// 게시글 수정
	@GetMapping("/modify")
	public String boardModifyGET(@RequestParam("nobno") int nobno, Model model, Criteria cri) {
		model.addAttribute("noticeboard", noticeBoardService.getPage(nobno));
		model.addAttribute("cri", cri); 
		return "/notice/modify";
	}
	
	// 게시글 수정
	@PostMapping("/modify")
	public String boardModifyPOST(NoticeBoardVO noticeboard, RedirectAttributes attr) {
		log.info(""+noticeboard);
		noticeBoardService.modify(noticeboard);	//modify페이지에서 수정된 내용을 업데이트 함
		attr.addFlashAttribute("message", "수정 성공!");	
		return "redirect:/noticeboard/list";	//post - redirect - get
	}
	
	// 게시글 삭제
	@GetMapping("/delete")
	public String boardDeleteGet(@RequestParam("nobno") int nobno, RedirectAttributes attr) {
		noticeBoardService.delete(nobno);
		attr.addFlashAttribute("message", "삭제 성공!");
		return "redirect:/noticeboard/list";
	}
}

















