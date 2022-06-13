import lombok.ToString;

public class EX03 {

	public static void main(String[] args) {

//		Student3 t = new Student3();
//		t.setName("홍길동");
//		t.setBan(1);
//		t.setNo(1);
//		t.setKor(100);
//		t.setEng(60);
//		t.setMath(76);
//		
//		System.out.println("이름 : " + t.getName());
//		System.out.println("총점 : " + t.getTotal());
//		System.out.println("평균 : " + t.getAverage());
		
		/*---------*/
		
		Student3 t1 = new Student3("홍길동", 2, 3, 70, 100, 80);
		
		System.out.println(t1.info());
		System.out.println(t1.toString());
	}

}
@ToString
class Student3{
	
	private String name;
	private int ban, no, kor, eng, math;
	
	
	int getTotal() {
		return kor+eng+math;
	}
	
	float getAverage() {
		return Math.round((getTotal()/3.0f)*10)*0.1f;
	}
	
	public Student3() {} // 디폴트 생성자는 반드시 기입
	
	public Student3(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;	
	}
	
	String info() {
		return name + " " + ban + " " + no + " " + kor + " " + eng + " " + math + " " + getTotal() + " " + getAverage();
	}
	
	
	/* get set 파트 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	
	
	
}