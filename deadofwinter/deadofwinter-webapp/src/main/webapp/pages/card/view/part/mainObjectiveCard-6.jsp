<%@ include file="/pages/headerOnlyMeta.jsp" %>

<!-- Line 6 : Victory conditions -->
<tr id="mainObjectiveCardLine-6">
  <td id="mainObjectiveCardCell-6">

    <div class="cardSetUpLabel">Victoire</div> <c:forEach var="victoryPart" items="${mainObjective.normalVictoryText}">

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