package com.example.ex01.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ex01.dao.ISimpleBbsDao;
import com.example.ex01.domain.SimpleBbsDto;

@Controller
public class MyController {
	
	@Autowired
	private ISimpleBbsDao dao;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Hi~ Ex~~";
	}
	
	@GetMapping("/main")
	public String mainPage() {
		return "main";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		model.addAttribute("list", dao.getList());
		
		return "list";
	}
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@PostMapping("/write")
	public String write(HttpServletRequest request, String writer, String title, String content) {
		String swriter = request.getParameter("writer");
		String stitle = request.getParameter("title");
		String scontent = request.getParameter("content");
		//파라미터 받아서 db에 등록하기
		dao.write2(swriter, stitle, scontent);
		
		return "redirect:list";
	}
	
	@PostMapping("/write2")
	public String write2(@RequestParam("writer") String writer, @RequestParam("title") String title, @RequestParam("content") String content) {
		//String swriter = request.getParameter("writer");
		//String stitle = request.getParameter("title");
		//String scontent = request.getParameter("content");
		//파라미터 받아서 db에 등록하기
		dao.write2(writer, title, content);
		
		return "redirect:list";
	}
	
	@PostMapping("/write3")
	public String write3(SimpleBbsDto dto) {
		//String swriter = request.getParameter("writer");
		//String stitle = request.getParameter("title");
		//String scontent = request.getParameter("content");
		//파라미터 받아서 db에 등록하기
		dao.write5(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/command")//model을 생략하는 장점 (클래스 이름의 앞글자를 소문자로 쓰고 나머지는 표기법 지키면서사용)
	public String command(SimpleBbsDto dto) {
		
		System.out.println(dto.getTitle());
		
		return "command";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") String id, Model model) {
		
		model.addAttribute("dto", dao.getDto(id));
		
		return "detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") String id) {
		
		dao.delete(id);
		
		return "redirect:list";
	}
	
	
	
	
	
}
