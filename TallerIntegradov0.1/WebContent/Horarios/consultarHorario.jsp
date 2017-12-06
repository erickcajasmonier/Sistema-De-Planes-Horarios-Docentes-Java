<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Consultar Horario</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="../Imagenes/Horarios/uni.ico">


        <link rel="stylesheet" href="../Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="../Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="../Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="../Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="../CSS/Horarios/horarioCompartido.css">

        <link rel="stylesheet" href="../Recursos/responsive.css" />
        <script src="../Recursos/Jquery/jquery-1.11.2.min.js"></script>
        <script src="<%=request.getContextPath()%>/JS/Horarios/ConsultarHorario.js"></script>

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
                        
                        <a class="navbar-brand" href="../index.jsp">

                            <img src="../Imagenes/Horarios/escudo3.png" class="logo logo-display m-top-10" alt="" width="174px" height="70px">
                            <img src="../Imagenes/Horarios/usmp1.png" class="logo logo-scrolled" alt="" width="174px" height="60px">

                        </a>
                    </div>
                    <!-- End Header Navigation -->

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                            
                           <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Horario
                                </a>
                                <ul class="dropdown-menu cart-list">
                                    <li>
                                        <h6><a href="<%=request.getContextPath()%>/Horarios/consultarHorario.jsp">Consultar Horario</a>
                                    </li>
                                    <li><h6><a href="<%=request.getContextPath()%>/Horarios/validarHorario.jsp">Validar Horario</a></li>
                                </ul>
                            </li>                                 
                            
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>  
            </nav><br><br>
      

            <section id="ayuda" class="">
                <div class="container">

                        <div class="main_service roomy-100">
                              <div class="container-fluid">
                                <div class="row">
                                    <div id="divEscuela"class="col-md-6">
                                        <label for="">Seleccione Escuela:</label>
                                        <select class="form-control selectEsc" id="selectEscuela">
							</select>	
                                    </div>
                                    <div id="divSemestre" class="col-md-6">
                                        <label for="">Seleccione Semestre:</label>
                                        <select class="form-control selectSem" id="selectSemestre">
                                        </select>                                       
                                    </div>
                                </div><br>
                                <div class="row">
                                <div class="col-md-6">
                                <input type="button" class="btn btn-primary form-control" id="btnMostrarHorario" value="Consultar Horario"></div>
                                <div class="col-md-6">
                                <input type="button" class="btn btn-danger form-control" value="Salir"></div>
                                </div><br><br>

                                <div class="col-lg-12 nopadding" style="width:100%;height:600px;overflow-x: auto;overflow-y: auto;">
                                    <table name="table1" id="table1" class="table table-bordered">
                                        <thead name="table1head" id="table1head">
                                          	<td>Ciclo</td>
											<td>Profesor</td>
											<td>Curso</td>
											<td>Sección</td>
											<td>Aula</td>
											<td>Escuelas</td>
											<td>Lunes</td>
											<td>Martes</td>
											<td>Miércoles</td>
											<td>Jueves</td>
											<td>Viernes</td>
											<td>Sábado</td>
											<td>Domingo</td>
                                        </thead>
                                        <tbody name="table1body" id="table1body">
                                        </tbody>
                                    </table>                
                                </div>
                              </div>
                        </div>
                </div><!--End off container -->

            </section> <!--End off Featured section-->

           
             <!-- scroll up-->
            <div class="scrollup">
                <a href="#"><i class="fa fa-chevron-up"></i></a>
            </div><!-- End off scroll up -->

             <br>
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

    </body>
</html>