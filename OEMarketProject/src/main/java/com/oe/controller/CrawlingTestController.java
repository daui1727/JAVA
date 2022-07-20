package com.oe.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oe.domain.DGVO;
import com.oe.service.MarketBoardService;

import lombok.extern.log4j.Log4j;

@Controller
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@WebAppConfiguration
@Log4j
@RequestMapping("/board/*")
public class CrawlingTestController {
	
	@Autowired
	private MarketBoardService service;
				
	@GetMapping("/boardList")
	public String list(DGVO vo, Model model, RedirectAttributes rttr) {
		log.info("boardList------------------");
		
		try {
			
			int k = 1;
			//당근
			Document doc = Jsoup.connect("https://www.daangn.com/hot_articles").get();
			//제목
			Elements title = doc.select("article.card-top a.card-link div.card-desc h2.card-title");
			//가격
            Elements price=doc.select("article.card-top a.card-link div.card-desc h2.card-price");
            //주소
            Elements address=doc.select("article.card-top a.card-link div.card-desc h2.card-region-name");
            //하트
            Elements heart=doc.select("article.card-top a.card-link div.card-desc h2.card-counts span");
            //그림
            Elements poster=doc.select("article.card-top a.card-link div.card-photo img");
            //상세페이지 링크
            Elements link=doc.select("article.card-top a.card-link");

            for(int j=0;j<poster.size();j++)
            {
               try{
            	   Document doc2=Jsoup.connect("https://www.daangn.com/"+link.get(j).attr("href")).get();
            	   
                   Elements content=doc2.select("section#article-description div#article-detail p");
                   System.out.println("내용:"+content.text());
                   System.out.println("=========================================================");
                   
                   vo = new DGVO();
                   vo.setNo(k);
                   vo.setTitle(title.get(j).text());
                   vo.setPrice(j);
                   vo.setAddress(address.get(j).text());
                   vo.setHeart(j);
                   String image = poster.get(j).attr("src");
                   vo.setPoster(image);
                   vo.setContent(content.get(j).text());
                   
                   k++;
                   
               }catch(Exception e){
            	   e.printStackTrace();
               }
            }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		service.register(vo);
		rttr.addFlashAttribute("result", vo);
		
		model.addAttribute("list", service.getList());
		
		return "redirect:/board/boardList";
		
	}
	
}
