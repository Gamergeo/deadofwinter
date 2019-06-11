<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body bgcolor="red">
	<h1>Dead of Winter</h1>

	<h2>Voici l'histoire de votre mort...</h2>
	
	${mainObjective.name}<br />
	${mainObjective.victory.text}<br />
	${mainObjective.additionalRule.text}<br />
	${mainObjective.difficultyNormal.moral}<br />
	${mainObjective.difficultyHard.numberTurn}<br />
	
	<img src="images/Template.png" />
	
</body>
</html>