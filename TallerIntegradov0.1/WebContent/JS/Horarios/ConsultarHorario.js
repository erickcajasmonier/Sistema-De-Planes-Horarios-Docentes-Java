$(document).ready(function(){	
//////////////////////////////////////////////////////////////////////////////////////////
	$.ajax({
        type: 'POST',
        url: '/TallerIntegradov0.1/ListarEscuelas',
        success: function(data)
        {
        	$('.selectEsc option').remove();
        	$('.selectEsc').append('<option value="'+""+'">--Seleccionar--</option>');
        	var var1=data.split(":");
        	for (var i=0;i<var1.length-1;i++) {
			    var idescuela=var1[i].split("-")[0];
			    var descr=var1[i].split("-")[1];
			    $('.selectEsc').append('<option value="'+idescuela+'">'+descr+'</option>');
			}
        }
	});
//////////////////////////////////////////////////////////////////////////////////////////
	$.ajax({
	        type: 'POST',
	        url: '/TallerIntegradov0.1/ListarSemestres',
	        success: function(data)
	        {            	
	        	$('.selectSem option').remove();
	        	$('.selectSem').append('<option value="'+""+'">--Seleccionar--</option>');
	        	var var1=data.split(":");
	        	for (var i=0;i<var1.length-1;i++) {
				    var varr1=var1[i].split("/")[0];
				    var varr2=var1[i].split("/")[1];
				    var varr3=var1[i].split("/")[2];
				    $('.selectSem').append('<option value="'+varr1+'">'+varr2+' - '+varr3+'</option>');
				}
	        }
	});
//////////////////////////////////////////////////////////////////////////////////////////
	var countbtnAgregarSeccion1 = 0;
//	$('body').off('click').on('click', '#btnMostrarHorario', function(e){
	$('body').on('click', '#btnMostrarHorario', function(e){
		e.preventDefault();
		if(e.handled !== true){
			e.handled = true;
			console.log("a");
		}
		$('#table1body').empty();    
		$.ajax({
	        type:'POST',
	        url: '/TallerIntegradov0.1/ConsultarHorario',
	        data: { 
	        	semestre:$('#selectSemestre').val(),
	        	escuela:$('#selectEscuela').val()
	        },
	        success: function(result) {
	        	var var1=result.split("%");
	        	if(result==''){
	        		console.log(result);
//					alert("El Horario Seleccionado no esta disponible.");
	        		console.log("El semestre seleccionado no cuenta con horarios para la escuela "+$('#selectEscuela selected').text());
	        		alert("No se encontraron horarios para la Escuela en el semestre seleccionado.");
				}else {
					var contadorTabla=0;
					$('#table1body').empty();
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
	  				    
	  				    		$('#table1body').append("<tr id='fila"+contadorTabla+"' class='ciclo"+_ciclo+"' style='color:white;'>" +
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
	  	  		  				  		"</tr>");
	  				    contadorTabla++;
					}
				}
	        },
	        error: function(result) {
	            alert('Error revisar Datos.');
	        }
	    });
	});
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	


});