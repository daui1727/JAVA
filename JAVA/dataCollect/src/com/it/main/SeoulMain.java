package com.it.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.it.dao.*;
public class SeoulMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SeoulMain sm=new SeoulMain();
//        sm.seoulAttractions();
//        sm.seoulNature();
//        sm.seoulHotel();
        
          sm.seoulShopping();
	}
	
    private void seoulShopping() {
    	// ?? DataDAO의 싱글톤 객체 생성을 통해 메모리 공간을 1개만 생성. + DB에 크롤링 데이터 저장.
    	// 최초 한번의 new 연산자를 통해 고정된 메모리 영역을 사용하기 때문에 추후 해당 객체에 접근할때 메모리 낭비를 방지하거나 
        // 이미 생성된 인스턴스를 활용하기 때문에 속도 측면에서도 이점이 있다.
        // DBCP(DataBase Connection Pool)처럼 공통된 객체를 여러개 생성해서 사용해야하는 상황에서 많이 사용.
    	DataDAO dao = new DataDAO();
    	try {
    		int k=1;
    		for(int i = 1; i <= 20; i++) {
    			//  jsoup은 자바(Java)로 만들어진 HTML 파서(Parser)
    			Document doc = Jsoup.connect("https://korean.visitseoul.net/shopping?curPage="+i).get();
    			Elements poster = doc.select("ul.article-list li.item div.thumb");
    			Elements comment = doc.select("ul.article-list li.item div.infor-element span.text-dot-d");
    			Elements link = doc.select("ul.article-list li.item a");
    			Elements title = doc.select("ul.article-list li.item div.infor-element span.title");
    			
    			for(int j = 0; j < poster.size(); j++) {
    				try {
    					// 번호, 이름, 포스터의 스타일, 코멘트, 주소
    					System.out.println("번호:" + k);
    					System.out.println(title.get(j).text());
    					System.out.println(poster.get(j).attr("style"));
    					System.out.println(comment.get(j).text());
    					System.out.println(link.get(j).attr("href"));
    					Document doc2=Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();
    					// :eq(n) 해당 n번째 요소에 스타일이나 동작이 적용됩니다. 요소 선택시 사용
    					Element address = doc2.select("div.detail-map-infor:eq(1) dl dd").get(0);
    					System.out.println("주소:"+address.text());
    					System.out.println("=========================================================");
    					
    					SeoulShoppingVO vo = new SeoulShoppingVO();
    					// 번호, 이름, 주소, 포스터의 스타일, 코멘트
    					vo.setNo(k);
    					vo.setTitle(title.get(j).text());
    					vo.setMsg(comment.get(j).text());
    					String image = poster.get(j).attr("style");
    					// substring() --> 문자열에서 특정 부분만 골라낼때 사용하는 메서드 substring(시작, 끝) 지정.
    					image = image.substring(image.indexOf("(")+1, image.lastIndexOf(")"));
    					// ex) https://korean.visitseoul.net/comm/getImage?srvcId=POST&parentSn=11965&fileTy=POSTTHUMB&fileNo=1&thumbTy=M
    					image="https://korean.visitseoul.net"+image;
    					vo.setPoster(image);
    					vo.setAddress(address.text());
    					
    					
    					dao.seoulShoppingInsert(vo);
    					k++;
    					
    				}catch(Exception ex) {}
    			}
    		}
    	}catch(Exception ex) {}
    	
	} // end seoulShopping

	public void seoulAttractions()
	{
		DataDAO dao=new DataDAO();
		try
		{
			int k=1;
			for(int i=1;i<=35;i++)
			{
			   Document doc=Jsoup.connect("https://korean.visitseoul.net/attractions?curPage="+i).get();
			   Elements poster=doc.select("ul.article-list li.item div.thumb");
			   Elements comment=doc.select("ul.article-list li.item div.infor-element span.text-dot-d");
			   Elements link=doc.select("ul.article-list li.item a");
			   Elements title=doc.select("ul.article-list li.item div.infor-element span.title");
			   for(int j=0;j<poster.size();j++)
			   {
				   try{
					   System.out.println("번호:"+k);
					   System.out.println(title.get(j).text());
					   System.out.println(poster.get(j).attr("style"));
					   System.out.println(comment.get(j).text());
					   System.out.println(link.get(j).attr("href"));
					   Document doc2=Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();
					   Element address=doc2.select("div.detail-map-infor:eq(1) dl dd").get(0);
					   System.out.println("주소:"+address.text());
					   System.out.println("=========================================================");
				       
					   SeoulLocationVO vo=new SeoulLocationVO();
					   vo.setNo(k);
					   vo.setTitle(title.get(j).text());
					   vo.setMsg(comment.get(j).text());
					   String image=poster.get(j).attr("style");
					   image=image.substring(image.indexOf("(")+1,image.lastIndexOf(")"));
					   // style="background-image:url(/comm/getImage?srvcId=POST&amp;parentSn=5548&amp;fileTy=POSTTHUMB&amp;fileNo=1&amp;thumbTy=M)"
					   image="https://korean.visitseoul.net"+image;
					   vo.setPoster(image);
					   vo.setAddress(address.text());
					   dao.seoulLocationInsert(vo);
					   k++;
				   }catch(Exception ex) {}
			   }
			}
		}catch(Exception ex){}
	}
	
	public void seoulHotel()
	{
		DataDAO dao=new DataDAO();
		try
		{
			int k=1;
			for(int i=1;i<=33;i++)
			{
			   Document doc=Jsoup.connect("https://korean.visitseoul.net/hotels?curPage="+i).get();
			   Elements poster=doc.select("ul.article-list li.item div.thumb img");
			   Elements link=doc.select("ul.article-list li.item a");
			   Elements title=doc.select("ul.article-list li.item div.infor-element span.title");
			   Elements score=doc.select("div.infor-element-inner span.trip-ico img");
			   for(int j=0;j<poster.size();j++)
			   {
				   try {
						   System.out.println("번호:"+k);
						   System.out.println(title.get(j).text());
						   System.out.println(poster.get(j).attr("src"));
						   System.out.println(link.get(j).attr("href"));
						   System.out.println("score-alt" + score.get(j).attr("alt"));
						   Document doc2=Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();
						   Element address=doc2.select("div.detail-map-infor dl dd").get(0);
						   Elements images=doc2.select("div.wide-slide div.item");
						   String simg="";
						   for(int m=0;m<images.size();m++)
						   {
							   System.out.println(images.get(m).attr("style"));
							   String temp=images.get(m).attr("style");
							   // background-image:url(http://media-cdn.tripadvisor.com/media/photo-s/10/f5/38/a8/twin-rom--v17512289.jpg)"
							   // http://media-cdn.tripadvisor.com/media/photo-s/10/f5/38/a8/twin-rom--v17512289.jpg
							   temp=temp.substring(temp.indexOf("(")+1,temp.lastIndexOf(")"));
							   simg+=temp+"^";
						   }
						   simg=simg.substring(0,simg.lastIndexOf("^"));
						   System.out.println("주소:"+address.text());
						   
						   System.out.println("=========================================================");
					       SeoulHotelVO vo=new SeoulHotelVO();
					       vo.setNo(k);
					       vo.setName(title.get(j).text());
					       vo.setAddress(address.text());
					       vo.setPoster(poster.get(j).attr("src"));
					       String s=score.get(j).attr("alt");
					       // alt=""  평점:4.5
					       s=s.substring(s.indexOf(":")+1);
//					       vo.setScore(Double.parseDouble(s.trim()));
					       vo.setScore(0.0);
					       vo.setImages(simg);
					       dao.seoulHotelInsert(vo);
						   k++;
				   }catch(Exception ex) {
					   ex.printStackTrace();
				   }
			   }
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/*
	 *  NO      NOT NULL NUMBER         
		TITLE   NOT NULL VARCHAR2(200)  
		POSTER  NOT NULL VARCHAR2(300)  
		MSG     NOT NULL VARCHAR2(4000) 
		ADDRESS NOT NULL VARCHAR2(300)
	 */
	public void seoulNature()
	{
		DataDAO dao=new DataDAO();
		try
		{
			int k=1;
			for(int i=1;i<=14;i++)
			{
			   Document doc=Jsoup.connect("https://korean.visitseoul.net/nature?curPage="+i).get();
			   
			   Elements poster=doc.select("ul.article-list li.item div.thumb");
			   Elements comment=doc.select("ul.article-list li.item div.infor-element span.text-dot-d");
			   Elements link=doc.select("ul.article-list li.item a");
			   Elements title=doc.select("ul.article-list li.item div.infor-element span.title");
			   for(int j=0;j<poster.size();j++)
			   {
				  try
				  {
				   System.out.println("번호:"+k);
				   System.out.println(title.get(j).text());
				   System.out.println(poster.get(j).attr("style"));
				   System.out.println(comment.get(j).text());
				   System.out.println(link.get(j).attr("href"));
				   Document doc2=Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();
				   /*
				    *   <div class="detail-map-infor"> :eq(0)
				    *     <dl>
				    *     </dl>
				    *   </div>
				    *   <div class="detail-map-infor"> :eq(1)
				    *     <dl>
				    *     </dl>
				    *   </div>
				    *   <div class="detail-map-infor"> :eq(2)
				    *     <dl>
				    *     </dl>
				    *   </div>
				    */
				   Element address=doc2.select("div.detail-map-infor:eq(1) dl dd").get(0);
				   System.out.println("주소:"+address.text());
				   System.out.println("=========================================================");
			       SeoulNatureVO vo=new SeoulNatureVO();
			       vo.setNo(k);
			       vo.setTitle(title.get(j).text());
			       vo.setAddress(address.text());
			       vo.setMsg(comment.get(j).text());
			       String s=poster.get(j).attr("style");
			       s=s.substring(s.indexOf("(")+1,s.lastIndexOf(")"));
			       s="https://korean.visitseoul.net"+s;
			       vo.setPoster(s);
			       dao.seoulNatureInsert(vo);
				   k++;
				  }catch(Exception ex) {}
			   }
			}
		}catch(Exception ex){}
	}

}
