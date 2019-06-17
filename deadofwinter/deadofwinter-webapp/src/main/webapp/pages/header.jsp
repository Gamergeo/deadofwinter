<%@include file="/pages/headerOnlyMeta.jsp" %>

<link href="<c:url value='/css/reset.css' />" rel="stylesheet" media="all" type="text/css">

<script src="<c:url value='/webjars/jquery/3.4.1/jquery.min.js' />"></script>
<script src="<c:url value='/js/util.js'/>"></script>

<!-- Definition of some constants for javascript -->
<script type="text/javascript">
	const DESCRIPTION_TYPE = {
		VICTORY: "<%=DescriptionType.VICTORY%>",
		ADDITIONAL_RULE: "<%=DescriptionType.ADDITIONAL_RULE%>",
		DIFFICULTY_RULE: "<%=DescriptionType.DIFFICULTY_RULE%>",
	}
	
	const REPLACING_NUMBERS_SEPARATION = ",";
</script>