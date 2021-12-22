package modelo;
import java.util.ArrayList;
import modelo.Objeto;

public class Casa {
	boolean cama;
	ArrayList<Objeto>inventario;
	
	public Casa () {
		this.cama = false;
		inventario = new ArrayList<Objeto>();
	}
	
	private void mostrarObjetosCasa (ArrayList<Objeto> obj) {
		for (int i = 0; i < inventario.size(); i++) {
			System.out.println(inventario.get(i));
		}
	}
	
	public ArrayList<Objeto> getObjetos () {
		return this.inventario;
	}
	
	public boolean getHayComida(ArrayList<Objeto> objetos) {
		for (int i = 0; i < objetos.size(); i++) {
			if (objetos.get(i).getTipo().equals("Comida") && objetos.get(i).getCantidad() == 1) {
				objetos.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean getHayMediacmentos(ArrayList<Objeto> objetos) {
		for (int i = 0; i < objetos.size(); i++) {
			if (objetos.get(i).getTipo().equals("Medicamentos") && objetos.get(i).getCantidad() == 2) {
				objetos.get(i).setCantidad(1);
				return true;
			}
		}
		return false;
	}
	
	public boolean getSuficientesComponentes (ArrayList<Objeto> objetos) {
		int comp = 0;
		for (int i = 0; i < objetos.size(); i++) {
			if (objetos.get(i).getTipo().equals("Componentes") && objetos.get(i).getCantidad() == 1) {
				comp++;
			}
			if (objetos.get(i).getTipo().equals("Componentes") && objetos.get(i).getCantidad() == 2) {
				comp+=2;
			}
		}
		if (comp >= 5) {
			return true;
		}
		return false;
	}
	public boolean getSuficientesComponentesDoble (ArrayList<Objeto> objetos) {
		int comp = 0;
		for (int i = 0; i < objetos.size(); i++) {
			if (objetos.get(i).getTipo().equals("Componentes") && objetos.get(i).getCantidad() == 1) {
				comp++;
			}
			if (objetos.get(i).getTipo().equals("Componentes") && objetos.get(i).getCantidad() == 2) {
				comp+=2;
			}
		}
		if (comp >= 10) {
			return true;
		}
		return false;
	}

	
	public ArrayList<Objeto> getInventario () {
		return this.inventario;
	}
	
	public int getInventarioLength () {
		return this.inventario.size();
	}

	public void setObjetos (Objeto obj) {
		inventario.add(obj);
	}
	
	public void generarComida (ArrayList<Objeto>obj) {
		int deleted = 0;
		for (int i = 0; i < obj.size(); i++) {
			if (deleted >= 5) {
				if (obj.get(i).getTipo().equals("Componentes") && obj.get(i).getCantidad() == 1) {
					deleted++;
					obj.remove(i);
					i--;
				}
				if (obj.get(i).getTipo().equals("Componentes") && obj.get(i).getCantidad() == 2) {
					deleted+=2;
					obj.remove(i);
					i--;
				}
			}
		}
		obj.add(new Objeto("Comida",2));
	}
	
	public void generarMedicamento (ArrayList<Objeto>obj) {
		int deleted = 0;
		for (int i = 0; i < obj.size(); i++) {
			if (deleted >= 5) {
				if (obj.get(i).getTipo().equals("Componentes") && obj.get(i).getCantidad() == 1) {
					deleted++;
					obj.remove(i);
					i--;
				}
				if (obj.get(i).getTipo().equals("Componentes") && obj.get(i).getCantidad() == 2) {
					deleted+=2;
					obj.remove(i);
					i--;
				}
			}
		}
		obj.add(new Objeto("Medicamentos",1));
	}
	
	public void generarCama (ArrayList<Objeto> obj) {
		int comp = 0;
		for (int i = 0; i < obj.size(); i++) {
			if (obj.get(i).getTipo().equals("Componentes") && obj.get(i).getCantidad() == 1) {
				comp++;
			}
			if (obj.get(i).getTipo().equals("Componentes") && obj.get(i).getCantidad() == 2) {
				comp++;
			}
		}
		if (comp >= 10) {
			comp = 0; 
			this.cama = true;
			for (int j = 0; j < obj.size(); j++) {
				if (obj.get(j).getTipo().equals("Componentes") && obj.get(j).getCantidad() == 1 && comp < 10) {
					comp++;
					obj.remove(j);
				}
				if (obj.get(j).getTipo().equals("Componentes") && obj.get(j).getCantidad() == 2 && comp < 10) {
					comp++;
					obj.remove(j);
				}
			}
		}
	}
	

	
}
