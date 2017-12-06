package jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Escuela;
import util.Conexion;

public class EscuelaJDBC {

	public List<Escuela> listarEscuelas() {

		List<Escuela> lista = new ArrayList<Escuela>();
		String sql = "SELECT * FROM ESCUELA";
		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);

			while (rs.next()) {
				Escuela bean = new Escuela();

				bean.setIdescuela(rs.getString(1));
				bean.setDescripcion(rs.getString(2));
				bean.setFacultad(rs.getString(3));

				lista.add(bean);
			}

		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<Escuela> listar(String escuela) {

		List<Escuela> lista = new ArrayList<Escuela>();
		String sql = "SELECT descripcion FROM ESCUELA where idescuela='"+escuela+"'";
		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);

			while (rs.next()) {
				Escuela bean = new Escuela();

				bean.setDescripcion(rs.getString(1));

				lista.add(bean);
			}

		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return lista;
	}
}
