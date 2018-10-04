<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/mystyle.css">
<title>Búsqueda</title>
</head>
<body>
<img id = header src="/images/Skyline-Sevilla.png"/></img>
<h1> Hoy quiero comer en: </h1>
<div id="searchDiv">
		<form id="searchForm" action="/SearchController" method="get"/>
		
		<input type="text" id="location" name="location"  placeholder="Escribe tu ciudad o una dirección."required/></br>
        <br>
        <label><b>Elige un tipo de restaurante: </b></label>
            <select id="category" name = "category" required/ >
                <option value="restaurants">Todos</option>
                <option value="afghani">Afgano</option>
                <option value="african">Africano</option>
                <option value="german">Alemán</option>
                <option value="tradamerican">Americano(tradicional)</option>
                <option value="andalusian">Andaluz</option>
                <option value="argentine">Argentino</option>
                <option value="arabia">Árabe</option>
                <option value="rotisserie_chicken">Asador de pollos</option>
                <option value="steak">Asadores</option>
                <option value="asturian">Asturiano</option>
                <option value="australian">Australiano</option>
                <option value="bbq">Barbacoa</option>
                <option value="tapas">Bares de tapas</option>
                <option value="belgian">Belga</option>
                <option value="sandwiches">Bocatas</option>
                <option value="brasseries">Braserías</option>
                <option value="brailian">Brasileño</option>
                <option value="british">Británico</option>
                <option value="buffets">Buffet libre</option>
                <option value="bulgarian">Búlgaro</option>
                <option value="cafeteria">Cafetería</option>
                <option value="dinnertheater">Café teatro</option>
                <option value="caribbean">Caribeño</option>
                <option value="gamemeat">Carnes exóticas</option>
                <option value="chinese">Chino</option>
                <option value="dimsum">Comida china tradicional</option>
                <option value="soulfood">Cocina afro-americana</option>
                <option value="armenian">Cocina armenia</option>
                <option value="panasian">Cocina asiática</option>
                <option value="catalan">Cocina catalana</option>
                <option value="srilankan">Cocina cingalesa</option>
                <option value="guamanian">Cocina de Guam</option>
                <option value="signature_cuisine">Cocina de autor</option>
                <option value="honduran">Cocina hondureña</option>
                <option value="irish">Cocina irlandesa</option>
                <option value="laotian">Cocina laosiana</option>
                <option value="nicaraguan">Cocina nicaragüense</option>
                <option value="nikkei">Cocina nikkei</option>
                <option value="syrian">Cocina siria</option>
                <option value="swissfood">Cocina suiza</option>
                <option value="raw_food">Comida cruda</option>
                <option value="hotdogs">Comida rápida</option>
                <option value="korean">Coreano</option>
                <option value="creperies">Creperías</option>
                <option value="cuban">Cubano</option>
                <option value="breakfast_brunch">Desayuno y brunch</option>
                <option value="salad">Ensaladas</option>
                <option value="scandinavian">Escandinavo</option>
                <option value="spanish">Español</option>
                <option value="arroceria_paella">Arrocería/Paella</option>
                <option value="ethiopian">Etíope</option>
                <option value="modern_european">Europeo moderno</option>
                <option value="filipino">Filipino</option>
                <option value="fishnchips">Fish & Chips</option>
                <option value="french">Francés</option>
                <option value="reunion">Cocina de Reunión</option>
                <option value="mauritius">Cocina mauriciana</option>
                <option value="freiduria">Freiduría</option>
                <option value="asianfusion">Fusión asiática</option>
                <option value="galician">Gallego</option>
                <option value="gastropubs">Gastrobar</option>
                <option value="waffles">Gofres</option>
                <option value="greek">Griego</option>
                <option value="halal">Halal</option>
                <option value="burgers">Hamburgueserías</option>
                <option value="hawaiian">Hawaiano</option>
                <option value="himalayan">Himalayo/nepalí</option>
                <option value="hungarian">Húngaro</option>
                <option value="indpak">Indio</option>
                <option value="international">Internacional</option>
                <option value="italian">Italiano</option>
                <option value="japanese">Japonés</option>
                <option value="ramen">Ramen</option>
                <option value="kosher">Judío</option>
                <option value="kebab">Kebab</option>
                <option value="latin">Latinoamericano</option>
                <option value="colombian">Cocina colombiana</option>
                <option value="venezuelan">Cocina venezolana</option>
                <option value="seafood">Marisquerías</option>
                <option value="moroccan">Marroquí</option>
                <option value="mediterranean">Mediterráneo</option>
                <option value="falafel">Faláfel</option>
                <option value="diners">Mesón</option>
                <option value="mexican">Mexicano</option>
                <option value="noodles">Noodles</option>
                <option value="mideastern">Oriente Medio</option>
                <option value="lebanese">Libanés</option>
                <option value="pakistani">Pakistaní</option>
                <option value="hotdog">Perritos calientes</option>
                <option value="persian">Persa/iraní</option>
                <option value="peruvian">Peruano</option>
                <option value="pizza">Pizzería</option>
                <option value="polish">Polaco</option>
                <option value="chickenshop">Pollería</option>
                <option value="portuguese">Portugués</option>
                <option value="romanian">Rumano</option>
                <option value="russian">Ruso</option>
                <option value="gluten_free">Sin gluten</option>
                <option value="soup">Sopas</option>
                <option value="foodstands">Stands de alimentación</option>
                <option value="supperclubs">Supper Club</option>
                <option value="sushi">Sushi</option>
                <option value="delis">Sándwiches</option>
                <option value="bistros">Taberna</option>
                <option value="tabernas">Tabernas</option>
                <option value="thai">Tailandés</option>
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
			<em><input id="buttom" type="submit" value="¡Comienza la búsqueda!"></em>
		</form>
	</div>
</body>
</html>