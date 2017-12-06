package jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;
import beans.DetallePlanCurricular;

public class DetallePlanCurricularJDBC {
	
	public List<DetallePlanCurricular> listarDetallePlanCurricular(int idPlanCurricular, int idEscuela) {
		// TODO Auto-generated method stub
		List<DetallePlanCurricular> lista = new ArrayList<DetallePlanCurricular>();
		
		try{
			Conexion con = new Conexion();
			String sql = "SELECT a.idcurso, a.nombre, a.creditos, b.codDce_escuela, b.idPlan, b.codDce_sem, b.ciclo, b.estado "+
			"from curso a, det_curso_esc b where a.idcurso=b.codDce_curso and idPlan='"+idPlanCurricular+
			"' and codDce_escuela='"+idEscuela+"' order by ciclo asc;";
			System.out.println("consulta :"+sql);
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				DetallePlanCurricular bean = new DetallePlanCurricular();				
				bean.setCodDce_curso(rs.getString(1));
				bean.setNombre_curso(rs.getString(2));
				bean.setCredito(rs.getInt(3));
				bean.setCodDce_escuela(rs.getInt(4));
				bean.setIdPlan(rs.getInt(5));
				bean.setCodDce_sem(rs.getInt(6));
				bean.setCiclo(rs.getInt(7));				
				bean.setEstado(rs.getInt(8));								
				lista.add(bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	/*
	public List<Curso> listarCurso(){
		
		List<Curso> lista = new ArrayList<Curso>();
		
		try{
			Conexion con = new Conexion();
			String sql = "select * from curso group by idcurso;";
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				Curso bean = new Curso();				
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
				
				lista.add(bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		return lista;
	}
	*/
	public List<DetallePlanCurricular> listarDetallePlanCurricularCiclo(int idPlanCurricular, int idEscuela, int ciclo) {
		// TODO Auto-generated method stub
		List<DetallePlanCurricular> lista = new ArrayList<DetallePlanCurricular>();
		
		try{
			Conexion con = new Conexion();
			String sql = "SELECT a.idcurso, a.nombre, a.creditos, b.codDce_escuela, b.idPlan, b.codDce_sem, b.ciclo, b.estado, b.cat_fia, b.tipo_fia, b.tipo_sunedu, b.tipo_pres_virt "+
			"from det_curso_esc b inner join curso a on a.idcurso=b.codDce_curso where idPlan='"+idPlanCurricular+
			"' and codDce_escuela='"+idEscuela+"' and b.ciclo='"+ciclo+"' and b.estado='1' and not a.creditos=0 order by a.creditos asc;";
			System.out.println("consulta :"+sql);
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				DetallePlanCurricular bean = new DetallePlanCurricular();				
				bean.setCodDce_curso(rs.getString(1));
				bean.setNombre_curso(rs.getString(2));
				bean.setCredito(rs.getInt(3));
				bean.setCodDce_escuela(rs.getInt(4));
				bean.setIdPlan(rs.getInt(5));
				bean.setCodDce_sem(rs.getInt(6));
				bean.setCiclo(rs.getInt(7));				
				bean.setEstado(rs.getInt(8));
				bean.setCat_fia(rs.getString(9));
				bean.setTipo_fia(rs.getString(10));
				bean.setTipo_sunedu(rs.getString(11));
				bean.setTipo_pres_virt(rs.getString(12));
				lista.add(bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}

	public int validarSumaCreditoCiclo(int ciclo, int idPlan, int idEscuela) {
		// TODO Auto-generated method stub
		int sumaCredito=0;
		try{
			Conexion con = new Conexion();
			String sql = "select sum(a.creditos) from curso a, det_curso_esc b where " +
					"a.idcurso=b.codDce_curso and idPlan='"+idPlan+"' and codDce_escuela='"+idEscuela+
					"' and b.ciclo='"+ciclo+"' and b.estado='1'";
			System.out.println("consulta :"+sql);
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				sumaCredito=rs.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return sumaCredito;
	}

	public int validarSumaCredito(int idPlan, int idEscuela) {
		// TODO Auto-generated method stub
		int sumaCredito=0;
		try{
			Conexion con = new Conexion();
			String sql = "select sum(a.creditos) from curso a, det_curso_esc b where " +
					"a.idcurso=b.codDce_curso and idPlan='"+idPlan+"' and codDce_escuela='"+idEscuela+
					"' and b.estado='1'";
			System.out.println("consulta :"+sql);
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				sumaCredito=rs.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return sumaCredito;
	}

	public int validarSumaCreditoCursoEspecialidad(int idPlan, int idEscuela) {
		// TODO Auto-generated method stub
		int sumaCredito=0;
		try{
			Conexion con = new Conexion();
			String sql = "select sum(a.creditos) from curso a, det_curso_esc b where " +
					"a.idcurso=b.codDce_curso and idPlan='"+idPlan+"' and codDce_escuela='"+idEscuela+
					"' and b.estado='1' and b.tipo_sunedu='especifico'";
			System.out.println("consulta :"+sql);
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				sumaCredito=rs.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return sumaCredito;
	}

	public int actualizarDetallePlanCurricularEstado(int estadoCursoPlan,
			String idCurso, int ciclo, int idPlan) {
		// TODO Auto-generated method stub
		int resultado = 0;
		String sql="";
		try{
			Conexion con = new Conexion();
			if(estadoCursoPlan==1){				
				sql = "Update det_curso_esc set estado='0' where codDce_curso='"+idCurso+"' and idPlan='"+idPlan+"'";				
			}else if(estadoCursoPlan==0){
				sql = "Update det_curso_esc set estado='1', ciclo='"+ciclo+"' where codDce_curso='"+idCurso+"' and idPlan='"+idPlan+"'";				
			}
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return resultado;
	}

	public int agregarDetallePlanCurricularCurso(int idPlan, int idSemestre,
			int idEscuela, int ciclo, String idCurso) {
		// TODO Auto-generated method stub
		int resultado = 0;
		String sql="";
		try{
			Conexion con = new Conexion();
			sql = "INSERT INTO det_curso_esc (index_curso, codDce_curso, sicat, codDce_escuela, idPlan, codDce_sem, ciclo, creditos, h_teo,h_lab,h_pract,estado) "
					+ "VALUES ((select index_curso from curso where idcurso='"+idCurso+"' and not creditos='0'),'"+idCurso+"', "
					+ "(select sicat from curso where idcurso='"+idCurso+"' and not creditos='0'),'"+idEscuela+"', '"+idPlan+"',"
					+ " '"+idSemestre+"','"+ciclo+"',(select creditos from curso where idcurso='"+idCurso+"' and not creditos='0'),"
							+ " (select h_teo from curso where idcurso='"+idCurso+"' and not creditos='0'), (select h_lab from curso where idcurso='"+idCurso+"'and not creditos='0'),"
							+ " (select h_pract from curso where idcurso='"+idCurso+"' and not creditos='0'),'1') ";
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return resultado;
	}

	public DetallePlanCurricular preactualizarCursoDetallePlanCurricular(
			int idPlan, int idSemestre, String idCurso) {
		// TODO Auto-generated method stub
		DetallePlanCurricular bean = null;
		
		try{
			Conexion con = new Conexion();
			String sql = "SELECT a.idcurso, a.nombre, b.idPlan, b.codDce_sem, b.codDce_escuela, b.ciclo, b.cat_fia, b.tipo_fia, b.tipo_sunedu, b.tipo_pres_virt "+
			"from det_curso_esc b inner join curso a on a.idcurso=b.codDce_curso where idPlan='"+idPlan+"' and codDce_sem='"+idSemestre+"' and codDce_curso='"+idCurso+"'";
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				bean = new DetallePlanCurricular();
				bean.setCodDce_curso(rs.getString(1));
				bean.setNombre_curso(rs.getString(2));
				bean.setIdPlan(rs.getInt(3));
				bean.setCodDce_sem(rs.getInt(4));
				bean.setCodDce_escuela(rs.getInt(5));
				bean.setCiclo(rs.getInt(6));				
				bean.setCat_fia(rs.getString(7));
				bean.setTipo_fia(rs.getString(8));
				bean.setTipo_sunedu(rs.getString(9));
				bean.setTipo_pres_virt(rs.getString(10));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return bean;
	}

	public int actualizarCursoDetallePlanCurricular(DetallePlanCurricular bean) {
		// TODO Auto-generated method stub
		int resultado = 0;
		
		try{
			Conexion con = new Conexion();
			String sql = "Update det_curso_esc set cat_fia='"+bean.getCat_fia()+"',tipo_fia='"+bean.getTipo_fia()+"',"
					+ "tipo_sunedu='"+bean.getTipo_sunedu()+"',tipo_pres_virt='"+bean.getTipo_pres_virt()+"' "
					+ "where codDce_curso='"+bean.getCodDce_curso()+"'";
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return resultado;
	}

	public int validarCreditoCiclo(int ciclo, int idPlan, int idSemestre) {
		// TODO Auto-generated method stub
		int credito=0;
		String sql="";
		try{
			Conexion con = new Conexion();
			if(ciclo==1){
				sql = "select primerCiclo from plan_curricular where idPlan='"+idPlan+"' and codPc_sem='"+idSemestre+"'";
		    }else if(ciclo==2){
		    	sql = "select segundoCiclo from plan_curricular where idPlan='"+idPlan+"' and codPc_sem='"+idSemestre+"'";
		    }else if(ciclo==3){
		    	sql = "select tercerCiclo from plan_curricular where idPlan='"+idPlan+"' and codPc_sem='"+idSemestre+"'";
		    }else if(ciclo==4){
		    	sql = "select cuartoCiclo from plan_curricular where idPlan='"+idPlan+"' and codPc_sem='"+idSemestre+"'";
		    }else if(ciclo==5){
		    	sql = "select quintoCiclo from plan_curricular where idPlan='"+idPlan+"' and codPc_sem='"+idSemestre+"'";
		    }else if(ciclo==6){
		    	sql = "select sextoCiclo from plan_curricular where idPlan='"+idPlan+"' and codPc_sem='"+idSemestre+"'";
		    }else if(ciclo==7){
		    	sql = "select septimoCiclo from plan_curricular where idPlan='"+idPlan+"' and codPc_sem='"+idSemestre+"'";
		    }else if(ciclo==8){
		    	sql = "select octavoCiclo from plan_curricular where idPlan='"+idPlan+"' and codPc_sem='"+idSemestre+"'";
		    }else if(ciclo==9){
		    	sql = "select novenoCiclo from plan_curricular where idPlan='"+idPlan+"' and codPc_sem='"+idSemestre+"'";
		    }else if(ciclo==10){
		    	sql = "select decimoCiclo from plan_curricular where idPlan='"+idPlan+"' and codPc_sem='"+idSemestre+"'";
		    }
			
			System.out.println("consulta :"+sql);
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				credito=rs.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return credito;
	}

}
