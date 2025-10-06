<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Canción</title>
</head>
<body>

<h2>Agregar Nueva Cancion</h2>

<form:form method="post" action="/canciones/procesa/agregar" modelAttribute="cancion">
    <div>
        <label for="titulo">Titulo:</label>
        <form:input path="titulo" />
        <form:errors path="titulo" cssClass="error" />
    </div>

    <div>
        <label for="album">Album:</label>
        <form:input path="album" />
        <form:errors path="album" cssClass="error" />
    </div>

    <div>
        <label for="genero">Genero:</label>
        <form:input path="genero" />
        <form:errors path="genero" cssClass="error" />
    </div>

    <div>
        <label for="idioma">Idioma:</label>
        <form:input path="idioma" />
        <form:errors path="idioma" cssClass="error" />
    </div>

    <div>
        <label for="artista">Artista:</label>
            <form:select path="artista.id">
                <form:option value="" label="-- Selecciona un artista --" />
                <form:options items="${artistas}" itemValue="id" itemLabel="nombre" />
            </form:select>
        <form:errors path="artista" cssClass="error" />
    </div>

    <button type="submit">Agregar Cancion</button>
</form:form>

<br>
<a href="/canciones">Volver a lista de canciones</a>

</body>
</html>
