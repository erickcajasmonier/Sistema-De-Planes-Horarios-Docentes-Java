$(document).ready(function(){	
	$('#selectEscuela').prop("disabled",true);
	$('#selectCiclo').prop("disabled",true);
	$('#selectCurso').prop("disabled",true);
	$('#btnAgregarDC').prop("disabled",true);
		
///////////////////////////////////////////////////////////////////////////////////////////////	
	
///////////////////////////////////////////////////////////////////////////////////////////////
        $.ajax({
                type: 'POST',
                url: '/TallerIntegradov0.1/ListarEscuelas',
                success: function(data)
                {
                	$('.selectEsc').append('<option value="'+""+'">--Seleccionar--</option>');
                	var var1=data.split(":");
                	for (var i=0;i<var1.length-1;i++) {
    				    var valor=var1[i].split("-")[0];
    				    var descr=var1[i].split("-")[1];
    				    $('.selectEsc').append('<option value="'+valor+'">'+descr+'</option>');
    				}
                }
        });
///////////////////////////////////////////////////////////////////////////////////////////////
        $.ajax({
            type: 'POST',
            url: '/TallerIntegradov0.1/ListarSemestres',
            success: function(data)
            {            	
            	$('.selectSem').empty();
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
///////////////////////////////////////////////////////////////////////////////////////////////
        $('#btnBuscar').prop("disabled",true);
        
        $('#divSemestre').on('change', '#selectSemestre', function(){
        	if($('#selectSemestre').val()==""){
        		$('#btnBuscar').prop("disabled",true);
        		$('#btnAgregarDC').prop("disabled",true);
        	} else {
        		$('#btnBuscar').prop("disabled",false);
        	}
        	$('#txtnumdoc').val('');
        	$('#txtNombre').val('');
        	$('#txtApepat').val('');
        	$('#txtApemat').val('');
        	$('#txtDni').val('');
        	$('#tableDCbody').empty();   
        	$('.selectCic option').remove();
            $('.selectCic').append('<option value="'+""+'">--Seleccionar--</option>');
        	$('.selectCur option').remove();
            $('.selectCur').append('<option value="'+""+'">--Seleccionar--</option>');
            $('#selectEscuela').prop('selectedIndex',0);
            $('#selectEscuela').prop("disabled",true);
            $('#selectCiclo').prop("disabled",true);
            $('#selectCurso').prop("disabled",true);
            $('#btnAgregarDC').prop("disabled",true);
            $('#btnGuardarDC').prop("disabled",true);
        });
        
        
        //$( "#selectEscuela" ).change(function(){
          $('#divEscuela').on('change', '#selectEscuela', function(){
            if ( $(this).children(":selected").val() === "" ) {
                  $('.selectCic option').remove();
                  $('.selectCic').append('<option value="'+""+'">--Seleccionar--</option>');
                  $('.selectCur option').remove();
                  $('.selectCur').append('<option value="'+""+'">--Seleccionar--</option>');
            }
            else {
            	$('.selectCic option').remove();
            	$('.selectCic').append('<option value="'+""+'">--Seleccionar--</option>');
            	$('.selectCur option').remove();
                $('.selectCur').append('<option value="'+""+'">--Seleccionar--</option>');
            	$.ajax({
                    type: 'POST',
                    url: '/TallerIntegradov0.1/ListarCiclos',
                    success: function(data)
                    {
                    	var var1=data.split(":");
                    	for (var i=0;i<var1.length-1;i++) {
        				    var valor=var1[i].split("-")[0];
        				    var descr=var1[i].split("-")[1];
        				    $('.selectCic').append('<option value="'+valor+'">'+descr+'</option>');
        				}
                    }
            });   
            }
        });
        //});    
///////////////////////////////////////////////////////////////////////////////////////////////
//        $( "#selectCiclo" ).change(function(){
          $('#divCiclo').on('change', '#selectCiclo', function(){
            if ( $(this).children(":selected").val() === "" ) {
                  $('.selectCur option').remove();
                  $('.selectCur').append('<option value="'+""+'">--Seleccionar--</option>');
            }
            else {
            	$('.selectCur option').remove();
            	$.ajax({
                    type: 'POST',
                    url: '/TallerIntegradov0.1/ListarCursos',
                    data: { 
			        	idescuela:$('#selectEscuela').val(),
			        	idciclo:$('#selectCiclo').val()
			        },
                    success: function(data)
                    {
                    	$('.selectCur').append('<option value="'+""+'">--Seleccionar--</option>');
                    	var var1=data.split(":");
                    	for (var i=0;i<var1.length-1;i++) {
        				    var valor=var1[i].split("-")[0];
        				    var descr=var1[i].split("-")[1];
        				    $('.selectCur').append('<option value="'+valor+'">'+descr+'</option>');
        				}
                    }
            });   
            }
        });   
///////////////////////////////////////////////////////////////////////////////////////////////    

          
          $('#divDocente').on('click', '#btnBuscar', function(){
        	  var numdoc = $('#txtnumdoc').val().trim();
        	  
        	  if(numdoc == ""){
        		  alert("Datos incompletos");
        		  return false;
        	  }
        	  $.ajax({
                  type: 'POST',
                  url: '/TallerIntegradov0.1/VerificarDocente',
                  data: {
                	  	numerodoc : numdoc
			        },
                  success: function(data)
                  {
                  	var var1=data.split(":");
//                  	console.log(data);
                  	if(data==":"){
                  		alert("Docente no encontrado.");
                  		$('#txtnumdoc').val("");
                  		$('#txtDni').val("");
                  		$('#txtNombre').val("");
      				    $('#txtApepat').val("");
      				    $('#txtApemat').val("");
                  		$('#selectEscuela').prop("disabled",true);
                        $('#selectCiclo').prop("disabled",true);
                        $('#selectCurso').prop("disabled",true);
                        $('#btnAgregarDC').prop("disabled",true);
                  	}
                  	else{
	                  	for (var i=0;i<var1.length-1;i++) {
	      				    var nombre    =   var1[i].split("-|")[0];
	      				    var apellidoP =   var1[i].split("-|")[1];
	      				    var apellidoM =   var1[i].split("-|")[2];
	      				    var dni       =   var1[i].split("-|")[3];
	//      				    $('.selectCur').append('<option value="'+descr3+'">'+descr+'</option>');
	//      				    $('#txtNombre').val(descr0);
	//      				    $('#txtApepat').val(descr1);
	//      				    $('#txtApemat').val(descr2);
	      				    $('#txtDni').val(dni);
	      				    alert("Docente: "+nombre+" "+apellidoP+" "+apellidoM+" encontrado");
	      				    $('#txtNombre').val(nombre);
	      				    $('#txtApepat').val(apellidoP);
	      				    $('#txtApemat').val(apellidoM);
	                        $('#selectEscuela').prop("disabled",false);
	                        $('#selectCiclo').prop("disabled",false);
	                        $('#selectCurso').prop("disabled",false);
	                        $('#btnAgregarDC').prop("disabled",false);
	      				}
                  	}
                  }
        	  }); 
          });
          
//////////////////////////////////////////////////////////////////////////////////////////////////
        
        $('#tableDCbody').on('click', '#btnborrarfila', function(){
      		var hi= confirm("Eliminar seleccionado?");
      	    if (hi== true){
      	        alert("Eliminado");
      	        $(this).closest('tr').remove();
      	      var countFilas = $('#tableDCbody tr').length;
        	  //
        	  if(countFilas==""){
            	  $('#btnGuardarDC').attr('disabled', 'disabled');
              } else {
            	  $('#btnGuardarDC').removeAttr('disabled');
              }
        	  //
      	    }else{
      	    	//$(".hide_div").hide();
      	    }
      	});
          
//////////////////////////////////////////////////////////////////////////////////////////////////
      	var contadorTablaDC = 0;
      	$('#btnGuardarDC').attr('disabled', 'disabled');
          $('body').on('click', '#btnAgregarDC', function(){
        	  
        	  var varx = $('#selectCurso').val();
        	  var vary = $('#selectCurso option:selected').text(); 
        	  var varz = $('#txtnumdoc').val();//cambiar por iddocente
        	      if (varz.trim().length<=0){
        	    	  alert("No se ha verificado existencia del docente, intente otra vez.");
        	    	  return false;
        	      }
        	  var varw = $('#selectSemestre').val();
        	  var countFilas = $('#tableDCbody tr').length-1; //solo lengt
//    		  console.log("contador:"+countFilas);
        	  //
        	  if(countFilas==-1){
            	  $('#btnGuardarDC').attr('disabled', 'disabled');
              } else if (countFilas>=0){
            	  $('#btnGuardarDC').removeAttr('disabled');
              }
        	  
        	  /*
        	   if(countFilas <= 0){
            	  $('#btnGuardarDC').attr('disabled', 'disabled');
              } else {
            	  $('#btnGuardarDC').removeAttr('disabled');
              }
        	   */
        	  
        	  //
        	  if ( $('#selectCurso').children(":selected").val() === "" ) {
                  alert("Curso no ha sido seleccionado");
                  return false;
        	  }
        	  
        	   $("#tableDCbody tr").each(function() {
        		   var itemOrden={};
        		   var codigotd="";
       	    	   var tds = $(this).find("td");
//       	    	   itemOrden.semestre	= tds.filter(":eq(0)").text();
       	    	   codigotd	= tds.filter(":eq(0)").text();
//       	    	   console.log("codigos existentes: "+codigotd);
       	    	   if(varx==codigotd){
       	    		   alert("El curso ya fue seleccionado, elegir otro.");
       	    		   $(this).remove();
       	    	   }
        	   });
        	  
        	  
      				$.ajax({
      			        type:'POST',
      			        url: '/TallerIntegradov0.1/ListarCursosxDocente',
      			        data: { 
      			        	idc_ajax:varx,
      			        	des_ajax:vary,
      			        	dni_ajax:varz,
      			        	sem_ajax:varw
      			        },
      			      success: function(data)
                      {
                      	var var1=data.split(":");
                      	if(data==":"){
                      		alert("El curso ya se le asigno al docente seleccionado");
                      	}
                      	else{
                      		$('#btnGuardarDC').removeAttr('disabled');
    	                  	for (var i=0;i<var1.length-1;i++) {
    	      				    var descr0=var1[i].split("-|")[0];
    	      				    var descr1=var1[i].split("-|")[1];
    	      				var borrarFila1="<button id='btnborrarfila' type='button' class='btn btn-danger btn-md'><span class='glyphicon glyphicon-remove-sign'></span></button>"
	    	      				
    	      				  $('#tableDCbody').append("<tr id='id"+contadorTablaDC+"'>" +
    	      				  		"<td id='t_idcurso' name='t_idcurso' class='semestreIDCell'>"+descr0+"</td>" +
    	      				  		"<td  name='t_nomcurso'>"+descr1+"</td>" +
    	      				  		"<td>"+borrarFila1+"</td></tr>");
    	      				contadorTablaDC++;
    	      				}
                      	}
                      }
      			    });
      		});

//////////////////////////////////////////////////////////////////////////////////////////////////
          $('#divDocente1').on('change', '#txtnumdoc', function(){        	  
              var empty = false;
              if($('#txtnumdoc').val().trim()==""){
            	  empty=true;
            	  $('#btnGuardarDC').attr('disabled', 'disabled');
              } else {
            	  empty=false;
            	  $('#btnGuardarDC').removeAttr('disabled');
              }
          });
//////////////////////////////////////////////////////////////////////////////////////////////////

          $('body').on('click', '#btnGuardarDC', function(){
        	  var count0 = $('#tableDCbody tr').length;
        	  var count1 = $('#txtDni').val().trim();
        	  	  count1 = count1.length;
        	  var count2 = $('select#selectSemestre').val().trim();
        	  	  count2 = count2.length;
        	  if(count0 >0 && count1>0 && count2>0){
        		  //
        		  alert("Datos Correctos :)");
        		  var linea = [];
        		  $('#tableDCbody tr').each(function(el) {
        		    	var itemOrden={};
        		    	var tds = $(this).find("td");
        		    	itemOrden.idcursog	= tds.filter(":eq(0)").text();
        		    	itemOrden.nomcurg	= tds.filter(":eq(1)").text();
        		    	itemOrden.txtdnig	= $('#txtDni').val();
        		    	itemOrden.semesg	= $('select#selectSemestre').val();
        		    	linea.push(itemOrden);
        		  });
        		  
        		  var datosxlinea={};
        		  datosxlinea.linea=linea;
        		  var datatable=JSON.stringify(datosxlinea);
       		      console.log(datatable);
        		  
        		  $.ajax({
    			        type:'POST',
    			        url: '/TallerIntegradov0.1/RegistrarCursosDocente',
    			        dataType:'JSON',
    					data:{
    						 objetojson:JSON.stringify(datosxlinea)
    						 },
    			      success: function(data)
                    {	
    			    	  if(data == '1'){
    			    		  alert("Se registraron los cursos del docente");
    			    		  $('#tableDCbody').empty();
    			    		  $('#txtnumdoc').val('');
    			    		  $('#txtNombre').val('');
    			    		  $('#txtApepat').val('');
    			    		  $('#txtApemat').val('');
    			    		  $('#txtDni').val('');
    			    		  $('.selectCic option').remove();
    			              	$('.selectCic').append('<option value="'+""+'">--Seleccionar--</option>');
    			              $('.selectCur option').remove();
    			              	$('.selectCur').append('<option value="'+""+'">--Seleccionar--</option>');
    			              $('#selectEscuela').prop('selectedIndex',0);
    			              $('#selectEscuela').prop("disabled",true);
    			              $('#selectCiclo').prop("disabled",true);
    			              $('#selectCurso').prop("disabled",true);
    			              $('#btnAgregarDC').prop("disabled",true);
    			              $('#btnGuardarDC').prop("disabled",true);
    			    	  }else{
    			    		  aler("Error al registrar")
    			    	  }
                    }
    			    });

                	
        		  //
        	  } else {
        		  alert("Error al grabar");
        	  }

          });
//////////////////////////////////////////////////////////////////////////////////////////////////
          $('#divLimpiar').on('click', '#btnLimpiarDC', function(){
        	  console.log("LIMPIAR");
          	if($('#selectSemestre').val()==""){
          		$('#btnBuscar').prop("disabled",true);
          		$('#btnAgregarDC').prop("disabled",true);
          	} else {
          		$('#btnBuscar').prop("disabled",false);
          	}
          	$('#txtnumdoc').val('');
          	$('#txtNombre').val('');
          	$('#txtApepat').val('');
          	$('#txtApemat').val('');
          	$('#txtDni').val('');
          	$('#tableDCbody').empty();   
          	$('.selectCic option').remove();
              $('.selectCic').append('<option value="'+""+'">--Seleccionar--</option>');
          	$('.selectCur option').remove();
              $('.selectCur').append('<option value="'+""+'">--Seleccionar--</option>');
              $('#selectEscuela').prop('selectedIndex',0);
              $('#selectEscuela').prop("disabled",true);
              $('#selectCiclo').prop("disabled",true);
              $('#selectCurso').prop("disabled",true);
              $('#btnAgregarDC').prop("disabled",true);
              $('#btnGuardarDC').prop("disabled",true);
          });
//////////////////////////////////////////////////////////////////////////////////////////////////         
          
});