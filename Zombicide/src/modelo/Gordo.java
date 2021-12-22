package modelo;

public class Gordo extends Zombie {

	private String skill;
	
	public Gordo(String type, int maxHp, int damage,int mov) {
		super(type, maxHp,damage,mov);
		this.skill = "Permite eliminar a otro gordo al morir";
	}

	
	

}
