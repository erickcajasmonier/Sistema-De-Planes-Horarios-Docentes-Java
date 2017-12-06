<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <title>Validar Horario</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="../Imagenes/Horarios/uni.ico">

		<link rel="stylesheet" href="../Recursos/file-input.css">
        <link rel="stylesheet" href="../Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="../Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="../Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="../Recursos/bootstrap/bootsnav.css">
 	 	 	 	
        <link rel="stylesheet" href="../CSS/Horarios/horarioCompartido.css">

        <link rel="stylesheet" href="../Recursos/responsive.css" />

		<script src="../Recursos/Jquery/jquery-1.11.2.min.js"></script>
		
		<script type="text/javascript" src="../Recursos/js/custom-file-input.js" async></script>
        <script type="text/javascript" src="../Recursos/js/jquery.custom-file-input.js" async></script>	
		<script src="<%=request.getContextPath()%>/JS/Horarios/ValidarHorario.js"></script>
        <script src="../Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>

    <body data-spy="scroll" data-target=".navbar-collapse">


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
                <!--<div class="top-search">
                    <div class="container">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                            <input type="text" class="form-control" placeholder="Search">
                            <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
                        </div>
                    </div>
                </div> -->
                <!-- End Top Search -->

                <div class="container">    
                    <!-- Start Atribute Navigation -->
                    <!-- <div class="attr-nav">
                        <ul>
                            <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
                        </ul>
                    </div> -->       
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
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Horario
                                </a>
                                <ul class="dropdown-menu cart-list">
                                    <li>
                                        <h6><a href="<%=request.getContextPath()%>/Horarios/consultarHorario.jsp">Consultar Horario</a>
                                    </li>
                                    <li><h6><a href="<%=request.getContextPath()%>/Horarios/validarHorario.jsp">Validar Horario</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i></a>
                            	<ul class="dropdown-menu cart-list">
                                    <li>
                                        <h6><a href="../login.jsp">Cerrar Sesión</a>
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
                              <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-8">
                                            <div class="row divArchivo">
                                            <div class="col-md-5">
                                                <input class="txtArchivo inputfile inputfile-1" name="txtArchivo" type="file" id="txtarchivo" style="border-radius: 10px;border:1px solid">
                                                <label for="txtarchivo"><svg xmlns="http://www.w3.org/2000/svg" class="iborrainputfile" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"></path></svg>
                                                <span class="iborrainputfile" id="spanInputFile">Importar Archivo .xlsx</span></label>
                                                
                                            </div><div class="col-md-7">
                                            <input type="submit" class="btn btn-secondary" value = "Subir Archivo" name = "submit" id="subirExcel"></div></div><br>
                                            <div class="row">
                                            <div class="col-md-4 row">
                                                <div class="col-md-3">
                                                    <p >Escuela:</p>
                                                </div>
                                                <div class="col-md-9">
                                                <select class="form-control selectEsc" id="selectEscuela"></select>
                                                </div>
                                            </div>
                                            <div class="col-md-5 row">
                                                <div class="col-md-3">
                                                    <p >Semestre:</p>
                                                </div>
                                                <div class="col-md-9">
                                                    <select class="form-control selectSem" id="selectSemestre" >
													</select>
                                                </div>
                                            </div>
                                            <div class="col-md-3 row">
                                              <div class="col-md-3">
                                                <p  >Ciclo:</p> 
                                              </div>
                                              <div class="col-md-9">
                                                <select class="form-control" id="cboCiclo">
													<option value="">Todos</option>
													<option value="ciclo01">01</option>
													<option value="ciclo02">02</option>
													<option value="ciclo03">03</option>
													<option value="ciclo04">04</option>
													<option value="ciclo05">05</option>
													<option value="ciclo06">06</option>
													<option value="ciclo07">07</option>
													<option value="ciclo08">08</option>
													<option value="ciclo09">09</option>
													<option value="ciclo10">10</option>
													<option value="cicloEle">Electivos</option>
												</select>
											</div>
                                             </div>
                                        </div><br>

                                        <input type="button" class="btn btn-secondary btnImportar" value="Mostrar Horario Importado">
                                        <br><br><br>

                                        <div style="border:1px solid gray;border-radius: 4px;text-align: center;width:100%;overflow-x: auto;overflow-y: auto;height:400px" id="import">
                                        <table id="tablaExcel" class="table table-bordered" role="grid" aria-describedly="tabla_info">
											<thead> 
											<!-- MODIFICAR EL CSSSSSSSSSSSSSSSSSSSSSSSS -->
												  <tr role="row">
												  	<td style="text-align: center;" valign="middle">Ciclo</td>
													<td style="text-align: center;" valign="middle">Profesor</td>
													<td style="text-align: center;" valign="middle">Curso</td>
													<td style="text-align: center;" valign="middle">Sección</td>
													<td style="text-align: center;" valign="middle">Aula</td>
													<td style="text-align: center;" valign="middle">Escuelas</td>
													<td style="text-align: center;" valign="middle">Lunes</td>
													<td style="text-align: center;" valign="middle">Martes</td>
													<td style="text-align: center;" valign="middle">Miércoles</td>
													<td style="text-align: center;" valign="middle">Jueves</td>
													<td style="text-align: center;" valign="middle">Viernes</td>
													<td style="text-align: center;" valign="middle">Sábado</td>
													<td style="text-align: center;" valign="middle">Domingo</td>
													<td style="text-align: right;" valign="middle">Opción</td>					
												</tr>
												
											</thead>
											<tbody id="tablaExcelBody">
											</tbody>
										</table>
                                        </div><br><br>

                                        <div class="row">
                                            <div class="col-md-3">
                                              <input type="button" class="btn btn-secondary btnValidar" value="Validar Horas por plan">
                                            </div>
                                            <div class="col-md-3">
                                              <input type="button" class="btn btn-secondary btnValidarDisp" value="Validar disponibilidad docente">
                                            </div>
                                        </div>

                                        <br>

                                        <p>Lista de Errores de Planes</p>

                                        <div class="errores" style="border:1px solid gray;border-radius: 4px;text-align: center;height:205px;color:white;overflow-x:auto;overflow-y:auto;">
                                        <table id='tablaErrores' class='table table-bordered dataTable no-footer' class='tablaErrores' role='grid' aria-describedly='tabla_info' style='overflow-x: auto; white-space: nowrap; width: 100%;overflow-y: auto;'>
												<thead>
													<tr role='row'>
													  	<td style='text-align: center;' valign='middle'>SAP</td>
													  	<td style='text-align: center;' valign='middle'>SICAT</td>
														<td style='text-align: center;' valign='middle'>Curso</td>
														<td style='text-align: center;' valign='middle'>Sección</td>
														<td style='text-align: center;' valign='middle'>Horas Excel</td>
														<td style='text-align: center;' valign='middle'>Horas Plan</td>
														<td style='text-align: center;' valign='middle'>Resultado</td>
													</tr>
												</thead>
											<tbody id='tablaErroresBody' style='color:white;'>
											</tbody>
										</table>
                                        </div>
                                  </div>

                                  <aside class="col-md-4" style="border:1px solid gray;border-radius: 4px;height:1000px"><br>
                                        <p >Curso:</p> <input type="text" class="form-control" id="txtcurso" disabled><br>
                                        <p >Profesor:</p> 
                                        <select class="form-control" id="cboProfesor">
                                        </select>
                                        <br>
                                        <p >Cod.Seccion:</p> <input type="text" class="form-control" id="txtseccion" disabled><br>
                                        <p >Aula:</p> <input type="text" class="form-control" id="txtaula" disabled><br>
                                        <hr>

                                        <label>Dia</label><label for="" style="margin-left:27%">Inicio</label><label for="" style="margin-left:27%">Fin</label><hr>
                                        <br>

                                        <div class="row dia">
                                        <div class="col-md-4"><p >Lunes</p>
                                        </div>
                                        <div class="col-md-3">
                                        <select  class="day form-control time" style="width:90px"  id="lunesIni">
                                        </select>
                                        </div>
                                        <div class="col-md-1"><p >-</p> </div> 
                                        <div class="col-md-3">
                                        <select class="form-control time" style="width:90px"   id="lunesFin">
                                        </select>
                                        </div>
                                        </div><br>

                                        <div class="row dia">

                                        <div class="col-md-4"><p >Martes</p>
                                        </div>
                                        <div class="col-md-3">
                                        <select  class="day form-control time" style="width:90px"  id="martesIni">
                                        </select>
                                        </div>
                                        <div class="col-md-1"><p >-</p> </div> 
                                        <div class="col-md-3">
                                        <select class="form-control time" style="width:90px"   id="martesFin">
                                        </select>
                                        </div>
                                        </div><br>

                                        <div class="row dia">

                                         <div class="col-md-4"><p >Miercoles</p>
                                        </div>
                                        <div class="col-md-3">
                                        <select  class="day form-control time" style="width:90px"  id="miercolesIni">
                                        </select>
                                        </div>
                                        <div class="col-md-1"><p >-</p> </div> 
                                        <div class="col-md-3">
                                        <select class="form-control time" style="width:90px"   id="miercolesFin">
										</select>                                        
                                        </div>
                                        </div><br>

                                        <div class="row dia">

                                         <div class="col-md-4"><p >Jueves</p>
                                        </div>
                                        <div class="col-md-3">
                                        <select  class="day form-control time" style="width:90px"  id="juevesIni">
                                        </select>
                                        </div>
                                        <div class="col-md-1"><p >-</p> </div> 
                                        <div class="col-md-3">
                                        <select class="form-control time" style="width:90px"   id="juevesFin">
                                        </select>
                                        </div>
                                        </div><br>

                                        <div class="row dia">

                                         <div class="col-md-4"><p >Viernes</p>
                                        </div>
                                        <div class="col-md-3">
                                        <select  class="day form-control time" style="width:90px"  id="viernesIni">
                                        </select>
                                        </div>
                                        <div class="col-md-1"><p >-</p> </div> 
                                        <div class="col-md-3">
                                        <select class="form-control time" style="width:90px"   id="viernesFin">
                                        </select>
                                        </div>
                                        </div><br>

                                        <div class="row dia">

                                         <div class="col-md-4"><p >Sabado</p>
                                        </div>
                                        <div class="col-md-3">
                                        <select  class="day form-control time" style="width:90px"  id="sabadoIni">
                                        </select>
                                        </div>
                                        <div class="col-md-1"><p >-</p> </div> 
                                        <div class="col-md-3">
                                        <select class="form-control time" style="width:90px"  id="sabadoFin">
                                        </select>
                                        </div>
                                        </div><br>

                                        <div class="row dia">

                                        <div class="col-md-4"><p >Domingo</p>
                                        </div>
                                        <div class="col-md-3">
                                        <select  class="day form-control time" style="width:90px" id="domingoIni">
                                        </select>
                                        </div>
                                        <div class="col-md-1"><p >-</p> </div> 
                                        <div class="col-md-3">
                                        <select class="day form-control time" style="width:90px" id="domingoFin">
                                        </select>
                                        </div>
                                        </div><br><br><br>
                                        <input class="btn btn-primary form-control" id="btnActualizar" type="button" value="Modificar"></input><br><br>
                                        <input type="hidden" id="nroFila">
                                  </aside>
                              </div><br>	
                              <p>Lista de Errores de Disponibilidad Docente</p>
                              		<label>Docente:</label>
									<input type="text" class="form-control" id="txtFiltrarDocente" placeholder="Ingrese el nombre del docente" onkeyup="filtrarPorDocente()"><br>
                                        <div class="errores" style="border:1px solid gray;border-radius: 4px;text-align: center;height:205px;color:white;overflow-x:auto;overflow-y:auto;">
                                        <table id='tablaErroresDisponibilidad' class='table table-bordered dataTable no-footer' class='tablaErrores' role='grid' aria-describedly='tabla_info' style='overflow-x: auto; white-space: nowrap; width: 100%;overflow-y: auto;'>
												<thead>
													<tr role='row'>
													  	<td style='text-align: center;' valign='middle'>Docente</td>
													  	<td style='text-align: center;' valign='middle'>Curso</td>
													  	<td style='text-align: center;' valign='middle'>L</td>
														<td style='text-align: center;' valign='middle'>D.L</td>
														<td style='text-align: center;' valign='middle'>Ma</td>
														<td style='text-align: center;' valign='middle'>D. Ma</td>
														<td style='text-align: center;' valign='middle'>Mi</td>
														<td style='text-align: center;' valign='middle'>D. Mi</td>
														<td style='text-align: center;' valign='middle'>J</td>
														<td style='text-align: center;' valign='middle'>D. J</td>
														<td style='text-align: center;' valign='middle'>V</td>
														<td style='text-align: center;' valign='middle'>D. V</td>
														<td style='text-align: center;' valign='middle'>S</td>
														<td style='text-align: center;' valign='middle'>D. S</td>
														<td style='text-align: center;' valign='middle'>D</td>
														<td style='text-align: center;' valign='middle'>D. D</td>
													</tr>
												</thead>
											<tbody id='tablaErroresDisponibilidadBody' style='color:gray;'>
											</tbody>
										</table>
                                        </div>
                                        <br>
                                        <p>DNR = Disponibilidad No Registrada</p>
                                        <p>DDD = Dia Docente Disponible</p>
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
            <script src="../Recursos/main.js"></script>

    </body>
</html>
