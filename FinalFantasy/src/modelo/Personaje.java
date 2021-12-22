package modelo;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import main.Recursos;

public class Personaje {
	private ArrayList<Arma>armas;
	private String nombre;
	private String clase;
	private int nivel;
	private int poder;
	
	public Personaje() {
		armas = new ArrayList<Arma>();
		this.nombre = Recursos.getNombre();
		this.clase = Recursos.getClase();
		this.nivel = 1;
		this.poder = 1;
	}

	public void menu () {

		boolean ok = true;
		Scanner sc = new Scanner(System.in);
		while (ok) {
			System.out.println("  -- Menu Personaje --");
			System.out.println("     1- Mostrar armas");
			System.out.println("     2- Crear nueva arma");
			System.out.println("     3- Seleccionar arma");
			System.out.println("     0- Salir");
			switch (sc.nextInt()) {
				case 0:
					ok = false;
					break;
					
				case 1:
					mostrarArmas();
					break;
				
				case 2:
					nuevaArma();
					break;
					
				case 3:
					seleccionarArma();
					break;
				
				default:
					break;
			}
		}
		
	}
	
	@Override
	public String toString() {
		return nombre + " (" + clase + ")";
	}
	
	private void nuevaArma() {
		Arma a = new Arma ();
		armas.add(a);
		a.menu();
	}
	
	private void mostrarArmas() {
		if (armas.size() == 0) {
			System.out.println("No hay armas a mostrar");
		}else {
			for (int i = 0; i < armas.size(); i++) {
				System.out.println(armas.get(i));
			}
		}
	}
	
	private void seleccionarArma() {
		if (armas.size() == 0) {
			System.out.println("Debes crear un arma primero");
		}else  {
			Object armaArray[] = new Object [armas.size()];
			for (int i = 0; i < armas.size();i++) {
				armaArray[i] = armas.get(i);
			}
			int indice = JOptionPane.showOptionDialog(null, "Nueva arma","Selecciona un arma",JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE,null,armaArray,null);
			armas.get(indice).menu();
		}
	}
	
	public int getArmasLength() {
		return armas.size();
	}
	
	public Arma getArmas(int a) {
		return armas.get(a);
	}
	
	public int getNivel () {
		return this.nivel;
	}
	
	public int getPoder () {
		return this.poder;
	}
	
	public void levelUp () {
		this.nivel++;
		this.poder+=2;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public void setPoder(int poder) {
		this.poder = poder;
		
	}
	
}
