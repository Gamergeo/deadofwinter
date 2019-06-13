<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url var="cssResetUrl" value="/css/reset.css"/>
<link href="${cssResetUrl}" rel="stylesheet" media="all" type="text/css">
	
<c:url var="cssSizeUrl" value="/css/mainObjectiveSize.css"/>
<link href="${cssSizeUrl}" rel="stylesheet" media="all" type="text/css">
	
<c:url var="cssfontUrl" value="/css/font.css"/>
<link href="${cssfontUrl}" rel="stylesheet" media="all" type="text/css">

 <style type="text/css" media="screen">

	body {
	 	background-color: red;
	}
	
	.cardTitle {
		text-align: center;
		font-size: 38px;
		color: rgba(0, 0, 0, 0.7);
  	font-family: "Headline";
	}

	/* Add background image in css for each cell of the table */
	<c:forEach var = "line" begin = "0" end = "10">

		<c:forEach var = "col" begin = "0" end = "2">
			#mainObjectiveImageCell-${line}-${col} {
				background-image: url(images/Template/Template-${line}-${col}.png);
				border:none;
			}
			
		</c:forEach>
	</c:forEach>
</style>
<table>
	
	<!-- Ligne 0 : En-tête --> 
	<tr id="mainObjectiveImageLine-0">
		<c:forEach var = "col" begin = "0" end = "2">
			<td id="mainObjectiveImageCell-0-${col}" class="mainObjectiveImageColumn-${col}" />
		</c:forEach>
	</tr>
	
	<!-- Ligne 1 : Nom --> 
	<tr id="mainObjectiveImageLine-1">

		<td id="mainObjectiveImageCell-1-0" class="mainObjectiveImageColumn-0" />
		
		<td id="mainObjectiveImageCell-1-1" class="mainObjectiveImageColumn-1 cardTitle">
			Sombre est la nuit
		</td>
		
		<td id="mainObjectiveImageCell-1-2" class="mainObjectiveImageColumn-2" />
	</tr>
	
	<!-- Ligne 2 : Mise en place --> 
	<tr id="mainObjectiveImageLine-2">
		<c:forEach var = "col" begin = "0" end = "2">
			<td id="mainObjectiveImageCell-2-${col}" class="mainObjectiveImageColumn-${col}" />
		</c:forEach>
	</tr>
	
	<!-- Ligne 3 : Moral --> 
	<tr id="mainObjectiveImageLine-3">
		<c:forEach var = "col" begin = "0" end = "2">
			<td id="mainObjectiveImageCell-3-${col}" class="mainObjectiveImageColumn-${col}" />
		</c:forEach>
	</tr>
	
	<!-- Ligne 4 : Nombre de tour --> 
	<tr id="mainObjectiveImageLine-4">
		<c:forEach var = "col" begin = "0" end = "2">
			<td id="mainObjectiveImageCell-4-${col}" class="mainObjectiveImageColumn-${col}" />
		</c:forEach>
	</tr>
	
	<!-- Ligne 5 : Règles additionnelles --> 
	<tr id="mainObjectiveImageLine-5">
		<c:forEach var = "col" begin = "0" end = "2">
			<td id="mainObjectiveImageCell-5-${col}" class="mainObjectiveImageColumn-${col}" />
		</c:forEach>
	</tr>
	
	<!-- Ligne 6 : Victoire (titre) --> 
	<tr id="mainObjectiveImageLine-6">
		<c:forEach var = "col" begin = "0" end = "2">
			<td id="mainObjectiveImageCell-6-${col}" class="mainObjectiveImageColumn-${col}" />
		</c:forEach>
	</tr>
	
	<!-- Ligne 7 : Victoire (texte) --> 
	<tr id="mainObjectiveImageLine-7">
		<c:forEach var = "col" begin = "0" end = "2">
			<td id="mainObjectiveImageCell-7-${col}" class="mainObjectiveImageColumn-${col}" />
		</c:forEach>
	</tr>
	
	<!-- Ligne 8 : Durée (titre) --> 
	<tr id="mainObjectiveImageLine-8">
		<c:forEach var = "col" begin = "0" end = "2">
			<td id="mainObjectiveImageCell-8-${col}" class="mainObjectiveImageColumn-${col}" />
		</c:forEach>
	</tr>
	
	<!-- Ligne 9 : Durée (texte) --> 
	<tr id="mainObjectiveImageLine-9">
		<c:forEach var = "col" begin = "0" end = "2">
			<td id="mainObjectiveImageCell-9-${col}" class="mainObjectiveImageColumn-${col}" />
		</c:forEach>
	</tr>
	
	<!-- Ligne 10 : Fin de la carte --> 
	<tr id="mainObjectiveImageLine-10">
		<c:forEach var = "col" begin = "0" end = "2">
			<td id="mainObjectiveImageCell-10-${col}" class="mainObjectiveImageColumn-${col}" />
		</c:forEach>
	</tr>
	
</table>