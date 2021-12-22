package modelo;

import java.util.ArrayList;

public class Arco extends Arma{

	private String skill;
	
	//ejemplo de new algun hijo:
	// Arma a = new Arco ("habilidad","otro parametro","y otro por probar");
	//Este new tendra la habilidad del arco pero los otros parametros k estan en arco se cojeran del constructor de arma
	//revisar si sigue cojiendo la habilidad k tenga el arco si ya la tiene definida
	
	public Arco(String name, int damage, int range, int accuaricy) {
		super(name,damage,range,accuaricy);
		this.skill = "Mata gratis a un corredor";
	}
	
	//sobreescribir el metodo de specialSkill para cada tipo de arma
	public boolean specialSkill (ArrayList<Zombie>zombies) {
		boolean ok = true;
		for (int i = 0; i < zombies.size() && ok; i++) {
			if (zombies.get(i).getType().equalsIgnoreCase("Corredor")) {
				zombies.get(i).zombieDead();
				System.out.println("has matado a un corredor");
				ok = false;
			}
		}
		if (ok) {
			return true;
		}else {
			return false;
		}
	}

}