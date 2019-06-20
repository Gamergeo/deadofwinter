<%@include file="/pages/headerOnlyMeta.jsp" %>

<!-- Line 4 : Additional Rule --> 
<tr id="mainObjectiveCardLine-4">
	<td id="mainObjectiveCardCell-4">

		<div class="cardSetUpLabel">Mise en place</div>

		<div class="cardMoral">MARQUEUR DE MORAL : ${mainObjective.difficultyNormal.moral}</div>
		
		<div class="cardTurn">COMPTEUR  DE MANCHES : ${mainObjective.difficultyNormal.numberTurn}</div>
    
    <div class="cardText cardLineSize">${additionalRulePart}</div>
		
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