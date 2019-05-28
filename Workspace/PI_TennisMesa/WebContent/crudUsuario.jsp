<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="esS" >
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

 <div class="container">
 <h1>Crud de Usuario</h1>
		 <div class="col-md-23" >  
			  <form id="idFormElimina" action="eliminaUsuario">
			  		<input type="hidden" id="id_elimina" name="id">
			  </form>	
				
		       <form accept-charset="UTF-8"  action="consultaUsuario" class="simple_form" id="defaultForm2"  method="post">
					<div class="row">
						<div class="col-md-3">	
							<div class="form-group">
							  	<label class="control-label" for="id_nombre_filtro">Correo</label>
							  	<input class="form-control" id="id_nombre_filtro"  name="filtro" placeholder="Ingrese el correo" type="text" maxlength="70"/>
							</div>
						</div>
					</div>			
					<div class="row">
						<div class="col-md-3">
							<button type="submit" class="btn btn-primary" id="validateBtnw1" >FILTRA</button><br>&nbsp;<br>
						</div>
						<div class="col-md-3">
							<button type="button" data-toggle='modal' onclick="registrar();"  class='btn btn-success' id="validateBtnw2" >REGISTRA</button><br>&nbsp;<br>
						</div>
						<div class="col-md-3">
							<button type="button" class="btn btn-primary" onclick="window.location.href='/PI_TennisMesa/Mantenimiento.jsp'">VOLVER</button><br>&nbsp;<br>
						</div>
					</div>
					<div class="row" > 
						<div class="col-md-12">
								<div class="content" >
						
									<table class="table" >

										<tbody>  
												<c:forEach items="${usuarios}" var="x">
													<tr>
														<td style="font-size:40px" >${x.correo}</td>
															<tr>
																
																
																
																<td align="justify"><b>Nombre: </b>
																	${x.nombre}
																</td>
																<td>
																	<button type='button' data-toggle='modal' onclick="editar('${x.idUsuario}','${x.nombre}','${x.apellido}','${x.fechaRegistro}','${x.correo}','${x.contrasenia}','${x.ciudad}','${x.direccion}','${x.telefono}','${x.pais}');" class='btn btn-success' style='background-color:hsla(233, 100%, 100%, 0);'>
																		<img src='images/edit.gif' width='auto' height='auto' />
																	</button>
																</td>
																<td>
																	<button type='button' data-toggle='modal' onclick="eliminar('${x.idUsuario}');">
																		<img src='images/delete.gif' width='auto' height='auto' />
																	</button>
																</td>
															</tr>
																<td align="justify"><b>Apellido: </b> 
																	${x.apellido}
																</td>
															<tr>
																<td align="justify"><b>Fecha de Registro: </b>
																	${x.fechaRegistro}
																</td>	
															</tr>
																<td align="justify"><b>Contraseña: </b> 
																	${x.contrasenia}
																</td>	
															<tr>
																<td align="justify"><b>Ciudad: </b>
																	${x.ciudad}
																</td>
															</tr>
																<td align="justify"><b>Direccion: </b>
																	${x.direccion}
																</td>
															<tr>
																<td align="justify"><b>Telefono: </b> 
																	${x.telefono}
																</td>
															</tr>
																<td align="justify"><b>Pais: </b>
																	${x.pais.nombre}
																</td>
												</c:forEach>
										</tbody>
										</table>	
									
								</div>	
						</div>
					</div>
		 		</form>
		  </div>
  
  		 <div class="modal fade" id="idModalRegistra" >
			<div class="modal-dialog" style="width: 60%">
		
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Registro de Usuario</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form id="defaultForm" accept-charset="UTF-8" action="registraUsuario" class="form-horizontal"     method="post">
		                    <div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading">
		                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos del Usuario</a></h4>
		                            </div>
		                            <div id="stepOne" class="panel-collapse collapse in">
		                                <div class="panel-body">
		                                     <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_nombre" name="nombre" placeholder="Ingrese el nombre" type="text" maxlength="70"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_apellido">Apellido</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_apellido" name="apellido" placeholder="Ingrese el apellido" type="text" maxlength="70"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_correo">Correo</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_correo" name="correo" placeholder="Ingrese el correo" type="text" maxlength="70"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_contrasenia">Contraseña</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_contrasenia" name="contrasenia" placeholder="Ingrese la contraseña" type="text" maxlength="70"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_ciudad">Ciudad</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_ciudad" name="ciudad" placeholder="Ingrese la ciudad" type="text" maxlength="70"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_direccion">Direccion</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_direccion" name="direccion" placeholder="Ingrese la direccion" type="text" maxlength="70"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_telefono">Telefono</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_telefono" name="telefono" placeholder="Ingrese el telefono" type="text" maxlength="70"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_categoria">Pais</label>
		                                        <div class="col-lg-5">
													<select id="id_cboPais" name="pais"   class="form-control">
														<option value=" " >[ Seleccione ]</option>
													</select>
		                                        </div>
		                                    </div>
											
		                                    <div class="form-group">
		                                        <div class="col-lg-9 col-lg-offset-3">
		                                        	<button type="submit" class="btn btn-primary">REGISTRA</button>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        
		                    </div>
		                </form>   
				
				</div>
			</div>
		</div>
			
		</div>
  
		 <div class="modal fade" id="idModalActualiza" >
			<div class="modal-dialog" style="width: 60%">
		
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Actualiza Usuarios</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form id="defaultForm" accept-charset="UTF-8"  action="actualizaUsuario" class="form-horizontal"     method="post">
		                    <div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading">
		                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos del Usuario</a></h4>
		                            </div>
		                            <div id="stepOne" class="panel-collapse collapse in">
		                                <div class="panel-body">
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_ID">ID</label>
		                                        <div class="col-lg-5">
		                                           <input class="form-control" id="id_ID" readonly="readonly" name="id" type="text" maxlength="8"/>
		                                        </div>
		                                     </div>
		                                     <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_titulo">Nombre</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_titulo" name="titulo" placeholder="Ingrese el Titulo" type="text" maxlength="70"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_contenido">Contenido</label>
		                                        <div class="col-lg-5">
													<textarea id="id_contenido" name="contenido" cols="60" rows="10" placeholder="Ingrese el Contenido" maxlength="20000" ></textarea>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <div class="col-lg-9 col-lg-offset-3">
		                                        	<button type="submit" class="btn btn-primary">ACTUALIZA</button>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        
		                    </div>
		                </form>   
				
				</div>
			</div>
		</div>
			
		</div>

</div>

<script type="text/javascript">

function eliminar(id){	
	$('input[id=id_elimina]').val(id);
	$('#idFormElimina').submit();
}

function registrar(){
	$('#idModalRegistra').modal("show");
}

function editar(id,nombre,apellido,fechaRegistra,correo,contrasenia,ciudad,direccion,telefono,pais){	
	
	$('input[id=id_ID]').val(id);
	$('input[id=id_nombre]').val(nombre);
	$('input[id=id_apellido]').val(apellido);
	$('input[id=id_fechaRegistro]').val(fechaRegistro);
	$('input[id=id_correo]').val(correo);
	$('input[id=id_contrasenia]').val(contrasenia);
	$('input[id=id_ciudad]').val(ciudad);
	$('input[id=id_direccion]').val(direccion);
	$('input[id=id_telefono]').val(telefono);
	$('[id=id_pais]').val(pais.idPais);
	$('#idModalActualiza').modal("show");
}

$(document).ready( function(){
	$.getJSON("cargaPais",{}, function (data){
		console.log(data);

		$.each(data.lstPais, function(index, item){
			$("#id_cboPais").append("<option value="+item.idPais+">"+ item.nombre +"</option>");
		});
	});
});
</script>

<script type="text/javascript">
$(document).ready(function() {
    $('#defaultForm').bootstrapValidator({
        message: 'This value is not valid',
        excluded: ':disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	titulo: {
        		selector : '#id_reg_titulo',
                validators: {
                    notEmpty: {
                        message: 'El titulo es un campo obligatorio'
                    },
                    stringLength :{
                    	message:'El titulo es de 5 a 100 caracteres',
                    	min : 5,
                    	max : 100
                    }
                }
            },
            contenido: {
        		selector : '#id_reg_contenido',
                validators: {
                    notEmpty: {
                        message: 'El contenido es un campo obligatorio'
                    },
                    stringLength :{
                    	message:'El contenido es de 5 a 100 caracteres',
                    	min : 5,
                    	max : 5000000
                    }
                }
            }
       	}    
     }).on('error.form.bv', function(e) {
            console.log('error');

            // Active the panel element containing the first invalid element
            var $form         = $(e.target),
                validator     = $form.data('bootstrapValidator'),
                $invalidField = validator.getInvalidFields().eq(0),
                $collapse     = $invalidField.parents('.collapse');

            $collapse.collapse('show');
    });
});

function processFiles(files) {
	var files = files[0];
	var reader = new FileReader();
	reader.onload = function (e) {
		document.getElementById("list").innerHTML = "<img src='"+e.target.result+"' width='500px' height='250px' />";
	};
	reader.readAsDataURL(files); 
}
</script>

</body>
</html> 