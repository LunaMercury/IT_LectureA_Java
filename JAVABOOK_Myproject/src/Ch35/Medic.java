package Ch35;

public class Medic extends Unit {

	int hp = 150;
	int armor = 0;

	void healing(Marine marine) {
		if (!marine.isDead) {
			if (marine.hp > 100) {
				System.out.println("체력 가득");
			} else {
				System.out.println("Marine hp 회복, 현재 hp : " + marine.hp);
				marine.hp += 15;
			}
		}
	}

	@Override
	public void move() {
		System.out.println(type + "이동합니다.");
	}

	@Override
	public int underAttack(int damage) {
		return 0; // 메딕은 공격받지 않음
	}
}
