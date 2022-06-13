package pack0428;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Abc{
	private int aaa = 10;
	
}


public class ex {

	public static void main(String[] args) {
		Abc ab = new Abc();
		ab.setAaa(3);
		System.out.println(ab.getAaa());
	}

}

