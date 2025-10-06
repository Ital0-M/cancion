<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle de Canción</title>
</head>
<body>
    <h1>Detalle de Cancion</h1>
    <p>Titulo: ${cancion.titulo}</p>
    <p>Artista: ${cancion.artista}</p>
    <p>Album: ${cancion.album}</p>
    <p>Genero: ${cancion.genero}</p>
    <p>Idioma: ${cancion.idioma}</p>
    <p>Fecha de creacion: ${cancion.fechaCreacion}</p>
    <p>Fecha de actualizacion: ${cancion.fechaActualizacion}</p>
    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>