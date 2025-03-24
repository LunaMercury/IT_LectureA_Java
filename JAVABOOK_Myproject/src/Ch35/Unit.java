package Ch35;

public abstract class Unit {
	public int hp;
	public int armor;
	public String type;
	public boolean isDead = false;

	abstract public void move();

	abstract public int underAttack(int damage);	
}
