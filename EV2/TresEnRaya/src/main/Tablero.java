package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tablero {
	
	static Scanner in = new Scanner (System.in);
	
	//M�todo que rellena un tablero
	public static void rellenarTablero(char[][] t) {
		for (int i=0;i<t.length;i++) {
			for (int j=0;j<t[0].length;j++) {
				t[i][j] = ' ';
			}
		}
		for (int i=0;i<t.length;i++) {
			t[i][0]='*';
			t[i][t.length-1]='*';
			t[0][i]='*';
			t[t.length-1][i]='*';
		}
	}
	//M�todo que muestra un tablero
	public static void mostrarTablero(char[][] t) {
		System.out.println();
		for (int i=0;i<t.length;i++) {
			for(int j=0;j<t[0].length;j++) {
				System.out.print(t[i][j]);				
				if (j==t.length-1) {
					System.out.print("\n");
				}
			}
		}
		System.out.println();
	}
	//M�todo que pide d�nde colocar la ficha y la coloca si es posible
	public static void pedirDatos(char[][] t) {
		int fila=pedirPosicion(true),columna=pedirPosicion(false);
		while (t[fila][columna] != ' ') {
			System.out.println("Error. Esa posici�n est� ocupada");
			mostrarTablero(t);
			fila=pedirPosicion(true);
			columna=pedirPosicion(false);
		}
		t[fila][columna]= 'X';
		mostrarTablero(t);
		comprobar3EnRaya(t);
	}
	//M�todo que pide y comprueba si se puede colocar en un sitio en concreto.
	//Si el par�metro es true, est� jugando el usuario. Si es false, juega la CPU
	public static int pedirPosicion(boolean esFila) {
		int posicion=0;
		boolean errorLectura=true;
		try {
			while (posicion<1 || posicion>3){
				if (esFila) {
					System.out.println("Dime la fila");
				}
				else {
					System.out.println("Dime la columna");
				}
				errorLectura=false;
				posicion=in.nextInt();
				if(posicion<1 || posicion>3) {
					System.out.println("Error. El n�mero debe estar entre 1 y 3");
				}
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
		
		return posicion;
	}
	//M�todo que coloca la ficha de la CPU
	public static void jugarCPU(char[][] t) {
		int i,j;
		do{
			i=(int)Math.floor(Math.random()*3+1);
			j=(int)Math.floor(Math.random()*3+1);
		}while(t[i][j]!=' ');
		t[i][j] = 'O';
		mostrarTablero(t);
		comprobar3EnRaya(t);
	}
	//M�todo que devuelve true si el teclado est� lleno, o false en caso contrario
	public static boolean lleno(char[][] t) {
		for (int i=0;i<t.length;i++) {
			for (int j=0;j<t[0].length;j++) {
				if (t[i][j]==' ') return false;
			}
		}
		System.out.println("�EMPATE!");
		return true;
	}
	//M�todo que comprueba si se ha hecho ya 3 en raya, y en ese caso, cierra el programa
	public static void comprobar3EnRaya(char[][] t) {
		//comprobamos filas
		for (int f=0; f<t.length; f++){
			if (t[f][1]==t[f][2] && t[f][2]==t[f][3]){
				if(t[f][1]=='X') {
					System.out.println("�HAS GANADO!");
					System.exit(0);
				}
				else if(t[f][1]=='O') {
					System.out.println("LO SIENTO, HAS PERDIDO");
					System.exit(0);
				}
			}			
		}
		//comprobamos columnas
		for (int c=0;c<t.length;c++) {
			if (t[1][c]==t[2][c] && t[2][c]==t[3][c]) {
				if (t[1][c]=='X') {
					System.out.println("�HAS GANADO!");
					System.exit(0);
				}
				else if (t[1][c]=='O') {
					System.out.println("LO SIENTO, HAS PERDIDO");
					System.exit(0);
				}
			}
		}
		
		//comprobamos diagonales
		if (t[1][1]== t[2][2] && t[2][2] == t[3][3]){
			if (t[1][1]=='X') {
				System.out.println("�HAS GANADO!");
				System.exit(0);
			}
			else if (t[1][1]=='O') {
				System.out.println("LO SIENTO, HAS PERDIDO");
				System.exit(0);
			}
		}
		if (t[1][3]== t[2][2] && t[2][2] == t[3][1]){
			if (t[1][3]=='X') {
				System.out.println("�HAS GANADO!");
				System.exit(0);
			}
			else if (t[1][3]=='O') {
				System.out.println("LO SIENTO, HAS PERDIDO");
				System.exit(0);
			}
		}
	}
}
