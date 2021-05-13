package quitar;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Introduzca el número de intentos: ");
		int casosPrueba = in.nextInt();
		in.nextLine(); //limpiamos buffer
		int intentos = 0;
		while (intentos < casosPrueba) {
			intentos++;
			System.out.println("Introduzca la cadena: ");
			String cadenaInicial = in.nextLine();
			
			if (cadenaInicial.length()>50) {
				System.out.println("La cadena es demasiado larga.");
			}
			
			else {
				System.out.println("La nueva cadena es " + cambiar(cadenaInicial));
			}
		}

	}
	
	/*método que devuelve un string en el que cambia todas las secuencias de
	varias interrogaciones por una sola*/
	public static String cambiar(String s) {
		String nueva = "";
		int i=0;
		boolean hayInterrogante;
		while(i<s.length()) {
			hayInterrogante=false;
			//primero comprobamos si tiene interrogantes 
			if(s.charAt(i) == '?') {
				while(!esLetra(s.charAt(i)) && i<s.length()-1){
					i++;
				}
				//si tiene, copiamos solo 1
				nueva = nueva + '?';
			}
			//después, comoprobamos si tiene exclamaciones
			else if (s.charAt(i) == '!') {
				hayInterrogante=false;
				while(!esLetra(s.charAt(i)) && i<s.length()-1) {
					if (s.charAt(i)=='?') {
						hayInterrogante = true;
					}
					i++;
			}		//else{} es otro carácter diferente que NO se copiará en la nueva cadena
			
			/*aquí entra solo si hay exclamaciones, diferenciando si entre ellas
			  hay también un interrogante*/
			if (hayInterrogante || s.charAt(i)=='?')
				nueva = nueva + '?';
			else 
				nueva = nueva + '!';
			}
			
			//ya hemos acabado con las '?' y las '!', ahora comprobamos si es letra o espacio
			if (esLetra(s.charAt(i)) || s.charAt(i)==' '){
				nueva = nueva + s.charAt(i);
			}
			i++;
		}
		return nueva;
	}
	/*método que devuelve un booleano que indica si el carácter introducido como parámetro
	  es una letra (true) o no lo es (false)*/
	public static boolean esLetra(char c) {
		if ((c>='a' && c<='z') || (c>='A' && c<='Z')) 
			return true;
		
		return false;
	}

}