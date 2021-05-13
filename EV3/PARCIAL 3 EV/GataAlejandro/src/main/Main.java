package main;

import java.util.ArrayList;
import java.util.Scanner;

import montessori.Concierto;
import montessori.Montessori;
import montessori.Teatro;

public class Main {
	
	static Scanner in = new Scanner (System.in);
	public static void main(String[] args) {
		ArrayList<Montessori> v = new ArrayList<Montessori>();
		
		Operaciones.rellenarMain(v);
		Operaciones.visualizarMain(v);
		Operaciones.visualizarRAF();
	}

}
