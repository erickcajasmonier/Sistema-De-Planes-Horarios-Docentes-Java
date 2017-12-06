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

import beans.Disponibilidad_Docente;
import jdbc.Disponibilidad_DocenteJDBC;




@WebServlet({"/RegistrarDisponibilidadDocente", "/RegistrarDisponibilidadReferido", "/ListarDisponibilidadxDocente", 
	"/ListarDisponibilidadxReferido", "/EliminarDisponibilidadDocente", "/EliminarDisponibilidadReferido"})
public class Servlet_Disponibilidad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			switch (request.getServletPath()) {
				case "/ListarDisponibilidadxDocente":
					listarDisponibilidadxDocente(request, response);
				break;
				case "/ListarDisponibilidadxReferido":
					listarDisponibilidadxReferido(request, response);
				break;
				case "/RegistrarDisponibilidadDocente":
					registrarDisponibilidadDocente(request, response);
					break;
				case "/RegistrarDisponibilidadReferido":
					registrarDisponibilidadReferido(request, response);
					break;
				case "/EliminarDisponibilidadDocente":
					eliminarDisponibilidadDocente(request, response);
					break;
				case "/EliminarDisponibilidadReferido":
					eliminarDisponibilidadReferido(request, response);
					break;
		
			}
			
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			e.printStackTrace();
		}
	}
    
    private void eliminarDisponibilidadReferido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
    	String numdoc = request.getParameter("numdoc");
		String sem = request.getParameter("sem");
		String horini = request.getParameter("horini");
		String horfin = request.getParameter("horfin");
		String dia = request.getParameter("dia");
		
		//System.out.println("id: " + id);
		Disponibilidad_Docente bean = new Disponibilidad_Docente();
		int respuesta = 0;
		try {
			Disponibilidad_DocenteJDBC dao = new Disponibilidad_DocenteJDBC();

			respuesta = dao.eliminarDisponibilidadReferido(numdoc, sem, horini,horfin,dia) == true ? 1 : 0;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}
    
    private void eliminarDisponibilidadDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String numdoc = request.getParameter("numdoc");
		String sem = request.getParameter("sem");
		String horini = request.getParameter("horini");
		String horfin = request.getParameter("horfin");
		String dia = request.getParameter("dia");
		
		//System.out.println("id: " + id);
		Disponibilidad_Docente bean = new Disponibilidad_Docente();
		int respuesta = 0;
		try {
			Disponibilidad_DocenteJDBC dao = new Disponibilidad_DocenteJDBC();

			respuesta = dao.eliminarDisponibilidadDocente(numdoc, sem, horini,horfin,dia) == true ? 1 : 0;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}
    
    private void listarDisponibilidadxReferido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		StringBuilder sb = new StringBuilder("");
		String numdoc = request.getParameter("numdoc");
		String sem = request.getParameter("sem");

		try {
			Disponibilidad_DocenteJDBC dao = new Disponibilidad_DocenteJDBC();
			List<Disponibilidad_Docente> lista = dao.listarDisponibilidadxReferido(numdoc, sem);
			if (lista != null) {
				for (Disponibilidad_Docente bean : lista) {
					sb.append(bean.getDia() + "=" + bean.getHora_ini() + "=" + bean.getHora_fin() + "$");
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

    
    private void listarDisponibilidadxDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		StringBuilder sb = new StringBuilder("");
		String numdoc = request.getParameter("numdoc");
		String sem = request.getParameter("sem");
		//String semestre = request.getParameter("cod_semestre");

		try {
			Disponibilidad_DocenteJDBC dao = new Disponibilidad_DocenteJDBC();
			List<Disponibilidad_Docente> lista = dao.listarDisponibilidadxDocente(numdoc, sem);
			if (lista != null) {
				for (Disponibilidad_Docente bean : lista) {
					sb.append(bean.getDia() + "=" + bean.getHora_ini() + "=" + bean.getHora_fin() + "$");
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
    
	private void registrarDisponibilidadDocente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, JSONException {
		// TODO Auto-generated method stub

		String resultado = "0";
		
		String jsonData = request.getParameter("objetojson");
		JSONObject obj = new JSONObject(jsonData);
		JSONArray arr = obj.getJSONArray("linea");
		
		try{
			Disponibilidad_DocenteJDBC dao = new Disponibilidad_DocenteJDBC();
			for (int i = 0; i < arr.length(); i++) {
				Disponibilidad_Docente bean = new Disponibilidad_Docente();
				
				bean.setCod_docente(arr.getJSONObject(i).getString("cod_docente"));
				bean.setCod_semestre(arr.getJSONObject(i).getInt("cod_semestre"));
				bean.setHora_ini(arr.getJSONObject(i).getInt("hora_ini"));
				bean.setHora_fin(arr.getJSONObject(i).getInt("hora_fin"));
				bean.setDia(arr.getJSONObject(i).getString("dia"));
				
				resultado = dao.registrarDisponiblidadDocente(bean) == true ? "1" : "0";
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(resultado);
	}

	private void registrarDisponibilidadReferido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, JSONException {

		String resultado = "0";

		String jsonData = request.getParameter("objetojson");
		JSONObject obj = new JSONObject(jsonData);
		JSONArray arr = obj.getJSONArray("linea");

		try {
			Disponibilidad_DocenteJDBC dao = new Disponibilidad_DocenteJDBC();
			for (int i = 0; i < arr.length(); i++) {
				Disponibilidad_Docente bean = new Disponibilidad_Docente();
				bean.setCod_docente(arr.getJSONObject(i).getString("cod_docente"));
				bean.setCod_semestre(arr.getJSONObject(i).getInt("cod_semestre"));
				bean.setHora_ini(arr.getJSONObject(i).getInt("hora_ini"));
				bean.setHora_fin(arr.getJSONObject(i).getInt("hora_fin"));
				bean.setDia(arr.getJSONObject(i).getString("dia"));

				resultado = dao.registrarDisponiblidadReferido(bean) == true ? "1" : "0";
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(resultado);
	}
}
