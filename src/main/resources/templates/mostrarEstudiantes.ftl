<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Mostrar Estudiantes</title>

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
    <h2>Mostrar Estudiantes</h2>
    <table class="table table-hover">
        <tbody>
        <tr><th>Matricula</th><th>Nombre</th><th>Apellido</th><th>Telefono</th><th>Modificar</th></tr>
        <#list listaEstudiante as estudiante>
        <tr><td> ${estudiante.matricula?string["0"]}</td>
            <td>${estudiante.nombre}</td>
            <td>${estudiante.apellido}</td>
            <td>${estudiante.telefono}</td>
            <td><a href="/modificarEstudiante/${estudiante_index}">Modificar</td></a></tr>
        </#list>
        </tbody>
    </table>
    <div class="form-group">
       <a href="/crearEstudiante"><input type="Button" class="form-control" value="Crear Estudiante"  ></a>
    </div>
</div
</body>
</html>