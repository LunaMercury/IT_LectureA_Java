// 날짜정보 포맷팅을 해야하는 이유는 데이터베이스 날짜 저장 형식과 자바의 저장형식이 다를 수 있기 때문
// 자바는 2025/03/02인데, 다른 데이터베이스 형식은 2025-03-02일 수 있기 때문

package Ch14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class C06SimpleDateFormatMain {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("YYYY/MM/DD 입력 : ");
		String ymd = sc.next();
		
		// 포메터 객체 생성(입력용)
		SimpleDateFormat fmtin = new SimpleDateFormat("yyyy/MM/dd"); //Y,M,d,h,m,s. ★대소문자에 주의
		System.out.println(ymd);
		Date date = fmtin.parse(ymd);
		System.out.println(date);
		
		//포메터 객체 생성(출력용)
		SimpleDateFormat fmtout = new SimpleDateFormat("yyyy~MM~dd");
		System.out.println(fmtout.format(date));
		
		sc.close();
	}
}