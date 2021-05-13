package montessori;

import java.util.Scanner;

public class Montessori {
	
	static Scanner in = new Scanner (System.in);
	
	private String descripcion;
	private int duracion;
	private float precio;
	
	public Montessori(){
		this.descripcion = "";
		this.duracion = 0;
		this.precio = 0;
	}
	
	public Montessori (String descripcion, int duracion, float precio){
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.precio = precio;
	}

	public void rellenar() {
		System.out.println("Por favor, indique una breve descripci�n: ");
		this.descripcion = in.nextLine();
		System.out.println("Introduzca la duraci�n (en d�as)");
		this.duracion = in.nextInt();
		in.nextLine();
		System.out.println("Introduzca el precio base: ");
		this.precio = in.nextFloat();
		in.nextLine();
	}
	
	public void visualizar() {
		System.out.println("Una breve descripci�n: " + this.descripcion);
		System.out.println("Duraci�n (en d�as): " + this.duracion);
		System.out.println("Precio base: " + this.precio);
		
	}
	
	public void calcular() {
		
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
