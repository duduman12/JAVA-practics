package modelo;

import java.util.ArrayList;
import modelo.Arma;

public class Jugador extends Humanoide {


	 ArrayList <Arma> armas;
	 Arma armaActiva;
	
	public Jugador(String name, int maxHp) {
		super(name, maxHp);
		this.armas = new ArrayList <Arma> ();
		Arma a = new Arma ();
		this.armas.add(a);
		this.armaActiva = a;
	}
	
	public Jugador (String name, int maxHp, String arma, int dmg, int range,int accuaricy) {
		super(name, maxHp);
		this.armas = new ArrayList <Arma> ();
		Arma a = new Arma (arma,dmg,range,accuaricy);
		this.armas.add(a);
		this.armaActiva = a;
	}
	
	public int getHp () {
		return super.hp;
	}

	public Arma getArma() {
		return this.armas.get(0);
	}

	public ArrayList <Arma> getArrayListArma() {
		return this.armas;
	}
	
	public Arma getArmaActiva () {
		return armaActiva;
	}
	
	public void wounded (int dmg) {
		this.hp = this.hp - dmg;
	}
	
	public String getNamePlayer() {
		return this.name;
	}
	
	public int getMaxHp () {
		return this.maxHp;
	}
	
	@Override
	public String toString() {
		return  "Jugador:" + this.name + " HP:" + this.hp + " arma [" + this.armaActiva.toString() + "]";
	}

}
