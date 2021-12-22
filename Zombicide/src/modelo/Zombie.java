package modelo;

public class Zombie extends Humanoide {
	
	private int movement;
	private int damage;
	private String type;
	
	public Zombie(String type, int maxHp,int damage,int mov) {
		super("Zombie", maxHp);
		this.type = type;
		this.movement = mov;
		this.damage = damage;
	}
	
	public int getZombieHp() {
		return this.hp;
	}
	
	public String getType () {
		return this.type;
	}
	//Para evitar errores con las habilidades especiales primero cambio la boolean alive 
	//de los zombies y luego los elimino a todos de golpe al final del turno de cada jugadores 
	public void zombieDead() {
		this.alive = false;
	}
	
	public int getMov () {
		return this.movement;
	}
	
	public int getDmg () {
		return this.damage;
	}
	
	public boolean isAlive () {
		return this.alive;
	}
	
}
