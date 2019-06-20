<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<%@include file="/pages/header.jsp" %>
    
    <link href="<c:url value='/css/mainObjective/displayMainObjectiveEdit.css' />" rel="stylesheet" media="all" type="text/css">
        
    <!-- JS Import -->
    <script src='<c:url value="/js/mainObjective/displayEdit.js" />'></script>
    
    
    <script type="text/javascript">
      $(document).ready(function() {
        
        $("#buttonToHard").click(function() {
          changeDifficulty(DIFFICULTY_LEVEL['HARD']);
        });
        
        $("#buttonToNormal").click(function() {
          changeDifficulty(DIFFICULTY_LEVEL['NORMAL']);
        });
        
        $("#Save").click(function() {
        	$('form#mainObjective').submit();
        });
      });
    </script>
    
		
		<style type="text/css" media="screen">
			body {
				background-color: blue;
			}
		</style>
	</head>

	<body>
  
    <table style="width:100%">
      <tr>
        <td id="card" style="width:85%">
          <jsp:include page="../../card/edit/editMainObjectiveCard.jsp"/>
        </td>
        <td id="otherInformations" style="width:15%;">
          Difficulté : 
          <br />
          <div id="difficultyLabel">Normal</div>
          <br />
          <button class="buttonTo" id="buttonToHard">Editer mode difficile</button>
          <button class="buttonTo" id="buttonToNormal" style="display:none;">Editer mode normal</button>
          <br />
          <br />
          <button class="buttonTo" id="Save">Sauvegarder la carte</button>
        </td>
      </tr>
    </table>
	</body>
</html>