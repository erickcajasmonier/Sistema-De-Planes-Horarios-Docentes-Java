package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Perfil;
import util.Conexion;


public class PerfilesJDBC {

	public boolean registrarPermisos(Perfil bean)
	{
		boolean flag = false;
		String sql = "INSERT INTO PERFIL (nombre, permisos) VALUES (?,?)";
		
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);

			ps.setString(1, bean.getNombre());
			ps.setString(2, bean.getPermiso());

			flag = ps.executeUpdate() == 1 ? true : false;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean eliminarPermisos(String nombre) throws Exception{
		boolean resultado = false;
		String sql = "Delete from PERFIL where nombre='"+nombre+"' limit 1";
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
	
	
	public Perfil buscarPermisos(String nombre, String permisos) throws Exception {
		String sql = "SELECT *  FROM PERFIL WHERE NOMBRE=? AND PERMISOS=?";
		Perfil bean = new Perfil();
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, permisos);
			ResultSet rs = ps.executeQuery();
			System.out.println("Ejecuta sql : " + sql);

			if (rs.next()) {
				bean.setNombre(rs.getString(1));
				bean.setPermiso(rs.getString(2));
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return bean;
	}
	
	public List<Perfil> listarPerfiles() {

		List<Perfil> lista = new ArrayList<Perfil>();
		String sql = "SELECT * FROM Perfil";
		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);

			while (rs.next()) {
				Perfil bean = new Perfil();

				bean.setIdperfil(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setPermiso(rs.getString(3));

				lista.add(bean);
			}

		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return lista;
	}
	

}
