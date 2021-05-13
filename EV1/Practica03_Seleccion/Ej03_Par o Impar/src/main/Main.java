package main;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Introduzca un numero entre el 1 y el 10");
		int numero = in.nextInt();
		switch (numero) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 9:
			System.out.println("Es impar");			
			break;
		case 2:
		case 4:
		case 6:
		case 8:
		case 10:
			System.out.println("Es par");
		default:
			System.out.println("Numero fuera de rango");
			break;
		}
	}

}
