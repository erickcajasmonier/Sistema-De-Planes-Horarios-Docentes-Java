package beans;

public class Horario {
	private int idHorario;
	private String codH_sem;
	private String codH_curso;
	private int codH_doc;
	private String codH_secc;
	private String codH_aula;
	private String dia;
	private int hora_ini;
	private int hora_fin;
	private String cod_esc;
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public String getCodH_sem() {
		return codH_sem;
	}
	public void setCodH_sem(String codH_sem) {
		this.codH_sem = codH_sem;
	}
	public String getCodH_curso() {
		return codH_curso;
	}
	public void setCodH_curso(String codH_curso) {
		this.codH_curso = codH_curso;
	}
	public int getCodH_doc() {
		return codH_doc;
	}
	public void setCodH_doc(int codH_doc) {
		this.codH_doc = codH_doc;
	}
	public String getCodH_secc() {
		return codH_secc;
	}
	public void setCodH_secc(String codH_secc) {
		this.codH_secc = codH_secc;
	}
	public String getCodH_aula() {
		return codH_aula;
	}
	public void setCodH_aula(String codH_aula) {
		this.codH_aula = codH_aula;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
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
	public String getCod_esc() {
		return cod_esc;
	}
	public void setCod_esc(String cod_esc) {
		this.cod_esc = cod_esc;
	}
}
