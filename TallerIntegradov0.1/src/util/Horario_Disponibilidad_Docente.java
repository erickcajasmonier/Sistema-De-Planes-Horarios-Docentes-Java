package util;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Disponibilidad_Docente;
import dto.DTOResultadoVDD;
import dto.DTOValidacionDispDocente;

public class Horario_Disponibilidad_Docente {
	private List<DTOValidacionDispDocente> getHorasIFExcel(String escuela){
		List<DTOValidacionDispDocente> lista = new ArrayList<DTOValidacionDispDocente>();
		String sql = "SP_HORASINIFINEXCEL('" + escuela + "')";
		try {
			Conexion con = new Conexion();
			CallableStatement cl = con.ejecutarProcedure(sql);
			ResultSet rs = cl.executeQuery();
			
			while(rs.next()){
				DTOValidacionDispDocente dto = new DTOValidacionDispDocente();
				dto.setDocente(rs.getString(1));
				dto.setLunes_ini(rs.getInt(2));
				dto.setLunes_fin(rs.getInt(3));
				dto.setMartes_ini(rs.getInt(4));
				dto.setMartes_fin(rs.getInt(5));
				dto.setMiercoles_ini(rs.getInt(6));
				dto.setMiercoles_fin(rs.getInt(7));
				dto.setJueves_ini(rs.getInt(8));
				dto.setJueves_fin(rs.getInt(9));
				dto.setViernes_ini(rs.getInt(10));
				dto.setViernes_fin(rs.getInt(11));
				dto.setSabado_ini(rs.getInt(12));
				dto.setSabado_fin(rs.getInt(13));
				dto.setDomingo_ini(rs.getInt(14));
				dto.setDomingo_fin(rs.getInt(15));
				dto.setCurso(rs.getString(16));
				dto.setTipo_profesor(rs.getString(17));
				lista.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<DTOResultadoVDD> resultadoValidacionDD(String escuela, String sem){
		String esc = obtenerStringEscuela(escuela);
		List<DTOValidacionDispDocente> lista = getHorasIFExcel(esc);
		List<DTOResultadoVDD> resultado = new ArrayList<DTOResultadoVDD>();
		String a_paterno = "";
		String a_materno = "";
		String nombres_completo = "";
		String apellidos = "";
		String[] docente;
		String[] nombre;
		DTOResultadoVDD vdd;
		try {
			Conexion con = new Conexion();
			for (int i = 0; i < lista.size(); i++) {
				vdd = new DTOResultadoVDD();
				
				docente = lista.get(i).getDocente().split(",");
				apellidos = docente[0];
				nombres_completo = docente[1];
				
				nombre = nombres_completo.split(" ");
				
				System.out.println(nombre.length);
				
				if (nombre.length > 1) {
					nombres_completo = nombre[0] + " " + nombre[1];

					System.out.println(nombre[0]);
				} else if (nombre.length == 0) {
					nombres_completo = "";
				} else {
					nombres_completo = nombre[0];

				}

				if (apellidos.split(" ").length > 1) {
					a_paterno = apellidos.split(" ")[0];
					a_materno = apellidos.split(" ")[1];
				} else {
					a_paterno = apellidos.split(" ")[0];
					a_materno = "";
				}
				
				vdd.setCurso(lista.get(i).getCurso());
				vdd.setNombres(a_paterno + " " + a_materno + ", " + nombres_completo);

				// System.out.println(lista.get(i).getDocente().indexOf(','));
//				System.out.println(nombres_completo + " " + a_paterno + " " + a_materno);
				
				
				List<Disponibilidad_Docente> lista_bean;
				
				if (lista.get(i).getTipo_profesor().trim().equalsIgnoreCase("CONTRATADO")) {
					lista_bean = getDisponibilidadDocente(nombres_completo, a_paterno, a_materno, con, sem);
				} else {
					lista_bean = getDisponibilidadRecomendado(nombres_completo, a_paterno, a_materno, con, sem);
				}
				
				
				vdd.setLunes(lista.get(i).getLunes_ini() + " - " + lista.get(i).getLunes_fin());
				vdd.setMartes(lista.get(i).getMartes_ini() + " - " + lista.get(i).getMartes_fin());
				vdd.setMiercoles(lista.get(i).getMiercoles_ini() + " - " + lista.get(i).getMiercoles_fin());
				vdd.setJueves(lista.get(i).getJueves_ini() + " - " + lista.get(i).getJueves_fin());
				vdd.setViernes(lista.get(i).getViernes_ini() + " - " + lista.get(i).getViernes_fin());
				vdd.setSabado(lista.get(i).getSabado_ini() + " - " + lista.get(i).getSabado_fin());
				vdd.setDomingo(lista.get(i).getDomingo_ini() + " - " + lista.get(i).getDomingo_fin());
				
				
				for (Disponibilidad_Docente bean : lista_bean) {
					
					if (bean.getDia().toUpperCase().equals("LUNES")) {
						vdd.setMensaje1(compararDisponibilidadHorario(lista.get(i).getLunes_ini(), lista.get(i).getLunes_fin(),
								bean.getHora_ini(), bean.getHora_fin()));
					} else if (bean.getDia().toUpperCase().equals("MARTES")) {
						vdd.setMensaje2(compararDisponibilidadHorario(lista.get(i).getMartes_ini(), lista.get(i).getMartes_fin(),
								bean.getHora_ini(), bean.getHora_fin()));
					} else if (bean.getDia().toUpperCase().equals("MIERCOLES")) {
						vdd.setMensaje3(compararDisponibilidadHorario(lista.get(i).getMiercoles_ini(), lista.get(i).getMiercoles_fin(),
								bean.getHora_ini(), bean.getHora_fin()));
					} else if (bean.getDia().toUpperCase().equals("JUEVES")) {
						vdd.setMensaje4(compararDisponibilidadHorario(lista.get(i).getJueves_ini(), lista.get(i).getJueves_fin(),
								bean.getHora_ini(), bean.getHora_fin()));
					} else if (bean.getDia().toUpperCase().equals("VIERNES")) {
						vdd.setMensaje5(compararDisponibilidadHorario(lista.get(i).getViernes_ini(), lista.get(i).getViernes_fin(),
								bean.getHora_ini(), bean.getHora_fin()));
					} else if (bean.getDia().toUpperCase().equals("SABADO")) {
						vdd.setMensaje6(compararDisponibilidadHorario(lista.get(i).getSabado_ini(), lista.get(i).getSabado_fin(),
								bean.getHora_ini(), bean.getHora_fin()));
					} else if (bean.getDia().toUpperCase().equals("DOMINGO")) {
						vdd.setMensaje7(compararDisponibilidadHorario(lista.get(i).getDomingo_ini(), lista.get(i).getDomingo_fin(),
								bean.getHora_ini(), bean.getHora_fin()));
					}
				
					
//					System.out.println();
				}
				
				
				resultado.add(vdd);
				
				
//				System.out.println(resultado.get(i).getNombres() + "\t" + resultado.get(i).getLunes() + "\t" +
//						resultado.get(i).getMartes() + "\t" + resultado.get(i).getMiercoles() + "\t" +
//						resultado.get(i).getJueves() + "\t" + resultado.get(i).getViernes() + "\t" +
//						resultado.get(i).getSabado() + "\t" + resultado.get(i).getDomingo() + "\t" +
//						resultado.get(i).getMensaje1() + "\t" + resultado.get(i).getMensaje2() + "\t" +
//						resultado.get(i).getMensaje3() + "\t" + resultado.get(i).getMensaje4() + "\t" +
//						resultado.get(i).getMensaje5() + "\t" + resultado.get(i).getMensaje6() + "\t" +
//						resultado.get(i).getMensaje7()); 
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}
		
	private String compararDisponibilidadHorario(int a, int b, int c, int d){
		if ((a >= c) && (d >= b)) {
			return "Comparacion Exitosa"; // Comparacion exitosa
		} else {
			if ((a == 0) || (b == 0)) {
				return "DDD"; // dia disponible para el docente
			}
			return "Comparacion no Exitosa"; // Comparcion no exitosa

			// DNR Disponibilidad no registrada por default en el constructor del objeto
		}
	}
	
	private List<Disponibilidad_Docente> getDisponibilidadDocente(String nombres, String a_paterno, String a_materno, Conexion con, String sem) throws SQLException{
		List<Disponibilidad_Docente> lista = new ArrayList<Disponibilidad_Docente>();
		String sql = "SELECT DD.* FROM DISPONIBILIDAD_DOCENTE AS DD "
				+ "INNER JOIN DOCENTE AS DOC ON DOC.NUMDOC = DD.COD_DOCENTE " + "WHERE UPPER(DOC.APEPAT) = '"
				+ a_paterno + "' " + "AND UPPER(DOC.APEMAT) = '" + a_materno + "' " + "AND UPPER(DOC.NOMBRE) LIKE '"
				+ nombres + "%' AND DD.COD_SEMESTRE = '" + sem + "'";
		ResultSet rs = con.executeQuery(sql);
		while (rs.next()) {
			Disponibilidad_Docente bean = new Disponibilidad_Docente();
			bean.setCod_docente(rs.getString(2));
			bean.setCod_semestre(rs.getInt(3));
			bean.setHora_ini(rs.getInt(4));
			bean.setHora_fin(rs.getInt(5));
			bean.setDia(rs.getString(6));
			lista.add(bean);
		}
		System.out.println(sql);
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
	
//	private String compararDisponiblidadHorario_Recomendado(){
//		return "";
//	}
	
	private List<Disponibilidad_Docente> getDisponibilidadRecomendado(String nombres, String a_paterno, String a_materno, Conexion con, String sem) throws SQLException{
		List<Disponibilidad_Docente> lista = new ArrayList<Disponibilidad_Docente>();

		String sql = "SELECT DR.* FROM DISPONIBILIDAD_REFERIDO AS DR "
				+ "INNER JOIN REFERIDO AS REF ON REF.NUMDOC = DR.COD_REFERIDO " + "WHERE UPPER(REF.APEPAT) = '"
				+ a_paterno + "' " + "AND UPPER(REF.APEMAT) = '" + a_materno + "' " + "AND UPPER(REF.NOMBRE) LIKE '"
				+ nombres + "%' AND DR.COD_SEMESTRE = '" + sem + "'";
		ResultSet rs = con.executeQuery(sql);
		while (rs.next()) {
			Disponibilidad_Docente bean = new Disponibilidad_Docente();
			bean.setCod_docente(rs.getString(2));
			bean.setCod_semestre(rs.getInt(3));
			bean.setHora_ini(rs.getInt(4));
			bean.setHora_fin(rs.getInt(5));
			bean.setDia(rs.getString(6));
			lista.add(bean);
		}
		System.out.println(sql);

		return lista;
	}
}
