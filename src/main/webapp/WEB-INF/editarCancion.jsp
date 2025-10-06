<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Cancion</title>
</head>
    <body>
        <h1>Editar Cancion</h1>
        <div>
            <form action="/canciones/formulario/editar/${cancion.id}" method="post">
            <label>Titulo:</label>
            <input type="text" name="titulo" value="${cancion.titulo}" />
            <form:errors path="titulo" cssClass="error" />
        </div>
        <div>
            <label>Artista:</label>
                <select name="artista.id">
                    <c:forEach items="${artistas}" var="artista">
                        <option value="${artista.id}"
                            <c:if test="${cancion.artista != null && artista.id == cancion.artista.id}">
                                selected="selected"
                            </c:if>>
                            ${artista.nombre} ${artista.apellido}
                        </option>
                    </c:forEach>
                </select>
        </div>
        <div>
            <label>Album:</label>
            <input type="text" name="album" value="${cancion.album}" />
            <form:errors path="album" cssClass="error" />
        </div>
        <div>
            <label>Genero:</label>
            <input type="text" name="genero" value="${cancion.genero}" />
            <form:errors path="genero" cssClass="error" />
        </div>
        <div>
            <label>Idioma:</label>
            <input type="text" name="idioma" value="${cancion.idioma}" />
            <form:errors path="idioma" cssClass="error" />
        </div>
        <button type="submit">Actualizar Cancion</button>
        <br>
            <a href="/canciones">Volver a lista de canciones</a>
    </body>
</html>
