<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<body>

	<c:url var="formUrl" value="/mainObjective/save.do"/>
	<form:form action="${formUrl}" method="post" modelAttribute="mainObjective">
		<form:label path="name">Name</form:label>
		<form:input path="name" value="${mainObjective.name}" />
		<br />
		
		<input type="submit" value="Save" />
	</form:form>

</body>