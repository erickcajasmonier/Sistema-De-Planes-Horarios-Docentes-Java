<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, maximum-scale=1">

<title>Sistema USMP</title>
<link rel="icon" href="<%=request.getContextPath()%>/Imagenes/Docentes/uni.ico" type="image/png">

<link href="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/CSS/Index/index.css" rel="stylesheet" type="text/css">

<!--[if IE]><style type="text/css">.pie {behavior:url(PIE.htc);}</style><![endif]-->

<script type="text/javascript" src="<%=request.getContextPath()%>/Recursos/Jquery/jquery.1.8.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Recursos/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Recursos/js/jquery-scrolltofixed.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Recursos/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Recursos/js/jquery.isotope.js"></script>

</head>
<body>
	<header class="header" id="header"><!--header-start-->
	<div class="container">
    	<img src="<%=request.getContextPath()%>/Imagenes/Index/usmp.png" alt=""><br><br><br><br>
        <h1 class="animated fadeInDown delay-07s">Bienvenido a la FIA</h1>
        <ul class="we-create animated fadeInUp delay-1s">
        	<li>Facultad de Ingeniería y Arquitectura</li>
        </ul>
        <ul class="we-create animated fadeInUp delay-1s">
        	<li>Bienvenido ${sessionScope.profile} <strong>${sessionScope.username}</strong>, al sistema de optimización de los procesos de generación de planes, horarios y docentes.</li>
        </ul>
            <a class="link animated fadeInUp delay-1s servicelink" href="#Portfolio">Empezar</a>
    </div>
</header><!--header-end-->

<nav class="main-nav-outer" id="test"><!--main-nav-start-->
	<div class="container">
        <ul class="main-nav">
            <li class="small-logo"><a href="#header"><img src="<%=request.getContextPath()%>/Imagenes/Index/logo.ico" alt=""></a></li>
        </ul>
        <a class="res-nav_click" href="#"><i class="fa-bars"></i></a>
    </div>
</nav><!--main-nav-end-->



<section class="main-section paddind" id="Portfolio"><!--main-section-start-->
	<div class="container">
    	<h2>MENU</h2>
    	<h6> Elija un Módulo</h6>
	</div>
    <div class="portfolioContainer wow fadeInUp delay-04s">
    <%Integer perfil = (Integer) session.getAttribute("perfil"); %>
      <%if(perfil == 1) {%> <!-- ADMINISTRADOR -->
            	<div class=" Portfolio-box printdesign">
                	<a href="<%=request.getContextPath()%>/Docentes/principalDocentes.jsp"><img src="<%=request.getContextPath()%>/Imagenes/Index/teacher.jpg" alt=""></a>	
                	<h3 style="font-weight: bold">Módulo Docente</h3>
                    <p></p>
                </div>
                <div class="Portfolio-box webdesign">
                	<a href="<%=request.getContextPath()%>/Planes/principalPlanes.jsp"><img src="<%=request.getContextPath()%>/Imagenes/Index/plan.jpg" alt=""></a>	
                	<h3 style="font-weight: bold">Módulo Planes</h3>
                    <p></p>
                </div>
                <div class=" Portfolio-box branding">
                	<a href="<%=request.getContextPath()%>/Horarios/principalHorarios.jsp"><img src="<%=request.getContextPath()%>/Imagenes/Index/horario.jpg" alt=""></a>	
                	<h3 style="font-weight: bold">Módulo Horario</h3>
                    <p></p>
                </div>
                <div class=" Portfolio-box branding">
                	<a href="<%=request.getContextPath()%>/Usuarios/principalUsuarios.jsp"><img src="<%=request.getContextPath()%>/Imagenes/Index/horario.jpg" alt=""></a>	
                	<h3 style="font-weight: bold">Módulo Usuarios</h3>
                    <p></p>
                </div>
          <%}if(perfil == 3) {%>   <!-- DIRECTOR -->
                <div class=" Portfolio-box printdesign">
                	<a href="<%=request.getContextPath()%>/Docentes/principalDocentes.jsp"><img src="<%=request.getContextPath()%>/Imagenes/Index/teacher.jpg" alt=""></a>	
                	<h3 style="font-weight: bold">Módulo Docente</h3>
                    <p></p>
                </div>               
          <%}%>
          <%if(perfil == 4) {%>   <!-- DIRECTOR -->
                <div class=" Portfolio-box printdesign">
                	<a href="<%=request.getContextPath()%>/Docentes/principalDocentes.jsp"><img src="<%=request.getContextPath()%>/Imagenes/Index/teacher.jpg" alt=""></a>	
                	<h3 style="font-weight: bold">Módulo Docente</h3>
                    <p></p>
                </div>               
          <%}%>
          <%if(perfil == 2) {%>   <!-- DIRECTOR -->
                <div class="Portfolio-box webdesign">
                	<a href="<%=request.getContextPath()%>/Planes/principalPlanes.jsp"><img src="<%=request.getContextPath()%>/Imagenes/Index/plan.jpg" alt=""></a>	
                	<h3 style="font-weight: bold">Módulo Planes</h3>
                    <p></p>
                </div>              
          <%}%>
          <%if(perfil == 5) {%>   <!-- DIRECTOR -->
                <div class="Portfolio-box webdesign">
                	<a href="<%=request.getContextPath()%>/Planes/principalPlanes.jsp"><img src="<%=request.getContextPath()%>/Imagenes/Index/plan.jpg" alt=""></a>	
                	<h3 style="font-weight: bold">Módulo Planes</h3>
                    <p></p>
                </div>  
                <div class=" Portfolio-box printdesign">
                	<a href="<%=request.getContextPath()%>/Docentes/principalDocentes.jsp"><img src="<%=request.getContextPath()%>/Imagenes/Index/teacher.jpg" alt=""></a>	
                	<h3 style="font-weight: bold">Módulo Docente</h3>
                    <p></p>
                </div>             
          <%}%>
          <%if(perfil == 6) {%>   <!-- COORDINADOR DE ESCUELA -->
                <div class=" Portfolio-box printdesign">
                	<a href="<%=request.getContextPath()%>/Docentes/principalDocentes.jsp"><img src="<%=request.getContextPath()%>/Imagenes/Index/teacher.jpg" alt=""></a>	
                	<h3 style="font-weight: bold">Módulo Docente</h3>
                    <p></p>
                </div>   
                <div class=" Portfolio-box branding">
                	<a href="<%=request.getContextPath()%>/Horarios/principalHorarios.jsp"><img src="<%=request.getContextPath()%>/Imagenes/Index/horario.jpg" alt=""></a>	
                	<h3 style="font-weight: bold">Módulo Horario</h3>
                    <p></p>
                </div>            
          <%}%>
          <%if(perfil == 7) {%>   <!-- DEPARTAMENTO -->
                <div class=" Portfolio-box printdesign">
                	<a href="<%=request.getContextPath()%>/Docentes/principalDocentes.jsp"><img src="<%=request.getContextPath()%>/Imagenes/Index/teacher.jpg" alt=""></a>	
                	<h3 style="font-weight: bold">Módulo Docente</h3>
                    <p></p>
                </div>              
          <%}%>
          
                
                
    </div>
</section><!--main-section-end-->


<footer class="footer">
    <div class="container">
    
        <span class="copyright">Taller de Proyecto - Fia Usmp - 2017</span>
    </div>
</footer>


<script type="text/javascript">
    $(document).ready(function(e) {
        $('#test').scrollToFixed();
        $('.res-nav_click').click(function(){
            $('.main-nav').slideToggle();
            return false    
            
        });
        
    });
</script>

  <script>
    wow = new WOW(
      {
        animateClass: 'animated',
        offset:       100
      }
    );
    wow.init();
  </script>


<script type="text/javascript">
	$(window).load(function(){
		
		$('.main-nav li a, .servicelink').bind('click',function(event){
			var $anchor = $(this);
			
			$('html, body').stop().animate({
				scrollTop: $($anchor.attr('href')).offset().top - 102
			}, 1500,'easeInOutExpo');
			/*
			if you don't want to use the easing effects:
			$('html, body').stop().animate({
				scrollTop: $($anchor.attr('href')).offset().top
			}, 1000);
			*/
      if ($(window).width() < 768 ) { 
        $('.main-nav').hide(); 
      }
			event.preventDefault();
		});
	})
</script>

<script type="text/javascript">

$(window).load(function(){
  
  
  var $container = $('.portfolioContainer'),
      $body = $('body'),
      colW = 375,
      columns = null;

  
  $container.isotope({
    // disable window resizing
    resizable: true,
    masonry: {
      columnWidth: colW
    }
  });
  
  $(window).smartresize(function(){
    // check if columns has changed
    var currentColumns = Math.floor( ( $body.width() -30 ) / colW );
    if ( currentColumns !== columns ) {
      // set new column count
      columns = currentColumns;
      // apply width to container manually, then trigger relayout
      $container.width( columns * colW )
        .isotope('reLayout');
    }
    
  }).smartresize(); // trigger resize to set container width
  $('.portfolioFilter a').click(function(){
        $('.portfolioFilter .current').removeClass('current');
        $(this).addClass('current');
 
        var selector = $(this).attr('data-filter');
        $container.isotope({
			
            filter: selector,
         });
         return false;
    });
  
});

</script>
	
</body>
</html>