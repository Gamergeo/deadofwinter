<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h1>Dead of Winter</h1>

	<h2>Voici l'histoire de votre mort...</h2>

	<c:url var="formUrl" value="/anewdawn"/>
	<form:form action="${formUrl}" method="post" modelAttribute="search">
		<form:label path="hard">Difficile ?</form:label>
		<form:checkbox path="hard" />
		<br />

		<form:label path="extension">Extension ?</form:label>
		<form:checkbox path="extension" />
		<br />

		<form:label path="original">Original ?</form:label>
		<form:checkbox path="original" />
		<br />

		<form:label path="custom">Custom ?</form:label>
		<form:checkbox path="custom" />
		<br />
		<br />
		
		<input type="submit" value="Allons-y..." />
	</form:form>

	<h2>${message}</h2>
</body>
</html>