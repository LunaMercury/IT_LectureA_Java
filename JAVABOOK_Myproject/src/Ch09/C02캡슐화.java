package Ch09;

import java.security.PrivateKey;

// 캡슐화란?
// 특정 목적을 가지는 기능을 구현하는데 필요한 세부 기능들을 묶어서 처리하는 방법
// 특정 목적을 가지는 기능 구현에 잇어서 각 과정의 일부나 전부가 외부로 노출되는 문제를 막기 위해 정보은닉을 수반(필수는 아님)
// 캡슐화 작업은 각 공정과정에 대한 정확한 이해가 수반되어야 한다.

class Engine {
	private void 흡입() {
		System.out.println("흡입");
	}

	private void 압축() {
		System.out.println("압축");
	}

	private void 폭발() {
		System.out.println("폭발");
	}

	private void 배기() {
		System.out.println("배기");
	}

	// 캡슐화
	public void EngineStart() {
		흡입();
		압축();
		폭발();
		배기();
	}
}

class Car {
	private Engine engine;
	// 차는 바퀴나 후드 등 여러 요소가 있으므로 private Wheel wheel; private Hood hood; 등을 계속 입력할 수 있다.
	
	//생성자. Engine 클래스의 기능을 engine에 복사하기 위해 필요하다.
	Car(){
		engine = new Engine();
	}
	void run() {
		engine.EngineStart();
	}
}

public class C02캡슐화 {

	public static void main(String[] args) {
		Car car1 = new Car();
		car1.run();
	}
}