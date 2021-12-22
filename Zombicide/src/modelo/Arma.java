package modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arma {

	private String name;
	private int damage; //va del 1 al 3
	private int range;
	private int accuracy;
	
	
	public Arma () {
		this.name = "daga";
		this.damage = 1;
		this.range = 1;
		this.accuracy = 4;
	}
	
	public Arma (String name, int damage, int range, int accuracy) {
		this.name = name;
		this.damage = damage;
		this.range = range;
		this.accuracy = accuracy;
	}
	
	//Si retorna true no se ha podido utilizar la habilidad o no hay y se le vuelve a pedir al usuario una eleccion del menu
	public boolean specialSkill (ArrayList<Zombie>zombies) {
		System.out.println("No hay habilidad especial");
		return true;
	}
	
	public void getStatsArma() {
		System.out.print(this.name + " Dano:" + this.damage + " Dist:" + this.range + "Acier:" + this.accuracy);
	}
	
	//funcion para atacar a un zombie
	protected void atacar (ArrayList<Zombie>zombies) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random ();
		while (this.range > 0) {
			int indice = rand.nextInt(zombies.size()); 
			if (zombies.get(indice).getZombieHp() <= this.damage) {
				int kill = rand.nextInt(5)+1;
				int zombie = rand.nextInt(zombies.size());
				if (kill >= this.accuracy) {
					System.out.println("Has matado a un " + zombies.get(zombie).getType() + "\n");
					zombies.get(zombie).zombieDead();
				}else {
					System.out.println("Ha fallado tu ataque con un " + zombie);
				}
				
			}else {
				System.out.println(zombies.get(indice).getType() + " ha esquivado tu ataque");
			}
			range--;
		}
	}
	
	public String getNombreArma () {
		return this.name;
	}
	
	public int getDmg() {
		return this.damage;
	}
	
	public int getRange () {
		return this.range;
	}
	
	@Override
	public String toString() {
		return this.name + " damage=" + this.damage + " range=" + this.range + " accuracy=" + this.accuracy + "]";
	}
}
	

                                                                                                     
                                                                                                 
                                                                                              
                                                                                                    
                                                                                                                                                                                                                                         
                                                 
