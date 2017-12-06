<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Plan Curricular</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
 <link rel="icon" type="image/png" href="/TallerIntegradov0.1/Imagenes/Planes/uni.ico">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Planes/planesCompartido.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/responsive.css" />

        <script src="<%=request.getContextPath()%>/Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>


<body data-spy="scroll" data-target=".navbar-collapse">
<div class="culmn">
<nav class="navbar navbar-default navbar-fixed no-background bootsnav">
<!-- Start Top Search -->
                <div class="top-search">
                    <div class="container">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                            <input type="text" class="form-control" placeholder="Search">
                            <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
                        </div>
                    </div>
                </div>
                <!-- End Top Search -->
                <div class="container">  
                <!-- Start Atribute Navigation -->
                    <div class="attr-nav">
                        <ul>
                            <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
                        </ul>
                    </div>        
                    <!-- End Atribute Navigation -->
                    
                    <!-- Start Header Navigation -->
                    <div class="navbar-header">

                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                            <i class="fa fa-bars"></i>
                        </button>
                        
                        <a class="navbar-brand" href="/TallerIntegradov0.1/index.jsp">

                            <img src="/TallerIntegradov0.1/Imagenes/Horarios/escudo3.png" class="logo logo-display m-top-10" alt="" width="174px" height="70px">
                <img src="/TallerIntegradov0.1/Imagenes/Horarios/usmp1.png" class="logo logo-scrolled" alt="" width="174px" height="60px">

                        </a>
                    </div>
                    <!-- End Header Navigation -->
                    <%-- <div class="collapse navbar-collapse" id="navbar-menu">
                    <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                    <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletPlanCurricular?action=listarPlanCurricular">Planes Curriculares
                                </a>
                     </li> 
                    </ul>
                    </div> --%>
                </div>
</nav><br><br>
<section id="ayuda" class="">
<div class="container">
<div class="main_service roomy-100">
	<% beans.DetallePlanCurricular beans = (beans.DetallePlanCurricular)request.getAttribute("lista");%>
	<h3>Actualizar Asignatura en Plan Curricular</h3><br>
	<form action="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=actualizarCursoDetallePlanCurricular" method="post">
		<% if(beans!=null){ %>
		
		<div class="form-group col-xs-12 col-sm-6 col-md-4">
			<label>Código de Usuario: </label>
    		<input class="form-control" readonly="" name="idUsuario" value="<%=request.getParameter("idUsuario")%>">
		</div>	    	
		<div class="form-group col-xs-12 col-sm-6 col-md-4">
			<label>Código de Asignatura: </label>
    		<input class="form-control" readonly="" name="idCurso" value="<%=beans.getCodDce_curso()%>">
		</div>
		
		<div class="form-group col-xs-12 col-sm-6 col-md-4">
		   	<label>Código de Plan Curricular: </label>
    		<input class="form-control" readonly="" name="idPlan" value="<%=beans.getIdPlan()%>">
    	</div>
    	
    	<div class="form-group col-xs-12 col-sm-6 col-md-4">
			<label>Código de Semestre: </label>
    		<input type="hidden" class="form-control" readonly="" name="idSemestre" value="<%=beans.getCodDce_sem()%>">
    		<input class="form-control" readonly="" name="" value="<%=request.getAttribute("añoSemestre") %>-<%=request.getAttribute("semestre") %>">
    	</div>
    	
    	<div class="form-group col-xs-12 col-sm-6 col-md-4">
			<label>Código Escuela: </label>
    		<input class="form-control" readonly="" name="idEscuela" value="<%=beans.getCodDce_escuela()%>">
    	</div>
    	
    	<div class="form-group col-xs-12 col-sm-6 col-md-4">
			<label>Ciclo: </label>
    		<input class="form-control" readonly="" name="ciclo" value="<%=beans.getCiclo()%>">
    	</div>
    	
    	<div class="form-group col-xs-12 col-sm-6 col-md-4">
		   	<label>Categoría FIA: </label>
		   	<select name="categoriaFIA" class="form-control">
		   		<option><%=beans.getCat_fia()%></option>
	    		<option>CIENCIAS DE LA COMPUTACIÓN</option>
	    		<option>MÉTODOS CUANTITATIVOS</option>
	    		<option>MATEMÁTICA</option>
	    	</select>
	   	</div>
			    	
		<div class="form-group col-xs-12 col-sm-6 col-md-4">
		   	<label>Tipo FIA: </label>
		   	<select name="tipoFIA" class="form-control">
		   		<option><%=beans.getTipo_fia()%></option>
		   		<option>ELECTIVO</option>
		   		<option>OBLIGATORIO</option>
	    	</select>
		</div>
		
		<div class="form-group col-xs-12 col-sm-6 col-md-4">
			<label>Tipo SUNEDU: </label>
			<select name="tipoSUNEDU" class="form-control">
				<option><%=beans.getTipo_sunedu()%></option>
				<option>ESPECÍFICO</option>
				<option>GENERAL</option>
			</select>
		</div>
			    	
		<div class="form-group col-xs-12 col-sm-6 col-md-4">
		   	<label>Modalidad: </label>
		   	<select name="modalidad" class="form-control">
		   		<option><%=beans.getTipo_pres_virt()%></option>
		   		<option>PRESENCIAL</option>
		   		<option>VIRTUAL</option>
		   	</select>
	   	</div>
		<div class="form-group col-xs-12 col-sm-6 col-md-4 col-md-offset-4">
		<br>
		<input type="submit" value="Actualizar en Plan Curricular" class="btn btn-success form-control">
		</div>
		<% }%>
		
	</form>
	</div>
	</div>
</section><br><br><br>
 <!-- scroll up-->
            <div class="scrollup">
                <a href="#"><i class="fa fa-chevron-up"></i></a>
            </div><!-- End off scroll up -->


            <footer id="footer" class="footer bg-black">
                <div class="container">
                    <div class="row">
                        <div class="main_footer text-center p-top-40 p-bottom-30">
                            <p class="wow fadeInRight" data-wow-duration="1s">
                                USMP -
                                Developers: Erick Diaz, Hernan Percca, Jhonatan Yachi
                            </p>
                        </div>
                    </div>
                </div>
            </footer>
</div>
		<!-- JS includes -->

            <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery-1.11.2.min.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.min.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/main.js"></script>
</body>
</html>