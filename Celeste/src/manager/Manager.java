package manager;

import java.util.ArrayList;
import model.*;
import dao.*;

public class Manager {

	private Reader r;
	private Reader r1;
	private Writer w;
	private ArrayList <Personajes> numPers;
	private ArrayList <Personajes> pers;
	private ArrayList <String> elem;

	public Manager() {
		numPers = new ArrayList <Personajes>();
		pers = new ArrayList <Personajes>();
		elem = new ArrayList <String>();
		r = new Reader ("files/personajes.txt");
		r1 = new Reader ("files/elementos.txt");
		w = new Writer ("files/resultadoElemental.txt");
	}

	public void init () {
		moveToArrayList();
		numPers();
		numElem();
		reactElement();
		w.closeWriter();
	}
	/**
	 * Lee todo el contenido del fichero de personajes.txt y lo pasa a un arrayList
	 */
	public void moveToArrayList() {
		String persona = "";
		while ((persona = r.readPers()) != null) {
			String [] parts = persona.split(" ");
			numPers.add(new Personajes (parts[0],parts[1]));
		}
		r.closeReader();
	}
	
	/**
	 * Print del numero de personajes,
	 * lo hago como una función pork lo pone en la práctica, aunque no creo que sea rentable hacer la función
	 */
	public void numPers () {
		System.out.println("Total de personajes: " + numPers.size());
		w.write("Total de personajes: " + numPers.size() + "\n");
	}
/**
 * La funcion empieza comprobando si el elemento del ArrayList de personajes esta dentro del ArrrayList de elementos.
 * Si el elemento esta registrado en el ArrayList se incrementa su cantidad y si no lo esta se añade
 */
	private void numElem () {
		pers.add(new Personajes (numPers.get(0).getName(), numPers.get(0).getElement()));
		int pos = 0;
		boolean same = false;
		String prov = "";
		for (int i = 1; i < numPers.size(); i++) {
			prov = numPers.get(i).getElement();
			for (int j = 0; j < pers.size(); j++) {
				if (prov.equalsIgnoreCase(pers.get(j).getElement())) {
					same = true;
					pos = j;
					j = pers.size();
				}else {
					same = false;
				}
			}
			
			if (same) {
				pers.get(pos).masUno();
			}else {
				pers.add(new Personajes (numPers.get(i).getName(),numPers.get(i).getElement()));
			}
		}
		
		System.out.println("Total de elementos utilizados:" + pers.size());
		w.write("Total de elementos utilizados: " + pers.size() + "\n");
			for (int k = 0; k < pers.size(); k++) {
				System.out.println(pers.get(k).toString());
				w.write(pers.get(k).toString() + "\n");
			}
	}
	/**
	 * tilizando un ArrayList guardo todos los elementos, Utilizando un switch
	 * compruebo si se da alguna de las reacciones y las escribo en el fichero, 
	 * sino paso a la siguiente combinación de letras. 
	 */
	private void reactElement () {
		int letra;
		while ((letra = r1.readCharEle()) != -1) {
			elem.add(Character.toString((char)letra));
		}
		r1.closeReader();
		for (int i = 0; i < elem.size()-1; i++) {
			switch (elem.get(i) + elem.get(i+1)) {
				case "FA": case "AF":
					System.out.println("Evaporacion");
					w.write("Evaporacion\n");
					i++;
					break;
				case "FH": case "HF":
					System.out.println("Derretido");
					w.write("Derretido\n");
					i++;
					break;
				case "FR": case "RF":
					System.out.println("Sobrecarga");
					w.write("Sobrecarga\n");
					i++;
					break;
				case "RA": case "AR":
					System.out.println("Electro-carga");
					w.write("Electro-carga\n");
					i++;
					break;
				case "RH": case "HR":
					System.out.println("Superconductor");
					w.write("Superconductor\n");
					i++;
					break;
				case "AH": case "HA":
					System.out.println("Congelar");
					w.write("Congelar\n");
					i++;
					break;
				case "FN": case "NF":
					System.out.println("Quemadura");
					w.write("Quemadura\n");
					i++;
					break;
				case "VF": case "VR": case "VA": case "VH": case "FV": case "RV": case "AV": case "HV":
					System.out.println("Torbellino");
					w.write("Torbellino\n");
					i++;
					break;
				case "TF": case "TR": case "TA": case "TH": case "FT": case "RT": case "AT": case "HT":
					System.out.println("Cristalizar");
					w.write("Cristalizar\n");
					i++;
					break;
			}
		}
	}

}















