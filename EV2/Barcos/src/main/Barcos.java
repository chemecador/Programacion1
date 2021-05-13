package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Barcos {

	static Scanner in=new Scanner(System.in);
	
	//Método que rellena un tablero vacío
	public static void rellenarTableroVacio(char [][] t) {

		for (int i=0;i<t.length;i++) {
			for (int j=0;j<t[0].length;j++) {
				t[i][j]='o';
			}
		}
	}
	
	//Método que muestra un tablero
	public static boolean mostrarTablero(char[][] t) {
		
		boolean quedanBarcos=false;
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				if(t[i][j]!='B') {
					System.out.print(t[i][j]);
				}
				else {
					System.out.print("o");
					quedanBarcos=true;
				}
				
			}
			System.out.println();
		}
		return quedanBarcos;
	}
	
	//Método que coloca un número determinado de barcos
	public static void ponerBarcos(char[][] t, int cantidadBarcos) {
		int barcosColocados=0;
		while(barcosColocados<cantidadBarcos) {
			for(int i=0;i<t.length;i++) {
				for(int j=0;j<t[i].length;j++) {
					double aleatorio = Math.random(); //Para colocar los barcos de manera aleatoria, generaremos un número aleatorio
					if(aleatorio<0.01 && t[i][j] != 'B') { //aleatorio<0.01 para que todos tengan la misma probabilidad, 
						t[i][j]='B'; 						//y no tengan ventaja los primeros
						barcosColocados++;
					}
					if(barcosColocados==cantidadBarcos) {
						break;
					}
				}
				if(barcosColocados==cantidadBarcos) {
					break;
				}
			}
			if(barcosColocados==cantidadBarcos) {
				break;
			}
		}
	}
	
	//Método que pide al usuario dónde quiere colocar, y si es posible, coloca
	public static void jugar(char[][] t) {
		int f=-1,c=-1;
		boolean error=true,
				errorLectura=true;
		try{ 
			while(error) {
				System.out.println("Dime la fila: ");
				f= in.nextInt()-1;
				System.out.println("Dime la columna: ");
				c= in.nextInt()-1;
				error=(f<0 || f>=t.length || c<0 || c>=t[0].length);
				if(error) {
					System.out.println("El número de la fila debe estar entre "
							+ "1 y " + t.length);
					System.out.println("El número de la columna debe estar entre "
							+ "1 y " + t[0].length);
				}
				errorLectura=false;
			}
	}catch(InputMismatchException e) {
		System.out.println("Error en la lectura de datos");
		in.nextLine();
		errorLectura=true;
	}catch(Exception e) {
		System.out.println("Error de teclado");
		in.nextLine();
		errorLectura=true;
	}while (errorLectura);
		
		System.out.println();
		if (t[f][c]=='B') {
			t[f][c]='X';
			System.out.println("HUNDIDO");
		}
		else if (t[f][c]== 'o') {
			t[f][c] = 'F';
			System.out.println("AGUA");
		}
		else if (t[f][c]=='F') {
			System.out.println("Ya te he dicho que NO");			
		}
	}
}