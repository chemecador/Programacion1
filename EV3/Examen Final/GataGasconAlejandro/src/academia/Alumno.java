package academia;

public class Alumno extends Persona {
	private float nota;

	public Alumno() {
		super();
		this.nota = 0.0f;
	}

	public Alumno(String dni, String nombre, float nota) {
		super(dni, nombre);
		this.nota = nota;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [nota=" + nota + "]";
	}

	public void rellenar() {
		super.rellenar();
		System.out.println("Nota del alumno: ");
		this.nota = in.nextInt();
		in.nextLine();
	}

	public void visualizar() {
		super.visualizar();
		System.out.println("Su nota es: " + this.nota);

	}

	public int compareTo(Persona otraPersona) {
		return (super.getDni().compareTo(otraPersona.getDni()));
	}


}
