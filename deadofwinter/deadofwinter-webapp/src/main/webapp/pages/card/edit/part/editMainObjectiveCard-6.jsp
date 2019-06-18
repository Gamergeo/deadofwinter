<%@include file="/pages/headerOnlyMeta.jsp" %>

<!-- Line 6 : Victory conditions -->
<tr id="mainObjectiveCardLine-6">
  <td id="mainObjectiveCardCell-6">

    <div class="cardSetUpLabel">Victoire</div>

    <div class="divBlockForInput">
      <c:if test="${isDifficultyNormal}">
        <form:textarea id="victoryTextArea" rows="4" style="width:100%" class="cardText cardInput" path="victory.text"/>
      </c:if>
      <c:if test="${isDifficultyHard}">
        <div class="cardText">${mainObjective.victory.text}</div>
        <form:hidden path="victory.text" />
      </c:if>
    </div>
  </td>
  
  <c:set var="descriptionTypeVictory" value="<%=DescriptionType.VICTORY%>"/>
  <form:hidden id='replacingNumbers-${descriptionTypeVictory}' path="difficultyNormal.replacingNumbersVictory"/>
  <td id="replacingNumbersBlock-${descriptionTypeVictory}" class="replacingNumbersBlock" style="display: none;" />
</tr>