package ScannerToken;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_split_studentDB {

	static ArrayList record = new ArrayList();   // 성적 데이터를 저장할 공간
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {

		while(true) {
			switch(displayMenu()) {
			case 1 :
				inputRecord();
				break;
			case 2 :
				displayRecord();
				break;
			case 3 :
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			    
			}
		} // while(true)
		
	}
	
	// menu를 보여주는 메서드
	static int displayMenu() {
		System.out.println("**********************************************");
		System.out.println("*              성적 관리 프로그램                 *");
		System.out.println("**********************************************");
		System.out.println();
		System.out.println(" 1.  학생성적 입력하기");
		System.out.println();
		System.out.println(" 2.  학생성적 보기");
		System.out.println();
		System.out.println(" 3.  프로그램 종료 ");
		System.out.println();
		System.out.print(" 4.  원하는 메뉴를 선택하세요. (1~3) :  ");
		
		int menu = 0;
		/*
		 (1) 아래의 로직에 맞게 코르를 작성하시오.
		 1. 화면으로부터 메뉴를 입력받는다. 메뉴의 값은 1 ~ 3 사이의 값이어야 한다.
		 2. 1 ~ 3 사이의 값을 입력받지 않으면, 메뉴의 선택이 잘못되었음을 알려주고 다시 입력받는다.
		 (유효한 값을 입력받을 때까지 반족해서 입력받는다.)
		 */
		
		int input1 = 0;
		do {
			Scanner scanner1 = new Scanner(System.in);
			input1 = scanner1.nextInt();
			menu = input1;
			
		}while(input1 > 3 || input1 < 1); 
		
		return menu;
	}
	
	// 데이터를 입력받는 메서드
	 static void inputRecord() {
		 System.out.println("1. 학생성적 입력하기");
		 System.out.println("이름, 반, 번호, 국어성적, 영어성적, 수학성적의 순서로 공백없이 입력하세요.");
		 System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");
		 
		 while (true) {
	         System.out.println(">>");
	         try {
	            String grade = s.nextLine();

	            if (grade.equalsIgnoreCase("q")) {
	               System.out.println("메인화면으로 돌아갑니다.");
	               break;
	            } else {
	               String[] instance = grade.split(",");
	               int[] intInstance = new int[instance.length];

	               for (int i = 0; i < instance.length; i++) {
	                  instance[i].trim();

	                  if (i >= 1) {
	                     intInstance[i] = Integer.parseInt(instance[i]);
	                  }
	               }
	               if (instance.length < 5) {
	                  throw new Exception();
	               }

	               record.add(new Student(instance[0], intInstance[1],
	                     intInstance[2], intInstance[3],
	                     intInstance[4],intInstance[5]));
	            }
	         } catch (Exception e) {
	            System.out.println("입력오류입니다.");
	         }
	      }
	   }


	 
	 // 데이터의 목록을 보여주는 메서드
	 static void displayRecord() {
		 int koreanTotal = 0;
		 int englishTotal = 0;
		 int mathTotal = 0;
		 int total = 0;
		 
		 int length = record.size();
		 
		 if(length > 0) {
			 System.out.println();
			 System.out.println("이름 반 번호 국어 영어 수학 총점 평균 전교등수 반등수");
			 
			 System.out.println("========================================================");
			 
			 for(int i = 0; i < length; i++) {
				 Student student = (Student)record.get(i);
				 System.out.println(student);
				 koreanTotal += student.kor;
				 mathTotal += student.math;
				 englishTotal += student.eng;
				 total += student.total;
			 }
			 
			 System.out.println("========================================================");
			 System.out.println("총점 : " + koreanTotal + " " + englishTotal + " " + mathTotal + " " + total);
			 System.out.println();
			 
		 }else {
			 System.out.println("========================================================");
			 System.out.println(" 데이터가 없습니다. ");
			 System.out.println("========================================================");
		 }
	 }  // end displayRecord()
}

class Student implements Comparable{
	String name;
	int ban, no, kor, eng, math, total, schoolRank, classRank;
	
	Student(String name, int ban, int no, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		total = kor+eng+math;
	}
	
	int getTotal() {
		return total;
	}
	
	float getAverage() {
		return (int)((getTotal()/3f)*10+0.5)/10f;
	}
	
	public int compareTo(Object o) {
		if(o instanceof Student) {
			Student tmp = (Student)o;
			return tmp.total - this.total;
		}else {
			return -1;
		}
	}  // end compareTo
	
	public String toString() {
		return name
				+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage()
				+","+schoolRank+","+classRank;
	}
}


