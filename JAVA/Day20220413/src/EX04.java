import java.util.Arrays;

public class EX04 {

	public static void main(String[] args) {

		
		// ������ �迭 5�� ����
		// �ʱ�ȭ�� �����Լ� ���ؼ� 1 ~ 100 ���� ���� ���� �� ���
		
		int[] num = new int[5];
		
		for(int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random()*100)+1;
		}
		
		System.out.println(Arrays.toString(num));
		
		
		// �ִ밪 �� �ּҰ� ��� �� ���
		
		int max = num[0];
		int min = num[0];
		
		for(int i = 0; i < num.length; i++) {
			
			if(max < num[i])
				max = num[i];
			
			// �ּҰ�
			if(min > num[i])
				min = num[i];
		}
		
		System.out.println("max : " + max);
		System.out.println("min : " + min);
		
		// Sort(����)

		for (int i = 0; i < num.length; i++) {
			
			for(int j = 0; j < num.length; j++) {
				if(num[i] > num[j])
					num[i] = num[j];
				
				for (int k = 0; k < num.length; k++) {
					
				}
			}
			
		}
		System.out.println(Arrays.toString(num));
	}

}
