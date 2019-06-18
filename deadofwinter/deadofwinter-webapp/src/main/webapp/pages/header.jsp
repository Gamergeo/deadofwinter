<%@include file="/pages/headerOnlyMeta.jsp" %>

<link href="<c:url value='/css/general/reset.css' />" rel="stylesheet" media="all" type="text/css">
<link href="<c:url value='/css/general/font.css' />" rel="stylesheet" media="all" type="text/css">

<script src="<c:url value='/webjars/jquery/3.4.1/jquery.min.js' />"></script>
<script src="<c:url value='/js/util.js'/>"></script>

<!-- Definition of some constants for javascript -->
<script type="text/javascript">
	const DESCRIPTION_TYPE = {
		VICTORY: "<%=DescriptionType.VICTORY%>",
		ADDITIONAL_RULE: "<%=DescriptionType.ADDITIONAL_RULE%>",
		DIFFICULTY_RULE: "<%=DescriptionType.DIFFICULTY_RULE%>"
	}
	
	const DIFFICULTY_LEVEL = {
			NORMAL:  "<%=DifficultyLevel.NORMAL.toString()%>",
			HARD:    "<%=DifficultyLevel.HARD.toString()%>",
			EXTREME: "<%=DifficultyLevel.EXTREME.toString()%>"
		}
	
	const REPLACING_NUMBERS_SEPARATION = ",";
</script>