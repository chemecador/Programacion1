package main;

public class Main {

	public static void main(String[] args) {
		double celsius = 35.5;
		double reamhur = celsius * 0.8;
		double fahrenheit = celsius * 1.8+32;
		double kelvin = celsius + 273;
		System.out.println("La temperatura en grados de "+ celsius + " ºC "+ " es de " + reamhur + " R, " 
				+ fahrenheit + " F " + " y " + kelvin + "K. ");
		//R=C*0,8 F=C*1,8+32 K=C+273

	}

}
