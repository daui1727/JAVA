package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	/*
	@RequestMapping("/basic")
	public String basic() {
		log.info("basic ----------------- ");
		return "test";
	}
	*/
	
	@GetMapping("/basic")
	public String basic(SampleVO vo, Model model) {
		log.info("basic ----------------- ");
		log.info("vo ==> " + vo);
		model.addAttribute("list", vo);
		return "sample/basic";
	}
	
	
	
	
	
}
