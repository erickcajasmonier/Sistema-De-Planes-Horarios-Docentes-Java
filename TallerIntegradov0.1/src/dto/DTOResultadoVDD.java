package dto;

public class DTOResultadoVDD {
	private String curso;
	private String nombres;
	private String lunes;
	private String martes;
	private String miercoles;
	private String jueves;
	private String viernes;
	private String sabado;
	private String domingo;
	private String mensaje1;
	private String mensaje2;
	private String mensaje3;
	private String mensaje4;
	private String mensaje5;
	private String mensaje6;
	private String mensaje7;
	
	public DTOResultadoVDD() {
		this.nombres = "";
		this.lunes = "";
		this.martes = "";
		this.miercoles = "";
		this.jueves = "";
		this.viernes = "";
		this.sabado = "";
		this.domingo = "";
		this.mensaje1 = "DNR";
		this.mensaje2 = "DNR";
		this.mensaje3 = "DNR";
		this.mensaje4 = "DNR";
		this.mensaje5 = "DNR";
		this.mensaje6 = "DNR";
		this.mensaje7 = "DNR";
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
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
	public String getMensaje1() {
		return mensaje1;
	}
	public void setMensaje1(String mensaje1) {
		this.mensaje1 = mensaje1;
	}
	public String getMensaje2() {
		return mensaje2;
	}
	public void setMensaje2(String mensaje2) {
		this.mensaje2 = mensaje2;
	}
	public String getMensaje3() {
		return mensaje3;
	}
	public void setMensaje3(String mensaje3) {
		this.mensaje3 = mensaje3;
	}
	public String getMensaje4() {
		return mensaje4;
	}
	public void setMensaje4(String mensaje4) {
		this.mensaje4 = mensaje4;
	}
	public String getMensaje5() {
		return mensaje5;
	}
	public void setMensaje5(String mensaje5) {
		this.mensaje5 = mensaje5;
	}
	public String getMensaje6() {
		return mensaje6;
	}
	public void setMensaje6(String mensaje6) {
		this.mensaje6 = mensaje6;
	}
	public String getMensaje7() {
		return mensaje7;
	}
	public void setMensaje7(String mensaje7) {
		this.mensaje7 = mensaje7;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
}
