// Date, Calender, LocalDateTime 차이

package Ch14;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class C05DateMain {

	public static void main(String[] args) {
		// Date
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println("getYear : " + (d1.getYear() + 1900)); // 리눅스 기반이라 1900년을 시작으로 한다. 1900을 더해줘야 한다.
		System.out.println("getMonth : " + (d1.getMonth() + 1));
		System.out.println("getDay : " + d1.getDay()); // 0-6(일-토)
		System.out.println("getHours : " + d1.getHours());
		System.out.println("getMinutes : " + d1.getMinutes());
		System.out.println("getSeconds : " + d1.getSeconds());
		System.out.println("getTime : " + d1.getTime());
		System.out.println("------------------------------------------------------");

		// Calender
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println("get(Calendar.YEAR) : " + cal.get(Calendar.YEAR));
		System.out.println("get(Calendar.MONTH) : " + (cal.get(Calendar.MONTH) + 1));
		System.out.println("get(Calendar.DAY_OF_MONTH) : " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("get(Calendar.DAY_OF_WEEK) : " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("get(Calendar.HOUR_OF_DAY) : " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("get(Calendar.MINUTE) : " + cal.get(Calendar.MINUTE));
		System.out.println("get(Calendar.SECOND) : " + cal.get(Calendar.SECOND));
		System.out.println("------------------------------------------------------");

		// LocalDateTime
		LocalDateTime now = LocalDateTime.now();

		// 연, 월, 일, 시, 분, 초 가져오기
		int year = now.getYear();
		int month = now.getMonthValue(); // 월 (1~12)
		int day = now.getDayOfMonth(); // 일 (1~31)
		int hour = now.getHour(); // 시 (0~23)
		int minute = now.getMinute(); // 분 (0~59)
		int second = now.getSecond(); // 초 (0~59)
		DayOfWeek dayOfWeek = now.getDayOfWeek();

		System.out.println("연 : " + year);
		System.out.println("월 : " + month);
		System.out.println("일 : " + day);
		System.out.println("시 : " + hour);
		System.out.println("분 : " + minute);
		System.out.println("초 : " + second);

	}

}
