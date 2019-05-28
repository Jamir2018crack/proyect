
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
								<li class="active">
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
								<li>
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
        
         
        
       <div class="noticia-prin">
        	<div class="enc-noticia">ULTIMAS NOTICIAS</div>
        	<div class='row'>
	        	<%
				while(rs.next()){
				%>        
						
	            <div class="col-sm-4">
	         		<div class='panel panel-default'>
		         		<div class='panel-heading' style='overflow:hidden'>
		         		   
					            	<img src="images/null.jpg" alt="imagen-not-prin" style="width: 250px">
					            
					    </div>
		         		<div class='pane-body' style="height: 200px">	
			         		<hi id="tit-noticia">
			         			<a href='DetalleNoticia.jsp?id=<%= rs.getString("idNoticia")%>'>
			         		<%= rs.getString("titulo")%></a></hi>
			            	<p class="text-noticia" style="height: 125px">
			                	<%= rs.getString("contenido")%>
			           	 	</p>
		         		</div>
					</div>
	         
	           	</div>   
	            <%}%>
            </div>
        </div>
        


</body>

</html> 