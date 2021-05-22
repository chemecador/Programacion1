package entidades;

/**
 * Clase Arbitro: La clase Arbitro tiene 3 atributos: el nombre, el pa�s de
 * nacimiento y su reputaci�n. Por defecto, se han le�do los �rbitros m�s
 * reconocidos a nivel mundial a trav�s del fichero arbitros.txt y se ha
 * almacenado en un ArrayList de arbitros al ejecutar el programa
 * 
 * @author Alejandro Gata
 * @since 1.8
 */

public class Arbitro extends Persona {
	private Reputacion rep;

	/**
	 * Constructor
	 */
	public Arbitro() {
		super();
		this.rep = null;
	}

	/**
	 * Sobrecarga de constructor
	 * 
	 * @param rep Reputaci�n
	 */
	public Arbitro(Reputacion rep) {
		super();
		this.rep = rep;
	}

	public Reputacion getRep() {
		return rep;
	}

	public void setRep(Reputacion rep) {
		this.rep = rep;
	}

	/**
	 * M�todo que visualiza un �rbitro
	 */
	public void visualizar() {
		super.visualizar();
		System.out.println("Su reputaci�n es " + this.rep);
	}

	/**
	 * M�todo que rellena un �rbitro
	 */
	public void rellenar() {
		super.rellenar();
		System.out.println("Introduzca su reputaci�n (BUENA, NORMAL, MALA)");
		boolean error = false;
		do {
			try {
				this.rep = Reputacion.valueOf(in.nextLine());
				error = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Error, no ha escrito correctamente la reputaci�n.");
				error = true;
			}
		} while (error);
	}

	@Override
	public int compareTo(Persona otraPersona) {

		return super.getNombre().compareTo(otraPersona.getNombre());
	}
}
