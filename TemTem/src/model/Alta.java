package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="alta")
public class Alta {
	@XmlAttribute(name="ciudad")
	private String ciudad;
	@XmlValue
	private String date;
	
	public Alta () {
		
	}
	public Alta (String city, String date) {
		this.ciudad = city;
		this.date = date;
	}
	
	public String getAlta () {
		return this.ciudad;
	}
	
}
