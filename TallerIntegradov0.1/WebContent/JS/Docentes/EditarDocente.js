$(document).ready(function(){
	$.ajax({
        type: 'POST',
        url: '/TallerIntegradov0.1/ListarEscuelas',
        success: function(data)
        {            	
        	$('.selectEscuela').empty();
        	$('.selectEscuela').append('<option value="'+""+'">--Seleccionar--</option>');
        	var var1=data.split(":");
        	for (var i=0;i<var1.length-1;i++) {
        		var valor=var1[i].split("-")[0];
			    var desc=var1[i].split("-")[1];
				    $('.selectEscuela').append('<option value="'+valor+'">'+desc+'</option>');
			}
       }
	});
/////////////////////////////////////////////////////////
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
			    ultimosem=varr1;
			}
        	$('#selectSemestre').val(ultimosem);
        }
      });
/////////////////////////////////////////////////////////
	$('.onlytext').keyup(function(e) {
		  var regex = /^[a-zA-Z ]+$/;
		  if (regex.test(this.value) !== true)
		    this.value = this.value.replace(/[^a-zA-Z]+/, '');
	});
/////////////////////////////////////////////////////////

	$('body').on('click', '#btn_volver', function(){
		window.location='principalDocentes.jsp';
	});
/////////////////////////////////////////////////////////

populateCountries("txtnac");
populateCountries("txtpaiuni");	

/////////////////////////////////////////////////////////
$('.selectMayg').append('<option value="'+""+'">--Seleccionar--</option><option value="'+"Doctor"+'">Doctor</option><option value="'+"Maestria"+'">Maestría</option><option value="'+"Sin grado"+'">Sin grado</option><option value="'+"Titulo"+'">Título</option>');
$('.selectCat').append('<option value="'+""+'">--Seleccionar--</option><option value="'+"CONTRATADO"+'">Contratado</option><option value="'+"EXTRAORDINARIO"+'">Extraordinario</option><option value="'+"ORDINARIOAS"+'">Ordinario Asocioado</option><option value="'+"ORDINARIOAU"+'">Ordinario Auxiliar</option><option value="'+"ORDINARIOPR"+'">Ordinario Principal</option>');
$('.selectReg').append('<option value="'+""+'">--Seleccionar--</option><option value="'+"Dedicacion Exclusiva"+'">Dedicación Exclusiva</option><option value="'+"Tiempo Completo"+'">Tiempo Completo</option><option value="'+"Tiempo Parcial"+'">Tiempo Parcial</option>');
/////////////////////////////////////////////////////////
var fecha=$('#txtfecini');
var containercalendario=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
var options={
  format: 'yyyy/mm/dd',
  container: containercalendario,
  todayHighlight: true,
  autoclose: true,
};
fecha.datepicker(options);
/////////////////////////////////////////////////////////    
$('#txttothor').val("0");
$('#txttothor').prop("disabled",true);
$('.suma').keyup(function() {
	 sumar();
});
function sumar()
{
	 var num1=0;
	 var num2=0;
    num1 = ($('#txthorcla').val());
    num2 = ($("#txthoract").val());
    $('#txttothor').val(parseInt(num1) +parseInt(num2));
    if($('#txttothor').val()>40){
   	 alert("La cantidad total de horas no debe ser mayor a 40!");
   	 return false;
    }
}
/////////////////////////////////////////////////////////    
/////////////////////////////////////////////////////////
$("#txtnac").on("click", function(){
	console.log("clicktxtnac");
});

/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////    
//$("opciones").on('click', '#btnRegistrarDocente', function(){  	
$('#btnActualizarDocente').on('click', function(){ 
	console.log("click en boton Editar Docente.");
	var flag = $("#formEditarDocente").valid();
	console.log(flag);
	if (flag==true){
    	var parametro0= $("#iddoc").val().trim();
 		var parametro1= $("#txtnom").val().trim();
 		var parametro2= $("#txtapepat").val().trim();
 		var parametro3= $("#txtapemat").val().trim();
 		var parametro4= $("#txtnac").val();
 		var parametro5= $("#txtnumdoc").val();
 		var parametro6= $("#txtfecini").val();
 		var parametro7= $('#txtley:checked').val();
 		var parametro8= $("#txtmaygra").val();
 		var parametro9= $("#txtmenmay").val();
 		var parametro10= $("#txtuni").val();
 		var parametro11= $("#txtpaiuni").val();
 		var parametro12= $('#pregrado:checked').val();
 		var parametro13= $('#maestria:checked').val();
 		var parametro14= $('#doctor:checked').val();
 		var parametro15= $("#txtcat").val();
 		var parametro16= $("#txtregded").val();
 		var parametro17= $("#txthorcla").val();
 		var parametro18= $("#txthoract").val();
 		var parametro19= $("#txttothor").val();
 		var parametro20= $('#txtdocinv:checked').val();
 		var parametro21= $('#txtdina:checked').val();
 		//var parametro22= $("#txtperaca").val();
 		var parametro22= $('#selectSemestre').val();
 		var parametro23= $("#txtobs").val();
 		var parametro24= $("#txttelef").val();
		var parametro25= $("#txtemail").val();
		//var parametro26= $("#txtescuela").val();
		var parametro26= $('#selectEscuela option:selected').text();
 		
 		$.ajax({
            type: 'POST',
            url: '/TallerIntegradov0.1/EditarDocente',
            data: { 
            	id		: parametro0,
     			nombre 	: parametro1,
     			apepat 	: parametro2,
     			apemat 	: parametro3,
     			nac		: parametro4,	
     			numdoc	: parametro5,
     			fecini	: parametro6,
     			ley		: parametro7,
     			maygra	: parametro8,
     			menmay	: parametro9,
     			uni		: parametro10,
     			paiuni	: parametro11,
     			preg	: parametro12,
     			maes	: parametro13,
     			doct	: parametro14,
     			cat		: parametro15,
     			regded	: parametro16,
     			horcla	: parametro17,
     			horact	: parametro18,
     			tothor	: parametro19,
     			docinv	: parametro20,
     			dina	: parametro21,
     			peraca	: parametro22,
     			obs		: parametro23,
     			telef	: parametro24,
     			email	: parametro25,
     			escuela	: parametro26
	        },
            success: function(data)
            {
            	if (data == 0){
     				alert("Hubo un error, revisar campos obligarios.");
     			}else {
     				alert("Mensaje: "+"Actualizacion satisfactoria.");
     			}	
            }
 		});   
	} else {
		alert("Datos incompletos.");
	}

 });     
/////////////////////////////////////////////////////////   
     $("#formEditarDocente").validate({
		  rules: {
			txtnom:		{	required:true,
		    				minlength:2
		    			},
		    txtapepat:	{
		    				required:true,
		    				minlength:2
		    			},
		    txtapemat:	{
							required:false,
							minlength:2
						},
			txtnac:		{required:true, minlength:1},
			txtnumdoc:	{required:true, minlength:8,maxlength:11},
			txtfecini:	{required:true},
			txtley   :	{required:true},
			txtmaygra:	{required:true, minlength:1},
			txtmenmay:	{required:true},
			txtuni	 :	{required:true},
			txtpaiuni:	{required:true, minlength:1},
			pregrado :	{required:true},
			maestria :	{required:true},
			doctor	 :	{required:true},
			txtcat	 :	{required:true, minlength:1},
			txtregded:	{required:true, minlength:1},
			txthorcla:	{required:true, min:0,max:40},
			txthoract:	{required:true, min:0,max:40},
			txtdocinv:	{required:true},
			txtdina	 :	{required:true},
			
			txtperaca:	{required:true}
		  },
		  messages: {
		    txtnom: 	{	required:"Ingresar nombre.",
		    				minlength:"Minimo de caracteres es de 2."},
		  	txtapepat: 	{	required:"Ingresar Apellido Paterno.",
		  					minlength:"Minimo de caracteres es de 2."},
		  	txtapemat: 	{	required:"Ingresar Apellido Materno.",
			  				minlength:"Minimo de caracteres es de 2."},
		  	txtnac: 	{   required: "Seleccionar Pais." },
		  	txtnumdoc:	{	required:"Ingrese un valor", minlength:"Ingrese mínimo 8 digitos",
		  					maxlength:"Ingrese menos de 11 digitos"},
		  	txtfecini:	{	required:"Ingrese su fecha de Nacimiento."},
		  	txtley	:	{	required:"Seleccione un valor."},
		  	txtmaygra: 	{   required: "Seleccionar Grado." },
		  	txtmenmay:	{	required:"Ingrese Mencion."},
		  	txtuni	 :	{	required:"Ingrese universidad."},
		  	txtpaiuni:	{	required:"Seleccionar Pais."},
		  	pregrado :	{	required:"Seleccione un valor"},
			maestria :	{	required:"Seleccione un valor"},
			doctor	 :	{	required:"Seleccione un valor"},
			txtcat: 	{   required: "Seleccionar Categoria." },
			txtregded:	{	required:"Seleccionar Regimen."},
			txthorcla:	{	required:"Ingresar horas.", min:"Minimo 0.",max:"Maximo 40 horas."},
			txthoract:	{	required:"Ingresar horas.", min:"Minimo 0.",max:"Maximo 40 horas."},
			txtdocinv:	{	required:"Seleccione un valor."},
			txtdina  :	{	required:"Seleccione un valor."},
			
			txtperaca:	{	required:"Ingrese el periodo."}
		  }
		});
/////////////////////////////////////////////////////////    
     $('#btnBuscarDocente').on('click', function(){ 
    		console.log("click en boton Buscar Docente.");
    		 var var1	=	$("#txtnom").val();
    		 var var2	=	$("#txtapepat").val();
    		 var var3	=	$("#txtapemat").val();
    		 var var4	=	$("#txtnumdoc").val();
    		 
    		 if((var1.length>=2&&var2.length>=2&&var3.length>=2)||(var4.length>=8)){  
    		       //alert("Datos Correctos.");
    		       $.ajax({
    			        type: 'POST',
    			        url: '/TallerIntegradov0.1/BuscarDocente',
    			        data: {
    				        	nombre:$('#txtnom').val(),
    				        	apepat:$('#txtapepat').val(),
    				        	apemat:$('#txtapemat').val(),
    				        	dni:$('#txtnumdoc').val()
    				        },
    			        success: function(data)
    			        {
    			        	if (data==="vacio"){
    							alert("No se encontró al Docente");
    						}else {
    							var listaNombres = data.split("-|");
    							$("#txtnom").val(listaNombres[0]);
    							$("#txtapepat").val(listaNombres[1]);
    							$("#txtapemat").val(listaNombres[2]);
    							//$("#txtnac").val(listaNombres[3]);
    							var nac=listaNombres[3];
    							$('#txtnac option[value='+nac+']').attr('selected',true);
    							$("#txtnumdoc").val(listaNombres[4]);
    							$("#txtfecini").val(listaNombres[5]);
    							var ley=listaNombres[6]== "1" ? "SI" : "NO";
    							$('input[name="txtley"][value='+ley+']').prop('checked',true);
    							$("#txtmaygra").val(listaNombres[7]);
    							$("#txtmenmay").val(listaNombres[8]);
    							$("#txtuni").val(listaNombres[9]);
    							$("#txtpaiuni").val(listaNombres[10]);
    							var pregrado=listaNombres[11]== "1" ? "SI" : "NO";;
    							$('input[name="pregrado"][value='+pregrado+']').prop('checked',true);
    							var maestria=listaNombres[12]== "1" ? "SI" : "NO";;
    							$('input[name="maestria"][value='+maestria+']').prop('checked',true);
    							var doctorado=listaNombres[13]== "1" ? "SI" : "NO";;
    							$('input[name="doctor"][value='+doctorado+']').prop('checked',true);
    							$("#txtcat").val(listaNombres[14]);
    							$("#txtregded").val(listaNombres[15]);
    							$("#txthorcla").val(listaNombres[16]);
    							$("#txthoract").val(listaNombres[17]);
    							$("#txttothor").val(listaNombres[18]);
    							var v5=listaNombres[19]== "1" ? "SI" : "NO";;
    							$('input[name="txtdocinv"][value='+v5+']').prop('checked',true);
    							var v6=listaNombres[20]== "1" ? "SI" : "NO";;
    							$('input[name="txtdina"][value='+v6+']').prop('checked',true);
    							//$("#txtperaca").val(listaNombres[21]);
    							$('#selectSemestre').val(listaNombres[21]);
    							$("#txtobs").val(listaNombres[22]);
    							//listaNombres[23]
    							//listaNombres[24]
    							//listaNombres[25]
    							//listaNombres[26]
    							$("#txttelef").val(listaNombres[27]);
    							$("#txtemail").val(listaNombres[28]);
    							//$("#txtescuela").val(listaNombres[29]);
    							//$("#selectEscuela").val( $('#selectEscuela option:selected').text();listaNombres[29]);
    							$("#selectEscuela").val($("#selectEscuela").find('option:contains('+listaNombres[29]+')').val());
    							$("#iddoc").val(listaNombres[30]);
    							}	
    			        	}
    					});
    		 } else {
    		        alert("Error: La busqueda es por DNI o por los campos Nombre, Apellido paterno y materno");
    		 }
     });
     
     
     
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
});