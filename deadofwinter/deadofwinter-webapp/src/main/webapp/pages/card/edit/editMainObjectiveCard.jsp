<%@include file="/pages/headerOnlyMeta.jsp" %>

<!-- CSS Import and Definitions -->
<link href="<c:url value='/css/card/mainObjectiveCard.css' />" rel="stylesheet" media="all" type="text/css">
<link href="<c:url value='/css/general/font.css' />" rel="stylesheet" media="all" type="text/css">
<link href="<c:url value='/css/card/editMainObjectiveCard.css' />" rel="stylesheet" media="all" type="text/css">

<!-- JS Import -->
<script src='<c:url value="/js/mainObjective/displayEditCard.js" />'></script>

<c:set scope="request" var="difficultyNormal" value="<%=DifficultyLevel.NORMAL%>" />
<c:set scope="request" var="difficultyHard" value="<%=DifficultyLevel.HARD%>" />

<script type="text/javascript">

  $(document).ready(function() {
  		<c:if test="${isDifficultyNormal}">
      	// On ajoute les evenements de change sur les textarea pour determiner le nombre de chiffre à remplacer
      	$("#victoryTextArea").change(function() {
      		updateReplacingNumberBlock($('#victoryTextArea').val(), DESCRIPTION_TYPE["VICTORY"], "${difficultyNormal}");
      	});
      
      	// On ajoute les evenements de change sur les textarea pour determiner le nombre de chiffre à remplacer
      	$("#addRuleTextArea").change(function() {
      		updateReplacingNumberBlock($('#addRuleTextArea').val(), DESCRIPTION_TYPE["ADDITIONAL_RULE"], "${difficultyNormal}");
      	});

        updateReplacingNumberBlock("${mainObjective.victory.text}", DESCRIPTION_TYPE["VICTORY"], "${difficultyNormal}");
  			updateReplacingNumberBlock("${mainObjective.additionalRule.text}", DESCRIPTION_TYPE["ADDITIONAL_RULE"], "${difficultyNormal}");
      </c:if>

			<c:if test="${isDifficultyHard}">
        updateReplacingNumberBlock("${mainObjective.victory.text}", DESCRIPTION_TYPE["VICTORY"], "${difficultyHard}");
  			updateReplacingNumberBlock("${mainObjective.additionalRule.text}", DESCRIPTION_TYPE["ADDITIONAL_RULE"], "${difficultyHard}");
			</c:if>
  });
</script>

<c:url value="/mainObjective/save.do" var="urlSubmitForm"/>
<form:form action='${urlSubmitForm}' method="post" modelAttribute="mainObjective">
  <table id="cardTable">
  
  
    <c:if test="${not empty errors}">
      <tr>
        <td id="errorMessage">
          THERE ARE ERRORS !
        </td>
      </tr>
      <c:forEach var="error" items="${errors}">
     	  <tr>
          <td id="errorMessage">
            ${error}
          </td>
        </tr>
      </c:forEach>
    </c:if>
  
    <!-- Line 1 : Header -->
    <jsp:include page="part/editMainObjectiveCard-1.jsp" />
    
    <!-- Line 2 : Title -->
    <jsp:include page="part/editMainObjectiveCard-2.jsp" />
    
    <!-- Line 3 : 1st separation -->
    <jsp:include page="part/editMainObjectiveCard-3.jsp" />
  
    <!-- Line 4 : Additional Rule -->
    <jsp:include page="part/editMainObjectiveCard-4.jsp" />
    
    <!-- Line 5 : 2nd separation -->
    <jsp:include page="part/editMainObjectiveCard-5.jsp" />
  
    <!-- Line 6 : Victory conditions -->
    <jsp:include page="part/editMainObjectiveCard-6.jsp" />
  
    <!-- Line 7 : 3rd separation -->
    <jsp:include page="part/editMainObjectiveCard-7.jsp" />
  
    <!-- Line 8 : Time and footer  -->
    <jsp:include page="part/editMainObjectiveCard-8.jsp" />
  </table>
</form:form>