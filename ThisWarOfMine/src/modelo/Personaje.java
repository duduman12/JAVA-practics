package modelo;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import modelo.Casa;

public class Personaje {
	
	private String nombre;
	private int salud;
	private int hambre;
	private int sueno;
	private String habilidad;
	ArrayList<Objeto>mochila;
	
	
	public Personaje (String name, String habilidad) {
		mochila = new ArrayList<Objeto>();
		this.nombre = name;
		this.salud = 10;
		this.hambre = 1;
		this.sueno = 1;
		this.habilidad = habilidad;
	}
	
	public String getNombre () {
		return this.nombre;
	}
	public String getHabilidad () {
		return this.habilidad;
	}
	public int getSalud () {
		return this.salud;
	}
	public int getHambre () {
		return this.hambre;
	}
	
	public int getSueno () {
		return this.sueno;
	}
	public int mochilaLength () {
		return mochila.size();
	}
	
	public Objeto getObjeto (int a) {
		return this.mochila.get(a);
	}
	public void restarSaludHambre (int a) {
		this.salud = salud - a;
	}
	public void restarSaludSueno (int a) {
		a = a/2;
		this.salud = salud - a;
	}
	
	
	public int vigilar (int nivel){
		Random rand = new Random();
		int random = (rand.nextInt(50)) - nivel;
		if (random <= 5) {
			System.out.println("Asalto!! pierdes 2 de vida");
			salud = salud - 2;
		}
		if (random >= 40 && random <= 50) {
			if (this.habilidad.equals("Elocuencia")) {//extra
				System.out.println("Comerciante!! consigues 3 de comida y 3 de componentes");
				mochila.add(new Objeto ("Comida",3));
				mochila.add(new Objeto("Componentes",3));
			}else {
				System.out.println("Comerciante!! consigues 2 de comida y 2 de componentes");
				mochila.add(new Objeto ("Comida",2));
				mochila.add(new Objeto("Componentes",2));
			}
		}
			
		return this.sueno+1;
	}
	
	public int dormir (){
		return this.sueno-2;
	}
	
	public void explorar (Ubicacion ubi){
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int espacio;
		if (this.habilidad.equals("Rapidez")) {//extra
			espacio = 7;
		}else {
			espacio = 5;
		}
		boolean salir = false;
		for (int i = 0; i < ubi.recursos.size(); i++) {
			System.out.println(" " + i + "-" + ubi.recursos.get(i));
		}
		System.out.println();
		System.out.println("Quieres recoger Objetos?");
		while (espacio > 0 && !salir) {
			if (ubi.recursos.size() == 0) {
				salir = true;
			}else {
				if (espacio < 5 && !this.habilidad.equals("Rapidez")) {
					System.out.println("Quieres seguir recogiendo Objetos?");
				}
				System.out.println("1- SI");
				System.out.println("2- NO");
				int decision1 = sc.nextInt();
				if (decision1 == 1) {
					System.out.println("Introduce el numero del objeto que quieres recoger: \n(recuerda que solo puede coger 5 como maximo) ");
					int num = sc.nextInt();
					if (num <= ubi.recursos.size()-1) {
						mochila.add(ubi.recursos.get(num));
						espacio--;
						ubi.recursos.remove(num);
						System.out.println("Objetos en la mochila \n -");
						for (int k = 0; k < mochila.size(); k++) {
							System.out.println (mochila.get(k));
						}
						System.out.println("\n ----------------------------\n");
						}else {
						System.out.println("Elige uno de los objetos de la lista \n");
					}
					for (int j = 0; j < ubi.recursos.size(); j++) {
						System.out.println(" " + j + "-" + ubi.recursos.get(j));
					}
					System.out.println();
				}else if (decision1 == 2) {
					salir = true;
				}else {
					System.out.println("Elige una opcion valida");
				}
			}
		}
		
		if (this.habilidad.equals("Sigilo")) { //extra
			if (rand.nextInt(ubi.peligrosidad) - 2 > 0) {
				salud = salud - (rand.nextInt(ubi.peligrosidad) - 2);
			}
		}else {
			salud = salud - rand.nextInt(ubi.peligrosidad);//seteo la salud con la peligrosidad
		}
		hambre +=  1;
		sueno += 2;
	}
	
	public int setHambre (int a) {
		return this.hambre = hambre + a;
	}
	
	public int restarHambre () {
		if (this.habilidad.equals("Cocinero")) {
			return this.hambre-2;
		}
		return this.hambre--;
	}
	
	public void recuperarSalud () {
		this.salud++;
	}
	
	
}
