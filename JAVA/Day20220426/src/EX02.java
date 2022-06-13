
public class EX02 {

	public static void main(String[] args) {

		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		
		System.out.println(card1.info());
		System.out.println(card2.info());
		
	}

}

class SutdaCard{
	
	private int num = (int)(Math.random()*10)+1;
	private boolean isKwang;
	
	
	public SutdaCard(int num, boolean isKwang) {
		if(num >= 1 && num <= 10)
			this.num = num;
		else
			this.num = 0;
		
		this.isKwang = isKwang;
	}
	
	public SutdaCard(){
//		this.num = 1;
//		this.isKwang = true;
		this(1,true);   // 이 this는 위의 다른 SutdaCard를 불러오는 것.
	}
	
	String info(){
//		return num + (isKwang==true ? "K" : "");
		return num + (isKwang? "K":"");
	}
	
}
