package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beans.Perfil;
import jdbc.PerfilesJDBC;

@WebServlet("/RegistrarPerfil")
public class Servlet_Perfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			switch (request.getServletPath()) {
			case "/RegistrarPerfil":
				registrarPerfil(request, response);
			}
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private void registrarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, JSONException {
//		int cod_docente = Integer.parseInt(request.getParameter("cod_docente"));
//		int cod_semestre = Integer.parseInt(request.getParameter("cod_semestre"));
//		int hora_ini = Integer.parseInt(request.getParameter("hora_ini"));
//		int hora_fin = Integer.parseInt(request.getParameter("hora_fin"));
//		String dia = request.getParameter("dia");
		
		String resultado = "0";
		
		String jsonData = request.getParameter("objetojson");
		JSONObject obj = new JSONObject(jsonData);
		JSONArray arr = obj.getJSONArray("linea");
		
		try{
			PerfilesJDBC dao = new PerfilesJDBC();
			for (int i = 0; i < arr.length(); i++) {
				Perfil bean = new Perfil();
				
				bean.setNombre(arr.getJSONObject(i).getString("nombre"));
				bean.setPermiso(arr.getJSONObject(i).getString("permisos"));
				resultado = dao.registrarPermisos(bean) == true ? "1" : "0";
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(resultado);
	}

}
