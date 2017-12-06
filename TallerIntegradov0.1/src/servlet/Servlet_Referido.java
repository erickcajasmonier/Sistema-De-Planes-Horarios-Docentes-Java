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

import beans.Referido;
import jdbc.ReferidoJDBC;

@WebServlet({ "/RegistrarReferido", "/ListarReferido", "/BuscarReferido","/ListarReferidoxDocente", "/ListarReferidoxDocenteSem",
	"/EliminarReferido",
	"/EditarReferido"})
public class Servlet_Referido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			switch (request.getServletPath()) {
			case "/RegistrarReferido":
				registrarReferido(request, response);
				break;
			case "/ListarReferido":
				listarReferido(request, response);
				break;
			case "/BuscarReferido":
				buscarReferido(request, response);
				break;
			case "/ListarReferidoxDocenteSem":
				listarReferidoxDocenteSem(request, response);
				break;
			case "/ListarReferidoxDocente":
				listarReferidoxDocente(request, response);
				break;
			case "/EditarReferido":
				editarReferido(request, response);
				break;
			case "/EliminarReferido":
				eliminarReferido(request, response);
				break;
			}
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void eliminarReferido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		//System.out.println("numdoc: " + numdoc);
		//Referido bean = new Referido();
		int respuesta = 0;
		try {
			ReferidoJDBC dao = new ReferidoJDBC();

			respuesta = dao.eliminarReferido(id) == true ? 1 : 0;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}
	
	
	private void editarReferido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int iddoc = Integer.parseInt(request.getParameter("iddoc"));
		String numdoc = request.getParameter("numdoc");
		System.out.println("numdoc: " + numdoc);
		String nombre = request.getParameter("nombre");
		System.out.println("nombre: " + nombre);
		String apepat = request.getParameter("apepat");
		System.out.println("apepat: " + apepat);
		String apemat = request.getParameter("apemat");
		System.out.println("apemat: " + apemat);
		int edad = Integer.parseInt(request.getParameter("edad"));
		System.out.println("edad: " + edad);
		String correo = request.getParameter("correo");
		System.out.println("correo: " + correo);
		String cod_semestre = request.getParameter("cod_semestre");
		System.out.println("cod_semestre: " + cod_semestre);
		
		Referido bean = new Referido();
		
		bean.setId(iddoc);
		bean.setNumdoc(numdoc);
		bean.setNombre(nombre);
		bean.setApepat(apepat);
		bean.setApemat(apemat);
		bean.setEdad(edad);
		bean.setEmail(correo);
		bean.setCod_semestre(cod_semestre);
	

		int respuesta = 0;

		try {
			ReferidoJDBC dao = new ReferidoJDBC();

			respuesta = dao.modificarReferido(bean) == true ? 1 : 0;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}
	
	private void listarReferidoxDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		StringBuilder sb = new StringBuilder("");
		String numcod = request.getParameter("numdoc");

		try {
			ReferidoJDBC dao = new ReferidoJDBC();
			List<Referido> lista = dao.listarReferidoxDocente(numcod);
			if (lista != null) {
				for (Referido bean : lista) {
					sb.append(bean.getId() + "=" + bean.getCod_docente() + "=" + bean.getNumdoc() + "="
							+ bean.getNombre() + "=" + bean.getApepat() + "=" + bean.getApemat() + "="
							+ bean.getEdad() + "=" +bean.getEmail() + "=" + bean.getCod_semestre() + "$");
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
	
	private void listarReferido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder("");
		try {
			ReferidoJDBC dao = new ReferidoJDBC();
			List<Referido> lista = dao.listarReferido();
			if (lista != null) {
				for (Referido bean : lista) {
					sb.append(bean.getId()+ "=" + bean.getNumdoc() + "="+ bean.getApepat()
					+ "="+bean.getApemat()+"="+ bean.getNombre()+"="+bean.getEmail()+ "$");

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
	
	private void listarReferidoxDocenteSem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		StringBuilder sb = new StringBuilder("");
		String numdoc = request.getParameter("numdoc");
		String sem = request.getParameter("sem");

		try {
			ReferidoJDBC dao = new ReferidoJDBC();
			List<Referido> lista = dao.listarReferidoxDocenteSem(numdoc, sem);
			if (lista != null) {
				for (Referido bean : lista) {
					sb.append(bean.getId() + "=" + bean.getCod_docente() + "=" + bean.getNumdoc() + "="
							+ bean.getNombre() + "=" + bean.getApepat() + "=" + bean.getApemat() + "="
							+ bean.getEdad() + "=" +bean.getEmail() + "=" + bean.getCod_semestre() + "$");
				}
			} else {
				sb.append("null");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	private void buscarReferido(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String numdoc = request.getParameter("numdoc");
		if (numdoc.length() <= 0) {
			numdoc = "empty";
		} else {
			numdoc = request.getParameter("numdoc");
		}
		String respuesta = "";
		try {
			ReferidoJDBC dao = new ReferidoJDBC();
			Referido bean = dao.buscarReferido(numdoc);
			if (bean.getNumdoc()=="") {
				respuesta = "vacio";
			} else {
				respuesta = bean.getId() + "=" + bean.getCod_docente() + "=" + bean.getNumdoc() + "="
						+ bean.getNombre() + "=" + bean.getApepat() + "=" + bean.getApemat() + "="
						+ bean.getEdad() + "=" +bean.getEmail() + "=" + bean.getCod_semestre();
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.getMessage();
		}
		System.out.println("respuesta: " + respuesta);
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}


	
	
	private void registrarReferido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, JSONException {

		String resultado = "0";

		String jsonData = request.getParameter("objetojson");
		JSONObject obj = new JSONObject(jsonData);
		JSONArray arr = obj.getJSONArray("linea");

		try {
			ReferidoJDBC dao = new ReferidoJDBC();
			for (int i = 0; i < arr.length(); i++) {
				Referido bean = new Referido();
				bean.setCod_docente(arr.getJSONObject(i).getString("cod_docente"));
				bean.setNumdoc(arr.getJSONObject(i).getString("numdoc"));
				bean.setNombre(arr.getJSONObject(i).getString("nombre"));
				bean.setApepat(arr.getJSONObject(i).getString("apepat"));
				bean.setApemat(arr.getJSONObject(i).getString("apemat"));
				bean.setEdad(arr.getJSONObject(i).getInt("edad"));
				bean.setEmail(arr.getJSONObject(i).getString("correo"));
				bean.setCod_semestre(arr.getJSONObject(i).getString("cod_semestre"));

				resultado = dao.crearReferido(bean) == true ? "1" : "0";
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(resultado);
	}

	

	

}
