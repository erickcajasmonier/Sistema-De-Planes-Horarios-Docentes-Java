<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Docente Referido</title>
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
            td = tr[i].getElementsByTagName("td")[2];
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
      

            <section id="ayuda" class="" >
                <div class="container">
                        <div class="main_service roomy-100" >
                            <h4>Docentes Recomendados</h4>
                            <br>
                            <p>Bienvenido ${sessionScope.profile} <strong>${sessionScope.username}</strong>.</p>
                            <!--  <div class="panel-body">-->
                             <%if(perfil == 1) {%> <!-- ADMINISTRADOR -->
	                            <div class="row">
	                            	<div class="col-md-3" id="divReferidoDni">
	                                    <p>N° de Documento</p>
	                                    <input type="text" class="form-control" id="txtnumdoc" name="txtnumdoc" value="<%out.print(session.getAttribute("dni"));%>" >
	                                </div>
	                            </div>
	                          <%}else if(perfil == 3) {%> <!-- DOCENTE -->
	                            <div class="row">
	                            	<div class="col-md-3" id="divReferidoDni">
	                                    <input type="hidden" class="form-control" id="txtnumdoc" name="txtnumdoc" value="<%out.print(session.getAttribute("dni"));%>" >
	                                </div>
	                            </div>
	                          <%}%>
	                            <br>
	                            <div class="row">
		                          <div class="col-md-3"><a class="btn btn-block btn-primary form-control" href="docenteReferido.jsp">Agregar Docente Recomendado</a>
		                          </div>	
		                          <div class="col-md-3"><input type="text" class="form-control" id="myInput" onkeyup="myFunction()" placeholder="Codigo">
		                          </div>
		                          <div class="col-md-3"><input type="text" class="form-control" id="myInput2" onkeyup="myFunction2()" placeholder="Apellido Paterno">
		                          </div>
		                          <div class="col-md-3" id="divDocenteSem">
	                                      <select 
											class="form-control selectSem" id="selectSemestre">
											<!-- <option value="" selected disabled hidden>Semestre</option> -->
										</select>
	                              </div>
	                         	</div>

                            <br>
                            <h4></h4>
                            <br>
                           <div style="overflow-x:auto;overflow-y:auto;height:400px;border:1px solid gray;border-radius:7px">
                           <!--   <form method="post" action="editarReferido.jsp"> -->
                            <table id="myTable" class="table">
								   <thead>
									    <tr>
									      <th style="text-align:center">DNI</th>
									      <th style="text-align:center">Nombre</th>
									      <th style="text-align:center">Apellido Paterno</th>
									      <th style="text-align:center">Apellido Materno</th>
									      <th style="text-align:center">Correo</th> 
									      <th style="text-align:center">Opciones</th>    
										</tr>
								     </thead>
								      
								     <tbody id="tbl">
								       
								     </tbody>
					    	</table>
					    	
					    	<% String dni;
			  				dni=request.getParameter("dni");%>
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
        	$('.selectSem').append('<option value="'+"0"+'">Todos</option>');
        	var var1=data.split(":");
        	for (var i=0;i<var1.length-1;i++) {
        		var varr1=var1[i].split("/")[0];
			    var varr2=var1[i].split("/")[1];
			    var varr3=var1[i].split("/")[2];
			    $('.selectSem').append('<option value="'+varr1+'">'+varr2+' - '+varr3+'</option>');
			    ultimosem=varr1;
			}
        	$('#selectSemestre').val(ultimosem);
        	buscarReferido();
        }
      });

	
	
});
buscarReferido();
$('#divReferidoDni').on('change', '#txtnumdoc', function(){
	//listarReferido();
	
	if($('.selectSem').val()!='0'){
		
		buscarReferido();
	}
	else{
		listarReferido();
	}
	
});
////////////////////////////////////////////////////////////////////////////////////////////

$('#divDocenteSem').on('change', '.selectSem', function(){
	if($('.selectSem').val()=='0'){
		listarReferido();
	}
	else{
		buscarReferido();
	}
});
function buscarReferido() {
	$('#myTable tbody tr').remove();
	$.ajax({
        type: 'POST',
        url: '/TallerIntegradov0.1/ListarReferidoxDocenteSem',
        data : {
			numdoc : $('#txtnumdoc').val(),
			sem: $('.selectSem').val()
		},
        success: function(data)
        {            	
        	var array = data.split("$");
        	//alert(array);
			//$('#table_disponibilidad').empty();
			if(data == "_"){
				alert("No hay registro de Docente Recomendado");
			}else{
				for (var i = 0; i < array.length -1; i++) {
					var id=array[i].split("=")[0];
					var dni = array[i].split("=")[2];
					var nombre = array[i].split("=")[3];
					var apepat = array[i].split("=")[4];
					var apemat = array[i].split("=")[5];
					var correo = array[i].split("=")[7];
  				    $('#myTable').append("<tr>" +
	  				  		"<td>"+dni+"</td>" +
	  				  		"<td>"+nombre+"</td>" +
	  				  		"<td>"+apepat+"</td>" +
	  				  		"<td>"+apemat+"</td>" +
	  				  		"<td>"+correo+"</td>" +
	  				  	'<td><form name="myform" action="editarReferido.jsp">'+
  				  		'<input name="dni" value= '+dni+' class="btn btn-block btn-primary" type="hidden"></input>'+
  				  		'<input id="btn_editar" name="btn_editar" value="Editar" class="btn btn-block btn-primary" type="submit"></input></form></td>'+
  				  		'<td><form name="myform1" action="disponibilidadReferido.jsp" >'+
  				  		'<input name="dni" value= '+dni+' class="btn btn-block btn-primary" type="hidden"></input>'+
				  		'<input name="btn_disponibilidad" value="Disponibilidad" class="btn btn-block btn-primary" type="submit"></input></form></td>'+
  				  		'<td><form name="myform2" action="interesReferido.jsp" >'+
  				  		'<input name="dni" value= '+dni+' class="btn btn-block btn-primary" type="hidden"></input>'+
				  		'<input name="btn_interes" value="Interes" class="btn btn-block btn-primary" type="submit"></input></form></td>'+
  				  	    //'<td><button name="btn_eliminar" id="btn_eliminar" class="btn btn-danger">Eliminar</button> </td>'+
  				  	    '<td><input  onclick="eliminar('+id+')" value="Eliminar" class="btn form-control btn-danger" type="submit"> </td>'+
  				  		"</tr>");
  				  
				}
			}
        }
	});
}

	
function listarReferido() {
	$('#myTable tbody tr').remove();
	$.ajax({
        type: 'POST',
        url: '/TallerIntegradov0.1/ListarReferidoxDocente',
        data : {
			numdoc : $('#txtnumdoc').val()
		},
        success: function(data)
        {            	
        	var array = data.split("$");
        	//alert(array);
			//$('#table_disponibilidad').empty();
			if(data == "_"){
				alert("No hay registro de Docente Recomendado");
			}else{
				for (var i = 0; i < array.length -1; i++) {
					var id=array[i].split("=")[0];
					var dni = array[i].split("=")[2];
					var nombre = array[i].split("=")[3];
					var apepat = array[i].split("=")[4];
					var apemat = array[i].split("=")[5];
					var correo = array[i].split("=")[7];
  				    $('#myTable').append("<tr>" +
	  				  		"<td>"+dni+"</td>" +
	  				  		"<td>"+nombre+"</td>" +
	  				  		"<td>"+apepat+"</td>" +
	  				  		"<td>"+apemat+"</td>" +
	  				  		"<td>"+correo+"</td>" +
	  				  		'<td><form name="myform" action="editarReferido.jsp">'+
	  				  		'<input name="dni" value= '+dni+' class="btn btn-block btn-primary" type="hidden"></input>'+
	  				  		'<input id="btn_editar" name="btn_editar" value="Editar" class="btn btn-block btn-primary" type="submit"></input></form></td>'+
	  				  		'<td><form name="myform1" action="disponibilidadReferido.jsp" >'+
	  				  		'<input name="dni" value= '+dni+' class="btn btn-block btn-primary" type="hidden"></input>'+
  				  			'<input name="btn_disponibilidad" value="Disponibilidad" class="btn btn-block btn-primary" type="submit"></input></form></td>'+
	  				  		'<td><form name="myform2" action="interesReferido.jsp" >'+
	  				  		'<input name="dni" value= '+dni+' class="btn btn-block btn-primary" type="hidden"></input>'+
  				  			'<input name="btn_interes" value="Interes" class="btn btn-block btn-primary" type="submit"></input></form></td>'+
	  				  	    //'<td><button name="btn_eliminar" id="btn_eliminar" class="btn btn-danger">Eliminar</button> </td>'+
	  				  	    //'<td><button  onclick="eliminar('+id+')" name="btn_eliminar" id="btn_eliminar" class="btn btn-danger">Eliminar</button> </td>'+
	  				  	    '<td><input  onclick="eliminar('+id+')" value="Eliminar" class="btn form-control btn-danger" type="submit"> </td>'+
	  				  		"</tr>");

				}
			}
        }
		
		
 });
}

//$('#myTable').on('click', '#btn_eliminar', function(){
function eliminar(id){
	var hi= confirm("¿Esta seguro que desea eliminar?");
  	if (hi== true){
        $.ajax({
	        type: 'POST',
	        url: '/TallerIntegradov0.1/EliminarReferido',
	        data: {
	        	//numdoc: numdoc,
	        	//sem:sem
	        	id: id
		    },
	        success: function(data)
	        {
	        	if (data==="vacio"){
					alert("No se encontró el Interes");
				}else {
					//alert("Se eliminó correctamente");
					if($('.selectSem').val()=='0'){
						listarReferido();
					}
					else{
						buscarReferido();
					}
				}	
	        }
		});

  		//$(this).closest('tr').remove();
  		}
}
//});

</script>

	<script src="<%=request.getContextPath()%>/Recursos/main.js"></script>
    </body>
</html>
