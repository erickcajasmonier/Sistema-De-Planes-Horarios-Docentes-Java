<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%String idUsuario = (String)session.getAttribute("idUser"); 
String idEscuela = (String)session.getAttribute("idSchool"); %>
<!DOCTYPE>
<html>
 <head>
        <meta charset="utf-8">
        <title>Plan Curricular</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="../Imagenes/Planes/uni.ico">


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
            <!--Home page style-->
            <nav class="navbar navbar-default navbar-fixed white no-background bootsnav">
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

                            <img src="<%=request.getContextPath()%>/Imagenes/Horarios/usmp.png" class="logo logo-display m-top-10" alt="">
                            <img src="<%=request.getContextPath()%>/Imagenes/Horarios/usmp3.png" class="logo logo-scrolled" alt="">

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
                                <a href="<%=request.getContextPath()%>/ServletPlanCurricular?action=listarPlanCurricular&idUsuario=<%=idUsuario%>&idEscuela=<%=idEscuela%>">Planes Curriculares
                                </a>
                            </li> 
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/login.jsp">Salir
                                </a>
                            </li>                        
						   <%}else{ %>  <!-- OTROS -->
						   <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletCurso?action=listarCurso">Cursos 
                                </a>
                            </li>                    
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletPlanCurricular?action=listarPlanCurricular&idUsuario=<%=idUsuario%>&idEscuela=<%=idEscuela%>">Planes Curriculares
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
                          <button class="btn btn-block btn-success" onclick='location.href="<%=request.getContextPath()%>/ServletPlanCurricular?action=preagregarPlanCurricular&idEscuela=${sessionScope.idSchool}&idUsuario=${sessionScope.idUser}";'>Agregar Plan Curricular</button>
                          
                          <br>
                          	<div>
							    <p style="text-align:center; color:red;">${war_message}</p>
							</div>
                          <br>
                          <div class="" style="overflow-x: auto;overflow-y: auto;height:600px;width:95%">
                              <table class="table">
								<tr id="tr1">
									<td>Código Plan Curricular</td>
									<td>Escuela</td>
									<td style="visibility: hidden">Código Semestre</td>
									<td>Descripción</td>
									<td>Usuario</td>
									<td>Estado</td>
									<td>Editar</td>
									<td>Eliminar</td>
								</tr>
			                 <%java.util.List<beans.PlanCurricular> lista = (java.util.List<beans.PlanCurricular>)request.getAttribute("lista");
								if(lista!=null){
									for(int i = 0; i<lista.size(); i++){
										beans.PlanCurricular bean = lista.get(i);		
								%>
								<tr>
								<td><%=bean.getIdPlan()%></td>
								<td><%=bean.getDescripcionEscuela()%></td>		
								<td style="visibility: hidden"><%=bean.getCodPc_sem()%></td>
								<td> <%=bean.getDescripcionSemestre()%></td>
								<td><%=bean.getUsu_crea_reg()%></td>	
								<% if(bean.getEstado()==1){%>
									<td><input type="button" onclick='location.href="<%=request.getContextPath()%>/ServletPlanCurricular?action=actualizarPlanCurricularEstado&estadoPlan=<%=bean.getEstado()%>&idPlan=<%=bean.getIdPlan()%>&idUsuario=${sessionScope.idUser}&idEscuela=<%=bean.getIdEscuela()%>";' id="estado" type="button" class="btn btn-success disabled btn-block" value="Aprobado"></td>
									<td><input type="button" onclick='location.href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricular&idPlan=<%=bean.getIdPlan()%>&idSemestre=<%=bean.getCodPc_sem()%>&idEscuela=<%=idEscuela%>&idUsuario=${sessionScope.idUser}";' value="Editar" class="btn btn-info disabled btn-block"></td>
								<%}else if(bean.getEstado()==0){ %>
									<td><input type="button" onclick='location.href="<%=request.getContextPath()%>/ServletPlanCurricular?action=actualizarPlanCurricularEstado&estadoPlan=<%=bean.getEstado()%>&idPlan=<%=bean.getIdPlan() %>&idUsuario=${sessionScope.idUser}&idEscuela=<%=bean.getIdEscuela()%>";' id="estado" type="button" class="btn btn-warning btn-block" value="En Espera"></td>
									<td><input type="button" onclick='location.href="<%=request.getContextPath()%>/ServletDetallePlanCurricular?action=listarDetallePlanCurricular&idPlan=<%=bean.getIdPlan()%>&idSemestre=<%=bean.getCodPc_sem()%>&idEscuela=<%=idEscuela%>&idUsuario=${sessionScope.idUser}";' value="Editar" class="btn btn-info btn-block"></td>
								<%}%>	
								
								<td><a onclick="return confirm('¡Atención! Se va a eliminar este plan curricular y todos los cursos que están contenidos en el mismo. De click en OK para continuar.');"
								href="<%=request.getContextPath()%>/ServletPlanCurricular?action=eliminarPlanCurricular&idPlan=<%=bean.getIdPlan()%>&idEscuela=<%=idEscuela%>&idUsuario=<%=bean.getUsu_crea_reg()%>" class="btn btn-danger btn-block">Eliminar</a></td>
								</tr>
									<%}%>	
								<%}%>
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