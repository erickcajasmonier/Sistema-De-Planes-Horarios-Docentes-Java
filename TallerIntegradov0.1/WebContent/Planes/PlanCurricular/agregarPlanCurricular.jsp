<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8">
        <title>Crear Plan Curricular</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/Imagenes/Planes/uni.ico">


        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Planes/planesCompartido.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/responsive.css" />
		
		<script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery-1.11.2.min.js"></script>
        <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.js"></script>
	
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
                                <a href="<%=request.getContextPath()%>/ServletPlanCurricular?action=listarPlanCurricular&idUsuario=${sessionScope.idUser}&idEscuela=${sessionScope.idSchool}">Planes Curriculares
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
                	
					<form action="<%=request.getContextPath()%>/ServletPlanCurricular?action=agregarPlanCurricular" method="post">
                        <div class="main_service roomy-100">
                          <h4>Crear Plan Curricular:</h4>
                          <hr>
                          	<div><a class="btn btn-info btn-block" data-toggle="collapse" data-target="#demo">Click para ver detalle del plan curricular</a>

							<div id="demo" class="collapse">
								<div class="col-md-6">
	                              <p>Código Plan Curricular:</p>
	                              <input class="form-control" readonly="" name="idPlan" value="<%=request.getAttribute("idPlan")%>">
                              	</div>
	                              <div class="col-md-6">
	                              <p>Código Usuario:</p>
	                              <input class="form-control" readonly="readonly" name="idUsuario" value="${sessionScope.idUser}">
	                              </div>
	                              <div class="col-md-6">
	                              <p>Código Escuela:</p>
	                              <input class="form-control" readonly="" name="idEscuela" value="${sessionScope.idSchool}">
	                              </div>
	                       		  <div class="col-md-6">
	                              <p>Escuela:</p>
	                              <input class="form-control" readonly="" name="escuela" value="<%=request.getAttribute("escuela")%>"><br>
	                              </div>
	                              <div class="col-md-6">
	                              <p>Código Semestre:</p>
	                              <input class="form-control" readonly="" name="idSemestre" value="<%=request.getAttribute("idSemestre")%>">
	                              </div>
	                              <div class="col-md-6">
	                              <p>Semestre:</p>
	                              <input class="form-control" readonly="" name="" value="<%=request.getAttribute("añoSemestre")%>-<%=request.getAttribute("semestre")%>">
	                              </div>
							</div>
							</div>
                         
                          <div class="container col-md-12">
                          	<h2>Cantidad de créditos por ciclo</h2>
                          </div>
                          <div class="container col-md-12">
                          	 <div class="col-md-2">
	                          	 
                              </div>
                          	  
                          	  <div class="col-md-2">
	                          	 <div class="form-group">
	  								<label for="sel1">I Ciclo:</label>
	  								<select class="form-control" id="sel1" name="primerCiclo">
									      <option>20</option>
									    <option>21</option>
									    <option>22</option>
									    <option>23</option>
									    <option>24</option>
									    <option>25</option>
									 </select>
								</div>
                              </div>
                              
                              <div class="col-md-2">
	                          	 <div class="form-group">
	  								<label for="sel1">II Ciclo:</label>
	  								<select class="form-control" id="sel1" name="segundoCiclo">
									     <option>20</option>
									    <option>21</option>
									    <option>22</option>
									    <option>23</option>
									    <option>24</option>
									    <option>25</option>
									 </select>
								</div>
                              </div>
                              
                              <div class="col-md-2">
	                          	 <div class="form-group">
	  								<label for="sel1">III Ciclo:</label>
	  								<select class="form-control" id="sel1" name="tercerCiclo">
									     <option>20</option>
									    <option>21</option>
									    <option>22</option>
									    <option>23</option>
									    <option>24</option>
									    <option>25</option>
									 </select>
								</div>
                              </div>
                              
                              <div class="col-md-2">
	                          	 <div class="form-group">
	  								<label for="sel1">IV Ciclo:</label>
	  								<select class="form-control" id="sel1" name="cuartoCiclo">
									       <option>20</option>
									    <option>21</option>
									    <option>22</option>
									    <option>23</option>
									    <option>24</option>
									    <option>25</option>
									 </select>
								</div>
                              </div>
                              
                              <div class="col-md-2">
	                          	 <div class="form-group">
	  								<label for="sel1">V Ciclo:</label>
	  								<select class="form-control" id="sel1" name="quintoCiclo">
									      <option>20</option>
									    <option>21</option>
									    <option>22</option>
									    <option>23</option>
									    <option>24</option>
									    <option>25</option>
									 </select>
								</div>
                              </div>
                              
                              <div class="col-md-2">
	                          	 
                              </div>
                              
                              <div class="col-md-2">
	                          	 <div class="form-group">
	  								<label for="sel1">VI Ciclo:</label>
	  								<select class="form-control" id="sel1" name="sextoCiclo">
									      <option>20</option>
									    <option>21</option>
									    <option>22</option>
									    <option>23</option>
									    <option>24</option>
									    <option>25</option>
									 </select>
								</div>
                              </div>
                              
                              <div class="col-md-2">
	                          	 <div class="form-group">
	  								<label for="sel1">VII Ciclo:</label>
	  								<select class="form-control" id="sel1" name="septimoCiclo">
									      <option>20</option>
									    <option>21</option>
									    <option>22</option>
									    <option>23</option>
									    <option>24</option>
									    <option>25</option>
									 </select>
								</div>
                              </div>
                              
                              <div class="col-md-2">
	                          	 <div class="form-group">
	  								<label for="sel1">VIII Ciclo:</label>
	  								<select class="form-control" id="sel1" name="octavoCiclo">
									      <option>20</option>
									    <option>21</option>
									    <option>22</option>
									    <option>23</option>
									    <option>24</option>
									    <option>25</option>
									 </select>
								</div>
                              </div>
                              
                              <div class="col-md-2">
	                          	 <div class="form-group">
	  								<label for="sel1">IX Ciclo:</label>
	  								<select class="form-control" id="sel1" name="novenoCiclo">
									      <option>20</option>
									    <option>21</option>
									    <option>22</option>
									    <option>23</option>
									    <option>24</option>
									    <option>25</option>
									 </select>
								</div>
                              </div>
                              
                              <div class="col-md-2">
	                          	 <div class="form-group">
	  								<label for="sel1">X Ciclo:</label>
	  								<select class="form-control" id="sel1" name="decimoCiclo">
									       <option>20</option>
									    <option>21</option>
									    <option>22</option>
									    <option>23</option>
									    <option>24</option>
									    <option>25</option>
									 </select>
								</div>
                              </div>
                              
                              </div>
                          
                          <div class="col-md-12">
                               <input type="submit" class="btn btn-success form-control" value="Agregar Plan Curricular">
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
            <script src="<%=request.getContextPath()%>/Recursos/main.js"></script>

    </body>
</html>