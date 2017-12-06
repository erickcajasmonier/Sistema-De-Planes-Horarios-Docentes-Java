package jdbc;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Usuario;
import util.Conexion;

public class UsuarioJDBC {
	
	public boolean registrarUsuario(Usuario bean)
	{
		boolean resultado = false;
		String sql = "INSERT INTO USUARIO (idusuario, nombreUsu, Password,nombre,ape_Pat,ape_Mat,correoE,perfil,usu_crea_reg) VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);

			ps.setString(1,bean.getIdUsuario());
			ps.setString(2, bean.getNombreUsu());
			ps.setString(3, bean.getPassword());
			ps.setString(4, bean.getNombre());
			ps.setString(5, bean.getApe_Pat());
			ps.setString(6, bean.getApe_Mat());
			ps.setString(7, bean.getCorreo());
			ps.setInt(8, bean.getPerfil());
			ps.setString(9, bean.getUsu_crea_reg());

			resultado = ps.executeUpdate() == 1 ? true : false;

		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return resultado;
	}
	
	public boolean registrarDetalleUsuario(String idusuario, String escuela, int perfil)
	{
		boolean resultado = false;
		String sql = "INSERT INTO det_usu_esc (idUsuario, idEscuela, idPerfl) VALUES (?,?,?)";

		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);

			ps.setString(1, idusuario);
			ps.setString(2, escuela);
			ps.setInt(3,  perfil);
			
			

			resultado = ps.executeUpdate() == 1 ? true : false;

		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return resultado;
	}

	public Usuario buscarUsuario(String nombreUsu) throws Exception {
		String sql = "SELECT *  FROM Usuario WHERE nombreUsu=? ";
		Usuario bean = new Usuario();
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);
			ps.setString(1, nombreUsu);
			ResultSet rs = ps.executeQuery();
			System.out.println("Ejecuta sql : " + sql);

			if (rs.next()) {
				bean.setIdUsuario(rs.getString(1));
				bean.setNombreUsu(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setApe_Pat(rs.getString(5));
				bean.setApe_Mat(rs.getString(6));
				bean.setCorreo(rs.getString(7));
				bean.setPerfil(rs.getInt(8));
				
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return bean;
	}
	
	public boolean modificarUsuario(Usuario bean) throws Exception {
		boolean resultado = false;
		String sql = "UPDATE Usuario SET "
				+ "idusuario='" + bean.getIdUsuario() + "'"
				+ ",nombreUsu='" + bean.getNombreUsu() + "'"
				+ ",Password='" + bean.getPassword() + "'"
				+ ",nombre='" + bean.getNombre()+ "'"
				+ ",ape_Pat='" + bean.getApe_Pat() + "'"
				+ ",ape_Mat='" + bean.getApe_Mat()  +"'"
				+ ",correoE='" + bean.getCorreo() + "'"
				+ ",perfil='"  + bean.getPerfil() + "'"
				+ " WHERE nombreUsu= '"+bean.getNombreUsu()+"'"; 
		try {
			Conexion con= new Conexion();
			
			resultado = con.executeUpdate(sql) == 1 ? true : false;
			System.out.println("Ejecuta sql : " + sql);	
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}
	public boolean modificarContraseña(Usuario bean) throws Exception {
		boolean resultado = false;
		String sql = "UPDATE Usuario SET "
				+ "Password='" + bean.getPassword() + "'"
				+ " WHERE nombreUsu= '"+bean.getNombreUsu()+"'"; 
		try {
			Conexion con= new Conexion();
			
			resultado = con.executeUpdate(sql) == 1 ? true : false;
			System.out.println("Ejecuta sql : " + sql);	
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}
	
	public boolean cambiarContraseña(Usuario bean) throws Exception {
		boolean resultado = false;
		String sql = "UPDATE Usuario SET "
				+ "Password='" + bean.getPassword() + "'"
				+ " WHERE nombreUsu= '"+bean.getIdUsuario()+"'"; 
		try {
			Conexion con= new Conexion();
			
			resultado = con.executeUpdate(sql) == 1 ? true : false;
			System.out.println("Ejecuta sql : " + sql);	
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}

	public Usuario verificar(String idusuario, String password) throws Exception {
		String sql = "SELECT *  FROM Usuario WHERE nombreUsu=? and Password=?";
		Usuario bean = new Usuario();
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);
			ps.setString(1, idusuario);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			System.out.println("Ejecuta sql : " + sql);

			if (rs.next()) {
				bean.setIdUsuario(rs.getString(1));
				bean.setNombreUsu(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setApe_Pat(rs.getString(5));
				bean.setApe_Mat(rs.getString(6));
				bean.setCorreo(rs.getString(7));
				bean.setPerfil(rs.getInt(8));
				
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return bean;
	}
	
	public boolean eliminarUsuario(String nombreUsu) throws Exception{
		boolean resultado = false;
		String sql = "Delete from USUARIO where nombreUsu='"+nombreUsu+"' limit 1";
		try{
			Conexion con = new Conexion();
			
			resultado = con.executeUpdate(sql) == 1?true:false;
			System.out.println("Ejecuta sql:" + sql);
		}catch(Exception e){
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return resultado;
		
		
		
	}
	
}
