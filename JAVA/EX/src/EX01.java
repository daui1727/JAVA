
public class EX01 {

	public static void main(String[] args) {

		// �޷� ����� ����
		
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
		int year = 0, month = 0, daysOfMonth = 0, firstDay = 0;
		int monthDays = 0;
		int totalDays;
		
		int daysOfWeek = 0;
		if(args.length != 2) {  // args �迭 - ���� �� run configurations�� �� �Է�.
			year = 2022;
			month = 4;
		}else {
			year = Integer.parseInt(args[0]);
			month = Integer.parseInt(args[1]);
		}
		
		totalDays = (year*365);
		totalDays += (year-1)/4;
		totalDays -= (year-1)/100;
		totalDays += (year-1)/400;
		
		for(int i = 1; i < month; i++) {  // �ش� �⵵���� �Է��� �� �� �ޱ����� �� ���� �ش� �⵵�� �������� ����ؼ� ���
			if(i == 2) {
				if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
					monthDays = 29;
				} else {
					monthDays = 28;
				}
			} else {
				monthDays = days[i-1];
			}
			totalDays += monthDays;
		} // for�� ��
		
		firstDay = totalDays%7;  // �ش� �� 1���� ����
		
		if(month == 2) {  // ���� ���θ� �Ǵ��ؼ� �Է��� ���� �� ���� ���Ѵ�.
			if((year%4 == 0) && (year%100 != 0) || (year%400 == 0)) {
				daysOfMonth = 29;
			}else {
				daysOfMonth = 28;
			}
		}else {
			daysOfMonth = days[month-1];
		}
		
		/* ���� ��� */
		
		System.out.println(" " + year + "��" + month + "��");
		System.out.println(" �� �� ȭ �� �� �� ��");
		System.out.println("----------------------");
		for(int i = 0; i < firstDay; i++) {  // �ش� �� 1�� ������ �Ͽ����� �ƴ϶�� �պκ��� �������� ä���.
			System.out.print(" ");
			daysOfWeek++;
		}
		
		for(int i = 1; i <= daysOfMonth; i++) {   // �ٹٲް� ����
			if(i<10) {
				System.out.print(" "+i+"");
			}else {
				System.out.print(""+i+" ");				
			}
			daysOfWeek++;
			if(daysOfWeek%7 == 0) {
				System.out.println();
				daysOfWeek = 0;
			}
		}
		
		
		
		
		
		
		
	} // main�� ��

}
