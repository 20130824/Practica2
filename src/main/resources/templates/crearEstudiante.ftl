<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Crear Estudiante</title>

<!-- Bootstrap -->
<link href="/css/bootstrap.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="col-md-4 col-md-offset-4">
<h2>Crear Estudiante</h2>
	<form method='post' action='/crearEstudiante' style="padding-bottom:20px">
		<div class="form-group">
			<label>Matricula</label>
			<input type="text" name="matricula" class="form-control">
		</div>
		<div class="form-group">
			<label>Nombre</label>
			<input type="text"  name="nombre" class="form-control">
		</div>
		<div class="form-group">
			<label>Apellido</label>
			<input type="text" name="apellido" class="form-control">
		</div>
		<div class="form-group">
		  <label>Telefono</label>
			<input type="text" name="telefono" class="form-control">
	  </div>
	     <div class="form-group">
            <input type="submit" id="btnSubmit" class="form-control" value="Crear">
        </div>

        <div class="form-group">
            <input class="form-control" type="reset" value="Limpiar campos"/>
</div>
        <div class="form-group">
            <a href="/mostrarEstudiantes"><input type="Button" class="form-control" value="Volver a listado de estudiantes"  ></a>
        </div>
	</form>
	</div
</body>
</html>
