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
         $('#txttothor').val(parseInt(num1) + parseInt(num2));
         
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
$('#btnRegistrarDocente').on('click', function(){ 
	//console.log("click en boton Registrar Docente.");
        $("#form1").valid();
        if($("#form1").valid()){   // test for validity
        //alert("Correcto.");
        var linea = []; 
     	var item={};
        item.txtnom			=	$('#txtnom').val().trim();
        item.txtapepat      =   $('#txtapepat').val().trim();
        item.txtapemat      = 	$('#txtapemat').val().trim();
  		item.txtnac			= 	$('#txtnac').val().trim();
  		item.txtnumdoc      = 	$('#txtnumdoc').val().trim();
  		item.txtfecini      = 	$('#txtfecini').val().trim();
  		item.txtley			= 	$('#txtley:checked').val(); console.log(item.txtley);//ponerlo tambien en el for del servlet
  		item.maygra			= 	$('#txtmaygra').val();
  		item.menmay			= 	$('#txtmenmay').val();
  		item.uni			= 	$('#txtuni').val();
  		item.paiuni			= 	$('#txtpaiuni').val();
  		item.preg			= 	$('#pregrado:checked').val();
  		item.maes			= 	$('#maestria:checked').val();
  		item.doct			= 	$('#doctor:checked').val();
  		item.cat			= 	$('#txtcat').val();
  		item.regded			= 	$('#txtregded').val();
  		item.horcla			= 	$('#txthorcla').val();
  		item.horact			= 	$('#txthoract').val();
  		item.tothor			= 	$('#txttothor').val();
  		item.docinv			= 	$('#txtdocinv:checked').val();
  		item.dina			= 	$('#txtdina:checked').val();
  		//item.peraca			= 	$('#txtperaca').val();
  		item.peraca			= 	$('#selectSemestre').val();
  		item.obs			= 	$('#txtobs').val();
  		//item.licen			= 	0;//$('#txtlicen:checked').val();
  		//item.sl01			= 	0//$('#txtsl01:checked').val();
  		//item.sl02			= 	0//$('#txtsl02:checked').val();
  		//item.sl03			= 	0//$('#txtsl03:checked').val();
  		item.email			= 	$('#txtemail').val();
  		//item.escuela		= 	$('#txtescuela').val();
  		//item.escuela		=	$('#selectEscuela option:selected').text();
  		item.escuela		=	$('#selectEscuela').val();
  		item.telefono		= 	$('#txttelef').val();
  		
      	linea.push(item);    
      	//agregar lo de observaciones y los flags (pregrado, maestria, doctorado)
      	var datosxlinea={};
    	datosxlinea.linea=linea;
    	//mostrar en consola (para validar la cadena de texto)
    	var datatable=JSON.stringify(datosxlinea);
    	console.log(datatable);
    	//
    	
    	$.ajax({
	        type:'POST',
	        url: '/TallerIntegradov0.1/RegistrarDocente',
	        dataType:'JSON',
			data:{
				 objetojson:JSON.stringify(datosxlinea)
				 },
	      success: function(data)
        {	
	    	 console.log("Data :"+data);
	    	 if(data=='1'){
	    		 alert("Datos correctos, pase a crear el usuario para el docente.");
	    		 document.getElementById("btnCREAR").disabled=false;
	    		 var esc = $('#selectEscuela').val();
	    		 document.getElementById("txtescuela").setAttribute('value', esc);
	    		 
	    		 
	    	 }	else {
	    		 alert("Error, el docente ya existe.")
	    	 }
        }
	    });
      	
     } else {
        alert("Datos incompletos.");
     }
	 
});
/////////////////////////////////////////////////////////   
     $("#form1").validate({
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
			txtperaca:	{required:true},
			txtlicen :	{required:true},
			txttelef :  {required:true, max:15}
			
		  },
		  messages: {
            txtnom: 	{	required:"Ingresar nombre.",
		    				minlength:"Minimo de caracteres es de 2."},
		  	txtapepat: 	{	required:"Ingresar Apellido Paterno.",
		  					minlength:"Minimo de caracteres es de 2."},
		  	txtapemat: 	{	required:"Ingresar Apellido Materno.",
			  				minlength:"Minimo de caracteres es de 2."},
		  	txtnac: 	{       required: "Seleccionar Pais." },
		  	txtnumdoc:	{	required:"Ingrese un valor", minlength:"Ingrese mínimo 8 digitos",
		  					maxlength:"Ingrese menos de 11 digitos"},
		  	txtfecini:	{	required:"Ingrese su fecha de Nacimiento."},
		  	txtley	:	{	required:"Seleccione un valor."},
		  	txtmaygra: 	{       required: "Seleccionar Grado." },
		  	txtmenmay:	{	required:"Ingrese Mencion."},
		  	txtuni	 :	{	required:"Ingrese universidad."},
		  	txtpaiuni:	{	required:"Seleccionar Pais."},
		  	pregrado :	{	required:"Seleccione un valor"},
			maestria :	{	required:"Seleccione un valor"},
			doctor	 :	{	required:"Seleccione un valor"},
			txtcat: 	{       required: "Seleccionar Categoria." },
			txtregded:	{	required:"Seleccionar Regimen."},
			txthorcla:	{	required:"Ingresar horas.", min:"Minimo 0.",max:"Maximo 40 horas."},
			txthoract:	{	required:"Ingresar horas.", min:"Minimo 0.",max:"Maximo 40 horas."},
			txtdocinv:	{	required:"Seleccione un valor."},
			txtdina  :	{	required:"Seleccione un valor."},			
			txtperaca:	{	required:"Ingrese el periodo."},
			txtlicen :	{	required:"Seleccione un valor."}
		  }
		});

});

