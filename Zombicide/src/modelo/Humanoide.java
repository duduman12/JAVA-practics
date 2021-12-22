package modelo;

public class Humanoide {
	
	protected String name; 
	protected int hp;
	protected int maxHp;
	protected boolean alive;
	
	public Humanoide (String name, int maxHp) {
		this.name = name;
		this.maxHp = maxHp;
		this.alive = true;
		this.hp = this.maxHp;	
	}
	
}
