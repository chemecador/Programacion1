package main;

public class Main {

	public static void main(String[] args) {
		
		//1. Creamos tres variables numericas
		byte unByte = 2;
		short unShort = 1000;
		int unInt = 10000;
		long unLong = 100000;
		//2. Conversi�n impl�cita
		System.out.println("**Conversion Implicita**");
		unShort = unByte;
		System.out.println("Nuevo valor de short: " + unShort);
		//3. Conversi�n expl�cita
		System.out.println("**Conversion Explicita");
		unInt = (int)unLong;
	
	}

}
