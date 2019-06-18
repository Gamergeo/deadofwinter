<%@include file="/pages/headerOnlyMeta.jsp" %>

<!-- Line 4 : Additional Rule -->
<tr id="mainObjectiveCardLine-4">
  <td id="mainObjectiveCardCell-4">

    <div class="cardSetUpLabel">Mise en place</div>

    <div class="cardMoral">
      MARQUEUR DE MORAL : 
        
        <c:if test="${isDifficultyNormal}">
          <form:input size="1" class="cardMoral cardInput" path="difficultyNormal.moral" />
          <form:hidden path="difficultyHard.moral"/>
        </c:if>
        <c:if test="${isDifficultyHard}">
          <form:input size="1" class="cardMoral cardInput" path="difficultyHard.moral" />
          <form:hidden path="difficultyNormal.moral" />
        </c:if>
    </div>
    
    <div class="cardTurn">
      COMPTEUR DE MANCHES :
        <c:if test="${isDifficultyNormal}">
          <form:input size="1" class="cardMoral cardInput" path="difficultyNormal.numberTurn"/>
          <form:hidden path="difficultyHard.numberTurn"/>
        </c:if>
        <c:if test="${isDifficultyHard}">
          <form:input size="1" class="cardMoral cardInput" path="difficultyHard.numberTurn" />
          <form:hidden path="difficultyNormal.numberTurn" />
        </c:if>
    </div> 

    <div class="divBlockForInput">
      <c:if test="${isDifficultyNormal}">
        <form:textarea id="addRuleTextArea" rows="9" style="width:100%" class="cardText cardInput" path="additionalRule.text"/>
      </c:if>
      <c:if test="${isDifficultyHard}">
        <div class="cardText">${mainObjective.additionalRule.text}</div>
          <form:hidden path="additionalRule.text" />
      </c:if>
    </div>
  </td>
  
  <c:set var="descriptionTypeAddRule" value="<%=DescriptionType.ADDITIONAL_RULE%>"/>
  <form:hidden id="replacingNumbers-${descriptionTypeAddRule}" path="difficultyNormal.replacingNumbersAdditionalRule"/>
  <td id="replacingNumbersBlock-${descriptionTypeAddRule}" class="replacingNumbersBlock" style="display: none;" />
</tr>