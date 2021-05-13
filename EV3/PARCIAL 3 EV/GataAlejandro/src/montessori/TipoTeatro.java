package montessori;

public enum TipoTeatro {
	Clase1(20,"Comedia"),
	Clase2(10,"Drama"),
	Clase3(40,"Humor");
	
	int porcentaje;
	String descripcion;
	
	
	TipoTeatro(int porcentaje, String descripcion){
		this.porcentaje = porcentaje;
		this.descripcion = descripcion;
	}


	public int getPorcentaje() {
		return porcentaje;
	}


	public String getDescripcion() {
		return descripcion;
	}
}
