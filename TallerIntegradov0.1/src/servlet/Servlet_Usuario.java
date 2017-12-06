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
import beans.Usuario;
import jdbc.PerfilesJDBC;
import jdbc.UsuarioJDBC;

@WebServlet({"/RegistrarUsuario","/BuscarUsuario","/EditarUsuario","/EliminarUsuario", "/ListarPerfiles","/ModificarContraseña","/VerificarUsuario","/CambiarContraseña"})
public class Servlet_Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			switch (request.getServletPath()) {
			case "/RegistrarUsuario":
				registrarUsuario(request, response);
				break;
			case "/BuscarUsuario":
				buscarUsuario(request, response);
				break;
			case "/EditarUsuario":
				editarUsuario(request, response);
				break;
			case "/EliminarUsuario":
				eliminarUsuario(request, response);
				break;
			case "/ModificarContraseña":
				modificarContraseña(request, response);
				break;	
			case "/ListarPerfiles":
				listarPerfiles(request, response);
				break;
			case "/VerificarUsuario":
				verificarUsuario(request, response);
				break;
			case "/CambiarContraseña":
				cambiarContraseña(request, response);

		   } 
		}  catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			e.printStackTrace();
		}

	}
	private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, JSONException {

		boolean flag = false;
		boolean flag1 = false;
		String respuesta = "0";
		String respuesta1 = "0";

		String jsonData = request.getParameter("objetojson");
		JSONObject obj = new JSONObject(jsonData);
		JSONArray arr = obj.getJSONArray("linea");

		String idusuario = "", nombreUsu = "", Password = "", nombre = "", ape_Pat = "", ape_Mat = "", correoE = "", escuela="", usu_crea_reg="";
	    int perfil = 0;
		Usuario bean = new Usuario();

		try {
			UsuarioJDBC dao = new UsuarioJDBC();
			for (int i = 0; i < arr.length(); i++) {
				idusuario = arr.getJSONObject(i).getString("txtusuario");
				nombreUsu = arr.getJSONObject(i).getString("txtdni");
				Password = arr.getJSONObject(i).getString("txtcontra");
				nombre = arr.getJSONObject(i).getString("txtnombre");
				ape_Pat = arr.getJSONObject(i).getString("txtapepat");
				ape_Mat = arr.getJSONObject(i).getString("txtapemat");
				correoE = arr.getJSONObject(i).getString("txtcorreo");
				perfil = Integer.parseInt(arr.getJSONObject(i).getString("txtperfil"));
				escuela = arr.getJSONObject(i).getString("txtescuela");
				usu_crea_reg = arr.getJSONObject(i).getString("txtusucreareg");
			 

				bean.setIdUsuario(idusuario);;
				bean.setNombreUsu(nombreUsu);
				bean.setPassword(Password);
				bean.setNombre(nombre);
				bean.setApe_Pat(ape_Pat);
				bean.setApe_Mat(ape_Mat);
				bean.setCorreo(correoE);
				bean.setPerfil(perfil);
				bean.setUsu_crea_reg(usu_crea_reg);

				flag = dao.registrarUsuario(bean);
				flag1 = dao.registrarDetalleUsuario(idusuario, escuela, perfil);
				
			}

			respuesta = flag == true ?   "1" : "0";
			respuesta1 = flag1 == true ? "1" : "0";
			
			System.out.println("respuesta: " + respuesta);
			System.out.println("respuesta: " + respuesta1);
			response.setContentType("text/plain");
			response.getWriter().write(respuesta);

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	private void buscarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombreUsu = request.getParameter("nombreUsu");
		if (nombreUsu.length() <= 0) {
			nombreUsu = "empty";
		} else {
			nombreUsu = request.getParameter("nombreUsu");
		}
		String respuesta = "";
		try {
			UsuarioJDBC dao = new UsuarioJDBC();
			Usuario bean = dao.buscarUsuario(nombreUsu);
			if (bean.getNombreUsu()== null) {
				respuesta = "vacio";
			} else {
				respuesta = bean.getIdUsuario() + " -|" + bean.getNombreUsu() + " -|" + bean.getPassword() + " -|"
						+ bean.getNombre() + " -|" + bean.getApe_Pat() + "-|" + bean.getApe_Mat() + "-|"
						+ bean.getCorreo() + "-|" + bean.getPerfil();
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.getMessage();
		}
		System.out.println("respuesta: " + respuesta);
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}
	
	private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idusuario = request.getParameter("idusuario");
		System.out.println("idusuario: " + idusuario);
		String nombreUsu = request.getParameter("nombreUsu");
		System.out.println("nombreUsu: " + nombreUsu);
		String Password = request.getParameter("Password");
		System.out.println("Password: " + Password);
		String nombre = request.getParameter("nombre");
		System.out.println("nombre: " + nombre);
		String ape_Pat = request.getParameter("ape_Pat");
		System.out.println("ape_Pat: " + ape_Pat);
		String ape_Mat = request.getParameter("ape_Mat");
		System.out.println("ape_Mat: " + ape_Mat);
		String correoE = request.getParameter("correoE");
		System.out.println("correoE: " + correoE);
		int perfil = Integer.parseInt(request.getParameter("perfil"));
		System.out.println("perfil: " + perfil);
		
		Usuario bean = new Usuario();

		bean.setIdUsuario(idusuario);
		bean.setNombreUsu(nombreUsu);
		bean.setPassword(Password);
		bean.setNombre(nombre);
		bean.setApe_Pat(ape_Pat);
		bean.setApe_Mat(ape_Mat);
		bean.setCorreo(correoE);
		bean.setPerfil(perfil);
	

		int respuesta = 0;

		try {
			UsuarioJDBC dao = new UsuarioJDBC();

			respuesta = dao.modificarUsuario(bean) == true ? 1 : 0;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}
	
	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombreUsu = request.getParameter("nombreUsu");
		System.out.println("nombreUsu: " + nombreUsu);
		Usuario bean = new Usuario();
		
		int respuesta = 0;

		try {
			UsuarioJDBC dao = new UsuarioJDBC();

			respuesta = dao.eliminarUsuario(nombreUsu) == true ? 1 : 0;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}
    
	private void modificarContraseña(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombreUsu = request.getParameter("nombreUsu");
		System.out.println("nombreUsu: " + nombreUsu);
		String Password = request.getParameter("Password");
		System.out.println("Password: " + Password);
	
		Usuario bean = new Usuario();
        
		bean.setNombreUsu(nombreUsu);
		bean.setPassword(Password);

		int respuesta = 0;

		try {
			UsuarioJDBC dao = new UsuarioJDBC();

			respuesta = dao.modificarContraseña(bean) == true ? 1 : 0;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}
	
	private void listarPerfiles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Perfil> lista = new ArrayList<Perfil>();
		StringBuilder sb = new StringBuilder("");

		try {
			PerfilesJDBC dao = new PerfilesJDBC();
			lista = dao.listarPerfiles();

			for (Perfil bean : lista) {
				sb.append(bean.getIdperfil() + "/" + bean.getNombre() + ":");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());

	}
	
	private void verificarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idusuario = request.getParameter("idusuario");
		String password  = request.getParameter("password"); 
		if (idusuario.length() <= 0) {
			idusuario = "empty";
		} else {
			idusuario = request.getParameter("idusuario");
		}
		if (password.length() <= 0) {
			password = "empty";
		} else {
			password = request.getParameter("password");
		}
		String respuesta = "";
		try {
			UsuarioJDBC dao = new UsuarioJDBC();
			Usuario bean = dao.verificar(idusuario, password);
			if (bean.getIdUsuario()==null) {
				respuesta = "vacio";
			} else {
				respuesta = bean.getIdUsuario() + " -|" + bean.getNombreUsu() + " -|" + bean.getPassword() + " -|"
						+ bean.getNombre() + " -|" + bean.getApe_Pat() + "-|" + bean.getApe_Mat() + "-|"
						+ bean.getCorreo() + "-|" + bean.getPerfil();
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.getMessage();
		}
		System.out.println("respuesta: " + respuesta);
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}
	
	private void cambiarContraseña(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idusuario = request.getParameter("idusuario");
		System.out.println("nombreUsu: " + idusuario);
		String Password = request.getParameter("Password");
		System.out.println("Password: " + Password);
	
		Usuario bean = new Usuario();
        
		bean.setIdUsuario(idusuario);
		bean.setPassword(Password);

		int respuesta = 0;

		try {
			UsuarioJDBC dao = new UsuarioJDBC();

			respuesta = dao.cambiarContraseña(bean) == true ? 1 : 0;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}
	

}
