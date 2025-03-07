package Ch12;

// 각 클래스에 모든 인자를 받는 생성자 코드 삽입
// toStirng 코드 삽입

class A {
	int a;

	public A(int a) {
		super();
		this.a = a;
	}

	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
}

class B extends A {
	int b;

	public B(int a, int b) {
		super(a);
		this.b = b;
	}

	@Override
	public String toString() {
		return "B [b=" + b + ", a=" + a + "]";
	}
}

class C extends A {
	int c;

	public C(int a, int c) {
		super(a);
		this.c = c;
	}

	@Override
	public String toString() {
		return "C [c=" + c + ", a=" + a + "]";
	}
}

class D extends B {
	int d;

	public D(int a, int b, int d) {
		super(a, b);
		this.d = d;
	}

	@Override
	public String toString() {
		return "D [d=" + d + ", b=" + b + ", a=" + a + "]";
	}
}

class E extends B {
	int e;

	public E(int a, int b, int e) {
		super(a, b);
		this.e = e;
	}

	@Override
	public String toString() {
		return "E [e=" + e + ", b=" + b + ", a=" + a + "]";
	}
}

class F extends C {
	int f;

	public F(int a, int c, int f) {
		super(a, c);
		this.f = f;
	}

	@Override
	public String toString() {
		return "F [f=" + f + ", c=" + c + ", a=" + a + "]";
	}
}

class G extends C {
	int g;

	public G(int a, int c, int g) {
		super(a, c);
		this.g = g;
	}

	@Override
	public String toString() {
		return "G [g=" + g + ", c=" + c + ", a=" + a + "]";
	}
}

public class Ch07UpDownCastingMain {

	public static void UpDownCastTestFunc(A obj, int... arg) {
		// 괄호 안에 (A) obj 가 필요하지 않은 이유는 int a 같은 느낌이다.

		obj.a = arg[0];
//		obj.b = arg[1];// 안되는 이유는 arg[1]을 A클래스인 ob1이 받을 수 없기 때문. 아래처럼 형변환을 해줘야 한다.

		if (obj instanceof B) {
			B downB = (B) obj;
			downB.b = arg[1];
		}
		if (obj instanceof C) {
			C downC = (C) obj;
			downC.c = arg[1];
		}
		if (obj instanceof D) {
			D downD = (D) obj;
			downD.b = arg[1];
			downD.d = arg[2];
		}
		if (obj instanceof E) {
			E downE = (E) obj;
			downE.b = arg[1];
			downE.e = arg[2];
		}
		if (obj instanceof F) {
			F downF = (F) obj;
			downF.c = arg[1];
			downF.f = arg[2];
		}
		if (obj instanceof G) {
			G downG = (G) obj;
			downG.c = arg[1];
			downG.g = arg[2];
		}

		System.out.println(obj.toString());
	}

	public static void main(String[] args) {
		A ob1 = new A(0);
		B ob2 = new B(0, 0);
		C ob3 = new C(0, 0);
		D ob4 = new D(0, 0, 0);
		E ob5 = new E(0, 0, 0);
		F ob6 = new F(0, 0, 0);
		G ob7 = new G(0, 0, 0);

		UpDownCastTestFunc(ob1, 10);
		UpDownCastTestFunc(ob2, 10, 20);
		UpDownCastTestFunc(ob3, 30, 40);
		UpDownCastTestFunc(ob4, 50, 60, 70);
		UpDownCastTestFunc(ob5, 80, 90, 100);
		UpDownCastTestFunc(ob6, 110, 120, 130);
		UpDownCastTestFunc(ob7, 140, 150, 160);
	}
}