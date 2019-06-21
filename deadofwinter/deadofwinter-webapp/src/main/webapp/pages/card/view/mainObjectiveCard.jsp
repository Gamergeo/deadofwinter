<%@ include file="/pages/headerOnlyMeta.jsp" %>
	
<!-- CSS Import and Definitions -->
<link href="<c:url value='/css/card/mainObjectiveCard.css' />" rel="stylesheet" media="all" type="text/css">

<script type="text/javascript" src="<c:url value='/js/mainObjective/displayViewCard.js'/>"></script>

<script type="text/javascript">

	$(document).ready(function() {
		$(".cardText").each(function() {
			$(this).html(replaceTextWithImages($(this).html()));
		});
	});

</script>

<table id="cardTable">
	
	<!-- Line 1 : Header --> 
  <jsp:include page="part/mainObjectiveCard-1.jsp" />
  
  <!-- Line 2 : Title --> 
  <jsp:include page="part/mainObjectiveCard-2.jsp" />
  
  <!-- Line 3 : 1st separation --> 
  <jsp:include page="part/mainObjectiveCard-3.jsp" />
  
  <!-- Line 4 : Additional Rule --> 
  <jsp:include page="part/mainObjectiveCard-4.jsp" />
	
	<!-- Line 5 : 2nd separation --> 
  <jsp:include page="part/mainObjectiveCard-5.jsp" />
	
	<!-- Line 6 : Victory conditions --> 
  <jsp:include page="part/mainObjectiveCard-6.jsp" />
  
	<!-- Line 7 : 3rd separation -->
  <jsp:include page="part/mainObjectiveCard-7.jsp" />
  
  <!-- Line 8 : Time and footer  --> 
  <jsp:include page="part/mainObjectiveCard-8.jsp" />
</table>
