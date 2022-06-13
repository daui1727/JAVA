package ScannerToken;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringToken_etc {

	public static void main(String[] args) {

		String data ="100, 200,,,300";
		
		System.out.println("StringTokenizer......");
		StringTokenizer st = new StringTokenizer(data,",");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("========================");
		System.out.println("Scanner.....");
		Scanner sc = new Scanner(data).useDelimiter(",");
		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
		
		System.out.println("=========================");
		System.out.println("Split.......");
		String[] strings = new String(data).split(",");
		for(String str : strings) {
			System.out.println(str);
		}
		
		
	}

}
