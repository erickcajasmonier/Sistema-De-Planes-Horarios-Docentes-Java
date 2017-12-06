package jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.DTOHorarios;
import util.Conexion;

public class HorarioJDBC {

	public List<DTOHorarios> consultarHorario(String codsemestre, String codescuela) {
		List<DTOHorarios> lista = new ArrayList<DTOHorarios>();
		
//		String sql = "SELECT CONCAT(SEM.ANO,'-',SEM.SEMESTRE), C.IDCURSO, C.SICAT, C.NOMBRE, SECC.IDSECCION, A.NUM_AULA, "
//				+ "H.DIA, H.HORA_INI, H.HORA_FIN, D.NOMBRE, E.DESCRIPCION FROM HORARIO AS H "
//				+ "INNER JOIN SEMESTRE AS SEM ON H.CODH_SEM = SEM.IDSEMESTRE "
//				+ "INNER JOIN CURSO AS C ON H.CODH_CURSO = C.INDEX_CURSO "
//				+ "INNER JOIN DOCENTE AS D ON H.CODH_DOC = D.ID "
//				+ "INNER JOIN AULA AS A ON H.CODH_AULA = A.IDAULA "
//				+ "INNER JOIN SECCION AS SECC ON H.CODH_SECC = SECC.IDSECCION "
//				+ "INNER JOIN ESCUELA AS E ON H.COD_ESC = E.IDESCUELA WHERE H.CODH_SEM = '" + codsemestre + "' "
//				+ "AND H.COD_ESC = '" + codescuela + "' ORDER BY H.DIA";
		String escuela = obtenerStringEscuela(codescuela);
		String sql = "SELECT ciclo, tur, cod_cur, cod_cu_teoria, profesor, curso, seccion, aula, escuela, numcre, lunes, martes, miercoles, jueves, viernes, sabado, domingo, horas_semana, id_horario_excel"
				+ " FROM HORARIO_EXCEL WHERE ESCUELA LIKE '%" + escuela + "%' AND SEMESTRE = '" + codsemestre + "'";
		
		
		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			while (rs.next()) {
				DTOHorarios dto = new DTOHorarios();
				dto.setCiclo(rs.getString(1));
				dto.setTur(rs.getString(2));
				dto.setCod_cur(rs.getString(3));
				dto.setCod_cur_teoria(rs.getString(4));
				dto.setProfesor(rs.getString(5));
				dto.setCurso(rs.getString(6));
				dto.setSeccion(rs.getString(7));
				dto.setAula(rs.getString(8));
				dto.setEscuela(rs.getString(9));
				dto.setNumcre(rs.getString(10));
				dto.setLunes(rs.getString(11));
				dto.setMartes(rs.getString(12));
				dto.setMiercoles(rs.getString(13));
				dto.setJueves(rs.getString(14));
				dto.setViernes(rs.getString(15));
				dto.setSabado(rs.getString(16));
				dto.setDomingo(rs.getString(17));
				dto.setHorasxsemana(rs.getInt(18));
				lista.add(dto);
			}
			System.out.println(sql);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return lista;
	}
	
	private String obtenerStringEscuela(String pk){
		int indice = Integer.parseInt(pk);
		
		if(indice == 101){
			return "SIS";
		}else if(indice == 202){
			return "IND";
		}else if(indice == 303){
			return "ARQ";
		}else if(indice == 404){
			return "CIV";
		}else if(indice == 505){
			return "ELE";
		}else if(indice == 606){
			return "ALI";
		}else if(indice == 707){
			return "CC";
		}else{
			return "";
		}
	}
}
