package montessori;

import java.util.Scanner;

public class Concierto extends Montessori {
	
	static Scanner in = new Scanner (System.in);
	
	private boolean provincia; // si est�, true; si no, false
	private float pvp;
	
	public Concierto(){
		super();
		this.provincia = false;
		this.pvp = super.getPrecio();
	}
	public Concierto (boolean provincia){
		super();
		this.provincia = provincia;
		this.pvp = super.getPrecio();
	}
	public void rellenar() {
		super.rellenar();
		char opcion;
		do {
			System.out.println("�El concierto est� en su provincia? (s/n)");
			opcion = in.nextLine().charAt(0);
		}while(opcion != 's' && opcion != 'n');
		if (opcion == 's') {
			this.provincia = true;
		}
		else if (opcion == 'n'){
			this.provincia = false;
		}
		else {
			System.out.println("Este mensaje nunca deber�a aparecer. Si lee este mensaje,"
					+ " contacte con el servicio t�cnico.");
		}
		this.calcular();
	}
	public void visualizar() {
		super.visualizar();
		if (this.provincia) {
			System.out.println("Est� en su provincia.");
		}
		else {
			System.out.println("No est� en su provincia.");
		}
		System.out.println("Su PVP es " + this.pvp);
	}
	
	public void calcular() {
		if (this.provincia) {
			this.pvp = super.getPrecio();
		}
		else {
			this.pvp = super.getPrecio() * 1.20f;
		}
		System.out.println("Su PVP despues es: " + this.pvp);
	}
}
