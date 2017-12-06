<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Disponibilidad Recomendado</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="../Imagenes/Planes/uni.ico">

		
		<!-- <script src="../Recursos/Jquery/jquery-1.11.2.min.js"></script> -->
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script> 
		 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		
        <link rel="stylesheet" href="../Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="../Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="../Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="../Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="../CSS/Docentes/docenteCompartido.css">

        <link rel="stylesheet" href="../Recursos/responsive.css" />
        

        <script src="../Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        
        <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery.validate.js"></script>
        
        <!-- <script src="../Recursos/bootstrap/bootstrap.min.js"></script>
             -->
        
		<script src="../Recursos/bootstrap/bootsnav.js"></script>
		
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
                            <h4>Consulta Disponibilidad de Docentes Recomendados</h4>
                            <br>
                            <p>Bienvenido ${sessionScope.profile} <strong>${sessionScope.username}</strong>.</p>
	                            <br>
	                            <div class="row">
		                          
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
                           <!-- <div style="overflow-x: auto;overflow-y: auto;height: 250px;border:1px solid gray;border-radius:7px" class="form-group" id="tabla_Intereses">--> 
                           <div style="overflow-x:auto;overflow-y:auto;height:400px;border:1px solid gray;border-radius:7px">
                            <table id="myTable" class="table">
								   <thead>
									    <tr>
									      <th style="text-align:center">DNI</th>
									      <th style="text-align:center">Apellido Paterno</th>
									      <th style="text-align:center">Apellido Materno</th>
									      <th style="text-align:center">Nombre</th>
									      <th style="text-align:center">Correo</th> 
									      <th style="text-align:center">Opciones</th>    
										</tr>
								     </thead>
								      
								     <tbody id="tbl">
								       
								     </tbody>
					    	</table>
					    	
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
        
<!-- Modal <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->

                            <!-- Button trigger modal -->
							
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="myModalLabel">Disponibilidad del Docente Recomendado</h4>
							      </div>
							      <div class="modal-body">
							        <table class="table" id="table_disponibilidad">
									        	<thead id="tr2">
				                                	<tr>
				                                    <th style="text-align:center">Día</th>
				                                    <th style="text-align:center">Hora Inicio</th>
				                                    <th style="text-align:center">Hora Fin</th>
				                                    </tr>
			                                    </thead>
			                                    <tbody id="tbl_disponibilidad">
			                                    </tbody>
			                          </table>   
							      </div>
							      <div class="modal-footer">
							      </div>
							    </div>
							  </div>
							</div>
                            <!-- Modal -->
            <!-- JS includes -->

            
	
<script type="text/javascript"> 

$(document).ready(function(){
	listarReferido();
	
	$.ajax({
        type: 'POST',
        url: '/TallerIntegradov0.1/ListarSemestres',
        success: function(data)
        {            	
        	$('.selectSem').empty();
        	$('.selectSem').append('<option value="'+""+'">Semestre</option>');
        	var var1=data.split(":");
        	for (var i=0;i<var1.length-1;i++) {
        		var varr1=var1[i].split("/")[0];
			    var varr2=var1[i].split("/")[1];
			    var varr3=var1[i].split("/")[2];
			    $('.selectSem').append('<option value="'+varr1+'">'+varr2+' - '+varr3+'</option>');
			    ultimosem=varr1;
			}
        	$('#selectSemestre').val(ultimosem);
        	buscarDisponibilidad();
        }
      });
	
});
$('#divReferidoDni').on('change', '#txtnumdoc', function(){

});
////////////////////////////////////////////////////////////////////////////////////////////

$('#divDocenteSem').on('change', '.selectSem', function(){

});
////////////////////////////////////////////////////////////////////////////////////////////

$('body').on('click', '#btn_modal', function(e){
	var numdoc=$(this).closest('tr').find("td").filter(":eq(0)").text();
	var sem = $('.selectSem').val();
	buscarDisponibilidad(numdoc, sem);
    $('#myModal').modal('show');
      
      
});
////////////////////////////////////////////////////////////////////////////////////////////

function buscarDisponibilidad(numdoc, sem) {
	$('#table_disponibilidad tbody tr').remove();
	
	$.ajax({
        type: 'POST',
        url: '/TallerIntegradov0.1/ListarDisponibilidadxReferido',
        data : {
			numdoc : numdoc,
			sem: sem
		},
        success: function(data)
        {            	
        	var array = data.split("$");
        	//alert(array);
			//$('#table_disponibilidad').empty();
			if(data == "_"){
				alert("No hay registro de Disponibilidad");
			}else{
				for (var i = 0; i < array.length -1; i++) {
					var dia = array[i].split("=")[0];
					var hor_ini = array[i].split("=")[1];
					
					if(hor_ini.length==4){
						hor_ini=hor_ini.substr(0,2)+":"+hor_ini.substr(2,2);
					}else{
						hor_ini="0"+hor_ini.substr(0,1)+":"+hor_ini.substr(1,2);
					}
					
					var hor_fin = array[i].split("=")[2];
					
					if(hor_fin.length==4){
						hor_fin=hor_fin.substr(0,2)+":"+hor_fin.substr(2,2);	
					}
					else{
						hor_fin="0"+hor_fin.substr(0,1)+":"+hor_fin.substr(1,2);
					}
					//alert(dia+" "+hor_ini+" "+hor_fin+"");
					
					
  				    $('#table_disponibilidad').append("<tr>" +
	  				  		"<td>"+dia+"</td>" +
	  				  		"<td>"+hor_ini+"</td>" +
	  				  		"<td>"+hor_fin+"</td>" +
	  				  		"</tr>");
				}
			}
        }
		
 });
}

////////////////////////////////////////////////////////////////////////////////////////////

function listarReferido() {
	$('#myTable tbody tr').remove();
	$.ajax({
        type: 'POST',
        url: '/TallerIntegradov0.1/ListarReferido',
        data : {
		},
        success: function(data)
        {            	
        	var array = data.split("$");
			if(data == "_"){
				alert("No hay registro de Docentes");
			}else{
				for (var i = 0; i < array.length -1; i++) {
					var id 	= array[i].split("=")[0];
					var numdoc 	= array[i].split("=")[1];
					var apepat = array[i].split("=")[2];
					var apemat = array[i].split("=")[3];
					var nombre = array[i].split("=")[4];
					var correo=array[i].split("=")[5];
					
  				    $('#myTable').append("<tr>" +
	  				  		"<td>"+numdoc+"</td>" +
	  				  		"<td>"+apepat+"</td>" +
	  				  		"<td>"+apemat+"</td>" +
	  				  		"<td>"+nombre+"</td>" +
	  				  		"<td>"+correo+"</td>" +
	  				  		//'<td><form name="myform1" action="disponibilidadDocente.jsp" >'+
	  				  		//'<input name="dni" value= '+numdoc+' class="btn btn-block btn-primary" type="hidden"></input>'+
					  		//'<input name="btn_disponibilidad" value="Disponibilidad" class="btn btn-block btn-primary" type="submit"></input></form></td>'+
					  		//'<td><button id="btn_modal"  type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#miModal">Abrir modal</button></td>'+
					  		'<td><button id="btn_modal"  type="button" class="btn btn-primary" >Ver Disponibilidad</button></td>'+
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
