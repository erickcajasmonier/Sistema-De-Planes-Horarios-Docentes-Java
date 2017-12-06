<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Docente Recomendado</title>
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
                        	<%String dni; 
	                        dni=request.getParameter("dni"); %>
                        	<%if(perfil == 1) {%> <!-- ADMINISTRADOR -->
                        	<h4>Buscar Docente Recomendado</h4>
                           	<form action="" id="formEditarDocente" >
	                        <div class="panel-body">
	                           <div class="row">
									<div class="col-md-4">
										<p>DNI</p>
										<input value="<%out.print(dni);%>" type="text" id="txtnumdocb" class="form-control" name="txtnumdocb" minlength="8" maxlength="8" required>
									</div>
									<div class="col-md-4" id="divDocenteSem">
                                      <p>Semestre</p>
                                      <select 
										class="form-control selectSem" id="selectSemestre">
										<!-- <option value="" selected disabled hidden>--Seleccionar--</option> -->
									</select>
                                    </div>
									<div class="col-md-4">
										<button name="btn_buscar" id="btn_buscar" type="button" class="btn btn-primary ">
		                                   <span  aria-hidden="true"></span>Buscar
		                                </button>
									</div>
							    </div>
						    </div>
						    <%}else if(perfil == 3) {%>   <!-- DOCENTE -->
						    	<div class="row" style="display:none">
									<div class="col-md-4">
										<input value="<%out.print(dni);%>" type="text" id="txtnumdocb" class="form-control" name="txtnumdocb" minlength="8" maxlength="8" required>
									</div>
									<div class="col-md-4" id="divDocenteSem">
                                      <select
										class="form-control selectSem" id="selectSemestre">
										<!-- <option value="" selected disabled hidden>--Seleccionar--</option> -->
									</select>
                                    </div>
									<div class="col-md-4">
										<button name="btn_buscar" id="btn_buscar" type="button" class="btn btn-primary ">
		                                   <span  aria-hidden="true"></span>Buscar
		                                </button>
									</div>
							    </div>
						    <%}%>
						    </form>
						    <br>
                            <h4>Modificar Docente Recomendado</h4>
                            <br>
                            <p>Bienvenido ${sessionScope.profile} <strong>${sessionScope.username}</strong>.</p>
                            <form action="" id="form1">
                            <div class="panel-body">
                            
	                            <br>
	                            <div class="row">
	                                <div class="col-md-4" id="divReferidoDni">
	                                    <p>N° de Documento</p>
	                                    <input type="hidden" id="iddoc" name="iddoc">
	                                    <input type="hidden" class="form-control" id="txtnumdocDoc" name="txtnumdocDoc" value="<%out.print(session.getAttribute("dni"));%>" >
	                                    <input type="text" class="form-control" id="txtnumdoc" name="txtnumdoc" disabled>
	                                </div>
	                                <div class="col-md-4" id="divReferido1">
	                                    <p>Nombre(s)</p>
	                                    <input type="text" id="txtNombre"  name="txtNombre"  class="form-control onlytext">
	                                </div>
	                                <div class="col-md-4" id="divReferido1">
	                                    <p>Apellido Paterno</p>
	                                    <input type="text" id="txtApepat" name="txtApepat" class="form-control onlytext">
	                                </div>
	                            </div> 
	                            <br>
	                            <div class="row">
	                                <div class="col-md-4" id="divReferido1">
	                                    <p>Apellido Materno</p>
	                                    <input type="text" id="txtApemat" name="txtApemat" class="form-control onlytext">
	                                </div>
	                                <div class ="col-md-4" id="divReferido1">
	                                    <p>Edad</p>
	                                    <input type="number" id="txtedad" name="txtedad"  class="form-control">
	                                </div>
	                                <div class="col-md-4" id="divReferido1">
	                                    <p>E-mail</p>
	                                    <input type="email" id="txtemail" name="txtemail" class="form-control">
	                                </div>
	                            </div>
                            </div>
                            <br>
                            <br><br>
                            <div class="row">
                                <div class="col-md-offset-6 col-md-3">
                                    <button type="button" class="btn btn-success form-control" id="btn_guardar" value="Grabar">Grabar</button>
                                </div>
                                <div class="col-md-3">
                                    <button type="button" class="btn btn-danger form-control" id="btn_volver" value="Regresar">Regresar</button>
                                </div>
                            </div>
                            </form>
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
	///////////////////////////////////////////////////////////////////////////////////
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
			}
        }
      });

	$('.onlytext').keyup(function(e) {
		  var regex = /^[a-zA-Z]+$/;
		  if (regex.test(this.value) !== true)
		    this.value = this.value.replace(/[^a-zA-Z]+/, '');
		});
	
	//////////////////////////////////////////////////////////////////////
	$("#form1").validate({
		  rules: {
			txtNombre:	{
			  				required:true,
			  				minlength:2
						},
          txtApepat:	{
		    				required:true,
		    				minlength:2
		    			},
          txtApemat:	{
							required:true,
							minlength:2
						},
			txtnumdoc:	{	
							required:true, 
							minlength:8,
							maxlength:11
						},
			txtedad:    {
							required:true,
							min:20,
							max:99
						},
			txtemail: 	{
							required:true,
							email: true
						}
		  },
		  messages: {
          txtNombre: 	{	required:"Campo obligatorio",
		    				minlength:"Campo no válido"},
		  	txtApepat: 	{	required:"Ingresar Apellido Paterno.",
		  					minlength:"Campo no válido"},
		  	txtApemat: 	{	required:"Ingresar Apellido Materno.",
			  				minlength:"Campo no válido"},
		  	txtnumdoc:	{	required:"Ingrese DNI.", 
		  					minlength:"Ingrese mínimo 8 digitos",
		  					maxlength:"Ingrese menos de 11 digitos"},
		  	txtedad:	{	required:"Ingrese un valor",
		  					min:"Campo no válido",
		  					max:"Campo no válido"},
			txtemail:	{	required:"Ingrese Correo electronico",
							email:"Campo no válido"}		
		  }
	});
	
	buscarReferido();
	setSemestre();
		
});	
	//////////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////////////////
$('#btn_buscar').on('click', function(){ 
	buscarReferido();
});
$('body').on('click', '#btn_guardar', function(){
	guardarReferido();
});
$('body').on('click', '#btn_volver', function(){
	window.location='Referido.jsp';
});
	
//////////////////////////////////////////////////////////////////////
function guardarReferido() {
        if($("#form1").valid()){   // test for validity
        	$.ajax({
                type: 'POST',
                url: '/TallerIntegradov0.1/EditarReferido',
                data: { 
                	iddoc		: $("#iddoc").val(),
                	numdoc		: $('#txtnumdoc').val(),
         			nombre    	: $('#txtNombre').val(),
         			apepat    	: $('#txtApepat').val(),
         			apemat      : $('#txtApemat').val(),
         			edad  		: $('#txtedad').val(),	
         			correo      : $('#txtemail').val(),
         			cod_semestre: $('#selectSemestre').val(),
         			
    	        },
                success: function(data)
                {
                	if (data == 1){
         				alert("Error al modificar docente recomendado.Se modificó correctamente.");
         			}else {
         				alert("Se modificó correctamente.");
         			}	
                }
     		});
        	
        }
	};

function buscarReferido(){
	var var1	=	$("#txtnumdocb").val();
	 if(var1.length>=8){  
      //alert("Datos Correctos.");
       $.ajax({
	        type: 'POST',
	        url: '/TallerIntegradov0.1/BuscarReferido',
	        data: {
		        	numdoc:$('#txtnumdocb').val()
		        },
	        success: function(data)
	        {
	        	if (data==="vacio"){
					alert("No se encontró al Usuario");
				}else {
					//alert("Docente encontrado.");
					var listaNombres = data.split("=");
					
					$("#iddoc").val(listaNombres[0]);
					$("#txtnumdoc").val(listaNombres[2]);
					$("#txtNombre").val(listaNombres[3]);
					$("#txtApepat").val(listaNombres[4]);
					$("#txtApemat").val(listaNombres[5]);
					$("#txtedad").val(listaNombres[6]);
					$("#txtemail").val(listaNombres[7]);
					var semestre=listaNombres[8];
					$('.selectSem option[value='+semestre+']').attr('selected',true);
					
					
				}	
	        }
		});
	 }
}

function setSemestre(){
	$('#selectSemestre').val($('#selectSemestre > option:last').val());
}

        
        

</script>

	<script src="<%=request.getContextPath()%>/Recursos/main.js"></script>
    </body>
</html>
