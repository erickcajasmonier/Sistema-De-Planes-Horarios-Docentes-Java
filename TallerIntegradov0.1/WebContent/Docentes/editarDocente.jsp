<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Modificar Docente</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="../Imagenes/Docentes/uni.ico">


        <link rel="stylesheet" href="../Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="../Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="../Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="../Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="../CSS/Docentes/docenteCompartido.css">

        <link rel="stylesheet" href="../Recursos/responsive.css" />
        <link rel="stylesheet" href="<%=request.getContextPath() %>/Recursos/datepicker/css/bootstrap-datepicker3.css">
		<script src="../Recursos/Jquery/jquery-1.11.2.min.js"></script>
        <script src="<%=request.getContextPath()%>/Recursos/countries.js"></script>
        
        <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery.validate.js"></script>
		<script src="<%=request.getContextPath() %>/Recursos/datepicker/js/bootstrap-datepicker.min.js"></script>  
		<script src="<%=request.getContextPath()%>/JS/Docentes/EditarDocente.js"></script>
        <script src="../Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
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

		<form action="" id="formEditarDocente">
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
                                    <input type="hidden" id="iddoc" name="iddoc">
                        <div class="main_service roomy-100">
                       <div class="row">
                           <div class="col-md-8">
                            <h4>Datos Personales</h4>
                                <div class="row">    
                                    <div class="col-md-4">
                                    <p>Nombre(s):</p>
                                    <input type="text" class="form-control onlytext" id="txtnom" name="txtnom"/>
                                    </div>

                                    <div class="col-md-4">
                                    <p>Apellido Paterno:</p>
                                    <input type="text" class="form-control onlytext" id="txtapepat" name="txtapepat"/>
                                    </div>

                                    <div class="col-md-4">
                                    <p>Apellido Materno:</p>
                                    <input type="text" class="form-control onlytext" id="txtapemat" name="txtapemat"/>
                                    </div>

                                </div><br>

                                <div class="row">    

                                    <div class="col-md-4">
                                    <p>Pais de Nacimiento:</p>
                                   	<select id="txtnac" name="txtnac" class="form-control seleccionable" /></select>
                                    </div>

                                    <div class="col-md-4">
                                    <p>N° de Documento:</p>
                                    <input type="text" class="form-control onlyNumber" id="txtnumdoc" name="txtnumdoc"/>
                                    </div>

                                    <div class="col-md-4">  <!--ERRORRRRRRRRRR-->
                                    <p>Fecha de Inicio:</p>
                                    <input type="text" class="form-control" id="txtfecini" name="txtfecini"/>
                                    </div>
                                </div>
                                <br>

                                <div>
                                    <p>¿Era docente a la entrada en vigencia de la Ley 30220?:</p>
                                    <input type="hidden" id="txtley" name="txtley" value="">
                                    <input type="radio" id="txtley" name="txtley" value="SI"><label for="txtley">Si</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" id="txtley" name="txtley" value="NO"><label for="txtley">No</label>
                                </div>
                            </div>
                            
                            <div class="col-md-4">
                            <h4>Grados Universitarios</h4>
                                <div class="row">    
                                    <div class="col-md-6">
                                    <p>Mayor Grado:</p>
                                    <select class="form-control selectMayg seleccionable" id="txtmaygra" name="txtmaygra"></select></div>

                                    <div class="col-md-6">
                                    <p>Mencion Mayor Grado:</p>
                                    <input type="text" id="txtmenmay" class="form-control">
                                    </div>
              
                                </div><br>
                                <div class="row">
                                    <div class="col-md-6">
                                        <p>Pais de Estudio:</p>
                                        <select class="form-control seleccionable" id="txtpaiuni" name="txtpaiuni"></select>
                                    </div> 
                                    <div class="col-md-6">
                                        <p>Universidad:</p>
                                        <input type="text" class="form-control" id="txtuni">
                                    </div>   
                                </div>
                             </div>
                          </div>

                        <br><br> 

                        <div class="row">
		                        <div class="col-md-8">
		                        <h4>Datos Extras</h4>
		                            <div class="row">    
		                                <div class="col-md-3">
		                                <p>Categoria:</p>
		                                <select class="form-control selectCat seleccionable" id="txtcat" name="txtcat"></select></div>
		
		                                <div class="col-md-3">
		                                <p>Regimen:</p>
		                                <select class="form-control selectReg seleccionable" id="txtregded" name="txtregded"></select></div>
		
		                                <div class="col-md-3">
		                                <p>Horas de Clase:</p>
		                               <input type="number" class="form-control suma" id="txthorcla" name="txthorcla"/></div>
		
		                                <div class="col-md-3">
		                                <p>Horas de Actividad:</p>
		                                <input type="number" class="form-control suma" id="txthoract" name="txthoract"/>
		                                <input class="form-control" type="hidden" id="txttothor" name="txttothor"/>
		                                </div>   
		              
		                            </div><br>
		
		                            <div class="row">     
		                                <div class="col-md-3">
		                                <p>Investigador:</p>
		                                <input type="hidden" id="txtdocinv" name="txtdocinv" value="">
		                                <input type="radio" id="txtdocinv" name="txtdocinv" value="SI"><label for="txtdocinv">Si</label> &nbsp;&nbsp;&nbsp;&nbsp;
		                                <input type="radio" id="txtdocinv" name="txtdocinv" value="NO"><label for="txtdocinv">No</label>
		                                </div>
		
		                                <div class="col-md-3">
		                                <p>Registrado en DINA:</p>
		                                <input type="hidden" id="txtdina" name="txtdina" value="">
		                                <input type="radio" id="txtdina" name="txtdina" value="SI"><label for="txtdina">Si</label>&nbsp;&nbsp;&nbsp;&nbsp;
		                                <input type="radio" id="txtdina" name="txtdina" value="NO"><label for="txtdina">No</label>
		                                </div>  
		
		                                <div class="col-md-3">
		                                <p>Periodo Academico:</p>
		                                <!-- <input class="form-control" type="text" id="txtperaca" name="txtperaca"/> -->
		                                <select 
										class="form-control selectSem" id="selectSemestre">
										<!-- <option value="" selected disabled hidden>--Seleccionar--</option> -->
										</select>
		                                </div> 
		
		                                <div id="divEscuela" class="col-md-3">
	                                  	<p>Escuela:</p>
	                                  	<select class="form-control selectEscuela" id="selectEscuela">
											<option value="" selected disabled>--Seleccionar--</option>
							 			</select>
	                                  	</div>
		
		                            </div><br>
		
		                            <div class="row">
		                                <div class="col-md-4">
		                                <p>E-mail:</p>
		                                <input type=email id="txtemail" class="form-control">
		                                </div>  
		
		                                <div class="col-md-4">
		                                <p>Telefono:</p>
		                                <input type="number" id="txttelef" class="form-control"></div> 
		
		                                <div class="col-md-4">
		                                <p>Observaciones:</p>
		                                <input class="form-control" type="text" id="txtobs" name="txtobs"/>
		                                </div>        
		                            </div><br>
		
		                        </div>
		
		                        <div class="col-md-4">
		                        <h4>Programa de Estudio de dictado</h4>
		                            <div class="row">    
		                                <div class="col-md-4">
		                                <p>Pregrado:</p>
		                                <input type="hidden" id="pregrado" name="pregrado" value="">
		                                <input type="radio" name="pregrado" id="pregrado" value="SI"><label for="pregrado">Si</label><br><br>
		                                <input type="radio" name="pregrado" id="pregrado" value="NO"><label for="pregrado">No</label>
		                                </div>
		
		                                <div class="col-md-4">
		                                <p>Maestria:</p>
		                                <input type="hidden" id="maestria" name="maestria" value="">
		                                <input type="radio" name="maestria" id="maestria" value="SI"><label for="maestria">Si</label><br><br>
		                                <input type="radio" name="maestria" id="maestria" value="NO"><label for="maestria">No</label>
		                                </div>
		
		                                <div class="col-md-4">
		                                <p>Doctorado:</p>
		                                <input type="hidden" id="doctor" name="doctor" value="">
		                                <input type="radio" name="doctor" id="doctor" value="SI"><label for="doctor">Si</label><br><br>
		                                <input type="radio" name="doctor" id="doctor" value="NO"><label for="doctor">No</label>
		                                </div>
		                            </div>
		                       </div>
                        </div>
                            <br><br>
                    
                        <div class="row">
                                <div class="col-md-4"><input type="button" class="btn btn-primary form-control" id="btnBuscarDocente" value="Buscar">
                                </div>  
                                <div class="col-md-4"><input type="button" class="btn btn-success form-control" id="btnActualizarDocente" value="Modificar">
                                </div>
                                <div class="col-md-4">
                                <!-- <input type="button" class="btn btn-danger form-control" value="Salir"> -->
                                <button type="button" class="btn btn-danger form-control" id="btn_volver" value="Regresar">Regresar</button>
                                </div>  
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
</form>
            <!-- JS includes -->

            
            <script src="../Recursos/bootstrap/bootstrap.min.js"></script>
            <script src="../Recursos/bootstrap/bootsnav.js"></script>
            <script src="../Recursos/main.js"></script>


    </body>
</html>
