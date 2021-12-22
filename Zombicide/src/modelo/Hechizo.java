package modelo;

import java.util.ArrayList;

public class Hechizo extends Arma{

	public Hechizo(String name, int damage, int range, int accuaricy) {
		super(name,damage,range,accuaricy);
	}
	
	//sobreescribir el metodo de specialSkill para cada tipo de arma
	public boolean specialSkill (ArrayList<Zombie>zombies) {
		boolean ok = true;
		int dead = 0;
		for (int i = 0; i < zombies.size() && ok; i++) {
			if (zombies.get(i).getType().equalsIgnoreCase("Caminantes")) {
				zombies.get(i).zombieDead();
				System.out.println("has matado a un caminantes");
				dead++;
				if (dead == 2) {
					ok = false;
				}
			}
		}
		if (ok) {
			return true;
		}else {
			return false;
		}
	}
}
