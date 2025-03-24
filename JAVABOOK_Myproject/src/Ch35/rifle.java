package Ch35;

public class rifle extends Gun {
	public rifle() {
		this.power = 30;
		this.max_BulletCnt = 100;
		this.cur_BulletCnt = max_BulletCnt;
	}

	@Override
	void fire(Unit unit) {
		if (cur_BulletCnt == 0) {
			System.out.println("재장전 필요");
			reload(cur_BulletCnt);
			return;
		}
		this.cur_BulletCnt--;
		System.out.println(unit.type + "을 rifle로 fire!, 남은 총알 : " + cur_BulletCnt);
	}
}