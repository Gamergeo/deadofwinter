<%@include file="/pages/headerOnlyMeta.jsp" %>

<c:forEach var="replacedNumberIndex" begin="1" end="${replacedNumberNumber}">
  <div>
    {<c:out value="${replacedNumberIndex}" />} = 
    <input type="text" size="1" id="replacingNumber-${replacedNumberIndex}" />
  </div>
 
  <script>
  	$("#replacingNumber-${replacedNumberIndex}").change(function() {
			
	  });
	</script>
</c:forEach>
