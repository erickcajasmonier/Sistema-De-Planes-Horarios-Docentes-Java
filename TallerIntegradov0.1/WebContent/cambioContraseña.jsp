<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
  <title>Cambio de Contraseña</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="icon" type="" href="<%=request.getContextPath()%>/Imagenes/Docentes/uni.ico">

  <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Login/login.css">
  <script src="../Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
  <script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery-1.11.2.min.js"></script>
  <script src="<%=request.getContextPath()%>/JS/MD5/md5.js"></script>
  <script src="<%=request.getContextPath() %>/Recursos/Jquery/jquery.validate.js"></script>
</head>

<body>
	
	<div class="login-box col-md-offset-4">
  <div class="login-logo">
    <img src="<%=request.getContextPath()%>/Imagenes/Login/usmp.png" alt="">
  </div><br>
  <div class="login-box-body">
    <p class="login-box-msg">Identifiquese</p>

    <form action="" id="form1">
      <div class="input-group">
        <input type="text" class="form-control" id="txtusuario" placeholder="Usuario" name="usuario" required>
        <span class="input-group-addon"><i class="fa fa-user"></i></span>
      </div><br>
      <div class="input-group">
        <input type="password" class="form-control" id="txtcontraseña" name="pass" onkeyup="this.form.passve.value=md5(this.form.pass.value)" placeholder="Contraseña" required>
        <input type="hidden" id="txtcontra" name="passve" class="form-control">
        <span class="input-group-addon"><i class="fa fa-key"></i></span>
      </div><br>
      <div class="input-group">
        <input type="text" id="txtnueva" name="vieja" class="form-control" onkeyup="this.form.nueva.value=md5(this.form.vieja.value)" placeholder="Confirmra Contraseña" required>
        <input type="hidden" id="txtcontranueva" name="nueva" class="form-control">
        <span class="input-group-addon"><i class="fa fa-key"></i></span>
      </div><br><br>
      <div class="row">

        <!-- /.col -->
        <div class="col-xs-6">
          <button type="button" name="btnCambiar" class="btn btn-primary btn-block btn-flat" id="btnCambiar">Cambiar Contraseña</button>
        </div>
        <div class="col-xs-6 col">
            <a href="login.jsp"><button type="button" class="btn btn-primary btn-block btn-flat">Salir</button></a>  
        </div>
        <!-- /.col -->
      </div>
    </form>
  <!-- /.login-box-body -->
 </div>
</div>

<script type="text/javascript">
////////////////////////////////////
$('#btnCambiar').on('click', function(){ 
	 var var1	=	$("#txtusuario").val();
	 var var2   =   $("#txtcontra").val();
	 var var3   =   $("#txtcontranueva").val();
	 $("#form1").valid();
	 if($("#form1").valid()){  
        $.ajax({
	        type: 'POST',
	        url: '/TallerIntegradov0.1/VerificarUsuario',
	        data: {
		        	idusuario: var1,
                    password: var2
		        },
	        success: function(data)
	        {
	        	if (data==="vacio"){
					alert("No se encontró al Usuario");
				}else {
					alert("Usuario encontrado.");
					$.ajax({
			            type: 'POST',
			            url: '/TallerIntegradov0.1/CambiarContraseña',
			            data: { 
			            	
			            	idusuario       : var1,
			     			Password    	: var3
			   
				        },
			            success: function(data)
			            {
			            	if (data == 0){
			     				alert("Hubo un error, revisar campos obligarios.");
			     			}else {
			     				alert("Mensaje: "+"Su contraseña ha sido cambiada.");
			     	
			     			}	
			            }
			 		}); 
					
				}	
	        }
		});
      	
     } else {
        alert("Datos incompletos.");
        
     }
	 document.getElementById("txtusuario").value = "";
	 document.getElementById("txtcontraseña").value = "";
	 document.getElementById("txtcontra").value = "";
	 document.getElementById("txtcontranueva").value = "";
	 document.getElementById("txtnueva").value = "";
});
////////////////////////////////////////////////
$("#form1").validate({
		  rules: {
			usuario  :	{ required:true, minlength:2},
			pass	 :	{ required:true, minlength:6, maxlength:20},
			vieja    :	{ required:true, minlength:6, maxlength:20}		
		  },
		  messages: {
		  	usuario      :	{	required:"Ingrese su usuario"},
		  	pass   :   {   required:"Ingrese su contraseña antigua"},
			vieja  :	{	required:"Ingrese su contraseña nueva"}
		  }
});

////////////////////////////////////
</script>	
</body>
</html>