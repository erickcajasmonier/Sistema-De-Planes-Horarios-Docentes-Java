package beans;

public class Referido {

	private int id;
	private String cod_docente;
	private String cod_semestre;
	private String nombre;
	private String apepat;
	private String apemat;
	private String numdoc; 
	private int edad;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApepat() {
		return apepat;
	}
	public void setApepat(String apepat) {
		this.apepat = apepat;
	}
	public String getApemat() {
		return apemat;
	}
	public void setApemat(String apemat) {
		this.apemat = apemat;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCod_docente() {
		return cod_docente;
	}
	public void setCod_docente(String cod_docente) {
		this.cod_docente = cod_docente;
	}
	public String getNumdoc() {
		return numdoc;
	}
	public void setNumdoc(String numdoc) {
		this.numdoc = numdoc;
	}
	public String getCod_semestre() {
		return cod_semestre;
	}
	public void setCod_semestre(String cod_semestre) {
		this.cod_semestre = cod_semestre;
	}
}
