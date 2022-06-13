package pack0428;

public class EX03 {

	
	static void action(Robot robot) {
		
		if(robot instanceof DanceRobot) {
			DanceRobot dan = (DanceRobot)robot;
			dan.dance();
		}else if(robot instanceof SingRobot) {
			SingRobot sin = (SingRobot)robot;
			sin.sing();
		}else if(robot instanceof DrawRobot) {
			DrawRobot dra = (DrawRobot)robot;
			dra.draw();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Robot[] arr = {new DanceRobot(), new SingRobot(), new DrawRobot()};
		
		for(int i = 0; i < arr.length; i++) {
			action(arr[i]);
		}
		
	}

}


class Robot{}

class DanceRobot extends Robot{
	void dance() {
		System.out.println("춤을 춥니다.");
	}
}

class SingRobot extends Robot{
	void sing() {
		System.out.println("노래를 합니다.");
	}
}

class DrawRobot extends Robot{
	void draw() {
		System.out.println("그림을 그립니다.");
	}
}