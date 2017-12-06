<%
int idPlan = (int)session.getAttribute("idPlan");
int idSemestre = (int)session.getAttribute("idSemester");
int idEscuela = (int)session.getAttribute("idSchool");
String escuela = (String)session.getAttribute("school");
String idUsuario = (String)session.getAttribute("idUser");
int añoSemestre = (int)session.getAttribute("yearSemester");
int semestre = (int)session.getAttribute("semester");

//Sumatoria de creditos para validación
int sumaCreditoCiclo = 0;
int sumaCredito = 0;
int sumaCreditoCursoEspecialidad = 0;
int sumaCreditoCursoGeneral = 0;
int creditoCiclo = 0;

if(session.getAttribute("sumaCredito")!=null){
	sumaCredito = (int)session.getAttribute("sumaCredito");
	sumaCreditoCiclo = (int)session.getAttribute("sumaCreditoCiclo");
	sumaCreditoCursoEspecialidad = (int)session.getAttribute("sumaCreditoCursoEspecialidad");
	sumaCreditoCursoGeneral = sumaCredito-sumaCreditoCursoEspecialidad;
	creditoCiclo=(int)session.getAttribute("creditoCiclo");
}	
%>	


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.css">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Planes/planesCompartido.css">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/responsive.css" />
		
    <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.js"></script>
	
    <script src="<%=request.getContextPath()%>/Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
</head>

<style>
	h5,h2,p{
	text-align:center;
	color:white;
	}
	#cursoPlan{
	border-width: 5px; border-style: double; height: 210px;
	}
	#cursoDisponible{
	border-width: 5px; border-style: dotted; height: 210px;
	}
	#contenedorCursos{
		border : solid 3px #ff0000; border-style: dashed; background : #000000; 
		color : #ffffff;padding : 4px; width : 100%; height : 500px; overflow : auto; 
	}
</style>

<body class="container-liquid">
	<div class="col-xs-12 col-sm-12 col-md-12">
		<a class="btn btn-warning btn-block" href="<%=request.getContextPath()%>/ServletPlanCurricular?action=listarPlanCurricular&idUsuario=<%=request.getParameter("idUsuario")%>&idEscuela=<%=idEscuela%>">Volver al listado de planes</a>
	</div>
	
	<div class="col-xs-12 col-sm-12 col-md-12">
	<h2>PLAN CURRICULAR</h2>
	<h2><%=escuela %></h2>
	<h2><%=añoSemestre %>-<%=semestre %></h2>
	</div>
		  
	<%String numeroCiclo = request.getParameter("ciclo");%>
		
	<div class="btn-group btn-group-justified">
  		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=1&idUsuario=<%=idUsuario %>">Ciclo I</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=2&idUsuario=<%=idUsuario %>">Ciclo II</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=3&idUsuario=<%=idUsuario %>">Ciclo III</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=4&idUsuario=<%=idUsuario %>">Ciclo VI</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=5&idUsuario=<%=idUsuario %>">Ciclo V</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=6&idUsuario=<%=idUsuario %>">Ciclo VI</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=7&idUsuario=<%=idUsuario %>">Ciclo VII</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=8&idUsuario=<%=idUsuario %>">Ciclo VIII</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=9&idUsuario=<%=idUsuario %>">Ciclo XI</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=10&idUsuario=<%=idUsuario %>">Ciclo X</a>
	</div>
	<div class="btn-group btn-group-justified">
		<%if(idEscuela==101){ %>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=11&idUsuario=<%=idUsuario %>">Sistemas de Información</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=12&idUsuario=<%=idUsuario %>">Tecnologías de Información</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=13&idUsuario=<%=idUsuario %>">Ingeniería de Software</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=14&idUsuario=<%=idUsuario %>">Generales</a>
		<%}else{ %>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=11&idUsuario=<%=idUsuario %>">Electivo 1</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=12&idUsuario=<%=idUsuario %>">Electivo 2</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=13&idUsuario=<%=idUsuario %>">Electivo 3</a>
		<a class="btn btn-info" href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricularCiclo&idPlan=<%=idPlan %>&idSemestre=<%=idSemestre %>&idEscuela=<%=idEscuela %>&ciclo=14&idUsuario=<%=idUsuario %>">Electivo 4</a>
		<%} %>
	</div>
	
	<div class="col-xs-12 col-sm-12 col-md-6">

		<h2>Asignaturas en el plan</h2>
		<div id=contenedorCursos>
			<% java.util.List<beans.DetallePlanCurricular> cicloLista = (java.util.List<beans.DetallePlanCurricular>)request.getAttribute("cicloLista");
			if(cicloLista!=null){
				for(int i = 0; i<cicloLista.size(); i++){
					beans.DetallePlanCurricular beans = cicloLista.get(i);%>
			<div class="col-xs-12 col-sm-6 col-md-4" id="cursoPlan">
				<h5><%=beans.getCodDce_curso()%></h5>
				<h5><%=beans.getNombre_curso()%></h5>
				<h5><%=beans.getCredito()%></h5>
				<input type="button" class="btn btn-warning btn-block" onclick='location.href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=preactualizarCursoDetallePlanCurricular&idCurso=<%=beans.getCodDce_curso()%>&idPlan=<%=idPlan%>&idSemestre=<%=request.getParameter("idSemestre")%>&idEscuela=<%=idEscuela%>&ciclo=<%=request.getParameter("ciclo")%>&idUsuario=<%=request.getParameter("idUsuario")%>";' value="Editar">
				<% if(beans.getEstado()==1){%>
				<input type="button" onclick='location.href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=actualizarDetallePlanCurricularEstado&estadoCursoPlan=<%=beans.getEstado()%>&idCurso=<%=beans.getCodDce_curso()%>&idPlan=<%=idPlan%>&idSemestre=<%=request.getParameter("idSemestre")%>&idEscuela=<%=idEscuela%>&ciclo=<%=request.getParameter("ciclo")%>&idUsuario=<%=request.getParameter("idUsuario")%>";' id="estado" type="button" class="btn btn-danger btn-block" value="Retirar">
				<%}else if(beans.getEstado()==0){ %>	
				<input type="button" onclick='location.href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=actualizarDetallePlanCurricularEstado&estadoCursoPlan=<%=beans.getEstado()%>&idCurso=<%=beans.getCodDce_curso()%>&idPlan=<%=idPlan%>&idSemestre=<%=request.getParameter("idSemestre")%>&idEscuela=<%=idEscuela%>&ciclo=<%=request.getParameter("ciclo")%>&idUsuario=<%=request.getParameter("idUsuario")%>";' id="estado" type="button" class="btn btn-success btn-block" value="Agregar">
				<%}%>
			</div>		
				<%}%>		
			<%}%>
		</div>		
		
	</div>
	
	
	<div class="col-xs-12 col-sm-12 col-md-6">
		<h2>Asignaturas disponibles</h2>
		<div id=contenedorCursos>
		<%if(numeroCiclo!=null){
			
			%>					
		<% java.util.List<beans.DetallePlanCurricular> cursoPlan = (java.util.List<beans.DetallePlanCurricular>)request.getAttribute("cursoPlan");
			if(cursoPlan!=null){
				
					for(int i = 0; i<cursoPlan.size(); i++){
						beans.DetallePlanCurricular bean = cursoPlan.get(i);
						if(bean.getEstado()==0){%>
			<div class="col-xs-12 col-sm-6 col-md-4"  id="cursoDisponible">		
				<h5><%=bean.getCodDce_curso()%></h5>
				<h5><%=bean.getNombre_curso()%></h5>
				<h5><%=bean.getCredito()%></h5>
				<%if(bean.getEstado()==0 && sumaCreditoCiclo+bean.getCredito()<=creditoCiclo){ %>
				<input type="button" onclick='location.href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=actualizarDetallePlanCurricularEstado&estadoCursoPlan=<%=bean.getEstado()%>&idCurso=<%=bean.getCodDce_curso()%>&idPlan=<%=idPlan%>&idSemestre=<%=request.getParameter("idSemestre")%>&idEscuela=<%=idEscuela%>&ciclo=<%=request.getParameter("ciclo")%>&idUsuario=<%=request.getParameter("idUsuario")%>";' id="estado" type="button" class="btn btn-success btn-block" value="Agregar">
				<%}else{%>
				<button class="btn btn-danger btn-block disabled">No disponible</button>
				<%} %>
			</div>	
						
					<%}%>
				<%}%>
			<%}%>	
		
		<% java.util.List<beans.Curso> cursoDisponible = (java.util.List<beans.Curso>)request.getAttribute("cursoDisponible");
			if(cursoDisponible!=null){
				for(int i = 0; i<cursoDisponible.size(); i++){
					beans.Curso bean = cursoDisponible.get(i);
		%>
			<div class="col-xs-12 col-sm-6 col-md-4" id="cursoDisponible">		
				<h5><%=bean.getIdCurso()%></h5>
				<h5><%=bean.getNombre()%></h5>
				<h5><%=bean.getCredito()%></h5>
				<%if(sumaCreditoCiclo+bean.getCredito()<=creditoCiclo){ %>
				<input type="button" onclick='location.href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=agregarCursoDetallePlanCurricular&idPlan=<%=idPlan%>&idSemestre=<%=request.getParameter("idSemestre")%>&idEscuela=<%=idEscuela%>&ciclo=<%=request.getParameter("ciclo")%>&idCurso=<%=bean.getIdCurso()%>&idUsuario=<%=request.getParameter("idUsuario")%>";' id="estado" type="button" class="btn btn-success btn-block" value="Agregar">
				<%}else{%>
				<button class="btn btn-danger btn-block disabled">No disponible</button>
				<%} %>
			</div>			
				<%}%>
			<%}%>
		<%}%>			
		</div>
		
	</div>
	
	<%if(numeroCiclo!=null){ %>
	
	<div class="col-xs-12 col-sm-12 col-md-12" >			
		<br>
		<p>Número de créditos en el ciclo <%=request.getParameter("ciclo") %>: <%=sumaCreditoCiclo %></p>
		<p>Número de créditos permitidos para el ciclo <%=request.getParameter("ciclo") %>: <%=creditoCiclo %></p>
		<p>Número de créditos de Asignaturas de especialidad: <%=sumaCreditoCursoEspecialidad %></p>
		<p>Número de créditos de Asignaturas generales: <%=sumaCreditoCursoGeneral %></p>
		<p>Total de créditos en el Plan: <%=sumaCredito %></p>
				
		<%if(sumaCreditoCursoEspecialidad>=165 && sumaCreditoCursoGeneral>=35){ %>	
			<input type="button" onclick='location.href="<%=request.getContextPath()%>/ServletPlanCurricular?action=actualizarPlanCurricularEstado&estadoPlan=0&idPlan=<%=idPlan%>&idUsuario=<%=request.getParameter("idUsuario")%>&idEscuela=<%=idEscuela%>";' id="estado" type="button" class="btn btn-success btn-block" value="Click para aprobar el plan">
		<%}else{ %>
			<button class="btn btn-danger btn-block disabled" onclick="return confirm('No se cumple el requisito de créditos de especialidad y/o generales o el creditaje por ciclo. Por favor, revise');">Aún no se puede aprobar el plan</button>
		<%} %>		
	</div>
	
	<%}%>
</body>


</html>