package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="jugadores")
public class Jugadores {
	
	@XmlElement(name="jugador")
	private ArrayList <Jugador> jugadores;
	
	public Jugadores () {
		jugadores  = new ArrayList<Jugador>();
	}

	public ArrayList<Jugador> getPlayers() {
		return jugadores;
	}
	
}
