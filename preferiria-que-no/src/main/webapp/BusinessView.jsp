<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/mystyle.css">
<title>Información</title>
</head>
<body>
	<img id = header src="/images/Skyline-Sevilla.png"/></img>
	<h1>${business.name}</h1>

	<div id="mapa">
		<iframe id="imgmapa" src="https://www.google.com/maps/embed/v1/${map}&key=AIzaSyAtVQaOBZvu3WtsYfZu7L8qnWlitTTBZi4" allowfullscreen></iframe>
		
	</div>

	<div id="informacion">
			<ul>
				<li><b>Puntuación: </b>${business.rating}/5 de ${business.reviewCount} opiniones en <i>Yelp</i>.</li>
				<li><b>Categorías: </b></li><ol>
				<c:forEach items="${requestScope.business.categories}" var="entry">
					<li><c:out value = '${entry.title}'></c:out></li>
				</c:forEach>
				</ol>
				<li><b>Dirección: </b><span>
				<c:forEach items="${requestScope.business.location.displayAddress}" var="entry">
					<c:out value = "${entry}"></c:out>
				</c:forEach>
				</span></li>
				<li><b>Teléfono: </b>${business.phone}</li>
				<li><b>¿Está abierto ahora?: </b>
				<% String isOpenNow = "Sí, ¡Abierto!"; %>
				<c:if test = "${business.hours[0].isOpenNow == 'false'}">
					<% isOpenNow = "No, está cerrado..."; %>
				</c:if>
				<%= isOpenNow %>
				</li>
			</ul>
	</div>
	<div id="botones">
		<h3>¿Vas a ir?</h3>
		<form method="post" action="/SaveController">
			<input type="hidden" id="id" name="id" value="${business.id}"/>
			<span>
				<input type="submit" id="google" name="google" value="Crear evento en Google Calendar"/>
				<a href="/SearchView.jsp"><i>Preferiría que no...</i></a>
			</span>
		</form>
		<form method='post' action='/BusinessController?id=${id}'>
			</br><div id="mapForm"></div>
		</form>
	</div>

	<div id="imagesRestaurant">
		<c:forEach items ="${requestScope.business.photos}" var="entry">
			<img src="<c:out value = '${entry}'></c:out>"/>
		</c:forEach>
	</div>

	
<script>
var x = document.getElementById("mapForm");

if (navigator.geolocation) {
	navigator.geolocation.getCurrentPosition(showPosition);
} 
function showPosition(position) {
    x.innerHTML = "<input type='hidden' id='lat' name='lat' value='" + position.coords.latitude
    	+ "'/><input type='hidden' id='lon' name='lon' value='" + position.coords.longitude 
    	+ "'/><input type='submit' id='locationForm' name='locationForm' value='¡Obtener ruta!'/>";
}
</script>

</body>
</html>