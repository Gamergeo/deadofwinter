$(document).ready(function() {
  
	changeDifficulty(DIFFICULTY_LEVEL['NORMAL']);

 	$("#buttonToHard").click(function() {
 		changeDifficulty(DIFFICULTY_LEVEL['HARD']);
 	});
 	
 	$("#buttonToNormal").click(function() {
 		changeDifficulty(DIFFICULTY_LEVEL['NORMAL']);
 	});
});

/**
 * Change difficulty to level
 */
function changeDifficulty(level) {
	$('#difficultyLabel').text(level);
	
	if (level == DIFFICULTY_LEVEL['NORMAL']) {
		$('#buttonToHard').show();
		$('#buttonToNormal').hide();
	} else if (level == DIFFICULTY_LEVEL['HARD']) {
		$('#buttonToHard').hide();
		$('#buttonToNormal').show();		
	}
	
	updateCard(level);
}

function updateCard(level) {
	url = "/deadofwinter/mainObjective/ajaxCardEdit.do";
	var elementToReplace = $("#card");
	params = $("#mainObjective").serialize();
	params += "&level="+level;
	postAjaxUpdateElement(elementToReplace, url, params);
}