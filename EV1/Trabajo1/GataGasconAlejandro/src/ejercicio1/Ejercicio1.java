package ejercicio1;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		boolean fin = false;
		int contador = 0, matricula, digito, ara = 0,
				cat = 0, mad = 0, and = 0, gal = 0;
		while (!fin) {
			System.out.println("Introduzca el n�mero de la matr�cula");
			matricula = in.nextInt();
			if (matricula < 1000 || matricula > 9999)
				System.out.println("Matr�cula no v�lida");
			else {
				digito = matricula%10;
				contador++;
				if (digito == 1 || digito == 2)
					ara++;
				else if (digito == 3 || digito == 4)
					cat++;
				else if (digito == 5 || digito == 6)
					mad++;
				else if (digito == 7 || digito == 8)
					and++;
				else if(digito == 9 || digito == 0)
					gal++;
				
				System.out.println("�Desea a�adir una m�s? S/N");
				char respuesta = in.next().charAt(0);				
				if(respuesta == 'N' || respuesta == 'n')
					fin = true;
				else if (respuesta != 'S' && respuesta != 's') {
					System.out.println("Caracter no v�lido, no se a�adir�n m�s matr�culas");
				}
				//else{} , sigue igual
			}			
		}
		System.out.println("Total: " + contador + "\nArag�n: " + ara + " que representa un "
				+ ara*100/contador + "% del total.");
		System.out.println("\nCatalu�a: " + cat + " que representa un "
				+ cat*100/contador + "% del total.");
		System.out.println("\nMadrid " + mad + " que representa un "
				+ mad*100/contador + "% del total.");
		System.out.println("\nAndaluc�a: " + and + " que representa un "
				+ and*100/contador + "% del total.");
		System.out.println("\nGalicia: " + gal + " que representa un "
				+ gal*100/contador + "% del total.");
	}

}
