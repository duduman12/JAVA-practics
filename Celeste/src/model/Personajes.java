package model;

public class Personajes {

	private String name;
	private String element;
	private int cant;
	
	public Personajes (String name, String element) {
		this.name = name;
		this.element = element;
		this.cant = 1;
	}
	
	public String getElement () {
		return this.element;
	}
	
	public String getName () {
		return this.name;
	}

	public void masUno() {
		this.cant++;
	}

	@Override
	public String toString() {
		return "     - " + this.element + ": " + this.cant;
	}
	
}
