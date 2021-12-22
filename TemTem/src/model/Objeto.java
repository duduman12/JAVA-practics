package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="objeto")
@XmlType(propOrder={"name","cantidad"})
public class Objeto {

	@XmlAttribute(name="name")
	private String name;
	@XmlElement
	private String cantidad;
	
	public Objeto () {
		
	}
	
	public Objeto (String name, String quantity) {
		this.name = name;
		this.cantidad = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return "Objeto [name=" + name + ", cantidad=" + cantidad + "]";
	}

	
	
}
