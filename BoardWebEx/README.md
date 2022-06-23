BoardWebEx

스프링 예제 다시 연습하기

*********순서

**1. Spring Legacy Project 선택 - Spring MVC Project 선택 - BoardWebEx 생성

**2. 폴더의 properties에서 java 11로 변경 tomcat 선택 apply

**3. src-webapp- web-inf - 아래 spring과 view 폴더 삭제

**4. pom.xml 수정

1.8 / 5.2.7 / 1.8 / 1.8

<!-- AspectJ -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.9.1</version>
    <scope>runtime</scope>
</dependency>

<!-- Logging -->
<dependency>
	<groupId>log4j</groupId>
	<artifactId>log4j</artifactId>
	<version>1.2.15</version>
	<exclusions>
		<exclusion>
			<groupId>javax.mail</groupId>
			<artifactId>mail</artifactId>
		</exclusion>
		<exclusion>
			<groupId>javax.jms</groupId>
			<artifactId>jms</artifactId>
		</exclusion>
		<exclusion>
			<groupId>com.sun.jdmk</groupId>
			<artifactId>jmxtools</artifactId>
		</exclusion>
		<exclusion>
			<groupId>com.sun.jmx</groupId>
			<artifactId>jmxri</artifactId>
		</exclusion>
	</exclusions>
	<scope>runtime</scope>
</dependency>

위 부분 삭제 시 아래 부분 추가

<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
<dependency>
	<groupId>org.apache.logging.log4j</groupId>
	<artifactId>log4j-core</artifactId>
	<version>2.17.2</version>
</dependency>

dependency 끝나기 전에 아래도 추가

<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
    <scope>provided</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <version>2.1.214</version>
</dependency>

**5. polymorphismEx 패키지 내에 SamsungTV , LgTV 클래스 생성 - 두 tv클래스를 번갈아 사용할 TVUser 메인 클래스 작성
---> : 메소드 시그니처가 다르므로 TVUser 코드 대부분을 사용해야 tv를 교체할 수 있다. 유지보수 힘듬

**6. 다형성을 이용하여 수정해보자. 공통으로 가져야할 메서드를 넣은 TV 인터페이스를 생성 후 각 tv클래스에 implements TVUser 클래스도 수정하면
---> : 묵시적 형변환을 이용하여 TVUser 클래스의 SamsungTV와 LgTV 만 바꿔주면 교체가 가능하다. 유지보수 보다 편안

**7. 디자인 패턴 이용하기. BeanFactory 클래스 생성

public Object getBean(String beanName) {
	if(beanName.equals("samsung")) {
		return new SamsungTV();
	}else if(beanName.equals("lg")){
		return new LgTV();
	}
	return null;
}
 
이후 BeanFactory 클래스를 이용하여 사용할 TV객체를 획득하도록 TVUser 클래스 수정
BeanFactory factory = new BeanFactory();
TV tv = (TV) factory.getBean(args[0]);

RUN Arguments 탭에서 lg 혹은 samsung을 입력하고 run하면 소스 수정 없이 tv를 변경할 수 있다.

// 2장까지.

**8. src/main/resources 폴더 내에 Spring Bean Configuration - applicationContext.xml 생성. 
대부분 IoC 컨테이너는 각 컨테이너에서 관리할 객체들을 위한 별도의 설정 파일이 있다.

클래스 하나 당 하나의 <bean> 설정이 필요하다. <bean id="tv" class="polymorphismEx.SamsungTV"/> 추가

**9. TVUser 클래스에 TV객체를 테스트하는 클라이언트를 만들어보자.

// 1. Spring 컨테이너를 구동한다. 
AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

**10. 구동된 컨테이너로부터 SamsungTV 객체를 먼저 얻어보자. SamsungTV에 기본 생성자 추가
public SamsungTV() {
	System.out.println("===> SamsungTV 객체 생성");
}

**11. 스프링 컨테이너(xml파일)을 구동하고 이름이 tv인 객체를 getBean()메서드를 이용하여 요청하도록 TVUser를 수정한다.

// 2. Spring 컨테이너로부터 필요한 객체를 요청(LookUp)한다.
TV tv = (TV) factory.getBean("tv");
tv.powerOn();
tv.volumeUp();
tv.volumeDown();
tv.powerOff();

// 3. Spring 컨테이너를 종료한다.
factory.close();

--> : TV를 LgTV로 변경할때 xml 파일만 수정하면 된다.

///// <bean>의 각 속성 알아보기
**12. init-method 속성 : 객체 초기화 작업 처리..

 SamsungTV 클래스에 initMethod 메서드 작성
<bean id="tv" class="polymorphismEx.SamsungTV" init-method="initMethod"/>

**13. destroy-method 속성 - 객체 삭제 전에 처리할 로직 처리..

<bean id="tv" class="polymorphismEx.SamsungTV" init-method="initMethod" destroy-method="destroyMethod"/>
SamsungTV 클래스에 destroyMethod 메서드 작성 

**14. lazy-init 속성 - 컨테이너가 구동되는 시점이 아닌 해당 <bean>이 사용되는 시점에 객체를 생성하도록.

<bean id="tv" class="polymorphismEx.SamsungTV" init-method="initMethod" destroy-method="destroyMethod" lazy-init="true"/>

**15. scope 속성 - 스프링 컨테이너가 생성한 bean을 어느 범위에서 사용할 수 있는 지 지정. 기본 - 싱글톤
scope="prototype"

/// 3장까지

// 4장 의존성 주입
IoC란 Inversion of Control의 줄임말이며, 제어의 역전이라고 한다.
스프링 애플리케이션에서는 오브젝트(빈)의 생성과 의존 관계 설정, 사용, 제거 등의 작업을 애플리케이션 코드 대신 스프링 컨테이너가 담당한다.
이를 스프링 컨테이너가 코드 대신 오브젝트에 대한 제어권을 갖고 있다고 해서 IoC라고 부른다.
따라서, 스프링 컨테이너를 IoC 컨테이너라고도 부른다.

Inversion of Control - Dependency LookUp , Dependency Injection(Setter Injection, Constructor Injection)

**16. 스프링 프레임워크의 가장 중요한 특징은 객체의 생성과 의존관계를 컨테이너가 자동으로 관리한다는 점.


































