package Ch13;

interface Remocon {
	// interface에서는 abstract를 입력하지 않아도 된다.(입력불가)
	int MAX_VOL = 100; // public static final
	int MIN_VOL = 0; // public static final

	void setVolume(int vol);

	// TV, Radio에 각각 메서드 완성하기
	// MAX_VOL / MIN_VOL을 적용해서 각각 최대볼륨 최소볼륨 제한
	// vod1값이 100을 초과할 때는 최대볼륨값으로 적용(print : "최대볼륨으로 설정")
	// vol1값이 0미만일때는 최소볼륨값으로 적용(print : "최소볼륨으로 설정")
	void powerOn();	

	void powerOff();

	void setVolume();
}

interface Browser {
	void SearchURL(String url);
}

class smartTV extends TV implements Browser {

	@Override
	public void SearchURL(String url) {
		System.out.println(url + " 로 이동합니다.");

	}
}

class TV implements Remocon {

	int vol;

	@Override
	public void powerOn() {
		System.out.println("TV를 켭니다");

	}
	
	@Override
	public void powerOff() {
		System.out.println("TV를 끕니다");

	}

	public void setVolume() {
	}

	@Override
	public void setVolume(int vol) {
		if (vol >= MAX_VOL) {
			System.out.println("최대볼륨으로 설정");
		} else if (vol <= MIN_VOL) {
			System.out.println("최소볼륨으로 설정");
		} else {
			System.out.println("볼륨 " + vol + "으로 설정");
		}
		this.vol = vol;

	}

}

class Radio implements Remocon {

	int vol;

	@Override
	public void powerOn() {
		System.out.println("Radio를 켭니다");

	}

	@Override
	public void powerOff() {
		System.out.println("Radio를 끕니다");

	}

	public void setVolume() {
	}

	@Override
	public void setVolume(int vol) {
		if (vol >= MAX_VOL) {
			System.out.println("최대볼륨으로 설정");
		} else if (vol <= MIN_VOL) {
			System.out.println("최소볼륨으로 설정");
		} else {
			System.out.println("볼륨 " + vol + "으로 설정");
		}
		this.vol = vol;

	}
}

public class C03InterfaceMain {

	// 이 함수 호출이 없으면 tv1.powerOn(); 으로 불러와야 한다
	public static void TurnOn(Remocon controller) {
		controller.powerOn();
	}

	public static void TurnOff(Remocon controller) {
		controller.powerOff();
	}

	public static void setVolume(Remocon controller, int vol) {
		controller.setVolume(vol);
	}

	public static void setVolume(Remocon controller1, int vol1, Remocon controller2, int vol2) {
		controller1.setVolume(vol1);
		controller2.setVolume(vol2);
	}
	
	public static void Internet(Browser browser, String url) {
		browser.SearchURL(url);
	}

	public static void main(String[] args) {
		TV tv1 = new TV();
		smartTV smartTV1 = new smartTV();
		Radio radio1 = new Radio();

		TurnOn(tv1);
		TurnOn(smartTV1);
		TurnOn(radio1);
		System.out.println("--------------------------");

		setVolume(radio1, 200, tv1, 50);
		Internet(smartTV1, "www.naver.com");

		TurnOff(tv1);
		TurnOff(radio1);
	}
}
