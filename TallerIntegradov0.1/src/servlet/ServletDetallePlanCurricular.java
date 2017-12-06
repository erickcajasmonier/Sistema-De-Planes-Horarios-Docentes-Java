package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.CursoJDBC;
import jdbc.DetallePlanCurricularJDBC;
import jdbc.PlanCurricularJDBC;
import jdbc.SemestreJDBC;
import beans.Curso;
import beans.DetallePlanCurricular;
import beans.PlanCurricular;
import beans.Semestre;

@WebServlet("/ServletDetallePlanCurricular")
public class ServletDetallePlanCurricular extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("action");
		String vista = "";
		
		if(accion.equals("agregarCursoDetallePlanCurricular")){
			vista = agregarCursoDetallePlanCurricular(request);
		}else if(accion.equals("listarDetallePlanCurricular")){
			vista = listarDetallePlanCurricular(request);
		}else if(accion.equals("listarDetallePlanCurricularCiclo")){
			vista = listarDetallePlanCurricularCiclo(request);
		}else if(accion.equals("actualizarCursoDetallePlanCurricular")){
			vista = actualizarCursoDetallePlanCurricular(request);
		}else if(accion.equals("actualizarDetallePlanCurricularEstado")){
			vista = actualizarDetallePlanCurricularEstado(request);
		}else if(accion.equals("preactualizarCursoDetallePlanCurricular")){
			vista = preactualizarCursoDetallePlanCurricular(request);
		}
		
		getServletContext().getRequestDispatcher(vista).forward(request, response);
	}
	private String preactualizarCursoDetallePlanCurricular(
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		String idCurso=request.getParameter("idCurso");
		int idPlan=Integer.parseInt(request.getParameter("idPlan"));
		int idSemestre=Integer.parseInt(request.getParameter("idSemestre"));
		DetallePlanCurricularJDBC dao = new DetallePlanCurricularJDBC();		
		DetallePlanCurricular lista = dao.preactualizarCursoDetallePlanCurricular(idPlan,idSemestre,idCurso);
		
		SemestreJDBC DAO = new SemestreJDBC();
		Semestre s = DAO.preactualizarSemestre(idSemestre);
		
		int añoSemestre=s.getAño();
		int semestre=s.getSemestre();
		
		request.setAttribute("lista", lista);
		request.setAttribute("añoSemestre",añoSemestre);
		request.setAttribute("semestre",semestre);
		
		return "/Planes/PlanCurricular/actualizarCursoPlanCurricular.jsp";
	}

	private String agregarCursoDetallePlanCurricular(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int idPlan=Integer.parseInt(request.getParameter("idPlan"));
		int idEscuela=Integer.parseInt(request.getParameter("idEscuela"));
		int ciclo=Integer.parseInt(request.getParameter("ciclo"));
		int idSemestre=Integer.parseInt(request.getParameter("idSemestre"));
		String idCurso=request.getParameter("idCurso");
		
		DetallePlanCurricularJDBC dao = new DetallePlanCurricularJDBC();
		dao.agregarDetallePlanCurricularCurso(idPlan, idSemestre, idEscuela, ciclo, idCurso);
		
		return "/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&ciclo="+ciclo+"&idPlan="+idPlan+"&idEscuela="+idEscuela+"";
		
	}

	private String actualizarCursoDetallePlanCurricular(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		int idPlan=Integer.parseInt(request.getParameter("idPlan"));
		int idEscuela=Integer.parseInt(request.getParameter("idEscuela"));
		int ciclo=Integer.parseInt(request.getParameter("ciclo"));
		String idUsuario=request.getParameter("idUsuario");
		
		DetallePlanCurricular bean = new DetallePlanCurricular();
		bean.setIdPlan(Integer.parseInt(request.getParameter("idPlan")));
		bean.setCodDce_sem(Integer.parseInt(request.getParameter("idSemestre")));
		bean.setCodDce_curso(request.getParameter("idCurso"));
		bean.setCat_fia(request.getParameter("categoriaFIA"));
		bean.setTipo_fia(request.getParameter("tipoFIA"));
		bean.setTipo_sunedu(request.getParameter("tipoSUNEDU"));
		bean.setTipo_pres_virt(request.getParameter("modalidad"));
		
		DetallePlanCurricularJDBC dao = new DetallePlanCurricularJDBC();
		dao.actualizarCursoDetallePlanCurricular(bean);
		
		return "/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan="+idPlan+"&idEscuela="+idEscuela+"&ciclo="+ciclo+"&idUsuario="+idUsuario+"";
		
	}

	private String listarDetallePlanCurricularCiclo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int ciclo=Integer.parseInt(request.getParameter("ciclo"));
		int idPlan=Integer.parseInt(request.getParameter("idPlan"));
		int idEscuela=Integer.parseInt(request.getParameter("idEscuela"));
		int idSemestre=Integer.parseInt(request.getParameter("idSemestre"));
		
			try{
				DetallePlanCurricularJDBC dao = new DetallePlanCurricularJDBC();
				List<DetallePlanCurricular> cicloLista = dao.listarDetallePlanCurricularCiclo(idPlan,idEscuela,ciclo);
				request.setAttribute("cicloLista", cicloLista);
			}catch(Exception e){
				e.printStackTrace();
			}

		HttpSession session=request.getSession(); 
		DetallePlanCurricularJDBC dao = new DetallePlanCurricularJDBC();
		
		int sumaCredito=dao.validarSumaCredito(idPlan,idEscuela);
		int sumaCreditoCiclo=dao.validarSumaCreditoCiclo(ciclo,idPlan,idEscuela);		
		int sumaCreditoCursoEspecialidad=dao.validarSumaCreditoCursoEspecialidad(idPlan,idEscuela);
		
		int creditoCiclo=dao.validarCreditoCiclo(ciclo,idPlan,idSemestre);
		
		session.setAttribute("sumaCredito", sumaCredito);
		session.setAttribute("sumaCreditoCiclo", sumaCreditoCiclo);
		session.setAttribute("sumaCreditoCursoEspecialidad", sumaCreditoCursoEspecialidad);
		
		session.setAttribute("creditoCiclo", creditoCiclo);
		
		return "/ServletDetallePlanCurricular?action=listarDetallePlanCurricular&idPlan="+idPlan+"&idEscuela="+idEscuela+"";
	}
	
	private String actualizarDetallePlanCurricularEstado(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int estadoCursoPlan=Integer.parseInt(request.getParameter("estadoCursoPlan"));
		String idCurso=request.getParameter("idCurso");
		int ciclo=Integer.parseInt(request.getParameter("ciclo"));
		
		int idPlan=Integer.parseInt(request.getParameter("idPlan"));
		int idEscuela=Integer.parseInt(request.getParameter("idEscuela"));
		
		DetallePlanCurricularJDBC dao = new DetallePlanCurricularJDBC();
		dao.actualizarDetallePlanCurricularEstado(estadoCursoPlan,idCurso,ciclo,idPlan);
		
		return "/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&ciclo="+ciclo+"&idPlan="+idPlan+"&idEscuela="+idEscuela+"";
	}

	private String listarDetallePlanCurricular(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int idPlan = Integer.parseInt(request.getParameter("idPlan"));
		int idSemestre=Integer.parseInt(request.getParameter("idSemestre"));
		int idEscuela=Integer.parseInt(request.getParameter("idEscuela"));
		String escuela="";
		String idUsuario = request.getParameter("idUsuario");
		if(idEscuela==101){
			escuela="INGENIERÍA DE COMPUTACIÓN Y SISTEMAS";
		}else if(idEscuela==202){
			escuela="INGENIERÍA INDUSTRIAL";
		}else if(idEscuela==303){
			escuela="ARQUITECTURA";
		}else if(idEscuela==404){
			escuela="INGENIERÍA CIVIL";
		}else if(idEscuela==505){
			escuela="INGENIERÍA ELECTRÓNICA";
		}else if(idEscuela==606){
			escuela="INGENIERÍA EN INDUSTRIAS ALIMENTARIAS";
		}else if(idEscuela==707){
			escuela="CIENCIAS AERONÁUTICAS";
		}
		//Del ServletSemestre
		SemestreJDBC DAO = new SemestreJDBC();		
		Semestre s = DAO.preactualizarSemestre(idSemestre);
		int añoSemestre=s.getAño();
		int semestre=s.getSemestre();
		
		HttpSession session=request.getSession();  
		session.setAttribute("idPlan", idPlan);
		session.setAttribute("idSemester", idSemestre);
		session.setAttribute("idSchool", idEscuela);
		session.setAttribute("school", escuela);
		session.setAttribute("idUser",idUsuario);
		session.setAttribute("yearSemester", añoSemestre);
		session.setAttribute("semester", semestre);
		
		//Del ServletCurso
		try{
			CursoJDBC dao = new CursoJDBC();
			List<Curso> cursoDisponible = dao.listarCursoDisponible(idEscuela,idPlan);
			request.setAttribute("cursoDisponible", cursoDisponible);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			DetallePlanCurricularJDBC dao = new DetallePlanCurricularJDBC();
			List<DetallePlanCurricular> cursoPlan = dao.listarDetallePlanCurricular(idPlan,idEscuela);
			request.setAttribute("cursoPlan", cursoPlan);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "/Planes/PlanCurricular/actualizarPlanCurricular.jsp";
	}


}
