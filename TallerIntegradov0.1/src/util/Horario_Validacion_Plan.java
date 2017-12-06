package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import beans.Fichero_Excel;
import dto.DTOContratados;
import dto.DTOHorarios;
import dto.DTOValidacionHorasPlan;
import jdbc.Fichero_ExcelJDBC;

public class Horario_Validacion_Plan {
	List<DTOContratados> contratados = new ArrayList<DTOContratados>();
	
	private List<DTOHorarios> cargarExcel(String ruta) throws Exception{
		try {
			FileInputStream archivo = new FileInputStream(new File(ruta));

			XSSFWorkbook libro = new XSSFWorkbook(archivo);

			XSSFSheet hoja = libro.getSheetAt(0);

			List<DTOHorarios> lista = new ArrayList<DTOHorarios>();

			int f_contador = 0;
			int c_contador = 0;

			int horasxsemana = 0;
			
			List<DTOContratados> _contratados= new ArrayList<DTOContratados>();
			
			DTOHorarios dto = null;
			for (Row fila : hoja) {
				dto = new DTOHorarios();
				for (Cell celda : fila) {
					if (f_contador > 0) {
						if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
							switch (c_contador) {
							case 2:
								dto.setCiclo(celda.getStringCellValue());
								break;
							case 3:
								dto.setTur(celda.getStringCellValue());
								break;
							case 4:
								dto.setCod_cur(celda.getStringCellValue());
								break;
							case 5:
								dto.setCod_cur_teoria(celda.getStringCellValue());
								break;
							case 6:
								dto.setProfesor(celda.getStringCellValue());
								break;
							case 7:
								dto.setCurso(celda.getStringCellValue());
								break;
							case 8:
								dto.setDesres(celda.getStringCellValue());
								break;
							case 9:
								dto.setSeccion(celda.getStringCellValue());
								break;
							case 10:
								dto.setAula(celda.getStringCellValue());
								break;
							case 11:
								dto.setEscuela(celda.getStringCellValue());
								break;
							case 12:
								dto.setNumcre(celda.getStringCellValue());
								break;
							case 13:
								dto.setLunes(celda.getStringCellValue());
								horasxsemana = horasxsemana + obtenerHorasxDia(celda);
								dto.setHorasxsemana(horasxsemana);
								break;
							case 14:
								dto.setMartes(celda.getStringCellValue());
								horasxsemana = horasxsemana + obtenerHorasxDia(celda);
								dto.setHorasxsemana(horasxsemana);
								break;
							case 15:
								dto.setMiercoles(celda.getStringCellValue());
								horasxsemana = horasxsemana + obtenerHorasxDia(celda);
								dto.setHorasxsemana(horasxsemana);
								break;
							case 16:
								dto.setJueves(celda.getStringCellValue());
								horasxsemana = horasxsemana + obtenerHorasxDia(celda);
								dto.setHorasxsemana(horasxsemana);
								break;
							case 17:
								dto.setViernes(celda.getStringCellValue());
								horasxsemana = horasxsemana + obtenerHorasxDia(celda);
								dto.setHorasxsemana(horasxsemana);
								break;
							case 18:
								dto.setSabado(celda.getStringCellValue());
								horasxsemana = horasxsemana + obtenerHorasxDia(celda);
								dto.setHorasxsemana(horasxsemana);
								break;
							case 19:
								dto.setDomingo(celda.getStringCellValue());
								horasxsemana = horasxsemana + obtenerHorasxDia(celda);
								dto.setHorasxsemana(horasxsemana);
								break;
							}
						}
					}else{
						if( (celda.getStringCellValue().equalsIgnoreCase("CODFAC")) || (celda.getStringCellValue().equalsIgnoreCase("01'"))
								|| (celda.getStringCellValue().equalsIgnoreCase("CICEST")) || (celda.getStringCellValue().equalsIgnoreCase("TUR"))
								|| (celda.getStringCellValue().equalsIgnoreCase("CODCUR")) || (celda.getStringCellValue().equalsIgnoreCase("CODCURTEO"))
								|| (celda.getStringCellValue().equalsIgnoreCase("PROFESOR")) || (celda.getStringCellValue().equalsIgnoreCase("CURSO"))
								|| (celda.getStringCellValue().equalsIgnoreCase("DESRES")) || (celda.getStringCellValue().equalsIgnoreCase("CODSEC"))
								|| (celda.getStringCellValue().equalsIgnoreCase("AULA")) || (celda.getStringCellValue().equalsIgnoreCase("ESCUELA"))
								|| (celda.getStringCellValue().equalsIgnoreCase("NUMCRE")) || (celda.getStringCellValue().equalsIgnoreCase("LUNES")) 
								|| (celda.getStringCellValue().equalsIgnoreCase("MARTES")) || (celda.getStringCellValue().equalsIgnoreCase("MIERCOLES"))
								|| (celda.getStringCellValue().equalsIgnoreCase("JUEVES")) || (celda.getStringCellValue().equalsIgnoreCase("VIERNES"))
								|| (celda.getStringCellValue().equalsIgnoreCase("SABADO")) || (celda.getStringCellValue().equalsIgnoreCase("DOMINGO")) ){
							//C MAMUT
						}else{
							return null;
						}
					}
					c_contador++;
				}

				if (f_contador > 0) {
					lista.add(dto);
				}
				f_contador++;
				horasxsemana = 0;
				c_contador = 0;
				
			}
			lista.remove(f_contador - 2);// sin esta linea se guarda un ultimo dto con datos vacios
			// System.out.println(lista.size());
			contratados.addAll(_contratados);
			return lista;
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean guardaExcelDB(String ruta, String cod_usuario, String nombre_archivo, String semestre) throws Exception{
		String sql = "INSERT INTO HORARIO_EXCEL (ciclo, tur, cod_cur, cod_cu_teoria, profesor, curso, desres, seccion, aula, escuela, numcre, lunes, martes, miercoles, jueves, viernes, sabado, domingo, horas_semana, tipo_profesor, nombre_archivo, cod_usuario, semestre)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		List<DTOHorarios> lista = cargarExcel(ruta);	
		
		try{
			Conexion con = new Conexion();
			PreparedStatement ps = con.executePreparedStatement(sql);

			if (lista != null) {
				for (DTOHorarios dto : lista) {
					ps.setString(1, dto.getCiclo());
					ps.setString(2, dto.getTur());
					ps.setString(3, dto.getCod_cur());
					ps.setString(4, dto.getCod_cur_teoria());
					ps.setString(5, dto.getProfesor());
					ps.setString(6, dto.getCurso());
					ps.setString(7, dto.getDesres());
					ps.setString(8, dto.getSeccion());
					ps.setString(9, dto.getAula());
					ps.setString(10, dto.getEscuela());
					ps.setString(11, dto.getNumcre());
					ps.setString(12, dto.getLunes());
					ps.setString(13, dto.getMartes());
					ps.setString(14, dto.getMiercoles());
					ps.setString(15, dto.getJueves());
					ps.setString(16, dto.getViernes());
					ps.setString(17, dto.getSabado());
					ps.setString(18, dto.getDomingo());
					ps.setInt(19, dto.getHorasxsemana());
					ps.setString(20, "CONTRATADO");
					ps.setString(21, nombre_archivo);
					ps.setString(22, cod_usuario);
					ps.setString(23, semestre);
					ps.executeUpdate();
				}
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public List<DTOHorarios> listarHorarioFiltrado(String pk_escuela) throws Exception{
		List<DTOHorarios> lista = new ArrayList<DTOHorarios>();
		String escuela = obtenerStringEscuela(pk_escuela);
		String sql = "SELECT ciclo, tur, cod_cur, cod_cu_teoria, profesor, curso, seccion, aula, escuela, numcre, lunes, martes, miercoles, jueves, viernes, sabado, domingo, horas_semana, id_horario_excel"
				+ " FROM HORARIO_EXCEL WHERE ESCUELA LIKE '%" + escuela + "%'";
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
				dto.setIndex(rs.getInt(19));
				lista.add(dto);
			}
			return lista;
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public List<DTOValidacionHorasPlan> validarHorasxPlan(String pk_escuela, String semestre) throws Exception {
		List<DTOValidacionHorasPlan> cursos = curso(pk_escuela);
		List<Integer> horas_curso_plan = horasCursoxPlan(cursos, semestre, pk_escuela);
		try {
			Conexion con = new Conexion();
			int horas_excel = 0;
			int horas_plan = 0;

			for (int i = 0; i < cursos.size(); i++) {

				horas_excel = cursos.get(i).getHoras_curso_excel();

				horas_plan = horas_curso_plan.get(i);
				
				if(horas_plan == 0){			// ES LABORATORIO O NO HAY HORAS EN EL CURSO
					cursos.get(i).setHoras_curso_plan(horaslab(cursos.get(i).getSicat(), con, pk_escuela, semestre));
				}else if(horas_plan == -1){		// CURSO NO EXISTE EN LA BD
					cursos.get(i).setHoras_curso_plan(-1);
				}else{							// HORAS REGISTRADAS EN EL SISTEMA
					cursos.get(i).setHoras_curso_plan(horas_plan);
				}
				
				horas_plan = cursos.get(i).getHoras_curso_plan();
				
				if (horas_plan == horas_excel) {
					cursos.get(i).setFlag(1);
				} else {
					if (cursos.get(i).getHoras_curso_plan() == -1) {
						cursos.get(i).setFlag(-1);
					} else {
						cursos.get(i).setFlag(0);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return cursos;
	}
	
	private List<DTOValidacionHorasPlan> curso(String pk_escuela){
		String escuela = obtenerStringEscuela(pk_escuela);
		String sql = "SELECT COD_CUR, CURSO, IDCURSO, SECCION, SUM(HORAS_SEMANA) FROM HORARIO_EXCEL, CURSO " +
				"WHERE ESCUELA LIKE '%" + escuela + "%' AND COD_CUR = SICAT " +
				"GROUP BY CURSO, SECCION " +
				"ORDER BY ID_HORARIO_EXCEL ";
		List<DTOValidacionHorasPlan> lista = new ArrayList<DTOValidacionHorasPlan>();

		try {
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
 			while(rs.next()){
				DTOValidacionHorasPlan dto = new DTOValidacionHorasPlan();
				dto.setSicat(rs.getString(1));
				dto.setCurso(rs.getString(2));
				dto.setSap(rs.getString(3));
				dto.setSeccion(rs.getString(4));
				dto.setHoras_curso_excel(rs.getInt(5));
				lista.add(dto);
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println(sql);
		return lista;
	}
	
	private List<Integer> horasCursoxPlan(List<DTOValidacionHorasPlan> cursos, String semestre, String escuela){
		List<Integer> lista = new ArrayList<Integer>();
//		String sql = "SELECT H_TEO + H_PRACT FROM CURSO WHERE SICAT = ?";
		String sql = "SELECT H_TEO + H_PRACT FROM DET_CURSO_ESC "
				+ "WHERE SICAT = ? AND IDPLAN = (SELECT IDPLAN FROM PLAN_CURRICULAR WHERE IDESCUELA = ? AND CODPC_SEM = ?)";
		String sicat = "";
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = null;
			ResultSet rs = null;

			for (int i = 0; i < cursos.size(); i++) {
				sicat = cursos.get(i).getSicat();
				ps = con.executePreparedStatement(sql);
				ps.setString(1, sicat);
				ps.setString(2, escuela);
				ps.setString(3, semestre);
				rs = ps.executeQuery();
				
				if(rs.next()){
					lista.add(rs.getInt(1));
				}else{
					lista.add(-1);
				}
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}
	
	private int horaslab(String curso, Conexion con, String escuela, String semestre) {
		int _horaslab = 0;
		String sql = "SELECT H_LAB FROM DET_CURSO_ESC WHERE SICAT = (SELECT DISTINCT COD_CU_TEORIA FROM HORARIO_EXCEL WHERE COD_CUR = '" + curso + "') " +
				"AND IDPLAN = (SELECT IDPLAN FROM PLAN_CURRICULAR WHERE IDESCUELA = " + escuela + " AND CODPC_SEM = " + semestre + ")";

		try {
			ResultSet rs = con.executeQuery(sql);
			if (rs.next()) {
				_horaslab = rs.getInt(1);
			} else {
				_horaslab = horasSoloLAB(curso, con, escuela, semestre);
			}
		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
			e.printStackTrace();
		}
		return _horaslab;
	}

	private int horasSoloLAB(String curso, Conexion con, String escuela, String semestre) {   //PARA CURSOS DONDE SOLO ESTA REGISTRADO LABORATORIO
		int _horaslab = 0;
//		String sql = "SELECT H_LAB FROM CURSO WHERE SICAT = '" + curso + "'";
		String sql = "SELECT H_LAB FROM DET_CURSO_ESC WHERE SICAT = '" + curso + "' "
				+ "AND IDPLAN = (SELECT IDPLAN FROM PLAN_CURRICULAR WHERE IDESCUELA = " + escuela + " AND CODPC_SEM = " + semestre + ")"; 

		try {
			ResultSet rs = con.executeQuery(sql);
			if (rs.next()) {
				_horaslab = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
			e.printStackTrace();
		}
		return _horaslab;
	}
	
	public boolean actualizarFila(String profesor, String[] dias, int index){
		boolean flag = false;
		String tipo_profesor = profesor.endsWith("(R)") == true ? "RECOMENDADO" : "CONTRATADO";
		profesor = profesor.replace("(C)", "");
		profesor = profesor.replace("(I)", "");
		profesor = profesor.replace("(R)", "");
		
		int horas = 0;
		for(int i = 0; i < dias.length; i++){
			System.out.println(dias[i]);
			
			if ((dias[i].equals(""))) {
			} else {
				horas += obtenerHorasxDia(dias[i]);
			}
		}
		
		String sql = "UPDATE HORARIO_EXCEL " +
						"SET PROFESOR = '" + profesor + "', " +
							"LUNES = '" + dias[0] + "', " +
							"MARTES = '" + dias[1] + "', " +
							"MIERCOLES = '" + dias[2] + "', " +
							"JUEVES = '" + dias[3] + "', " +
							"VIERNES = '" + dias[4] + "', " +
							"SABADO = '" + dias[5] + "', " +
							"DOMINGO = '" + dias[6] + "', " +
							"HORAS_SEMANA = '" + horas + "'," +
							"TIPO_PROFESOR = '" + tipo_profesor + "' " +
						"WHERE ID_HORARIO_EXCEL = '" + index + "'";
		
		try {
			Conexion con= new Conexion();
			
			flag = con.executeUpdate(sql) == 1 ? true : false;
					
		} catch (Exception e) {
			System.out.print("Error : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println(sql);
		return flag;
	}
	
	public DTOContratados listarContratados(String curso, String seccion){
		String sql = "SELECT COD_CUR, PROFESOR, CURSO, SECCION FROM DOCENTE_CONTRATADO_EXCEL WHERE CURSO = '"+ curso +"' AND SECCION ='"+seccion+"'";
		DTOContratados dto = new DTOContratados();
		try{
			Conexion con = new Conexion();
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				dto.setCod_cur(rs.getString(1));
				dto.setDocente(rs.getString(2));
				dto.setCurso(rs.getString(3));
			}
		}catch(Exception e){
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return dto;
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
	
	private int obtenerHorasxDia(Cell celda){
		String valor_inicio = celda.getStringCellValue().substring(0, 5);
		String valor_fin = celda.getStringCellValue().substring(6, 11);

		String inicio_primer_digito = valor_inicio.substring(0, 2);
		String fin_primer_digito = valor_fin.substring(0, 2);

		String inicio_segundo_digito = valor_inicio.substring(3, 5);
		String fin_segundo_digito = valor_fin.substring(3, 5);

//		System.out.print("\t" + valor_inicio + " " + valor_fin);
		
		return contarHoras(inicio_primer_digito, fin_primer_digito, inicio_segundo_digito,
				fin_segundo_digito);
	}
	
	private int obtenerHorasxDia(String cadena){
		String valor_inicio = cadena.substring(0, 5);
		String valor_fin = cadena.substring(6, 11);

		String inicio_primer_digito = valor_inicio.substring(0, 2);
		String fin_primer_digito = valor_fin.substring(0, 2);

		String inicio_segundo_digito = valor_inicio.substring(3, 5);
		String fin_segundo_digito = valor_fin.substring(3, 5);

//		System.out.print("\t" + valor_inicio + " " + valor_fin);
		
		return contarHoras(inicio_primer_digito, fin_primer_digito, inicio_segundo_digito,
				fin_segundo_digito);
	}
	
	private int contarHoras(String inicio_p, String fin_p, String inicio_s, String fin_s) {

		int inicio_1 = Integer.parseInt(inicio_p);
		int inicio_2 = Integer.parseInt(inicio_s);
		int fin_1 = Integer.parseInt(fin_p);
		int fin_2 = Integer.parseInt(fin_s);

		int diferenciaHora = fin_1 - inicio_1;

		int horasAcademicas = 0;
		
		if (diferenciaHora >= 2) {
			diferenciaHora--;
			if (fin_2 <= inicio_2) {
				switch (inicio_2 - fin_2) {
				case 0:
					horasAcademicas = diferenciaHora + 2;
					break;
				default:
					horasAcademicas = diferenciaHora + 1;
					break;
				}
			} else {
				horasAcademicas = diferenciaHora + 2;
			}
		} else {
			if (fin_2 <= inicio_2) {
				switch (inicio_2 - fin_2) {
				case 15:
					horasAcademicas = diferenciaHora;
					break;
				default :
					horasAcademicas = diferenciaHora + 1;
					break;
				}
			} else {
				switch (fin_2 - inicio_2) {
				case 15:
					horasAcademicas = diferenciaHora;
					break;
				default:
					horasAcademicas = diferenciaHora + 1;
					break;
				}
			}
		}

		return horasAcademicas;
	}

}