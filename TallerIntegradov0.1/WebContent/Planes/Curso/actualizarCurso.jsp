<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Curso</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="/TallerIntegradov0.1/Imagenes/Planes/uni.ico">
 
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
 <!-- Latest compiled and minified CSS -->

<!-- jQuery library -->
<script src="<%=request.getContextPath()%>/Recursos/Jquery/jquery-1.11.2.min.js"></script>
            <script src="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.js"></script>
            
<!-- Latest compiled JavaScript -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/CSS/Planes/planesCompartido.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Recursos/responsive.css" />

<script
	src="<%=request.getContextPath()%>/Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>
	 <link rel="icon" type="image/png" href="uni.ico">


        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/fonticons.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/fontawesome/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/bootstrap/bootsnav.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Planes/planesCompartido.css">
         <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Recursos/responsive.css" />

        <script src="<%=request.getContextPath()%>/Recursos/modernizer/modernizr-2.8.3-respond-1.4.2.min.js"></script>

<title>Editar Curso</title>
</head>
<body
	style="background: url(<%=request.getContextPath()%>/Imagenes/Planes/planesFnd.jpg) fixed ;"
	data-spy="scroll" data-target=".navbar-collapse">
	<!-- Preloader -->
	<!-- -->	<div id="loading">
		<div id="loading-center">
			<div id="loading-center-absolute">
				<div class="object" id="object_one"></div>
				<div class="object" id="object_two"></div>
				<div class="object" id="object_three"></div>
				<div class="object" id="object_four"></div>
			</div>
		</div>
	</div>   
	<!--End off Preloader -->
	<div class="culmn">
		<nav
			class="navbar navbar-default navbar-fixed no-background bootsnav">
		<!-- Start Top Search -->
		<div class="top-search">
			<div class="container">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-search"></i></span>
					<input type="text" class="form-control" placeholder="Search">
					<span class="input-group-addon close-search"><i
						class="fa fa-times"></i></span>
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

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-menu">
					<i class="fa fa-bars"></i>
				</button>

				<a class="navbar-brand" href="#brand"> 
				<img src="/TallerIntegradov0.1/Imagenes/Horarios/escudo3.png" class="logo logo-display m-top-10" alt="" width="174px" height="70px">
                <img src="/TallerIntegradov0.1/Imagenes/Horarios/usmp1.png" class="logo logo-scrolled" alt="" width="174px" height="60px">

				</a>
			</div>
			<!-- End Header Navigation -->
			<!-- Collect the nav links, forms, and other content for toggling -->
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
                           <%}else if(perfil == 2) {%>   <!-- DIRECTOR -->
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletPlanCurricular?action=listarPlanCurricular&idUsuario=${sessionScope.idUser}&idEscuela=${sessionScope.idSchool}">Planes Curriculares
                                </a>
                            </li>                     
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletSemestre?action=listarSemestre">Semestres
                                </a>
                            </li>
						   <%}else{ %>  <!-- OTROS -->
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
                            <li class="dropdown">
                                <a href="<%=request.getContextPath()%>/ServletSemestre?action=listarSemestre">Semestres
                                </a>
                            </li>
						   <%}%>
                        </ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		</nav>
		<section id="ayuda" class="">
		<% beans.Curso bean = (beans.Curso)request.getAttribute("curso"); %>
<form action="<%=request.getContextPath()%>/ServletCurso?action=actualizarCurso" method="post">
	<%if(bean!=null){%>
		<div class="container" style="color:white">
			<div class="main_service roomy-100"><br>
				<h3>Editar Curso:</h3>
				<hr>
				<div class="col-md-5 col-lg-5">
					
						<div style="text-align: left">

							<div class="row">
							<div style="display:none">
							<input type="text" name="id" value="<%=bean.getId() %>">
							</div>
		
								<div class="col-md-12" style="min-height: 60px">
									<div class="col-md-4">
										<h5>Código SAP</h5>
									</div>
									<div class="col-md-8">
										<input class="form-control" type="text" name="codigoSAP" maxlength=11 oninput="this.value=this.value.replace(/[^0-9]/g,'');"   value="<%=bean.getIdCurso() %>">
									</div>
								</div>
								<div class="col-md-12" style="min-height: 60px">
									<div class="col-md-6">
										<h5>Nombre del curso</h5>
									</div>
									<div class="col-md-6">
										<input class="form-control" type="text" name="nombreCurso"  value="<%=bean.getNombre()%>">
									</div>
								</div>
								<div class="col-md-12" style="min-height: 60px">
									<div class="col-md-6">
										<h5>Código Sicat</h5>
									</div>
									<div class="col-md-6">
										<input class="form-control" type="text" name="sicat" maxlength=6 oninput="this.value=this.value.replace(/[^0-9]/g,'');" value="<%=bean.getSicat()%>">
									</div>
								</div>
								<div class="col-md-12" style="min-height: 60px">
									<div class="col-md-6">
										<h5>Propietario</h5>
									</div>
									<div class="col-md-6">
										<select class="form-control" name="propietarioCurso">
											<div class="dropdown-menu">
												<option><%=bean.getNombrePropietario()%></option>
												<option class="dropdown-item">Departamento Académico</option>
												<option class="dropdown-item">Ingeniería de Computación y Sistemas</option>
												<option class="dropdown-item">Ingeniería Civil</option>
												<option class="dropdown-item">Ingeniería en Industrias Alimentarias</option>
												<option class="dropdown-item">Ingeniería Electrónica</option>
												<option class="dropdown-item">Ingeniería Industrial</option>
											</div>
										</select>
									</div>
								</div>

								<div class="col-md-12" style="min-height: 60px">
									<div class="col-md-6">
										<h5>Horas de teoria</h5>
									</div>
									<div class="col-md-6">
										<select id="htc" class="form-control" name="horateoriaCurso"
											onchange="calcularCreditos()">
											<option><%=bean.getHoraTeoria()%></option>
											<%
												for(int i=0;i<=12;i++){
											%>
											<option value="<%=i%>"><%=i%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="col-md-12" style="min-height: 60px">
									<div class="col-md-6">
										<h5>Horas de practica</h5>
									</div>
									<div class="col-md-6">
										<select id="hpc" class="form-control" name="horapracticaCurso"
											onchange="calcularCreditos()">
											<option><%=bean.getHoraPractica()%></option>
											<%
												for(int i=0;i<=12;i++){
											%>
											<option value="<%=i%>"><%=i%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>

								<div class="col-md-12" style="min-height: 60px">
									<div class="col-md-6">
										<h5>Horas de laboratorio</h5>
									</div>
									<div class="col-md-6">
										<select id="hlc" class="form-control"
											name="horalaboratorioCurso" onchange="calcularCreditos()">
											<option><%=bean.getHoraLaboratorio()%></option>
											<%
												for(int i=0;i<=12;i++){
											%>
											<option value="<%=i%>"><%=i%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								
								
								
								

							</div>
						</div>
					
				</div>
				<div class="col-md-2 col-lg-2">
				<p>
				</div>
				<div class="col-md-5 col-lg-5">
					<div class="col-md-12" style="min-height: 60px;">
						<div class="col-md-6">
							<h5>Créditos</h5>
						</div>
						<div class="col-md-6">
							<input value="<%=bean.getCredito()%>" class="form-control" id="creditos" type="text" readonly
								name="creditoCurso">
						</div>
					</div>
								<h4 style="text-align:center">Requisitos</h4>
					<div class="col-md-12" style="min-height: 60px;text-align:right">
						<div class="col-md-4">
							<h5>Requisito 1</h5>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" id="r1" name="requisitoCurso01" value="<%=bean.getRequisito01()%>">
						</div>
						<div class="col-md-2">
							<!-- Boton que llamará al modal -->
								<button type="button" class="btn btn-primary btn-sm"
									data-toggle="modal" data-target="#myModal">Buscar</button>
						</div>
						<!-- Modal -->
						
								<div id="myModal" class="modal fade" role="dialog"
									style="font-weight: normal;">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 STYLE="text-align: center; color: black;"
													class="modal-title">BUSCAR CURSO</h4>
											</div>
											<div class="modal-body">
												<div class="col-md-3"
													style="color: black; text-align: center">Busqueda
													por:</div>
												<div class="col-md-4">
													<input type="text" class="form-control" id="myInput"
														onkeyup="myFunction()" placeholder="Codigo">
												</div>
												<div class="col-md-4">
													<input type="text" class="form-control" id="myInput2"
														onkeyup="myFunction2()" placeholder="Nombre">
												</div>
												<table style="color: black;" id="myTable"
													class="table table-striped">
													<thead>
														<tr>
															<th
																style="width: 120px; text-align: center; color: black">Código

															
															</td>
															<th
																style="width: 190px; text-align: left; margin-left: 100px; color: black">Nombre
																del Curso
															</td>
															<th></th>
													</thead>
													<tbody>
														<% java.util.List<beans.Curso> lista = (java.util.List<beans.Curso>)request.getAttribute("lista");
															if(lista!=null){
															for(int i = 0; i<lista.size(); i++){beans.Curso bean2 = lista.get(i);		
														%>
														<tr>
															<td
																style="width: 120px; text-align: center; color: black"><%=bean2.getIdCurso()%></td>
															<td style="width: 160px; color: black"><%=bean2.getNombre()%></td>
															<td><input class="btn btn-block btn-danger"
																type="button" onclick="AgRequi('<%=bean2.getIdCurso()%>')"
																id="estado" type="button" class="" value="Agregar"></td>
															<%
																}
															%>
															<%
																}
															%>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>
								
								
								
					</div>						
							<div class="col-md-12" style="min-height: 60px;text-align:right">
						<div class="col-md-4">
							<h5>Requisito 2</h5>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" id="r2" name="requisitoCurso02"   value="<%=bean.getRequisito02()%>">
						</div>
						<div class="col-md-2">
							<!-- Boton que llamará al modal -->
								<button type="button" class="btn btn-primary btn-sm"
									data-toggle="modal" data-target="#myModal2">Buscar</button>
						</div>
						<div id="myModal2" class="modal fade" role="dialog"
									style="font-weight: normal;">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 STYLE="text-align: center; color: black;" class="modal-title">BUSCAR CURSO</h4>
											</div>
											<div class="modal-body">
												<div class="col-md-3" style="color: black; text-align: center">Busqueda por:</div>
												<div class="col-md-4">
													<input type="text" class="form-control" id="myInput" onkeyup="myFunction()" placeholder="Codigo">
												</div>
												<div class="col-md-4">
													<input type="text" class="form-control" id="myInput2" onkeyup="myFunction2()" placeholder="Nombre">
												</div>
												<table style="color: black;" id="myTable" class="table table-striped">
													<thead>
														<tr>
															<th style="width: 120px; text-align: center; color: black">Código</th>
															<th style="width: 190px; text-align: left; margin-left: 100px; color: black">Nombre del Curso</th>
															<th></th>
													</thead>
												<tbody>
														<% if(lista!=null){
															for(int i = 0; i<lista.size(); i++){beans.Curso bean2 = lista.get(i);		
														%>
														
														<tr>
															<td style="width: 120px; text-align: center; color: black"><%=bean2.getIdCurso()%></td>
															<td style="width: 160px; color: black"><%=bean2.getNombre()%></td>
															<td><input class="btn btn-block btn-danger"7
																type="button" onclick="AgRequi2('<%=bean2.getIdCurso()%>')" id="estado" type="button" class="" value="Agregar"></td>
															<%}%>
															<%}%>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>
						</div>	
					<div class="col-md-12" style="min-height: 60px;text-align:right">
						<div class="col-md-4">
							<h5>Requisito 3</h5>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" id="r3" name="requisitoCurso03"  value="<%=bean.getRequisito03()%>">
						</div>
						<div class="col-md-2">
							<!-- Boton que llamará al modal -->
								<button type="button" class="btn btn-primary btn-sm"
									data-toggle="modal" data-target="#myModal3">Buscar</button>
						</div>
						<div id="myModal3" class="modal fade" role="dialog"
									style="font-weight: normal;">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 STYLE="text-align: center; color: black;" class="modal-title">BUSCAR CURSO</h4>
											</div>
											<div class="modal-body">
												<div class="col-md-3" style="color: black; text-align: center">Busqueda por:</div>
												<div class="col-md-4">
													<input type="text" class="form-control" id="myInput" onkeyup="myFunction()" placeholder="Codigo">
												</div>
												<div class="col-md-4">
													<input type="text" class="form-control" id="myInput2" onkeyup="myFunction2()" placeholder="Nombre">
												</div>
												<table style="color: black;" id="myTable" class="table table-striped">
													<thead>
														<tr>
															<th style="width: 120px; text-align: center; color: black">Código</th>
															<th style="width: 190px; text-align: left; margin-left: 100px; color: black">Nombre del Curso</th>
															<th></th>
													</thead>
													<tbody>
														<% if(lista!=null){
															for(int i = 0; i<lista.size(); i++){beans.Curso bean3 = lista.get(i);		
														%>
														
														<tr>
															<td style="width: 120px; text-align: center; color: black"><%=bean3.getIdCurso()%></td>
															<td style="width: 160px; color: black"><%=bean3.getNombre()%></td>
															<td><input class="btn btn-block btn-danger" type="button" onclick="AgRequi3('<%=bean3.getIdCurso()%>')" id="estado" type="button" class="" value="Agregar"></td>
															<%}%>
															<%}%>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>
					</div>
					<div class="col-md-12" style="min-height: 60px">
						<div class="col-md-6">
							<h5>Corequisito</h5>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="corequisitoCurso">
						</div>
					</div>
					<div class="col-md-12" style="min-height: 60px">
						<div class="col-md-6">
							<h5>Requisito por crédito</h5>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="requisitocreditoCurso">
						</div>
						
					</div>
					<div>
							    <p style="text-align:center; color:red;">${message}</p>
							</div>
					 <input class="btn btn-success form-control" type="submit" value="Guardar Cambios"></div>
										
				</div>
			</div>
			<%}%>
		
</form>	
		</div>

		</section>
		<br> <br>


	</div>
<script>
function exito(){
	var nom =document.getElementsByName("nombreCurso")[0].value
	alert("Se registro el curso "+nom)
}
function calcularCreditos(){
	var hp=0;
	var ht=0;
	var hl=0;
	
	if(parseInt($("#hpc").val())>0){
		hp=parseInt($("#hpc").val());
	}
	if(parseInt($("#htc").val())>0){
		ht=parseInt($("#htc").val())
	}
	
	if(parseInt($("#hlc").val())>0){
		hl=parseInt($("#hlc").val());
	}
	//alert(ht+" y "+hp);
	var creditos= ht+(hp/2)+(hl/2);
	document.getElementById("creditos").value=creditos;
}
function myFunction() {
    // Variables
    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
	
	// Recorre las filas y esconde las que no concuerdan con el query
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
    // Variables
    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput2");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

	// Recorre las filas y esconde las que no concuerdan con el query
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
function AgRequi(a){
	var re = a;
	document.getElementById("r1").setAttribute('value',a);
	$('#myModal').modal('hide');
}function AgRequi2(b){
	var re2 = b.toString();
	document.getElementById("r2").setAttribute('value',b);
	$('#myModal2').modal('hide');
}
function AgRequi3(c){
	re3 = c.toString();
	document.getElementById("r3").setAttribute('value',c);
	$('#myModal3').modal('hide');
}

function buscarCursos(){
	
	var accion = "buscarcurso";
	var idecurso =document.getElementById("idcursos").value;
	
	if(idecurso.substr(0,1)==0){
		
		alert("El codigo SAP no puede iniciar con 0");
		return false;
		
	}else{
	
	if(idecurso.length>10 && idecurso.length<12){
	
    	if(idecurso.length==11){
	    	$.post("Curso",{
				
	    		accion:accion,
	    		idecurso:idecurso
	    		
	    	},function(response){
	    		if(response['object']!=null){
	    			$("#idcursos").removeClass("form-control-success");
	    			$("#idcursos").addClass("form-control-success");
	    			$("#existecurso").val("0");
		    		alert("El código ya existe ");
	    		}else{
	    			$("#idcursos").addClass("form-control-success");
	    			$("#idcursos").removeClass("form-control-danger");
	    			$("#existecurso").val("1");
	    			alert("El código está disponible");
	    		}
	    			
	    	});
    	}
    	
    	return true;
	}else{
		
		return false;
		}
	}
}
</script>
	<!-- JS includes -->

            <script src="<%=request.getContextPath()%>/Recursos/main.js"></script>
	
</body>
</html>