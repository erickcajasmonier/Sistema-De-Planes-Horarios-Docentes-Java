package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Curso;
import beans.Det_Curso_Esc;
import beans.Escuela;
import beans.Semestre;
import jdbc.Det_Curso_EscuelaJDBC;
import jdbc.EscuelaJDBC;
import jdbc.SemestreJDBC;

@WebServlet({ "/ListarEscuelas", "/ListarSemestres", "/ListarCiclos", "/ListarCursos", "/ListarCur",
	"/ListarPropietario", "/Listarcursoxpropietario" })
public class Servlet_Escuela extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			switch (request.getServletPath()) {
			case "/ListarEscuelas":
				listarEscuelas(request, response);
				break;
			case "/ListarSemestres":
				listarSemestres(request, response);
				break;
			case "/ListarCiclos":
				listarCiclos(request, response);
				break;
			case "/ListarCursos":
				listarCursos(request, response);
				break;
			case "/ListarCur":
				listarCur(request, response);
				break;
			case "/ListarPropietario":
				listarPropietario(request, response);
				break;
			case "/Listarcursoxpropietario":
				listarcursoxpropietario(request, response);
				break;
			}
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			e.printStackTrace();
		}
	}

	private void listarSemestres(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Semestre> lista = new ArrayList<Semestre>();
		StringBuilder sb = new StringBuilder("");

		try {
			SemestreJDBC dao = new SemestreJDBC();
			lista = dao.listarSemestre();

			for (Semestre bean : lista) {
				sb.append(bean.getIdSemestre() + "/" + bean.getAño() + "/" + bean.getSemestre() + ":");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());

	}

	private void listarEscuelas(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Escuela> lista = new ArrayList<Escuela>();
		StringBuilder sb = new StringBuilder("");

		try {
			EscuelaJDBC dao = new EscuelaJDBC();
			lista = dao.listarEscuelas();

			for (Escuela bean : lista) {
				sb.append(bean.getIdescuela() + "-" + bean.getDescripcion() + ":");
				System.out.println(bean.getIdescuela() + "-" + bean.getDescripcion() + ":");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}

	private void listarcursoxpropietario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prop = request.getParameter("prop");

		List<Curso> lista = new ArrayList<Curso>();
		StringBuilder sb = new StringBuilder("");

		try {
			Det_Curso_EscuelaJDBC dao = new Det_Curso_EscuelaJDBC();
			// lista = dao.listarCur(id_escuela);
			lista = dao.cursoxpropietario(prop);

			for (Curso bean : lista) {
				sb.append(bean.getIdCurso() + "=" + bean.getNombre() + "$");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	private void listarCur(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id_escuela = request.getParameter("idescuela");

		List<Curso> lista = new ArrayList<Curso>();
		StringBuilder sb = new StringBuilder("");

		try {
			Det_Curso_EscuelaJDBC dao = new Det_Curso_EscuelaJDBC();
			// lista = dao.listarCur(id_escuela);
			lista = dao.cursoxescuela(id_escuela);

			for (Curso bean : lista) {
				sb.append(bean.getIdCurso() + "-" + bean.getNombre() + ":");
				System.out.println(bean.getIdCurso() + "-" + bean.getNombre() + ":");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	private void listarPropietario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Curso> lista = new ArrayList<Curso>();
		StringBuilder sb = new StringBuilder("");

		try {
			Det_Curso_EscuelaJDBC dao = new Det_Curso_EscuelaJDBC();
			lista = dao.listarPropietario();

			for (Curso bean : lista) {
				sb.append(bean.getNombrePropietario() + "$");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}

	private void listarCiclos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Det_Curso_Esc> lista = new ArrayList<Det_Curso_Esc>();
		StringBuilder sb = new StringBuilder("");

		try {
			Det_Curso_EscuelaJDBC dao = new Det_Curso_EscuelaJDBC();
			lista = dao.listarciclos();

			for (Det_Curso_Esc bean : lista) {
				sb.append(bean.getCiclo() + "-" + bean.getCiclo() + ":");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());

	}

	private void listarCursos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id_escuela = request.getParameter("idescuela");
		int ciclo = Integer.parseInt(request.getParameter("idciclo"));

		List<Curso> lista = new ArrayList<Curso>();
		StringBuilder sb = new StringBuilder("");

		try {
			Det_Curso_EscuelaJDBC dao = new Det_Curso_EscuelaJDBC();
			lista = dao.cursoxescuelaxciclo(id_escuela, ciclo);

			for (Curso bean : lista) {
				sb.append(bean.getIdCurso() + "-" + bean.getNombre() + ":");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());

	}

}
