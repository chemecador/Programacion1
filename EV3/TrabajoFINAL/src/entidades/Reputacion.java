package entidades;

public enum Reputacion {
	BUENA(1, "Es un �rbitro con buena reputaci�n"),
	NORMAL(2, "Es un �rbitro con una reputaci�n normal"),
	MALA(3, "Es un �rbitro con mala reputaci�n");
	
	private int n;
	private String descripcion;
	
	Reputacion(int n, String descripcion) {
		this.n = n;
		this.descripcion = descripcion;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}