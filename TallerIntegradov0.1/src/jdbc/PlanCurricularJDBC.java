package jdbc;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;
import beans.PlanCurricular;


public class PlanCurricularJDBC {

	public List<PlanCurricular> listarPlanCurricular(String idEscuela) {
		// TODO Auto-generated method stub
		List<PlanCurricular> lista = new ArrayList<PlanCurricular>();
		
		try{
			Conexion con = new Conexion();
			String sql = "SELECT a.idPlan, a.idEscuela, a.descripcion, a.codPc_sem,"
					+ " CONCAT(b.ano, '-', b.semestre), a.estado, a.usu_crea_reg from plan_curricular a "
					+ "inner join semestre b on a.codPc_sem=b.idSemestre where "
					+ "a.idEscuela='"+idEscuela+"'";
			System.out.println(sql);
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				PlanCurricular bean = new PlanCurricular();				
				bean.setIdPlan(rs.getInt(1));
				bean.setIdEscuela(rs.getInt(2));
				bean.setDescripcionEscuela(rs.getString(3));
				bean.setCodPc_sem(rs.getInt(4));
				bean.setDescripcionSemestre(rs.getString(5));
				bean.setEstado(rs.getInt(6));
				bean.setUsu_crea_reg(rs.getString(7));
				lista.add(bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}

	public int actualizarEstadoPlanCurricular(int estadoPlan, int idPlan, int idEscuela) {
		// TODO Auto-generated method stub
		int resultado = 0;
		String sql="";
		try{
			Conexion con = new Conexion();
			if(estadoPlan==1){				
				sql = "Update plan_curricular set estado='0' where idEscuela='"+idEscuela+"' and idPlan='"+idPlan+"'";				
			}else if(estadoPlan==0){
				sql = "Update plan_curricular set estado='1' where idEscuela='"+idEscuela+"' and idPlan='"+idPlan+"'";				
			}
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return resultado;
	}

	public int agregarPlanCurricular(PlanCurricular bean) {
		// TODO Auto-generated method stub
		int resultado = 0;		
		try{
			Conexion con = new Conexion();
			String sql = "INSERT INTO plan_curricular (idPlan, idEscuela, descripcion, codPc_sem, estado, usu_crea_reg, primerCiclo,"
					+ "segundoCiclo,tercerCiclo,cuartoCiclo,quintoCiclo,sextoCiclo,septimoCiclo,octavoCiclo,novenoCiclo,decimoCiclo)"
					+ " values('"+bean.getIdPlan()+"','"+bean.getIdEscuela()+"','"+bean.getDescripcionEscuela()+"','"+bean.getCodPc_sem()+"',"
					+ "'0','"+bean.getUsu_crea_reg()+"','"+bean.getPrimerCiclo()+"','"+bean.getSegundoCiclo()+"','"+bean.getTercerCiclo()+"',"
					+ "'"+bean.getCuartoCiclo()+"','"+bean.getQuintoCiclo()+"','"+bean.getSextoCiclo()+"','"+bean.getSeptimoCiclo()+"',"
					+ "'"+bean.getOctavoCiclo()+"','"+bean.getNovenoCiclo()+"','"+bean.getDecimoCiclo()+"')";
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return resultado;
	}
	
	public int agregarDetallePlanCurricular(int idEscuela){
		int resultado = 0;		
		try{
			Conexion con = new Conexion();
			String sql = "INSERT INTO DET_CURSO_ESC (index_curso, codDce_curso, sicat, codDce_escuela, idPlan, "
					+ "codDce_sem, ciclo,cupos, matriculados,cat_fia,tipo_fia,tipo_sunedu,tipo_pres_virt,estado, "
					+ "creditos, h_teo,h_lab,h_pract) SELECT DCE.INDEX_CURSO, DCE.CODDCE_CURSO, DCE.SICAT, DCE.CODDCE_ESCUELA, "
					+ "DCE.IDPLAN+1, DCE.CODDCE_SEM+1, DCE.CICLO, DCE.CUPOS, DCE.MATRICULADOS, DCE.CAT_FIA, DCE.TIPO_FIA, DCE.TIPO_SUNEDU, "
					+ "DCE.TIPO_PRES_VIRT, '1', C.CREDITOS, C.H_tEO, C.H_LAB, C.H_PRACT FROM DET_CURSO_ESC DCE INNER JOIN "
					+ "CURSO C ON DCE.INDEX_CURSO = C.INDEX_cURSO WHERE DCE.CODDCE_ESCUELA='"+idEscuela+"' and IDPLAN = (SELECT MAX(IDPLAN) FROM DET_CURSO_ESC where CODDCE_ESCUELA='"+idEscuela+"')";
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return resultado;
	}

	public PlanCurricular preagregarPlanCurricular(int idEscuela) {
		// TODO Auto-generated method stub
		PlanCurricular bean = null;
		
		try{
			Conexion con = new Conexion();
			String sql = "Select * from plan_curricular WHERE idPlan = (Select max(idPlan) from plan_curricular where idEscuela='"+idEscuela+"')"
					+ " and idEscuela='"+idEscuela+"'";	
			System.out.println("consulta :"+sql);
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				bean = new PlanCurricular();		
				bean.setIdPlan(rs.getInt(1));
				bean.setIdEscuela(rs.getInt(2));
				bean.setDescripcionEscuela(rs.getString(3));
				bean.setCodPc_sem(rs.getInt(4));
				bean.setEstado(rs.getInt(5));
				bean.setUsu_crea_reg(rs.getString(6));
				
				bean.setPrimerCiclo(rs.getInt(7));
				bean.setSegundoCiclo(rs.getInt(8));
				bean.setTercerCiclo(rs.getInt(9));
				bean.setCuartoCiclo(rs.getInt(10));
				bean.setQuintoCiclo(rs.getInt(11));
				bean.setSextoCiclo(rs.getInt(12));
				bean.setSeptimoCiclo(rs.getInt(13));
				bean.setOctavoCiclo(rs.getInt(14));
				bean.setNovenoCiclo(rs.getInt(15));
				bean.setDecimoCiclo(rs.getInt(16));
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		return bean;
	}
	
	public PlanCurricular validarCreditoCiclo(int idEscuela) {
		// TODO Auto-generated method stub
		PlanCurricular bean = null;
		
		try{
			Conexion con = new Conexion();
			String sql = "Select primerCiclo,segundoCiclo,tercerCiclo,cuartoCiclo,quintoCiclo,sextoCiclo,septimoCiclo,"
					+ "octavoCiclo,novenoCiclo,decimoCiclo from plan_curricular WHERE "
					+ "idPlan = (Select max(idPlan) from plan_curricular where idEscuela='"+idEscuela+"')"
					+ " and idEscuela='"+idEscuela+"'";	
			System.out.println("consulta :"+sql);
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				bean = new PlanCurricular();		
				bean.setPrimerCiclo(rs.getInt(1));
				bean.setSegundoCiclo(rs.getInt(2));
				bean.setTercerCiclo(rs.getInt(3));
				bean.setCuartoCiclo(rs.getInt(4));
				bean.setQuintoCiclo(rs.getInt(5));
				bean.setSextoCiclo(rs.getInt(6));
				bean.setSeptimoCiclo(rs.getInt(7));
				bean.setOctavoCiclo(rs.getInt(8));
				bean.setNovenoCiclo(rs.getInt(9));
				bean.setDecimoCiclo(rs.getInt(10));
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		return bean;
	}
	
	public int eliminarPlanCurricular(int idplan, int idescuela) {
		// TODO Auto-generated method stub
		int resultado = 0;
		
		try{
			Conexion con = new Conexion();
			
			String sql ="eliminarPlan("+idplan+","+idescuela+")";
			System.out.println("consulta :"+sql);
			CallableStatement cl = con.ejecutarProcedure(sql);
			
			cl.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public int eliminarDetallePlanCurricular(int idPlan, int idEscuela) {
		// TODO Auto-generated method stub
		int resultado = 0;
		
		try{
			Conexion con = new Conexion();
			String sql = "delete from det_curso_esc where idPlan='"+idPlan+"'and codDce_escuela='"+idEscuela+"';";
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return resultado;
	}

	public int eliminarCursoEstadoCero(int idPlan, int idEscuela) {
		// TODO Auto-generated method stub
		int resultado = 0;
		
		try{
			Conexion con = new Conexion();
			String sql = "delete from det_curso_esc where idPlan='"+idPlan+"'and codDce_escuela='"+idEscuela+"' and estado='0';";
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return resultado;
	}
}
