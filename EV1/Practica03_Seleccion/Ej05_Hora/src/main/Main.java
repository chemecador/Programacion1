package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int h,m,s;
		System.out.println("Introduzca las horas: ");
		h = in.nextInt();
		System.out.println("Introduzca los minutos: ");
		m = in.nextInt();
		System.out.println("Introduzca los segundos: ");
		s = in.nextInt();
		
		if (s<0 || s> 59 || m<0 || m>59 || h<0 || h>23) {
			System.out.println("La hora no es correcta");
			System.exit(0);
		}

		
		System.out.println("Son las " + h + ":" + m + ":" + s);
		
		if (s<59)
			s++;
		else {
			s=0;
			if (m<59)
				m++;
			else {
				m=0;
				if (h<23)
					h++;
				else 
					h=0;
			}
		}
		System.out.println("Dentro de un segundo, serán las " + h + ":" + m + ":" + s);
	}
}
