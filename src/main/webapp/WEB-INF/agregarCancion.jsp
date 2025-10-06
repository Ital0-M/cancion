<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Agregar Cancion</title>
</head>
<body>
    <h1>Agregar Nueva Cancion</h1>
    
    <form:form modelAttribute="cancion" method="POST" action="/canciones/procesa/agregar">
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
            <form:label path="album">album:</form:label>
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
            <button type="submit">Agregar Cancion</button>
        </div>
    </form:form>
    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>
