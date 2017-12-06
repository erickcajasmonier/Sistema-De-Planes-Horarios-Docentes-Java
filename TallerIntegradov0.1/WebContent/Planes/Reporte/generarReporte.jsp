<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*" %>
<%@page import="util.Conexion"%>

<!DOCTYPE>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Reportes</title>
        <meta name="description" content="">
        <meta name="viewport" content="widtd=device-widtd, initial-scale=1">
        <link rel="icon" type="image/png" href="/TallerIntegradov0.1/Imagenes/Planes/uni.ico">


        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Planes/planesCompartido.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/responsive.css" />

        <script src="../Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>

    <body data-spy="scroll" data-target=".navbar-collapse" style="text-align: center;background-color: #3f1a18">

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

                            <img src="/TallerIntegradov0.1/Imagenes/Horarios/escudo3.png" class="logo logo-display m-top-10" alt="" width="174px" height="70px">
                <img src="/TallerIntegradov0.1/Imagenes/Horarios/usmp1.png" class="logo logo-scrolled" alt="" width="174px" height="60px">

                        </a>
                    </div>
                    <!-- End Header Navigation -->

                    <!-- Collect tde nav links, forms, and otder content for toggling -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <%Integer perfil = (Integer) session.getAttribute("perfil"); %>
                        <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                    	<%if(perfil == 1) {%> <!-- ADMINISTRADOR -->
							<li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletCurso?action=listarCurso">Cursos 
                                </a>
                            </li>                    
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/Planes/Reporte/generarReporte.jsp">Reportes
                                </a>
                            </li> 
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletSemestre?action=listarSemestre">Semestres
                                </a>
                            </li>
                           <%} %>
                           <%if(perfil == 2) {%>   <!-- DIRECTOR -->
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletPlanCurricular?action=listarPlanCurricular&idUsuario=${sessionScope.idUser}&idEscuela=${sessionScope.idSchool}">Planes Curriculares
                                </a>
                            </li>                     
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletSemestre?action=listarSemestre">Semestres
                                </a>
                            </li>
						   <%}%>
						   <%if (perfil == 5){ %>  <!-- OTROS -->
						   <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletCurso?action=listarCurso">Cursos 
                                </a>
                            </li>                    
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletPlanCurricular?action=listarPlanCurricular&idUsuario=${sessionScope.idUser}&idEscuela=${sessionScope.idSchool}">Planes Curriculares
                                </a>
                            </li>                     
                                            
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/Planes/Reporte/generarReporte.jsp">Reportes
                                </a>
                            </li> 
                           
						   <%}%>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>  
            </nav><br><br>
	<div class="container" style="border:0.7px solid;width:500px;margin:100px auto;border-radius: 7px;background-color: #fff">
		<form action="<%=request.getContextPath()%>/Reportes" method="post">
		<br>
			<%Conexion con1 = new Conexion();
    	  	ResultSet rs1 = con1.executeQuery("SELECT DESCRIPCION FROM ESCUELA");
    		%>
			<label for="" style="color:gray">Carrera Profesional:</label>
			<select required name="cboEscuela" id="cboEscuela" class="form-control">
				<option value="">Seleccione Escuela</option>
				<%while(rs1.next()){
				%> <option><%=rs1.getString(1)%></option> <%
				}%>			
			</select>
			<br>
			
				<%Conexion con2 = new Conexion();
		    	  ResultSet rs2 = con1.executeQuery("SELECT DISTINCT ANO FROM SEMESTRE");
		    	%>
			
			<label for="" style="color:gray">Seleccione Año:</label>
            <select required name="cboano" id="cboano" class="form-control">
            	<option value="">Seleccione Año</option>		
				<%while(rs2.next()){
				%> <option><%=rs2.getInt(1)%></option> <%
				}%>
            </select>
            <br>
            
            <%Conexion con3 = new Conexion();
	    	  ResultSet rs3 = con1.executeQuery("SELECT DISTINCT SEMESTRE FROM SEMESTRE");
	    	%>
            
            <label for="" style="color:gray">Semestre Académico:</label>
            <select required name="cbosemestre" id="cbosemestre" class="form-control">
            	<option value="">Seleccione Semestre</option>		
				<%while(rs3.next()){
				%> <option><%=rs3.getInt(1)%></option> <%
				}%>
            </select>
            <br>
            <label for="" style="color:gray">Seleccione Reporte a generar:</label>
            <select required name="accion" id="accion" class="form-control">
            	<option value="">Seleccione Reporte a Generar</option>
	    	   	<option value="reportepc">Reporte Plan Curricular</option>
	    		<option value="repoplanporhora">Reporte Plan por Horas</option>
	    	   	<option value=reposunedu>Reporte SUNEDU</option>
	    		<option value="reportejecutivo">Reporte Resumen Ejecutivo</option>
	    	</select>
            <br>
            <div class="checkbox-inline">
            <input type="checkbox" id="check1" name = "repodiferencias" style="border-color: black">
            <label for="check1" style="color:gray">Diferencias</label></div><br><br>
            <div class="row">
            	<!--  <div class="col-md-6">
            	<a class="btn btn-success form-control" href="<%=request.getContextPath()%>/Reportes" value="EXCEL" name="action"><i class="fa fa-file-excel-o"></i> &nbsp;Excel</a></div>
            	<div class="col-md-6">
            	<a  class="btn btn-danger form-control" href="<%=request.getContextPath()%>/Reportes" value="PDF" name="action"><i class="fa fa-file-pdf-o"></i> &nbsp;PDF</a></div>
            	-->
            	<input class="btn btn-danger" type="submit" name=action value="PDF"/>
    			<input class="btn btn-success" type="submit" name=action value="EXCEL"/>
            </div><br>
		</form>

	</div>
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
	<script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery-1.11.2.min.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.min.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/main.js"></script>
</body>
</html>