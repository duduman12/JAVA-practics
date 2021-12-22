package modelo;

public class Corredor extends Zombie {

	private String skill;
	
	public Corredor(String type, int maxHp, int damage,int mov) {
		super(type, maxHp, damage,mov);
		this.skill = "Mata gratis a un corredor";
	}

	
	
}
