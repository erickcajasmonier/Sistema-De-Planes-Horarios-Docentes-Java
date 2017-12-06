<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8">
        <title>Semestre Académico</title>
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

                        <div class="main_service roomy-100">
                          <div class="container">
                            
                              <button type="button" class="btn btn-primary" onclick='location.href="<%=request.getContextPath()%>/ServletSemestre?action=preagregarSemestre";'>Agregar Semestre Académico</button>
                              <br><br>
                           <div>
                              <label>Introduzca el semestre a buscar:</label>
                            </div>
                            <div>
                              <input type="text" class="form-control" placeholder="Ej. 2016-1" id="filtrarSemestre" onkeyup="myFunction()" >
                            </div><br><br>
                            

                            <div style="height:400px;overflow-y: auto;overflow-x: auto;">               
                            <table class="table" id="tbl_semestre">
                                <thead>
                                        <th>Código Semestre</th>
                                        <th>Semestre</th>
                                        <th>Cantidad de Semanas</th>
                                        <th>Crédito de Especialidad</th>
                                        <th>Créditos de General</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                </thead>
                                <tbody>
                                <% java.util.List<beans.Semestre> lista = (java.util.List<beans.Semestre>)request.getAttribute("lista");
									if(lista!=null){
										for(int i = 0; i<lista.size(); i++){
											beans.Semestre bean = lista.get(i);		
									%>
									<tr>
										<td><%=bean.getIdSemestre()%></td>
										<td><%=bean.getAño()%>-<%=bean.getSemestre()%></td>		
										<td><%=bean.getCantidadSemana()%></td>
										<td><%=bean.getCred_especialidad()%></td>
										<td><%=bean.getCred_general() %></td>
										<td><input type="button" class="btn btn-warning btn-block" onclick='location.href="<%=request.getContextPath()%>/ServletSemestre?action=preactualizarSemestre&idSemestre=<%=bean.getIdSemestre()%>";' value="Editar"></td>
										<td><a class="btn btn-danger btn-block" onclick="return confirm('¡Atención! Se va a eliminar este semestre. De click en OK para continuar.');"
												href="<%=request.getContextPath()%>/ServletSemestre?action=eliminarSemestre&idSemestre=<%=bean.getIdSemestre()%>">Eliminar</a></td>
									</tr>
										<%}%>	
									<%}%>
                                </tbody>
                            </table>
                            <% String message = (String)request.getAttribute("message");
								if(message!=null){ %>
								<p style="text-align:center;"><%=message%></p>
								<%
								}
							%>
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

            <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery-1.11.2.min.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.min.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/main.js"></script>
			
			<!-- Filtro por semestre -->
			<script>
			function myFunction() {
			  // Declare variables 
			  var input, filter, table, tr, td, i;
			  input = document.getElementById("filtrarSemestre");
			  filter = input.value.toUpperCase();
			  table = document.getElementById("tbl_semestre");
			  tr = table.getElementsByTagName("tr");
			
			  // Loop through all table rows, and hide those who don't match the search query
			  for (i = 0; i < tr.length; i++) {
			    td = tr[i].getElementsByTagName("td")[1];
			    if (td) {
			      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
			    } 
			  }
			}
			</script>
    </body>
</html>