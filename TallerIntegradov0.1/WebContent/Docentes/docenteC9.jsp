<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8">
        <title>Reporte Licenciamiento C9</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/Imagenes/Planes/uni.ico">


        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="../Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="../Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="../Recursos/bootstrap/bootsnav.css">
            <script src="../Recursos/Jquery/jquery-1.11.2.min.js"></script>
		
		<script src="<%=request.getContextPath()%>/JS/Docentes/ListarDocentesC9.js"></script>
		
        <link rel="stylesheet" href="../CSS/Docentes/docenteCompartido.css">

        <link rel="stylesheet" href="../Recursos/responsive.css" />
        
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/datepicker/css/bootstrap-datetimepicker.min.css">
        
		<script src="<%=request.getContextPath()%>/Recursos/datepicker/js/bootstrap-datetimepicker.fr.js"></script>
    
    	<script src="<%=request.getContextPath()%>/Recursos/datepicker/js/bootstrap-datetimepicker.js"></script>

        <script src="../Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <style>
    	td{
    	font-size:11px;
    	}
    </style>
    <body data-spy="scroll" data-target=".navbar-collapse">


        <!-- Preloader -->
        <div id="loading">
            <div id="loading-center">
                <div id="loading-center-absolute">
                    <div class="object" id="object_one"></div>
                    <div class="object" id="object_two"></div>
                    <div class="object" id="object_tdree"></div>
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

                    <!-- Collect tde nav links, forms, and otder content for toggling -->
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
                            <h3>Reportes <small>Docentes</small></h3>
                            <hr>
                            <h5>Registro de Licenciamiento C9</h5><br>
							
							<div class="row">
   					<div class="col-md-6">	
						<div class="form-group">
                				<label for="dtp_input2" class="col-md-4 control-label">Elegir Fecha</label>
                			<div class="input-group date form_date col-md-8" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    			<input class="form-control" size="16" type="text" value="" readonly id="txtfecha" name="txtfecha" placeholder="AAAA-MM-DD">
                    			<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
         	       			</div>
							<input type="hidden" id="dtp_input2" value="" /><br/>
				
           				</div>
           		  		<span>
				            <div class = "col-md-6"> 
				       		 <button class="btn btn-block btn-success" type="button" id="btnGenerarReporte">Generar Reporte</button><br>	 
				     		</div>
				     		<div class = "col-md-6"> 
				       		 <button class="btn btn-block btn-success" type="button" id="btnEXCEL">Exportar Excel</button><br>	 
				     		</div>
				 		 </span>
					</div>
					
					<div class="col-md-6">
						<label class = "col-md-12">Filtrar por: </label>
					  <div class="row">
						<div class = " col-md-4">
							
								<button class ="btn form-control btn-primary" type ="button" id="btnDINA">DINA</button><br><br>
								<button class ="btn form-control btn-primary" type = "button" id="btnCompleto">TIEMPO COMPLETO</button>
							
						
						</div>
						<div class ="col-md-4">
							
								<button class ="btn form-control btn-primary" type ="button" id="btnCATE">CATEGORIA</button>
							<br><br>
								<button class ="btn form-control btn-primary" type = "button" id="btnPARCIAL">TIEMPO PARCIAL</button>
							
						</div>
						
						<div class ="col-md-4">
						
								<button class ="btn form-control btn-primary" type ="button" id="btnINV">INVESTIGADOR</button>
							<br><br>
								<button class ="btn form-control btn-primary" type = "button" id="btnTODO">MOSTRAR TODO</button>
							
						</div>
						</div>
						
					
					</div>
					
				</div><br><br>
							
							
                            <div class="row">
                                
                            <div class="" style="overflow-x: auto;overflow-y: auto;height:500px;border:1px solid gray;border-radius:7px">
                              <table id="example1" class="table table-bordered">
                                <thead>
                                  <tr>
                                    <td>APELLIDO PATERNO</td>
                                    <td>APELLIDO MATERNOS</td>
                                    <td>NOMBRES</td>
                                    <td>NACIONALIDAD (PAIS)</td>
                                    <td>N° DE DNI / CARNET DE EXTRANJERÍA</td>
                                    <td>FECHA DE INGRESO COMO DOCENTE EN LA UNIVERSIDAD</td>
                                    <td>¿ERA DOCENTE UNIVERSITARIO A LA ENTRADA EN VIGENCIA DE LA  LEY 30220, LU? Sí/No (1)</td>
                                    <td>¿EL DOCENTE FUE INCORPORADO DESPUÉS DE LA OBTENCIÓN DE LA LICENCIA DE FUNCIONAMIENTO INSTUCIONAL Sí/No (2)</td>
                                    <td>MAYOR GRADO ACADÉMICO DEL DOCENTE (3)</td>
                                    <td>MENCIÓN DEL MAYOR GRADO DOCENTE (4)</td>
                                    <td>UNIVERSIDAD QUE OTORGÓ EL MAYOR GRADO DOCENTE</td>
                                    <td>PAÍS / UNIVERSIDAD QUE OTORGÓ EL MAYOR GRADO DEL DOCENTE</td>
                                    <td>PREGRADO Sí/No</td>
                                    <td>MAESTRÍA Sí/No</td>
                                    <td>DOCTORADO Sí/No</td>
                                    <td>SL01</td>
                                    <td>SL02</td>
                                    <td>SL03</td>
                                    <td>CATEGORÍA DOCENTE (6)</td>
                                    <td>RÉGIMEN DE DEDICACIÓN (7)</td>
                                    <td>CLASES</td>
                                    <td>OTRAS ACTIVIDADES</td>
                                    <td>TOTAL HORAS SEMANALES</td>
                                    <td>DOCENTE REALIZA INVESTIGACIÓN  Sí/No (8)</td>
                                    <td>DOCENTE REGISTRADO EN DINA Sí/No (9)</td>
                                    <td>PERIODO ACADÉMICO (10)</td>
                                    <td>COMENTARIOS</td>
                                    <td>ESCUELAS</td>
                                    <td>EMAIL</td>
                                    <td>TELEFONO</td>
                                  </tr>


                                </thead>

                                <tbody id="tableBody">
                                                          
                                </tbody>
                              </table>
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

            <script src="../Recursos/bootstrap/bootstrap.min.js"></script>
            <script src="../Recursos/bootstrap/bootsnav.js"></script>
            <script src="../Recursos/main.js"></script>
		<script>
    $(function () {
        $("#example1").DataTable({
            "paging": false,
            "lengthChange": false,
            "searching": false,
            "ordering": false,
            "info": false,
            "autoWidth": false
          });        
      });
    </script>
    
    <script type="text/javascript">
  
	$('.form_date').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });

</script>
		
    </body>
</html>