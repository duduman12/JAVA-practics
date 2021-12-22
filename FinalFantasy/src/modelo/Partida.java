package modelo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;

public class Partida {
	private ArrayList<Personaje> personajes;
	private Date nombre;
	private String tiempo;
	
	//TODO acabar los extrta si da tiempo
	public Partida() {
		personajes = new ArrayList<Personaje>();
		this.tiempo = "0";
		this.nombre = new Date();
	}


	@Override
	public String toString() {
		return nombre + " de " + tiempo + " segundos ";
	}
	public void menu () {
		long start = System.currentTimeMillis();
		boolean ok = true;
		Scanner sc = new Scanner(System.in);
		while (ok) {
			System.out.println("   -- Menu Partida");
			System.out.println("     1- Mostrar personajes");
			System.out.println("     2- Crear nuevo personaje");
			System.out.println("     3- Seleccionar personaje");
			System.out.println("     4- Iniciar batalla");
			System.out.println("     0- Salir");
			switch (sc.nextInt()) { 
				case 0:
					setTiempo(start);
					ok = false;
					break;
					
				case 1:
					mostrarPersonajes();
					break;
					
				case 2:
					nuevoPersonaje();
					break;
					
				case 3:
					seleccionarPersonaje();
					break;
					
				case 4:
	                iniciarBatalla();
	                break;
					
				default:
					ok = false;
					break;
			}
		}
	}
	
	public void Victoria(int i, int nivel, int poder) {
        System.out.println("El jugador ha ganado la batalla, por lo tanto el nivel y el poder pasan de: " + nivel + " " + poder);
        nivel=nivel+1;
        poder=poder+2;
        personajes.get(i).setNivel(nivel);
        personajes.get(i).setPoder(poder);
        System.out.print("a " + nivel + " " + poder);
    }
	
	private void nuevoPersonaje() {
		Personaje pers = new Personaje();
		personajes.add(pers);
		pers.menu();
	}
	
	private void mostrarPersonajes() {
		if (personajes.size() == 0) {
			System.out.println("No hay personajes a mostrar");
		}else {
			for (int i = 0; i < personajes.size(); i++) {
				System.out.println(personajes.get(i));
			}
		}
	}
	
	private void seleccionarPersonaje() {
        if(this.personajes.size() >= 1) {
            String[] arrayAux = new String[personajes.size()+1];
            for(int i=0; i<personajes.size(); i++) {
                arrayAux[i] = personajes.get(i).toString();
            }
            arrayAux[personajes.size()] = "Cancelar";
            boolean salir = false;
            while(!salir) {
                Personaje cancelar = new Personaje();
                personajes.add(cancelar);
                int arma = JOptionPane.showOptionDialog(null, "Seleccion de Personajes", "Personajes", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, arrayAux, null);
                if(arma == -1) {
                    System.out.println("No cierres la ventana, selecciona una opcion");
                } else if(arma == arrayAux.length-1){
                    System.out.println("Has cancelado la eleccion de personajes");
                    salir = true;
                } else {
                    System.out.println("Accediendo al menu de la partida que acabas de seleccionar");
                    salir = true;
                }
            }
            
        } else System.out.println("Primero crea un personaje!");
            
    }
	
	private String finPartida(long start) {
		long stop = System.currentTimeMillis();
		long totalTime = stop - start;
		long segundosPartida = totalTime / 1000;
		return " segundos: " + segundosPartida;
	}
	
	private void iniciarBatalla () {
		Random rd = new Random();
        for(int i=0; i<personajes.size();i++) {
            int defensa = rd.nextInt(personajes.get(i).getPoder()+1);
            System.out.println("El random de batalla es: " + defensa);
            if(defensa<=personajes.get(i).getNivel()) {
                Victoria(i,personajes.get(i).getNivel(),personajes.get(i).getPoder());
            }
        }
	}
		
	
	public void setTiempo(long start) {
		this.tiempo = finPartida(start);
	}
	
	public int getPersonajesLength() {
		return personajes.size();
	}
	
	public Personaje getPersonaje(int a) {
		return personajes.get(a);
	}
	
}
