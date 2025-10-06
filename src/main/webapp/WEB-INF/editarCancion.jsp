<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Cancion</title>
</head>
<body>
    <h1>Editar Cancion</h1>
    
    <form:form modelAttribute="cancion" method="POST" action="/canciones/procesa/editar/${cancion.id}">
        <div>
            <form:label path="titulo">Titulo:</form:label>
            <form:input path="titulo"/>
            <form:errors path="titulo" cssClass="error"/>
        </div>
        <div>
            <form:label path="artista">Artista:</form:label>
            <form:input path="artista"/>
            <form:errors path="artista" cssClass="error"/>
        </div>
        <div>
            <form:label path="album">Album:</form:label>
            <form:input path="album"/>
            <form:errors path="album" cssClass="error"/>
        </div>
        <div>
            <form:label path="genero">Genero:</form:label>
            <form:input path="genero"/>
            <form:errors path="genero" cssClass="error"/>
        </div>
        <div>
            <form:label path="idioma">Idioma:</form:label>
            <form:input path="idioma"/>
            <form:errors path="idioma" cssClass="error"/>
        </div>
        <div>
            <button type="submit">Actualizar Cancion</button>
        </div>
    </form:form>

    <br/>
    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>
