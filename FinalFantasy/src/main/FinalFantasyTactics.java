package main;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import main.Recursos;
import modelo.Arma;
import modelo.Partida;


public class FinalFantasyTactics {

	public static void main(String[] args) {
		menu();
	}
	
	private static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		ArrayList <Partida> partidas = new ArrayList<Partida>();
		boolean salir=false;
		while (!salir) {
			System.out.println("   -- Menú Final Fantasy --"
					+ "\n   1- Mostrar partidas guardadas"
					+ "\n   2- Mostrar info partidas"
					+ "\n   0- Salir del programa");
			switch (sc.nextInt()) {
				case 1:
					mostrarPartidasGuardadas(partidas);
					break;
				
				case 2:
					mostrarInfo(partidas); 
					break;
			
				case 0:
					salir = true;
					break;
				
				default:
					System.out.println("No has escogido una opcion valida \n");
					break;
			}
		}
	}

	private static void mostrarInfo(ArrayList <Partida> par) {
		if (par.size() == 0) {
			System.out.println("No hay partidas guardadas \n");
		}else {
			for (int i = 0; i < par.size(); i++) {
				System.out.println(par.get(i));
				for (int j = 0; j < par.get(i).getPersonajesLength(); j++) {
					System.out.println("           " + par.get(i).getPersonaje(j).toString());
					for (int k = 0; k < par.get(i).getPersonaje(j).getArmasLength(); k++) {
						System.out.println("               " + par.get(i).getPersonaje(j).getArmas(k).toString());
						for (int p = 0; p < par.get(i).getPersonaje(j).getArmas(k).getHabilidadesLength(); p++) {
							System.out.println("                 " + par.get(i).getPersonaje(j).getArmas(k).getHabilidades(p).toString());
						}
					}
				}
			System.out.println();
			}
		}
	}

	private static void mostrarPartidasGuardadas(ArrayList<Partida> par) {
		Object partidasArray [] = new Object [par.size()];
		for (int i = 0; i < par.size(); i++) {
			partidasArray[i] = par.get(i);
		}
		int indice = JOptionPane.showOptionDialog(null,"Selecciona una partida","Partida",JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE,null,partidasArray,null);
		if (indice < 0) {	
			Partida p = new Partida();
			par.add(p);
		}else {
			par.get(indice).menu();
		}
	}
	
}