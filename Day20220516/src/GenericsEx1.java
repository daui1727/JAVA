
public class GenericsEx1 {

	public static void main(String[] args) {

//		AppleBox aBox = new AppleBox();
//		OrangeBox oBox = new OrangeBox();
//		
//		aBox.setAp(new Apple());
//		oBox.setOr(new Orange());
//		
//		Apple ap = aBox.getAp();
//		System.out.println(ap);
//		
//		Orange or = oBox.getOr();
//		System.out.println(or);
		
		/* ----------------------------------box클래스 이후 */
		
		Box aBox = new Box();
		Box oBox = new Box();
		
		aBox.setOb(new Apple());  // 이런 식으로 넣어야한다.
		oBox.setOb(new Orange());
		
		Apple ap = (Apple) aBox.getOb();   // 넣는건 괜찮은데 꺼낼때는 뭘 꺼낼지 모르기 때문에 문제가 된다. 형변환이 필요해진다.
		System.out.println(ap);
		
		Orange or = (Orange) oBox.getOb();
		System.out.println(or);
		System.out.println("------");
		
		/* ------------------------------------- */
		
		aBox.setOb("apple");
		oBox.setOb("orange");  // set으로 넣을땐 문제가 없지만
		
		String ap4 =(String) aBox.getOb();  // 불러올땐 문제가 발생한다. 이 경우엔 String을 넣어줬으니 String으로 받아줘야한다.
		
	}

}

class Apple{
	@Override
	public String toString() {
		return "apple";
	}
}

class Orange{
	@Override
	public String toString() {
		return "orange";
	}
}

class Box{  // 아래 박스들이 하는 역할을 이 클래스로.
	private Object ob;

	public Object getOb() {
		return ob;
	}

	public void setOb(Object ob) {
		this.ob = ob;
	}
	
}

//class AppleBox{
//	private Apple ap;
//
//	public Apple getAp() {
//		return ap;
//	}
//
//	public void setAp(Apple ap) {
//		this.ap = ap;
//	}
//}
//
//class OrangeBox{
//	private Orange or;
//
//	public Orange getOr() {
//		return or;
//	}
//
//	public void setOr(Orange or) {
//		this.or = or;
//	}
//}

