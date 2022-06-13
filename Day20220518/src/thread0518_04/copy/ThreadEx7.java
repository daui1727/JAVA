package thread0518_04.copy;

import javax.swing.JOptionPane;

public class ThreadEx7 {

	public static void main(String[] args) {
		
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");

	}   // 2개의 쓰레드로 처리했기 때문에 값이 찍히면서 값을 입력도 할 수 있다.

}

class ThreadEx7_1 extends Thread{  
	public void run() {
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				sleep(1000);
			}catch(Exception e) {}
		}
	}
}
