package beans;

public class Disponibilidad_Docente {
	private int id;
	private String cod_docente;
	private int cod_semestre;
	private int hora_ini;
	private int hora_fin;
	private String dia;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCod_docente() {
		return cod_docente;
	}
	public void setCod_docente(String cod_docente) {
		this.cod_docente = cod_docente;
	}
	public int getCod_semestre() {
		return cod_semestre;
	}
	public void setCod_semestre(int cod_semestre) {
		this.cod_semestre = cod_semestre;
	}
	public int getHora_ini() {
		return hora_ini;
	}
	public void setHora_ini(int hora_ini) {
		this.hora_ini = hora_ini;
	}
	public int getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(int hora_fin) {
		this.hora_fin = hora_fin;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
}
