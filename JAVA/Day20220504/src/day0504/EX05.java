package day0504;

// 9장 9-1예제

public class EX05 {

	public static void main(String[] args) {

		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		if(v1.equals(v2)) {
			System.out.println("v1과 v2는 같습니다.");
		}else {
			System.out.println("v1과 v2는 다릅니다.");
		}
		
		v2 = v1;
		
		if(v1.equals(v2)) {
			System.out.println("v1과 v2는 같습니다.");
		}else {
			System.out.println("v1과 v2는 다릅니다.");
		}
		
	}

}

class Value{
	int value;
	
	Value(int value){
		this.value = value;
	}
	
	// 주소값이 아닌 value값 자체로 비교하기 위해 equals메서드를 오버라이딩 하려고 한다.
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Value) {
			return value == ((Value)obj).value;  // 이것만 있어도 실행되지만 if등등으로 확실히 체크하는 것.
		}
		return false;
	}
}