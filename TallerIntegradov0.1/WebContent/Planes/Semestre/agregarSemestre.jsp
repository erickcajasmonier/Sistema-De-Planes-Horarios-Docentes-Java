<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE >
<html>
<head>
        <meta charset="utf-8">
        <title>Agregar Semestre</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="/TallerIntegradov0.1/Imagenes/Planes/uni.ico">


        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Planes/planesCompartido.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/responsive.css" />

        <script src="<%=request.getContextPath()%>/Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>

	<script>
	function validarInput(){
		
		var año = document.getElementById("año").value;
		if(isNaN(año)) {
			alert('Está introduciendo un valor no numérico en año. Por favor, revise.');
			return false;
		}
		var semestre = document.getElementById("semestre").value;
		if(isNaN(semestre)) {
			alert('Está introduciendo un valor no numérico en semestre. Por favor, revise.');
			return false;
		}
		var cantidadSemana = document.getElementById("cantidadSemana").value;
		if(isNaN(cantidadSemana)) {
			alert('Está introduciendo un valor no numérico en cantidad de semanas. Por favor, revise.');
			return false;
		}
		var creditoEspecialidad = document.getElementById("creditoEspecialidad").value;
		if(isNaN(creditoEspecialidad)) {
			alert('Está introduciendo un valor no numérico en créditos especialidad. Por favor, revise.');
			return false;
		}
		var creditoGeneral = document.getElementById("creditoGeneral").value;
		if(isNaN(creditoGeneral)) {
			alert('Está introduciendo un valor no numérico en créditos general. Por favor, revise.');
			return false;
		}
	}

	</script>
</head>

    <body data-spy="scroll" data-target=".navbar-collapse">


        <!-- Preloader -->
        <div id="loading">
            <div id="loading-center">
                <div id="loading-center-absolute">
                    <div class="object" id="object_one"></div>
                    <div class="object" id="object_two"></div>
                    <div class="object" id="object_three"></div>
                    <div class="object" id="object_four"></div>
                </div>
            </div>
        </div><!--End off Preloader -->


        <div class="culmn">
            <!--Home page style-->
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

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <%Integer perfil = (Integer) session.getAttribute("perfil"); %>
                        <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                    	<%if(perfil == 1) {%> <!-- ADMINISTRADOR -->
							<li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletCurso?action=listarCurso">Cursos 
                                </a>
                            </li>                    
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/Planes/Reporte/generarReporte.jsp">Reportes
                                </a>
                            </li> 
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletSemestre?action=listarSemestre">Semestres
                                </a>
                            </li>
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/login.jsp">Salir
                                </a>
                            </li> 
                           <%}else if(perfil == 2) {%>   <!-- DIRECTOR -->
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletPlanCurricular?action=listarPlanCurricular&idUsuario=${sessionScope.idUser}&idEscuela=${sessionScope.idSchool}">Planes Curriculares
                                </a>
                            </li>                     
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletSemestre?action=listarSemestre">Semestres
                                </a>
                            </li>
						   <%}else{ %>  <!-- OTROS -->
						   <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletCurso?action=listarCurso">Cursos 
                                </a>
                            </li>                    
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletPlanCurricular?action=listarPlanCurricular&idUsuario=${sessionScope.idUser}&idEscuela=${sessionScope.idSchool}">Planes Curriculares
                                </a>
                            </li>                     
                                            
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/Planes/Reporte/generarReporte.jsp">Reportes
                                </a>
                            </li> 
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletSemestre?action=listarSemestre">Semestres
                                </a>
                            </li>
						   <%}%>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>  
            </nav><br><br>
      

            <section id="ayuda" class="">
                <div class="container">
					<form action="<%=request.getContextPath()%>/ServletSemestre?action=agregarSemestre" id="form" method="post" onsubmit="return validarInput();">
                        <div class="main_service roomy-100">
                          <h4>Agregar Semestre Académico:</h4>
                          <hr>
                          <div class="container">
                            <div class="row">
                              <div class="col-md-4">
                              <p>Código Semestre:</p>
                              <input class="form-control" readonly="" name="idSemestre" value="<%=request.getAttribute("idSemestre")%>"></div>
                              <div class="col-md-4">
                              <p>Año:</p>
                              <input class="form-control" name="año" id="año" value="<%=request.getAttribute("año")%>"></div>
                              <div class="col-md-4">
                              <p>Semestre:</p>
                              <input class="form-control"  name="semestre" id="semestre" value="<%=request.getAttribute("semestre")%>">   
                              </div>
                            </div><br>
                            <div class="row">
                              <div class="col-md-4">
                              <p>Cantidad de Semanas:</p>
                              <input class="form-control"  name="cantidadSemana" id="cantidadSemana" value="<%=request.getAttribute("cantidadSemana")%>"></div>
                              <div class="col-md-4">
                              <p>Cantidad de créditos de cursos de especialidad:</p>
                              <input class="form-control" type="text" name="creditoEspecialidad" id="creditoEspecialidad" value="<%=request.getAttribute("creditoEspecialidad")%>"></div>
                              <div class="col-md-4">
                              <p>Cantidad de créditos de cursos generales:</p>
                              <input class="form-control" type="text" name="creditoGeneral" id="creditoGeneral" value="<%=request.getAttribute("creditoGeneral")%>"></div>
                            </div><br>
                            
							<div>
							    <p style="text-align:center; color:red;">${war_message}</p>
							</div>
                            <br>
                              <div class="row">
                                  <div class="col-md-6">
                                      <input type="submit" id="registrar" class="btn btn-success form-control" value="Agregar Semestre">
                                  </div>
                                  <div class="col-md-6">
                                      <input type="button" class="btn btn-danger form-control" value="Volver" onclick='location.href="<%=request.getContextPath()%>/ServletSemestre?action=listarSemestre"'>
                                  </div>
                              </div>
                          </div>
                        </div>
                    </form>    
                 </div><!--End off container -->

            </section> <!--End off Featured section-->

           
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