<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<%@include file="/pages/header.jsp" %>
		
		<!-- CSS Import and Definitions -->
    <link href="<c:url value='/css/mainObjectiveCard.css' />" rel="stylesheet" media="all" type="text/css">
    <link href="<c:url value='/css/font.css' />" rel="stylesheet" media="all" type="text/css">
    <link href="<c:url value='/css/mainObjectiveEdit.css' />" rel="stylesheet" media="all" type="text/css">
		
		<style type="text/css" media="screen">
			body {
				background-color: red;
			}
		</style>
		
		<!-- JS Import -->
		<script src='<c:url value="/js/mainObjective/displayEdit.js" />'></script>
	</head>

	<body>
	
		<form:form action='<c:url value="/mainObjective/save.do" />' method="post" modelAttribute="mainObjective">
			<table id="cardTableEdit">
      
				<!-- Line 1 : Header -->
				<tr id="mainObjectiveCardLine-1">
					<td id="mainObjectiveCardCell-1"></td>
				</tr>
        
				<!-- Line 2 : Title -->
				<tr id="mainObjectiveCardLine-2">
					<td id="mainObjectiveCardCell-2">
						<div class="divBlockForInput">
							<form:input style="width:100%" class="cardTitle cardInput" path="name" value="${mainObjective.name}" />
						</div>
					</td>
				</tr>
	
				<!-- Line 3 : 1st separation -->
				<tr id="mainObjectiveCardLine-3">
					<td id="mainObjectiveCardCell-3"></td>
				</tr>
	
				<!-- Line 4 : Additional Rule -->
				<tr id="mainObjectiveCardLine-4">
					<td id="mainObjectiveCardCell-4">
	
						<div class="cardSetUpLabel">Mise en place</div>
	
						<div class="cardMoral">
							MARQUEUR DE MORAL : 
								<form:input size="1" class="cardMoral cardInput" path="difficultyNormal.moral" value="${mainObjective.difficultyNormal.moral}" />
						</div>
						
						<div class="cardTurn">
							COMPTEUR DE MANCHES :
								<form:input size="1" class="cardMoral cardInput" path="difficultyNormal.numberTurn" value="${mainObjective.difficultyNormal.numberTurn}" />
						</div> 
	
						<div class="divBlockForInput">
							<form:textarea id="addRuleTextArea" rows="9" style="width:100%" class="cardText cardInput" path="additionalRule.text"/>
						</div>
					</td>
          
          <c:set var="descriptionTypeAddRule" value="<%=DescriptionType.ADDITIONAL_RULE%>"/>
          <form:hidden id="replacingNumbers-${descriptionTypeAddRule}" path="difficultyNormal.replacingNumbersAdditionalRule"/>
          <td id="replacingNumbersBlock-${descriptionTypeAddRule}" class="replacingNumbersBlock" style="display: none;" />
				</tr>
				
				<!-- Line 5 : 2nd separation -->
				<tr id="mainObjectiveCardLine-5">
					<td id="mainObjectiveCardCell-5"></td>
				</tr>
	
				<!-- Line 6 : Victory conditions -->
				<tr id="mainObjectiveCardLine-6">
					<td id="mainObjectiveCardCell-6">
	
						<div class="cardSetUpLabel">Victoire</div>
	
						<div class="divBlockForInput">
							<form:textarea id="victoryTextArea" rows="4" style="width:100%" class="cardText cardInput" path="victory.text"/>
						</div>
					</td>
          
          <c:set var="descriptionTypeVictory" value="<%=DescriptionType.VICTORY%>"/>
          <form:hidden id='replacingNumbers-${descriptionTypeVictory}' path="difficultyNormal.replacingNumbersVictory"/>
          <td id="replacingNumbersBlock-${descriptionTypeVictory}" class="replacingNumbersBlock" style="display: none;" />
				</tr>

				<!-- Line 7 : 3rd separation -->
				<tr id="mainObjectiveCardLine-7">
					<td id="mainObjectiveCardCell-7"></td>
				</tr>
	
				<!-- Line 8 : Time and footer  -->
				<tr id="mainObjectiveCardLine-8">
					<td id="mainObjectiveCardCell-8">
	
						<div class="cardSetUpLabel">Duree</div>
	
						<div class="cardMoral">
							<form:select class="cardInput cardMoral" path="time">
								<form:option class="cardMoral" value="<%=TimeName.SHORT%>"><%=TimeName.SHORT.getText()%></form:option>
								<form:option value="<%=TimeName.MEDIUM%>"><%=TimeName.MEDIUM.getText()%></form:option>
								<form:option value="<%=TimeName.LONG%>"><%=TimeName.LONG.getText()%></form:option>
							</form:select>
						</div>
					</td>
				</tr>
			</table>
	
			<input type="submit" value="Save" />
	
		</form:form>
	</body>
</html>