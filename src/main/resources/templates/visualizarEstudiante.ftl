<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visualizar estudiante</title>

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
    <h2>Editar Estudiante</h2>

    <div class="form-group">
        <label>Matricula</label>
        <input type="text" name="matricula" class="form-control" value="${Estudiante.matricula?string["0"]}">
    </div>
    <div class="form-group">
        <label>Nombre</label>
        <input type="text"  name="nombre" class="form-control" value="${Estudiante.nombre}">
    </div>
    <div class="form-group">
        <label>Apellido</label>
        <input type="text" name="apellido" class="form-control" value="${Estudiante.apellido}">
    </div>
    <div class="form-group">
        <label>Telefono</label>
        <input type="text" name="telefono" class="form-control" value="${Estudiante.telefono}">
    </div>




</div
</body>
</html>