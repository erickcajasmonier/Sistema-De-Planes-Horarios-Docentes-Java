<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Editar - Eliminar Usuario</title>
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
        
        <script src="../Recursos/Jquery/jquery.validate.js"></script>
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
                        
                        <a class="navbar-brand" href="../index.jsp">

                            <img src="../Imagenes/Horarios/escudo3.png" class="logo logo-display m-top-10" alt="" width="174px" height="70px">
                            <img src="../Imagenes/Horarios/usmp1.png" class="logo logo-scrolled" alt="" width="174px" height="60px">

                        </a>
                    </div>
                    <!-- End Header Navigation -->

                    <!-- Collect tde nav links, forms, and otder content for toggling -->
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
      

            <section id="ayuda" class="" style="margin-left: 15%">
                <div class="container">
                       
                        <div class="main_service roomy-100" style="width:80%">
                            <h4>Buscar Usuario</h4>
                            <form action="" id="formEditarDocente" >
                           <div class="form-group col-lg-6 col-md-6" >
											<label class="col-sm-2 control-label" for="form-field-user">DNI:</label>
											<div class="col-sm-7">
												<input type="text" id="txtnumdoc" class="form-control" name="txtnumdoc" minlength="8" maxlength="11" required>
											</div>
											<div class="col-sm-2">
											   <button name="btn_buscar" id="btn_buscar" type="button" class="btn btn-primary">
                                                  <span  aria-hidden="true"></span>Buscar Usuario
                                               </button>
											</div>
						    </div><br><br><br><br>
                            <h4>Datos Personales</h4>
                           
                            <div class="panel-body">
                            <div class="row">
                                <div class="col-md-4" id="divReferido1">
                                    <p>Nombre(s)</p>
                                    <input type="text" id="txtnombre" class="form-control" >
                                </div>
                                <div class="col-md-4" id="divReferido1">
                                    <p>Apellido Paterno</p>
                                    <input type="text" id="txtapepat" class="form-control" >
                                </div>
                                <div class="col-md-4" id="divReferido1">
                                    <p>Apellido Materno</p>
                                    <input type="text" id="txtapemat" class="form-control" >
                                </div>
                                
                                
                            </div> 
                            <br>
                            <div class="row">
                                <div class="col-md-4" id="divReferido1">
                                    <p>E-mail</p>
                                    <input type="email" id="txtcorreo" class="form-control" >
                                </div>
                                <div class ="col-md-4" id="divReferido1">
                                    <p>Perfil</p>
                                    <select  class="form-control selectPer" id="selectPerfil" required>
										<!-- 			  <option value="" selected disabled hidden>--Seleccionar--</option> -->
									</select>
                                </div>
                            </div></div><br><br>
                            <h4>Datos de Usuario</h4>
                            <br>
                            <div class="row" id="divEscuelaCurso">
                                <div class="col-md-4" id="divReferido1">
                                    <p>Usuario</p>
                                    <input type="text" id="txtusuario" class="form-control" minlength="2" maxlength="20" required>
                                </div>
                                <div class="col-md-4" id="divReferido1">
                                    <p>Contraseña</p>
                                    <input type="password" id="txtcontra" class="form-control" minlength="6" maxlength="20" required>
                                </div>
                                <div class="col-md-4" id="divReferido1">
                                    <p>Confirmar Contraseña</p>
                                    <input type="password" id="txtconfcontra" class="form-control" minlength="6" maxlength="20" required>
                                </div>
                            </div><br><br><br>
                             <div class="row">
                                 <div class="col-md-4"><input name="btn_editar" id="btn_editar"     type="button" class="btn btn-primary form-control" value="Editar Usuario"></div>
                                 <div class="col-md-4"><input name="btn_eliminar" id="btn_eliminar" type="button" class="btn btn-danger form-control" value="Eliminar Usuario"></div>
                                
                                
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
//////////////////////////////////////////////////////////////////////
$('#btn_buscar').on('click', function(){ 
	 var var1	=	$("#txtnumdoc").val();
	 if(var1.length>=8){  
       alert("Datos Correctos.");
        $.ajax({
	        type: 'POST',
	        url: '/TallerIntegradov0.1/BuscarUsuario',
	        data: {
		        	nombreUsu:$('#txtnumdoc').val()
		        },
	        success: function(data)
	        {
	        	if (data==="vacio"){
					alert("No se encontró al Usuario");
				}else {
					alert("Usuario encontrado.");
					var listaNombres = data.split("-|");
					$("#txtusuario").val(listaNombres[0]);
					$("#txtcontra").val(listaNombres[2]);
					$("#txtnombre").val(listaNombres[3]);
					$("#txtapepat").val(listaNombres[4]);
					$("#txtapemat").val(listaNombres[5]);
					$("#txtcorreo").val(listaNombres[6]);
					//$("#txtnac").val(listaNombres[3]);
					var perfil=listaNombres[7];
					$('#selectPerfil option[value='+perfil+']').attr('selected',true);
					
				}	
	        }
		});
      	
     } else {
        alert("Datos incompletos.");
     }
	 
});	
/////////////////////////////////////////////////////////////////////
$('#btn_editar').on('click', function(){ 
	var flag = $("#formEditarDocente").valid();
	if (flag==true){
    	var parametro0= $("#txtusuario").val().trim();
 		var parametro1= $("#txtnumdoc").val();
 		var parametro2= $("#txtcontra").val().trim();
 		var parametro3= $("#txtnombre").val().trim();
 		var parametro4= $("#txtapepat").val().trim();
 		var parametro5= $("#txtapemat").val().trim();
 		var parametro6= $("#txtcorreo").val().trim();
 		var parametro7= $("#selectPerfil").val();
 		var parametro8= $("#txtconfcontra").val().trim();
 	  if(parametro2==parametro8){
 		$.ajax({
            type: 'POST',
            url: '/TallerIntegradov0.1/EditarUsuario',
            data: { 
            	idusuario		: parametro0,
     			nombreUsu    	: parametro1,
     			Password    	: parametro2,
     			nombre      	: parametro3,
     			ape_Pat  		: parametro4,	
     			ape_Mat      	: parametro5,
     			correoE         : parametro6,
     			perfil   		: parametro7,
     			
	        },
            success: function(data)
            {
            	if (data == 0){
     				alert("Hubo un error, revisar campos obligarios.");
     			}else {
     				alert("Mensaje: "+"Actualizacion satisfactoria.");
     				document.getElementById("txtnombre").value = "";
     				document.getElementById("txtapepat").value = "";
     				document.getElementById("txtapemat").value = "";
     				document.getElementById("txtcorreo").value = "";
     				document.getElementById("txtusuario").value = "";
     				document.getElementById("txtcontra").value = "";
     				document.getElementById("txtconfcontra").value = "";
     				document.getElementById("selectPerfil").value="";
     				document.getElementById("txtnumdoc").value="";
     			}	
            }
 		});   
	} 
 	 else
     { alert("Contraseñas diferentes!!! Confirme contraseña");
       document.getElementById("txtcontra").value = "";
 	   document.getElementById("txtconfcontra").value = "";
       }
 	 }else {
		alert("Datos incompletos.");
	}
	
 });  
/////////////////////////////////////////////////////////////////////
$('#btn_eliminar').on('click', function(){ 
	 var var1	=	$("#txtnumdoc").val();
       alert("Datos Correctos.");
        $.ajax({
	        type: 'POST',
	        url: '/TallerIntegradov0.1/EliminarUsuario',
	        data: {
		        	nombreUsu:var1,
		        },
	        success: function(data)
	        {
	        	if (data==="vacio"){
					alert("No se encontró al Usuario");
				}else {
					alert("Usuario Eliminado.");
					
				}	
	        }
		});
        document.getElementById("txtnombre").value = "";
			document.getElementById("txtapepat").value = "";
			document.getElementById("txtapemat").value = "";
			document.getElementById("txtcorreo").value = "";
			document.getElementById("txtusuario").value = "";
			document.getElementById("txtcontra").value = "";
			document.getElementById("txtconfcontra").value = "";
			document.getElementById("selectPerfil").value="";
			document.getElementById("txtnumdoc").value="";
});
////////////////////////////////////////////////////////////////////////
   $(document).ready(function(){
			$.ajax({
	            type: 'POST',
	            url: '/TallerIntegradov0.1/ListarPerfiles',
	            success: function(data)
	            {            	
	            	$('.selectPer').empty();
	            	$('.selectPer').append('<option value="'+""+'">--Seleccionar--</option>');
	            	var var1=data.split(":");
	            	for (var i=0;i<var1.length-1;i++) {
	            		var varr1=var1[i].split("/")[0];
					    var varr2=var1[i].split("/")[1];
					    $('.selectPer').append('<option value="'+varr1+'">'+varr2+'</option>');
					}
	            }
	          });
		});
		
		
	
////////////////////////////////////////////////////////////////////////
 $("#form1").validate({
          rules: {
 			txtnombre :	{	required:true, minlength:2 },
            txtapepat:	{   required:true, minlength:2 },
            txtapemat:	{   required:true, minlength:2 },
			txtdni   :	{   required:true, minlength:8,maxlength:8},
			txtcontra:	{   required:true, minlength:6},
			txtconfcontra: {required:true, minlength:6},
            txtcorreo:  {required:true, minlength:5, maxlength:30},
            selectPerfil: {required:true}
//			txtusuario:	{required:true,minlenght:1}
		  },
		  messages: {
            txtnombre: 	{	required:"Ingresar nombre.", minlength:"Minimo de caracteres es de 2."},
		  	txtapepat: 	{	required:"Ingresar Apellido Paterno.", minlength:"Minimo de caracteres es de 2."},
		  	txtapemat: 	{	required:"Ingresar Apellido Materno.", minlength:"Minimo de caracteres es de 2."},
		  	txtcorreo:  {   required:"Ingresar correo electronico.", minlength:"Minimo de caracteres es de 10"},
		  	txtdni:	    {	required:"Ingrese un valor", minlength:"Ingrese mínimo 8 digitos", maxlength:"Ingrese menos de 11 digitos"},
		  	txtusuario: {   required:"Ingrese un usuario."},
			txtcontra  :	{	required:"Ingrese una contraseña.", minlength:"Contraseña muy corta"},
			txtconfcontra  :	{	required:"Ingrese su contraseña.", minlength:"Contraseña muy corta"},
			selectPerfil: {required:"Seleccione un Perfil"}
        }
});	
	
	
	
	
	
	
//////////////////////////////////////////////////////////////////////
	
</script>

	<script src="<%=request.getContextPath()%>/Recursos/main.js"></script>
    </body>
</html>
