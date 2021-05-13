package mayor;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		
		Scanner in = new Scanner(System.in);
		System.out.println("Introduce los tres números (la suma debe ser menor a 15: ");
		System.out.println("A: ");
		int a=in.nextInt();
		System.out.println("B: ");
		int b=in.nextInt();
		System.out.println("C: ");
		int c=in.nextInt();
		while(a<0 || b<0 || c<0 || sumaDigitos(a)>15 || sumaDigitos(b)>15 || sumaDigitos(c)>15) {
			System.out.println("Error al introducir los datos. Los números deben ser positivos"
					+ " Y LA SUMA DE SUS DÍGITOS MENOR DE 15");
			System.out.println("A: ");
			a=in.nextInt();
			System.out.println("B: ");
			b=in.nextInt();
			System.out.println("C: ");
			c=in.nextInt();
		}
		String sA = String.valueOf(a);
		String sB = String.valueOf(b);
		String sC = String.valueOf(c);

		
		System.out.println("El número más largo es " + comparar(sA,sB,sC));
		
		
}
		
	public static String comparar (String a, String b, String c) {
			String primero="",segundo="",tercero="";
			if(a.compareTo(b)>0 && a.compareTo(c)>0) {
				primero = a;
				if (b.compareTo(c)>0) {
					segundo = b;
					tercero = c;
				}
				else {
					segundo = c;
					tercero = b;
				}
			}
			else if(b.compareTo(a)>0 && b.compareTo(c)>0) {
				primero = b;
				if (a.compareTo(c)>0) {
					segundo = a;
					tercero = c;
				}
				else {
					segundo = c;
					tercero = a;
				}
			}
			else if(c.compareTo(a)>0 && c.compareTo(b)>0) {
				primero = c;
				if (a.compareTo(b)>0) {
					segundo = a;
					tercero = b;
				}
				else {
					segundo = b;
					tercero = a;
				}
			}

			return primero+segundo+tercero;
			
		}
		
		
	//método que devuelve el número de cifras
	public static int numCifras(int a) {
		int contador = 1;
		while (a/10>=1) {
			a=a/10;
			contador++;
		}
		return contador;
	}
	
	//método que devuelve la suma de los dígitos
	public static int sumaDigitos(int a) {
		int suma=0;
		int longitud = numCifras(a);
		for (int i=0;i<longitud;i++) {
			suma=suma+a%10;
			a=a/10;
		}
		return suma;
	}
	//método que quita el primer carácter de un string
	public static String quitarPrimero(String s) {
		String nuevo = "";
		for (int i=1;i<s.length();i++) {
			nuevo = nuevo + s.charAt(i);
		}
		return nuevo;
	}

	
	//método que devuelve la primera cifra
	public static int primeraCifra(int a) {
		int cifra;
		double quitar = numCifras(a)-1; //número de cifras que hay que quitar
		cifra = a/(int)Math.pow(10,quitar);
		return cifra;
	}
}
