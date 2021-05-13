package autobus;

import java.util.Scanner;

public abstract class Autobus implements Calculos {
	private int id;
	private int precioBase;
	private Conductor conductor;

	Autobus() {
		this.id = 0;
		this.conductor = new Conductor();
		this.precioBase = 0;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public int getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}

	public void rellenar() {
		Scanner in = new Scanner(System.in);
		System.out.println("Escribe el ID");
		this.id = in.nextInt();
		System.out.println("Escribe el precio base");
		this.precioBase = in.nextInt();
		this.conductor.rellenar();
	}

	public void visualizar() {
		System.out.println("El id es : " + this.id);
		System.out.println("El precio base es " + this.precioBase);
		this.conductor.visualizar();
	}

}
