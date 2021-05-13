package montessori;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Teatro extends Montessori {
	
	
	private TipoTeatro tipoTeatro;
	private float pvp;
	
	public Teatro() {
		super();
		this.pvp = super.getPrecio();
	}
	
	public Teatro(int porcentaje, String descripcion){
		super();
		this.pvp = super.getPrecio();
	}
	public void rellenar() {
		super.rellenar();
		System.out.println("A continuación se mostrarán las clases de teatro:\n");
		for (TipoTeatro tipoTeatroBucle : TipoTeatro.values()) {
			System.out.print(tipoTeatroBucle+ ", con un porcentaje del ");
			System.out.print(tipoTeatroBucle.getPorcentaje() + "% y su tipo de obra es ");
			System.out.println(tipoTeatroBucle.getDescripcion() + ".");
		}

		System.out.println("\nIndique únicamente el nombre de la clase, por ejemplo: Clase1\n");
		boolean error = false;
		do {
			try {
				this.tipoTeatro = TipoTeatro.valueOf(in.nextLine());
				error = false;
			} catch(IllegalArgumentException e) {
				System.out.println("Error, no ha escrito correctamente el nombre de la clase.");
				error = true;
			}
		} while (error);
		this.calcular();
		crearRAF();
	}
	public void visualizar() {
		super.visualizar();
		System.out.println("La clase de teatro es: " + this.tipoTeatro);
		System.out.println("Su PVP es: " + this.pvp);
	}
	
	public void calcular() {
		float porcentaje = this.tipoTeatro.getPorcentaje();
		porcentaje = 1 + (porcentaje/100);
		this.pvp = super.getPrecio() * porcentaje;
	}
	
	public void crearRAF() {
		try {
			RandomAccessFile f = new RandomAccessFile("teatro","rw");
			f.seek(f.length()); //añade la descripcion conforme lee el teatro
			String descripcion = formatear(super.getDescripcion(),20);
			f.writeUTF(descripcion);
			f.close();
		} catch (IOException e) {
			System.out.println("Error al escribir en el RAF");
		}
	}
	public String formatear(String nombre, int longitud) {
		if(nombre.length() > longitud) {
			return nombre.substring(0,longitud);
		}
		for (int i = nombre.length(); i < longitud; i++) {
			nombre = nombre + " ";
		}
		return nombre;
	}
}
