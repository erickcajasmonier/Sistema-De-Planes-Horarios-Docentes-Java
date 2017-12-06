package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.PlanCurricularJDBC;
import jdbc.SemestreJDBC;
import beans.PlanCurricular;
import beans.Semestre;

@WebServlet("/ServletPlanCurricular")
public class ServletPlanCurricular extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("action");
		String vista = "";
		
		if(accion.equals("agregarPlanCurricular")){
			vista = agregarPlanCurricular(request);
		}else if(accion.equals("listarPlanCurricular")){
			vista = listarPlanCurricular(request);
		}else if(accion.equals("actualizarPlanCurricularEstado")){
			vista = actualizarPlanCurricularEstado(request);
		}else if(accion.equals("preagregarPlanCurricular")){
			vista = preagregarPlanCurricular(request);
		}else if(accion.equals("actualizarPlanCurricular")){
			//vista = actualizarPlanCurricular(request);
		}else if(accion.equals("eliminarPlanCurricular")){
			vista = eliminarPlanCurricular(request);
		}
		
		getServletContext().getRequestDispatcher(vista).forward(request, response);
	}

	private String eliminarPlanCurricular(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int idPlan=Integer.parseInt(request.getParameter("idPlan"));
		int idEscuela=Integer.parseInt(request.getParameter("idEscuela"));
		String idUsuario=request.getParameter("idUsuario");
		
		PlanCurricularJDBC dao = new PlanCurricularJDBC();		
		dao.eliminarDetallePlanCurricular(idPlan,idEscuela);
		dao.eliminarPlanCurricular(idPlan,idEscuela);
		
		return "/ServletPlanCurricular?action=listarPlanCurricular&idUsuario="+idUsuario+"&idEscuela="+idEscuela+"";
	}

	private String preagregarPlanCurricular(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int idEscuela=Integer.parseInt(request.getParameter("idEscuela"));
		PlanCurricularJDBC dao = new PlanCurricularJDBC();
		PlanCurricular bean = dao.preagregarPlanCurricular(idEscuela);
		String idUsuario=request.getParameter("idUsuario");
		
		//Del ServletSemestre
		SemestreJDBC DAO = new SemestreJDBC();
		Semestre beans = DAO.preagregarSemestre();
			
		Semestre s = DAO.preactualizarSemestre(bean.getCodPc_sem()+1);
		if(s!=null){
			int añoSemestre=s.getAño();
			int semestre=s.getSemestre();
			
			if(bean.getEstado()==1 && beans.getIdSemestre()>=bean.getCodPc_sem()){			
				request.setAttribute("idPlan",bean.getIdPlan()+1);		
				request.setAttribute("idEscuela",bean.getIdEscuela());
				request.setAttribute("escuela",bean.getDescripcionEscuela());
				request.setAttribute("idSemestre",bean.getCodPc_sem()+1);
				request.setAttribute("añoSemestre",añoSemestre);
				request.setAttribute("semestre",semestre);
				request.setAttribute("idUsuario",bean.getUsu_crea_reg());			
				return "/Planes/PlanCurricular/agregarPlanCurricular.jsp";
			}else{
				request.setAttribute("war_message", "<strong>¡Atención!</strong> Para agregar un nuevo plan curricular es necesario que se cree un nuevo semestre y/o que el plan curricular vigente este aprobado. Revise esos datos e intente nuevamente.");
				return "/ServletPlanCurricular?action=listarPlanCurricular&idUsuario="+idUsuario+"";
			}		
		}else{
			request.setAttribute("war_message", "<strong>¡Atención!</strong> Para agregar un nuevo plan curricular es necesario que se cree un nuevo semestre y/o que el plan curricular vigente este aprobado. Revise esos datos e intente nuevamente.");
			return "/ServletPlanCurricular?action=listarPlanCurricular&idUsuario="+idUsuario+"";
		}
	}

	private String agregarPlanCurricular(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int idEscuela=Integer.parseInt(request.getParameter("idEscuela"));
		
		PlanCurricular bean = new PlanCurricular();
		bean.setIdPlan(Integer.parseInt(request.getParameter("idPlan")));;
		bean.setIdEscuela(Integer.parseInt(request.getParameter("idEscuela")));
		bean.setDescripcionEscuela(request.getParameter("escuela"));
		bean.setCodPc_sem(Integer.parseInt(request.getParameter("idSemestre")));
		
		bean.setPrimerCiclo(Integer.parseInt(request.getParameter("primerCiclo")));
		bean.setSegundoCiclo(Integer.parseInt(request.getParameter("segundoCiclo")));
		bean.setTercerCiclo(Integer.parseInt(request.getParameter("tercerCiclo")));
		bean.setCuartoCiclo(Integer.parseInt(request.getParameter("cuartoCiclo")));
		bean.setQuintoCiclo(Integer.parseInt(request.getParameter("quintoCiclo")));
		bean.setSextoCiclo(Integer.parseInt(request.getParameter("sextoCiclo")));
		bean.setSeptimoCiclo(Integer.parseInt(request.getParameter("septimoCiclo")));
		bean.setOctavoCiclo(Integer.parseInt(request.getParameter("octavoCiclo")));
		bean.setNovenoCiclo(Integer.parseInt(request.getParameter("novenoCiclo")));
		bean.setDecimoCiclo(Integer.parseInt(request.getParameter("decimoCiclo")));
		
		bean.setUsu_crea_reg(request.getParameter("idUsuario"));
		
		PlanCurricularJDBC dao = new PlanCurricularJDBC();
		int result=dao.agregarPlanCurricular(bean);
		if (result!=0){
			int result_detail=dao.agregarDetallePlanCurricular(idEscuela);			
			if(result_detail!=0){
				request.setAttribute("message", "El plan curricular se agregó correctamente");
			}else{
				request.setAttribute("message", "No se pudo agregar los cursos al plan curricular. Si el problema persiste, consulte con el personal de sistemas.");
			}
		}else{
			request.setAttribute("message", "No se pudo agregar el plan curricular. Si el problema persiste, consulte con el personal de sistemas.");
		}
		
		return "/ServletPlanCurricular?action=listarPlanCurricular&idUsuario="+bean.getUsu_crea_reg()+"";
	}

	private String actualizarPlanCurricularEstado(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int estado=Integer.parseInt(request.getParameter("estadoPlan"));
		int idPlan=Integer.parseInt(request.getParameter("idPlan"));		
		String idUsuario = request.getParameter("idUsuario");
		int idEscuela=Integer.parseInt(request.getParameter("idEscuela"));
		
		PlanCurricularJDBC dao = new PlanCurricularJDBC();
		dao.eliminarCursoEstadoCero(idPlan,idEscuela);
		int result=dao.actualizarEstadoPlanCurricular(estado,idPlan,idEscuela);
		
		if(result==1){
			request.setAttribute("message", "El plan curricular se actualizó correctamente");
		}else{
			request.setAttribute("message", "No se pudo actualizar el plan curricular. Si el problema persiste, consulte con el personal de sistemas.");
		}
		
		return "/ServletPlanCurricular?action=listarPlanCurricular&idUsuario="+idUsuario+"&idEscuela="+idEscuela+"";
	}

	private String listarPlanCurricular(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String idUsuario = request.getParameter("idUsuario");
		String idEscuela = request.getParameter("idEscuela");
		
		HttpSession session=request.getSession();  
		session.setAttribute("idUser", idUsuario);
		session.setAttribute("idSchool", idEscuela);
		
		try{
			PlanCurricularJDBC dao = new PlanCurricularJDBC();
			List<PlanCurricular> lista = dao.listarPlanCurricular(idEscuela);
			request.setAttribute("lista", lista);
			
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return "/Planes/PlanCurricular/plancurricular.jsp";
	}

}
