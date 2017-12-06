package jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;
import beans.Semestre;

public class SemestreJDBC {

public List<Semestre> listarSemestre(){
		
		List<Semestre> lista = new ArrayList<Semestre>();
		
		try{
			Conexion con = new Conexion();
			String sql = "select * from semestre order by idSemestre asc;";
			System.out.println("consulta :"+sql);
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				Semestre bean = new Semestre();				
				bean.setIdSemestre(rs.getInt(1));
				bean.setAño(rs.getInt(2));
				bean.setSemestre(rs.getInt(3));
				bean.setCantidadSemana(rs.getInt(4));
				bean.setCred_especialidad(rs.getInt(5));
				bean.setCred_general(rs.getInt(6));
				lista.add(bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}

	public int agregarSemestre(Semestre bean) {
		// TODO Auto-generated method stub
		int resultado = 0;		
		try{
			Conexion con = new Conexion();
			String sql = "Insert into semestre (idSemestre,ano,semestre,cant_sema,cred_especialidad,cred_general)"
					+ " values('"+bean.getIdSemestre()+"','"+bean.getAño()+"','"+bean.getSemestre()
					+"','"+bean.getCantidadSemana()+"','"+bean.getCred_especialidad()+"','"+bean.getCred_general()+"')";
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return resultado;
	}

	public Semestre preagregarSemestre() {
		// TODO Auto-generated method stub
		Semestre bean = null;
		
		try{
			Conexion con = new Conexion();
			String sql = "Select * from semestre WHERE CAST(idSemestre AS UNSIGNED) = "
					+ "cast((Select max(cast(idSemestre as unsigned)) from semestre) as unsigned)";	
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				bean = new Semestre();
				bean.setIdSemestre(rs.getInt(1));
				bean.setAño(rs.getInt(2));
				bean.setSemestre(rs.getInt(3));
				bean.setCantidadSemana(rs.getInt(4));
				bean.setCred_especialidad(rs.getInt(5));
				bean.setCred_general(rs.getInt(6));
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		return bean;
	}

	public int eliminarSemestre(int idSemestre) {
		// TODO Auto-generated method stub
		int resultado = 0;
		
		try{
			Conexion con = new Conexion();
			String sql = "Delete from semestre where idSemestre='"+idSemestre+"'";
			resultado = con.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return resultado;
	}

	public Semestre preactualizarSemestre(int idSemestre) {
		// TODO Auto-generated method stub
		Semestre bean = null;
		
		try{
			Conexion con = new Conexion();
			String sql = "select idSemestre,ano,semestre,cant_sema,cred_especialidad,cred_general from semestre where idSemestre="+idSemestre+"";
			System.out.println("consulta :"+sql);
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				bean = new Semestre();
				bean.setIdSemestre(rs.getInt(1));
				bean.setAño(rs.getInt(2));
				bean.setSemestre(rs.getInt(3));
				bean.setCantidadSemana(rs.getInt(4));
				bean.setCred_especialidad(rs.getInt(5));
				bean.setCred_general(rs.getInt(6));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return bean;
	}

	public int actualizarSemestre(Semestre bean) {
		// TODO Auto-generated method stub
		int resultado = 0;		
		try{
			Conexion con = new Conexion();
			String sql = "Update semestre set ano='"+bean.getAño()+"',semestre='"+bean.getSemestre()+"',cant_sema='"
					+bean.getSemestre()+"',cred_especialidad='"+bean.getCred_especialidad()+"',cred_general='"
					+bean.getCred_general()+"' where idSemestre='"+bean.getIdSemestre()+"';";
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return resultado;
	}

}
