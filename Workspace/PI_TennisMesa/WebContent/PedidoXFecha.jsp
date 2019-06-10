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
 <h1>Crud de Pedido</h1>
		 <div class="col-md-23" >  
			  <form id="idFormElimina" action="eliminaPedido">
			  		<input type="hidden" id="id_elimina" name="id">
			  </form>	
				
		       <form accept-charset="UTF-8"  action="consultaXPedidoFecha" class="simple_form" id="defaultForm2"  method="post">
					<div class="row">
						<div class="col-md-3">	
							<div class="form-group">
							  	<label>Fecha Inicio</label>
							  	<input name="filtroBean.fechaIni" type="date" />
							</div>
							<div class="form-group">
							  	<label>Fecha Fin</label>
							  	<input name="filtroBean.fechaFin" type="date" />
							</div>
						</div>
					</div>			
					<div class="row">
						<div class="col-md-3">
							<button type="submit" class="btn btn-primary" id="validateBtnw1" >FILTRA</button><br>&nbsp;<br>
						</div>
						

						<a href="Index.jsp">Atras</a>	
					</div>
					<div class="row" > 
						<div class="col-md-12">
								<div class="content" >
						
									<table class="table" >

										<tbody>  
												<c:forEach items="${lstConsulta}" var="x">
													<tr>
														<td style="font-size:40px" >ID: ${x.idFactura}</td>
															<tr>
																<td align="justify">Fecha de Registro: ${x.fechaRegistro}</td>
																<td>
																	<button type='button' data-toggle='modal' onclick="editar('${x.idNoticia}','${x.titulo}','${x.contenido}');" class='btn btn-success' style='background-color:hsla(233, 100%, 100%, 0);'>
																		<img src='images/edit.gif' width='auto' height='auto' />
																	</button>
																</td>
																<td>
																	<button type='button' data-toggle='modal' onclick="eliminar('${x.idNoticia}');">
																		<img src='images/delete.gif' width='auto' height='auto' />
																	</button>
																</td>
															</tr>

																<td>
																	Estado: ${x.estado}
																</td>
															<tr>
																<td>
																	Cliente: ${x.idUsuario}
																</td>	
															</tr>
																<td>
																<br>
																</td>	
															<tr>
														</tr>
												</c:forEach>
										</tbody>
										</table>	
									
								</div>	
						</div>
					</div>
		 		</form>
		  </div>
  
  
		 <div class="modal fade" id="idModalActualiza" >
			<div class="modal-dialog" style="width: 60%">
		
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Actualiza Estado de Pedido</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form id="defaultForm" accept-charset="UTF-8"  action="actualizaPedido" class="form-horizontal"     method="post">
		                    <div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading">
		                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos del Pedido</a></h4>
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
		                                        <label class="col-lg-3 control-label" for="id_contenido">Estado</label>
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

function editar(id,titulo,contenido){	
	
	$('input[id=id_ID]').val(id);
	$('input[id=id_titulo]').val(titulo);
	$('[id=id_contenido]').val(contenido);
	$('#idModalActualiza').modal("show");
}
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
</script>

</body>
</html> 