
public class EX02 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		
//		Card c = new Card("HEART",3);
//		System.out.println(c);
//		
//		Card c2 = Card.class.newInstance();  // Class  객체를 통해서 객체 생성
//		System.out.println(c2);
//		
//		Class cObj = c.getClass();
		Class cObj = Class.forName("Card");
		
		System.out.println(cObj.getName());
		System.out.println(cObj.toGenericString());
		System.out.println(cObj.toString());
		
	}

}

final class Card{
	String kind;
	int num;
	
	public Card() {
		this("SPADE",1);
	}
 
	public Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	
	@Override
	public String toString() {
		return kind + " : " + num;
	}
	
}