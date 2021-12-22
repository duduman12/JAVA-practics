package dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.Jugadores;

public class Marshall {

	public Marshall (Jugadores jugadores) {
		try {
			JAXBContext context = JAXBContext.newInstance(Jugadores.class);
			Marshaller marshall = context.createMarshaller();
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshall.marshal(jugadores, new File ("files/salida.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
}
