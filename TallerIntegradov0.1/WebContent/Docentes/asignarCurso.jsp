<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
        <title>Asignar Curso a Docente</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="uni.ico">
	
   	    <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery-1.11.2.min.js"></script>
		 <script src="<%=request.getContextPath()%>/JS/Docentes/AsignarCursoDocente.js"></script>
		 
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Docentes/docenteCompartido.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/responsive.css" />

        <script src="<%=request.getContextPath()%>/Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>
<body>
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
                        
                        <a class="navbar-brand" href="#brand">

                             <img src="../Imagenes/Horarios/escudo3.png" class="logo logo-display m-top-10" alt="" width="174px" height="70px">
                            <img src="../Imagenes/Horarios/usmp1.png" class="logo logo-scrolled" alt="" width="174px" height="60px">

                        </a>
                    </div>
                    <!-- End Header Navigation -->

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                    <%Integer perfil = (Integer) session.getAttribute("perfil"); %>
                        <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Docentes 
                                </a>
                                <ul class="dropdown-menu cart-list">
                                <%if(perfil == 1) {%> <!-- ADMINISTRADOR -->
                                    <li>
                                        <h6><a href="<%=request.getContextPath()%>/Docentes/nuevoDocente.jsp">Nuevo Docente</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/editarDocente.jsp">Actualizar Docente</a></h6>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/asignarCurso.jsp">Asignar Curso a Docente</a></h6>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/disponibilidadDocente.jsp">Disponibilidad</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/interesDocente.jsp">Interés</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/Referido.jsp">Docente Recomendado</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/docenteC9.jsp">Reporte Docente C9</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/ConsultarDisponibilidadDocente.jsp">Disponibilidad Docente</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/ConsultarDisponibilidadReferido.jsp">Disponibilidad Recomendado</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/ReporteInteres.jsp">Reporte Docentes por Interes</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/ReporteInteresRecomendado.jsp">Reporte Recomendado por Interes</a></h6>
                                     </li>
                                <%} %>
                                <%if(perfil == 4) {%> <!-- ESCALAFON -->
                                    <li>
                                        <h6><a href="<%=request.getContextPath()%>/Docentes/nuevoDocente.jsp">Nuevo Docente</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/editarDocente.jsp">Actualizar Docente</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/asignarCurso.jsp">Asignar Curso a Docente</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/docenteC9.jsp">Reporte Docente C9</a></h6>
                                    </li>
                                 <%} %>
                                 <%if(perfil == 3) {%> <!-- DOCENTE -->
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/disponibilidadDocente.jsp">Disponibilidad</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/interesDocente.jsp">Interés</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/Referido.jsp">Docente Recomendado</a></h6>
                                    </li>
                                    <%} %> 
                                    <%if(perfil == 5) {%> <!-- ACREDITADOR -->
                                     <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/docenteC9.jsp">Reporte Docente C9</a></h6>
                                    </li>
                                    <% } %>  
                                    <%if(perfil == 6) {%> <!-- COORDINADOR -->
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/ConsultarDisponibilidadDocente.jsp">Disponibilidad Docente</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/ConsultarDisponibilidadReferido.jsp">Disponibilidad Recomendado</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/ReporteInteres.jsp">Reporte Docentes por Interes</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/ReporteInteresRecomendado.jsp">Reporte Recomendado por Interes</a></h6>
                                     </li>
                                    <% } %> 
                                    
                                    <%if(perfil == 7) {%> <!-- DEPARTAMENTO -->
                                    <li>
                                        <h6><a href="<%=request.getContextPath()%>/Docentes/nuevoDocente.jsp">Nuevo Docente</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/editarDocente.jsp">Actualizar Docente</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/asignarCurso.jsp">Asignar Curso a Docente</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Docentes/docenteC9.jsp">Reporte Docente C9</a></h6>
                                    </li>
                                 <%} %>	
                                </ul>
                            </li>                    

                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>  
            </nav><br><br>
      

            <section id="ayuda" class="">
                <div class="container">

                        <div class="main_service roomy-100">
                          <h4>Asignar Curso(s) a Docente:</h4><hr>
                          <div class="row">
                              <div class="col-md-5 col-lg-5" id="divDocente1">
                                  <div class="row">
                                    <div class="col-md-6"  id="divSemestre">
                                      <p>Seleccione Semestre</p>
                                      <select class="form-control selectSem" id="selectSemestre"></select>
                                    </div>
                                    <div class="col-md-6" id="divDocente" >               
                                      <p>Nº de Documento</p>
                                        <div class="row">
                                          <div class="col-md-9">
                                          <input type="number" class="form-control"  id="txtnumdoc" name="txtnumdoc"/></div>
                                          <div class="col-md-2">
                                          <button id ="btnBuscar" name="btnBuscar" type="button" class="btn btn-warning btn-lg">
							    			<i class="fa fa-search"></i>
							  			</button>
                                          </div>
                                        </div>
                                    </div>  
                                  </div><br>
                                  <p>Nombre(s)</p>
                                  <input type="text" class="form-control" id="txtNombre" name="txtNombre" disabled><br>

                                   <div class="row">
                                    <div class="col-md-6">
                                      <p>Ap.Paterno</p>
                                      <input type="text" class="form-control"id="txtApepat" name="txtApepat"  disabled>
                                    </div>
                                    <div class="col-md-6">
                                      <p>Ap.Materno</p>
                                      <input type="text" class="form-control" id="txtApemat" name="txtApemat" disabled>
                                      <input class="form-control txtDn " type="hidden" id="txtDni" name="txtDni" value=""/>	
                                    </div>
                                  </div><br>
									<div id="divEscuela">
                                  <p>Selecione Escuela</p>
                                  <select class="form-control selectEsc" id="selectEscuela">
		<!-- 			  			<option value="" selected disabled hidden>--Seleccionar--</option> -->
					  				</select><br>
									</div>
                                  <div class="row">
                                    <div class="col-md-6" id="divCiclo">
                                      <p>Ciclo</p>
                                      <select class="form-control selectCic" id="selectCiclo">
						 				 <option value="" selected disabled>--Seleccionar--</option>
						  				</select>
                                    </div>
                                    <div class="col-md-6" id="divCurso">
                                      <p>Curso</p>
                                      <select class="form-control selectCur" id="selectCurso">
						  				<option value="" selected disabled>--Seleccionar--</option>
						  					</select>
                                    </div>
                                  </div>

                                  <hr>

                                  <div class="row">
                                  <div class="col-md-4"><input id="btnAgregarDC" type="button" class="btn btn-primary form-control" value="Agregar"></div>
                                 <div class="col-md-4"><input id="btnGuardarDC" type="button" class="btn btn-success form-control" value="Guardar"></div>
                                <div class="col-md-4"> <input id="btnLimpiarDC" type="button" class="btn btn-danger form-control" value="Limpiar"></div>
                                </div>
                              </div>

                              <div class="col-md-offset-1 col-md-6 col-lg-6">
                                      <table name="tableDC" id="tableDC" class="table">
                                        <thead name="tableDChead" id="tableDChead">
                                        <tr id="tr1">
                                          <th>Codigo</th>
                                          <th>Curso</th>
                                          <th>Opciones</th>
                                        </tr>
                                        </thead>
                                        <tbody name="tableDCbody" id="tableDCbody">
                                        </tbody>
                                      </table>        
                                  <input type="hidden" name="resultado" id="resultado" placeholder="resultado"/>
                              </div>
                          </div>
                        </div>
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

            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.min.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/main.js"></script>

    </body>
</body>
</html>