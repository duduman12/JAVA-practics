package main;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.*;


public class ThisWarOfMine {

	public static Casa casa;
	public static Scanner sc;
	
	public static void main(String[] args) {
		generateCharacter();
	}

	private static void generateCharacter () {
		ArrayList<Personaje>personajesJugables = new ArrayList<Personaje>(); 
		Personaje personaje = new Personaje ("Arica","Sigilo");
		Personaje personaje2 = new Personaje ("Bruno","Cocinero");
		Personaje personaje3 = new Personaje ("Katia","Elocuencia");
		Personaje personaje4 = new Personaje ("Pavel","Rapidez");
		personajesJugables.add(personaje);
		personajesJugables.add(personaje2);
		personajesJugables.add(personaje3);
		personajesJugables.add(personaje4);
		getCharacters(personajesJugables);
	}
	
	private static void getCharacters (ArrayList<Personaje> personajesJugables) {
		ArrayList<Personaje>personajes = new ArrayList<Personaje>();
		sc = new Scanner(System.in);
		System.out.println("Escoje 3 personajes para jugar:");
		while (personajes.size() != 3) {
			for (int i = 0; i < personajesJugables.size(); i++) {
				System.out.println((i+1) + "- "+personajesJugables.get(i).getNombre()+" | Habilidad: "+ personajesJugables.get(i).getHabilidad());
			}
			System.out.println();
			for (int j = 0; j < personajes.size(); j++) {
				System.out.println("Personajes escojidos: " + personajes.get(j).getNombre() + " | Habilidad: " + personajes.get(j).getHabilidad());
			}
			int num = sc.nextByte()-1;
			boolean haSalido = false;
			for (int k = 0; k < personajesJugables.size(); k++) {
				if (num == k) {
					personajes.add(personajesJugables.get(num));
					personajesJugables.remove(num);
					haSalido = true;
				}
			}
			if (!haSalido) {
				System.out.println("Escoje un personaje disponible");
			}
		}
		
		for (int j = 0; j < personajes.size(); j++) {
			System.out.println("Personajes escojidos: " + personajes.get(j).getNombre() + " | Habilidad: " + personajes.get(j).getHabilidad());
		}
		System.out.println();
		nuevaPartida(personajes);
	}
		
		
	private static boolean checkSalud (ArrayList<Personaje> pers) { 
		for (int i = 0; i < pers.size(); i++) {
			if (pers.get(i).getSalud() == 0) {
				return false;
			}
		}	
		return true;
	}
	
	private static void nuevaPartida(ArrayList<Personaje> personajes) {
		int nivel = 1;
		casa = new Casa ();
		boolean inGame = true;
		//sc = new Scanner(System.in);
		System.out.println("Empieza una partida nueva");
		System.out.println("\n");
		while (inGame == true) {
			if (checkSalud(personajes) == true) {
				mostrarObjetos();
				System.out.println("\n ------------------------------------------------- \n");
				escojerRoles(personajes,generateUbicacion(nivel),nivel);
				nivel++;
			}else {
				inGame = false;
			}
		}
		if (inGame = false) {
			System.out.println("GAME OVER");
		}
	}
	
	private static void escojerRoles(ArrayList <Personaje>personajes,Ubicacion ubi,int nivel) {
		ArrayList<Personaje>roles = new ArrayList<Personaje>();
		menu(personajes,roles);
		roles.get(0).vigilar(nivel);
		roles.get(1).dormir();
		roles.get(2).explorar(ubi);
		checkStats(personajes);
		finDia(personajes);
		
	}
	
	private static void mostrarObjetos() {
		System.out.println("Inventario: \n");
		for (int i = 0 ; i < casa.getObjetos().size(); i++) {
			System.out.println(casa.getObjetos().get(i).toString());
		}
	}
	
	private static Ubicacion generateUbicacion(int nivel) {  
		Ubicacion ubi1 = new Ubicacion(nivel);
		return ubi1;
	}
	
	public static void checkStats (ArrayList<Personaje>pers) {
		for (int i = 0; i < pers.size(); i++) {
			System.out.println(pers.get(i).getNombre());
			System.out.println("Salud :" + pers.get(i).getSalud());
			System.out.println("Hambre: " + pers.get(i).getHambre());
			System.out.println("Sueño: " + pers.get(i).getSueno());
			System.out.println();
		}
		System.out.println("\n -------------------------------------------- \n");
	}

	private static void finDia(ArrayList<Personaje> personajes) {
		boolean ok = true;
		for (int i = 0; i < personajes.size(); i++) {
			for (int j = 0; j < personajes.get(i).mochilaLength(); j++) {
				casa.setObjetos(personajes.get(i).getObjeto(j));
			}
			personajes.get(i).setHambre(1);
		}
			sc = new Scanner(System.in);
			while (ok) {
					if (casa.getHayComida(casa.getInventario())) {
						System.out.println("Quieres que algun personaje coma a cambio de 1 de comida)");
						System.out.println("1 - SI");
						System.out.println("2 - NO");
						int num = sc.nextByte();
						
						if (num == 1) {
							System.out.println("Que personaje va a comer?");
							System.out.println("1" + personajes.get(0).getNombre());
							System.out.println("2" + personajes.get(1).getNombre());
							System.out.println("3" + personajes.get(2).getNombre());
								
								switch (sc.nextByte()) {
									case 1:
										personajes.get(0).restarHambre();
										ok = false;
										break;
										
									case 2:
										personajes.get(1).setHambre(1);
										ok = false;
										break;
										
									case 3: 
										personajes.get(2).setHambre(1);								
										ok = false;
										break;
										
									default:
										break;
								}
						}else if (num == 2) {
							ok = false;
						}else {
							System.out.println("Elige a un personaje valido");
						}
					}else {
						ok = false;
					}
			
			}
			// generar comida
			ok = true;
			while (ok) {
				
					if (casa.getSuficientesComponentes(casa.getInventario())) {
						System.out.println("Quieres generar 2 de comida a cambio de 5 componentes? \n-1 Si \n2- No ");
						int numero = sc.nextByte();
						
						if (numero == 1) {							
							casa.generarComida(casa.getInventario());
							ok = false;
								
						}else if (numero == 2) {
							ok = false;
						}else {
							System.out.println("Elige una opcion valida");
						}
					}else {
						ok = false;
					}
				
			
			}
			//generar medicamento 
			ok = true;
			while (ok) {
					if (casa.getSuficientesComponentes(casa.getInventario())) {
						System.out.println("Quieres crear una cama a cambio de 10 componentes? \n-1 Si \n2- No ");
						int num3 = sc.nextByte();
						
						if (num3 == 1) {	
							casa.generarMedicamento(casa.getInventario());
							ok = false;
								
						}else if (num3 == 2) {
							ok = false;
						}else {
							System.out.println("Elige una opcion valida");
						}
					}else {
						ok = false;
					}
			
			}
			//generar cama
			ok = true;
			while (ok) {
					if (casa.getSuficientesComponentes(casa.getInventario())) {
						System.out.println("Quieres crear una cama a cambio de 10 componentes? \n-1 Si \n2- No ");
						int num3 = sc.nextByte();
						
						if (num3 == 1) {	
							casa.generarCama(casa.getInventario());
							ok = false;
								
						}else if (num3 == 2) {
							ok = false;
						}else {
							System.out.println("Elige una opcion valida");
						}
					}else {
						ok = false;
					}
			
			}
			// curar
			ok = true;
			while (ok) {
					if (casa.getHayMediacmentos(casa.getInventario())) {
						System.out.println("Quieres curar a algun personaje a cambio de 1 medicamento? \n-1 Si \n2- No ");
						int num4 = sc.nextByte();
						
						if (num4 == 1) {
							System.out.println("Que personaje vas a curar?");
							System.out.println("1" + personajes.get(0).getNombre());
							System.out.println("2" + personajes.get(1).getNombre());
							System.out.println("3" + personajes.get(2).getNombre());
								
								switch (sc.nextByte()) {
									case 1:
										personajes.get(0).recuperarSalud();
										ok = false;
										break;
										
									case 2:
										personajes.get(1).recuperarSalud();
										ok = false;
										break;
										
									case 3: 
										personajes.get(2).recuperarSalud();
										ok = false;
										break;
										
									default:
										break;
								}
						}else if (num4 == 2) {
							ok = false;
						}else {
							System.out.println("Elige a un personaje valido");
						}
					}else {
						ok = false;
					}
			
			}
			
			//sumar hambre y sueño
			for (int k = 0; k < personajes.size(); k++) {
				personajes.get(k).restarSaludHambre(personajes.get(k).getHambre());
				personajes.get(k).restarSaludSueno(personajes.get(k).getSueno());
			}
			System.out.println("\n");
	}
						
	
	
	private static void menu (ArrayList<Personaje>personajes,ArrayList<Personaje> roles) {   
		ArrayList<Personaje> persDisp = new ArrayList<Personaje>();
		persDisp.add(personajes.get(0));
		persDisp.add(personajes.get(1));
		persDisp.add(personajes.get(2));
		sc = new Scanner(System.in);									
		boolean isOk = true;	

			System.out.println("Elige que funcion debe hacer cada personaje:");
			
			while (isOk) {
				System.out.println("Ir a explorar: ");
				for (int i = 0; i < persDisp.size(); i++) {
					System.out.print(i+1 + " - " + persDisp.get(i).getNombre()+"\n");
				}
				switch (sc.nextByte()-1) {
					case 0:
						roles.add(persDisp.get(0));
						persDisp.remove(0);
						isOk = false;
						break;
						
					case 1:
						roles.add(persDisp.get(1));
						persDisp.remove(1);
						isOk = false;
						break;
						
					case 2:
						roles.add(persDisp.get(2));
						persDisp.remove(2);
						isOk = false;
						break;
						
						default:
							break;
				}
			}
			isOk = true;
			while (isOk) {
				System.out.println("Quedarse en casa vigilando: ");
				for (int i = 0; i < persDisp.size(); i++) {
					System.out.print(i+1 + " " + persDisp.get(i).getNombre()+"\n");
				}
				switch (sc.nextByte()-1) {
					case 0:
						roles.add(persDisp.get(0));
						persDisp.remove(0);
						isOk = false;
						break;
						
					case 1:
						roles.add(persDisp.get(1));
						persDisp.remove(1);
						isOk = false;
						break;
						
						default:
							break;
				}
			}
			
			isOk = true;
			while (isOk) {
				System.out.println("Quedarse en casa durmiendo:");
				System.out.println(+1 + " " + persDisp.get(0).getNombre());
				int numerito = sc.nextByte();
				if (numerito == 1) {
					roles.add(persDisp.get(0));
					persDisp.remove(0);
					isOk = false;
				}
			}
			System.out.println();
			System.out.println("Explorando:" + roles.get(0).getNombre());
			System.out.println("Durmiendo:" + roles.get(2).getNombre());
			System.out.println("Vigilando:" + roles.get(1).getNombre());
			System.out.println("\n------------------------------------------------------------------------\n");
			
		}


}
