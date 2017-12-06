package beans;

public class Usuario {
	private String idUsuario;
	private String nombreUsu;
	private String password;
	private String nombre;
	private String ape_Pat;
	private String ape_Mat;
	private String correo;
	private int perfil;
	private int escuela;
	private String usu_crea_reg;
	private String usu_mod_reg;
	private String fec_crea_reg;
	private String fec_mod_reg;
	
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsu() {
		return nombreUsu;
	}
	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApe_Pat() {
		return ape_Pat;
	}
	public void setApe_Pat(String ape_Pat) {
		this.ape_Pat = ape_Pat;
	}
	public String getApe_Mat() {
		return ape_Mat;
	}
	public void setApe_Mat(String ape_Mat) {
		this.ape_Mat = ape_Mat;
	}
	public String getCorreo()
	{
		return correo;
	}
	public void setCorreo(String correo)
	{
		this.correo=correo;
	}
	public int getPerfil() {
		return perfil;
	}
	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	public String getUsu_crea_reg() {
		return usu_crea_reg;
	}
	public void setUsu_crea_reg(String usu_crea_reg) {
		this.usu_crea_reg = usu_crea_reg;
	}
	public String getUsu_mod_reg() {
		return usu_mod_reg;
	}
	public void setUsu_mod_reg(String usu_mod_reg) {
		this.usu_mod_reg = usu_mod_reg;
	}
	public String getFec_crea_reg() {
		return fec_crea_reg;
	}
	public void setFec_crea_reg(String fec_crea_reg) {
		this.fec_crea_reg = fec_crea_reg;
	}
	public String getFec_mod_reg() {
		return fec_mod_reg;
	}
	public void setFec_mod_reg(String fec_mod_reg) {
		this.fec_mod_reg = fec_mod_reg;
	}
	public int getEscuela() {
		return escuela;
	}
	public void setEscuela(int escuela) {
		this.escuela = escuela;
	}
	
}