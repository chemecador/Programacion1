package main;

import java.util.Scanner;

public class Main {
	

	static Scanner in  = new Scanner (System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("N�mero de alumnos");
		int n=in.nextInt();
		int notas[] = new int[n];
		rellenarNotas(notas,n);
		System.out.println("�Qu� nota quieres buscar?");
		int notaBusca = in.nextInt();
		System.out.println("Hay " + visualizar(notas,n,notaBusca) + " personas "
				+ "con " + notaBusca + " de nota. ");
		

	}
	private static void rellenarNotas(int[] notas, int n) {
		for (int i=0;i<n;i++) {
			System.out.println("Nota del alumno " + i+1 + ": ");
			notas[i] = in.nextInt();
		}
	}
	private static int visualizar(int[] notas, int tama�o, int notaBusca) {
		int contador = 0;
		for (int i=0; i<tama�o;i++) {
			if (notas[i] == notaBusca) {
				contador++;
			}
		}
		return contador;
	}
	
}
