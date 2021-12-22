package manager;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import modelo.*;

public class Manager {

	ArrayList <Jugador> characters;
	ArrayList <Jugador> players;
	ArrayList <Arma> armas;
	
	public Manager () {
		this.characters = new ArrayList<Jugador>();
		this.players = new ArrayList<Jugador>();
		this.armas = new ArrayList<Arma>();
		this.armas.add(new Arma ());
	}
	
	public void init () {
		Scanner sc = new Scanner (System.in);
		boolean out = false;
		initPersonajes();	
		initArmas();
		
		while (!out) {
			System.out.println(" 1- Nueva partida \n 2- Nuevo Personaje \n 0- Salir");
			switch (sc.nextInt()) {
				case 0:
					out = true;
					break;
				case 1:
					nuevaPartida();
					out = true;
					break;
				case 2:
					nuevoPersonaje();
					break;
					default:
						System.out.println("Selecciona una opcion valida");
						break;
			}
		}
	}

	//Inicia una nueva partida
	private void nuevaPartida () {
		selectPersonajes();
		Partida partida = new Partida (players,players.size());	
		partida.setPlayers(players);
		partida.menu();
	}
	
	//Para seleccionar los personajes que van a estar en la partida
	private void selectPersonajes () {
		
		Scanner sc = new Scanner (System.in);
		boolean out = false;
		
		if (players.size() <= 6) {
			System.out.println(" 1- Elegir mas personajes (maximo 6) \n 2- Empezar partida");
			
			while (!out) {
				switch (sc.nextInt()) {
					case 1:
						morePlayers();
						out = true;
						break;
					case 2:
						if (players.size() == 0) {
							for (int i = 0; i < characters.size() ;i++) {
								players.add(characters.get(i));
							}
							System.out.println("Todos los personajes han sido seleccionados");
							out = true;
						}else if (players.size() < 3) {
							System.out.println("Te faltan personajes para iniciar la partida \n(Recuerda que debes tener un minimo de 3 y un maximo de 6)");
						}else {
							System.out.println("Todos los personajes han sido seleccionados ");
							out = true;
						}
						break;
						
					default:
						System.out.println("Selecciona una opcion valida");
						break;
				}
				
				if (players.size() == 6) {
					out = true;
				}
			}	
		}
	}
	
	//El case 1 de la funcion selectPersonaje: añade un personaje a los personajes de la partida
	private void morePlayers() {
		Scanner sc = new Scanner(System.in);
		boolean ok = false;
		boolean out = false;
		boolean out2 = false;
		
		while (!ok) {
			out2 = false;
			while (!out2) {
				System.out.println("Elige un minimo de 3 jugadores y un maximos de 6:");
				for (int i = 0; i < characters.size(); i++) {
					System.out.println(i+1 + "- " + characters.get(i));
				}
				int select = sc.nextInt()-1;
				int largo = characters.size(); 
				if (select < largo && select >= 0) {
					players.add(characters.get(select));
					characters.remove(select);
					out2 = true;
				}else {
					System.out.println("Selecciona un personaje");
				}
			}
			if (players.size() >= 3 && characters.size() > 0) {
				while (!out) {
					System.out.println("Quieres seleccionar mas? \n1- Si \n2- No");
					int num = sc.nextInt();
					if (num == 1) {
						out = true;
					}else if (num==2) {
						out = true;
						ok = true;
					}else {
						System.out.println("selecciona una opcion valida");
					}
				}
			}
			if (players.size() >= 3 && characters.size() == 0) {
				ok = true;
				System.out.println("No hay mas personajes para elegir asi que empezara la partida");
			}
		}
	}
	
	
	//Crear un nuevo personaje de cero
	private void nuevoPersonaje () {
		Scanner sc = new Scanner (System.in);
		if (characters.size() < 10) {
			System.out.println("Introduce el nombre del personaje");
			Jugador pj = new Jugador (sc.nextLine(),5);
			characters.add(pj);
		}else {
			System.out.println("Ya has creado el maximo de personajes \n");
		}
	}
	

	
	//crear Armas especiales
	private void initArmas () {
		Arma longbow = new Arco  ("Arco Largo",1,2,3);
		Arma dobleAxe = new Hacha ("Hacha Doble",2,1,3);
		Arma fireball = new Hechizo ("Bola de fuego",1,3,4);
		Arma shortSword = new Espada ("Espada corta",1,1,4);
		armas.add(longbow);
		armas.add(dobleAxe);
		armas.add(fireball);
		armas.add(shortSword);
	}
	
	//crear los personajes default
	private void initPersonajes () {
		Jugador james = new Jugador ("James",7,"Mandoble",2,1,4);
		Jugador marie = new Jugador ("Marie",5);
		Jugador jaci = new Jugador ("Jaci",5);
		characters.add(james);
		characters.add(marie);
		characters.add(jaci);
	}
	
	public ArrayList getPlayers () {
		return players;
	}
	


}
