import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EX02 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		int count = 0;
		File file = new File("data/data1.txt");
		FileInputStream src = new FileInputStream(file);
		Scanner sc = new Scanner(src);
		
		while(sc.hasNext()) {
			String tmp = sc.next();
			Thread.sleep(1000);
			System.out.printf("%s ", tmp);
			count++;
		}
		System.out.println("count : " + count);
		
		
	}

}
