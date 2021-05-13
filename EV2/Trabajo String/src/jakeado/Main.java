package jakeado;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("¿Cuántos casos de entrada vas a probar?");
		int casosEntrada = in.nextInt();
		in.nextLine(); //limpiamos buffer
		int intentos=0;
		String pass;
		while (intentos<casosEntrada) {
			System.out.println("Intento número " + (intentos+1) + ", prueba la contraseña: ");
			pass=in.nextLine();
			while (pass.length()>20) {
				intentos++;
				System.out.println("La contraseña es demasiado larga.");
				if(intentos == casosEntrada) System.exit(0); //hemos llegado al limite de casos de entrada
				System.out.println("Intento número " + (intentos+1) + ", prueba la contraseña: ");
				pass=in.nextLine();
			}
			if (esBuena(pass)) {
				System.out.println("Dale no te hackearan esta vez.");
			}
			else {
				System.out.println("No va dar Botas.");
			}
			
			intentos++;
		}
	}
	public static boolean esBuena(String pass) {
		boolean minus=false,mayus=false,numero=false,especial=false;
		for (int i=0;i<pass.length();i++) {
			if (pass.charAt(i)>='a' && pass.charAt(i)<='z') minus = true;
			if (pass.charAt(i)>='A' && pass.charAt(i)<='Z') mayus = true;
			if (pass.charAt(i)>='0' && pass.charAt(i)<='9') numero = true;
			if (esEspecial(pass.charAt(i))) especial = true;
			
		}
		return (mayus && minus && numero && especial); //devuelve true cuando TODAS son true
	}
	public static boolean esEspecial(char c) {
		if (c=='@') return true;
		else if (c=='.') return true;
		else if (c=='_') return true;
		else if (c=='<') return true;
		else if (c=='>') return true;
		else if (c=='-') return true;
		else return false; //si no se cumple ninguna, devuelve false

	}
}
