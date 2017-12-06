<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Reporte Cursos de Interes</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="../Imagenes/Planes/uni.ico">


        <link rel="stylesheet" href="../Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="../Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="../Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="../Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="../CSS/Docentes/docenteCompartido.css">

        <link rel="stylesheet" href="../Recursos/responsive.css" />
        
        
        <script src="../Recursos/Jquery/jquery-1.11.2.min.js"></script>

        <script src="../Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        
        <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery.validate.js"></script>
    </head>

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
      

            <section id="ayuda" class="" style="margin-left: 15%">
                <div class="container">

                        <div class="main_service roomy-100" style="width:80%">
                            <h4>Reporte de Docentes por Curso de Interes</h4>
                            
                            <div class="panel-body">
                            
                            <!-- <form action="/TallerIntegradov0.1/ReporteDocentesxInteres" method="post"> -->
	                            <div class="row" id="divEscuelaCurso">
		                                  <div id="divEscuela" class="col-md-4">
		                                  <p>Escuela</p>
		                                  <select class="form-control selectEscuela" id="selectEscuela">
													<option value="" selected disabled>--Seleccionar--</option>
								 				</select><br>
		                                  </div>
		                                  <div id="divCurso" class="col-md-4">
		                                  	<p>Curso</p>
		                                  	<select class="form-control selectCurso" id="selectCurso">
													<option value="" selected disabled>--Seleccionar--</option>
											</select>
		                                  </div>
		                                  <div class="col-md-4" id="divDocenteSem">
	                                      <p>Semestre</p>
	                                      <select 
											class="form-control selectSem" id="selectSemestre">
											<!-- <option value="" selected disabled hidden>--Seleccionar--</option> -->
										</select>
	                                	</div>
                                  </div>
                            <!-- --> 
                            <br>
                            <h4></h4>
                            <br>
                            <div style="overflow-x: auto;overflow-y: auto;height: 250px;border:1px solid gray;border-radius:7px" class="form-group" id="tabla_Intereses"> 
                            
                            <!--<form method="post" action="editarReferido.jsp">  -->
                            <table id="myTable" class="table">
								   <thead>
									    <tr>
									      <th style="text-align:center">DNI</th>
									      <th style="text-align:center">Nombre</th>
									      <th style="text-align:center">Apellido Paterno</th>
									      <th style="text-align:center">Apellido Materno</th> 
									      <th style="text-align:center">Correo</th> 
										</tr>
								     </thead>
								      
								     <tbody id="tbl">
								       
								     </tbody>
					    	</table>
					    	<!-- </form> -->
                            </div>
 					       
                            <div class="row">
                                <div class="col-md-offset-9 col-md-3">
                                     <button class="btn btn-success form-control" id="btnEXCEL">Generar Reporte Excel</button> 
                                    
                                    <!-- <input class="btn btn-success" type="submit" name=action value="Generar Reporte"/> -->
                                </div>

                            </div>
                            <!-- </form> -->
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
	
<script type="text/javascript"> 
$(document).ready(function(){
	
	$.ajax({
        type: 'POST',
        url: '/TallerIntegradov0.1/ListarSemestres',
        success: function(data)
        {            	
        	$('.selectSem').empty();
        	$('.selectSem').append('<option value="'+""+'">--Seleccionar--</option>');
        	var var1=data.split(":");
        	for (var i=0;i<var1.length-1;i++) {
        		var varr1=var1[i].split("/")[0];
			    var varr2=var1[i].split("/")[1];
			    var varr3=var1[i].split("/")[2];
			    $('.selectSem').append('<option value="'+varr1+'">'+varr2+' - '+varr3+'</option>');
			    ultimosem=varr1;
			}
        	$('#selectSemestre').val(ultimosem);
        }
      });
	
	$.ajax({
        type: 'POST',
        url: '/TallerIntegradov0.1/ListarPropietario',
        success: function(data)
        {            	
        	$('.selectEscuela').empty();
        	$('.selectEscuela').append('<option value="'+""+'">--Seleccionar--</option>');
        	var var1=data.split("$");
        	for (var i=0;i<var1.length-1;i++) {
        		var valor=var1[i].split("=")[0];
			    var desc=var1[i].split("=")[0];
				    $('.selectEscuela').append('<option value="'+valor+'">'+desc+'</option>');
			}
       }
	});
	$('#divEscuela').on('change', '#selectEscuela', function(){
        if ( $(this).children(":selected").val() === "" ) {
              $('.selectCurso option').remove();
              $('.selectCurso').append('<option value="'+""+'">--Seleccionar--</option>');
        }
        else {
        	$('.selectCurso option').remove();
        	$.ajax({
                type: 'POST',
                url: '/TallerIntegradov0.1/Listarcursoxpropietario',
                data: { 
		        	prop:$('#selectEscuela').val().trim(),
		        },
                success: function(data)
            {
       	$('.selectCurso').append('<option value="'+""+'">--Seleccionar--</option>');
               	var var1=data.split("$");
	           	for (var i=0;i<var1.length-1;i++) {
			    var valor=var1[i].split("=")[0];
			    var descr=var1[i].split("=")[1];
 			    $('.selectCurso').append('<option value="'+valor+'">'+descr+'</option>');
				}
         }
     });   
     }
	});
	
	/*
	$.ajax({
        type: 'POST',
        url: '/TallerIntegradov0.1/ListarEscuelas',
        success: function(data)
        {            	
        	$('.selectEscuela').empty();
        	$('.selectEscuela').append('<option value="'+""+'">--Seleccionar--</option>');
        	var var1=data.split(":");
        	for (var i=0;i<var1.length-1;i++) {
        		var valor=var1[i].split("-")[0];
			    var desc=var1[i].split("-")[1];
				    $('.selectEscuela').append('<option value="'+valor+'">'+desc+'</option>');
			}
       }
	});
	
	$('#divEscuela').on('change', '#selectEscuela', function(){
        if ( $(this).children(":selected").val() === "" ) {
              $('.selectCurso option').remove();
              $('.selectCurso').append('<option value="'+""+'">--Seleccionar--</option>');
        }
        else {
        	$('.selectCurso option').remove();
        	$.ajax({
                type: 'POST',
                url: '/TallerIntegradov0.1/ListarCur',
                data: { 
		        	idescuela:$('#selectEscuela').val(),
		        },
                success: function(data)
            {
       	$('.selectCurso').append('<option value="'+""+'">--Seleccionar--</option>');
               	var var1=data.split(":");
	           	for (var i=0;i<var1.length-1;i++) {
			    var valor=var1[i].split("-")[0];
			    var descr=var1[i].split("-")[1];
 			    $('.selectCurso').append('<option value="'+valor+'">'+descr+'</option>');
				}
         }
     });   
     }
	});
	*/
});


$('#divCurso').on('change', '#selectCurso', function(){
	listarReferidoxInteres();
});

////////////////////////////////////////////////////////////////////////////////////////////
$('#btnEXCEL').click(function(){ 
	$.ajax({
		type : 'POST',
		url : '/TallerIntegradov0.1/ReporteReferidoxInteres',
		data : {
			idcurso : $('#selectCurso').val(),
			idsem	: $('#selectSemestre').val(),
			curso	: $('#selectCurso option:selected').text(),
			sem		: $('#selectSemestre option:selected').text()
		}
	});
});

$('#divDocenteSem').on('change', '.selectSem', function(){
	listarReferidoxInteres();
});

function listarReferidoxInteres(){
	$('#myTable tbody tr').remove();
	var idcurso=$('#selectCurso').val(); 
	var sem =$('#selectSemestre').val();
	$.ajax({
        type: 'POST',
        url: '/TallerIntegradov0.1/ListarReferidoxInteres',
        data : {
			idcurso : idcurso,
			sem:	sem
		},
        success: function(data)
        {            	
        	var array = data.split("$");
        	//alert(array);
			//$('#table_disponibilidad').empty();
			if(data == "_"){
				alert("No hay registro de Cursos de Interes");
			}else{
				for (var i = 0; i < array.length - 1; i++) {
					var numdoc = array[i].split("=")[0];
					var nombre = array[i].split("=")[1];
					var apepat = array[i].split("=")[2];
					var apemat = array[i].split("=")[3];
					var correo = array[i].split("=")[4];
					

  				    $('#myTable').append("<tr>" +
	  				  		"<td>"+numdoc+"</td>" +
	  				  		"<td>"+nombre+"</td>" +
	  				  		"<td>"+apepat+"</td>" +
	  				  		"<td>"+apemat+"</td>" +
	  				 		"<td>"+correo+"</td>" +
	  				  		"</tr>");
				}
			}
			
        }
	});
}


</script>

	<script src="<%=request.getContextPath()%>/Recursos/main.js"></script>
    </body>
</html>
