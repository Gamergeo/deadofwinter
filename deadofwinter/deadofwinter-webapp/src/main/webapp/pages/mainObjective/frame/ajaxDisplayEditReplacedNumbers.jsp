<%@include file="/pages/headerOnlyMeta.jsp" %>

<c:forEach var="replacedNumberIndex" begin="1" end="${replacedNumberNumber}">
  {<c:out value="${replacedNumberIndex}" />}:  
  <input type="text" class="replacingNumbersInput" size="2" id="replacingNumber-${type}-${replacedNumberIndex}" />
  <br />
  
  <script>
  	$("#replacingNumber-${type}-${replacedNumberIndex}").change(function() {
			actualiseReplacingNumbers("${type}");
	  });
	</script>
</c:forEach>