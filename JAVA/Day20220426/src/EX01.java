import lombok.Data;

public class EX01 {

	public static void main(String[] args) {

		Student2 s = new Student2("홍길동", 1, 10, 90, 100, 60);  // 생성자 호출  >> 디폴트생성자
		
		System.out.println(s.getName());
		System.out.println(s.getTotal());
		
		Student2 s2 = new Student2("황건적", 2, 9, 80, 90, 70);  // 생성자 호출  >> 디폴트생성자
		
		System.out.println(s2.getName());
		System.out.println(s2.getTotal());
		
		Student2 s3 = new Student2("하암수", 3, 9);  // 생성자 호출  >> 디폴트생성자
		
		System.out.println(s3.getName());
		System.out.println(s3.getTotal());
		
	}

}

@Data
class Student2{

	private String name;
	private int ban, no, kor, eng, math;
	
	// 함수 오버로딩
	public Student2(String name, int ban, int no, int kor, int eng, int math) {
		System.out.println("생성자 호출");
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	// 함수 오버로딩
	public Student2(String name, int ban, int no) {
		System.out.println("s3 생성자 호출");
		this.name = name;
		this.ban = ban;
		this.no = no;
	}
	
	int getTotal() {
		int sum = kor+eng+math;
		return sum;
	}
}