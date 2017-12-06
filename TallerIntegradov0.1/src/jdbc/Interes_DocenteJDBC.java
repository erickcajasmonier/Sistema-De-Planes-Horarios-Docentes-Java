package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Docente;
import beans.Interes_Docente;
import beans.Referido;
import util.Conexion;

public class Interes_DocenteJDBC {
	
	public List<Docente> listarDocentexInteres(String idcurso, String sem) throws Exception {
		
		List<Docente> lista = new ArrayList<Docente>();
		
		//String sql = "SELECT idreferido, cod_Docente, numdoc, nombre, apepat, apemat, edad, correo, cod_semestre "
		//		+ " FROM Referido WHERE cod_Docente = '" + numdoc.substring(0,8) +"' and cod_semestre= '" + numdoc.substring(8) +"'";
		
		String sql = "select i.codDocente, d.nombre, d.apepat,d.apemat, d.telefono,d.email from"
				+ " intereses_docente as i inner join docente as d on "
				+ " i.codDocente=d.numdoc "
				+ " where i.idCurso= '" + idcurso +"'"
				+ " and i.cod_semestre= '" + sem +"'";

		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			System.out.println("Ejecuta sql : " + sql);
			while (rs.next()) {
				Docente bean = new Docente();
				
				bean.setNumdoc(rs.getString(1));
				bean.setNombre(rs.getString(2));
				bean.setApepat(rs.getString(3));
				bean.setApemat(rs.getString(4));
				bean.setTelefono(rs.getInt(5));
				bean.setEmail(rs.getString(6));
				
				lista.add(bean);
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}
	
public List<Referido> listarReferidoxInteres(String idcurso, String sem) throws Exception {
		
		List<Referido> lista = new ArrayList<Referido>();
		
		String sql = "select i.codReferido, r.nombre, r.apepat, r.apemat, r.correo from intereses_referido as i inner join referido as r on " + 
				" i.codReferido=r.numdoc where i.idCurso='" + idcurso +"'" 
				+" and i.cod_semestre= '" + sem +"'";

		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			System.out.println("Ejecuta sql : " + sql);
			while (rs.next()) {
				Referido bean = new Referido();
				
				bean.setNumdoc(rs.getString(1));
				bean.setNombre(rs.getString(2));
				bean.setApepat(rs.getString(3));
				bean.setApemat(rs.getString(4));
				bean.setEmail(rs.getString(5));
				
				lista.add(bean);
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}


	public boolean eliminarInteresDocente(String idcurso, String numdoc, String sem) throws Exception{
		boolean resultado = false;
		//String sql = "Delete from intereses_docente where idIntereses='"+id+"'";
		String sql = "Delete from intereses_docente where idCurso='"+idcurso+"' and "
				+ "codDocente='"+numdoc+"' and cod_semestre='"+sem+"'";
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
	
	public boolean eliminarInteresReferido(String idcurso, String numdoc, String sem) throws Exception{
		boolean resultado = false;
		//String sql = "Delete from intereses_docente where idIntereses='"+id+"'";
		String sql = "Delete from intereses_referido where idCurso='"+idcurso+"' and "
				+ "codReferido='"+numdoc+"' and cod_semestre='"+sem+"'";
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
	
	public List<Interes_Docente> listarInteresxDocente(String numdoc, String sem) throws Exception {
		
		List<Interes_Docente> lista = new ArrayList<Interes_Docente>();
		/*
		String sql = " SELECT I.IDCURSO, C.nombre, (SELECT DISTINCT E.DESCRIPCION FROM ESCUELA AS E INNER JOIN DET_CURSO_ESC AS D" + 
				" ON E.IDESCUELA=D.codDce_escuela WHERE D.CODDCE_CURSO=I.IDCURSO) ESCUELA FROM INTERESES_DOCENTE AS I " + 
				" INNER JOIN CURSO AS C ON I.IDCURSO = C.IDCURSO " + 
				"WHERE I.codDocente = '" + numdoc.substring(0,8) +"' AND I.COD_SEMESTRE= '"+ numdoc.substring(8) +"'" ;
		*/
		String sql = "SELECT I.IDCURSO, C.nombre, C.nombreProp FROM INTERESES_DOCENTE AS I " + 
				"INNER JOIN CURSO AS C ON I.IDCURSO=C.IDCURSO " + 
				"WHERE I.codDocente = '" + numdoc +"' AND I.COD_SEMESTRE= '"+ sem +"'";
		
		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			
			System.out.println("Ejecuta sql : " + sql);

			while (rs.next()) {
				Interes_Docente bean = new Interes_Docente();
				
				bean.setCod_curso(rs.getString(1));
				bean.setDescripcion(rs.getString(2));
				bean.setEscuela(rs.getString(3));
				
				lista.add(bean);
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Interes_Docente> listarInteresxReferido(String numdoc, String sem) throws Exception {
		
		List<Interes_Docente> lista = new ArrayList<Interes_Docente>();
/*
		String sql = " SELECT I.IDCURSO, C.nombre, (SELECT DISTINCT E.DESCRIPCION FROM ESCUELA AS E INNER JOIN DET_CURSO_ESC AS D" + 
		" ON E.IDESCUELA=D.codDce_escuela WHERE D.CODDCE_CURSO=I.IDCURSO) ESCUELA FROM INTERESES_REFERIDO AS I " + 
		" INNER JOIN CURSO AS C ON I.IDCURSO = C.IDCURSO " + 
		"WHERE I.codReferido = '" + numdoc.substring(0,8) +"' AND I.COD_SEMESTRE= '"+ numdoc.substring(8) +"'" ;
	*/	
		String sql = "SELECT I.IDCURSO, C.nombre, C.nombreProp FROM INTERESES_REFERIDO AS I " + 
				"INNER JOIN CURSO AS C ON I.IDCURSO=C.IDCURSO " + 
				"WHERE I.codReferido = '" + numdoc +"' AND I.COD_SEMESTRE= '"+ sem +"'";

		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			
			System.out.println("Ejecuta sql : " + sql);

			while (rs.next()) {
				Interes_Docente bean = new Interes_Docente();
				
				bean.setCod_curso(rs.getString(1));
				bean.setDescripcion(rs.getString(2));
				bean.setEscuela(rs.getString(3));
				
				lista.add(bean);
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}

	public List<Interes_Docente> listarInteres(){
		
		List<Interes_Docente> lista = new ArrayList<Interes_Docente>();
		
		try{
			Conexion con = new Conexion();
			String sql = "Select * from intereses_docente";
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				Interes_Docente bean = new Interes_Docente();
				bean.setId(rs.getInt(1));
				bean.setCod_docente(rs.getString(2));
				bean.setCod_curso(rs.getString(3));
				bean.setCod_semestre(rs.getInt(4));
				
				lista.add(bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public int agregarInteres(Interes_Docente bean) {
		// TODO Auto-generated method stub
		int resultado = 0;		
		try{
			Conexion con = new Conexion();
			String sql = "INSERT INTO INTERESES_DOCENTE (codDocente, idCurso,cod_semestre)"
					+ " values('"+bean.getCod_docente()+"','"+bean.getCod_curso()+"','"+bean.getCod_semestre()+"')";
			System.out.println("consulta :"+sql);
			resultado = con.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return resultado;
	}
	
	public boolean registrarInteresDocente(Interes_Docente bean) {
		boolean flag = false;
		//String sql = "INSERT INTO DISPONIBILIDAD_DOCENTE (cod_Docente,cod_semestre,hor_ini,hor_fin,dia) VALUES (?,?,?,?,?)";
		String sql="INSERT INTO INTERESES_DOCENTE (codDocente, idCurso,cod_semestre) VALUES (?,?,?)";
		
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);
			ps.setString(1, bean.getCod_docente());
			ps.setString(2, bean.getCod_curso());
			ps.setInt(3, bean.getCod_semestre());
			//ps.setString(4, bean.getInt_adicional());
			
			flag = ps.executeUpdate() == 1 ? true : false;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return flag;
	}
	public boolean registrarInteresReferido(Interes_Docente bean) {
		boolean flag = false;
		//String sql = "INSERT INTO DISPONIBILIDAD_DOCENTE (cod_Docente,cod_semestre,hor_ini,hor_fin,dia) VALUES (?,?,?,?,?)";
		String sql="INSERT INTO INTERESES_REFERIDO (codReferido, idCurso,cod_semestre) VALUES (?,?,?)";
		
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);
			ps.setString(1, bean.getCod_docente());
			ps.setString(2, bean.getCod_curso());
			ps.setInt(3, bean.getCod_semestre());
			
			flag = ps.executeUpdate() == 1 ? true : false;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return flag;
	}
}
