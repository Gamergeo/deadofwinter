<%@include file="/pages/headerOnlyMeta.jsp" %>

<c:forEach var="replacedNumberIndex" begin="1" end="${replacedNumberNumber}">
  {<c:out value="${replacedNumberIndex}" />}:  
  <input type="text" class="replacingNumbersInput" size="2" id="replacingNumber-${difficulty}-${type}-${replacedNumberIndex}" />
  <br />
  
  <script>
    $(document).ready(function() {
  
  		$("#replacingNumber-${difficulty}-${type}-${replacedNumberIndex}").val(getReplacingNumber('${type}', '${difficulty}', '${replacedNumberIndex}'));
    	
    	$("#replacingNumber-${difficulty}-${type}-${replacedNumberIndex}").change(function() {
  			actualiseReplacingNumbers("${type}", "${difficulty}");
  	  });
    });
	</script>
</c:forEach>