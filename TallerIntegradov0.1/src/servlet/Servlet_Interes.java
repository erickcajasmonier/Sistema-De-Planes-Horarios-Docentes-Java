package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beans.Docente;
import beans.Interes_Docente;
import beans.Referido;
import jdbc.Interes_DocenteJDBC;
import util.ReporteDocentexInteres_Excel;
import util.ReporteReferidoxInteres_Excel;

@WebServlet({"/RegistrarInteresDocente", "/RegistrarInteresReferido", "/ListarInteresxDocente", 
	"/ListarInteresxReferido", "/EliminarInteresDocente", "/EliminarInteresReferido",
	"/ListarDocentexInteres", "/ListarReferidoxInteres",
	"/ReporteDocentexInteres", "/ReporteReferidoxInteres"})
public class Servlet_Interes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			switch (request.getServletPath()) {
				case "/ListarInteresxDocente":
					listarInteresxDocente(request, response);
				break;
				case "/ListarInteresxReferido":
					listarInteresxReferido(request, response);
				break;
				case "/RegistrarInteresDocente":
					registrarInteresDocente(request, response);
					break;
				case "/RegistrarInteresReferido":
					registrarInteresReferido(request, response);
					break;
				case "/EliminarInteresDocente":
					eliminarInteresDocente(request, response);
					break;
				case "/EliminarInteresReferido":
					eliminarInteresReferido(request, response);
					break;
				case "/ListarDocentexInteres":
					listarDocentexInteres(request, response);
				break;
				case "/ListarReferidoxInteres":
					listarReferidoxInteres(request, response);
				break;
				case "/ReporteDocentexInteres":
					reporteDocentexInteres(request, response);
				break;
				case "/ReporteReferidoxInteres":
					reporteReferidoxInteres(request, response);
				break;
		
			}
			
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			e.printStackTrace();
		}
	}
    
    private void reporteDocentexInteres(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	String idcurso = request.getParameter("idcurso");
    	String idsem = request.getParameter("idsem");
    	String curso = request.getParameter("curso");
    	String sem = request.getParameter("sem");
    	
    	String flag = "-1";
    	
    	try {
    		ReporteDocentexInteres_Excel reporteExcel = new ReporteDocentexInteres_Excel();

    		flag = reporteExcel.generarExcel(idcurso, idsem, curso, sem) == true ? "1" : "0";

    	} catch (Exception e) {
    		System.out.println("Eror : " + e.getMessage());
    		e.printStackTrace();
    	}
    	response.setContentType("text/plain");
    	response.getWriter().write(flag);
    }
    
 private void reporteReferidoxInteres(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
	 	String idcurso = request.getParameter("idcurso");
	 	String idsem = request.getParameter("idsem");
    	String curso = request.getParameter("curso");
    	String sem = request.getParameter("sem");
    	
    	String flag = "-1";
    	
    	try {
    		ReporteReferidoxInteres_Excel reporteExcel = new ReporteReferidoxInteres_Excel();

    		flag = reporteExcel.generarExcel(idcurso, idsem,  curso, sem) == true ? "1" : "0";

    	} catch (Exception e) {
    		System.out.println("Eror : " + e.getMessage());
    		e.printStackTrace();
    	}
    	response.setContentType("text/plain");
    	response.getWriter().write(flag);
    }
 
    private void listarDocentexInteres(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		StringBuilder sb = new StringBuilder("");
		String idcurso = request.getParameter("idcurso");
		String sem = request.getParameter("sem");

		try {
			Interes_DocenteJDBC dao = new Interes_DocenteJDBC();
			List<Docente> lista = dao.listarDocentexInteres(idcurso, sem);
			if (lista != null) {
				for (Docente bean : lista) {
					sb.append(bean.getNumdoc() + "=" + bean.getNombre() + "=" + 
								bean.getApepat() + "=" + bean.getApemat() + "="+bean.getTelefono()+"="+bean.getEmail()+ "$");
				}
			} else {
				sb.append("_");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
    
    private void listarReferidoxInteres(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		StringBuilder sb = new StringBuilder("");
		String idcurso = request.getParameter("idcurso");
		String sem = request.getParameter("sem");

		try {
			Interes_DocenteJDBC dao = new Interes_DocenteJDBC();
			List<Referido> lista = dao.listarReferidoxInteres(idcurso, sem);
			if (lista != null) {
				for (Referido bean : lista) {
					sb.append(bean.getNumdoc() + "=" + bean.getNombre() + "=" + 
								bean.getApepat() + "=" + bean.getApemat() +"="+bean.getEmail()+ "$");
				}
			} else {
				sb.append("_");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
    
    private void eliminarInteresDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idcurso = request.getParameter("idcurso");
		String numdoc = request.getParameter("numdoc");
		String sem = request.getParameter("sem");
		//System.out.println("id: " + id);
		//Interes_Docente bean = new Interes_Docente();
		int respuesta = 0;
		try {
			Interes_DocenteJDBC dao = new Interes_DocenteJDBC();

			respuesta = dao.eliminarInteresDocente(idcurso, numdoc, sem) == true ? 1 : 0;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}
    
    private void eliminarInteresReferido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idcurso = request.getParameter("idcurso");
		String numdoc = request.getParameter("numdoc");
		String sem = request.getParameter("sem");
		//System.out.println("id: " + id);
		//Interes_Docente bean = new Interes_Docente();
		int respuesta = 0;
		try { 
			Interes_DocenteJDBC dao = new Interes_DocenteJDBC();

			respuesta = dao.eliminarInteresReferido(idcurso, numdoc, sem) == true ? 1 : 0;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}
    
    private void listarInteresxReferido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		StringBuilder sb = new StringBuilder("");
		String numdoc = request.getParameter("numdoc");
		String sem = request.getParameter("sem");
		//String semestre = request.getParameter("cod_semestre");

		try {
			Interes_DocenteJDBC dao = new Interes_DocenteJDBC();
			List<Interes_Docente> lista = dao.listarInteresxReferido(numdoc, sem);
			if (lista != null) {
				for (Interes_Docente bean : lista) {
					sb.append(bean.getCod_curso() + "=" + bean.getDescripcion() + "=" + bean.getEscuela() + "$");
				}
			} else {
				sb.append("_");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
    
    private void listarInteresxDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		StringBuilder sb = new StringBuilder("");
		String numdoc = request.getParameter("numdoc");
		String sem = request.getParameter("sem");
		//String semestre = request.getParameter("cod_semestre");

		try {
			Interes_DocenteJDBC dao = new Interes_DocenteJDBC();
			List<Interes_Docente> lista = dao.listarInteresxDocente(numdoc, sem);
			if (lista != null) {
				for (Interes_Docente bean : lista) {
					sb.append(bean.getCod_curso() + "=" + bean.getDescripcion() + "=" + bean.getEscuela() + "$");
				}
			} else {
				sb.append("_");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}

    private void registrarInteresDocente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, JSONException {
		String resultado="0";
		
		String jsonData = request.getParameter("objetojson");
		JSONObject obj = new JSONObject(jsonData);
		JSONArray arr = obj.getJSONArray("linea");
		
		try{
			Interes_DocenteJDBC dao = new Interes_DocenteJDBC();
			for (int i = 0; i < arr.length(); i++) {
				Interes_Docente bean = new Interes_Docente();
				
				bean.setCod_docente(arr.getJSONObject(i).getString("codDocente"));
				bean.setCod_curso(arr.getJSONObject(i).getString("idCurso"));
				bean.setCod_semestre(arr.getJSONObject(i).getInt("cod_semestre"));
				//bean.setInt_adicional(arr.getJSONObject(i).getString("int_adicional"));
				
				resultado = dao.registrarInteresDocente(bean) == true ? "1" : "0";
			}
			
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(resultado);
		
	}
    private void registrarInteresReferido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, JSONException {
		String resultado = "0";

		String jsonData = request.getParameter("objetojson");
		JSONObject obj = new JSONObject(jsonData);
		JSONArray arr = obj.getJSONArray("linea");

		try {
			Interes_DocenteJDBC dao = new Interes_DocenteJDBC();
			for (int i = 0; i < arr.length(); i++) {
				Interes_Docente bean = new Interes_Docente();

				bean.setCod_docente(arr.getJSONObject(i).getString("codDocente"));
				bean.setCod_curso(arr.getJSONObject(i).getString("idCurso"));
				bean.setCod_semestre(arr.getJSONObject(i).getInt("cod_semestre"));

				resultado = dao.registrarInteresReferido(bean) == true ? "1" : "0";
			}

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(resultado);

	}


}

