<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
  <title>Ingreso al Sistema</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="icon" type="" href="<%=request.getContextPath()%>/Imagenes/Docentes/uni.ico">

  <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Login/login.css">
  <script src="<%=request.getContextPath()%>/JS/MD5/md5.js"></script>
</head>

<body>
	
	<div class="login-box col-md-offset-4">
  <div class="login-logo">
    <img src="<%=request.getContextPath()%>/Imagenes/Login/usmp.png" alt="">
  </div><br>
  <div class="login-box-body">
    <p class="login-box-msg">Identifiquese para iniciar sesión</p>

    <form action="<%=request.getContextPath()%>/ServletLogin" method="post">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Usuario" name="usuario">
        <span class="input-group-addon"><i class="fa fa-user"></i></span>
      </div><br>
      <div class="input-group">
        <input type="password" class="form-control" placeholder="Contraseña" name="contrasena" onkeyup="this.form.passve.value=md5(this.form.contrasena.value)">
        <input type="hidden" id="txtcontra" name="passve" class="form-control">
        <span class="input-group-addon"><i class="fa fa-key"></i></span>
      </div><br><br>
      <div class="row">
        <!-- /.col -->
        <div class="col-xs-6 col-xs-offset-3 ">
        	<strong style="color:red;">${message}</strong>
          <button type="submit" class="btn btn-primary btn-block btn-flat">Ingresar</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
    <br>
       <div class="row">
          <div class="col-xs-6 col-xs-offset-3 ">
            <a href="cambioContraseña.jsp"><button type="submit" class="btn btn-primary btn-block btn-flat" id="btnCambiarContraseña" name="btnCambiarContraseña">Cambiar Contraseña</button></a>
          </div>
       </div>
  <!-- /.login-box-body -->
 </div>
</div>
	
</body>
</html>