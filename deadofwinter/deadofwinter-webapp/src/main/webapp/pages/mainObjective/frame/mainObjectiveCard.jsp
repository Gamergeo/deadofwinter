<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<c:url var="cssSizeUrl" value="/css/mainObjectiveCard.css"/>
<link href="${cssSizeUrl}" rel="stylesheet" media="all" type="text/css">
	
<c:url var="cssfontUrl" value="/css/font.css"/>
<link href="${cssfontUrl}" rel="stylesheet" media="all" type="text/css">

 <style type="text/css" media="screen">

	body {
	 	background-color: black;
	}
</style>


<table id="cardTable">
	
	<!-- Line 1 : Header --> 
	<tr id="mainObjectiveCardLine-1">
			<td id="mainObjectiveCardCell-1"></td>
	</tr>
	
	<!-- Line 2 : Title --> 
	<tr id="mainObjectiveCardLine-2">
			<td id="mainObjectiveCardCell-2">
					<!-- div necessary cause of font (too much space in bottom of letters -->
					<div class="cardTitle">${mainObjective.name}</div>
			</td>
	</tr>

	<!-- Line 3 : 1st separation --> 
	<tr id="mainObjectiveCardLine-3">
			<td id="mainObjectiveCardCell-3"></td>
	</tr>
	
	<!-- Line 4 : Additional Rule --> 
	<tr id="mainObjectiveCardLine-4">
			<td id="mainObjectiveCardCell-4">
			
					<div class="cardSetUpLabel">Mise en place</div>
			
					<div class="cardMoral">MARQUEUR DE MORAL : ${mainObjective.difficultyNormal.moral}</div>
					
					<div class="cardTurn">COMPTEUR  DE MANCHES : ${mainObjective.difficultyNormal.numberTurn}</div>
					
					<c:forEach  var="additionalRulePart" items="${mainObjective.normalAdditionalRules}">
						
						<!--  Interline -->
						<c:if test="${empty additionalRulePart}">
							<div class="cardInterline"></div>
						</c:if>
						<c:if test="${not empty additionalRulePart}">
							<div class="cardText cardLineSize">${additionalRulePart}</div>
						</c:if>
						
					</c:forEach>
			
			</td>
	</tr>
	
	<!-- Line 5 : 2nd separation --> 
	<tr id="mainObjectiveCardLine-5">
			<td id="mainObjectiveCardCell-5"></td>
	</tr>
	
	<!-- Line 6 : Victory conditions --> 
	<tr id="mainObjectiveCardLine-6">
			<td id="mainObjectiveCardCell-6">
			
					<div class="cardSetUpLabel">Victoire</div>
			
					<c:forEach  var="victoryPart" items="${mainObjective.normalVictoryText}">
						
						<!--  Interline -->
						<c:if test="${empty victoryPart}">
							<div class="cardInterline"></div>
						</c:if>
						<c:if test="${not empty victoryPart}">
							<div class="cardText">${victoryPart}</div>
						</c:if>
						
					</c:forEach>
			
			</td>
	</tr>
	
	<!-- Line 7 : 3rd separation --> 
	<tr id="mainObjectiveCardLine-7">
			<td id="mainObjectiveCardCell-7"></td>
	</tr>
	
	<!-- Line 8 : Time and footer  --> 
	<tr id="mainObjectiveCardLine-8">			
		<td id="mainObjectiveCardCell-8">
		
				<div class="cardSetUpLabel">Duree</div>
				
				<div class="cardMoral">${mainObjective.time.text}</div>
			
			</td>
	</tr>
</table>
