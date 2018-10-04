<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/mystyle.css">
<title>Resultados</title>
</head>
<body>
<img id = header src="/images/Skyline-Sevilla.png"/></img>
<% int i = 0; %>
<c:forEach items ="${requestScope.busqueda}" var="entry">
<% i++; %>
</c:forEach>
<% String localizacion = request.getParameter("location"); %>
<h1> Mostrando <%= i %> restaurantes en "<%=localizacion %>" </h1>
<c:forEach items = "${requestScope.busqueda}" var="entry">
	<fieldset id = busquedas>
		<legend>
			<a href="/BusinessController?id=<c:out value = '${entry.id}'></c:out>">
				<h2 class="nombreRest"><c:out value = "${entry.name}"></c:out></h2>
			</a>
		</legend>
		<img id= imagenes src="<c:out value = "${entry.imageUrl}"></c:out>" alt = "<c:out value = "${entry.name}"></c:out>">
		<ul>
   		<li><b>Puntuación: </b>${entry.rating}/5 de ${entry.reviewCount} opiniones en <i>Yelp</i>.</li>
		<li><b>Categorías: </b></li>
			<ol>
				<c:forEach items="${entry.categories}" var="category">
	    			<li><c:out value = '${category.title}'></c:out></li>
  				</c:forEach>
    		</ol>
		<li><b>Dirección: </b><span>
			<c:forEach items="${entry.location.displayAddress}" var="direction">
			<c:out value = "${direction}"></c:out>
		</c:forEach>
			</span></li>
		</ul>
	</fieldset>
</c:forEach>
</body>
</html>