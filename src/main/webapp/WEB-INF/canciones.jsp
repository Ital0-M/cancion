<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Canciones</title>
</head>
<body>
    <h1>Lista de Canciones</h1>
    <table>
        <tr>
            <th>Titulo</th>
            <th>Artista</th>
            <th>Detalle</th>
        </tr>
        <c:forEach var="cancion" items="${canciones}">
            <tr>
                <td>${cancion.titulo}</td>
                <td>${cancion.artista}</td>
                <td><a href="/canciones/detalle/${cancion.id}">Detalle</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>