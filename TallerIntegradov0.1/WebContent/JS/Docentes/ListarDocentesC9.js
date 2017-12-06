$(document).ready(function() {

	//yyyy-mm-dd
	
	//SELECT * FROM WHERE DATEFORMAT(COLDATE,'%Y-%m-%d') = ?
	
$('#btnGenerarReporte').click(function(){ 
	
	
	if($('#txtfecha').val() == ""){
		alert('Ingrese una fecha valida');
	}
	else{
		alert('Mostrando docentes');
		$.ajax({
			type : 'POST',
			url : '/TallerIntegradov0.1/ListarDocentesC9',
			data : {
				fecha : $('#txtfecha').val()
			},
			success : function(data) {
				var array = data.split("$");
				$('#tableBody').empty();
				if(data == "_"){
					alert("No hay registro de Docentes");
				}else{
					for (var i = 0; i < array.length -1; i++) {
						var apepat = array[i].split("=")[0]; 
	  				    var apemat  = array[i].split("=")[1];
	  				    var nombres = array[i].split("=")[2];
	  				    var nacionalidad = array[i].split("=")[3];
	  				    var numdoc = array[i].split("=")[4];
	  				    var fecing = array[i].split("=")[5];
	  				    var ley = array[i].split("=")[6] == "1" ? "SI" : "NO";
	  				    var sunedu = array[i].split("=")[7] == "1" ? "SI" : "NO";
	  				    var mayorgrado = array[i].split("=")[8];
	  				    var menciongrado= array[i].split("=")[9];
	  				    var univ = array[i].split("=")[10];
	  				    var paisuniv = array[i].split("=")[11];
	  				    var pregrado = array[i].split("=")[12] == "1" ? "SI" : "NO";
	  				    var maestria = array[i].split("=")[13] == "1" ? "SI" : "NO";
	  				    var doctorado = array[i].split("=")[14] == "1" ? "SI" : "NO";
	  				    var sl01 = array[i].split("=")[15] == "1" ? "SI" : "NO"; 
	  				    var sl02 = array[i].split("=")[16] == "1" ? "SI" : "NO";
	  				    var sl03 = array[i].split("=")[17] == "1" ? "SI" : "NO";
	   				    var categoria = array[i].split("=")[18];
	  				    var regimen = array[i].split("=")[19];
	  				    var horaclase = array[i].split("=")[20];
	  				    var otrasact = array[i].split("=")[21];
	  				    var totalhoras = array[i].split("=")[22];
	  				    var investigador = array[i].split("=")[23] == "1" ? "SI" : "NO";
	  				    var dina = array[i].split("=")[24] == "1" ? "SI" : "NO";
	  				    var semestre = array[i].split("=")[25];
	  				    var observ = array[i].split("=")[26] == "null" ? "Ninguno" : "Ninguno";
	  				    var escuela = array[i].split("=")[27];
	  				    var email = array[i].split("=")[28];
	  				    var telefono = array[i].split("=")[29];
	  				    
	  				    $('#example1').append("<tr>" +
		  				  		"<td>"+apepat+"</td>" +
		  				  		"<td>"+apemat+"</td>" +
		  				  		"<td>"+nombres+"</td>" +
		  				  		"<td>"+nacionalidad+"</td>" +
		  				  		"<td>"+numdoc+"</td>" +
		  				  		"<td>"+fecing+"</td>" +
		  				  		"<td>"+ley+"</td>" +
		  				  		"<td>"+sunedu+"</td>" +
		  				  		"<td>"+mayorgrado+"</td>" +
		  				  		"<td>"+menciongrado+"</td>" +
		  				  		"<td>"+univ+"</td>" +
		  				  		"<td>"+paisuniv+"</td>" +
		  				  		"<td>"+pregrado+"</td>" +
		  				  		"<td>"+maestria+"</td>" +
		  				  		"<td>"+doctorado+"</td>" +
		  				  		"<td>"+sl01+"</td>" +
		  				  		"<td>"+sl02+"</td>" +
		  				  		"<td>"+sl03+"</td>" +
	 	  				  		"<td>"+categoria+"</td>" +
		  				  		"<td>"+regimen+"</td>" +
		  				  		"<td>"+horaclase+"</td>" +
		  				  		"<td>"+otrasact+"</td>" +
		  				  		"<td>"+totalhoras+"</td>" +
		  				  		"<td>"+investigador+"</td>" +
		  				  		"<td>"+dina+"</td>" +
		  				  		"<td>"+semestre+"</td>" +
		  				  		"<td>"+observ+"</td>" +
		  				  		"<td>"+escuela+"</td>" +
		  				  		"<td>"+ email + "</td>" +
		  				  		"<td>" + telefono + "</td>" +
		  				  		"</tr>");
					}
				}
			}
		});
	}
	
});

$('#btnDINA').click(function(){
	
	
	if($('#txtfecha').val() == ""){
		alert('Ingrese una fecha valida');
	}
	else{
		alert('Mostrando docentes con DINA');
		$.ajax({
			type : 'POST',
			url : '/TallerIntegradov0.1/ListarDocentesC9DINA',
			data : {
				fecha : $('#txtfecha').val()
			},
			success : function(data) {
				var array = data.split("$");
				$('#tableBody').empty();
				if(data == "_"){
					alert("No hay registro de Docentes");
				}else{
				
					for (var i = 0; i < array.length -1; i++) {
						var apepat = array[i].split("=")[0]; 
	  				    var apemat  = array[i].split("=")[1];
	  				    var nombres = array[i].split("=")[2];
	  				    var nacionalidad = array[i].split("=")[3];
	  				    var numdoc = array[i].split("=")[4];
	  				    var fecing = array[i].split("=")[5];
	  				    var ley = array[i].split("=")[6] == "1" ? "SI" : "NO";
	  				    var sunedu = array[i].split("=")[7] == "1" ? "SI" : "NO";
	  				    var mayorgrado = array[i].split("=")[8];
	  				    var menciongrado= array[i].split("=")[9];
	  				    var univ = array[i].split("=")[10];
	  				    var paisuniv = array[i].split("=")[11];
	  				    var pregrado = array[i].split("=")[12] == "1" ? "SI" : "NO";
	  				    var maestria = array[i].split("=")[13] == "1" ? "SI" : "NO";
	  				    var doctorado = array[i].split("=")[14] == "1" ? "SI" : "NO";
	  				    var sl01 = array[i].split("=")[15] == "1" ? "SI" : "NO"; 
	  				    var sl02 = array[i].split("=")[16] == "1" ? "SI" : "NO";
	  				    var sl03 = array[i].split("=")[17] == "1" ? "SI" : "NO";
	   				    var categoria = array[i].split("=")[18];
	  				    var regimen = array[i].split("=")[19];
	  				    var horaclase = array[i].split("=")[20];
	  				    var otrasact = array[i].split("=")[21];
	  				    var totalhoras = array[i].split("=")[22];
	  				    var investigador = array[i].split("=")[23] == "1" ? "SI" : "NO";
	  				    var dina = array[i].split("=")[24] == "1" ? "SI" : "NO";
	  				    var semestre = array[i].split("=")[25];
	  				    var observ = array[i].split("=")[26] == "null" ? "Ninguno" : "Ninguno";
	  				    var escuela = array[i].split("=")[27];
	  				    var email = array[i].split("=")[28];
	  				    var telefono = array[i].split("=")[29];
	  				    
	  				  $('#example1').append("<tr>" +
		  				  		"<td>"+apepat+"</td>" +
		  				  		"<td>"+apemat+"</td>" +
		  				  		"<td>"+nombres+"</td>" +
		  				  		"<td>"+nacionalidad+"</td>" +
		  				  		"<td>"+numdoc+"</td>" +
		  				  		"<td>"+fecing+"</td>" +
		  				  		"<td>"+ley+"</td>" +
		  				  		"<td>"+sunedu+"</td>" +
		  				  		"<td>"+mayorgrado+"</td>" +
		  				  		"<td>"+menciongrado+"</td>" +
		  				  		"<td>"+univ+"</td>" +
		  				  		"<td>"+paisuniv+"</td>" +
		  				  		"<td>"+pregrado+"</td>" +
		  				  		"<td>"+maestria+"</td>" +
		  				  		"<td>"+doctorado+"</td>" +
		  				  		"<td>"+sl01+"</td>" +
		  				  		"<td>"+sl02+"</td>" +
		  				  		"<td>"+sl03+"</td>" +
		  				  		"<td>"+categoria+"</td>" +
		  				  		"<td>"+regimen+"</td>" +
		  				  		"<td>"+horaclase+"</td>" +
		  				  		"<td>"+otrasact+"</td>" +
		  				  		"<td>"+totalhoras+"</td>" +
		  				  		"<td>"+investigador+"</td>" +
		  				  		"<td>"+dina+"</td>" +
		  				  		"<td>"+semestre+"</td>" +
		  				  		"<td>"+observ+"</td>" +
		  				  		"<td>"+escuela+"</td>" +
		  				  		"<td>"+ email + "</td>" +
		  				  		"<td>" + telefono + "</td>" +
		  				  		"</tr>");
					}
				}
			}
		});
	}
});


$('#btnCompleto').click(function(){
	if($('#txtfecha').val() == ""){
		alert('Ingrese una fecha valida');
	}
	else{
		alert('Mostrando Docentes tiempo completo');
		$.ajax({
			type : 'POST',
			url : '/TallerIntegradov0.1/ListarDocenteC9Completo',
			data : {
				fecha : $('#txtfecha').val()
			},
			success : function(data) {
				var array = data.split("$");
				$('#tableBody').empty();
				if(data == "_"){
					alert("No hay registro de Docentes");
				}else{
				
					for (var i = 0; i < array.length -1; i++) {
						var apepat = array[i].split("=")[0]; 
	  				    var apemat  = array[i].split("=")[1];
	  				    var nombres = array[i].split("=")[2];
	  				    var nacionalidad = array[i].split("=")[3];
	  				    var numdoc = array[i].split("=")[4];
	  				    var fecing = array[i].split("=")[5];
	  				    var ley = array[i].split("=")[6] == "1" ? "SI" : "NO";
	  				    var sunedu = array[i].split("=")[7] == "1" ? "SI" : "NO";
	  				    var mayorgrado = array[i].split("=")[8];
	  				    var menciongrado= array[i].split("=")[9];
	  				    var univ = array[i].split("=")[10];
	  				    var paisuniv = array[i].split("=")[11];
	  				    var pregrado = array[i].split("=")[12] == "1" ? "SI" : "NO";
	  				    var maestria = array[i].split("=")[13] == "1" ? "SI" : "NO";
	  				    var doctorado = array[i].split("=")[14] == "1" ? "SI" : "NO";
	  				    var sl01 = array[i].split("=")[15] == "1" ? "SI" : "NO"; 
	  				    var sl02 = array[i].split("=")[16] == "1" ? "SI" : "NO";
	  				    var sl03 = array[i].split("=")[17] == "1" ? "SI" : "NO";
	   				    var categoria = array[i].split("=")[18];
	  				    var regimen = array[i].split("=")[19];
	  				    var horaclase = array[i].split("=")[20];
	  				    var otrasact = array[i].split("=")[21];
	  				    var totalhoras = array[i].split("=")[22];
	  				    var investigador = array[i].split("=")[23] == "1" ? "SI" : "NO";
	  				    var dina = array[i].split("=")[24] == "1" ? "SI" : "NO";
	  				    var semestre = array[i].split("=")[25];
	  				    var observ = array[i].split("=")[26] == "null" ? "Ninguno" : "Ninguno";
	  				    var escuela = array[i].split("=")[27];
	  				    var email = array[i].split("=")[28];
	  				    var telefono = array[i].split("=")[29];
	  				    
	  				  $('#example1').append("<tr>" +
		  				  		"<td>"+apepat+"</td>" +
		  				  		"<td>"+apemat+"</td>" +
		  				  		"<td>"+nombres+"</td>" +
		  				  		"<td>"+nacionalidad+"</td>" +
		  				  		"<td>"+numdoc+"</td>" +
		  				  		"<td>"+fecing+"</td>" +
		  				  		"<td>"+ley+"</td>" +
		  				  		"<td>"+sunedu+"</td>" +
		  				  		"<td>"+mayorgrado+"</td>" +
		  				  		"<td>"+menciongrado+"</td>" +
		  				  		"<td>"+univ+"</td>" +
		  				  		"<td>"+paisuniv+"</td>" +
		  				  		"<td>"+pregrado+"</td>" +
		  				  		"<td>"+maestria+"</td>" +
		  				  		"<td>"+doctorado+"</td>" +
		  				  		"<td>"+sl01+"</td>" +
		  				  		"<td>"+sl02+"</td>" +
		  				  		"<td>"+sl03+"</td>" +
		  				  		"<td>"+categoria+"</td>" +
		  				  		"<td>"+regimen+"</td>" +
		  				  		"<td>"+horaclase+"</td>" +
		  				  		"<td>"+otrasact+"</td>" +
		  				  		"<td>"+totalhoras+"</td>" +
		  				  		"<td>"+investigador+"</td>" +
		  				  		"<td>"+dina+"</td>" +
		  				  		"<td>"+semestre+"</td>" +
		  				  		"<td>"+observ+"</td>" +
		  				  		"<td>"+escuela+"</td>" +
		  				  		"<td>"+ email + "</td>" +
		  				  		"<td>" + telefono + "</td>" +
		  				  		"</tr>");
					}
				}
			}
		});
	}
	
});

$('#btnCATE').click(function(){
	
	
	if($('#txtfecha').val() == ""){
		alert('Ingrese una fecha valida');
	}else{
		alert('Mostrando categoria Contratado');
		$.ajax({
			type : 'POST',
			url : '/TallerIntegradov0.1/ListarDocenteC9Categoria',
			data : {
				fecha : $('#txtfecha').val()
			},
			success : function(data) {
				var array = data.split("$");
				$('#tableBody').empty();
				if(data == "_"){
					alert("No hay registro de Docentes");
				}else{
				
					for (var i = 0; i < array.length -1; i++) {
						var apepat = array[i].split("=")[0]; 
	  				    var apemat  = array[i].split("=")[1];
	  				    var nombres = array[i].split("=")[2];
	  				    var nacionalidad = array[i].split("=")[3];
	  				    var numdoc = array[i].split("=")[4];
	  				    var fecing = array[i].split("=")[5];
	  				    var ley = array[i].split("=")[6] == "1" ? "SI" : "NO";
	  				    var sunedu = array[i].split("=")[7] == "1" ? "SI" : "NO";
	  				    var mayorgrado = array[i].split("=")[8];
	  				    var menciongrado= array[i].split("=")[9];
	  				    var univ = array[i].split("=")[10];
	  				    var paisuniv = array[i].split("=")[11];
	  				    var pregrado = array[i].split("=")[12] == "1" ? "SI" : "NO";
	  				    var maestria = array[i].split("=")[13] == "1" ? "SI" : "NO";
	  				    var doctorado = array[i].split("=")[14] == "1" ? "SI" : "NO";
	  				    var sl01 = array[i].split("=")[15] == "1" ? "SI" : "NO"; 
	  				    var sl02 = array[i].split("=")[16] == "1" ? "SI" : "NO";
	  				    var sl03 = array[i].split("=")[17] == "1" ? "SI" : "NO";
	   				    var categoria = array[i].split("=")[18];
	  				    var regimen = array[i].split("=")[19];
	  				    var horaclase = array[i].split("=")[20];
	  				    var otrasact = array[i].split("=")[21];
	  				    var totalhoras = array[i].split("=")[22];
	  				    var investigador = array[i].split("=")[23] == "1" ? "SI" : "NO";
	  				    var dina = array[i].split("=")[24] == "1" ? "SI" : "NO";
	  				    var semestre = array[i].split("=")[25];
	  				    var observ = array[i].split("=")[26] == "null" ? "Ninguno" : "Ninguno";
	  				    var escuela = array[i].split("=")[27];
	  				    var email = array[i].split("=")[28];
	  				    var telefono = array[i].split("=")[29];
	  				    
	  				  $('#example1').append("<tr>" +
		  				  		"<td>"+apepat+"</td>" +
		  				  		"<td>"+apemat+"</td>" +
		  				  		"<td>"+nombres+"</td>" +
		  				  		"<td>"+nacionalidad+"</td>" +
		  				  		"<td>"+numdoc+"</td>" +
		  				  		"<td>"+fecing+"</td>" +
		  				  		"<td>"+ley+"</td>" +
		  				  		"<td>"+sunedu+"</td>" +
		  				  		"<td>"+mayorgrado+"</td>" +
		  				  		"<td>"+menciongrado+"</td>" +
		  				  		"<td>"+univ+"</td>" +
		  				  		"<td>"+paisuniv+"</td>" +
		  				  		"<td>"+pregrado+"</td>" +
		  				  		"<td>"+maestria+"</td>" +
		  				  		"<td>"+doctorado+"</td>" +
		  				  		"<td>"+sl01+"</td>" +
		  				  		"<td>"+sl02+"</td>" +
		  				  		"<td>"+sl03+"</td>" +
		  				  		"<td>"+categoria+"</td>" +
		  				  		"<td>"+regimen+"</td>" +
		  				  		"<td>"+horaclase+"</td>" +
		  				  		"<td>"+otrasact+"</td>" +
		  				  		"<td>"+totalhoras+"</td>" +
		  				  		"<td>"+investigador+"</td>" +
		  				  		"<td>"+dina+"</td>" +
		  				  		"<td>"+semestre+"</td>" +
		  				  		"<td>"+observ+"</td>" +
		  				  		"<td>"+escuela+"</td>" +
		  				  		"<td>"+ email + "</td>" +
		  				  		"<td>" + telefono + "</td>" +
		  				  		"</tr>");
					}
				}
			}
		});
	}
	
});

$('#btnPARCIAL').click(function(){
	
	
	if($('#txtfecha').val() == ""){
		alert('Ingrese una fecha valida');
	}else{
		alert('Mostrando Docentes tiempo parcial');
		$.ajax({
			type : 'POST',
			url : '/TallerIntegradov0.1/ListarDocenteC9Parcial',
			data : {
				fecha : $('#txtfecha').val()
			},
			success : function(data) {
				var array = data.split("$");
				$('#tableBody').empty();
				if(data == "_"){
					alert("No hay registro de Docentes");
				}else{
				
					for (var i = 0; i < array.length -1; i++) {
						var apepat = array[i].split("=")[0]; 
	  				    var apemat  = array[i].split("=")[1];
	  				    var nombres = array[i].split("=")[2];
	  				    var nacionalidad = array[i].split("=")[3];
	  				    var numdoc = array[i].split("=")[4];
	  				    var fecing = array[i].split("=")[5];
	  				    var ley = array[i].split("=")[6] == "1" ? "SI" : "NO";
	  				    var sunedu = array[i].split("=")[7] == "1" ? "SI" : "NO";
	  				    var mayorgrado = array[i].split("=")[8];
	  				    var menciongrado= array[i].split("=")[9];
	  				    var univ = array[i].split("=")[10];
	  				    var paisuniv = array[i].split("=")[11];
	  				    var pregrado = array[i].split("=")[12] == "1" ? "SI" : "NO";
	  				    var maestria = array[i].split("=")[13] == "1" ? "SI" : "NO";
	  				    var doctorado = array[i].split("=")[14] == "1" ? "SI" : "NO";
	  				    var sl01 = array[i].split("=")[15] == "1" ? "SI" : "NO"; 
	  				    var sl02 = array[i].split("=")[16] == "1" ? "SI" : "NO";
	  				    var sl03 = array[i].split("=")[17] == "1" ? "SI" : "NO";
	   				    var categoria = array[i].split("=")[18];
	  				    var regimen = array[i].split("=")[19];
	  				    var horaclase = array[i].split("=")[20];
	  				    var otrasact = array[i].split("=")[21];
	  				    var totalhoras = array[i].split("=")[22];
	  				    var investigador = array[i].split("=")[23] == "1" ? "SI" : "NO";
	  				    var dina = array[i].split("=")[24] == "1" ? "SI" : "NO";
	  				    var semestre = array[i].split("=")[25];
	  				    var observ = array[i].split("=")[26] == "null" ? "Ninguno" : "Ninguno";
	  				    var escuela = array[i].split("=")[27];
	  				    var email = array[i].split("=")[28];
	  				    var telefono = array[i].split("=")[29];
	  				    
	  				  $('#example1').append("<tr>" +
		  				  		"<td>"+apepat+"</td>" +
		  				  		"<td>"+apemat+"</td>" +
		  				  		"<td>"+nombres+"</td>" +
		  				  		"<td>"+nacionalidad+"</td>" +
		  				  		"<td>"+numdoc+"</td>" +
		  				  		"<td>"+fecing+"</td>" +
		  				  		"<td>"+ley+"</td>" +
		  				  		"<td>"+sunedu+"</td>" +
		  				  		"<td>"+mayorgrado+"</td>" +
		  				  		"<td>"+menciongrado+"</td>" +
		  				  		"<td>"+univ+"</td>" +
		  				  		"<td>"+paisuniv+"</td>" +
		  				  		"<td>"+pregrado+"</td>" +
		  				  		"<td>"+maestria+"</td>" +
		  				  		"<td>"+doctorado+"</td>" +
		  				  		"<td>"+sl01+"</td>" +
		  				  		"<td>"+sl02+"</td>" +
		  				  		"<td>"+sl03+"</td>" +
		  				  		"<td>"+categoria+"</td>" +
		  				  		"<td>"+regimen+"</td>" +
		  				  		"<td>"+horaclase+"</td>" +
		  				  		"<td>"+otrasact+"</td>" +
		  				  		"<td>"+totalhoras+"</td>" +
		  				  		"<td>"+investigador+"</td>" +
		  				  		"<td>"+dina+"</td>" +
		  				  		"<td>"+semestre+"</td>" +
		  				  		"<td>"+observ+"</td>" +
		  				  		"<td>"+escuela+"</td>" +
		  				  		"<td>"+ email + "</td>" +
		  				  		"<td>" + telefono + "</td>" +
		  				  		"</tr>");
					}
				}
			}
		});
	}
	
});

$('#btnINV').click(function(){
	
	
	
	if($('#txtfecha').val() == ""){
		alert('Ingrese una fecha valida');
	}else{
		alert('Mostrando Docentes Investigadores');
		$.ajax({
			type : 'POST',
			url : '/TallerIntegradov0.1/ListarDocenteC9Investigador',
			data : {
				fecha : $('#txtfecha').val()
			},
			success : function(data) {
				var array = data.split("$");
				$('#tableBody').empty();
				if(data == "_"){
					alert("No hay registro de Docentes");
				}else{
				
					for (var i = 0; i < array.length -1; i++) {
						var apepat = array[i].split("=")[0]; 
	  				    var apemat  = array[i].split("=")[1];
	  				    var nombres = array[i].split("=")[2];
	  				    var nacionalidad = array[i].split("=")[3];
	  				    var numdoc = array[i].split("=")[4];
	  				    var fecing = array[i].split("=")[5];
	  				    var ley = array[i].split("=")[6] == "1" ? "SI" : "NO";
	  				    var sunedu = array[i].split("=")[7] == "1" ? "SI" : "NO";
	  				    var mayorgrado = array[i].split("=")[8];
	  				    var menciongrado= array[i].split("=")[9];
	  				    var univ = array[i].split("=")[10];
	  				    var paisuniv = array[i].split("=")[11];
	  				    var pregrado = array[i].split("=")[12] == "1" ? "SI" : "NO";
	  				    var maestria = array[i].split("=")[13] == "1" ? "SI" : "NO";
	  				    var doctorado = array[i].split("=")[14] == "1" ? "SI" : "NO";
	  				    var sl01 = array[i].split("=")[15] == "1" ? "SI" : "NO"; 
	  				    var sl02 = array[i].split("=")[16] == "1" ? "SI" : "NO";
	  				    var sl03 = array[i].split("=")[17] == "1" ? "SI" : "NO";
	   				    var categoria = array[i].split("=")[18];
	  				    var regimen = array[i].split("=")[19];
	  				    var horaclase = array[i].split("=")[20];
	  				    var otrasact = array[i].split("=")[21];
	  				    var totalhoras = array[i].split("=")[22];
	  				    var investigador = array[i].split("=")[23] == "1" ? "SI" : "NO";
	  				    var dina = array[i].split("=")[24] == "1" ? "SI" : "NO";
	  				    var semestre = array[i].split("=")[25];
	  				    var observ = array[i].split("=")[26] == "null" ? "Ninguno" : "Ninguno";
	  				    var escuela = array[i].split("=")[27];
	  				    var email = array[i].split("=")[28];
	  				    var telefono = array[i].split("=")[29];
	  				    
	  				  $('#example1').append("<tr>" +
		  				  		"<td>"+apepat+"</td>" +
		  				  		"<td>"+apemat+"</td>" +
		  				  		"<td>"+nombres+"</td>" +
		  				  		"<td>"+nacionalidad+"</td>" +
		  				  		"<td>"+numdoc+"</td>" +
		  				  		"<td>"+fecing+"</td>" +
		  				  		"<td>"+ley+"</td>" +
		  				  		"<td>"+sunedu+"</td>" +
		  				  		"<td>"+mayorgrado+"</td>" +
		  				  		"<td>"+menciongrado+"</td>" +
		  				  		"<td>"+univ+"</td>" +
		  				  		"<td>"+paisuniv+"</td>" +
		  				  		"<td>"+pregrado+"</td>" +
		  				  		"<td>"+maestria+"</td>" +
		  				  		"<td>"+doctorado+"</td>" +
		  				  		"<td>"+sl01+"</td>" +
		  				  		"<td>"+sl02+"</td>" +
		  				  		"<td>"+sl03+"</td>" +
		  				  		"<td>"+categoria+"</td>" +
		  				  		"<td>"+regimen+"</td>" +
		  				  		"<td>"+horaclase+"</td>" +
		  				  		"<td>"+otrasact+"</td>" +
		  				  		"<td>"+totalhoras+"</td>" +
		  				  		"<td>"+investigador+"</td>" +
		  				  		"<td>"+dina+"</td>" +
		  				  		"<td>"+semestre+"</td>" +
		  				  		"<td>"+observ+"</td>" +
		  				  		"<td>"+escuela+"</td>" +
		  				  		"<td>"+ email + "</td>" +
		  				  		"<td>" + telefono + "</td>" +
		  				  		"</tr>");
					}
				}
			}
		});
	}
	
});


$('#btnTODO').click(function(){ 
	
	if($('#txtfecha').val() == ""){
		alert('Ingrese una fecha valida');
	}else{
		alert('Mostrando docentes')
		$.ajax({
			type : 'POST',
			url : '/TallerIntegradov0.1/ListarDocentesC9',
			data : {
				fecha : $('#txtfecha').val()
			},
			success : function(data) {
				var array = data.split("$");
				$('#tableBody').empty();
				if(data == "_"){
					alert("No hay registro de Docentes");
				}else{
					for (var i = 0; i < array.length -1; i++) {
						var apepat = array[i].split("=")[0]; 
	  				    var apemat  = array[i].split("=")[1];
	  				    var nombres = array[i].split("=")[2];
	  				    var nacionalidad = array[i].split("=")[3];
	  				    var numdoc = array[i].split("=")[4];
	  				    var fecing = array[i].split("=")[5];
	  				    var ley = array[i].split("=")[6] == "1" ? "SI" : "NO";
	  				    var sunedu = array[i].split("=")[7] == "1" ? "SI" : "NO";
	  				    var mayorgrado = array[i].split("=")[8];
	  				    var menciongrado= array[i].split("=")[9];
	  				    var univ = array[i].split("=")[10];
	  				    var paisuniv = array[i].split("=")[11];
	  				    var pregrado = array[i].split("=")[12] == "1" ? "SI" : "NO";
	  				    var maestria = array[i].split("=")[13] == "1" ? "SI" : "NO";
	  				    var doctorado = array[i].split("=")[14] == "1" ? "SI" : "NO";
	  				    var sl01 = array[i].split("=")[15] == "1" ? "SI" : "NO"; 
	  				    var sl02 = array[i].split("=")[16] == "1" ? "SI" : "NO";
	  				    var sl03 = array[i].split("=")[17] == "1" ? "SI" : "NO";
	   				    var categoria = array[i].split("=")[18];
	  				    var regimen = array[i].split("=")[19];
	  				    var horaclase = array[i].split("=")[20];
	  				    var otrasact = array[i].split("=")[21];
	  				    var totalhoras = array[i].split("=")[22];
	  				    var investigador = array[i].split("=")[23] == "1" ? "SI" : "NO";
	  				    var dina = array[i].split("=")[24] == "1" ? "SI" : "NO";
	  				    var semestre = array[i].split("=")[25];
	  				    var observ = array[i].split("=")[26] == "null" ? "Ninguno" : "Ninguno";
	  				    var escuela = array[i].split("=")[27];
	  				    var email = array[i].split("=")[28];
	  				    var telefono = array[i].split("=")[29];
	  				    
	  				  $('#example1').append("<tr>" +
		  				  		"<td>"+apepat+"</td>" +
		  				  		"<td>"+apemat+"</td>" +
		  				  		"<td>"+nombres+"</td>" +
		  				  		"<td>"+nacionalidad+"</td>" +
		  				  		"<td>"+numdoc+"</td>" +
		  				  		"<td>"+fecing+"</td>" +
		  				  		"<td>"+ley+"</td>" +
		  				  		"<td>"+sunedu+"</td>" +
		  				  		"<td>"+mayorgrado+"</td>" +
		  				  		"<td>"+menciongrado+"</td>" +
		  				  		"<td>"+univ+"</td>" +
		  				  		"<td>"+paisuniv+"</td>" +
		  				  		"<td>"+pregrado+"</td>" +
		  				  		"<td>"+maestria+"</td>" +
		  				  		"<td>"+doctorado+"</td>" +
		  				  		"<td>"+sl01+"</td>" +
		  				  		"<td>"+sl02+"</td>" +
		  				  		"<td>"+sl03+"</td>" +
		  				  		"<td>"+categoria+"</td>" +
		  				  		"<td>"+regimen+"</td>" +
		  				  		"<td>"+horaclase+"</td>" +
		  				  		"<td>"+otrasact+"</td>" +
		  				  		"<td>"+totalhoras+"</td>" +
		  				  		"<td>"+investigador+"</td>" +
		  				  		"<td>"+dina+"</td>" +
		  				  		"<td>"+semestre+"</td>" +
		  				  		"<td>"+observ+"</td>" +
		  				  		"<td>"+escuela+"</td>" +
		  				  		"<td>"+ email + "</td>" +
		  				  		"<td>" + telefono + "</td>" +
		  				  		"</tr>");
					}
				}
			}
		});
	}
	
});

$('#btnEXCEL').click(function(){ 
	alert('Mostrando docentes')
	$.ajax({
		type : 'POST',
		url : '/TallerIntegradov0.1/ReporteC9Excel',
		data : {
			fecha : $('#txtfecha').val()
		}
	});
});

});





