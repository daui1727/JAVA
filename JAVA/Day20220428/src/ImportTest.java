import java.text.SimpleDateFormat;  // import를 했기 때문에 SimpleDateFormat 클래스 이름 앞에 패키지명을 생략할 수 있다.
import java.util.Date;  // 같은 패키지 내의 클래스들은 import문을 지정하지 않더라도 생략가능하다.

public class ImportTest {

	public static void main(String[] args) {

		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		
		System.out.println("오늘 날짜는 " + date.format(today));
		System.out.println("현재 시간은 " + time.format(today));
	}

}
