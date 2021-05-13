package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char letra;
		System.out.println("Introduzca la calificacion (A/B/C/D/E");
		letra = in.nextLine().charAt(0);
		letra = Character.toUpperCase(letra);
		switch (letra) {
		case 'A':
			System.out.println("Es un 4");
			break;
		case 'B':
			System.out.println("Es un 5");
			break;
		case 'C':
			System.out.println("Es un 6");
			break;
		case 'D':
			System.out.println("Es un 7");
			break;
		case 'E':
			System.out.println("Es un 8");
			break;

		default:
			break;
		}
	}

}
