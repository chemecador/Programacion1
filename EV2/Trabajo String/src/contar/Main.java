package contar;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("Introduzca la letra a buscar: ");
		char letra = in.next().charAt(0);
		letra = Character.toLowerCase(letra);
		
		while(letra<'a' || letra>'z'){
			System.out.println("Error al introducir los datos. "
					+ letra + " no es una letra." );
			System.out.println("Introduzca la letra a buscar: ");
			letra = in.next().charAt(0);
			letra = Character.toLowerCase(letra);
		}
		
		System.out.println("Introduzca la frase en la que desea contar el número de \"" + letra + "\": ");
		in.nextLine();//limpiamos el buffer
		String frase = in.nextLine();
		System.out.println(frase);
		System.out.println("En la frase \"" + frase + "\" la letra \"" + letra 
				+ "\" aparece " + contar(letra,frase) + " veces.");
	}
	
	public static int contar(char letra, String frase) {

		int contador = 0;
		for (int i=0; i<frase.length(); i++) 
			if (frase.charAt(i) == letra) contador++;
		return contador;
	}

}
