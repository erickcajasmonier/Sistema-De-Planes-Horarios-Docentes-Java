package jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Curso;
import beans.Det_Curso_Esc;
import util.Conexion;

public class Det_Curso_EscuelaJDBC {

	public List<Curso> cursoxescuelaxciclo(String id_escuela, int ciclo) {
		List<Curso> lista = new ArrayList<Curso>();
		String sql = "SELECT D.CODDCE_CURSO, C.NOMBRE, D.CODDCE_ESCUELA "
					+ "FROM DET_CURSO_ESC AS D "
					+ "INNER JOIN CURSO AS C ON C.IDCURSO = D.CODDCE_CURSO "
					+ "WHERE D.CODDCE_ESCUELA = '" + id_escuela + "' AND D.CICLO = " + ciclo;
		try {
			Conexion con = new Conexion();

			ResultSet rs = con.executeQuery(sql);

			while (rs.next()) {
				Curso bean = new Curso();
				bean.setIdCurso(rs.getString(1));
				bean.setNombre(rs.getString(2));
				lista.add(bean);
			}

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<Curso> cursoxescuela(String id_escuela) {
		List<Curso> lista = new ArrayList<Curso>();
		String sql = "SELECT DISTINCT D.CODDCE_CURSO, C.NOMBRE "
					+ "FROM DET_CURSO_ESC AS D "
					+ "INNER JOIN CURSO AS C ON C.IDCURSO = D.CODDCE_CURSO "
					+ "WHERE D.CODDCE_ESCUELA = '" + id_escuela + "'";
		try {
			Conexion con = new Conexion();

			ResultSet rs = con.executeQuery(sql);

			while (rs.next()) {
				Curso bean = new Curso();
				bean.setIdCurso(rs.getString(1));
				bean.setNombre(rs.getString(2));
				lista.add(bean);
			}

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<Curso> cursoxpropietario(String prop) {
		List<Curso> lista = new ArrayList<Curso>();

		String sql="select idcurso, nombre from curso where nombreProp like '"+prop+"%'";
		System.out.println(sql);
		try {
			Conexion con = new Conexion();

			ResultSet rs = con.executeQuery(sql);

			while (rs.next()) {
				Curso bean = new Curso();
				bean.setIdCurso(rs.getString(1));
				bean.setNombre(rs.getString(2));
				lista.add(bean);
			}

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<Curso> listarCur() {

		List<Curso> lista = new ArrayList<Curso>();
		String sql = "SELECT IDCURSO, NOMBRE FROM CURSO";
		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);

			while (rs.next()) {
				Curso bean = new Curso();

				bean.setIdCurso(rs.getString(1));
				bean.setNombre(rs.getString(2));

				lista.add(bean);
			}

		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<Curso> listarPropietario() {

		List<Curso> lista = new ArrayList<Curso>();
		String sql = "select distinct nombreProp from curso where nombreProp is NOT NULL";
		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);

			while (rs.next()) {
				Curso bean = new Curso();

				bean.setNombrePropietario(rs.getString(1));
				lista.add(bean);
			}

		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return lista;
	}

	public List<Det_Curso_Esc> listarciclos() {
		List<Det_Curso_Esc> lista = new ArrayList<Det_Curso_Esc>();
		String sql = "SELECT DISTINCT CICLO FROM DET_CURSO_ESC WHERE CICLO IS NOT NULL ORDER BY CICLO";
		
		try {
			Conexion con = new Conexion();
			
			ResultSet rs = con.executeQuery(sql);
			
			while(rs.next()){
				Det_Curso_Esc bean = new Det_Curso_Esc();
				bean.setCiclo(rs.getInt(1));
				lista.add(bean);
			}
			
		} catch (Exception e) {
			System.out.println();
		}
		return lista;
	}
}
