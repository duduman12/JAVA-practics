package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="atributo")
public class Atributo {
	@XmlValue
	private String value;
	
	@XmlAttribute(name="id")
	private String id;
	
	public Atributo () {
		
	}
	
	public Atributo (String value, String id) {
		this.value = value;
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return id + " = " + value;
	}
	
	
	
}
