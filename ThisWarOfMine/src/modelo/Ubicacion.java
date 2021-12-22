package modelo;
import java.util.ArrayList;
import java.util.Random;

public class Ubicacion {
	ArrayList<Objeto>recursos;
	int peligrosidad;
	Random rand;
	
	public Ubicacion(int nivel) {
		setPeligrosidad(nivel);
		setRecursos(nivel);
	}
	
	private int setPeligrosidad (int nivel) {
		rand = new Random();
		this.peligrosidad = rand.nextInt(nivel)+1;
		return peligrosidad;
	}
	
	private ArrayList<Objeto> setRecursos(int nivel) {
		rand = new Random();
		recursos = new ArrayList<Objeto>();
		int numObjetos = rand.nextInt(10-nivel)+1;
		for (int i = 0; i < numObjetos; i++) {
			int random = rand.nextInt(100);
			if (random < 10) {
				recursos.add(new Objeto("Armas",1));
			}else if (random >= 10 && random < 40) {
				recursos.add(new Objeto("Comida",1));
			}else if (random >= 40 && random < 55) {
				recursos.add(new Objeto("Medicamentos",1));
			}else {
				recursos.add(new Objeto("Componentes",1));
			}
		}
		return recursos;
	}
			
}
