<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/mystyle.css">
<title>Creación de evento</title>
</head>
<body>
<img id = header src="/images/Skyline-Sevilla.png"/></img>
	<h1>¿Cómo quieres guardar el evento?</h1>
	<div id=calendar> 
	<form method="post" action="/ToCalendarController">
		<fieldset>
			<label class="col-25">Restaurante: &nbsp;</label> <input class="col-75" type="text" id="summary" name="summary" value="${requestScope.summary}" required/></br>
			<label class="col-25">Notas:&nbsp;</label> <input class="col-75" type="text" id="description" name="description" value="${requestScope.description}" required/></br>
			<label class="col-25">Dirección: &nbsp;</label><input class="col-75" type="text" id="location" name="location" value="${requestScope.location}" required/></br>
			<label class="col-25">Fecha: &nbsp;</label><input class="col-75" type="date" id="start" name="start" required/></br>
			<label class="col-25">Hora:&nbsp;</label> <input class="col-75" type="text" id="time" name="time" placeholder="20:30 (HH:MM)" required/></br></br>
			<input id = buttom type="submit" value="Guardar en Calendar"/>
		</fieldset>
	</form>
	</div>
</body>
</html>