package entidades;

public enum Reputacion {
	BUENA(1, "Es un árbitro con buena reputación"),
	NORMAL(2, "Es un árbitro con una reputación normal"),
	MALA(3, "Es un árbitro con mala reputación");
	
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