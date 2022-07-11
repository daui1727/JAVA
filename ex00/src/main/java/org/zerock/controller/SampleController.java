package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping(value="sample", method = RequestMethod.GET)  // "" 부분에 쓰는 글자를 리턴하는. home을 찾아가는 부분처럼 동작한다.
	public String basic() {
		log.info("basic--------------");
		return "sample";
	}
	
	@RequestMapping(value="sample", method = RequestMethod.POST)
	public String basic2() {
		log.info("basic2--------------");
		return "sample";
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basicGet2()--------------");
	}
	
	@GetMapping("/ex00")
	public String ex00(SampleDTO dto, Model model) {
		log.info("dto -------------- : " + dto);
		model.addAttribute("model",model);
		return "ex00";
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("dto -------------- : " + dto);
		return "sample/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(SampleDTO dto, @ModelAttribute("page")int page) {
		log.info(dto);
		log.info(page);
		return "ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(@ModelAttribute("SD") SampleDTO dto, @ModelAttribute("page")int page) {
		log.info(dto);
		log.info(page);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public @ResponseBody SampleDTO ex04() {
		log.info("ex04 -------------- ");
		SampleDTO dto = new SampleDTO();
		dto.setName("홍길동");
		dto.setAge(50);
		return dto;
	}
	
	

}
