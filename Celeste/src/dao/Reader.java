package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	private BufferedReader bf;
	private BufferedReader bfPer;
	private FileReader fr;
	private FileReader frPer;
	
	public Reader (String file) {
		try {
			this.fr = new FileReader(file);
			this.bf = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			System.out.println("Problemos");
		}
	}
	
	public String readPers () {
		try {
			return bf.readLine();	
		}catch (IOException e) {
			System.out.println("Error al leer el archivo");
			return null;
		}
	}
	
	public String readEle () {
		try {
			return bf.readLine();	
		}catch (IOException e) {
			System.out.println("Error al leer el archivo");
			return null;
		}
	}
	
	public int readCharPers () {
		try {
			return fr.read();
		}catch (IOException e){
			return -1;
		}
	}
	
	public int readCharEle () {
		try {
			return fr.read();
		}catch (IOException e){
			return -1;
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
