$(document).ready(function(){
	
	$.ajax({
        type: 'POST',
        url: '/TallerIntegradov0.1/ListarEscuelas',
        success: function(data)
        {
        	$('.selectEsc').append('<option value='+""+'>--Seleccionar--</option>');
        	var var1=data.split(":");
        	for (var i=0;i<var1.length-1;i++) {
			    var idescuela=var1[i].split("-")[0];
			    var descr=var1[i].split("-")[1];
			    $('.selectEsc').append('<option value="'+idescuela+'">'+descr+'</option>');
			}
        }
	});
	
	$.ajax({
	        type: 'POST',
	        url: '/TallerIntegradov0.1/ListarSemestres',
	        success: function(data)
	        {
	        	$('.selectSem').append('<option value='+""+'>--Seleccionar--</option>');
	        	var var1=data.split(":");
	        	for (var i=0;i<var1.length-1;i++) {
				    var varr1=var1[i].split("/")[0];
				    var varr2=var1[i].split("/")[1];
				    var varr3=var1[i].split("/")[2];
				    $('.selectSem').append('<option value="'+varr1+'">'+varr2+' - '+varr3+'</option>');
				}
	        }
	});
	
	var excelUpload = {

	           excelFile: null,

	           init: function() {

	        	   	document.getElementById("subirExcel").onclick = this.uploadExcel.bind(this);

	        	   	document.getElementById("txtarchivo").onchange = function(event) {
                   
	        	   		this.excelFile = event.target.files[0];
	        	   		
	                }.bind(this);
	            },

	            uploadExcel: function() {

	                var data = new FormData();
	                data.append("txtarchivo", this.excelFile);
	                this.subirAlServidor(data);

	            },

	            subirAlServidor: function(formData) {

	                xhr = new XMLHttpRequest();
	                var validacion = validarArchivo();	
	                if(validacion){
	                	xhr.open("post", "/TallerIntegradov0.1/SubirArchivo", true);
	                    xhr.send(formData);
	                    xhr.onreadystatechange = function() {
	                    	if (xhr.readyState == 4) {
	                    		alert("El archivo ha sido guardado en el sistema");
	                    	}
	                    };
	                }
	            }
	}
	
	function setearHoras(){
		$('.time').append('<option value=""></option>');
		$('.time').append('<option value="800">08:00</option>');
		$('.time').append('<option value="845">08:45</option>');
		$('.time').append('<option value="930">09:30</option>');
		$('.time').append('<option value="1015">10:15</option>');
		$('.time').append('<option value="1100">11:00</option>');
		$('.time').append('<option value="1145">11:45</option>');
		$('.time').append('<option value="1230">12:30</option>');
		$('.time').append('<option value="1315">13:15</option>');
		$('.time').append('<option value="1400">14:00</option>');
		$('.time').append('<option value="1445">14:45</option>');
		$('.time').append('<option value="1530">15:30</option>');
		$('.time').append('<option value="1615">16:15</option>');
		$('.time').append('<option value="1700">17:00</option>');
		$('.time').append('<option value="1745">17:45</option>');
		$('.time').append('<option value="1830">18:30</option>');
		$('.time').append('<option value="1915">19:15</option>');
		$('.time').append('<option value="2000">20:00</option>');
		$('.time').append('<option value="2045">20:45</option>');
		$('.time').append('<option value="2130">21:30</option>');
	}
	
	excelUpload.init();
	
	$('.btnImportar').on('click', function(){
		var cbo_semestre = $('#selectSemestre').val();
		var cbo_escuela = $('#selectEscuela').val();
		
		if (validarArchivo()) {

			if(cbo_semestre == "" && cbo_escuela == ""){
				alert("Seleccione el semestre y la escuela")
				return false;
			}
			if(cbo_semestre == ""){
				alert("Seleccione el semestre");
				return false;
			}
			if(cbo_escuela == ""){
				alert("Seleccione la escuela");
				return false;
			}
			
			alert("Iniciando Importación");
			
			ImportarExcel();
		}
	});	
	
	function ImportarExcel(){
			$.ajax({
				type: 'POST',
				url: '/TallerIntegradov0.1/ImportarExcel',
				data: { 
		        	semestre:$('#selectSemestre').val(),
		        	escuela:$('#selectEscuela').val()
		        },
				success: function(data){
					if(data == "0"){
						alert("El formato del horario no es correcto");
					}else{
						alert("El formato del horario es correcto");
						var contadorTabla=0;
						var var1=data.split("%");
						$('#tablaExcelBody').empty();
						limpiarDatosdelExcel();
		              	for (var i=0;i<var1.length-1;i++) {
		  				    var ciclo = var1[i].split("<>")[0];
		  				    var tur = var1[i].split("<>")[1];
		  				    var codcur = var1[i].split("<>")[2];
		  				    var codcurteo = var1[i].split("<>")[3];
		  				    var profesor = var1[i].split("<>")[4];
		  				    var curso = var1[i].split("<>")[5];
		  				    var desres = var1[i].split("<>")[6];
		  				    var codsec= var1[i].split("<>")[7];
		  				    var aula = var1[i].split("<>")[8];
		  				    var escuela = var1[i].split("<>")[9];
		  				    var numcre = var1[i].split("<>")[10];
		  				    var lunes = var1[i].split("<>")[11];
		  				    var martes = var1[i].split("<>")[12];
		  				    var miercoles = var1[i].split("<>")[13];
		  				    var jueves = var1[i].split("<>")[14];
		  				    var viernes = var1[i].split("<>")[15];
		  				    var sabado = var1[i].split("<>")[16];
		  				    var domingo = var1[i].split("<>")[17];
		  				    var index = var1[i].split("<>")[18];
		  				    var _ciclo = parseInt(ciclo) <= 10 ? ciclo : "Ele";
		  				    
		  				    		$('#tablaExcelBody').append("<tr id='fila"+contadorTabla+"' class='ciclo"+_ciclo+"' style='color:white;'>" +
		  				    				"<td >"+ciclo+"</td>" +
		  	  		  				  		"<td >"+profesor+"</td>" +
		  	  		  				  		"<td >"+curso+"</td>" +
		  	  		  				  		"<td >"+codsec+"</td>" +
		  	  		  				  		"<td >"+aula+"</td>" +
		  	  		  				  		"<td >"+escuela+"</td>" +
		  	  		  				  		"<td >"+lunes+"</td>" +
		  	  		  				  		"<td >"+martes+"</td>" +
		  	  		  				  		"<td >"+miercoles+"</td>" +
		  	  		  				  		"<td >"+jueves+"</td>" +
		  	  		  				  		"<td >"+viernes+"</td>" +
		  	  		  				  		"<td >"+sabado+"</td>" +
		  	  		  				  		"<td >"+domingo+"</td>" +
		  	  		  				  		"<td > <button class='fila' id="+index+" style='color:black'>Editar</button> </td>" +
		  	  		  				  		"</tr>");
		  				    contadorTabla++;
		  				}
					}
				}
			});
	}
	
	
	$('#tablaExcel').on('click','.fila',function(){
		$('.time option').remove();
		setearHoras();
		
		var id = $(this).attr('id');
		$('#nroFila').val(id);
//		alert(id);
		
		var filaSelec = $(this).closest('tr');
		
		var profesor = filaSelec.find('td:eq(1)').text();
		
		var curso = filaSelec.find('td:eq(2)').text();
		var codsec = filaSelec.find('td:eq(3)').text();
		var aula = filaSelec.find('td:eq(4)').text();
		var lunes = filaSelec.find('td:eq(6)').text();
		var martes = filaSelec.find('td:eq(7)').text();
		var miercoles = filaSelec.find('td:eq(8)').text();
		var jueves = filaSelec.find('td:eq(9)').text();
		var viernes = filaSelec.find('td:eq(10)').text();
		var sabado = filaSelec.find('td:eq(11)').text();
		var domingo = filaSelec.find('td:eq(12)').text();
		
		var lunes_ini = parseInt(lunes.substring(0,5).replace(":", ""));
		var lunes_fin = parseInt(lunes.substring(6,11).replace(":", ""));
		
		var martes_ini = parseInt(martes.substring(0,5).replace(":", ""));
		var martes_fin = parseInt(martes.substring(6,11).replace(":", ""));
		
		var miercoles_ini = parseInt(miercoles.substring(0,5).replace(":", ""));
		var miercoles_fin = parseInt(miercoles.substring(6,11).replace(":", ""));
		
		var jueves_ini = parseInt(jueves.substring(0,5).replace(":", ""));
		var jueves_fin = parseInt(jueves.substring(6,11).replace(":", ""));
		
		var viernes_ini = parseInt(viernes.substring(0,5).replace(":", ""));
		var viernes_fin = parseInt(viernes.substring(6,11).replace(":", ""));
		
		var sabado_ini = parseInt(sabado.substring(0,5).replace(":", ""));
		var sabado_fin = parseInt(sabado.substring(6,11).replace(":", ""));
		
		var domingo_ini = parseInt(domingo.substring(0,5).replace(":", ""));
		var domingo_fin = parseInt(domingo.substring(6,11).replace(":", ""));

		
//		console.log(codfac + "\n" + var01 + "\n" + cicest + "\n" + tur + "\n" + codcur + "\n" + codcurteo + "\n" + profesor + "\n" + curso + "\n"
//				+ desres + "\n" + codsec + "\n" + aula + "\n" + escuela + "\n" + numcre + "\n" + lunes + "\n" + martes + "\n" + miercoles + "\n"
//				+ jueves + "\n" + viernes + "\n" + sabado + "\n" + domingo );
		
//		$('#lunesIni option').val("");
//		$('#lunesFin option').val("");
//		$('#martesIni option').val("");
//		$('#martesFin option').val("");
//		$('#miercolesIni option').val("");
//		$('#miercolesFin option').val("");
//		$('#juevesIni option').val("");
//		$('#juevesFin option').val("");
//		$('#viernesIni option').val("");
//		$('#viernesFin option').val("");
//		$('#sabadoIni option').val("");
//		$('#sabadoFin option').val("");
//		$('#domingoIni option').val("");
//		$('#domingoFin option').val("");
		
		$('#lunesIni option[value='+lunes_ini+']').attr('selected',true);
		$('#lunesFin option[value='+lunes_fin+']').attr('selected',true);
		
		$('#martesIni option[value='+martes_ini+']').attr('selected',true);
		$('#martesFin option[value='+martes_fin+']').attr('selected',true);
		
		$('#miercolesIni option[value='+miercoles_ini+']').attr('selected',true);
		$('#miercolesFin option[value='+miercoles_fin+']').attr('selected',true);
		
		$('#juevesIni option[value='+jueves_ini+']').attr('selected',true);
		$('#juevesFin option[value='+jueves_fin+']').attr('selected',true);
		
		$('#viernesIni option[value='+viernes_ini+']').attr('selected',true);
		$('#viernesFin option[value='+viernes_fin+']').attr('selected',true);
		
		$('#sabadoIni option[value='+sabado_ini+']').attr('selected',true);
		$('#sabadoFin option[value='+sabado_fin+']').attr('selected',true);
		
		$('#domingoIni option[value='+domingo_ini+']').attr('selected',true);
		$('#domingoFin option[value='+domingo_fin+']').attr('selected',true);
		
//		$('#lunesIni').val(lunes.substring(0,5));
//		$('#lunesFin').val();
//		$('#martesIni').val(martes.substring(0,5));
//		$('#martesFin').val(martes.substring(6,11));
//		$('#miercolesIni').val(miercoles.substring(0,5));
//		$('#miercolesFin').val(miercoles.substring(6,11));
//		$('#juevesIni').val(jueves.substring(0,5));
//		$('#juevesFin').val(jueves.substring(6,11));
//		$('#viernesIni').val(viernes.substring(0,5));
//		$('#viernesFin').val(viernes.substring(6,11));
//		$('#sabadoIni').val(sabado.substring(0,5));
//		$('#sabadoFin').val(sabado.substring(6,11));
//		$('#domingoIni').val(domingo.substring(0,5));
//		$('#domingoFin').val(domingo.substring(6,11));
		
		$('#txtcurso').val(curso);
		$('#txtseccion').val(codsec);
		$('#txtaula').val(aula);
		
		$('#cboProfesor option').remove();
		
		var _profesor = profesor.split(",")[0].toUpperCase();
		var docente = _profesor.split(" ")[0].toUpperCase() + "" + _profesor.split(" ")[1].toUpperCase();
		var value_docente = docente.toString().toUpperCase();
 		console.log(value_docente);
 		 		
 		listarContratados(curso, codsec)
 		listarInteresados(curso, value_docente, profesor);
 		listarReferidos(curso);
		 		
		$('#cboProfesor option[value='+value_docente+']').attr('selected',true);
	});	
	
	function listarInteresados(_curso, _docente, profesor){
		$.ajax({
			type : 'POST',
			async : false,
			url : '/TallerIntegradov0.1/ListarInteresados',
			data : {
				curso:_curso
			},
			success : function(data){
//				$('#cboProfesor').append("<option value=" + _docente + ">" + profesor + "</option>");
				if(data == "0"){
					
				}else if(data == ""){
					
				}else{
					var array = data.split("%");
					for(var i = 0; i < array.length -1; i++){
						var _profesor = array[i].split(",")[0].toUpperCase();
						var docente = _profesor.split(" ")[0].toUpperCase() + "" + _profesor.split(" ")[1].toUpperCase();
						
						$('#cboProfesor').append("<option value=" + docente + ">" + array[i] + " (I)</option>");
					}
				}
			}
		});
	}
	
	function listarContratados(_curso, _seccion){
		$.ajax({
			type : 'POST',
			async : false,
			url : '/TallerIntegradov0.1/ListarContratados',
			data : {
				curso:_curso,
				seccion:_seccion
			},
			success : function(data){
				if(data == "0"){
					
				}else if(data == ""){
					
				}else{
						var _profesor = data.split(",")[0].toUpperCase();
						var docente = _profesor.split(" ")[0].toUpperCase() + "" + _profesor.split(" ")[1].toUpperCase();
						
						$('#cboProfesor').append("<option value=" + docente + ">" + data + " (C)</option>");
				}
			}
		});
	}
	
	function listarReferidos(_curso){
		$.ajax({
			type : 'POST',
			async : false,
			url : '/TallerIntegradov0.1/ListarReferidos',
			data : {
				curso:_curso
			},
			success : function(data){
				if(data == "0"){
					
				}else if(data == ""){
					
				}else{
					var array = data.split("%");
					for(var i = 0; i < array.length -1; i++){
						var _profesor = array[i].split(",")[0].toUpperCase();
						var docente = _profesor.split(" ")[0].toUpperCase() + "" + _profesor.split(" ")[1].toUpperCase();
						
						$('#cboProfesor').append("<option value=" + docente + ">" + array[i] + " (R)</option>");
					}
				}
			}
		});
	}
	
	$('.btnValidar').on('click', function(){
		var cbo_semestre = $('#selectSemestre').val();
		var cbo_escuela = $('#selectEscuela').val();
		
		if (validarArchivo()) {
			
			if ($('#tablaExcelBody tr').length  == 0) {
				alert("Seleccione y guarde el horario en el sistema");
				return false;
			}
			
			if(cbo_semestre == "" && cbo_escuela == ""){
				alert("Seleccione el semestre y la escuela")
				return false;
			}
			if(cbo_semestre == ""){
				alert("Seleccione el semestre");
				return false;
			}
			if(cbo_escuela == ""){
				alert("Seleccione la escuela");
				return false;
			}
			
			validarHorasxPlan();
		}
	});
	
	function validarHorasxPlan(){
		$.ajax({
			type : 'POST',
			url: '/TallerIntegradov0.1/ValidarExcel',
			data: { 
	        	semestre:$('#selectSemestre').val(),
	        	escuela:$('#selectEscuela').val()
	        },
			success : function(data){
				if(data == "0"){
					alert("Error al validar el horario");
				}else{
					if (data == "") {
						alert("Imposible validar el horario, revise el formato");
					}else{
						var array = data.split("%");
						$('#tablaErroresBody').empty();
						for(var i = 0; i < array.length - 1; i++){
							var sap = array[i].split("<>")[0];
							var sicat = array[i].split("<>")[1];
							var curso = array[i].split("<>")[2];
							var horas_excel = array[i].split("<>")[3];
							var horas_plan = array[i].split("<>")[4];
							var seccion = array[i].split("<>")[5];
							var resultado = array[i].split("<>")[6];
	
							$('#tablaErroresBody').append("<tr style='color: white;'>"+
												"<td>"+ sap +"</td>"+
												"<td>"+ sicat +"</td>"+
												"<td>"+ curso +"</td>"+
												"<td>"+ seccion +"</td>"+
												"<td>"+ horas_excel +"</td>"+
												"<td>"+ horas_plan +"</td>"+
												"<td>"+ resultado +"</td>"+
												"</tr>");
						}
					}
				}
				
			}
		});
	}
	
	
	
	$('.btnValidarDisp').on('click', function(){
		var cbo_semestre = $('#selectSemestre').val();
		var cbo_escuela = $('#selectEscuela').val();
		
		if (validarArchivo()) {
			
			if ($('#tablaExcelBody tr').length  == 0) {
				alert("Seleccione y guarde el horario en el sistema");
				return false;
			}
			
			if(cbo_semestre == "" && cbo_escuela == ""){
				alert("Seleccione el semestre y la escuela")
				return false;
			}
			if(cbo_semestre == ""){
				alert("Seleccione el semestre");
				return false;
			}
			if(cbo_escuela == ""){
				alert("Seleccione la escuela");
				return false;
			}
			
			ValidarDispDocente();
		}
	});
	
	function ValidarDispDocente(){
		$.ajax({
			type : 'POST',
			url: '/TallerIntegradov0.1/ValidarExcelDisp',
			data: { 
	        	semestre:$('#selectSemestre').val(),
	        	escuela:$('#selectEscuela').val()
	        },
			success : function(data){
				if(data=="0"){
					alert("Error al validar el horario");
				}else{
					if(data == ""){
						alert("Imposible validar el horario, revise el formato");
					}else{
						$('#tablaErroresDisponibilidadBody').empty();
						var array = data.split("/*");
						
						for(var i = 0; i < array.length - 1; i++){
							var docente = array[i].split("<>")[0];
							var lunes = array[i].split("<>")[1];
							var martes = array[i].split("<>")[2];
							var miercoles = array[i].split("<>")[3];
							var jueves = array[i].split("<>")[4];
							var viernes = array[i].split("<>")[5];
							var sabado = array[i].split("<>")[6];
							var domingo = array[i].split("<>")[7];
							var mensaje1 = array[i].split("<>")[8];
							var mensaje2 = array[i].split("<>")[9];
							var mensaje3 = array[i].split("<>")[10];
							var mensaje4 = array[i].split("<>")[11];
							var mensaje5 = array[i].split("<>")[12];
							var mensaje6 = array[i].split("<>")[13];
							var mensaje7 = array[i].split("<>")[14];
							var curso = array[i].split("<>")[15];
								
							if(mensaje1 == "Comparacion no Exitosa"){
								var men1="<td style='color : red;'>"+mensaje1+"</td>";
								//$('#men1').html("<td id=men1 style='color:red'>"+ mensaje1 +"</td>");
							}else if(mensaje1 == "Comparacion Exitosa"){
								var men1="<td style='color : green;'>"+mensaje1+"</td>";
							}else{
								var men1="<td>"+mensaje1+"</td>";
							}
							
							if(mensaje2 == "Comparacion no Exitosa"){
								var men2="<td style='color : red;'>"+mensaje2+"</td>";
								//$('#men1').html("<td id=men1 style='color:red'>"+ mensaje1 +"</td>");
							}else if(mensaje2 == "Comparacion Exitosa"){
								var men2="<td style='color : green;'>"+mensaje2+"</td>";
							}else{
								var men2="<td>"+mensaje2+"</td>";
							}
							
							if(mensaje3 == "Comparacion no Exitosa"){
								var men3="<td style='color : red;'>"+mensaje3+"</td>";
								//$('#men1').html("<td id=men1 style='color:red'>"+ mensaje1 +"</td>");
							}else if(mensaje3 == "Comparacion Exitosa"){
								var men3="<td style='color : green;'>"+mensaje3+"</td>";
							}else{
								var men3="<td>"+mensaje3+"</td>";
							}
							
							if(mensaje4 == "Comparacion no Exitosa"){
								var men4="<td style='color : red;'>"+mensaje4+"</td>";
								//$('#men1').html("<td id=men1 style='color:red'>"+ mensaje1 +"</td>");
							}else if(mensaje4 == "Comparacion Exitosa"){
								var men4="<td style='color : green;'>"+mensaje4+"</td>";
							}else{
								var men4="<td>"+mensaje4+"</td>";
							}
							
							if(mensaje5 == "Comparacion no Exitosa"){
								var men5="<td style='color : red;'>"+mensaje5+"</td>";
								//$('#men1').html("<td id=men1 style='color:red'>"+ mensaje1 +"</td>");
							}else if(mensaje5 == "Comparacion Exitosa"){
								var men5="<td style='color : green;'>"+mensaje5+"</td>";
							}else{
								var men5="<td>"+mensaje5+"</td>";
							}
							
							if(mensaje6 == "Comparacion no Exitosa"){
								var men6="<td style='color : red;'>"+mensaje6+"</td>";
								//$('#men1').html("<td id=men1 style='color:red'>"+ mensaje1 +"</td>");
							}else if(mensaje6 == "Comparacion Exitosa"){
								var men6="<td style='color : green;'>"+mensaje6+"</td>";
							}else{
								var men6="<td>"+mensaje6+"</td>";
							}
							
							if(mensaje7 == "Comparacion no Exitosa"){
								var men7="<td style='color : red;'>"+mensaje7+"</td>";
								//$('#men1').html("<td id=men1 style='color:red'>"+ mensaje1 +"</td>");
							}else if(mensaje7 == "Comparacion Exitosa"){
								var men7="<td style='color : green;'>"+mensaje7+"</td>";
							}else{
								var men7="<td>"+mensaje7+"</td>";
							}
							
							if(mensaje1 == ""){
								mensaje1 = "DNR";
							}
							if(mensaje2 == ""){
								mensaje2 = "DNR";
							}
							if(mensaje3 == ""){
								mensaje3 = "DNR";
							}
							if(mensaje4 == ""){
								mensaje4 = "DNR";
							}
							if(mensaje5 == ""){
								mensaje5 = "DNR";
							}
							if(mensaje6 == ""){
								mensaje6 = "DNR";
							}
							if(mensaje7 == ""){
								mensaje7 = "DNR";
							}
							
							$('#tablaErroresDisponibilidadBody').append("<tr style='color: white;'>"+
												"<td>"+ docente +"</td>"+
												"<td>"+ curso +"</td>"+
												"<td>"+ lunes +"</td>"+
												men1+
												"<td>"+ martes +"</td>"+
												men2+
												"<td>"+ miercoles +"</td>"+
												men3+
												"<td>"+ jueves +"</td>"+
												men4+
												"<td>"+ viernes +"</td>"+
												men5+
												"<td>"+ sabado +"</td>"+
												men6+
												"<td>"+ domingo +"</td>"+
												men7+
												"</tr>");
							
						}
					}
				}
			}
		});
	}
	
	$('#btnActualizar').on('click', function(){
		if(validarArchivo()){
			if($('#tablaExcelBody tr').length == 0){
				alert("Seleccione y guarde el horario en el sistema");
				return false;
			}
			if($('#txtcurso').val() == ""){
				alert("Seleccione un horario para modificar");
				return false;
			}
			ActualizarFila();
		}
	});
	
	function ActualizarFila(){
		var lunes_ini = $('#lunesIni').val();
		var lunes_fin = $('#lunesFin').val();
		
		var martes_ini = $('#martesIni').val();
		var martes_fin = $('#martesFin').val();
		
		var miercoles_ini = $('#miercolesIni').val();
		var miercoles_fin = $('#miercolesFin').val();
		
		var jueves_ini = $('#juevesIni').val();
		var jueves_fin = $('#juevesFin').val();
		
		var viernes_ini = $('#viernesIni').val();
		var viernes_fin = $('#viernesFin').val();
		
		var sabado_ini = $('#sabadoIni').val();
		var sabado_fin = $('#sabadoFin').val();
		
		var domingo_ini = $('#domingoIni').val();
		var domingo_fin = $('#domingoFin').val();
		
		lunes_ini = parseInt(lunes_ini) < 1000 ? "0" + lunes_ini : lunes_ini;
		lunes_fin = parseInt(lunes_fin) < 1000 ? "0" + lunes_fin : lunes_fin;
		
		martes_ini = parseInt(martes_ini) < 1000 ? "0" + martes_ini : martes_ini;
		martes_fin = parseInt(martes_fin) < 1000 ? "0" + martes_fin : martes_fin;
		
		miercoles_ini = parseInt(miercoles_ini) < 1000 ? "0" + miercoles_ini : miercoles_ini;
		miercoles_fin = parseInt(miercoles_fin) < 1000 ? "0" + miercoles_fin : miercoles_fin;
		
		jueves_ini = parseInt(jueves_ini) < 1000 ? "0" + jueves_ini : jueves_ini;
		jueves_fin = parseInt(jueves_fin) < 1000 ? "0" + jueves_fin : jueves_fin;
		
		viernes_ini = parseInt(viernes_ini) < 1000 ? "0" + viernes_ini : viernes_ini;
		viernes_fin = parseInt(viernes_fin) < 1000 ? "0" + viernes_fin : viernes_fin;
		
		sabado_ini = parseInt(sabado_ini) < 1000 ? "0" + lunes_ini : sabado_ini;
		sabado_fin = parseInt(sabado_fin) < 1000 ? "0" + sabado_fin : sabado_fin;
		
		domingo_ini = parseInt(domingo_ini) < 1000 ? "0" + domingo_ini : domingo_ini;
		domingo_fin = parseInt(domingo_fin) < 1000 ? "0" + domingo_fin : domingo_fin;
		
		var lunes = lunes_ini.substring(0, 2) + ":" + lunes_ini.substring(2, 4) + "-" + lunes_fin.substring(0, 2) + ":" + lunes_fin.substring(2, 4);
		var martes = martes_ini.substring(0, 2) + ":" + martes_ini.substring(2, 4) +"-" +  martes_fin.substring(0, 2) + ":" +  martes_fin.substring(2, 4);
		var miercoles = miercoles_ini.substring(0, 2) + ":" + miercoles_ini.substring(2, 4) + "-" +  miercoles_fin.substring(0, 2) + ":" + miercoles_fin.substring(2, 4); 
		var jueves = jueves_ini.substring(0, 2) + ":" + jueves_ini.substring(2, 4) + "-" + jueves_fin.substring(0, 2) + ":" + jueves_fin.substring(2, 4);
		var viernes = viernes_ini.substring(0, 2) + ":" + viernes_ini.substring(2, 4) + "-" + viernes_fin.substring(0, 2) + ":" + viernes_fin.substring(2, 4);
		var sabado = sabado_ini.substring(0, 2) + ":" + sabado_ini.substring(2, 4) + "-" + sabado_fin.substring(0, 2) + ":" + sabado_fin.substring(2, 4);
		var domingo = domingo_ini.substring(0, 2) + ":" + domingo_ini.substring(2, 4) + "-" + domingo_fin.substring(0, 2) + ":" + domingo_fin.substring(2, 4);
		
		console.log(lunes);
		console.log(martes);
		console.log(miercoles);
		console.log(jueves);
		console.log(viernes);
		console.log(sabado);
		console.log(domingo);
		
		if(lunes_ini == "" || lunes_fin == ""){
			lunes = "";
		}
		if(martes_ini == "" || martes_fin == ""){
			martes = "";
		}
		if(miercoles_ini == "" || miercoles_fin == ""){
			miercoles = "";
		}
		if(jueves_ini == "" || jueves_fin == ""){
			jueves = "";
		}
		if(viernes_ini == "" || viernes_fin == ""){
			viernes = "";
		}
		if(sabado_ini == "" || sabado_fin == ""){
			sabado = "";
		}
		if(domingo_ini == "" || domingo_fin == ""){
			domingo = "";
		}
		
		var profesor = $('#cboProfesor').val();
		var docente = $('#cboProfesor option[value=' + profesor + ']').text();
//		alert(docente);
//		return false;
		
		$.ajax({
			type : 'POST',
			async: false,
			url : '/TallerIntegradov0.1/ActualizarFila',
			data: {
				_profesor : docente,
				_index : $('#nroFila').val(),
				_lunes : lunes,
				_martes : martes,
				_miercoles : miercoles,
				_jueves : jueves,
				_viernes : viernes,
				_sabado : sabado,
				_domingo : domingo
			},
			success: function(data){
				if(data == "1"){
					alert('Horario Actualizado');
				}else{
					alert('Error en el proceso');
				}
			} 
		});
		$('#tablaErroresBody').empty();
		$('#tablaErroresDisponibilidadBody').empty();
		listarHorariosActualizados();
		
	}
	
	function listarHorariosActualizados(){
		$.ajax({
			type: 'POST',
			aync: false,
			url: '/TallerIntegradov0.1/ListarHorariosActualizados',
			data: { 
	        	semestre:$('#selectSemestre').val(),
	        	escuela:$('#selectEscuela').val()
	        },
			success: function(data){
				if(data == "0"){
					alert("El formato del horario no es correcto");
				}else{
					var contadorTabla=0;
					var var1=data.split("%");
					$('#tablaExcelBody').empty();
					limpiarDatosdelExcel();
	              	for (var i=0;i<var1.length-1;i++) {
	  				    var ciclo = var1[i].split("<>")[0];
	  				    var tur = var1[i].split("<>")[1];
	  				    var codcur = var1[i].split("<>")[2];
	  				    var codcurteo = var1[i].split("<>")[3];
	  				    var profesor = var1[i].split("<>")[4];
	  				    var curso = var1[i].split("<>")[5];
	  				    var desres = var1[i].split("<>")[6];
	  				    var codsec= var1[i].split("<>")[7];
	  				    var aula = var1[i].split("<>")[8];
	  				    var escuela = var1[i].split("<>")[9];
	  				    var numcre = var1[i].split("<>")[10];
	  				    var lunes = var1[i].split("<>")[11];
	  				    var martes = var1[i].split("<>")[12];
	  				    var miercoles = var1[i].split("<>")[13];
	  				    var jueves = var1[i].split("<>")[14];
	  				    var viernes = var1[i].split("<>")[15];
	  				    var sabado = var1[i].split("<>")[16];
	  				    var domingo = var1[i].split("<>")[17];
	  				    var index = var1[i].split("<>")[18];
	  				    var _ciclo = parseInt(ciclo) <= 10 ? ciclo : "Ele";
	  				    
	  				    		$('#tablaExcelBody').append("<tr id='fila"+contadorTabla+"' class='ciclo"+_ciclo+"' style='color:white;'>" +
	  				    				"<td >"+ciclo+"</td>" +
	  	  		  				  		"<td >"+profesor+"</td>" +
	  	  		  				  		"<td >"+curso+"</td>" +
	  	  		  				  		"<td >"+codsec+"</td>" +
	  	  		  				  		"<td >"+aula+"</td>" +
	  	  		  				  		"<td >"+escuela+"</td>" +
	  	  		  				  		"<td >"+lunes+"</td>" +
	  	  		  				  		"<td >"+martes+"</td>" +
	  	  		  				  		"<td >"+miercoles+"</td>" +
	  	  		  				  		"<td >"+jueves+"</td>" +
	  	  		  				  		"<td >"+viernes+"</td>" +
	  	  		  				  		"<td >"+sabado+"</td>" +
	  	  		  				  		"<td >"+domingo+"</td>" +
	  	  		  				  		"<td > <button class='fila' id="+index+" style='color:black'>Editar</button> </td>" +
	  	  		  				  		"</tr>");
	  				    contadorTabla++;
	  				}
				}
			}
		});
	}
	
	$('#cboCiclo').on('click',function(){
		if(validarArchivo()){
			if($('#tablaExcelBody tr').length == 0){
				alert("Seleccione y guarde el horario en el sistema");
				return false;
			}
				filtrarPorCiclo();
			}
	});
		
	function filtrarPorCiclo(){
		var $tabla = $('#tablaExcel');
		var valor = $('#cboCiclo').val();
		console.log(valor);
		if (valor){
			$('tbody tr.' + valor, $tabla).show();
			$('tbody tr:not(.' + valor + ')', $tabla).hide();
		}
		else{
			$('tbody tr', $tabla).show();
		}
	}
			
	$('.divArchivo').on('change', '#txtarchivo',function(){
		validarArchivo();
	});
	
	function validarArchivo(){
		var	archivo = document.getElementById('txtarchivo');
		var	nombre_archivo = archivo.value;
		
		var extensiones_permitidas = /(.xlsx|.xlsm|.xls|.xlsb|.xlsm)$/i;
		
		if(!extensiones_permitidas.exec(nombre_archivo)){
			alert('Debe de seleccionar un archivo Microsoft Excel');
			archivo.value = '';
			$('#spanInputFile').text('Importar Archivo .xlsx');
			return false;
		}else{
			return true;
		}
	}
	
	function limpiarDatosdelExcel(){
		$('#tablaErroresBody').empty();
		$('#tablaErroresDisponibilidadBody').empty();
		$('.time option').remove();
		$('#txtcurso').val('');
		$('#cboProfesor option').remove();
		$('#txtseccion').val('');
		$('#txtaula').val('');
		$('#nroFila').val('');
	}
});

function filtrarPorDocente(){
	var input, filter, table, tr, td, i;
	  input = document.getElementById("txtFiltrarDocente");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("tablaErroresDisponibilidadBody");
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

