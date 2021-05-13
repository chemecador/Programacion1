package main;

public class Mapa {
	
	//Método que rellena un mapa (matriz cuadrada) con números aleatorios
	public static void rellenarMapa(int[][] t) {
		for (int i=0;i<t.length;i++) {
			for (int j=0;j<t[0].length;j++) {
				t[i][j] = (int)Math.round(Math.random()*100);
			}
		}
	}
	//Método que visualiza el mapa rellenado previamente
	public static void visualizarMapaDatos(int [][] t) {
		for (int i=0;i<t.length;i++) {
			for (int j=0;j<t[0].length;j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
	}
	//Método que, a partir de un mapa de números aleatorios, crea y visualiza otro con la posición del oro
	public static void visualizarMapaOro(int [][] t) {
		char[][] oro = new char[t.length][t[0].length];
		if(t[0][0]>(t[0][1]+t[1][0])/2) {
			oro[0][0] = '*';
		}
		else {
			oro[0][0] = ' ';
		}
		if(t[0][t.length-1]>(t[0][t.length-2]+t[1][t.length-1])/2) {
			oro[0][t.length-1] = '*';
		}
		else {
			oro[0][t.length-1] = ' ';
		}
		if(t[t.length-1][0]>(t[t.length-2][0]+t[t.length-1][1])/2) {
			oro[t.length-1][0] = '*';
		}

		else {
			oro[t.length-1][0] = ' ';
		}
		if(t[t.length-1][t[0].length-1]>(t[t.length-1][t.length-2]+t[t.length-2][t.length-1])/2) {
			oro[t.length-1][t[0].length-1] = '*';
		}
		else {
			oro[t.length-1][t[0].length-1] = ' ';
		}
		for (int i=0;i<t.length;i++) {
			for (int j=0;j<t[0].length;j++) {
				
				if (i!=0 && i!=t.length-1 && j!=0 && j!=t[0].length-1) {
					if (t[i][j] > ((t[i][j-1]+t[i][j+1]+t[i-1][j]+t[i+1][j])/4) ){
						oro[i][j]='*';
					}
					else {
						oro[i][j]=' ';
					}
				}
				else if(j!=0 && j!=t.length-1) {
					if (t[0][j] > (t[0][j-1]+t[0][j+1]+t[1][j])/3) {
						oro[0][j]='*';
					}
					else {
						oro[0][j]=' ';
					}
				}
				else if(i!=0 && i!=t.length-1) {
					if (t[i][0] > (t[i-1][0]+t[i+1][0]+t[i][1])/3) {
						oro[i][0]='*';
					}
					else {
						oro[i][0]=' ';
					}
				}
			}
		}
		for (int i=0;i<oro.length;i++) {
			for (int j=0;j<oro[0].length;j++) {
				System.out.print(oro[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
}