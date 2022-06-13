package Crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import Crawling.EX01.Crawler;

public class EX01 {

	public static void main(String[] args) {

		/* 크롤링은 다양한 웹사이트의 페이지를 브라우징하는 작업을 말하고 원하는 데이터를 추출하는 것은 스크래핑이다.
		 * 크롤링 -> 스크래핑의 과정으로 진행된다. */
		
		
		
		
	}  // end main

	// Crawler 인터페이스
	public interface Crawler{
		public void crawling(String url);
	}
	
	// PuradakCrawler 클래스
	public class PuradakCrawler implements Crawler{
		
		public void crawling(String url) {
			// Document에는 페이지의 모든 소스가 들어간다
			Document doc = null;
			
			try {
				doc = Jsoup.connect(url).get();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}
}
