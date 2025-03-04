package Ch08;

// 멤버 변수		: 클래스 내부 ~ 메서드 영역 바깥 에서 생성.
//				생성된 객체의 개별 정보 저장
// static 변수	: 동일 클래스로부터 만든 여러 객체간 공유하는 멤버 변수
// 지역변수 		: 메서드 영역(파라미터, 매개변수 포함) 내에서, 혹은 메서드 영역 내의 {}범위에서 생성되는 변수

class C05Simple {
	int num = 10; // 멤버 변수

	void Func1() {
		System.out.println("멤버변수 num :" + num);
		int num = 5; // num을 새로 지정하였으므로 num은 멤버변수가 아닌 지역변수가 된다.
		System.out.println("Func1의 지역변수 num" + num);
		num++; // 지역변수에 적용
		this.num++; // 멤버변수에 적용. this는 멤버변수와 지역변수를 구분짓는 방법 중 하나.
	}

	void Func2() {
		System.out.println("멤버변수 num :" + num);
		if (true) {
			int num = 100; //지역변수 선언
			System.out.println("Func2의 if 안 지역변수 num :" + num);
		}
		System.out.println("멤버변수 num :" + num); // if가 끝났으므로 이 num은 멤버변수이다.

		while (num < 10) {			
			System.out.println("num :" + num);
			num++; // 따로 지정하지 않으면 멤버변수이다.
		}
	}
	void Func3(int num) {
		this.num = num;
	}
}

public class C05LocalVarMain {

	public static void main(String[] args) {
		C05Simple obj = new C05Simple();
		obj.Func1();
		obj.Func2();
	}
}