<%@include file="/pages/headerOnlyMeta.jsp" %>

<!-- Line 4 : Additional Rule -->
<tr id="mainObjectiveCardLine-4">
  <td id="mainObjectiveCardCell-4">

    <div class="cardSetUpLabel">Mise en place</div>

    <div class="cardMoral">
      MARQUEUR DE MORAL : 
        <form:input size="1" class="cardMoral cardInput" path="difficultyNormal.moral" value="${mainObjective.difficultyNormal.moral}" />
    </div>
    
    <div class="cardTurn">
      COMPTEUR DE MANCHES :
        <form:input size="1" class="cardMoral cardInput" path="difficultyNormal.numberTurn" value="${mainObjective.difficultyNormal.numberTurn}" />
    </div> 

    <div class="divBlockForInput">
      <form:textarea id="addRuleTextArea" rows="9" style="width:100%" class="cardText cardInput" path="additionalRule.text"/>
    </div>
  </td>
  
  <c:set var="descriptionTypeAddRule" value="<%=DescriptionType.ADDITIONAL_RULE%>"/>
  <form:hidden id="replacingNumbers-${descriptionTypeAddRule}" path="difficultyNormal.replacingNumbersAdditionalRule"/>
  <td id="replacingNumbersBlock-${descriptionTypeAddRule}" class="replacingNumbersBlock" style="display: none;" />
</tr>