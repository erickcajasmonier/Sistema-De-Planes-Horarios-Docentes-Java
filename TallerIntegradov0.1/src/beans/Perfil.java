package beans;

public class Perfil {
	private int idperfil;
	private String nombre;
	private String permiso;
	
	public int getIdperfil() {
		return idperfil;
	}
	public void setIdperfil(int idperfil) {
		this.idperfil = idperfil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPermiso()
	{
		return permiso;
	}
	public void setPermiso(String permiso)
	{
		this.permiso = permiso;
	}
}
