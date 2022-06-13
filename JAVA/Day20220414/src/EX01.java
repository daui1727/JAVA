import java.util.Arrays;

public class EX01 {

	public static void main(String[] args) {

		
		int[] num = new int[5];
		
		for(int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random()*100);
		}
		
		System.out.println(Arrays.toString(num));
		
		for(int i = 0; i < num.length-1; i++)
			for(int j = i+1; j < num.length; j++)
				if(num[i] > num[j]) {
					int tmp = num[i];
					num[i] = num[j];
					num[j] = tmp;
				}
		System.out.println(Arrays.toString(num));
	}

}