import java.util.Arrays;

public class EX00 {

	public static void main(String[] args) {

		
		int[] score = new int[5];  // 5���� int ���� ������ �� �ִ� �迭�� �����Ѵ�.
		score[2] = 100; // �迭�� 3��° ��ҿ� 100�� ����.
		int value = score[3]; // �迭 4��° ��ҿ� �ִ� ���� value�� ����.
		
		for(int i = 0; i < 5; i++)
			score[i] = i*10;
		
		System.out.println(Arrays.toString(score));
		
		System.out.println();
		
		
		
	}

}
