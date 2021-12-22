package dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Jugador;
import model.Jugadores;

public class UnMarshall {

	private Jugadores j = null;
	
	public UnMarshall () {
		try {
			JAXBContext context = JAXBContext.newInstance(Jugadores.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			j = (Jugadores) unmarshaller.unmarshal(new File("files/entrada.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("No furula");
		}
		
	}
	
	public Jugadores getJugadores() {
		return j;
		
	}
	
}
