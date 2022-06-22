package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

//		TV tv = factory.getBean("tv", SamsungTV.class);
		TV tv1 = (TV)factory.getBean("samsungTV");
// 		컴포넌트 아이디("samsung" 같은)를 지정하지 않으면 SamsungTV 클래스 이름을 앞글자 소문자로 하여
// 		사용할 수 있다. ex) lg의 경우 lgTV
		
		
		tv1.powerOn();
		tv1.volumeUp();
		tv1.volumeDown();
		tv1.powerOff();
		
		factory.close();
	}

}
