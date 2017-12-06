<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Modulo Horarios</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="../Imagenes/Docentes/uni.ico">


        <link rel="stylesheet" href="../Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="../Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="../Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="../Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="../CSS/Horarios/principalHorario.css">

        <link rel="stylesheet" href="../Recursos/responsive.css" />

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
                        
                        <a class="navbar-brand" href="../index.jsp">

                            <img src="../Imagenes/Horarios/usmp.png" class="logo logo-display m-top-10" alt="">
                            <img src="../Imagenes/Horarios/usmp3.png" class="logo logo-scrolled" alt="">

                        </a>
                    </div>
                    <!-- End Header Navigation -->

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                            <li ><a href="#ayuda" style="color:#ea8483;font-style:italic;">Comenzar</a></li>
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

            </nav>


            <!--Home Sections-->

            <section id="principal" class="home bg-mega">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row">
                        <div class="main_home">
                            <div class="home_text">
                                <h1 class="text-white">MODULO <br /> HORARIO</h1>
                            </div>

                    </div><!--End off row-->
                </div><!--End off container -->
            </section> <!--End off Home Sections-->
            <br><br><br><br>

            <section id="ayuda" class="service">
                <div class="container">
                    <div class="row">
                        <div class="main_service roomy-100">
                            <div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1">
                                <div class="head_title text-center">
                                    <h2>¿Como Empiezo?</h2>
                                    <div class="separator_auto"></div>
                                    <h5>Deberá seleccionar una de las opciones de la parte superior derecha de la barra de navegación. Dentro de capa opción deberá seleccionar la especificación con la cual desea trabajar... </h5>
                                </div>
                            </div>
                        </div>
                    </div><!--End off row -->
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

            <script src="../Recursos/Jquery/jquery-1.11.2.min.js"></script>
            <script src="../Recursos/bootstrap/bootstrap.min.js"></script>
            <script src="../Recursos/bootstrap/bootsnav.js"></script>
            <script src="../Recursos/main.js"></script>


    </body>
</html>
