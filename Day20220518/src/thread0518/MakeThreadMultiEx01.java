package thread0518;

public class MakeThreadMultiEx01 {

	public static void main(String[] args) {
		
		Runnable task1 = ()->{
			try {
				for(int i = 0; i < 20; i++) {
					if(i%2 == 0)
						System.out.print(i + " ");
					Thread.sleep(1000);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		};
		
		Runnable task2 = ()->{
			try {
				for(int i = 0; i < 20; i++) {
					if(i%2 == 1)
						System.out.print(i + " ");
					Thread.sleep(1000);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		t1.start();
		t2.start();

	}

}

// Thread.sleep이 없다면 쓰레드가 일정하게 돌지는 않아서 값이 매번 다르게 나온다.
