
public class EX02 {

	public static void main(String[] args) {

		
		
		int num = 1;
		int num2 = 0;
		int num3 = 0;
		
		num = num + 1;
		num += 1;
		
		num2 = ++num;
		
		System.out.println(num + "," + num2);
		
		num3 = num++;
		
		System.out.println(num + "," + num3);
		
		/*-------------------------------------------------------------*/
		
		int i = 1;
		int j = 4;
		j++;
		System.out.println(j);
		i--;
		System.out.println(i);
		
		boolean k;
		k = true;
		System.out.println("k -> " + k);
		k = false;
		System.out.println("k -> " + k);
		boolean l = 2 < 3;
		System.out.println("h -> " + l);
		boolean m = "3".equals("2");
		System.out.println("m -> " + m);
		
		
		/* -------------------------------------------------------------- */
		
		
		char a = 'a';
		char d = 'd';
		char zero = '0';
		char two = '2';
		
		System.out.printf("'%c' - '%c' = %d%n", d, a, d - a);
		System.out.printf("'%c' - '%c' = %d%n", two, zero, two - zero);
		System.out.printf("'%c' = %d%n", a, (int)a);
		System.out.printf("'%c' = %d%n", d, (int)d);
		
		
		

	}

}
