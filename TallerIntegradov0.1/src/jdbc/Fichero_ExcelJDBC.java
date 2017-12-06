package jdbc;

import java.sql.ResultSet;

import beans.Fichero_Excel;
import util.Conexion;

public class Fichero_ExcelJDBC {
	public Fichero_Excel getFichero() {
		String sql = "SELECT MAX(DESCRIPCION) FROM fichero_excel";
		Fichero_Excel bean = new Fichero_Excel();
		
		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			
			if(rs.next()){
				bean.setDescripcion(rs.getString(1));
			}
			
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return bean;
	}

	public boolean registrarFichero(String nombre_fichero) {
		boolean flag = false;
		String sql = "INSERT INTO fichero_excel (descripcion) " + "VALUES ('" + nombre_fichero + "')";
		try {
			Conexion con = new Conexion();
			flag = con.executeUpdate(sql) == 1 ? true : false;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return flag;
	}
}
