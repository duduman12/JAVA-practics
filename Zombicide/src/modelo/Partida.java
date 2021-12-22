package modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import utils.*;

public class Partida {

	private ArrayList <Jugador>players;
	private ArrayList <Zombie> zombies;
	private ArrayList <Humanoide> muertos;
	private int round;
	private int dificulty;
	private boolean search;
	
	public Partida (ArrayList <Jugador> players,int dificulty) {
		this.players = players;
		this.round = 0;
		this.dificulty = dificulty;
		this.search = false;
		this.zombies = new ArrayList<Zombie>();
		this.players = new ArrayList<Jugador>();
		this.muertos = new ArrayList<Humanoide>();
	}
	
	//Menu de la partida
	public void menu () {
		initZombie(this.dificulty);
		boolean out = false;
		while (!out) {
			for (int j = 0; j < players.size();j++) {
				System.out.println("-----|| Nivel: " + this.dificulty + "  Ronda:" + this.round + "  ||----- \n");
				System.out.print("==|| ");
				for (int i = 0; i < zombies.size(); i++) {
					System.out.print(zombies.get(i).getType() + " ");
				}
				System.out.println("||==");
				System.out.println(players.get(j).toString());
				System.out.println("1- Atacar "
						+ "\n2- Habilidad especial "
						+ "\n3- Buscar  "
						+ "\n4- Cambiar Arma "
						+ "\n0- Pasar");
				 turno(j,players.get(j).getArrayListArma());
				 search = false;
			}
			turnoZombies();
			if (players.size() == 0) {
				System.out.println("Han muerto todos los jugadores \n           GAME OVER");
				out = true;
			}
			this.round++;
		}
	}
	
	//Turno de los zombies
	//Extra: Si muere un jugador se transforma en zombie con todas sus estadisticas,
	//cambiando su arma y habilidad especial
	private void turnoZombies () {
		Random rand = new Random();
		for (int i = 0; i < zombies.size(); i++) {	
			int objetivo = rand.nextInt(players.size());
			for (int j = 0; j < zombies.get(i).getMov(); j++) {
				players.get(objetivo).wounded(zombies.get(i).getDmg());
				System.out.println(zombies.get(i).getType() + " ha atacado a " + players.get(objetivo).getNamePlayer() + " y le ha hecho " + zombies.get(i).getDmg() + " puntos de dano");
			}
		}
		for (int k = 0; k < players.size(); k++) {
			if (players.get(k).getHp() <= 0) {
				muertos.add(players.get(k));
				Zombie player = new PlayerZombie(players.get(k).getNamePlayer(),players.get(k).getMaxHp(), players.get(k).getArmaActiva().getDmg(), players.get(k).getArmaActiva().getRange());
				players.remove(k);
				zombies.add(player);
				muertos.remove(0);
				System.out.println(zombies.get(zombies.size()-1).getType() + " ha sido asesinado por un zombie y se ha unidos a ellos");
			}
		}
		System.out.println();
	}
	
	//Turno de cada personaje
	private void turno (int j,ArrayList<Arma>armas) {
		Scanner sc = new Scanner (System.in);
		boolean out = false;
		while (!out) {
			switch (sc.nextInt()) {
				case 0:
					out = true;
					break;
				
				case 1:
					players.get(j).getArma().atacar(zombies);
					out = true;
					break;
				
				case 2:
					if (!players.get(j).getArma().specialSkill(zombies)) {
						players.get(j).getArma().specialSkill(zombies);
						for (int i = 0; i < zombies.size(); i++) {
							if (zombies.get(i).isAlive()) {
								zombies.remove(i);
							}
						}
						out = true;
					}
					break;
				
				case 3:
					if (!this.search) {
						buscar(armas);
					}else {
						System.out.println("Ya has buscado en esta ronda");
					}
					break;
				
				case 4: 
					cambiarArma(armas,players.get(j).getArmaActiva());
					out = true;
					break;
				
				default:
					break;
			}
		}
	}
	
	//Extra:Busca un arma, si tiene mas de 6 le avisa de k no tiene suficiente espacio para mas 
	// y le pregunta si quiere cambiar el arma encontrada por una que ya tenga o si la quiere desechar
	private void buscar (ArrayList <Arma> armas) {
		if (armas.size() <= 6) {
			metodosArma.getArmaRandom(armas);
		}else {
			metodosArma.cambiarArmaRandom(armas);
		}
		yaBuscaste();
	}
	
	private void cambiarArma (ArrayList <Arma> armas,Arma armaActiva) {
		Scanner sc = new Scanner (System.in);
		boolean out = false;
		for (int i = 0; i < armas.size(); i++) {
			System.out.println(i+1 + "- " + armas.get(i) + " ,");
		}
		while (!out) {
			System.out.println("Arma actual:" + armaActiva.getNombreArma());
			int num = sc.nextInt();
			if (num < armas.size()) {
				if (armaActiva == armas.get(num)) {
					System.out.println("Ya tienes esta arma equipada");
				}else {
					armaActiva = armas.get(num);
					System.out.println("te has equipado");
				}
				out = true;
			}
		}
	}
	
	//crear Zombies
	private void initZombie(int dificulty) {
		Random rand = new Random();
		
		for (int i = 0; i < dificulty; i++) {
			int rand1 = rand.nextInt(3);
			if (rand1 == 0) {
				Zombie g = new Gordo ("Gordo",2,1,1);
				zombies.add(g);
			}else if (rand1 == 1) {
				Zombie ca = new Caminante ("Caminante",1,1,1);
				zombies.add(ca);
			}else {
				Zombie co = new Corredor ("Corredor",1,1,2);
				zombies.add(co);
			}
		}
	}
	
	public void setPlayers(ArrayList<Jugador>players) {
		this.players = players;
	}
	
	private void yaBuscaste () {
		this.search = true;
	}
}
