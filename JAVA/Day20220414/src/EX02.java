import java.util.Arrays;

public class EX02 {

	public static void main(String[] args) {

		// int �迭 1 ~ 100 ���� ���� �����ϰ� �Է¹޾Ƽ� ���հ� ��� ���ϱ�
		int sum = 0;
		double avg = 0;
		
		int[] nArr = new int[10];
		
		for(int i = 0; i < 10; i++) {
			nArr[i] = (int)(Math.random()*100)+1;
		}
		
		// ���� ���ϱ�
		for(int i = 0; i < 10; i++)
			sum += nArr[i];
		
		// ���հ� ��� ����ϱ�
		System.out.println(Arrays.toString(nArr));
		System.out.println("���� : " + sum);
		System.out.println("��� : " + (double)sum/nArr.length);
		

	}

}
