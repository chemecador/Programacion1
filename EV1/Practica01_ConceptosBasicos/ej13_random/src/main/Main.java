package main;

public class Main {

	public static void main(String[] args) {
		int numero;
		numero = (int)(Math.random()*100)+1;
		System.out.println("Numero entre 1 y 100 = " + numero);
		numero = (int)(Math.random()*50)+50;
		System.out.println("Otro... " + numero);
	}

}
