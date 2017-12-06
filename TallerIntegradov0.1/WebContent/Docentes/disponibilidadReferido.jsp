<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
 <meta charset="utf-8">
        <title>Disponibilidad Docente Recomendado</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="../Imagenes/Docentes/uni.ico">


        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Docentes/docenteCompartido.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/responsive.css" />

        <script src="<%=request.getContextPath()%>/Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        
        <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery.1.8.3.min.js"></script>
        <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery.validate.js"></script>
        
</head>
<body data-spy="scroll" data-target=".navbar-collapse">

		<form action="" id="form1">
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
                          <h4>Disponibilidad del Docente Recomendado:</h4><hr>
                          <br>
                            <p>Bienvenido ${sessionScope.profile} <strong>${sessionScope.username}</strong>.</p>
                          <%String dni; 
	                        dni=request.getParameter("dni"); %>
                          <div class="row">
                              <div class="col-md-6 col-lg-6">
                              <%if(perfil == 1) {%> <!-- ADMINISTRADOR -->
                              <div>
                                 <div class="row">
                                    <div class="col-md-6" id="divDocenteSem">
                                      <p>Semestre</p>
                                      <select 
										class="form-control selectSem" id="selectSemestre">
										<!-- <option value="" selected disabled hidden>--Seleccionar--</option> -->
									</select>
                                    </div>
                                    <div class="col-md-6" id="divDocenteDni" >               
                                      <p>Nº de Documento</p>
                                        <div class="row">
                                          <div class="col-md-9">
                                          <input value="<%out.print(dni);%>" type="text" id="txtnumdoc" name="txtnumdoc" class="form-control">
                                          </div>
                                          <div class="col-md-2">
                                          <button id ="btnBuscar" name="btnBuscar" type="button" class="btn btn-warning btn-lg">
							    			<i class="fa fa-search"></i>
							  			</button>
                                          </div>
                                        </div>
                                    </div>  
                                </div><br>
                                  <p>Nombre(s)</p>
                                  <input type="text" class="form-control" id="txtNombre" name="txtNombre" disabled><br>
								
								</div>
								<%}else if(perfil == 3) {%> <!-- DOCENTE -->
								<div style="display:none">
                                 <div class="row">
                                    <div class="col-md-6" id="divDocenteSem">
                                      <p>Semestre</p>
                                      <select 
										class="form-control selectSem" id="selectSemestre">
										<!-- <option value="" selected disabled hidden>--Seleccionar--</option> -->
									</select>
                                    </div>
                                    <div class="col-md-6" id="divDocenteDni" >               
                                      <p>Nº de Documento</p>
                                        <div class="row">
                                          <div class="col-md-9">
                                          <input value="<%out.print(dni);%>" type="text" id="txtnumdoc" name="txtnumdoc" class="form-control">
                                          </div>
                                          <div class="col-md-2">
                                          <button id ="btnBuscar" name="btnBuscar" type="button" class="btn btn-warning btn-lg">
							    			<i class="fa fa-search"></i>
							  			</button>
                                          </div>
                                        </div>
                                    </div>  
                                </div><br>
                                  <p>Nombre(s)</p>
                                  <input type="text" class="form-control" id="txtNombre" name="txtNombre" disabled><br>
								
								</div>
								<%}%>
								
                                  <div class="row">
                                      <div class="col-md-6">
                                      <p>Hora Inicio</p>
                                      <input type="time" class="form-control" id="timepicker1" name="timepicker1">
                                      </div>
                                      <div class="col-md-6">
                                      <p>Hora Fin</p>
                                      <input type="time" class="form-control" id="timepicker2" name="timepicker2">
                                      </div>
                                  </div><br><hr>

                                    <div class="form-group row">
                                        <div class="col-md-12" id="tb_sem">
                                            <table class="table" id="table_semana">
                                                <thead>
                                                    <tr id="tr1">
                                                        <th>Lunes</th>
                                                        <th>Martes</th>
                                                        <th>Miércoles</th>
                                                        <th>Jueves</th>
                                                        <th>Viernes</th>
                                                        <th>Sábado</th>
                                                        <th>Domingo</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                    	
                                                        <td><input type="checkbox" value="Lunes" id="1"
                                                            name="1"><label for="1"></label></td>
                                                        <td><input type="checkbox" value="Martes" id="2"
                                                            name="2"><label for="2"></label></td>
                                                        <td><input type="checkbox" value="Miercoles" id="3"
                                                            name="3"><label for="3"></label></td>
                                                        <td><input type="checkbox" value="Jueves" id="4"
                                                            name="4"><label for="4"></label></td>
                                                        <td><input type="checkbox" value="Viernes" id="5"
                                                            name="5"><label for="5"></label></td>
                                                        <td><input type="checkbox" value="Sabado" id="6"
                                                            name="6"><label for="6"></label></td>
                                                        <td><input type="checkbox" value="Domingo" id="7"
                                                            name="7"><label for="7"></label></td>  
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div><hr>


                                <div class="row">
                                  <div class="col-md-4">
                                  <button type="button" name="btn_cargar_disp" id="btn_cargar_disp" class="btn btn-primary form-control" >Cargar Disponibilidad</button>
								</div>
                                <div class="col-md-4"> 
                                	<button type="button" class="btn btn-danger form-control" id="btn_volver" value="Regresar">Regresar</button>
                                </div>
                                
                                </div>
                              </div>
                              <div class="col-md-5 col-md-offset-1">
                                   <div class="row">
                                    <div class="col-md-12">
                                        <!-- start: BASIC TABLE PANEL -->
                                            <div class="">
                                                <table class="table" id="table_disponibilidad">
                                                    <thead id="tr2">
                                                        <tr>
                                                            <th>Día</th>
                                                            <th>Hora Inicio</th>
                                                            <th>Hora Fin</th>
                                                            <th>Opciones</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="tbl_disponibilidad">
                                                    </tbody>
                                                </table>
                                            </div>
                                        <!-- end: BASIC TABLE PANEL -->
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
          </div>
		</form>

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
        

            <!-- JS includes -->

            <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery-1.11.2.min.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.min.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery.validate.js"></script>
            
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
            	buscarDisponibilidad();
	        }
	      });
		
		//$('#selectSemestre').val($('#selectSemestre > option:last').val());
		
		$("#form1").validate({
			  rules: { 	timepicker1:	{required:true, min:"08:00",max:"22:15"},
			  			timepicker2:	{required:true, min:"08:00",max:"22:15"}
			  },
			  messages: {
				  timepicker1: 	{	required:"Campo obligatorio",
					  				min:"Hora no válida.", max:"Hora no válida."},
				  
				  timepicker2: 	{	required:"Campo obligatorio",
					  				min:"Hora no válida.", max:"Hora no válida."}
			  }
		
		});
		
	});

////////////////////////////////////////////////////////////////////////////////////////////

	$('#divDocenteDni').on('click', '#btnBuscar', function(){
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
		//      	console.log(data);
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
$('body').on('click', '#btn_cargar_disp', function(){
	grabarDisponibilidad();
	//buscarDisponibilidad();
	setTimeout(buscarDisponibilidad, 700);
});
	
function restarHoras() {
	var inicio = $('#timepicker1').val();
	var fin = 	$('#timepicker2').val();
	var inicioMinutos = parseInt(inicio.substr(3,2));
	var inicioHoras = parseInt(inicio.substr(0,2));
	var finMinutos = parseInt(fin.substr(3,2));
		var finHoras = parseInt(fin.substr(0,2));
	if (finHoras>=inicioHoras){
		var transcurridoMinutos = finMinutos - inicioMinutos;
		var transcurridoHoras = finHoras - inicioHoras;
		  if (transcurridoMinutos < 0) {
		    transcurridoHoras--;
		    transcurridoMinutos = 60 + transcurridoMinutos;
		  }
		  horas = transcurridoHoras.toString();
		  minutos = transcurridoMinutos.toString();
		  if (horas.length < 2) {
		    horas = "0"+horas;
		  }
		  if (minutos.length < 2) {
		    minutos = "0"+minutos;
		  }
		  if(parseInt(horas)==0 && parseInt(minutos)<45){
			  alert("Hora no válida, la diferencia de horas debe ser mínimo de 45 minutos.");
			  return false;
		  }
		  //alert(horas+" "+minutos);
		  return true;
		  //document.getElementById("resta").value = horas+":"+minutos;
	}
	else{
		alert("Hora no válida");
		return false;
	}
};
////////////////////////////////////////////////////////////////////////////////////////////
function grabarDisponibilidad(){
		
		if($("#form1").valid()){ 
			
			if(restarHoras()){	
				$('#tb_sem :checked').each(function() {	
					var dia = $(this).val();
					var c=0;
					var vacio=1;
					
					$('#tbl_disponibilidad tr').each(function(el) {
				    	var xdia="";
				    	xdia= $(this).closest('tr').find("td").filter(":eq(0)").text();
				    	if(xdia==dia){
				    		var hi0="";hf0="";hi1="";hf1="";
				    		hi0=$(this).closest('tr').find("td").filter(":eq(1)").text().substr(0,2)+
				            $(this).closest('tr').find("td").filter(":eq(1)").text().substr(3,2);
				    		
				    		hf0=$(this).closest('tr').find("td").filter(":eq(2)").text().substr(0,2)+
				            $(this).closest('tr').find("td").filter(":eq(2)").text().substr(3,2);
				    		
				    		hi1=$('#timepicker1').val().substr(0,2)+$('#timepicker1').val().substr(3,2);
				    		hf1=$('#timepicker2').val().substr(0,2)+$('#timepicker2').val().substr(3,2);
				    		
				    		if(parseInt(hf1)<parseInt(hi0)){
				    			//c=0;
				    			
				    		}else if(parseInt(hi1)>parseInt(hf0)){
				    			
				    			//c=0;
				    			
				    		}else{
				    				c++;
				    		}
				    		
				    	}
				    	vacio=0;
					});
					
					if(c==0 || vacio==1){
						var linea = [];
		    		    var itemOrden = {};
		    			itemOrden.cod_docente	= $('#txtnumdoc').val();
		    			//itemOrden.dia	 		= $(this).val();
		    			itemOrden.dia	 		= dia;
		    			console.log($(this).val());
		    			itemOrden.hora_ini		= $('#timepicker1').val().substr(0,2)+$('#timepicker1').val().substr(3,2);
		    			itemOrden.hora_fin		= $('#timepicker2').val().substr(0,2)+$('#timepicker2').val().substr(3,2);
		    			itemOrden.cod_semestre	= $('#selectSemestre').val();
		    			linea.push(itemOrden);
		    			
		    		    var datosxlinea={};
		    		    datosxlinea.linea=linea;
		    		       
		    		    var datatable=JSON.stringify(datosxlinea);
		    		    console.log(datatable);
		    			
		    			$.ajax({
		    				type:'POST',
		    				url :'<%=request.getContextPath()%>/RegistrarDisponibilidadReferido',
		    				dataType:'JSON',
		    				data:{
		    					 objetojson:JSON.stringify(datosxlinea)
		    					 },
		    				success: function(data){
		    					if(data == "1"){
		    						//alert("Se registró correctamente.");
		    						//buscarDisponibilidad();
		    						
		    					}else{
		    						alert("Error al registrar");
		    					}
		    				}
		    			});
		    			
					}
					else{
						alert("Día y/o hora no válida.");
					}
					

				});
				
			}
			
			$('input').filter(':checkbox').prop('checked',false);
			$('#timepicker1').val('');
			$('#timepicker2').val('');
		}
}
////////////////////////////////////////////////////////////////////////////////////////////
	
$('#table_disponibilidad').on('click', '#btn_eliminar', function(){
	var hi= confirm("¿Esta seguro que desea eliminar?");
  	if (hi== true){
        var dia ="", horini="", horfin="";
        dia=$(this).closest('tr').find("td").filter(":eq(0)").text();
        horini=$(this).closest('tr').find("td").filter(":eq(1)").text().substr(0,2)+
        $(this).closest('tr').find("td").filter(":eq(1)").text().substr(3,2);
        horfin=$(this).closest('tr').find("td").filter(":eq(2)").text().substr(0,2)+
        $(this).closest('tr').find("td").filter(":eq(2)").text().substr(3,2);
  		var numdoc	=	$("#txtnumdoc").val();
  		var sem = $('.selectSem').val() ;
  		//var var1=numdoc+sem+horini+horfin+dia+"";
  		//console.log(var1);
        $.ajax({
	        type: 'POST',
	        url: '/TallerIntegradov0.1/EliminarDisponibilidadReferido',
	        data: {
	        	numdoc : numdoc,
	        	sem: sem,
	        	horini: horini,
	        	horfin: horfin,
	        	dia:dia
		    },
	        success: function(data)
	        {
	        	if (data==="vacio"){
					alert("No se encontró el Interes");
				}else {
					//alert("Se eliminó correctamente");
					buscarDisponibilidad();
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

	////////////////////////////////////////////////////////////////////////////////////////////

	$('#divDocenteDni').on('change', '#txtnumdoc', function(){
		buscarDisponibilidad();
	});
	////////////////////////////////////////////////////////////////////////////////////////////

	$('#divDocenteSem').on('change', '.selectSem', function(){
		buscarDisponibilidad();
	});
	////////////////////////////////////////////////////////////////////////////////////////////

	function buscarDisponibilidad() {
		$('#table_disponibilidad tbody tr').remove();
		
		$.ajax({
	        type: 'POST',
	        url: '/TallerIntegradov0.1/ListarDisponibilidadxReferido',
	        data : {
				numdoc : $('#txtnumdoc').val(),
				sem: $('.selectSem').val()
				//semestre : 
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