package servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.Docente;
import beans.Fichero_Excel;
import dto.DTOContratados;
import dto.DTOHorarios;
import dto.DTOResultadoVDD;
import dto.DTOValidacionHorasPlan;
import jdbc.DocenteJDBC;
import jdbc.Fichero_ExcelJDBC;
import jdbc.HorarioJDBC;
import util.Horario_Disponibilidad_Docente;
import util.Horario_Validacion_Plan;


@WebServlet({"/ConsultarHorario", "/ImportarExcel", "/ValidarExcel", "/SubirArchivo", "/ValidarExcelDisp", "/ListarInteresados", "/ListarReferidos",
			"/ActualizarFila", "/ListarHorariosActualizados", "/ListarContratados"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50)
public class Servlet_Horario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "Sistema Planes, Docentes y Horarios";
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			switch (request.getServletPath()) {
			case "/ImportarExcel":
				importarExcel(request, response);
				break;
			case "/ValidarExcel":
				validarExcel(request, response);
				break;
			case "/ConsultarHorario":
				consultarHorario(request, response);
				break;
			case "/SubirArchivo":
				subirArchivo(request, response);
				break;
			case "/ValidarExcelDisp":
				validarDisp(request, response);
				break;
			case "/ListarInteresados":
				listarDocentesInteresados(request, response);
				break;
			case "/ListarReferidos":
				listarDocentesReferidos(request, response);
				break;
			case "/ActualizarFila":
				actualizarFila(request, response);
				break;
			case "/ListarHorariosActualizados":
				listarHorariosActualizados(request, response);
				break;
			case "/ListarContratados":
				listarContratados(request, response);
				break;
			}
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void listarHorariosActualizados(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Horario_Validacion_Plan excel = new Horario_Validacion_Plan();
		StringBuilder respuesta = new StringBuilder("");
		String semestre = request.getParameter("semestre");
		String escuela = request.getParameter("escuela");
		
		try{
			
			List<DTOHorarios> lista = excel.listarHorarioFiltrado(escuela);
			for(DTOHorarios dto : lista){
				respuesta.append(dto.getCiclo() + "<>" + dto.getTur() + "<>" + dto.getCod_cur() + "<>" + dto.getCod_cur_teoria() + "<>" + dto.getProfesor() + "<>"
								+ dto.getCurso() + "<>" + dto.getDesres() + "<>" + dto.getSeccion() + "<>" + dto.getAula() + "<>" + dto.getEscuela() + "<>"
								+ dto.getNumcre() + "<>" + dto.getLunes() + "<>" + dto.getMartes() + "<>" + dto.getMiercoles() + "<>"
								+ dto.getJueves() + "<>" + dto.getViernes() + "<>" + dto.getSabado() + "<>" + dto.getDomingo() + "<>" + dto.getIndex() + "%");
			}
			
		}catch(Exception e){
			System.out.println("Error  : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta.toString());
	}
	
	private void actualizarFila(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String profesor = request.getParameter("_profesor").toUpperCase();
		int index = Integer.parseInt(request.getParameter("_index"));
		String lunes = request.getParameter("_lunes");
		String martes = request.getParameter("_martes");
		String miercoles = request.getParameter("_miercoles");
		String jueves = request.getParameter("_jueves");
		String viernes = request.getParameter("_viernes");
		String sabado = request.getParameter("_sabado");
		String domingo = request.getParameter("_domingo");
		String dias[] = {lunes, martes, miercoles, jueves, viernes, sabado, domingo};
		
		String _flag = "0";
		
		try {
			boolean flag = false;
			Horario_Validacion_Plan dao = new Horario_Validacion_Plan();
			
			flag = dao.actualizarFila(profesor, dias, index);
			
			_flag = flag == true ? "1" : "0";
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		
		response.setContentType("text/plain");
		response.getWriter().write(_flag);
	}
	
	private void listarDocentesInteresados(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String curso = request.getParameter("curso");
		DocenteJDBC dao = new DocenteJDBC();
		List<Docente> lista = dao.listarInteresados(curso);
		StringBuilder sb = new StringBuilder("");
		
		try{
			
			for(Docente bean : lista){
				sb.append(bean.getApepat() + " " + bean.getApemat() + "," + bean.getNombre() + "%");
			}
			
		}catch(Exception e){
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
			sb.append("0");
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	private void listarDocentesReferidos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String curso = request.getParameter("curso");
		DocenteJDBC dao = new DocenteJDBC();
		List<Docente> lista = dao.listarReferidos(curso);
		StringBuilder sb = new StringBuilder("");
		
		try{
			
			for(Docente bean : lista){
				sb.append(bean.getApepat() + " " + bean.getApemat() + "," + bean.getNombre() + "%");
			}
			
		}catch(Exception e){
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
			sb.append("0");
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	private void listarContratados(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String curso = request.getParameter("curso");
		String seccion = request.getParameter("seccion");
		Horario_Validacion_Plan dao = new Horario_Validacion_Plan();
		StringBuilder sb = new StringBuilder("");
		
		try{
			DTOContratados dto = dao.listarContratados(curso, seccion);
			sb.append(dto.getDocente());
				
		}catch(Exception e){
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
			sb.append("0");
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	private void validarDisp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String esc = request.getParameter("escuela");
		String sem = request.getParameter("semestre");
		Horario_Disponibilidad_Docente ddd = new Horario_Disponibilidad_Docente();
		List<DTOResultadoVDD> lista = ddd.resultadoValidacionDD(esc, sem);
		StringBuilder sb = new StringBuilder("");
		try {

			for (DTOResultadoVDD dto : lista) {
				sb.append(dto.getNombres() + "<>" + dto.getLunes() + "<>" + dto.getMartes() + "<>" + dto.getMiercoles()
						+ "<>" + dto.getJueves() + "<>" + dto.getViernes() + "<>" + dto.getSabado() + "<>"
						+ dto.getDomingo() + "<>" + dto.getMensaje1() + "<>" + dto.getMensaje2() + "<>"
						+ dto.getMensaje3() + "<>" + dto.getMensaje4() + "<>" + dto.getMensaje5() + "<>"
						+ dto.getMensaje6() + "<>" + dto.getMensaje7() + "<>" + dto.getCurso() + "<>" + "/*");
			}

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	private void consultarHorario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String esc = request.getParameter("escuela");
		String sem = request.getParameter("semestre");

		StringBuilder sb = new StringBuilder("");

		try {
			HorarioJDBC dao = new HorarioJDBC();
			List<DTOHorarios> lista = dao.consultarHorario(sem, esc);
			for(DTOHorarios dto : lista){
				sb.append(dto.getCiclo() + "<>" + dto.getTur() + "<>" + dto.getCod_cur() + "<>" + dto.getCod_cur_teoria() + "<>" + dto.getProfesor() + "<>"
								+ dto.getCurso() + "<>" + dto.getDesres() + "<>" + dto.getSeccion() + "<>" + dto.getAula() + "<>" + dto.getEscuela() + "<>"
								+ dto.getNumcre() + "<>" + dto.getLunes() + "<>" + dto.getMartes() + "<>" + dto.getMiercoles() + "<>"
								+ dto.getJueves() + "<>" + dto.getViernes() + "<>" + dto.getSabado() + "<>" + dto.getDomingo() + "<>" + dto.getIndex() + "%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());

	}
	
	private void importarExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Horario_Validacion_Plan excel = new Horario_Validacion_Plan();
		StringBuilder respuesta = new StringBuilder("");
		boolean flag = false;
		String semestre = request.getParameter("semestre");
		String escuela = request.getParameter("escuela");
		HttpSession session = request.getSession();
		String cod_usuario = (String) session.getAttribute("idUser");
		Fichero_ExcelJDBC dao = new Fichero_ExcelJDBC();
		String nombre_archivo = dao.getFichero().getDescripcion();

		String ruta = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + SAVE_DIR + File.separator
				+ nombre_archivo;
		try {
			flag = excel.guardaExcelDB(ruta, cod_usuario, nombre_archivo, semestre);
			if (flag) {
				List<DTOHorarios> lista = excel.listarHorarioFiltrado(escuela);
				for(DTOHorarios dto : lista){
					respuesta.append(dto.getCiclo() + "<>" + dto.getTur() + "<>" + dto.getCod_cur() + "<>" + dto.getCod_cur_teoria() + "<>" + dto.getProfesor() + "<>"
									+ dto.getCurso() + "<>" + dto.getDesres() + "<>" + dto.getSeccion() + "<>" + dto.getAula() + "<>" + dto.getEscuela() + "<>"
									+ dto.getNumcre() + "<>" + dto.getLunes() + "<>" + dto.getMartes() + "<>" + dto.getMiercoles() + "<>"
									+ dto.getJueves() + "<>" + dto.getViernes() + "<>" + dto.getSabado() + "<>" + dto.getDomingo() + "<>" + dto.getIndex() + "%");
				}
			}else{
				respuesta.append("0");
			}
		}catch(Exception e){
			System.out.println("Error  : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta.toString());
	}
	
	private void validarExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String semestre = request.getParameter("semestre");
		String escuela = request.getParameter("escuela");
		StringBuilder respuesta = new StringBuilder("");
		String msj;
		Horario_Validacion_Plan excel = new Horario_Validacion_Plan();

		try {
			List<DTOValidacionHorasPlan> lista = excel.validarHorasxPlan(escuela, semestre);
			String horas_plan = "";
			if (lista != null) {
				for (DTOValidacionHorasPlan dto : lista) {
					if (dto.getFlag() == 1) {
						msj = "Correcto";
					} else if (dto.getFlag() == 0) {
						msj = "Revisar Horas";
					} else {
						msj = "Curso no registrado en el plan del semestre";
					}
					
					if(dto.getHoras_curso_plan() == -1){
						horas_plan = "-";
					}else{
						horas_plan = String.valueOf(dto.getHoras_curso_plan());
					}
					
					respuesta.append(dto.getSap() + "<>" + dto.getSicat() + "<>" + dto.getCurso() + "<>"
							+ dto.getHoras_curso_excel() + "<>" + horas_plan + "<>" + dto.getSeccion()
							+ "<>" + msj + "%");
					// System.out.println(dto.getSap() + "\t" + dto.getSicat() +
					// "\t" + dto.getCurso() + "\t" + dto.getHoras_curso_excel() + "\t" + dto.getHoras_curso_plan() + "\t" + msj);
				}
			} else {
				respuesta.append("0");
			}
		} catch (Exception e) {
			System.out.println("Error e : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta.toString());
	}
	
	private void subirArchivo(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		String respuesta = "1";
		response.setContentType("text/plain");
		try {
			
			Fichero_ExcelJDBC dao = new Fichero_ExcelJDBC();
			String rutaArchivo = System.getProperty("user.home") + File.separator +"Desktop" + File.separator + SAVE_DIR  + File.separator;
			String nombre_archivo = "Horarios - 0.xlsx";
			
			System.out.println(rutaArchivo);

			File fileSaveDir = new File(rutaArchivo);
			
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
				dao.registrarFichero(nombre_archivo);
			} else {
				Fichero_Excel bean = dao.getFichero();
				int contador = Integer.parseInt(bean.getDescripcion().replace(".xlsx", "").substring(11)) + 1;
				nombre_archivo = "Horarios - " + contador + ".xlsx";
				dao.registrarFichero(nombre_archivo);
			}
			
			
			Part part = request.getPart("txtarchivo");

			part.write(rutaArchivo + nombre_archivo);
			
//			response.getWriter().write(respuesta);
		} catch (Exception e) {
			System.out.println("Error e : " +e.getMessage());
			e.printStackTrace();
//			respuesta = "0";
//			response.getWriter().write(respuesta);

		}

	}
}
