package jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;
import beans.Curso;

public class CursoJDBC {

	public List<Curso> listarCurso(){
		
		List<Curso> lista = new ArrayList<Curso>();
		
		try{
			Conexion con = new Conexion();
			String sql = "Select * from curso";
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				Curso bean = new Curso();
				bean.setId(rs.getInt(1));
				bean.setIdCurso(rs.getString(2));
				bean.setSicat(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setCredito(rs.getInt(5));
				bean.setHoraTeoria(rs.getInt(6));
				bean.setHoraLaboratorio(rs.getInt(7));
				bean.setHoraPractica(rs.getInt(8));
				bean.setEstado(rs.getInt(9));
				bean.setRequisito01(rs.getString(10));
				bean.setRequisito02(rs.getString(11));
				bean.setRequisito03(rs.getString(12));
				bean.setCorequisito(rs.getString(13));
				bean.setCreditoRequisito(rs.getString(14));
				bean.setNombrePropietario(rs.getString(15));
				
				lista.add(bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Curso> listarCursoDisponible(int idEscuela, int idPlan){
		
		List<Curso> lista = new ArrayList<Curso>();
		
		try{
			Conexion con = new Conexion();
			String sql = "SELECT * FROM curso a where a.idcurso not in (select distinct b.codDce_curso from det_curso_esc b "
					+ "where codDce_escuela='"+idEscuela+"' and idplan='"+idPlan+"') and not a.creditos=0;";
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				Curso bean = new Curso();
				bean.setId(rs.getInt(1));
				bean.setIdCurso(rs.getString(2));
				bean.setSicat(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setCredito(rs.getInt(5));
				bean.setHoraTeoria(rs.getInt(6));
				bean.setHoraLaboratorio(rs.getInt(7));
				bean.setHoraPractica(rs.getInt(8));
				bean.setEstado(rs.getInt(9));
				bean.setRequisito01(rs.getString(10));
				bean.setRequisito02(rs.getString(11));
				bean.setRequisito03(rs.getString(12));
				bean.setCorequisito(rs.getString(13));
				bean.setCreditoRequisito(rs.getString(14));
				bean.setNombrePropietario(rs.getString(15));
				
				lista.add(bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
/*
	public int actualizarEstadoCurso(int estadoCurso, String idCurso) {
		// TODO Auto-generated method stub
		int resultado = 0;
		String sql="";
		try{
			Conexion con = new Conexion();
			if(estadoCurso==1){				
				sql = "Update curso set estado_hab_inhab='0' where idcurso='"+idCurso+"'";				
			}else if(estadoCurso==0){
				sql = "Update curso set estado_hab_inhab='1' where idcurso='"+idCurso+"'";				
			}
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return resultado;
	}
*/	
	public int actualizarEstadoCurso(int estadoCurso, String id) {
		// TODO Auto-generated method stub
		int resultado = 0;
		String sql="";
		try{
			Conexion con = new Conexion();
			if(estadoCurso==0){				
				sql = "Update curso set estado_hab_inhab='1' where index_curso='"+id+"'";				
			}else if(estadoCurso==1){
				sql = "Update curso set estado_hab_inhab='0' where index_curso='"+id+"'";				
			}
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return resultado;
	}
/*
	public Curso listarCursoporid(String idCurso) {
		// TODO Auto-generated method stub
		Curso bean = null;
		
		try{
			Conexion con = new Conexion();
			String sql = "Select * from curso where idcurso='"+idCurso+"'";			
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				bean = new Curso();
				bean.setIdCurso(rs.getString(1));
				bean.setNombre(rs.getString(2));
				bean.setCredito(rs.getInt(3));
				bean.setHoraTeoria(rs.getInt(4));
				bean.setHoraLaboratorio(rs.getInt(5));
				bean.setHoraPractica(rs.getInt(6));
				bean.setEstado(rs.getInt(7));
				bean.setRequisito01(rs.getString(8));
				bean.setRequisito02(rs.getString(9));
				bean.setRequisito03(rs.getString(10));
				bean.setCorequisito(rs.getString(11));
				bean.setCreditoRequisito(rs.getString(12));
				bean.setNombrePropietario(rs.getString(13));
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		return bean;
	}
*/	
	public Curso listarCursoporid(String id) {
		// TODO Auto-generated method stub
		Curso bean = null;
		
		try{
			Conexion con = new Conexion();
			String sql = "Select * from curso where index_curso='"+id+"'";			
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				bean = new Curso();
				bean.setId(rs.getInt(1));
				bean.setIdCurso(rs.getString(2));
				bean.setSicat(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setCredito(rs.getInt(5));
				bean.setHoraTeoria(rs.getInt(6));
				bean.setHoraLaboratorio(rs.getInt(7));
				bean.setHoraPractica(rs.getInt(8));
				bean.setEstado(rs.getInt(9));
				bean.setRequisito01(rs.getString(10));
				bean.setRequisito02(rs.getString(11));
				bean.setRequisito03(rs.getString(12));
				bean.setCorequisito(rs.getString(13));
				bean.setCreditoRequisito(rs.getString(14));
				bean.setNombrePropietario(rs.getString(15));
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		return bean;
	}

	public int actualizarCurso(Curso bean) {
		// TODO Auto-generated method stub
		int resultado = 0;
		
		try{
			Conexion con = new Conexion();
			String sql = "Update curso set index_curso='"+bean.getId()+"',idcurso='"+bean.getIdCurso()+"',sicat='"+bean.getSicat()+"',nombre='"+bean.getNombre()+"',"
					+ "creditos='"+bean.getCredito()+"',h_teo='"+bean.getHoraTeoria()+"',"
					+ "h_lab='"+bean.getHoraLaboratorio()+"',h_pract='"+bean.getHoraPractica()+"',"
					+ "nombreProp='"+bean.getNombrePropietario()+"',req01='"+bean.getRequisito01()+"',"
					+ "req02='"+bean.getRequisito02()+"',req03='"+bean.getRequisito03()+"',"
					+ "cooreq='"+bean.getCorequisito()+"',cred_req='"+bean.getCreditoRequisito()+"'"
					+ " where index_curso='"+bean.getId()+"'";
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return resultado;
	}

	public int agregarCurso(Curso bean) {
		// TODO Auto-generated method stub
		int resultado = 0;		
		try{
			Conexion con = new Conexion();
			String sql = "Insert into curso (idcurso,sicat,nombre,creditos,h_teo,h_lab,h_pract,estado_hab_inhab,req01,req02,req03,cooreq,cred_req,nombreProp)"
					+ " values('"+bean.getIdCurso()+"','"+bean.getSicat()+"','"+bean.getNombre()+"','"+bean.getCredito()+"','"+bean.getHoraTeoria()+"',"
					+ "'"+bean.getHoraLaboratorio()+"','"+bean.getHoraPractica()+"','"+bean.getEstado()+"',"
					+ "'"+bean.getRequisito01()+"','"+bean.getRequisito02()+"','"+bean.getRequisito03()+"',"
					+ "'"+bean.getCorequisito()+"','"+bean.getCreditoRequisito()+"','"+bean.getNombrePropietario()+"')";
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return resultado;
	}
}
