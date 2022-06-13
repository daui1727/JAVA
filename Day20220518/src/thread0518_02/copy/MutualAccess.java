package thread0518_02.copy;

class Counter{
	int count = 0;
//	synchronized public void increment() {count++; System.out.println("1111");}  // 이 경우 count++ 이외의 다른 것들도 실행되느라 손해가 발생한다.
	public void increment() {  // 이렇게 해결. 시간 차이가 나는 듯?
		synchronized (this) {  // 동기화 블럭
			count++;
		}
		System.out.println("1111");
	}
	synchronized public void decrement() {count--;}
	public int getcount() {return count;}
}

public class MutualAccess {

	public static Counter cnt = new Counter();
	
	public static void main(String[] args) throws Exception {
		
		Runnable task1 = () -> {   // Runnable 구현한 인스턴스 생성
			for(int i = 0; i < 1000; i++) {
				cnt.increment();
			}
		};
		
		Runnable task2 = () -> {
			for(int i = 0; i < 1000; i++) {
				cnt.decrement();
			}
		};
		
		Thread t1 = new Thread(task1);   // Thread 인스턴스 생성
		Thread t2 = new Thread(task2);   // Thread 인스턴스 생성

		t1.start();
		t2.start();
		
		t1.join();   // t1이 참조하는 쓰레드 종료까지 대기
		t2.join();
		
		System.out.println(cnt.getcount());
		
		// 빵을 두 사람이 나눠먹는 이야기. 한 놈이 두번 세번 먼저 먹어버리니까 값이 일정하게 나올 수가 없는..
		
		// 그래서 동기화가 필요하다..synchronized 하나가 접근할때 다른 하나는 대기.
	}

}
