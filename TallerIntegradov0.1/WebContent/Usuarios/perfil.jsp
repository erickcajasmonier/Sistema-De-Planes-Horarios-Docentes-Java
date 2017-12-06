<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
 <meta charset="utf-8">
        <title>Perfil</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/Imagenes/Planes/uni.ico">


        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Docentes/docenteCompartido.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/responsive.css" />

        <script src="<%=request.getContextPath()%>/Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
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
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Usuarios 
                                </a>
                                <ul class="dropdown-menu cart-list">
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Usuarios/usuarioRegistro.jsp">Registrar Usuario</a></h6>
                                    </li>
                                    <li>
                                    	<h6><a href="<%=request.getContextPath()%>/Usuarios/editarEliminarUsuario.jsp">Mantener Usuario</a></h6>
                                    </li>
                                    <li>
                                        <h6><a href="<%=request.getContextPath()%>/Usuarios/perfil.jsp">Perfiles</a></h6>
                                    </li>
                                </ul>

                            </li>                 
                            
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>  
            </nav><br><br>
      

            <section id="ayuda" class="">
                <div class="container">

                        <div class="main_service roomy-100">
                          <h4>Perfiles:</h4><hr>
                          <div class="row">
                              <div class="col-md-6 col-lg-6">
                                 <div class="row">
                                    <div class="col-md-6">
                                      <label for="selectPerfil">Nombre</label>
                                      <select
										class="form-control selectPer" id="selectPerfil">
										<option value="">---Seleccione---</option>
										<option value="Acreedor">Acreedor</option>
										<option value="Administrador">Administrador</option>
										<option value="Coordinador de Escuela">Coordinador de Escuela</option>
										<option value="Docente">Docente</option>
										<option value="Rol Escalafon">Rol Escalafon</option>
										<!-- 			  <option value="" selected disabled hidden>--Seleccionar--</option> -->
									  </select>
                                    </div>
                                </div><br>
                                <div class="form-group" id="tb_sem">
								<div id="divPerfil1" class="col-lg-12 col-md-12" >
								 <br>
								 <label for="selectPerfil">Permisos</label>	
								 <br>
								 <div class="col-lg-12 nopadding" id="selectPermisos">
								 <br>
								   <div class="col-lg-6">
							             <input type="checkbox"  id="idPermisos" name="idPermisos" value="Administrar Semestre"><label>Administrar Semestre</label><br><br>
							             <input type="checkbox"  id="idPermisos" name="idPermisos" value="Administrar Curso"><label>Administrar Curso</label><br><br>
							             <input type="checkbox"  id="idPermisos" name="idPermisos" value="Consultar Horario"><label>Consultar Horarios</label><br><br>
							             <input type="checkbox"  id="idPermisos" name="idPermisos" value="Admistrar Plan Curricular"><label>Administrar Plan Curricular</label><br><br>
							             <input type="checkbox"  id="idPermisos" name="idPermisos" value="Registrar Interes Docente"><label>Registrar Interes Docente</label><br><br>
							             <input type="checkbox"  id="idPermisos" name="idPermisos" value="Asignar Curso a Docente"><label>Asignar Curso a Docente</label><br><br>               
								   </div>  
								   <div class="col-lg-6">
								         <label>Reportar Plan Curricular</label> <input type="checkbox"  id="idPermisos" name="idPermisos" value="Plan Curricular"><br><br>
								         <label>Validar Horarios</label> <input type="checkbox"  id="idPermisos" name="idPermisos" value="Validar Horario"><br><br>
								         <label>Mantener Docente</label> <input type="checkbox"  id="idPermisos" name="idPermisos" value="Mantener Docente"><br><br>
							             <label>Administrar Referido</label> <input type="checkbox"  id="idPermisos" name="idPermisos" value="Administrar Referido"><br><br> 
							             <label>Reportar Formato C9</label> <input type="checkbox"  id="idPermisos" name="idPermisos" value="Reporte C9"><br><br> 
								   </div>
								 </div>
							    </div><br>
							</div><br>
                                <div class="row">
                                  <div class="col-md-4"><input type="button" name="btn_cargar_perfil"
										id="btn_cargar_perfil" class="btn btn-primary form-control" value="Cargar Perfil"></div>
                                 <div class="col-md-4"><input name="btn_guardar" id="btn_guardar" type="button" class="btn btn-success form-control" value="Guardar"></div>
                                <div class="col-md-4"> <input name="btn_cancelar" id="btn_cancelar" type="button" class="btn btn-danger form-control" value="Cancelar"></div>
                                
                                </div>


                              </div>



                              <div class="col-md-6 col-lg-6">
                                   <div class="row">
				                         <div class="col-md-12">
					                     <!-- start: BASIC TABLE PANEL -->
					                       <div class="panel panel-default">
						                     <div class="panel-body">
						                        <center><label>Lista de Perfiles</label></center>
							                        <table class="table table-hover" id="table_perfil">
								                    <thead>
									                 <tr>
										               <th>Perfil</th>
										               <th>Permisos</th>
										               <th></th>
										               <th>Opciones</th>
									                </tr>
								                   </thead>
								                   <tbody id="tbl_disponibilidad">


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

////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////Validar horas/////////////////////////////////////////////////////////////////
	//$('body').on('change', '#timepicker2', function(){

//window.onload = timer;

//function timer() {
//	console.log("cargando timer");
//	$('#timepicker1').timepicker();
//	$('#timepicker2').timepicker();

//}

	////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////
//	$('#btn_cargar_disp').click(function() {
//$('#btn_cargar_disp').on('click', function() {

	$('#btn_cargar_perfil').click(function() {
							var perfil    = $('#selectPerfil').val();
						    var permiso   = new Array();
						    var arregloPermisos = document.getElementsByName("idPermisos");
						    var seleccionados = "";
						    var vacio="";
						    var i=0;
							for(x=arregloPermisos.length; i<x; i++)
				             {
								 if(arregloPermisos[i].checked){
                                     seleccionados += arregloPermisos[i].value + " - ";
								 }
				             }
						if(perfil=="" && seleccionados==""){
							alert("Ingrese Campos Obligatorios!!")
						}
						else{
						    if(perfil=="")
						    {    alert("Ingrese Perfil!!");
						         document.getElementById("selectPerfil").value = "";
						         for (i=0; i<arregloPermisos.length; i++){
						        	 arregloPermisos[i].checked = false;
						        	 }
						    }
						    else{
						    	if(seleccionados=="")
						    	{   alert("Ingrese Permisos!!");
						    	    document.getElementById("selectPerfil").value = "";		            
						    	}
						    	else{
							    $('#table_perfil').append(
										        '<tr><td>'
										        +perfil+'</td><td>'
												+ seleccionados
												+ '</td><td></td><td class="center"><div class="visible-md visible-lg hidden-sm hidden-xs"><button name="btn_eliminar" id="btn_eliminar" type="button" class="btn btn-danger"> <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Eliminar</button><button name="btnBuscarPermisos" id="btnBuscarPermisos" type="button" class="btn btn-info form-control"> <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Editar</button></div></td></tr>')
						    	}
						    }
						}
						document.getElementById("selectPerfil").value = "";
				         for (i=0; i<arregloPermisos.length; i++){
				        	 arregloPermisos[i].checked = false;
				        	 }
							//console.log(t_semana);				
		});

////////////////////////////////////////////////////////////////////////////////////////////
	$('#table_perfil').on('click', '#btn_eliminar', function(){
			var hi= confirm("Eliminar seleccionado?");
		    if (hi== true){
		        //alert("Eliminado");
		        $(this).closest('tr').remove();
		      var countFilas = $('#btn_eliminar tr').length;
		  //
		    }
		});
////////////////////////////////////////////////////////////////////////////////////////////
	
////////////////////////////////////////////////////////////////////////////////////////////
$('body').on('click', '#btn_guardar', function(){//si realiza el registro
			var linea = [];
		    $('#tbl_disponibilidad tr').each(function(el) {
		    	var itemOrden = {};
		    	var tds = $(this).find("td");
		    	itemOrden.nombre    = tds.filter(":eq(0)").text();
		    	itemOrden.permisos	= tds.filter(":eq(1)").text();
		    	linea.push(itemOrden);
			});
		    	var datosxlinea={};
		    	datosxlinea.linea=linea;
                
		    	var datatable=JSON.stringify(datosxlinea);
		    	console.log(datatable);
		    	
	        	
		    	$.ajax({
					type:'POST',
					url :'<%=request.getContextPath()%>/RegistrarPerfil',
					dataType:'JSON',
					data:{
						 objetojson:JSON.stringify(datosxlinea)
						 },
					statusCode:{
						404: function(){
//							alert("Pagina no encontrada.");
							console.log("Pagina no encontrada.");
						},
						500:function(){
//							alert("Seleccione un tipo de docente valido.");
//							$('select[name=selectDocente] option').remove();s
							console.log("Error en servidor.");
						}
					},
					success: function(data){
						if(data == "1"){
							alert("Se registró los permisos en el sistema");
						}else{
							alert("Error al registrar");
						}
					}
				})

		}); 
	
////////////////////////////////////////////////////////////////////////////////////////////

</script>
		<script src="<%=request.getContextPath()%>/Recursos/main.js"></script>
    </body>
</html>