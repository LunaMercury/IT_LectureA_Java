package Ch35;

public abstract class Gun {
	int max_BulletCnt;
	int cur_BulletCnt;
	int power;

	abstract void fire(Unit unit);

	void reload(int bullet) {
		this.cur_BulletCnt = max_BulletCnt;
	};	
}