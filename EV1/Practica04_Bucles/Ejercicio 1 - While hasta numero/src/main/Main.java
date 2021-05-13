package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		/*while (n<1 || n>5) {
			System.out.println("Para finalizar, pulse un numero entre 1 y 5");
			n = in.nextInt();
		}*/
		do {
			System.out.println("Para finalizar, pulse un numero entre 1 y 5");
			n = in.nextInt();
		}while(n<1 || n>5);
		
		System.out.println("¡Adiós!");
	}

}
