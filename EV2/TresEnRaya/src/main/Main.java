package main;

public class Main {

	public static void main(String[] args) {
		char t[][] = new char[5][5];
		Tablero.rellenarTablero(t);
		
		while(true) {
			Tablero.pedirDatos(t);
			if (Tablero.lleno(t)) {
				break;
			}
			
			Tablero.jugarCPU(t);
			if(Tablero.lleno(t)) {
				break;
			}
		}
		Tablero.mostrarTablero(t);
	}


}