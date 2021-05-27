package academia;

public enum Especialidad {
	INF(1,"Informática"),
	MKT(2,"Marketing");
	
	private int n;
	private String tipo;
	
	Especialidad(int n, String tipo){
		this.n = n;
		this.tipo = tipo;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public static void mostrarTipos() {
		System.out.println("INF, con ID: 1 y descripción: \"Informática\"");
		System.out.println("MKT, con ID:2 y descripción: \"Marketing\"");
	}
	public String toString() {
		return ("INF, con ID: 1 y descripción: \"Informática\",\nMKT, con ID:2 y descripción: \"Marketing\"");
	}
}
