package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Disponibilidad_Docente;
import util.Conexion;
public class Disponibilidad_DocenteJDBC {
	
	public boolean eliminarDisponibilidadDocente(String numdoc, String sem, String horini, String horfin, String dia) throws Exception{
		boolean resultado = false;
		/*String sql = "Delete from disponibilidad_docente where cod_Docente='"+id.substring(0,8)+"' "
				+ " and cod_semestre= '"+id.substring(8,9)+"' "
				+ " and hor_ini='"+id.substring(9,13)+" ' and hor_fin='"+id.substring(13,17)+" '"
				+ " and dia='"+id.substring(17)+"'";
				*/
		String sql = "Delete from disponibilidad_docente where cod_Docente='"+numdoc+"' "
		+ " and cod_semestre= '"+sem+"' "
		+ " and hor_ini='"+horini+" ' and hor_fin='"+horfin+" '"
		+ " and dia='"+dia+"'";
		
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
	
	public boolean eliminarDisponibilidadReferido(String numdoc, String sem, String horini, String horfin, String dia) throws Exception{
		boolean resultado = false;
		//String sql = "Delete from intereses_docente where idCurso='"+id.substring(0,11)+"' and "
		//		+ "codDocente='"+id.substring(11,19)+"' and cod_semestre='"+id.substring(19,20)+"'";
		String sql = "Delete from disponibilidad_referido where cod_Referido='"+numdoc+"' "
				+ " and cod_semestre= '"+sem+"' "
				+ " and hor_ini='"+horini+" ' and hor_fin='"+horfin+" '"
				+ " and dia='"+dia+"'";
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
	
	public List<Disponibilidad_Docente> listarDisponibilidadxDocente(String numdoc, String sem) throws Exception {
		
		List<Disponibilidad_Docente> lista = new ArrayList<Disponibilidad_Docente>();
		
		String sql = "select dia, hor_ini, hor_fin from disponibilidad_docente where cod_Docente = '" 
		+ numdoc + "' and cod_semestre='" + sem +"'";

		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			System.out.println("Ejecuta sql : " + sql);
			while (rs.next()) {
				Disponibilidad_Docente bean = new Disponibilidad_Docente();
				
				bean.setDia(rs.getString(1));
				bean.setHora_ini(rs.getInt(2));
				bean.setHora_fin(rs.getInt(3));
				
				lista.add(bean);
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Disponibilidad_Docente> listarDisponibilidadxReferido(String numdoc, String sem) throws Exception {
		
		List<Disponibilidad_Docente> lista = new ArrayList<Disponibilidad_Docente>();
		
		String sql = "select dia, hor_ini, hor_fin from disponibilidad_referido where "
				+ "cod_Referido ='" + numdoc +"' and cod_semestre= '"+sem+"'";

		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			System.out.println("Ejecuta sql : " + sql);

			while(rs.next()) {
				Disponibilidad_Docente bean = new Disponibilidad_Docente();
				
				bean.setDia(rs.getString(1));
				bean.setHora_ini(rs.getInt(2));
				bean.setHora_fin(rs.getInt(3));
				
				lista.add(bean);
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}

	public boolean registrarDisponiblidadDocente(Disponibilidad_Docente bean) {
		boolean flag = false;
		String sql = "INSERT INTO DISPONIBILIDAD_DOCENTE (cod_Docente,cod_semestre,hor_ini,hor_fin,dia) VALUES (?,?,?,?,?)";

		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);

			ps.setString(1, bean.getCod_docente());
			ps.setInt(2, bean.getCod_semestre());
			ps.setInt(3, bean.getHora_ini());
			ps.setInt(4, bean.getHora_fin());
			ps.setString(5, bean.getDia());

			flag = ps.executeUpdate() == 1 ? true : false;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean registrarDisponiblidadReferido(Disponibilidad_Docente bean) {
		boolean flag = false;
		String sql = "INSERT INTO DISPONIBILIDAD_REFERIDO (cod_Referido,cod_semestre,hor_ini,hor_fin,dia) VALUES (?,?,?,?,?)";

		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);

			ps.setString(1, bean.getCod_docente());
			ps.setInt(2, bean.getCod_semestre());
			ps.setInt(3, bean.getHora_ini());
			ps.setInt(4, bean.getHora_fin());
			ps.setString(5, bean.getDia());

			flag = ps.executeUpdate() == 1 ? true : false;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return flag;
	}

}
