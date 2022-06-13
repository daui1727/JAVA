
public class BankAccount {		// 클래스 --> 클래스 설계는 추상화 기능을 이용하여 만듬

	private int balance;  // 잔액   //  멤버변수, 인스턴스변수   // 원칙 : 변수는 외부에서 직접 접근을 금지시켜야한다. // 정보은닉의 목적 무결성을 위해
	// bank.deposit = 10000;  이런식으로는 하지말라는. // 멤버변수의 경우는 필수적으로 private를 적어야한다. 보안 문제.
	
	private int sum;
	
//	// getter, setter --> get 값 출력, set 값 입력
//	void setSum(int sum) {
//		this.sum = sum;
//	}
//	
//	int getSum() {
//		return this.sum;
//	}
	
	
	int deposit(int amount) {  // 입금
		if(amount < 0) {
			return 0;
		}
		balance += amount;
		
		return balance;
	}

	int withdraw(int amount) {  // 출금
		balance -= amount;
		return balance;
	}
	
	void checkBalance() {  // 잔고 확인
		System.out.println("잔액 : " + balance);
	}

}

class MainClass{
	public static void main(String[] args) {
		
		BankAccount kim = new BankAccount();  // 생성자 호출 !!!!!!!   --> 현재는 디폴트 생성자 호출됨.
		
		kim.deposit(10000);
		
		kim.checkBalance();
		
		kim.withdraw(3000);

		kim.checkBalance();
		
//		bank.setSum(100);
//		bank.getSum();
		
		// park
		
		BankAccount park = new BankAccount();
		park.deposit(10000);
		park.checkBalance();
		park.withdraw(1000);
		park.checkBalance();
		
	
		
		// lee
		
		BankAccount lee = new BankAccount();
		lee.deposit(20000);
		lee.checkBalance();
		lee.withdraw(4000);
		lee.checkBalance();
		
		
		System.out.println("--------------------------------");
		lee = kim;
		lee.checkBalance();
		lee.deposit(10000);
		kim.checkBalance();
		park.checkBalance();
	}
}


// 다음과 같이 출력하고자 한다.
// 잔액 : 10000
// 잔액 : 7000