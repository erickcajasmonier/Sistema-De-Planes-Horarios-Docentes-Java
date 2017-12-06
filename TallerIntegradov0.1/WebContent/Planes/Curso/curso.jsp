<!doctype html>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Mantener Curso</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="/TallerIntegradov0.1/Imagenes/Planes/uni.ico">


        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Planes/planesCompartido.css">
         <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/responsive.css" />

        <script src="<%=request.getContextPath()%>/Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
<script>
    function myFunction() {
        // Declare variables
        var input, filter, table, tr, td, i;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
    
    function myFunction2() {
        // Declare variables
        var input, filter, table, tr, td, i;
        input = document.getElementById("myInput2");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
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
    <body style="background: url(<%=request.getContextPath()%>/Imagenes/Planes/planesFnd.jpg) top;" data-spy="scroll" data-target=".navbar-collapse">


        <!-- Preloader  -->
   <!--    <div id="loading">
            <div id="loading-center">
                <div id="loading-center-absolute">
                    <div class="object" id="object_one"></div>
                    <div class="object" id="object_two"></div>
                    <div class="object" id="object_three"></div>
                    <div class="object" id="object_four"></div>
                </div>
            </div>
        </div>
        -->
   
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
                           <%}if(perfil == 2) {%>   <!-- DIRECTOR -->
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletPlanCurricular?action=listarPlanCurricular&idUsuario=${sessionScope.idUser}&idEscuela=${sessionScope.idSchool}">Planes Curriculares
                                </a>
                            </li>                     
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletSemestre?action=listarSemestre">Semestres
                                </a>
                            </li>
						   <%}if(perfil == 5){ %>  <!-- OTROS -->
						   <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletCurso?action=listarCurso">Cursos 
                                </a>
                            </li>  
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/Planes/Reporte/generarReporte.jsp">Reportes
                                </a>
                            </li>                   
						   <%}%>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>  
            </nav><br><br>
      <div class="row">


            <section id="ayuda" class="">
             
                <div class="container">
              
                        <div class="main_service roomy-100">
                        <div class="row">
                          <div class="col-md-3"><a class="btn btn-block btn-primary form-control" href=ServletCurso?action=AgregarCurso>Agregar nuevo curso</a>
                          </div>	
                          <div class="col-md-4"><input type="text" class = "form-control" id="myInput" onkeyup="myFunction()" placeholder="Codigo">
                          </div>
                          <div class="col-md-5"><input type="text" class = "form-control" id="myInput2" onkeyup="myFunction2()" placeholder="Nombre">
                          </div>
                         </div><br><br>


	<div style="overflow-x:auto;overflow-y:auto;height:400px;border:1px solid gray;border-radius:7px">
                            <table id="myTable" class="table">
  
   <thead>
        <tr>
          <th style="width:120px;text-align:center">Código</th>
      <th style="width:190px;text-align:left;margin-left:100px">Nombre del Curso</th>
      <th style="width:100px;text-align:center">SICAT</th>
      <th style="width:60px;text-align:center">Crédito</th>   
      <th style="width:20px;text-align:center">HT</th>
      <th style="width:20px;text-align:center">HL</th>
      <th style="width:20px;text-align:center">HP</th>
      <th style="width:120px;text-align:center">Requisitos</th>
      <th style="width:120px;text-align:center">CoRequisito</th>
      <th style="width:120px;text-align:center">N°Crédito</th>
      <th style="width:220px;text-align:center">Propietario</th>
      <th style="width:100px;text-align:center">Estado</th>
      <th></th>
      </thead>
      <tbody>
     
        
      <% java.util.List<beans.Curso> lista = (java.util.List<beans.Curso>)request.getAttribute("lista");
    if(lista!=null){
      for(int i = 0; i<lista.size(); i++){
        beans.Curso bean = lista.get(i);    
    %>
  
        <tr>

      
          <td style="width:120px;text-align:center"><%=bean.getIdCurso()%></td>
      
      <td style="width:160px"><%=bean.getNombre()%></td>
      <td style="width:100px"><%=bean.getSicat()%></td>
      <td style="width:45px"><%=bean.getCredito()%></td>    
      <td style="width:35px"><%=bean.getHoraTeoria()%></td>
      <td style="width:35px"><%=bean.getHoraLaboratorio()%></td>
      <td style="width:35px"><%=bean.getHoraPractica()%></td>
      <td style="width:120px"><%=bean.getRequisito01()%>  <%=bean.getRequisito02()%> <%=bean.getRequisito03()%></td>
      <td style="width:120px"><%=bean.getCorequisito()%></td>
      <td><%=bean.getCreditoRequisito()%></td>
      <td style="width:180px"><%=bean.getNombrePropietario()%></td>   
      <% if(bean.getEstado()==1){%>
        <td><input class="btn btn-block btn-success" type="button" onclick='location.href="<%=request.getContextPath()%>/ServletCurso?action=actualizarCursoEstado&estadoCurso=<%=bean.getEstado()%>&id=<%=bean.getId() %>";' id="estado" type="button" class="" value="Activo"></td>
        <td><button class="btn btn-block btn-primary" onclick='location.href="<%=request.getContextPath()%>/ServletCurso?action=preactualizarCurso&index_curso=<%=bean.getId()%>";' >Editar</button></td>
      <%}else if(bean.getEstado()==0){ %>
        <td><input class="btn btn-block btn-danger" type="button" onclick='location.href="<%=request.getContextPath()%>/ServletCurso?action=actualizarCursoEstado&estadoCurso=<%=bean.getEstado()%>&id=<%=bean.getId() %>";' id="estado" type="button" class="" value="Bloqueado"></td>
        <td><button class="btn btn-block btn-primary" disabled onclick='location.href="<%=request.getContextPath()%>/ServletCurso?action=preactualizarCurso&index_curso=<%=bean.getId()%>";' >Editar</button></td>    
      <%}%>
      <%}%>   
    <%}%>

        </tr>
        
      </tbody>
    
    </table>
     </div>
                 </div><!--End off container -->
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
                                USMP - Developers: Erick Diaz, Hernan Percca, Jhonatan Yachi
                            </p>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
            <!-- JS includes -->

            <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery-1.11.2.min.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.min.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/main.js"></script>

    </body>
</html>
