package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


@XmlRootElement(name="temtem")
@XmlType(propOrder={"id","nombre","tipo","atributo"})
public class Temtem {
	@XmlAttribute(name="id")
	private String id;
	@XmlElement(name="nombre")
	private String nombre;
	@XmlElement(name="tipo")
	private String tipo;
	@XmlElement(name="atributo")
	ArrayList <Atributo> atributo;
	
	public Temtem () {
		
	}
	
	public Temtem (String id, String name, String tipo, ArrayList<Atributo> atributo) {
		this.id = id;
		this.nombre = name;
		this.tipo = tipo;
		this.atributo = atributo;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public ArrayList<Atributo> getAtributo() {
		return atributo;
	}
	
	
}
