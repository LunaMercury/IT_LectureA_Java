package Ch35;

public class Marine extends Unit {

	public Marine() {
		this.type = "Marine";
	}

	int hp = 100;
	int armor = 5;

	Gun myGun;
	int damageVal;

	void setGun(Gun gun) {
		this.myGun = gun;
		this.damageVal = gun.power;
	}

	void setType(String type) {
		this.type = type;
	}

	void attack(Unit unit) {
		if (!isDead) {
			myGun.fire(unit);
			unit.underAttack(damageVal);
		}

	}

	@Override
	public void move() {
		System.out.println(type + "이동합니다.");
	}

	@Override
	public int underAttack(int damage) {
		System.out.println("we're underattack!");
		if (hp - damage + armor > 0) {
			this.hp -= damage + armor;
			System.out.println("남은 hp : " + this.hp);
		} else {
			hp = 0;
			this.isDead = true;
			System.out.println(type + "dead");
		}
		return hp;
	}
}