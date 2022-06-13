import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Exercise6_4_1 {

	public static void main(String[] args) {
		
		int num=10;
		
		Student s = new Student();
		

		s.getAverage();
		

		/*------------------------------------------------*/
		
		String name = s.getName();   // 변수에는 이런 식으로 접근해야한다
		s.setName("홍길동");
		int kor = s.getKor();
		System.out.println(s.getKor());
		s.setKor(90);
		
		int ban = s.getBan();
		System.out.println("반 : " + s.getBan());
		s.setBan(1);
		
		
		
	}

}

// private < default < protected < public
@Getter  // 어노테이션
@Setter
@ToString
class Student{
	//변수>> 인스턴스변수, 클래스변수, 지역변수
	
	private String name;
	private int ban, no, kor, eng, math;
	
//	// getter*****
//	String getName() {  
//		return name;
//	}
//	
//	// setter*****
//	void setName(String name) {
//		this.name = name;
//	}
//	
//	int getKor() {
//		return kor;
//	}
//	
//	void setKor(int kor) {
//		this.kor = kor;
//	}
//	
//	int getBan() {
//		return ban;
//	}
//	
//	void setBan(int ban) {
//		this.ban = ban;
//	}
	
	//함수 --> 인스턴스메소드, 클래스메소드
	int getTotal() {
		int sum = kor+eng+math;
		return sum;
	}
	
	double getAverage() {
		return getTotal()/3.0;
	}
	
	/*---------------------------------------------------------------*/
}