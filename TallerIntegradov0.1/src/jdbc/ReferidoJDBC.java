package jdbc;

import beans.Referido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class ReferidoJDBC {
	
	public boolean eliminarReferido(String id) throws Exception{
		boolean resultado = false;
		String sql = "Delete from referido where idreferido='"+id+"'";
		
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
	public boolean modificarReferido(Referido bean) throws Exception {
		boolean resultado = false;
		String sql = "UPDATE referido SET "
				+ "numdoc='" + bean.getNumdoc() + "'"
				+ ",nombre='" + bean.getNombre() + "'"
				+ ",apepat='" + bean.getApepat() + "'"
				+ ",apemat='" + bean.getApemat()+ "'"
				+ ",edad='" + bean.getEdad() + "'"
				+ ",correo='" + bean.getEmail()  +"'"
				+ ",cod_semestre='" + bean.getCod_semestre() + "'"
				+ " WHERE idreferido= '"+bean.getId()+"'"; 
		try {
			Conexion con= new Conexion();
			
			resultado = con.executeUpdate(sql) == 1 ? true : false;
			System.out.println("Ejecuta sql : " + sql);	
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}
	
	public Referido buscarReferido(String numdoc) throws Exception {
		String sql = "SELECT *  FROM Referido WHERE numdoc=? ";
		Referido bean = new Referido();
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);
			ps.setString(1, numdoc);
			ResultSet rs = ps.executeQuery();
			System.out.println("Ejecuta sql : " + sql);

			if (rs.next()) {
				bean.setId(rs.getInt(1));
				bean.setCod_docente(rs.getString(2));
				bean.setNumdoc(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setApepat(rs.getString(5));
				bean.setApemat(rs.getString(6));
				bean.setEdad(rs.getInt(7));
				bean.setEmail(rs.getString(8));
				bean.setCod_semestre(rs.getString(9));
				
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return bean;
	}
	public List<Referido> listarReferidoxDocente(String numdoc) throws Exception {
		
		List<Referido> lista = new ArrayList<Referido>();
		
		String sql = "SELECT * "
				+ " FROM Referido WHERE cod_Docente = '" + numdoc +"'";

		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			System.out.println("Ejecuta sql : " + sql);
			while (rs.next()) {
				Referido bean = new Referido();
				
				bean.setId(rs.getInt(1));
				bean.setCod_docente(rs.getString(2));
				bean.setNumdoc(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setApepat(rs.getString(5));
				bean.setApemat(rs.getString(6));
				bean.setEdad(rs.getInt(7));
				bean.setEmail(rs.getString(8));
				bean.setCod_semestre(rs.getString(9));
				
				lista.add(bean);
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}
public List<Referido> listarReferidoxDocenteSem(String numdoc, String sem) throws Exception {
		
		List<Referido> lista = new ArrayList<Referido>();
		
		String sql = "SELECT idreferido, cod_Docente, numdoc, nombre, apepat, apemat, edad, correo, cod_semestre "
				+ " FROM Referido WHERE cod_Docente = '" + numdoc +"' and cod_semestre= '" + sem +"'";

		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			System.out.println("Ejecuta sql : " + sql);
			while (rs.next()) {
				Referido bean = new Referido();
				
				bean.setId(rs.getInt(1));
				bean.setCod_docente(rs.getString(2));
				bean.setNumdoc(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setApepat(rs.getString(5));
				bean.setApemat(rs.getString(6));
				bean.setEdad(rs.getInt(7));
				bean.setEmail(rs.getString(8));
				bean.setCod_semestre(rs.getString(9));
				
				lista.add(bean);
			}
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Referido> listarReferido(){
		
		List<Referido> lista = new ArrayList<Referido>();
		String sql = "Select idreferido, numdoc, apepat, apemat, nombre, correo from referido";
		System.out.println("Ejecuta sql : " + sql);
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				Referido bean = new Referido();
				bean.setId(rs.getInt(1));
				bean.setNumdoc(rs.getString(2));
				bean.setApepat(rs.getString(3));
				bean.setApemat(rs.getString(4));
				bean.setNombre(rs.getString(5));
				bean.setEmail(rs.getString(6));
				
				lista.add(bean);
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		return lista;
		
	}

	public boolean crearReferido(Referido bean) throws Exception {
		boolean resultado = false;
		String sql = "INSERT INTO REFERIDO (COD_DOCENTE, NUMDOC, NOMBRE, APEPAT, APEMAT, EDAD, CORREO, COD_SEMESTRE) VALUES (?,?,?,?,?,?,?,?)";

		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);

			ps.setString(1, bean.getCod_docente());
			ps.setString(2, bean.getNumdoc());
			ps.setString(3, bean.getNombre());
			ps.setString(4, bean.getApepat());
			ps.setString(5, bean.getApemat());
			ps.setInt(6, bean.getEdad());
			ps.setString(7, bean.getEmail());
			ps.setString(8, bean.getCod_semestre());

			resultado = ps.executeUpdate() == 1 ? true : false;

		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return resultado;
	}
}
