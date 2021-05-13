package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		boolean errorLectura=true;
		int filas=0,columnas=0,cantidadBarcos=0;
		do {
			try {
				System.out.println("Introduzca el número de filas");
				filas=in.nextInt();
				System.out.println("Introduzca el número de columnas");
				columnas=in.nextInt();
				System.out.println("Introduzca el número de barcos (tendrán longitud 1)");
				cantidadBarcos=in.nextInt();
				while(cantidadBarcos>filas*columnas) {
					System.out.println("La cantidad de barcos debe estar entre 1 y " + filas*columnas);
					cantidadBarcos=in.nextInt();
				}
				errorLectura=false;
			}catch(InputMismatchException e) {
				System.out.println("Error de lectura");
				in.nextLine();
				errorLectura=true;
			}
			catch(Exception e) {
				System.out.println("Error de teclado");
				in.nextLine();
				errorLectura=true;
			}
		}while(errorLectura);
		char [][]t = new char[filas][columnas];
		int intentos=0;
		Barcos.rellenarTableroVacio(t);
		Barcos.ponerBarcos(t,cantidadBarcos);
		while(Barcos.mostrarTablero(t)) {
			intentos++;
			Barcos.jugar(t);
			System.out.println("Llevas " + intentos + " intentos. ");
		}
		System.out.println("¡Has ganado! Has necesitado " + intentos + " intentos.");
	}
}