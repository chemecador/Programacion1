package rotando;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		
		System.out.println("Introduzca la cadena a rotar (40 caracteres máximo, sin espacios): ");
		String S = in.nextLine();
		int L = S.length(); //longitud de la cadena
		while (L > 40) {
			System.out.println("La cadena es demasiado larga.");
			System.out.println("Introduzca la cadena a rotar (40 caracteres máximo, sin espacios): ");
			S = in.nextLine();
			L = S.length();
		}
		for (int i=0; i<L; i++) {
			if (S.charAt(i) == ' ') {
				System.out.println("Error al introducir los datos. La cadena NO debe contener espacios. "
						+ "\nEl programa se cerrará.");
				System.exit(0);
			}
		}
		
		System.out.println("Introduzca el número de posiciones a rotar: ");
		int R = in.nextInt();
		while(R>L) {
			System.out.println("Error. No se pueden rotar " + R + " posiciones, "
					+ "el máximo es " + L + ".");
			System.out.println("Introduzca el número de posiciones a rotar: ");
			R = in.nextInt();
		}
		
		System.out.println("La cadena inicial es: " + S);
		System.out.println("\nLa cadena invertida es: " + invertir(S,R));
	}
	
	public static String invertir(String S, int R) {
		
		String cadenaInvertida = "";
		int L = S.length();
		for (int i=L-R; i<L; i++) { //copiamos lo invertido
			cadenaInvertida += S.charAt(i);
		}

		for (int i=0; i<L-R; i++) { //copiamos lo restante
			cadenaInvertida += S.charAt(i);
		}
		return cadenaInvertida;
	}

}
