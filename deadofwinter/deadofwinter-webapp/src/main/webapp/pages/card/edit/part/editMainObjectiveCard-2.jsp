<%@include file="/pages/headerOnlyMeta.jsp" %>

<c:if test="${isDifficultyNormal}">
  <!-- Line 2 : Title -->
  <tr id="mainObjectiveCardLine-2">
    <td id="mainObjectiveCardCell-2">
      <div class="cardTitleEdit">
        <form:input class="cardInput cardTitleEditInput" path="name"/>
      </div>
    </td>
  </tr>
</c:if>
  
<c:if test="${isDifficultyHard}">
  <form:hidden path="name" />
  <jsp:include page="../../view/part/mainObjectiveCard-2.jsp" />
</c:if>