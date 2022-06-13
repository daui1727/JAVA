import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EX01 {

	public static void main(String[] args) throws IOException {
		
		int count = 0;
		{
			File file = new File("data/suwon.txt");
			FileInputStream infile = new FileInputStream(file);
			Scanner sc = new Scanner(infile);
			
			while(sc.hasNextLine()) {  // 읽어올 데이터가 있는지 물어봄.
				sc.nextLine();
				count++;
			}   
			count--;   // 데이터 외에 가장 윗 줄 시도명 시군구명 같은 란을 빼기 위함.
			System.out.println("count : " + count);
			sc.close();
			infile.close();
		}
		
		//시도명,시군구명,구청명,법정동명,등록품종수,등록개체수,소유자수,관리부서명,관리부서연락처,데이터기준일자
		//경기도,수원시,권선구,탑동,67,1486,1100,권선구 경제교통과,031-228-6373,2021-09-30
		
		String[] region = new String[count];
	    String[] city = new String[count];
	    String[] district = new String[count];
	    String[] dong = new String[count];
	    int[] variety = new int[count];
	    String[] howmany = new String[count];
	    String[] owner = new String[count];
	    String[] office = new String[count];
	    String[] callnum = new String[count];
	    String[] data = new String[count];
	    
	    {
	    	File file = new File("data/suwon.txt");
			FileInputStream infile = new FileInputStream(file);
			Scanner sc = new Scanner(infile);
			
			int total = 0;
			sc.nextLine();  // 첫번째 줄을 읽어서 버린다.
			
			for(int i = 0; i < count; i++) {
				String line = sc.nextLine();
				
				String[] tokens = line.split(",");
				region[i] = tokens[0];
				city[i] = tokens[1];
				district[i] = tokens[2];
				dong[i] = tokens[3];
				variety[i] = Integer.parseInt(tokens[4]);
				total += variety[i];
			} // end for
			
			for(int i = 0; i < count; i++) {
				
				System.out.printf("%s %s %s %s %d\n", region[i], city[i], district[i], dong[i], variety[i]);
				
			} // end for
			System.out.println("total = " + total);
			sc.close();
			infile.close();
	    }
	    
		
	}

}
