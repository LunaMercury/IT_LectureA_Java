package Ch35;

public abstract class Building {
	public int hp;
	public int sheld;
	public int armor;
	
	// 건물짓기
	abstract void BuildStructure();
	
	// 공격당함
	abstract void underAttack(Unit unit);
}
