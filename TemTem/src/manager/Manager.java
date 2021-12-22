package manager;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.Reader;
import model.Atributo;
import model.Jugadores;
import model.Temtem;
import dao.*;

public class Manager {

	private static Manager manager;
	private Reader r;
	private ArrayList <String> actions;
	private UnMarshall um;
	private Marshall m;
	private Jugadores jugadores;
	
	public static Manager getInstance() {
		if (manager == null) {
			manager = new Manager ();
		}
		
		return manager;
	}
	
	public Manager () {
		r = new Reader ("files/acciones.txt");
		actions = new ArrayList<String>();
	}
	
	public void init () {
		showImage("files/temtem.jpg");
		readTxt(r);
		um = new UnMarshall();
		jugadores = um.getJugadores();
		executeAction();
	}
	
	private void readTxt (Reader r) {
		String aux = "";
		while ( (aux = r.readLine()) != null) {
			actions.add(aux);
		}
	}
	
	private void executeAction () {
		for (int i = 0; i < actions.size(); i++) {
			String [] parts = actions.get(i).split(" ");
			switch (parts[0]) {
				case "M":
					actionM(parts[1]);
					break;
				case "P":
					actionP(parts[1]);
					break;
				case "B":
					actionB(parts[1],parts[2]);
					break;
				case "A":
					actionA(parts);
					break;
				case "S":
					m = new Marshall(jugadores);
					break;
				default:
					System.out.println("La x no hace nada");
					break;
			}
		}
	}
	
	//TODO revisar como mejorar esta funcion con lo de la excepcion y mostrar tambien sus stats
	/**
	 * Muestra el temtem correspondiente con la id que se le pasa por parametro
	 * @idTemtem la id del temtem en cuestion
	 */
	private void actionM (String idTemtem) {
		int counter = 0;
		boolean ok = false;
		while (counter < jugadores.getPlayers().size()) {
			for (int i = 0; i < jugadores.getPlayers().get(counter).getTemtems().size(); i++) {
				String id = jugadores.getPlayers().get(counter).getTemtems().get(i).getId();
				if (id.equalsIgnoreCase(idTemtem) && !ok) {
					showImage("files/" + jugadores.getPlayers().get(counter).getTemtems().get(i).getNombre() + ".jpg");
					System.out.println("ActionM --> temtem: " + jugadores.getPlayers().get(counter).getTemtems().get(i).getNombre());
					showStats(counter, i);
					i = jugadores.getPlayers().get(counter).getTemtems().size()+1;
					ok = true;
				}
			}
			counter++;
		}
		if (!ok) {
			System.out.println("Error M --> No se pudo encontrar el temtem seleccionado");
		}
	}
	/**
	 * Imprime por consola la cantidad de Objetos y de Temtems que tiene un jugador en concreto
	 * @idPlayer la id del jugador en concreto
	 */
	private void actionP (String idPlayer) {
		int player = 0;
		int cantidadObjetos = 0;
		for (int j = 0; j < jugadores.getPlayers().size(); j++) {
			player = j;
			j = jugadores.getPlayers().size();
		}
		for (int i = 0; i < jugadores.getPlayers().get(player).getObjects().size(); i++) {
			cantidadObjetos = cantidadObjetos + Integer.parseInt(jugadores.getPlayers().get(player).getObjects().get(i).getCantidad());
		}
		
		System.out.println("ActionP --> Numero de Objetos: " + cantidadObjetos + ""
				+ "\nActionP --> Numero de Temtems: " + jugadores.getPlayers().get(player).getTemtems().size());
	}
	
	/**
	 * Elimina el temtem que se pasa por parametro del jugador que se pasa por parametro
	 * @idPers id del personaje en cuestion
	 * @idTemtem id del temtem en cuestion
	 */
	private void actionB (String idPers, String idTemtem) {
		int idP = Integer.parseInt(idPers) - 1;
		boolean control = true;
		
		if (idP <= jugadores.getPlayers().size()) {
			for (int i = 0; i < jugadores.getPlayers().get(idP).getTemtems().size() && control; i++) {
				if (jugadores.getPlayers().get(idP).getTemtems().get(i).getId().equalsIgnoreCase(idTemtem)) {
					jugadores.getPlayers().get(idP).getTemtems().remove(i);
					control = false;
				}
			}
			if (control) {
				System.out.println("Error B --> No se puede borrar este Temtem");
			}
		}else {
			System.out.println("Error B --> Este personaje no existe");
		}
		
	}
	
	/**
	 * Crea y añade un nuevo temtem en un usuario en concreto
	 * @parts datos del ArrayList de Atributo y id del personaje
	 */
	private void actionA (String parts []) {
		System.out.println("Action A \n");
		if (parts.length == 12) {
			System.out.println("Entra");
			int idPers = Integer.parseInt(parts[1]) - 1;
			ArrayList<Temtem> t = jugadores.getPlayers().get(idPers).getTemtems();
			t.add(new Temtem (parts[2],parts[3],parts[4],fillArrayList(parts)));
		}else {
			System.out.println("Numero de parametros incorrecto");
		}
	}
	
	//TODO revisar la forma en la que esta hecho esto, quizas se puede mejorar
	/**
	 * Rellena un arrayList de atributo con los datos que se le pasan por fichero
	 * @parts Todos los atributos
	 * @return el arrayList rellenado
	 */
	private ArrayList<Atributo> fillArrayList (String parts []) {
		ArrayList<Atributo> atr = new ArrayList<Atributo>();
		String [] id = {"PS","ATQ","SATQ","STA","VEL","DEF","SDEF"};
		for (int i = 5; i < 12; i++) {
			atr.add(new Atributo (parts[i],id[i-5]));
		}
		return atr;
	}
	
	private void showStats(int counter, int i) {
		for (int j = 0; j < jugadores.getPlayers().get(counter).getTemtems().get(i).getAtributo().size(); j++) {
			System.out.println("\t" + jugadores.getPlayers().get(counter).getTemtems().get(i).getAtributo().get(j).toString());
		}
		System.out.println();
	}
	
	public void showImage(String temtem) {
		JFrame f = new JFrame();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        f.setUndecorated(true);

        ImageIcon image = new ImageIcon(temtem);

        JLabel lbl = new JLabel(image);

        f.getContentPane().add(lbl);

        f.setSize(image.getIconWidth(), image.getIconHeight());

        int x = (screenSize.width - f.getSize().width)/2;
        int y = (screenSize.height - f.getSize().height)/2;

        f.setLocation(x, y);
        f.setVisible(true);
        
        
        f.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				f.dispose();
				f.setVisible(false);
			}
            
        });
        
        try {
			System.in.read();
		} catch (IOException e1) {
			System.out.println("ERROR");
		}
	}
	
}
