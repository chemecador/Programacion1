package main;

import java.util.Scanner;

public class Ejer2 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		System.out.println("¿De qué tamaño desea la pirámide?");
		int n = in.nextInt();
		if (n < 1) {
			System.out.println("No es posible realizar la pirámide de tamaño " + n + ". El programa se cerrará.");
			System.exit(0);
		}
		for(int i = 0; i<n; i++) {
			for (int j = 0; j<n-i; j++) {
				if (j%2 == 0) {
					System.out.print("*");
				}
				else {
					System.out.print("?");
				}
			}
			System.out.println();
		}
	}

}
