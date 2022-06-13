import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionEx1 {

	public static void main(String[] args) throws Exception {
		// Test t = new Test();
		// 차후에 봐도 되는 부분인듯..  new 없이 객체 생성해서 자원에 접근.
		
		Class clsName = Class.forName("Test");
		
		Object obj = clsName.getDeclaredConstructor().newInstance();
		
		System.out.println(obj.getClass().getName());
		
		Method[] method = clsName.getDeclaredMethods();
		System.out.println(method);
		
		for(Method m : method)
			System.out.println(m);
		
		Field[] field = clsName.getDeclaredFields();
		for(Field f : field)
			System.out.println(f.getInt(obj));
	}

}

class Test{
	int num = 10;
	int num2 = 20;
	int num3 = 30;
	
	void func1() {}
	void func2() {}
	void func3() {}
}
