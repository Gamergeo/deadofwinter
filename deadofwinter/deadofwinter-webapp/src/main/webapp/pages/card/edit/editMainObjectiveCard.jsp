<%@include file="/pages/headerOnlyMeta.jsp" %>

<!-- CSS Import and Definitions -->
<link href="<c:url value='/css/card/mainObjectiveCard.css' />" rel="stylesheet" media="all" type="text/css">
<link href="<c:url value='/css/general/font.css' />" rel="stylesheet" media="all" type="text/css">
<link href="<c:url value='/css/card/editMainObjectiveCard.css' />" rel="stylesheet" media="all" type="text/css">

<!-- JS Import -->
<script src='<c:url value="/js/mainObjective/displayEditCard.js" />'></script>

<c:set var="level" value="${level}"/>
<c:set var="levelNormal" value="<%=DifficultyLevel.NORMAL.toString()%>"/>
<c:set var="levelHard" value="<%=DifficultyLevel.HARD.toString()%>"/>

<c:if test="${level==levelNormal}" var="isLevelNormal" scope="request"/>
<c:if test="${level==levelHard}" var="isLevelHard" scope="request"/>

<form:form action='<c:url value="/mainObjective/save.do" />' method="post" modelAttribute="mainObjective">
  <table id="cardTable">
  
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