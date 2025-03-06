package Ch10;

class student {
	private String name;
	private int korean;
	private int english;
	private int math;

	public student() {
	}

	public student(int[] array) {
		this.korean = array[0];
		this.english = array[1];
		this.math = array[2];
	}

	public student(Object[] array) {
		this.name = (String) array[0];
		this.korean = (int) array[1];
		this.english = (int) array[2];
		this.math = (int) array[3];
	}

	public student(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public student(String name, int korean, int english, int math) {
		super();
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int sum() {
		int sum = (this.korean + this.english + this.math);
		return sum;
	}

	public int average() {
		int avg = (this.korean + this.english + this.math) / 3;
		return avg;
	}

}

public class C06Ex {

	public static void main(String[] args) {
		// 5개의 정수 값을 입력받아 int형 배열에 저장하고
		// 최대값, 최소값, 전제합을 출력합니다.

		// 5명의 학생에 국영수 점수를 입력받아 2차원 배열 저장
		// 각 학생의 국영수 점수의 합/평균 구하고
		// 각 과목당 합/평균 구하시오.

//		student student1 = new student("홍길동", 90, 80, 80);
//		student student2 = new student("홍길순", 85, 80, 85);
//		student student3 = new student("홍길남", 100, 85, 80);
//		student student4 = new student("홍길영", 80, 70, 85);
//		student student5 = new student("홍길윤", 80, 90, 85);

//		Object student2[] = { "홍길동", 90, 80, 80 };
//		Object student2[] = { "홍길순", 85, 80, 85 };
//		Object student3[] = { "홍길남", 100, 85, 80 };
//		Object student4[] = { "홍길영", 80, 70, 85 };
//		Object student5[] = { "홍길윤", 80, 90, 85 };

		int array[][] = { { 90, 80, 80 }, { 85, 80, 85 }, { 100, 85, 80 }, { 80, 70, 85 }, { 80, 90, 85 }, };

		Object studentarray[][] = { { "홍길동", 90, 80, 80 }, { "홍길순", 85, 80, 85 }, { "홍길남", 100, 85, 80 },
				{ "홍길윤", 80, 90, 85 } };

		student students[] = new student[5];
		student studentsarray[] = new student[5];

		for (int i = 0; i < students.length; i++) {
			students[i] = new student(array[i]);
			System.out.println("합 : " + students[i].sum());
			System.out.println("평균 : " + students[i].average());
		}

//		for (int i = 0; i < studentsarray.length; i++) {
//			studentsarray[i] = new student(studentarray[i]);
//		}
		
		double totalsum = 0;
		for (int i = 0; i < 5; i++) {
			totalsum += students[i].getKorean();
		}
		System.out.println("국어 전체 합 : " + totalsum);
		System.out.println("국어 전체 평균 : " + totalsum / 5);

	}

}
