package beans;

public class Curso {
	private int id;
	private String sicat;
	private String idCurso;
	private String nombre;
	private int credito;
	private int horaTeoria;
	private int horaLaboratorio;
	private int horaPractica;
	private int estado;
	private String requisito01;
	private String requisito02;
	private String requisito03;
	private String corequisito;
	private String creditoRequisito;
	private String nombrePropietario;
	private String userCrea;
	private String userMod;
	private String fechCrea;
	public String getUserCrea() {
		return userCrea;
	}
	public void setUserCrea(String userCrea) {
		this.userCrea = userCrea;
	}
	public String getUserMod() {
		return userMod;
	}
	public void setUserMod(String userMod) {
		this.userMod = userMod;
	}
	public String getFechCrea() {
		return fechCrea;
	}
	public void setFechCrea(String fechCrea) {
		this.fechCrea = fechCrea;
	}
	public String getFechMod() {
		return fechMod;
	}
	public void setFechMod(String fechMod) {
		this.fechMod = fechMod;
	}
	private String fechMod;
	
	
	public String getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCredito() {
		return credito;
	}
	public void setCredito(int credito) {
		this.credito = credito;
	}
	public int getHoraTeoria() {
		return horaTeoria;
	}
	public void setHoraTeoria(int horaTeoria) {
		this.horaTeoria = horaTeoria;
	}
	public int getHoraLaboratorio() {
		return horaLaboratorio;
	}
	public void setHoraLaboratorio(int horaLaboratorio) {
		this.horaLaboratorio = horaLaboratorio;
	}
	public int getHoraPractica() {
		return horaPractica;
	}
	public void setHoraPractica(int horaPractica) {
		this.horaPractica = horaPractica;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getRequisito01() {
		return requisito01;
	}
	public void setRequisito01(String requisito01) {
		this.requisito01 = requisito01;
	}
	public String getRequisito02() {
		return requisito02;
	}
	public void setRequisito02(String requisito02) {
		this.requisito02 = requisito02;
	}
	public String getRequisito03() {
		return requisito03;
	}
	public void setRequisito03(String requisito03) {
		this.requisito03 = requisito03;
	}
	public String getCorequisito() {
		return corequisito;
	}
	public void setCorequisito(String corequisito) {
		this.corequisito = corequisito;
	}
	public String getCreditoRequisito() {
		return creditoRequisito;
	}
	public void setCreditoRequisito(String creditoRequisito) {
		this.creditoRequisito = creditoRequisito;
	}
	public String getNombrePropietario() {
		return nombrePropietario;
	}
	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSicat() {
		return sicat;
	}
	public void setSicat(String sicat) {
		this.sicat = sicat;
	}

}
