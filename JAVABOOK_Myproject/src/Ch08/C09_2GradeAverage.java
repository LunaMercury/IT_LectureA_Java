package Ch08;

import java.util.Scanner;

class Grade {
	private int math;
	private int science;
	private int english;
	int average;

	Grade(int math, int science, int english) {
		super();
		this.math = math;
		this.science = science;
		this.english = english;
	}

	public int average() {
		average = (math + science + english) / 3;
		return average;
	}
}

public class C09_2GradeAverage {

	public static void main(String[] args) {
		/*
		 * 수학, 과학, 영어 순으로 3개의 정수 입력 >> 90 88 96 평균은 91 [Hint] Grade 클래스에 int 타입의 math,
		 * science, english 필드를 private로 선언하고, 생성자와 세 과목의 평균을 리턴하는 average() 메소드를 작성한다.
		 */
		Scanner sc = new Scanner(System.in);

		System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
		int math = sc.nextInt();
		int science = sc.nextInt();
		int english = sc.nextInt();
		Grade me = new Grade(math, science, english);
		System.out.println("평균은 " + me.average()); // average()는 평균을 계산하여 리턴

		sc.close();
	}

}
