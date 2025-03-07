package Ch12.ex;

// Exercise 2: Method Access
class Vehicle {
	void start() {
		System.out.println("탈것의 시동을 겁니다");
	}
}

class Car extends Vehicle {
	void start() {
		System.out.println("자동차의 시동을 겁니다");
	}

	void turboBoost() {
		System.out.println("자동차가 터보로 가속합니다!");
	}
}

public class Ex02MethodAccess {
	public static void main(String[] args) {
		System.out.println("=== 연습문제 2: 메서드 접근 ===");
		// 문제: 다음 단계를 수행하는 코드를 작성하세요
		// 1. Car 인스턴스를 생성하세요
		Car car1 = new Car();

		// 2. 생성한 Car 인스턴스를 Vehicle 타입으로 업캐스팅하세요
		Vehicle car2 = car1;

		// 3. 업캐스팅된 참조로 start() 메서드를 호출해보세요
		car2.start();

		// 4. 업캐스팅된 참조로 turboBoost() 메서드 호출을 시도해보세요
//		car2.turboBoost();

		// 5. 다시 Car 타입으로 다운캐스팅한 후 turboBoost() 메서드를 호출해보세요
		Car car3 = (Car) car2;
		car3.turboBoost();

		// 실행 결과 예시:
		// 자동차의 시동을 겁니다
		// 컴파일 에러: turboBoost() 메서드는 Vehicle 타입에서 접근 불가
		// 자동차가 터보로 가속합니다!
	}
}