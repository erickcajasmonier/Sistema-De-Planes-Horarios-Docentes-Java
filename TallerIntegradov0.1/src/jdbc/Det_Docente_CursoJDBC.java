package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Det_Docente_Curso;
import util.Conexion;

public class Det_Docente_CursoJDBC {

	public boolean registrarCursosxDocente(Det_Docente_Curso bean) {
		boolean flag = false;
		String sql = "INSERT INTO DET_DOC_CUR (id_doc, id_cur, descri, idsemestre) VALUES ( ?, ?, ?, ?)";
		
		try{
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);
			ps.setLong(1, bean.getId_doc());
			ps.setString(2, bean.getId_cur());
			ps.setString(3, bean.getDescri());
			ps.setString(4, bean.getIdsemestre());
			
			flag = ps.executeUpdate() == 1 ? true : false;
			
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}
	
	public List<Det_Docente_Curso> listarCursosxDocente(String idsemestre, long dni){//cambiar por int iddocente
		List<Det_Docente_Curso> lista = new ArrayList<Det_Docente_Curso>();
		String sql = "SELECT * FROM DET_DOC_CUR WHERE IDSEMESTRE = '" + idsemestre + "' and  ID_DOC = " + dni;
		
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql); // ERORRRRRRRRRRRRRRRRRRRRRRRRRRRR
			
			while(rs.next()){
				Det_Docente_Curso bean = new Det_Docente_Curso();
				bean.setId(rs.getInt(1));
				bean.setId_doc(rs.getLong(2));//rs.getInt(2)
				bean.setId_cur(rs.getString(3));
				bean.setDescri(rs.getString(4));
				bean.setIdsemestre(rs.getString(5));
				
				lista.add(bean);
			}
			
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}
		
}
