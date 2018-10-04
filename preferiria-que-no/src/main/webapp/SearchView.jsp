<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/mystyle.css">
<title>B�squeda</title>
</head>
<body>
<img id = header src="/images/Skyline-Sevilla.png"/></img>
<h1> Hoy quiero comer en: </h1>
<div id="searchDiv">
		<form id="searchForm" action="/SearchController" method="get"/>
		
		<input type="text" id="location" name="location"  placeholder="Escribe tu ciudad o una direcci�n."required/></br>
        <br>
        <label><b>Elige un tipo de restaurante: </b></label>
            <select id="category" name = "category" required/ >
                <option value="restaurants">Todos</option>
                <option value="afghani">Afgano</option>
                <option value="african">Africano</option>
                <option value="german">Alem�n</option>
                <option value="tradamerican">Americano(tradicional)</option>
                <option value="andalusian">Andaluz</option>
                <option value="argentine">Argentino</option>
                <option value="arabia">�rabe</option>
                <option value="rotisserie_chicken">Asador de pollos</option>
                <option value="steak">Asadores</option>
                <option value="asturian">Asturiano</option>
                <option value="australian">Australiano</option>
                <option value="bbq">Barbacoa</option>
                <option value="tapas">Bares de tapas</option>
                <option value="belgian">Belga</option>
                <option value="sandwiches">Bocatas</option>
                <option value="brasseries">Braser�as</option>
                <option value="brailian">Brasile�o</option>
                <option value="british">Brit�nico</option>
                <option value="buffets">Buffet libre</option>
                <option value="bulgarian">B�lgaro</option>
                <option value="cafeteria">Cafeter�a</option>
                <option value="dinnertheater">Caf� teatro</option>
                <option value="caribbean">Caribe�o</option>
                <option value="gamemeat">Carnes ex�ticas</option>
                <option value="chinese">Chino</option>
                <option value="dimsum">Comida china tradicional</option>
                <option value="soulfood">Cocina afro-americana</option>
                <option value="armenian">Cocina armenia</option>
                <option value="panasian">Cocina asi�tica</option>
                <option value="catalan">Cocina catalana</option>
                <option value="srilankan">Cocina cingalesa</option>
                <option value="guamanian">Cocina de Guam</option>
                <option value="signature_cuisine">Cocina de autor</option>
                <option value="honduran">Cocina hondure�a</option>
                <option value="irish">Cocina irlandesa</option>
                <option value="laotian">Cocina laosiana</option>
                <option value="nicaraguan">Cocina nicarag�ense</option>
                <option value="nikkei">Cocina nikkei</option>
                <option value="syrian">Cocina siria</option>
                <option value="swissfood">Cocina suiza</option>
                <option value="raw_food">Comida cruda</option>
                <option value="hotdogs">Comida r�pida</option>
                <option value="korean">Coreano</option>
                <option value="creperies">Creper�as</option>
                <option value="cuban">Cubano</option>
                <option value="breakfast_brunch">Desayuno y brunch</option>
                <option value="salad">Ensaladas</option>
                <option value="scandinavian">Escandinavo</option>
                <option value="spanish">Espa�ol</option>
                <option value="arroceria_paella">Arrocer�a/Paella</option>
                <option value="ethiopian">Et�ope</option>
                <option value="modern_european">Europeo moderno</option>
                <option value="filipino">Filipino</option>
                <option value="fishnchips">Fish & Chips</option>
                <option value="french">Franc�s</option>
                <option value="reunion">Cocina de Reuni�n</option>
                <option value="mauritius">Cocina mauriciana</option>
                <option value="freiduria">Freidur�a</option>
                <option value="asianfusion">Fusi�n asi�tica</option>
                <option value="galician">Gallego</option>
                <option value="gastropubs">Gastrobar</option>
                <option value="waffles">Gofres</option>
                <option value="greek">Griego</option>
                <option value="halal">Halal</option>
                <option value="burgers">Hamburgueser�as</option>
                <option value="hawaiian">Hawaiano</option>
                <option value="himalayan">Himalayo/nepal�</option>
                <option value="hungarian">H�ngaro</option>
                <option value="indpak">Indio</option>
                <option value="international">Internacional</option>
                <option value="italian">Italiano</option>
                <option value="japanese">Japon�s</option>
                <option value="ramen">Ramen</option>
                <option value="kosher">Jud�o</option>
                <option value="kebab">Kebab</option>
                <option value="latin">Latinoamericano</option>
                <option value="colombian">Cocina colombiana</option>
                <option value="venezuelan">Cocina venezolana</option>
                <option value="seafood">Marisquer�as</option>
                <option value="moroccan">Marroqu�</option>
                <option value="mediterranean">Mediterr�neo</option>
                <option value="falafel">Fal�fel</option>
                <option value="diners">Mes�n</option>
                <option value="mexican">Mexicano</option>
                <option value="noodles">Noodles</option>
                <option value="mideastern">Oriente Medio</option>
                <option value="lebanese">Liban�s</option>
                <option value="pakistani">Pakistan�</option>
                <option value="hotdog">Perritos calientes</option>
                <option value="persian">Persa/iran�</option>
                <option value="peruvian">Peruano</option>
                <option value="pizza">Pizzer�a</option>
                <option value="polish">Polaco</option>
                <option value="chickenshop">Poller�a</option>
                <option value="portuguese">Portugu�s</option>
                <option value="romanian">Rumano</option>
                <option value="russian">Ruso</option>
                <option value="gluten_free">Sin gluten</option>
                <option value="soup">Sopas</option>
                <option value="foodstands">Stands de alimentaci�n</option>
                <option value="supperclubs">Supper Club</option>
                <option value="sushi">Sushi</option>
                <option value="delis">S�ndwiches</option>
                <option value="bistros">Taberna</option>
                <option value="tabernas">Tabernas</option>
                <option value="thai">Tailand�s</option>
                <option value="tapasmallplates">Tapas, pinchos o raciones</option>
                <option value="turkish">Turco</option>
                <option value="basque">Vasco</option>
                <option value="vegan">Vegano</option>
                <option value="vegetarian">Vegetariano</option>
                <option value="vietnamese">Vietnamita</option>
                <option value="wok">Wok</option>	  
            </select>
 </br>
 <br>
			<em><input id="buttom" type="submit" value="�Comienza la b�squeda!"></em>
		</form>
	</div>
</body>
</html>