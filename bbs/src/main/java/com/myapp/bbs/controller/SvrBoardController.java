package com.myapp.bbs.controller;

import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myapp.bbs.model.Criteria;
import com.myapp.bbs.model.PageMakerDTO;
import com.myapp.bbs.model.SvrBoardVO;
import com.myapp.bbs.service.SvrBoardService;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/svrboard")
@Log		// 콘솔의 로그 출력 (print out 대신 사용)
public class SvrBoardController {
	
	private SvrBoardService svrboardService;	// 생성자 주입
	
	public SvrBoardController(SvrBoardService svrboardService) {
		this.svrboardService = svrboardService;
	}
	
	@GetMapping("/enroll")
	public String boardEnrollGet(Model model) {
		model.addAttribute("svrboard", new SvrBoardVO());
		return "/server/enroll";
	}
	
	@PostMapping("/enroll")
	public String boardEnrollPost(SvrBoardVO svrboard,RedirectAttributes attr) {
		// log.info("FreeBoardVO : " + freeboard);
		svrboardService.enroll(svrboard);		// DB에 저장
		attr.addFlashAttribute("message", "게시물 등록 성공");
		return "redirect:/svrboard/list";	// post 다음에 redirect하기
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
		model.addAttribute("svrboardList", svrboardService.getListPaging(cri));	
		
		int total = svrboardService.getTotal(cri);
		PageMakerDTO pmk = new PageMakerDTO(total, cri); //객체 생성시 모든 변수가 계산됨
		
		model.addAttribute("pmk", pmk); // 페이지네이션을 위한 pmk객체 전달
		
		return "/server/list";												
	}
	
	// 게시글 조회
	@GetMapping("/get")
	public String boardPageGET(@RequestParam("svbno") int svbno, Model model, Criteria cri) {

		model.addAttribute("svrboard", svrboardService.getPage(svbno));
		svrboardService.updateViewCount(svbno);
		model.addAttribute("cri", cri); 
		return "/server/get";
	}
	
	// 게시글 수정
	@GetMapping("/modify")
	public String boardModifyGET(@RequestParam("svbno") int svbno, Model model, Criteria cri) {
		model.addAttribute("svrboard", svrboardService.getPage(svbno));
		model.addAttribute("cri", cri); 
		return "/server/modify";
	}
	
	// 게시글 수정
	@PostMapping("/modify")
	public String boardModifyPOST(SvrBoardVO svrboard, RedirectAttributes attr) {
		log.info(""+svrboard);
		svrboardService.modify(svrboard);	//modify페이지에서 수정된 내용을 업데이트 함
		attr.addFlashAttribute("message", "수정 성공!");	
		return "redirect:/svrboard/list";	//post - redirect - get
	}
	
	// 게시글 삭제
	@GetMapping("/delete")
	public String boardDeleteGet(@RequestParam("svbno") int svbno, RedirectAttributes attr) {
		svrboardService.delete(svbno);
		attr.addFlashAttribute("message", "삭제 성공!");
		return "redirect:/svrboard/list";
	}
}

















