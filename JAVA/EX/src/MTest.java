import java.util.Scanner;

public class MTest {

	 public static void main(String[] args) {

		 
		    int year = 0; 
			int month = 0; 
			int ttdays = 0; 
			int day = 0;       
			int i = 0; 
			int j = 0;
		//-----------------------------------------------------------------------------------------------------//	   
			   Scanner scanner = new Scanner(System.in);
			   System.out.println("�ش� �⵵�� �Է� �� �ּ���.");
			   year = scanner.nextInt( );
		       System.out.println("�ش�  ���� �Է� �� �ּ���.");
			   month = scanner.nextInt( );
		//-----------------------------------------------------------------------------------------------------//
		       // �� �ϼ� ���
		       for(i = 1; i<year; i++){
		                if(i % 4 != 0){
		                    ttdays +=365;
		                        }
		                else {
		                    if(i%100 != 0){
		                        ttdays += 366;
		                        }
		                    else{
		                        if(i%400 != 0){
		                            ttdays += 365;
		                        }
		                        else{
		                            ttdays+=366;
		                        }
		                       } 
		                      }
		                     }
		//-----------------------------------------------------------------------------------------------------//
		        // �� �ϼ� 
		        switch(month) {
		            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
		                day = 31;
		            case 4: case 6: case 9: case 11:
		                day = 30;
		            case 2:
		                if((year %4 != 0) && (year %100 == 0) && (year %400 != 0))
		                    day = 28;
		                	day = 29 ; 
		        }
		//------------------------------------------------------------------------------------------------------//
		        int d = ttdays%7;
		        int g;
		        int month2 = 30;
		        System.out.println("year : " + year + " month : " + month + "\ntotal days :" + ttdays + "\nd : " +d);
		//-----------------------------------------------------------------------------------------------------//        
		         //�޷� ���  
		        System.out.println("--------------------------------");
		        System.out.printf("��\t��\tȭ\t��\t��\t��\t��\t\n");
		        {
		        for(g = 1; g <= d; g++) {
		        	System.out.print("\t");
		        }
		        for(int k = 1; k <= month2; k++) {
					System.out.printf("%d\t", k);
					d++;
					if(d%7 == 0) {
						System.out.println();
					}
				}
//		        for(j = 1; j <= day; j++){
//		                if((j)%7 == 0){
//		                    System.out.printf("%2d\n" , j);
//		                    }
//		                else {    
//		                    System.out.printf("%2d\t" , j);
//		                    }
//		        }
		        	
		        }
		        System.out.printf("--------------------------------");
		//-----------------------------------------------------------------------------------------------------//
		 }	    

	 
}