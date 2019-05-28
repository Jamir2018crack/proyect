
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script src="js/codigos.js" type="text/javascript"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<link rel="stylesheet" href="css/style.css"/>




<!-- js -->
<script src="js/jquery-2.1.4.js"></script>
    
</head>





<body>
<%
Connection con;
String url = "jdbc:mysql://localhost:3306/tenisdb";
String Driver = "com.mysql.jdbc.Driver";
String user="root";
String clave = "mysql";
Class.forName(Driver);
con=DriverManager.getConnection(url,user,clave);

PreparedStatement ps;
ResultSet rs;
ps=con.prepareStatement("SELECT idnoticia, titulo, substring(contenido,1,460) as contenido FROM noticia ORDER by idnoticia DESC");
rs = ps.executeQuery();

%>
	<div id="IdArriba"><a href="javascript:void(0)"><span></span></a></div>
	<!-- header -->
	<div class="header">
		<div class="header-left">
			<div class="container">
				<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<div class="logo">
							<h1>
								<a href="Index.jsp">
									Tennis Club
									<img class="logo-position" src="images/logo.png" alt="" />
								</a>
							</h1>
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						<nav class="link-effect-9" id="link-effect-9">
							<ul class="nav navbar-nav">
								<li>
									<a href="Index.jsp" class="hvr-overline-from-center scroll">Inicio</a>
								</li>
								<li>
									<a href="Noticias.jsp" class="hvr-overline-from-center scroll">Noticias</a>
								</li>
								<li>
									<a href="Tienda.jsp" class="hvr-overline-from-center scroll">Tienda</a>
								</li>
								<li>
									<a href="Galeria.jsp" class="hvr-overline-from-center scroll">Galeria</a>
								</li>
								<li>
									<a href="Ranking.jsp" class="hvr-overline-from-center scroll">Ranking</a>
								</li>
								<li class="active">
									<a href="Contactos.jsp" class="hvr-overline-from-center scroll">Contactos</a>
								</li>
							</ul>
						</nav>
					</div>
					<!-- /.navbar-collapse -->
				</nav>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<!-- //header -->
        <!--Slider-->
        <section class="slider-container">
        	<ul id="slider" class="slider-wrapper">
            	<li class="slider-current">
                	<img src="images/imagen1.jpg" alt="Slider Imagen 1">
                    <div class="caption">
                    	<h3 class="caption-title">MEJORANDO CADA DIA MÁS</h3>
                        <p>Así con el deporte, uno crece como persona</p>
                    </div>
                </li>
                <li>
                	<img src="images/imagen2.jpg" alt="Slider Imagen 1">
                    <div class="caption">
                    	<h3 class="caption-title">SIEMPRE HACIA ADELANTE</h3>
                        <p>Nunca te rindas y lucha por ser mejor</p>
                    </div>
                </li>
                <li>
                	<img src="images/imagen3.jpg" alt="Slider Imagen 1">
                    <div class="caption">
                    	<h3 class="caption-title">SUEÑA EN GRANDE</h3>
                        <p>Vive la vida y no dejes que la vida te viva</p>
                    </div>
                </li>
            </ul>
            <ul id="slider-controls" class="slider-controls">
            	<li class="active"></li>
            	<li></li>
            	<li></li>
            </ul>
        </section>
         
        
       <div class="noticia-prin">
        	<div class="enc-noticia">ULTIMAS NOTICIAS</div>
        	
        	<%
			while(rs.next()){
			%>        
			
            <div class="der-noticia">
           		<hi id="tit-noticia"><%= rs.getString("titulo")%></hi>
            	<p class="text-noticia">
                	<%= rs.getString("contenido")%>
           	 	</p>
         
           	</div>

            <div class="ima-not">
            	<img src="images/null.jpg" alt="imagen-not-prin">
            </div>
            
            <%}%>
        </div>
        


</body>

</html> 