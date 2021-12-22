package modelo;

public class Objeto {
	String tipo;
	int cantidad;
	
	public Objeto (String type, int cant) {
		this.tipo = type;
		this.cantidad = cant;
	}
	
	public String toString() {
			return "Objeto: "+ tipo + ": " + cantidad;
	}
	
	public String getTipo () {
		return tipo;
	}
	
	public int getCantidad () {
		return this.cantidad;
	}
	
	public void setCantidad (int a) {
		this.cantidad-=a;
	}
}
