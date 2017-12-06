package dto;

public class DTOHorarios {
	private String ciclo;
	private String tur;
	private String cod_cur;
	private String cod_cur_teoria;
	private String profesor;
	private String curso;
	private String desres;
	private String seccion;
	private String aula;
	private String escuela;
	private String numcre;
	private String lunes;
	private String martes;
	private String miercoles;
	private String jueves;
	private String viernes;
	private String sabado;
	private String domingo;
	private int horasxsemana;
	private int index;
	
	public DTOHorarios() {
		this.ciclo = "";
		this.tur = "";
		this.cod_cur = "";
		this.cod_cur_teoria = "";
		this.profesor = "";
		this.curso = "";
		this.desres = "";
		this.seccion = "";
		this.aula = "";
		this.escuela = "";
		this.numcre = "";
		this.lunes = "";
		this.martes = "";
		this.miercoles = "";
		this.jueves = "";
		this.viernes = "";
		this.sabado = "";
		this.domingo = "";
		this.horasxsemana = 0;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public String getDesres() {
		return desres;
	}
	public void setDesres(String desres) {
		this.desres = desres;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getTur() {
		return tur;
	}
	public void setTur(String tur) {
		this.tur = tur;
	}
	public String getNumcre() {
		return numcre;
	}
	public void setNumcre(String numcre) {
		this.numcre = numcre;
	}
	public String getCod_cur() {
		return cod_cur;
	}
	public void setCod_cur(String cod_cur) {
		this.cod_cur = cod_cur;
	}
	public String getCod_cur_teoria() {
		return cod_cur_teoria;
	}
	public void setCod_cur_teoria(String cod_cur_teoria) {
		this.cod_cur_teoria = cod_cur_teoria;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public String getEscuela() {
		return escuela;
	}
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}
	public String getLunes() {
		return lunes;
	}
	public void setLunes(String lunes) {
		this.lunes = lunes;
	}
	public String getMartes() {
		return martes;
	}
	public void setMartes(String martes) {
		this.martes = martes;
	}
	public String getMiercoles() {
		return miercoles;
	}
	public void setMiercoles(String miercoles) {
		this.miercoles = miercoles;
	}
	public String getJueves() {
		return jueves;
	}
	public void setJueves(String jueves) {
		this.jueves = jueves;
	}
	public String getViernes() {
		return viernes;
	}
	public void setViernes(String viernes) {
		this.viernes = viernes;
	}
	public String getSabado() {
		return sabado;
	}
	public void setSabado(String sabado) {
		this.sabado = sabado;
	}
	public String getDomingo() {
		return domingo;
	}
	public void setDomingo(String domingo) {
		this.domingo = domingo;
	}
	public int getHorasxsemana() {
		return horasxsemana;
	}
	public void setHorasxsemana(int horasxsemana) {
		this.horasxsemana = horasxsemana;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
