<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<%@include file="/pages/header.jsp" %>
	</head>
	
	<body>
		<h1>Dead of Winter</h1>
		
		<h2>Voici l'histoire de votre mort...</h2>
		
		<c:url var="formUrl" value="/mainObjective/anewdawn.do"/>
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
		
		<div>
			<c:url var="editUrl" value="/mainObjective/displayEdit.do"/>
			<a href="${editUrl}">Add a new main objective</a> 
		
		</div>
		
		<h2>${message}</h2>
	</body>
</html>