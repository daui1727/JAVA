public class EX01 {

	public static void main(String[] args) {

		// ������ �⺻ ����� 1500 �̶�� ����
		// ���̴� �����Լ����� �Է�
		/*
		   0 ~ 3��   ������ 100%
		   4 ~ 13��  ������  50%
		   14 ~ 19�� ������  25%
		   20�� �̻�  ������   0%
		   65�� �̻�  ������  100%
		 */
		// ���� ��� ��� ����
		
//		int bus = 1500;
//		
//		int	age = (int)(Math.random()*100)+1;
		
//		if(age >= 0 && age <= 3) {
//			bus -= (bus*1);
//		}
//		else if(age >= 4 && age <= 13) {
//			bus -= (bus*0.5);
//		}
//		else if(age >= 14 && age <= 19) {
//			bus -= (bus*0.25);
//		}
//		else if(age >= 20 && age < 65) {
//			bus -= (bus*0);
//		}
//		else if(age >= 65) {
//			bus -= (bus*1);
//		}
		
//		if(age >= 65)
//			bus -= (bus*1);
//		else if(age >= 20)
//			bus -= (bus*0);
//		else if(age >= 14 && age <= 19)
//			bus -= (bus*0.25);
//		else if(age >= 4 && age <= 13)
//			bus -= (bus*0.5);
//		else if(age >= 0 && age <= 3)
//			bus -= (bus*1);
		
//		System.out.println(age + "���� ���� ����� " + bus);
		
		
		/* -- */
		
		
		int age = (int)(Math.random()*100)+1;
		int fee = 1500;
		double rate = 0;
		
		if(age>=65)
			rate = 0.0;
		else if(age >= 20)
			rate = 1.0;
		else if(age >= 14)
			rate = 0.75;
		else if(age >= 4)
			rate = 0.5;
		else
			rate = 0.0;
		
		System.out.println(age + " : " + "������� : " + (int)(fee*rate) + "��");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
