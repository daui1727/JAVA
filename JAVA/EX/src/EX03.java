import java.util.*;
public class EX03 {
   public static void main(String[] args) {
	   
Scanner scanner = new Scanner(System.in);
int year=0, month=0, week=0, day=0, i=0;
int monthSet[]= {31,28,31,30,31,30,31,31,30,31,30,31};

while(true) {
   System.out.println("�⵵�� �Է��ϼ���.(0�� ������ �����մϴ�.)");
   year=scanner.nextInt();
   if(year==0) {
      System.exit(0);
      break;
   }
   System.out.println("���� �Է��ϼ���.");
   month=scanner.nextInt();
   if(month<1||month>12) {
      System.out.println("1������ 12�������� ���� �Է����ּ���.");
      return;
   }
   System.out.println("");
   
   if(year%4 == 0 && year%100 !=0 || year%400==0) //����
      monthSet[1]=29;//�����̸� 2�� 29��
   else
      monthSet[1]=28;//�ƴϸ� 2�� 28��
   
   //
   day = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
   for(i=0;i<month-1;i++) {
      day+=monthSet[i];
   }
   week=day%7;
   System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t\n","��","ȭ","��","��","��","��","��");
   
   week=5;
   for(i=1; i<week; i++) {
      System.out.print("\t");
   }
   
   for(int j=1;j<=30;j++) {
      System.out.printf("%d\t",j);
      week++;
      if(week%7==0) {
         System.out.println();
      }
     }
	}
   }
}