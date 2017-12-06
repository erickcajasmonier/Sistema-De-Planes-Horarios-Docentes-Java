package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.SemestreJDBC;
import beans.Semestre;

@WebServlet("/ServletSemestre")
public class ServletSemestre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("action");
		String vista = "";
		
		if(accion.equals("agregarSemestre")){
			vista = agregarSemestre(request);
		}else if(accion.equals("listarSemestre")){
			vista = listarSemestre(request);
		}else if(accion.equals("preagregarSemestre")){
			vista = preagregarSemestre(request);
		}else if(accion.equals("actualizarSemestre")){
			vista = actualizarSemestre(request);
		}else if(accion.equals("preactualizarSemestre")){
			vista = preactualizarSemestre(request);
		}else if(accion.equals("eliminarSemestre")){
			vista = eliminarSemestre(request);
		}
		
		getServletContext().getRequestDispatcher(vista).forward(request, response);
	}

	private String eliminarSemestre(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int idSemestre=Integer.parseInt(request.getParameter("idSemestre"));
		
		SemestreJDBC dao = new SemestreJDBC();		
		int result=dao.eliminarSemestre(idSemestre);
		
		if(result==1){
			request.setAttribute("message", "El semestre se eliminó correctamente");
		}else{
			request.setAttribute("message", "No se pudo eliminar el semestre. Revise que el semestre que desea eliminar no este asociado a un plan curricular.");
		}
		
		return "/ServletSemestre?action=listarSemestre";
	}

	private String actualizarSemestre(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int idSemestre=Integer.parseInt(request.getParameter("idSemestre"));
		int creditoEspecialidad=Integer.parseInt(request.getParameter("creditoEspecialidad"));
		int creditoGeneral=Integer.parseInt(request.getParameter("creditoGeneral"));
		
		if(creditoEspecialidad<165 || creditoGeneral<35){
			request.setAttribute("war_message", "<strong>¡Atención!</strong>El semestre que desea actualizar tiene menos de 165 créditos de cursos de especialidad y/o menos de 35 créditos de cursos generales. Intente nuevamente.");
			
			return "/ServletSemestre?action=preactualizarSemestre&idSemestre="+idSemestre+"";			
		}else{
			Semestre bean = new Semestre();
			bean.setIdSemestre(Integer.parseInt(request.getParameter("idSemestre")));
			bean.setAño(Integer.parseInt(request.getParameter("año")));
			bean.setSemestre(Integer.parseInt(request.getParameter("semestre")));
			bean.setCantidadSemana(Integer.parseInt(request.getParameter("cantidadSemana")));
			bean.setCred_especialidad(Integer.parseInt(request.getParameter("creditoEspecialidad")));
			bean.setCred_general(Integer.parseInt(request.getParameter("creditoGeneral")));
			SemestreJDBC dao = new SemestreJDBC();
			int result=dao.actualizarSemestre(bean);			
			if(result==1){
				request.setAttribute("message", "El semestre se actualizó correctamente");
			}			
			return "/ServletSemestre?action=listarSemestre";
		}	
	}

	private String preactualizarSemestre(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int idSemestre=Integer.parseInt(request.getParameter("idSemestre"));
		
		SemestreJDBC dao = new SemestreJDBC();		
		Semestre lista = dao.preactualizarSemestre(idSemestre);
		
		request.setAttribute("lista", lista);
		
		return "/Planes/Semestre/actualizarSemestre.jsp";
	}

	private String preagregarSemestre(HttpServletRequest request) {
		// TODO Auto-generated method stub
		SemestreJDBC dao = new SemestreJDBC();
		Semestre bean = dao.preagregarSemestre();
		
		if(bean.getSemestre()==0){
			request.setAttribute("idSemestre",bean.getIdSemestre()+1);
			request.setAttribute("año",bean.getAño());
			request.setAttribute("semestre","1");
			request.setAttribute("cantidadSemana","16");
			request.setAttribute("creditoEspecialidad","165");
			request.setAttribute("creditoGeneral","35");
		}else if(bean.getSemestre()==1){
			request.setAttribute("idSemestre",bean.getIdSemestre()+1);
			request.setAttribute("año",bean.getAño());
			request.setAttribute("semestre","2");
			request.setAttribute("cantidadSemana","16");
			request.setAttribute("creditoEspecialidad","165");
			request.setAttribute("creditoGeneral","35");
		}else if(bean.getSemestre()==2){
			request.setAttribute("idSemestre",bean.getIdSemestre()+1);
			request.setAttribute("año",bean.getAño()+1);
			request.setAttribute("semestre","0");
			request.setAttribute("cantidadSemana","4");
			request.setAttribute("creditoEspecialidad","0");
			request.setAttribute("creditoGeneral","0");
		}		
		return "/Planes/Semestre/agregarSemestre.jsp";
	}

	private String listarSemestre(HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			SemestreJDBC dao = new SemestreJDBC();
			List<Semestre> lista = dao.listarSemestre();
			request.setAttribute("lista", lista);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return "/Planes/Semestre/semestre.jsp";
	}

	private String agregarSemestre(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int creditoEspecialidad=Integer.parseInt(request.getParameter("creditoEspecialidad"));
		int creditoGeneral=Integer.parseInt(request.getParameter("creditoGeneral"));
		
		if(creditoEspecialidad<165 || creditoGeneral<35){
			request.setAttribute("war_message", "<strong>¡Atención!</strong>El semestre que desea crear tiene menos de 165 créditos de cursos de especialidad y/o menos de 35 créditos de cursos generales. Intente nuevamente.");
			return "/ServletSemestre?action=preagregarSemestre";			
		}else{
			Semestre bean = new Semestre();
			bean.setIdSemestre(Integer.parseInt(request.getParameter("idSemestre")));
			bean.setAño(Integer.parseInt(request.getParameter("año")));
			bean.setSemestre(Integer.parseInt(request.getParameter("semestre")));
			bean.setCantidadSemana(Integer.parseInt(request.getParameter("cantidadSemana")));
			bean.setCred_especialidad(Integer.parseInt(request.getParameter("creditoEspecialidad")));
			bean.setCred_general(Integer.parseInt(request.getParameter("creditoGeneral")));
			SemestreJDBC dao = new SemestreJDBC();
			
			int result=dao.agregarSemestre(bean);
			
			if(result==1){
				request.setAttribute("message", "El semestre se agregó correctamente");
			}else{
				request.setAttribute("message", "No se pudo agregar el semestre. Si el problema persiste, consulte con el personal de sistemas.");
			}
			return "/ServletSemestre?action=listarSemestre";
		}		
	}

}
