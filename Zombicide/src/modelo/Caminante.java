package modelo;

public class Caminante extends Zombie {

	private String skill;
	
	public Caminante(String type, int maxHp, int damage,int mov) {
		super(type, maxHp,damage,mov);
		this.skill = "Invoca a tantos caminantes como hay (dobla la cantidad de caminantes vivos)";
		
	}

	
}


