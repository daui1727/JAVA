// 인터페이스 예제 7-24

public class EX03 {

	public static void main(String[] args) {

		Fighter f = new Fighter();
		
		if(f instanceof Unit) {  // 참조변수 f가 Unit을 참조하거나 Unit을 상속하는 클래스를 참조하면 ok
			System.out.println("f는 Unit클래스의 자손입니다.");
		}
		if(f instanceof Fightable) {
			System.out.println("f는 Fightable인터페이스를 구현했습니다");
		}
		if(f instanceof Movable) {
			System.out.println("f는 Movable인터페이스를 구현했습니다.");
		}
		if(f instanceof Attackable) {
			System.out.println("f는 Attackable인터페이스를 구현했습니다.");
		}
		if(f instanceof Object) {
			System.out.println("f는 Object클래스의 자손입니다.");
		}
	
	}

}

class Unit{
	int currntHP;   // 유닛의 체력
	int x;   // 유닛의 위치(x 좌표)
	int y;   // 유닛의 위치(y 좌표)
}

class Fighter extends Unit implements Fightable{
	public void move(int x, int y){}
	public void attack(Unit u){}
}

interface Fightable extends Movable, Attackable{}
interface Movable{void move(int x, int y);}
interface Attackable{void attack(Unit u);}