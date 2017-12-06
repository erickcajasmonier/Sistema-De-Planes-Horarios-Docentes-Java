<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%@page import="util.Conexion"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Interés Docente Recomendado</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="../Imagenes/Docentes/uni.ico">


        <link rel="stylesheet" href="../Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="../Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="../Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="../Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="../CSS/Docentes/docenteCompartido.css">

        <link rel="stylesheet" href="../Recursos/responsive.css" />
		<script src="../Recursos/Jquery/jquery-1.11.2.min.js"></script>
		
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
                          <h4>Interés del Docente Recomendado:</h4><hr>
                          <br>
                            <p>Bienvenido ${sessionScope.profile} <strong>${sessionScope.username}</strong>.</p>
                          <%String dni; 
	                        dni=request.getParameter("dni"); %>
                          <div class="row">
                              <div class="col-md-6 col-lg-6" id="divEscuelaCurso">
                              <%if(perfil == 1) {%> <!-- ADMINISTRADOR -->
                              <div>
                              		<div id="divSemestre" class="">
									<p for="selectSemestre">Semestre</p> 
									<select
										class="form-control selectSem" id="selectSemestre">
										<!-- 			  <option value="" selected disabled hidden>--Seleccionar--</option> -->
									</select>
									</div><br>
                                  <p>Nº de Documento</p>
                                  <div class="row" id="divDocenteDni">
                                  <div class="col-md-10">
                                  <input value="<%out.print(dni);%>" type="text" id="txtnumdoc" name="txtnumdoc" class="form-control">
                                  </div>
                                  <div class="col-md-2">
                                  		<button id ="btnBuscar" name="btnBuscar" type="button" class="btn btn-warning btn-lg">
							    			<i class="fa fa-search"></i>
							  			</button>
                                  </div></div><br>
                                  <p>Nombre(s)</p>
                                  <input type="text" class="form-control" id="txtNombre" name="txtNombre" disabled><br>
								</div>
								<%}else if(perfil == 3) {%> <!-- DOCENTE -->
									<div style="display:none">
	                              		<div id="divSemestre" class="">
										<p for="selectSemestre">Semestre</p> 
										<select
											class="form-control selectSem" id="selectSemestre">
											<!-- 			  <option value="" selected disabled hidden>--Seleccionar--</option> -->
										</select>
										</div><br>
	                                  <p>Nº de Documento</p>
	                                  <div class="row" id="divDocenteDni">
	                                  <div class="col-md-10">
	                                  <input value="<%out.print(dni);%>" type="text" id="txtnumdoc" name="txtnumdoc" class="form-control">
										</div>
	                                  <div class="col-md-2">
	                                  		<button id ="btnBuscar" name="btnBuscar" type="button" class="btn btn-warning btn-lg">
								    			<i class="fa fa-search"></i>
								  			</button>
	                                  </div></div><br>
	                                  <p>Nombre(s)</p>
	                                  <input type="text" class="form-control" id="txtNombre" name="txtNombre" disabled><br>
									</div>
								<%}%>
								
								
                                  <div class="row" id="divEscuelaCurso">
	                                  <div id="divEscuela" class="col-md-6">
	                                  <p>Escuela</p>
	                                  <select class="form-control selectEscuela" id="selectEscuela">
												<option value="" selected disabled hidden>--Seleccionar--</option>
							 				</select><br>
	                                  </div>
	                                  <div id="divCurso" class="col-md-6">
	                                  	<p>Curso</p>
	                                  	<select class="form-control selectCurso" id="selectCurso">
												<option value="" selected disabled>--Seleccionar--</option>
										</select>
	                                  </div>
                                  </div>

								
								<br>
								<br>
								<br>
								<br>
								<br>
                                <div class="row">
                                	<div class="col-md-4"> 
                                		<button type="button" class="btn btn-danger form-control" id="btn_volver" value="Regresar">Regresar</button>
                                	</div>                                
                                </div>
                              </div>
                           
                              <div id="divInteres" class="col-md-6 col-lg-6">
                                   <div class="row">
                                    <div class="col-md-12">
                                    <label>Cursos de Interes</label>
                                        <!-- start: BASIC TABLE PANEL -->
                                        <div class="">
                                            <div class="">
                                                <table class="table" id="table_interes">
                                                    <thead >
                                                        <tr>
                                                            <th>Codigo</th>
                                                            <th>Curso</th>
                                                            <th>Escuela</th>
                                                            <th>Opciones</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="tbl_interes">
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <!-- end: BASIC TABLE PANEL -->
                                    </div>
                                </div>
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
                        <div class="main_footer text-center p-top-20 p-bottom-20">
                            <p class="wow fadeInRight" data-wow-duration="1s">
                                USMP - 
                                Developers: Erick Diaz, Hernan Percca, Jhonatan Yachi, Pikachu, Roowlet
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
            	buscarInteres();
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
	
////////////////////////////////////////////////////////////////////////////////////////////
	
$('#divCurso').on('change', '#selectCurso', function(){
	var idcurso = $('#selectCurso').val();
	var c=0;
	var vacio=1;
	
	$('#tbl_interes tr').each(function(el) {
    	var idCur="";
    	var tdss = $(this).find("td");
    	idCur= tdss.filter(":eq(0)").text();
    	if(idCur==idcurso){
    		c++;}
    	vacio=0;
	});
	
	if(c==0 || vacio==1){
		grabarInteres();
	}
	else{
		alert("El curso ya esta registrado.");
	}
	$('#selectCurso').val($('#selectCurso > option:first').val());
	$('#selectAdicional').val($('#selectAdicional > option:first').val());
});

$('#divAdicional').on('change', '#selectAdicional', function(){
	var idcurso = $('#selectAdicional').val();
	var c=0;
	var vacio=1;
	
	$('#tbl_interes tr').each(function(el) {
    	var idCur="";
    	var tdss = $(this).find("td");
    	idCur= tdss.filter(":eq(0)").text();
    	if(idCur==idcurso){
    		c++;}
    	vacio=0;
	});
	
	if(c==0 || vacio==1){
		grabarAdicional();
	}
	else{
		alert("El curso ya esta registrado.");
	}
	$('#selectCurso').val($('#selectCurso > option:first').val());
	$('#selectAdicional').val($('#selectAdicional > option:first').val());
});

function grabarInteres(){
	var linea = [];
    var itemOrden = {};

    itemOrden.codDocente	= $('#txtnumdoc').val();
	itemOrden.idCurso		= $('#selectCurso').val();
	itemOrden.cod_semestre = $('#selectSemestre').val();
    
    linea.push(itemOrden);
	
    var datosxlinea={};
    datosxlinea.linea=linea;
       
    var datatable=JSON.stringify(datosxlinea);
    console.log(datatable);
	
	$.ajax({
		type:'POST',
		url :'<%=request.getContextPath()%>/RegistrarInteresReferido',
		dataType:'JSON',
		data:{
			 objetojson:JSON.stringify(datosxlinea)
			 },
		success: function(data){
			if(data == "1"){
				alert("Se registró correctamente.");
				buscarInteres();
			}else{
				alert("Error al registrar");
			}
		}
	});
}
function grabarAdicional(){
	var linea = [];
    var itemOrden = {};

    itemOrden.codDocente	= $('#txtnumdoc').val();
	itemOrden.idCurso		= $('#selectAdicional').val();
	itemOrden.cod_semestre = $('#selectSemestre').val();
    
    linea.push(itemOrden);
	
    var datosxlinea={};
    datosxlinea.linea=linea;
       
    var datatable=JSON.stringify(datosxlinea);
    console.log(datatable);
	
	$.ajax({
		type:'POST',
		url :'<%=request.getContextPath()%>/RegistrarInteresReferido',
		dataType:'JSON',
		data:{
			 objetojson:JSON.stringify(datosxlinea)
			 },
		success: function(data){
			if(data == "1"){
				alert("Se registró correctamente.");
				buscarInteres();
			}else{
				alert("Error al registrar");
			}
		}
	});
}

	$('#divEscuelaCurso').on('click', '#btnBuscar', function(){
	   	  var numdoc = $('#txtnumdoc').val().trim();
	   	  
	   	  if(numdoc == ""){
	   		  alert("Datos incompletos");
	   		  return false;
	   	  }
	   	  $.ajax({
	            type: 'POST',
    		    url: '/TallerIntegradov0.1/VerificarDocente',
	            data: {
            	  	numerodoc : numdoc
			        },
              success: function(data)
              {
              	var var1=data.split(":");
              	console.log(data);
              	if(data==":"){
              		alert("Docente no encontrado.");
              		$('#txtnumdoc').val("");
              		$('#txtDni').val("");
              		$('#txtNombre').val("");
  				    $('#txtApepat').val("");
  				    $('#txtApemat').val("");
              	}
             	else{
	                  	for (var i=0;i<var1.length-1;i++) {
	      				    var nombre    =   var1[i].split("-|")[0];
	      				    var apellidoP =   var1[i].split("-|")[1];
	      				    var apellidoM =   var1[i].split("-|")[2];
	      				    var dni       =   var1[i].split("-|")[3];
	      				    $('#txtDni').val(dni);
	      				    alert("Docente: "+nombre+" "+apellidoP+" "+apellidoM+" encontrado");
	      				    $('#txtNombre').val(nombre);
	      				    $('#txtApepat').val(apellidoP);
	      				    $('#txtApemat').val(apellidoM);
	      				}
              	}
              }
  	  });
	   	  
	   
     });

////////////////////////////////////////////////////////////////////////////////////////////
	
$('#table_interes').on('click', '#btn_eliminar', function(){
	var hi= confirm("¿Esta seguro que desea eliminar?");
  	if (hi== true){
        var idcurso ="";
        idcurso=$(this).closest('tr').find("td").filter(":eq(0)").text();
  		//alert(id);
  		var numdoc	=	$("#txtnumdoc").val();
  		var sem = $('.selectSem').val() ;
  		//var var1=id+numdoc+sem+"";
      	//alert("Datos Correctos.");
        $.ajax({
	        type: 'POST',
	        url: '/TallerIntegradov0.1/EliminarInteresReferido',
	        data: {
		        	idcurso: idcurso,
		        	numdoc: numdoc,
		        	sem: sem
		    },
	        success: function(data)
	        {
	        	if (data==="vacio"){
					alert("No se encontró el Interes");
				}else {
					//alert("Se eliminó correctamente");
					buscarInteres();
				}	
	        }
		});

  		//$(this).closest('tr').remove();
  		}
});
	////////////////////////////////////////////////////////////////////////////////////////////

$('body').on('click', '#btn_volver', function(){
	window.location='Referido.jsp';
});
	////////////////////////////////////////////////////////////////////////////////////////////

	$('#divDocenteDni').on('change', '#txtnumdoc', function(){
		buscarInteres();
	});
		
	$('#divSemestre').on('change', '#selectSemestre', function(){
		buscarInteres();
	});
			
	function buscarInteres() {
		$('#table_interes tbody tr').remove();
		
		$.ajax({
	        type: 'POST',
	        url: '/TallerIntegradov0.1/ListarInteresxReferido',
	        data : {
				numdoc : $('#txtnumdoc').val(),
				sem: $('.selectSem').val() 
			},
	        success: function(data)
	        {            	
	        	var array = data.split("$");
				//$('#table_disponibilidad').empty();
				if(data == "_"){
					alert("No hay registro de Cursos de Interes");
				}else{
					for (var i = 0; i < array.length - 1; i++) {
						var codigo = array[i].split("=")[0];
						var curso = array[i].split("=")[1];
						var escuela = array[i].split("=")[2];
						if(escuela=="null"){
							escuela="---";
							}
	  				    $('#table_interes').append("<tr>" +
		  				  		"<td>"+codigo+"</td>" +
		  				  		"<td>"+curso+"</td>" +
		  				  		"<td>"+escuela+"</td>" +
		  				  		'<td><button name="btn_eliminar" id="btn_eliminar" class="btn btn-danger">Eliminar</button></td>'+
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