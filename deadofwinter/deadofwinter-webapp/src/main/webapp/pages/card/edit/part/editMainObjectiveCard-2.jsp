<%@ include file="/pages/headerOnlyMeta.jsp" %>
	
<c:if test="${isLevelNormal}">
  <!-- Line 2 : Title -->
  <tr id="mainObjectiveCardLine-2">
    <td id="mainObjectiveCardCell-2">
        <form:input style="width:100%" class="cardTitle cardInput" path="name" value="${mainObjective.name}" />
    </td>
  </tr>
</c:if>
  
<c:if test="${isLevelHard}">
  <form:hidden path="name" value="${mainObjective.name}" />
  <jsp:include page="../../view/part/mainObjectiveCard-2.jsp" />
</c:if>