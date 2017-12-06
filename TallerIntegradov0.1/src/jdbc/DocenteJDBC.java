package jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Docente;
import java.sql.PreparedStatement;
import util.Conexion;

public class DocenteJDBC {

	public int mayorId() {
		int c = 0;
		String sql;
		sql = "SELECT MAX(ID) FROM DOCENTE";
		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			if (rs.next()) {
				c = rs.getInt(1);
				c++;
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return c;
	}

	public Docente buscarDocente(String nombre, String apepat, String apemat, long numdoc) throws Exception {
		String sql = "SELECT *  FROM DOCENTE WHERE NOMBRE=? AND APEPAT=? AND APEMAT=? OR NUMDOC=?";
		Docente bean = new Docente();
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, apepat);
			ps.setString(3, apemat);
			ps.setLong(4, numdoc);
			ResultSet rs = ps.executeQuery();
			System.out.println("Ejecuta sql : " + sql);

			if (rs.next()) {
				bean.setId(rs.getInt(1));
				bean.setNumdoc(rs.getString(2));
				bean.setApepat(rs.getString(3));
				bean.setApemat(rs.getString(4));
				bean.setNombre(rs.getString(5));
				bean.setPais(rs.getString(6));
				bean.setFecini(rs.getString(7));
				bean.setLey30220(rs.getInt(8));
				bean.setMayorgrado(rs.getString(9));
				bean.setMenciongrado((rs.getString(10)));
				bean.setUniv(rs.getString(11));
				bean.setPasiuniv((rs.getString(12)));
				bean.setPregrado(rs.getInt(13));
				bean.setMaestria(rs.getInt(14));
				bean.setDoctorado(rs.getInt(15));
				bean.setCategoria(rs.getString(16));
				bean.setRegimen(rs.getString(17));
				bean.setHoraclase(rs.getInt(18));
				bean.setHoraactiv(rs.getInt(19));
				bean.setTotalhoras(rs.getInt(20));
				bean.setInvestigador(rs.getInt(21));
				bean.setDina(rs.getInt(22));
				bean.setCodD_sem(rs.getString(23));
				bean.setEscuela(rs.getString(24));
				bean.setEmail(rs.getString(25));
				bean.setTelefono(rs.getInt(26));
				bean.setObservaciones(rs.getString(27));
				bean.setLicen(rs.getInt(28));
				bean.setSl01(rs.getInt(29));
				bean.setSl02(rs.getInt(30));
				bean.setSl03(rs.getInt(31));
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return bean;
	}

	public boolean crearDocente(Docente bean) throws Exception {
		boolean resultado = false;
		String sql = "INSERT INTO DOCENTE"
				+ " (numdoc, apepat, apemat, nombre, pais, fecini, ley30220, mayorgrado, menciongrado, univ, paisuniv, pregrado, maestria, doctorado, categoria, regimen, horaclase, horaactiv, totalhoras, investigador, DINA, codD_sem, escuela, email, telefono, observaciones, licenciamiento, sl01, sl02, sl03) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);

			ps.setString(1, bean.getNumdoc());
			ps.setString(2, bean.getApepat());
			ps.setString(3, bean.getApemat());
			ps.setString(4, bean.getNombre());
			ps.setString(5, bean.getPais());
			ps.setString(6, bean.getFecini());
			ps.setInt(7, bean.getLey30220());
			ps.setString(8, bean.getMayorgrado());
			ps.setString(9, bean.getMenciongrado());
			ps.setString(10, bean.getUniv());
			ps.setString(11, bean.getPasiuniv());
			ps.setInt(12, bean.getPregrado());
			ps.setInt(13, bean.getMaestria());
			ps.setInt(14, bean.getDoctorado());
			ps.setString(15, bean.getCategoria());
			ps.setString(16, bean.getRegimen());
			ps.setInt(17, bean.getHoraclase());
			ps.setInt(18, bean.getHoraactiv());
			ps.setInt(19, bean.getTotalhoras());
			ps.setInt(20, bean.getInvestigador());
			ps.setInt(21, bean.getDina());
			ps.setString(22, bean.getCodD_sem());
			ps.setString(23, bean.getEscuela());
			ps.setString(24, bean.getEmail());
			ps.setInt(25, bean.getTelefono());
			ps.setString(26, bean.getObservaciones());
			ps.setInt(27, bean.getLicen());
			ps.setInt(28, bean.getSl01());
			ps.setInt(29, bean.getSl02());
			ps.setInt(30, bean.getSl03());

			resultado = ps.executeUpdate() == 1 ? true : false;

		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return resultado;
	}

	public boolean modificarDocente(Docente bean) throws Exception {
		boolean resultado = false;
		String sql = "UPDATE DOCENTE SET "
				+ "NUMDOC='" + bean.getNumdoc() + "'"
				+ ",NOMBRE='" + bean.getNombre() + "'"
				+ ",APEMAT='" + bean.getApemat() + "'"
				+ ",APEPAT='" + bean.getApepat() + "'"
				+ ",PAIS='" + bean.getPais() + "'"
				+ ",FECINI='" + bean.getFecini() + "'"
				+ ",LEY30220=" + bean.getLey30220()
				+ ",MAYORGRADO='" + bean.getMayorgrado() + "'"
				+ ",MENCIONGRADO='" + bean.getMenciongrado() + "'"
				+ ",UNIV='" + bean.getUniv() + "'"
				+ ",PAISUNIV='" + bean.getPasiuniv() + "'"
				+ ",PREGRADO=" + bean.getPregrado()
				+ ",MAESTRIA=" + bean.getMaestria()
				+ ",DOCTORADO=" + bean.getDoctorado()
				+ ",CATEGORIA='" + bean.getCategoria() + "'"
				+ ",REGIMEN='" + bean.getRegimen() + "'"
				+ ",HORACLASE=" + bean.getHoraclase()
				+ ",HORAACTIV=" + bean.getHoraactiv()
				+ ",TOTALHORAS=" + bean.getTotalhoras()
				+ ",INVESTIGADOR=" + bean.getInvestigador()
				+ ",DINA=" + bean.getDina()
				+ ",CODD_SEM='" + bean.getCodD_sem() + "'"
				+ ",ESCUELA='" + bean.getEscuela() + "'"
				+ ",EMAIL='" + bean.getEmail() + "'"
				+ ",TELEFONO=" + bean.getTelefono()
				+ ",OBSERVACIONES='" + bean.getObservaciones() + "'"
				+ ",LICENCIAMIENTO=" + bean.getLicen()
				+ ",SL01=" + bean.getSl01()
				+ ",SL02=" + bean.getSl02()
				+ ",SL03=" + bean.getSl03()
				+ " WHERE ID = "+bean.getId();
		try {
			Conexion con= new Conexion();
			
			resultado = con.executeUpdate(sql) == 1 ? true : false;
					
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}
	
	public List<Docente> listarDocentes(){
		List<Docente> lista = new ArrayList<Docente>();
		String sql = "select numdoc, apepat, apemat, nombre, telefono, email from docente order by apepat";
		
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			System.out.println(sql);
			
			while(rs.next()){
				Docente bean = new Docente();
				bean.setNumdoc(rs.getString(1));
				bean.setApepat(rs.getString(2));
				bean.setApemat(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setTelefono(rs.getInt(5));
				bean.setEmail(rs.getString(6));
				
				lista.add(bean);
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Docente> listarDocentesRegistrados(){
		List<Docente> lista = new ArrayList<Docente>();
		String sql = "select distinct d.numdoc, d.apepat, d.apemat, d.nombre, d.telefono, d.email" + 
				" from docente as d inner join usuario as u where u.nombreUsu=d.numdoc order by d.apepat";
		
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			System.out.println(sql);
			
			while(rs.next()){
				Docente bean = new Docente();
				bean.setNumdoc(rs.getString(1));
				bean.setApepat(rs.getString(2));
				bean.setApemat(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setTelefono(rs.getInt(5));
				bean.setEmail(rs.getString(6));
				
				lista.add(bean);
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Docente> listarDocentesC9(String fecha){
		List<Docente> lista = new ArrayList<Docente>();
		System.out.println("TODOS!!");
		//String sql = "SELECT * FROM DOCENTE_C9 WHERE FECHA <= '" + fecha + "'" ;
		String sql = "select id_doc, numdoc, apepat, apemat, nombre, pais, fecini, ley30220, mayorgrado, menciongrado, univ, paisuniv, pregrado, maestria, doctorado, categoria, regimen, horaclase, horaactiv, totalhoras, investigador, dina, codD_sem, escuela, email, telefono, observaciones, licenciamiento, sl01, sl02, sl03 , max(fecha) from docente_audi where fecha <= '" + fecha + "' group by id_doc" ;
		
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			
			while(rs.next()){
				Docente bean = new Docente();
				bean.setId(rs.getInt(1));
				bean.setNumdoc(rs.getString(2));
				bean.setApepat(rs.getString(3));
				bean.setApemat(rs.getString(4));
				bean.setNombre(rs.getString(5));
				bean.setPais(rs.getString(6));
				bean.setFecini(rs.getString(7));
				bean.setLey30220(rs.getInt(8));
				bean.setMayorgrado(rs.getString(9));
				bean.setMenciongrado((rs.getString(10)));
				bean.setUniv(rs.getString(11));
				bean.setPasiuniv((rs.getString(12)));
				bean.setPregrado(rs.getInt(13));
				bean.setMaestria(rs.getInt(14));
				bean.setDoctorado(rs.getInt(15));
				bean.setCategoria(rs.getString(16));
				bean.setRegimen(rs.getString(17));
				bean.setHoraclase(rs.getInt(18));
				bean.setHoraactiv(rs.getInt(19));
				bean.setTotalhoras(rs.getInt(20));
				bean.setInvestigador(rs.getInt(21));
				bean.setDina(rs.getInt(22));
				bean.setCodD_sem(rs.getString(23));
				bean.setEscuela(rs.getString(24));
				bean.setEmail(rs.getString(25));
				bean.setTelefono(rs.getInt(26));
				bean.setObservaciones(rs.getString(27));
				bean.setLicen(rs.getInt(28));
				bean.setSl01(rs.getInt(29));
				bean.setSl02(rs.getInt(30));
				bean.setSl03(rs.getInt(31));
				
				lista.add(bean);

			
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		return lista;
	
		
	}
	
	
	public List<Docente> listarDocentesC9DINA(String fecha){
		List<Docente> lista = new ArrayList<Docente>();
		System.out.println("Dina!!");
		//String sql = "SELECT * FROM DOCENTE_C9 WHERE FECHA <= '" + fecha + "'" ;
		String sql = "select id_doc, numdoc, apepat, apemat, nombre, pais, fecini, ley30220, mayorgrado, menciongrado, univ, paisuniv, pregrado, maestria, doctorado, categoria, regimen, horaclase, horaactiv, totalhoras, investigador, dina, codD_sem, escuela, email, telefono, observaciones, licenciamiento, sl01, sl02, sl03 , max(fecha) from docente_audi where fecha <= '" + fecha + "' and dina = 0 group by id_doc" ;
		
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			
			while(rs.next()){
				Docente bean = new Docente();
				bean.setId(rs.getInt(1));
				bean.setNumdoc(rs.getString(2));
				bean.setApepat(rs.getString(3));
				bean.setApemat(rs.getString(4));
				bean.setNombre(rs.getString(5));
				bean.setPais(rs.getString(6));
				bean.setFecini(rs.getString(7));
				bean.setLey30220(rs.getInt(8));
				bean.setMayorgrado(rs.getString(9));
				bean.setMenciongrado((rs.getString(10)));
				bean.setUniv(rs.getString(11));
				bean.setPasiuniv((rs.getString(12)));
				bean.setPregrado(rs.getInt(13));
				bean.setMaestria(rs.getInt(14));
				bean.setDoctorado(rs.getInt(15));
				bean.setCategoria(rs.getString(16));
				bean.setRegimen(rs.getString(17));
				bean.setHoraclase(rs.getInt(18));
				bean.setHoraactiv(rs.getInt(19));
				bean.setTotalhoras(rs.getInt(20));
				bean.setInvestigador(rs.getInt(21));
				bean.setDina(rs.getInt(22));
				bean.setCodD_sem(rs.getString(23));
				bean.setEscuela(rs.getString(24));
				bean.setEmail(rs.getString(25));
				bean.setTelefono(rs.getInt(26));
				bean.setObservaciones(rs.getString(27));
				bean.setLicen(rs.getInt(28));
				bean.setSl01(rs.getInt(29));
				bean.setSl02(rs.getInt(30));
				bean.setSl03(rs.getInt(31));
				lista.add(bean);

			
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		return lista;
	
		
	}
	
	public List<Docente> listarDocentesC9TIEMPO(String fecha){
		List<Docente> lista = new ArrayList<Docente>();
		System.out.println("Tiempo!!");
		//String sql = "SELECT * FROM DOCENTE_C9 WHERE FECHA <= '" + fecha + "'" ;
		String sql = "select id_doc, numdoc, apepat, apemat, nombre, pais, fecini, ley30220, mayorgrado, menciongrado, univ, paisuniv, pregrado, maestria, doctorado, categoria, regimen, horaclase, horaactiv, totalhoras, investigador, dina, codD_sem, escuela, email, telefono, observaciones, licenciamiento, sl01, sl02, sl03 , max(fecha) from docente_audi where fecha <= '" + fecha + "' and regimen = 'Tiempo Completo' group by id_doc" ;
		
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			
			while(rs.next()){
				Docente bean = new Docente();
				bean.setId(rs.getInt(1));
				bean.setNumdoc(rs.getString(2));
				bean.setApepat(rs.getString(3));
				bean.setApemat(rs.getString(4));
				bean.setNombre(rs.getString(5));
				bean.setPais(rs.getString(6));
				bean.setFecini(rs.getString(7));
				bean.setLey30220(rs.getInt(8));
				bean.setMayorgrado(rs.getString(9));
				bean.setMenciongrado((rs.getString(10)));
				bean.setUniv(rs.getString(11));
				bean.setPasiuniv((rs.getString(12)));
				bean.setPregrado(rs.getInt(13));
				bean.setMaestria(rs.getInt(14));
				bean.setDoctorado(rs.getInt(15));
				bean.setCategoria(rs.getString(16));
				bean.setRegimen(rs.getString(17));
				bean.setHoraclase(rs.getInt(18));
				bean.setHoraactiv(rs.getInt(19));
				bean.setTotalhoras(rs.getInt(20));
				bean.setInvestigador(rs.getInt(21));
				bean.setDina(rs.getInt(22));
				bean.setCodD_sem(rs.getString(23));
				bean.setEscuela(rs.getString(24));
				bean.setEmail(rs.getString(25));
				bean.setTelefono(rs.getInt(26));
				bean.setObservaciones(rs.getString(27));
				bean.setLicen(rs.getInt(28));
				bean.setSl01(rs.getInt(29));
				bean.setSl02(rs.getInt(30));
				bean.setSl03(rs.getInt(31));
				lista.add(bean);

			
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		return lista;
	
		
	}
	
	public List<Docente> listarDocentesC9CATEGORIA(String fecha){
		List<Docente> lista = new ArrayList<Docente>();
		System.out.println("Categoria!!");
		//String sql = "SELECT * FROM DOCENTE_C9 WHERE FECHA <= '" + fecha + "'" ;
		String sql = "select id_doc, numdoc, apepat, apemat, nombre, pais, fecini, ley30220, mayorgrado, menciongrado, univ, paisuniv, pregrado, maestria, doctorado, categoria, regimen, horaclase, horaactiv, totalhoras, investigador, dina, codD_sem, escuela, email, telefono, observaciones, licenciamiento, sl01, sl02, sl03 , max(fecha) from docente_audi where fecha <= '" + fecha + "' and categoria = 'CONTRATADO' group by id_doc" ;
		
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			
			while(rs.next()){
				Docente bean = new Docente();
				bean.setId(rs.getInt(1));
				bean.setNumdoc(rs.getString(2));
				bean.setApepat(rs.getString(3));
				bean.setApemat(rs.getString(4));
				bean.setNombre(rs.getString(5));
				bean.setPais(rs.getString(6));
				bean.setFecini(rs.getString(7));
				bean.setLey30220(rs.getInt(8));
				bean.setMayorgrado(rs.getString(9));
				bean.setMenciongrado((rs.getString(10)));
				bean.setUniv(rs.getString(11));
				bean.setPasiuniv((rs.getString(12)));
				bean.setPregrado(rs.getInt(13));
				bean.setMaestria(rs.getInt(14));
				bean.setDoctorado(rs.getInt(15));
				bean.setCategoria(rs.getString(16));
				bean.setRegimen(rs.getString(17));
				bean.setHoraclase(rs.getInt(18));
				bean.setHoraactiv(rs.getInt(19));
				bean.setTotalhoras(rs.getInt(20));
				bean.setInvestigador(rs.getInt(21));
				bean.setDina(rs.getInt(22));
				bean.setCodD_sem(rs.getString(23));
				bean.setEscuela(rs.getString(24));
				bean.setEmail(rs.getString(25));
				bean.setTelefono(rs.getInt(26));
				bean.setObservaciones(rs.getString(27));
				bean.setLicen(rs.getInt(28));
				bean.setSl01(rs.getInt(29));
				bean.setSl02(rs.getInt(30));
				bean.setSl03(rs.getInt(31));
				lista.add(bean);

			
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		return lista;
	
		
	}
	
	public List<Docente> listarDocentesC9PARCIAL(String fecha){
		List<Docente> lista = new ArrayList<Docente>();
		System.out.println("Parcial!!");
		//String sql = "SELECT * FROM DOCENTE_C9 WHERE FECHA <= '" + fecha + "'" ;
		String sql = "select id_doc, numdoc, apepat, apemat, nombre, pais, fecini, ley30220, mayorgrado, menciongrado, univ, paisuniv, pregrado, maestria, doctorado, categoria, regimen, horaclase, horaactiv, totalhoras, investigador, dina, codD_sem, escuela, email, telefono, observaciones, licenciamiento, sl01, sl02, sl03 , max(fecha) from docente_audi where fecha <= '" + fecha + "' and regimen = 'Tiempo Parcial' group by id_doc" ;
		
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			
			while(rs.next()){
				Docente bean = new Docente();
				bean.setId(rs.getInt(1));
				bean.setNumdoc(rs.getString(2));
				bean.setApepat(rs.getString(3));
				bean.setApemat(rs.getString(4));
				bean.setNombre(rs.getString(5));
				bean.setPais(rs.getString(6));
				bean.setFecini(rs.getString(7));
				bean.setLey30220(rs.getInt(8));
				bean.setMayorgrado(rs.getString(9));
				bean.setMenciongrado((rs.getString(10)));
				bean.setUniv(rs.getString(11));
				bean.setPasiuniv((rs.getString(12)));
				bean.setPregrado(rs.getInt(13));
				bean.setMaestria(rs.getInt(14));
				bean.setDoctorado(rs.getInt(15));
				bean.setCategoria(rs.getString(16));
				bean.setRegimen(rs.getString(17));
				bean.setHoraclase(rs.getInt(18));
				bean.setHoraactiv(rs.getInt(19));
				bean.setTotalhoras(rs.getInt(20));
				bean.setInvestigador(rs.getInt(21));
				bean.setDina(rs.getInt(22));
				bean.setCodD_sem(rs.getString(23));
				bean.setEscuela(rs.getString(24));
				bean.setEmail(rs.getString(25));
				bean.setTelefono(rs.getInt(26));
				bean.setObservaciones(rs.getString(27));
				bean.setLicen(rs.getInt(28));
				bean.setSl01(rs.getInt(29));
				bean.setSl02(rs.getInt(30));
				bean.setSl03(rs.getInt(31));
				lista.add(bean);

			
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		return lista;
	
		
	}
	
	public List<Docente> listarDocentesC9INVESTIGADOR(String fecha){
		List<Docente> lista = new ArrayList<Docente>();
		System.out.println("Parcial!!");
		//String sql = "SELECT * FROM DOCENTE_C9 WHERE FECHA <= '" + fecha + "'" ;
		String sql = "select id_doc, numdoc, apepat, apemat, nombre, pais, fecini, ley30220, mayorgrado, menciongrado, univ, paisuniv, pregrado, maestria, doctorado, categoria, regimen, horaclase, horaactiv, totalhoras, investigador, dina, codD_sem, escuela, email, telefono, observaciones, licenciamiento, sl01, sl02, sl03 , max(fecha) from docente_audi where fecha <= '" + fecha + "' and investigador = 1 group by id_doc" ;
		
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			
			while(rs.next()){
				Docente bean = new Docente();
				bean.setId(rs.getInt(1));
				bean.setNumdoc(rs.getString(2));
				bean.setApepat(rs.getString(3));
				bean.setApemat(rs.getString(4));
				bean.setNombre(rs.getString(5));
				bean.setPais(rs.getString(6));
				bean.setFecini(rs.getString(7));
				bean.setLey30220(rs.getInt(8));
				bean.setMayorgrado(rs.getString(9));
				bean.setMenciongrado((rs.getString(10)));
				bean.setUniv(rs.getString(11));
				bean.setPasiuniv((rs.getString(12)));
				bean.setPregrado(rs.getInt(13));
				bean.setMaestria(rs.getInt(14));
				bean.setDoctorado(rs.getInt(15));
				bean.setCategoria(rs.getString(16));
				bean.setRegimen(rs.getString(17));
				bean.setHoraclase(rs.getInt(18));
				bean.setHoraactiv(rs.getInt(19));
				bean.setTotalhoras(rs.getInt(20));
				bean.setInvestigador(rs.getInt(21));
				bean.setDina(rs.getInt(22));
				bean.setCodD_sem(rs.getString(23));
				bean.setEscuela(rs.getString(24));
				bean.setEmail(rs.getString(25));
				bean.setTelefono(rs.getInt(26));
				bean.setObservaciones(rs.getString(27));
				bean.setLicen(rs.getInt(28));
				bean.setSl01(rs.getInt(29));
				bean.setSl02(rs.getInt(30));
				bean.setSl03(rs.getInt(31));
				lista.add(bean);

			
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}
	public List<Docente> listarInteresados(String curso){
		List<Docente> lista = new ArrayList<Docente>();
		String sql = "SELECT D.NOMBRE,D. APEPAT, D.APEMAT FROM DOCENTE AS D "
				+ "INNER JOIN INTERESES_DOCENTE AS ID ON ID.CODDOCENTE = D.NUMDOC "
				+ "WHERE ID.IDCURSO = (SELECT IDCURSO FROM CURSO WHERE SICAT = (SELECT DISTINCT COD_CUR FROM HORARIO_EXCEL WHERE CURSO LIKE '" + curso + "'))";
		
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			
			while (rs.next()) {
				Docente bean = new Docente();
				bean.setNombre(rs.getString(1));
				bean.setApepat(rs.getString(2));
				bean.setApemat(rs.getString(3));
				lista.add(bean);
			}
			
		}catch(Exception e){
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Docente> listarReferidos(String curso){
		List<Docente> lista = new ArrayList<Docente>();
		String sql = "SELECT R.NOMBRE,R. APEPAT, R.APEMAT FROM REFERIDO AS R " + 
				"INNER JOIN INTERESES_REFERIDO AS IR ON IR.CODREFERIDO = R.NUMDOC " +
				"WHERE IR.IDCURSO = (SELECT IDCURSO FROM CURSO WHERE SICAT = (SELECT DISTINCT COD_CUR FROM HORARIO_EXCEL WHERE CURSO LIKE '" + curso + "'))";
		
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			
			while (rs.next()) {
				Docente bean = new Docente();
				bean.setNombre(rs.getString(1));
				bean.setApepat(rs.getString(2));
				bean.setApemat(rs.getString(3));
				lista.add(bean);
			}
			
		}catch(Exception e){
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		
		return lista;
	}
}
