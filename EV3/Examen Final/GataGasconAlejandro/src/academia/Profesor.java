package academia;

public class Profesor extends Persona{
	private Especialidad especialidad;
	
	public Profesor(){
		super();
		this.especialidad = null;
	}
	public Profesor(String dni, String nombre, Especialidad especialidad){
		super(dni,nombre);
		this.especialidad = especialidad;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	@Override
	public String toString() {
		return "Profesor [especialidad=" + especialidad + "]";
	}
	public void rellenar() {
		super.rellenar();
		System.out.println("Introduce la especialidad. Aquí te muestro los diferentes tipos");
		Especialidad.mostrarTipos();
		boolean error;
		do {
			try {
				this.especialidad = Especialidad.valueOf(in.nextLine().toUpperCase());
				error = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Los valores solo pueden ser INF o MKT. Prueba de nuevo");
				error = true;
			}
		} while (error);
	}
	public void visualizar() {
		super.visualizar();
		System.out.println("Su especialidad es " + this.especialidad);
		System.out.println();
	}
	public int compareTo(Persona otraPersona) {
		return (super.getDni().compareTo(otraPersona.getDni()));
	}
}
