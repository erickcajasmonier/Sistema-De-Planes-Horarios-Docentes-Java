package dto;

public class DTOValidacionHorasPlan {
	private String sicat;
	private String sap;
	private String curso;
	private int horas_curso_excel;
	private int horas_curso_plan;
	private String seccion;
	private int flag;
	
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getSicat() {
		return sicat;
	}
	public void setSicat(String sicat) {
		this.sicat = sicat;
	}
	public String getSap() {
		return sap;
	}
	public void setSap(String sap) {
		this.sap = sap;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getHoras_curso_excel() {
		return horas_curso_excel;
	}
	public void setHoras_curso_excel(int horas_curso_excel) {
		this.horas_curso_excel = horas_curso_excel;
	}
	public int getHoras_curso_plan() {
		return horas_curso_plan;
	}
	public void setHoras_curso_plan(int horas_curso_plan) {
		this.horas_curso_plan = horas_curso_plan;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
