<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="esS">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>


<style>
	.modal-header, h4, .close {
		background-color: #286090;
		color: white !important;
		text-align: center;
		font-size: 30px;
	}
</style>     

<title>Tenis </title>
</head>
<body>
   
  <h1 style="margin-bottom: 50px">MANTENIMIENDO GENERAL</h1>
             
        
        <div class="noticia-prin" style="">
        	<div class='row'>		
	            <div class="col-sm-4" style="margin-left: 100px">
	         		<div class='panel panel-default' style="border: none;">
		         		<div class='pane-body'>	
			         		<hi id="tit-noticia">
			         			<a>
			         				<button type="submit" class="btn btn-primary" id="validateBtnw1" onclick="window.location.href='/PI_TennisMesa/crudNoticia.jsp'">Mantenimiento de Noticias</button><br>&nbsp;<br>
			         			</a>
			         		</hi>
		         		</div>
		         		<div class='pane-body'>	
			         		<hi id="tit-noticia">
			         			<a>
			         				<button type="submit" class="btn btn-primary" id="validateBtnw1" onclick="window.location.href='/PI_TennisMesa/crudUsuario.jsp'">Mantenimiento de Usuarios</button><br>&nbsp;<br>
			         			</a>
			         		</hi>
		         		</div>
		         		<div class='pane-body'>	
			         		<hi id="tit-noticia">
			         			<a>
			         				<button type="submit" class="btn btn-primary" id="validateBtnw1" onclick="window.location.href='/PI_TennisMesa/crudProducto.jsp'">Mantenimiento de Productos</button><br>&nbsp;<br>
			         			</a>
			         		</hi>
		         		</div>
		         		<div class='pane-body'>	
			         		<hi id="tit-noticia">
			         			<a>
			         				<button type="submit" class="btn btn-primary" id="validateBtnw1" onclick="window.location.href='/PI_TennisMesa/Index.jsp'">Volver al Inicio</button><br>&nbsp;<br>
			         			</a>
			         		</hi>
		         		</div>
					</div>
	         
	           	</div>
	           	<div class="col-sm-4">
	         		<div class='panel panel-default' style="border: none;">
		         		<div class='pane-body'>	
			         		<hi id="tit-noticia">
			         			<a>
			         				<button type="submit" class="btn btn-primary" id="validateBtnw1" onclick="window.location.href='/PI_TennisMesa/crudPais.jsp'">Mantenimiento de Paises</button><br>&nbsp;<br>
			         			</a>
			         		</hi>
		         		</div>
		         		<div class='pane-body'>	
			         		<hi id="tit-noticia">
			         			<a>
			         				<button type="submit" class="btn btn-primary" id="validateBtnw1" onclick="window.location.href='/PI_TennisMesa/crudPedido.jsp'">Mantenimiento de Pedidos</button><br>&nbsp;<br>
			         			</a>
			         		</hi>
		         		</div>
		         		<div class='pane-body'>	
			         		<hi id="tit-noticia">
			         			<a>
			         				<button type="submit" class="btn btn-primary" id="validateBtnw1" onclick="window.location.href='/PI_TennisMesa/crudCategoria.jsp'">Mantenimiento de Categorias</button><br>&nbsp;<br>
			         			</a>
			         		</hi>
		         		</div>
					</div>
	         
	           	</div>     

            </div>
        </div>

 
    
    
    <script src="js/waves.js"></script>
    
    <script type="text/javascript">    
    Waves.init();
    Waves.attach('.boton', ['waves-button', 'waves-float']);
</script>        
</body>
</html>