package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.LoginJDBC;
import beans.Usuario;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("passve");
		//String contraseña = request.getParameter("contrasena");

		LoginJDBC dao = new LoginJDBC();
		Usuario bean = new Usuario();
        
		bean = dao.validarUsuario(usuario, contraseña);

		String username = "";
		String idUser = "";
		String dni = "";
		int perfil = -1;
		int escuela = -1;
		
		username = bean.getNombre();
		idUser = bean.getIdUsuario();
		perfil = bean.getPerfil();
        dni = bean.getNombreUsu();
		escuela = bean.getEscuela();
		
		System.out.println("escuela : " + escuela);
		
		if (bean.getPerfil() == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("profile", "Administrador");
			session.setAttribute("idSchool", ""+escuela);
			session.setAttribute("idUser", idUser);
			session.setAttribute("perfil", perfil);
			session.setAttribute("dni",dni);

			
			response.sendRedirect("index.jsp");
		}
		if (bean.getPerfil() == 2) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("profile", "Director");
			session.setAttribute("idSchool", escuela);
			session.setAttribute("idUser", idUser);
			session.setAttribute("perfil", perfil);
			session.setAttribute("dni",dni);

			
			response.sendRedirect("index.jsp");
		}
		if (bean.getPerfil() == 3) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("profile", "Docente");
			session.setAttribute("idSchool", escuela);
			session.setAttribute("idUser", idUser);
			session.setAttribute("perfil", perfil);
			session.setAttribute("dni",dni);

			
			response.sendRedirect("index.jsp");
		}
		if (bean.getPerfil() == 4) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("profile", "Escalafón");
			session.setAttribute("idSchool", escuela);
			session.setAttribute("idUser", idUser);
			session.setAttribute("perfil", perfil);
			session.setAttribute("dni",dni);

			
			response.sendRedirect("index.jsp");
		}
		if (bean.getPerfil() == 5) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("profile", "Acreedor");
			session.setAttribute("idSchool", escuela);
			session.setAttribute("idUser", idUser);
			session.setAttribute("perfil", perfil);
			session.setAttribute("dni",dni);


			response.sendRedirect("index.jsp");
		} 
		if (bean.getPerfil() == 6) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("profile", "Coordinador");
			session.setAttribute("idSchool", escuela);
			session.setAttribute("idUser", idUser);
			session.setAttribute("perfil", perfil);
			session.setAttribute("dni",dni);


			response.sendRedirect("index.jsp");
		} 
		if (bean.getPerfil() == 7) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("profile", "Departamento");
			session.setAttribute("idSchool", escuela);
			session.setAttribute("idUser", idUser);
			session.setAttribute("perfil", perfil);
			session.setAttribute("dni",dni);


			response.sendRedirect("index.jsp");
		} 
		else {
			request.setAttribute("message", "Credenciales Invalidas");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		
	}
}
