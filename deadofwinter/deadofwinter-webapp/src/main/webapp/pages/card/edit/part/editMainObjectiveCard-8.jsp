<%@include file="/pages/headerOnlyMeta.jsp" %>

<!-- Line 8 : Time and footer  --> 

<c:if test="${isDifficultyNormal}">
  <tr id="mainObjectiveCardLine-8">
    <td id="mainObjectiveCardCell-8">
  
      <div class="cardSetUpLabel">Duree</div>
  
      <div class="cardMoral">
        
          <form:select class="cardInput cardMoral" path="time">
            <form:option value="<%=TimeName.SHORT%>"><%=TimeName.SHORT.getText()%></form:option>
            <form:option value="<%=TimeName.MEDIUM%>"><%=TimeName.MEDIUM.getText()%></form:option>
            <form:option value="<%=TimeName.LONG%>"><%=TimeName.LONG.getText()%></form:option>
          </form:select>
      </div>
    </td>
  </tr>
</c:if>


<c:if test="${isDifficultyHard}">
  <form:hidden path="time" />
  <jsp:include page="../../view/part/mainObjectiveCard-8.jsp" />
</c:if>