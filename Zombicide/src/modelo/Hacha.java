package modelo;

import java.util.ArrayList;

public class Hacha extends Arma {
	
	public Hacha (String name, int damage, int range, int accuaricy) {
		super(name,damage,range,accuaricy);
	}
	
	//sobreescribir el metodo de specialSkill para cada tipo de arma
	public boolean specialSkill (ArrayList<Zombie>zombies) {
		boolean ok = true;
		for (int i = 0; i < zombies.size() && ok; i++) {
			if (zombies.get(i).getType().equalsIgnoreCase("Gordo")) {
				zombies.get(i).zombieDead();
				System.out.println("has matado a un gordo");
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
