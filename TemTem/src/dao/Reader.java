package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	private BufferedReader bf;
	private FileReader fr;
	
	public Reader (String file) {
		try {
			this.fr = new FileReader(file);
			this.bf = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			System.out.println("Problemos");
		}
	}
	
	public String readLine () {
		try {
			return bf.readLine();	
		}catch (IOException e) {
			System.out.println("Error al leer el archivo");
			return null;
		}
	}
	
	public void closeReader () {
		try {
			if (null != this.fr) {
				fr.close();	
			}
		}catch (IOException e) {
			System.out.println("No se pudo cerra el writer");
		}
	}
	
}
