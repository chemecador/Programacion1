package entidades;

public class Arbitro extends Persona{
	private Reputacion rep;

	public Arbitro() {
		super();
		this.rep = null;
	}

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

	public void visualizar() {
		super.visualizar();
		System.out.println("Su reputación es " + this.rep);
	}

	public void rellenar() {
		super.rellenar();
		System.out.println("Introduzca su reputación (BUENA, NORMAL, MALA)");
		boolean error = false;
		do {
			try {
				this.rep = Reputacion.valueOf(in.nextLine());
				error = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Error, no ha escrito correctamente la reputación.");
				error = true;
			}
		} while (error);
	}

	@Override
	public int compareTo(Persona otraPersona) {
		
		return super.getNombre().compareTo(otraPersona.getNombre());
	}
}
