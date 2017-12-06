package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Curso;
import jdbc.CursoJDBC;

@WebServlet("/ServletCurso")
public class ServletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("action");
		String vista = "";
		
		if(accion.equals("agregarCurso")){
			vista = agregarCurso(request);
		}else if(accion.equals("listarCurso")){
			vista = listarCurso(request);
		}else if(accion.equals("preactualizarCurso")){
			vista = preactualizarCurso(request);
		}else if(accion.equals("actualizarCurso")){
			vista = actualizarCurso(request);
		}else if(accion.equals("actualizarCursoEstado")){
			vista = actualizarCursoEstado(request);
		}else if(accion.equals("eli")){
			//vista = eliminarEditorial(request);
		}else if(accion.equals("AgregarCurso")){
			vista = AgregarCurso(request);
		}
		
		getServletContext().getRequestDispatcher(vista).forward(request, response);
	}
/*
	private String eliminarEditorial(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String[] id = request.getParameterValues("eliminar");
		
		EditorialJDBC dao = new EditorialJDBC();
		
		for(int i=0; i<id.length; i++){
			dao.eliminarEditorial(id[i]);
		}
		return "/listarEditorial";
	}
*/

	private String actualizarCurso(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		double cre =Double.parseDouble(request.getParameter("creditoCurso"));
		
		
		if (cre==(int)cre){
		Curso bean = new Curso();
		bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setIdCurso(request.getParameter("codigoSAP"));
		bean.setNombre(request.getParameter("nombreCurso"));
		bean.setSicat(request.getParameter("sicat"));
		
		bean.setHoraTeoria(Integer.parseInt(request.getParameter("horateoriaCurso")));
		bean.setHoraPractica(Integer.parseInt(request.getParameter("horapracticaCurso")));
		bean.setHoraLaboratorio(Integer.parseInt(request.getParameter("horalaboratorioCurso")));
		
		bean.setCredito(Integer.parseInt(request.getParameter("creditoCurso")));
		bean.setNombrePropietario(request.getParameter("propietarioCurso"));
		
		bean.setRequisito01(request.getParameter("requisitoCurso01"));
		bean.setRequisito02(request.getParameter("requisitoCurso02"));
		bean.setRequisito03(request.getParameter("requisitoCurso03"));
		bean.setCorequisito(request.getParameter("corequisitoCurso"));
		bean.setCreditoRequisito(request.getParameter("requisitocreditoCurso"));
		
		bean.setUserMod(sesion.getAttribute("username").toString());
		System.out.println(sesion.getAttribute("username").toString());
		CursoJDBC dao = new CursoJDBC();
		dao.actualizarCurso(bean);
		
		return "/ServletCurso?action=listarCurso";}else{
			request.setAttribute("message", "<strong>¡Advertencia!</strong>  <p>El curso que desea modificar no es entero, vuelva a ingresarlo.</p>");
			return "/ServletCurso?action=preactualizarCurso&index_curso="+request.getParameter("id")+"";	
			}
	}

	private String actualizarCursoEstado(HttpServletRequest request) {
		// TODO Auto-generated method stub
						
		int estado=Integer.parseInt(request.getParameter("estadoCurso"));
		String id=request.getParameter("id");
		
		
		CursoJDBC dao = new CursoJDBC();
		dao.actualizarEstadoCurso(estado,id);
		
		return "/ServletCurso?action=listarCurso";
	}

	private String preactualizarCurso(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("index_curso");
		
		CursoJDBC dao = new CursoJDBC();
		Curso bean = dao.listarCursoporid(id);
		
		request.setAttribute("curso", bean);
		List<Curso> lista = dao.listarCurso();
		request.setAttribute("lista", lista);
		return "/Planes/Curso/actualizarCurso.jsp";
	}

	private String listarCurso(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		try{
			CursoJDBC dao = new CursoJDBC();
			List<Curso> lista = dao.listarCurso();
			request.setAttribute("lista", lista);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "/Planes/Curso/curso.jsp";
	}
	private String AgregarCurso(HttpServletRequest request) {
		// TODO Auto-generated method stub
			try{
				CursoJDBC dao = new CursoJDBC();
				List<Curso> lista = dao.listarCurso();
				request.setAttribute("lista", lista);
			}catch(Exception e){
				e.printStackTrace();
			}	
			
			return "/Planes/Curso/agregarCurso.jsp";
	}
	private String agregarCurso(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		
		double cre =Double.parseDouble(request.getParameter("creditoCurso"));
	    if (cre==(int)cre){
	    	Curso bean = new Curso();
			bean.setIdCurso(request.getParameter("codigoSAP"));
			bean.setNombre(request.getParameter("nombreCurso"));
			bean.setSicat(request.getParameter("sicat"));
			
			bean.setHoraTeoria(Integer.parseInt(request.getParameter("horateoriaCurso")));
			bean.setHoraPractica(Integer.parseInt(request.getParameter("horapracticaCurso")));
			bean.setHoraLaboratorio(Integer.parseInt(request.getParameter("horalaboratorioCurso")));
			bean.setCredito(Integer.parseInt(request.getParameter("creditoCurso")));
			bean.setNombrePropietario(request.getParameter("propietarioCurso"));
			bean.setRequisito01(request.getParameter("requisitoCurso01"));
			bean.setRequisito02(request.getParameter("requisitoCurso02"));
			bean.setRequisito03(request.getParameter("requisitoCurso03"));
			bean.setCorequisito(request.getParameter("corequisitoCurso"));
			bean.setCreditoRequisito(request.getParameter("requisitocreditoCurso"));
			bean.setUserMod(sesion.getAttribute("username").toString());
			
			CursoJDBC dao = new CursoJDBC();
			dao.agregarCurso(bean);
			
			return "/ServletCurso?action=listarCurso";
	    }else{
	    	request.setAttribute("message", "<strong>¡Advertencia!</strong>  <p>El curso que desea crear no es entero, vuelva a ingresarlo.</p>");
			return "/ServletCurso?action=AgregarCurso";	
	    }
			
			
			
		
		
	}
}
