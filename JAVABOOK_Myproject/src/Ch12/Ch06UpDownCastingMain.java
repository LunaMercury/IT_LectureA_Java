package Ch12;

class Super {
	int n1;
}

class Sub extends Super {
	int n2;
}

public class Ch06UpDownCastingMain {

	public static void main(String[] args) {
		Super ob1 = new Super();
		ob1.n1 = 10;
		Sub ob2 = new Sub();
		ob2.n1 = 10;
		ob2.n2 = 20;

		// Upcasting : 상위클래스 참조변수 = 하위클래스형 객체. 자동형변환
		// 상속관계로 연결된 모든 하위객체를 연결할 수 있다
		
		Super ob3 = new Sub();
		// 먼저 Sub 클래스로 공간을 확보. 그리고 Super 클래스로 ob3를 만든다. 이렇게 되면 ob3와 확보된 공간의 형태가 다르다. 형태를
		// 바꾸기 위해 공간의 형태를 변환한다.
		// 형태는 Super ob3 = (Super) new sub(); 가 된다.
		ob3.n1 = 100;
//		ob3.n2 = 200; // 처음 공간은 Sub로 만들었지만, Super로 형변환 하였다. Super는 n1만 가지고 있으므로 n2는 인식할 수 없다.

		Super ob4 = ob2;
		// Sub 클래스인 ob2를 복사해서 Super 클래스인 ob4에 적용하였으므로 ob4는 n1만 가지고 있다.
		ob4.n1 = 100;
//		ob4.n2 = 200; // 적용할 수 없다.

		// Downcasting : 하위클래스 참조변수 = 상위클래스형 객체. 강제형변환
		// UPcasting된 상태에서 확장된 멤버에 접근하기 위한 용도
		
//		Sub ob5 = (Sub) ob1; // ob1은 처음 만들어질 때 Super 형으로 만들어졌기 때문에 메모리상 n1밖에 존재하지 않는다. 메모리 확보를 n1밖에 하지 않았으므로 강제형변환을 한다 해도 메모리 확보를 하지 않은 n2를 포함할 수 없으므로 에러가 발생한다. 
		Sub ob6 = (Sub) ob3; // ob3 처음에 Sub 형태로 만들어서 그걸 Super로 자동형변환했다. 즉 ob3는 메모리상 n1과 n2 둘 다 가지고 있지만, 형변환으로 인해 n1만 인식하고 n2는 존재하고 있지만 인식하지 않는 상황이다. 여기서 다시 ob3를 Sub로 다운캐스팅하면 n2를 다시 인식할 수 있다.

	}
}