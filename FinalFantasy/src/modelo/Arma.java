package modelo;
import java.util.Scanner;

import javax.swing.JOptionPane;

import main.Recursos;

import java.util.ArrayList;

public class Arma {
	private ArrayList<Habilidad> skills;
	private String nombre;
	private String tipoArma;
	
	public Arma() {
		skills = new ArrayList<Habilidad>();
		this.tipoArma = Recursos.getTipoArma();
		this.nombre = Recursos.getNombreArma();
	}
	
	public void menu () {
		Scanner sc = new Scanner(System.in);
		boolean ok = true;
		
		while (ok) {
			System.out.println("  -- Menu Arma --");
			System.out.println("    1- Mostrar habilidades");
			System.out.println("    2- Crear nueva habilidad");
			System.out.println("    0- Salir");
			switch (sc.nextInt()) {
				case 0:
					ok = false;
					break;
				
				case 1:
					mostrarHabilidades();
					break;
				
				case 2:
					nuevaHabilidad();
					break;
					
				default:
					System.out.println("Selecciona una opcion valida");
			}
		}
	}
	
	private void nuevaHabilidad() {
		Habilidad hab = new Habilidad();
		skills.add(hab);
		System.out.println("hab anadidad");
	}
	
	@Override
	public String toString() {
		return "Arma: " + this.nombre+"( " + this.tipoArma + " )";
	}

	private void mostrarHabilidades() { 
		if (skills.size() == 0) {
			System.out.println("No hay habilidades a mostrar");
		}else {
			for (int i = 0; i < skills.size(); i++) {
				System.out.println(skills.get(i).toString());
			}
		}
	}
	
	public int getHabilidadesLength() {
		return skills.size();
	}
	
	public Habilidad getHabilidades (int a) {
		return skills.get(a);
	}
	
}
