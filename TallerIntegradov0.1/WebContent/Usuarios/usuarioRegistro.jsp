<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Usuario Registro</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="../Imagenes/Planes/uni.ico">
        <link rel="stylesheet" href="../Recursos/bootstrap/bootstrap.css">
        <link rel="stylesheet" href="../Recursos/bootstrap/bootsnav.css">
        <link rel="stylesheet" href="../CSS/Docentes/docenteCompartido.css">
        <link rel="stylesheet" href="../Recursos/responsive.css" />  
        <script src="../Recursos/Jquery/jquery-1.11.2.min.js"></script>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/Recursos/datepicker/css/bootstrap-datepicker3.css">
        <script src="<%=request.getContextPath()%>/Recursos/datepicker/js/bootstrap-datetimepicker.js"></script>
        <script src="<%=request.getContextPath() %>/Recursos/datepicker/js/bootstrap-datepicker.min.js"></script> 
        <script src="../JS/MD5/md5.js"></script>
        <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery.validate.js"></script>

    </head>
    <style>
        td,label{
            color:white;
        }
    </style>

    <body data-spy="scroll" data-target=".navbar-collapse" onload="ejemplo2();">


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
                        
                        <a class="navbar-brand" href="#brand">

                            <img src="../Imagenes/Horarios/usmp.png" class="logo logo-display m-top-10" alt="">
                            <img src="../Imagenes/Horarios/usmp3.png" class="logo logo-scrolled" alt="">

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
                            <h4>Registro de Usuario</h4>
                            <hr>
                            <form id="form1" action="" >
                            <div class="panel-body">
                            <div class="row">
                                <div class="col-md-4" id="divReferido1">
                                    <p>Nombre(s)</p>
                                    <input type="text" id="txtnombre" name="txtnombre"  class="form-control onlytext" required >
                                </div>
                                <div class="col-md-4" id="divReferido1">
                                    <p>Apellido Paterno</p>
                                    <input type="text" id="txtapepat" name="txtapepat" class="form-control onlytext" required >
                                </div>
                                <div class="col-md-4" id="divReferido1">
                                    <p>Apellido Materno</p>
                                    <input type="text" id="txtapemat" name="txtapemat" class="form-control onlytext" required>
                                </div>
                                
                                
                            </div> 
                            <br>
                            <div class="row">
                                <div class="col-md-4" id="divReferidoDni">
                                    <p>N° de Documento</p>
                                    <input type="number" class="form-control" id="txtdni" name="txtdni" onKeyPress="return SoloNumeros(event);"  minlength="8" maxlength="11" required>
                                </div>
                                <div class="col-md-4" id="divReferido1">
                                    <p>E-mail</p>
                                    <input type="email" id="txtcorreo" name="txtcorreo" class="form-control" required>
                                </div>
                                <div class ="col-md-4" id="divReferido1">
                                    <p>Perfil</p>
                                    <select  class="form-control selectPer" id="selectPerfil" name="selectPerfil" required>
										<!-- 			  <option value="" selected disabled hidden>--Seleccionar--</option> -->
									</select>
                                </div>
                            </div></div><br>
                            <h4>Datos de Usuario</h4>
                            <hr>
                            <div class="row" id="divEscuelaCurso">
                                <div class="col-md-4" id="divReferido1">
                                    <p>Usuario</p>
                                    <input type="text" id="txtusuario" name="txtusuario"  class="form-control" disabled>
                                </div>
                                <div class="col-md-4" id="divReferido1">
                                    <p>Contraseña</p>
                                    <input type="password" id="txtcontra" name="pass" class="form-control" onkeyup="this.form.passve.value=md5(this.form.pass.value)" minlength="6" maxlength="20" required>
                                    <input type="hidden"   id="txtcontrae" name="passve" class="form-control">
                                </div>
                                <div class="col-md-4" id="divReferido1">
                                    <p>Confirmar Contraseña</p>
                                    <input type="password" id="txtconfcontra" name="txtconfcontra" class="form-control" minlength="6" maxlength="20" required>
                                </div>
                            </div><br><br>
                            <div class="row" id="">
                                <div class ="col-md-4" id="">
                                    <p>Escuela</p>
                                    <select  class="form-control selectEsc" id="selectEscuela" name="selectEscuela" required>
										<!-- 			  <option value="" selected disabled hidden>--Seleccionar--</option> -->
									</select>
                                </div>
                                <div class="col-md-4" id="divReferido1">
                                    <input type="hidden" id="txtusucreareg" value="<% out.print(session.getAttribute("dni")); %>" name="txtusuario" class="form-control">
                                </div>
                            </div><br><br><br>
                             <div class="row">
                                 <div class="col-md-4"></div>
                                 <div class="col-md-4"><input name="btn_guardar" id="btn_registrar" type="button" class="btn btn-success form-control" value="Registrar Usuario"></div>
                                <div class="col-md-4"><a href="usuario.jsp"> <input name="btn_cancelar" id="btn_cancelar" type="button" class="btn btn-danger form-control" value="Cancelar"></a></div>
                                
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
  
$(function () {
    $('#datetimepicker1').datetimepicker();
});
</script>	
<script>
function SoloNumeros(evt){
	 if(window.event){//asignamos el valor de la tecla a keynum
	  keynum = evt.keyCode; //IE
	 }
	 else{
	  keynum = evt.which; //FF
	 } 
	 //comprobamos si se encuentra en el rango numérico y que teclas no recibirá.
	 if((keynum > 47 && keynum < 58) || keynum == 8 || keynum == 13 || keynum == 6 ){
	  return true;
	 }
	 else{
	  return false;
	 }
	}

</script>
<script type="text/javascript"> 
var fecha=$('#txtfeccreareg');
var containercalendario=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
var options={
  format: 'yyyy/mm/dd',
  container: containercalendario,
  todayHighlight: true,
  autoclose: true,
};
fecha.datepicker(options);
/////////////////////////////////////////////////////////////////////
function ejemplo2() {
var aleatorio = Math.round(Math.random()*1001);
document.getElementById("txtusuario").value = "COD"+aleatorio;
}
////////////////////////////////////////////////////////////////////
$('#btn_registrar').on('click', function(){
	
	var contra1 = $('#txtcontra').val().trim();
	var contra2 = $('#txtconfcontra').val().trim();
	var dni     = $('#txtdni').val().trim();
	var vacio   = "";
	
	if($("#form1").valid())
	{
	 if((contra1==contra2)){
		var linea = []; 
	    var item={};
        item.txtusuario		=	$('#txtusuario').val().trim();
        item.txtdni         =   $('#txtdni').val().trim();
        item.txtcontra      = 	$('#txtcontrae').val().trim();
	    item.txtnombre		= 	$('#txtnombre').val().trim();
	    item.txtapepat      = 	$('#txtapepat').val().trim();
	    item.txtapemat      = 	$('#txtapemat').val().trim();
	    item.txtcorreo		= 	$('#txtcorreo').val().trim();//ponerlo tambien en el for del servlet
	    item.txtperfil      =   $('#selectPerfil').val();
	    item.txtescuela     =   $('#selectEscuela').val();
	    item.txtusucreareg  =   $('#txtusucreareg').val();

	    linea.push(item);    
	    //agregar lo de observaciones y los flags (pregrado, maestria, doctorado)
	    var datosxlinea={};
        datosxlinea.linea=linea;
        //mostrar en consola (para validar la cadena de texto)
        var datatable=JSON.stringify(datosxlinea);
        console.log(datatable);
        //

      $.ajax({
        type:'POST',
        url: '<%=request.getContextPath()%>/RegistrarUsuario',
        dataType:'JSON',
	    data:{
		      objetojson:JSON.stringify(datosxlinea)
		     },
        success: function(data) {
		    	 if(data == "1")
		    	 {
		    		 alert("Se registro el usuario");
		    		 document.getElementById("txtnombre").value = "";
		    		 document.getElementById("txtapepat").value = "";
		    		 document.getElementById("txtapemat").value = "";
		    		 document.getElementById("txtdni").value = "";
		    		 document.getElementById("txtcorreo").value = "";
		    		 document.getElementById("selectPerfil").value = "";
		    		 document.getElementById("selectEscuela").value = "";
		    		 document.getElementById("txtcontra").value = "";
		    		 document.getElementById("txtconfcontra").value = "";
		    		 document.getElementById("txtusuario").value="";
		    		 location.href="principalUsuarios.jsp"
		    		     setTimeout(location.href, 10000);
		    	 }
		    	 else
		    	 {
		    		 alert("Error, Usuario ya registrado!!!");
		    		 document.getElementById("txtnombre").value = "";
		    		 document.getElementById("txtapepat").value = "";
		    		 document.getElementById("txtapemat").value = "";
		    		 document.getElementById("txtdni").value = "";
		    		 document.getElementById("txtcorreo").value = "";
		    		 document.getElementById("selectPerfil").value = "";
		    		 document.getElementById("selectEscuela").value = "";
		    		 document.getElementById("txtcontra").value = "";
		    		 document.getElementById("txtconfcontra").value = ""; 
		    		 document.getElementById("txtusuario").value="";
		    	 }
			
		}     
		
        });
       
    }
	 else
     { 
	
	  alert("Contraseñas diferentes!!! Confirme contraseña");
      document.getElementById("txtcontra").value = "";
	  document.getElementById("txtconfcontra").value = "";
    }
   }
   else
   {
	 alert("Datos incompletos.");
	        
   }
	
});
/////////////////////////////////////////////////////////////////////
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
//////////////////////////////////////////////////////////////////////////		
   $(document).ready(function(){
			$.ajax({
	            type: 'POST',
	            url: '/TallerIntegradov0.1/ListarEscuelas',
	            success: function(data)
	            {            	
	            	$('.selectEsc').empty();
	            	$('.selectEsc').append('<option value="'+""+'">--Seleccionar--</option>');
	            	var var1=data.split(":");
	            	for (var i=0;i<var1.length-1;i++) {
	            		var varr1=var1[i].split("-")[0];
					    var varr2=var1[i].split("-")[1];
					    $('.selectEsc').append('<option value="'+varr1+'">'+varr2+'</option>');
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
			txtdni   :	{   required:true, minlength:8,maxlength:11},
			pass     :	{   required:true, minlength:6},
			txtconfcontra:  {required:true, minlength:6},
            txtcorreo    :  {required:true, minlength:5, maxlength:30},
            selectPerfil :  {required:true},
            txtfeccreareg : {required:true}
		  },
		  messages: {
            txtnombre: 	{	required:"Ingresar nombre.", minlength:"Minimo de caracteres es de 2."},
		  	txtapepat: 	{	required:"Ingresar Apellido Paterno.", minlength:"Minimo de caracteres es de 2."},
		  	txtapemat: 	{	required:"Ingresar Apellido Materno.", minlength:"Minimo de caracteres es de 2."},
		  	txtcorreo:  {   required:"Ingresar correo electronico.", minlength:"Minimo de caracteres es de 10"},
		  	txtdni         :    {	required:"Ingrese un valor", minlength:"Ingrese mínimo 8 digitos", maxlength:"Ingrese menos de 11 digitos"},
			pass           :	{	required:"Ingrese una contraseña.", minlength:"Contraseña muy corta"},
			txtconfcontra  :	{	required:"Ingrese su contraseña.", minlength:"Contraseña muy corta"},
			txtfeccreareg  :    {   required:"Ingrese una fecha"},
			selectPerfil   :    {   required:"Seleccione un Perfil"} 
        }
});	
	
	
	
	
	
	
//////////////////////////////////////////////////////////////////////
	
</script>

	<script src="<%=request.getContextPath()%>/Recursos/main.js"></script>
    </body>
</html>
