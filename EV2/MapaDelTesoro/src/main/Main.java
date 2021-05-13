package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int r=0;
		boolean errorLectura=true;
		do {
			try {
				while(r<2 || r>10) {
					System.out.println("Introduzca el rango de la matriz (2-10): ");
					r = in.nextInt();
				}
				errorLectura=false;
			}catch(InputMismatchException e) {
				System.out.println("Error de lectura");
				in.nextLine();
				errorLectura=true;
			}catch(Exception e) {
				System.out.println("Error de teclado");
				in.nextLine();
				errorLectura=true;
			}
		}while(errorLectura);
		
		int t[][] = new int[r][r];
		
		Mapa.rellenarMapa(t);
		System.out.println("El mapa es: ");
		Mapa.visualizarMapaDatos(t);
		System.out.println("El oro se encuentra en: ");
		Mapa.visualizarMapaOro(t);
	}
}
