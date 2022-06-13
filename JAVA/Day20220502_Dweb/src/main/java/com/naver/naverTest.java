package com.naver;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


// 웹페이지에서 선택한 해당 소스만 긁어오는 법. 

public class naverTest {

	public static void main(String[] args) throws IOException {   // 가져온 페이지가 달라지면 어쩔거냐..  예외처리.

		int pages = 10;
		for(int i = 1; i < pages; i++) {
		
			String url = "https://news.naver.com/main/list.naver?mode=LS2D&sid2=249&sid1=102&mid=shm&date=20220502&page=1" + i;
			
			Document doc = Jsoup.connect(url).get();   // Document도 jsoup로 같은 타입을 선택해야한다.
			
	//		System.out.println(doc);
			
			Elements elements = doc.getElementsByAttributeValue("class", "list_body newsflash_body");   // Elements도 타입을 맞춰야한다.
			
	//		System.out.println(elements.get(0));   // .get() 가져오다.
			
			Element element = elements.get(0);  // 단수 복수 구분인듯?
	//		System.out.println(element);
			Elements photoElements = element.getElementsByAttributeValue("class", "photo");  // 클래스 포토만 가져온다.
	//		System.out.println(photoElements);
			
			
			for(int j = 0; j < photoElements.size(); j++) {
				
				Element articleElement = photoElements.get(j);  // 단수 복수 구분하여 가져와서 변수에 넣고 출력.
	//			System.out.println(articleElement);
				Elements aElements = articleElement.select("a");    // a링크만 골라서 선택.
				Element aElement = aElements.get(0);
	//			System.out.println(aElements);
				
				String newsUrl = aElement.attr("href");   // 기사 링크만 긁어온다.
	//			System.out.println(newsUrl);
				
				Element imgElement = aElement.select("img").get(0);
				String imgUrl = imgElement.attr("src");
	//			System.out.println(imgUrl);
				
				String title = imgElement.attr("alt");
//				System.out.println(title);
				
				Document detailDoc = Jsoup.connect(newsUrl).get();
				Element contentElement= detailDoc.getElementById("dic_area");
				String content = contentElement.text();
				
				System.out.println(title);
				System.out.println(content);
				System.out.println();
			}
		
		}
		// end for i
		
	}

}
