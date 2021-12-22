package utils;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import modelo.*;

public class metodosArma {

	
	//Crea y añade una arma aleatoria
	public static void getArmaRandom(ArrayList <Arma> armas) {
		Random rand = new Random();
		int random = rand.nextInt(100);
		if (random >= 80 && random < 85) {
			armas.add(new Arco("Arco largo",1,2,3));
			System.out.println("Has encontrado: Arco lago");
		}else if (random >= 85 && random < 90) {
			armas.add(new Hacha("Hacha",2,1,3));
			System.out.println("Has encontrado: Hacha");
		}else if (random >= 90 && random < 95) {
			armas.add(new Hechizo("Bola de fuego",1,3,4));
			System.out.println("Has encontrado: Bola de fuego");
		}else if (random >= 95) {
			armas.add(new Espada("Espada corta",1,1,4));
			System.out.println("Has encontrado: Espada corta");
		}else {
			armas.add(new Arma());
			System.out.println("Has encontrado: Daga" );
		}
	}
	//Pequeño extra: añadir una cantidad maxima de armas que puede llevar un mismo jugador
	public static void cambiarArmaRandom (ArrayList <Arma> armas) {
		String armaTirada = "";
		Random rand = new Random();
		boolean out = false;
		Scanner sc = new Scanner (System.in);
		int random = rand.nextInt(100);
		String arma = "Daga";
		if (random >= 80 && random < 85) {
			arma = "Arco lago";
			System.out.println("Has encontrado: Arco lago");
		}else if (random >= 85 && random < 90) {
			arma = "Hacha doble";
			System.out.println("Has encontrado: Hacha");
		}else if (random >= 90 && random < 95) {
			arma = "Bola de fuego";
			System.out.println("Has encontrado: Bola de fuego");
		}else if (random >= 95) {
			arma = "Espada Corta";
			System.out.println("Has encontrado: Espada corta");
		}else {
			System.out.println("Has encontrado: Daga" );
		}
		
		System.out.println("Tu bolsa esta llena \n"
				+ "Quieres cambiar" + arma + "por una de las que tienes en la bolsa o quieres desechar" + arma + "\n"
				+ "1- Cambiar arma \n"
				+ "2- Tirar arma \n"
				+ "0- Volver");
		
		switch (sc.nextInt()) {
			case 1:
				System.out.println("Por que arma la quieres cambiar?");
				for (int i = 0; i < armas.size(); i++) {
					System.out.print(i+1 + "- " + armas.get(i));
				}
				while (!out) {
					int num = sc.nextInt();
					if (num < armas.size()) {
						armaTirada = armas.get(num).getNombreArma();
						armas.remove(num);
						if (arma.equalsIgnoreCase("Daga")) {
							armas.add(new Arma());
						}else if (arma.equalsIgnoreCase("Arco largo")) {
							armas.add(new Arco("Arco largo",1,2,3));
						}else if (arma.equalsIgnoreCase("Hacha doble")) {
							armas.add(new Hacha("Hacha doble",2,1,3));
						}else if (arma.equalsIgnoreCase("Bola de fuego")) {
							armas.add(new Hechizo("Bola de fuego",1,3,4));
						}else {
							armas.add(new Espada("Espada corta",1,1,4));
						}
						System.out.println("Has tirado" + armaTirada);
						System.out.println("Has obenido: " + armas.get(armas.size()-1));
						out = true;
					}
				}
				break;
				
			case 2:
				System.out.println("Has tirado el arma: " + armaTirada);
				break;
				
			default:
				break;
		}
	}
	
}
