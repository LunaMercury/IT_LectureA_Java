package Ch08;

// 홍길동이				-		사과장수에게 사과를 구매한다.		
// 구매자					-		판매자
// 보유금액(속성)					보유금액(속성)
// 사과갯수(속성)					사과갯수(속성)
//								개당 가격(속성)

// 구매하기(기능)					판매하기(기능)
// 1) 특정 사과장수에게 돈을 건넨다 -> 내 보유금액에서 차감
//								2) 돈을 내 보유금액에 누적
//								3) 사과갯수 계산->나유 보유사과갯수에서 차감
// 4) 나의 보유사과갯수에 누적

class Buyer {
	// 속성
	private int myMoney;
	private int appleCnt;

	// 기능
	public void payment(Seller seller, int money) {
		int appleAmount = money / seller.price;

		// 내 보유금액에서 차감
		this.myMoney -= money;

		// seller에 money를 전달하고 리턴되는 사과 갯수를 누적
		this.appleCnt += appleAmount; // 사과 누적
		seller.receive(money);
		System.out.println("사과를" + appleAmount + "개 구입하였습니다.");
	}

	// -------------------------------------
	// 생성자 및 getter,setter
	public Buyer() {
	}

	public Buyer(int myMoney, int appleCnt) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
	}

	@Override
	public String toString() {
		return "Buyer [myMoney=" + myMoney + ", appleCnt=" + appleCnt + "]";
	}
}

class Seller {
	// 속성
	private int myMoney;
	private int appleCnt;
	public int price;

	// 기능
	public int receive(int money) {
		// 구매자로부터 전달받은 money를 내 보유금액에 누적
		this.myMoney += money;
		// 전달받은 금액/ 사과갯수를 리턴
		this.appleCnt -= money / price;
		return -1;
	}

	// ---------------------------
	// 생성자 및 getter,setter
	public Seller() {
	}

	public Seller(int myMoney, int appleCnt, int price) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
		this.price = price;

		System.out.println("사과를 개당 " + price + "원에 판매중");
	}

	@Override
	public String toString() {
		return "Seller [myMoney=" + myMoney + ", appleCnt=" + appleCnt + ", price=" + price + "]";
	}
}

class trade {
}

public class C10Main {

	public static void main(String[] args) {
		Seller seller1 = new Seller(10000, 100, 1000);

		Buyer 홍길동 = new Buyer(10000, 0);
		Buyer 노홍철 = new Buyer(5000, 0);

		홍길동.payment(seller1, 3000);
		노홍철.payment(seller1, 5000);

		System.out.println(홍길동);
		System.out.println("--------------------");
		System.out.println(노홍철);
		System.out.println("--------------------");
		System.out.println(seller1);
	}
}