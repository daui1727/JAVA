
public class EX01 {

	public static void main(String[] args) {

		Tv2[] tvArr = new Tv2[3];   // 길이가 3인 Tv 객체 배열
		
		// Tv객체를 생성해서 Tv객체 배열의 각 요소에 저장
		for(int i = 0; i < tvArr.length; i++) {
			tvArr[i] = new Tv2();
			tvArr[i].channel = i + 10;  // tvArr [i]의 channel에 i + 10을 저장
		}
		
		for(int i = 0; i < tvArr.length; i++) {
			tvArr[i].channelUp();  // tvArr[i]의 메서드를 호출.
			System.out.printf("tvArr[%d].channel = %d\n", i, tvArr[i].channel);
		}
	} // end main
}

class Tv2{
	String color;
	boolean power;
	int channel;
	
	void power() {power = !power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}
