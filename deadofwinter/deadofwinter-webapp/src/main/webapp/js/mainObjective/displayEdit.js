/**
 * Change difficulty to level
 */
function changeDifficulty(level) {
	if (level == DIFFICULTY_LEVEL['NORMAL']) {
		$('#difficultyLabel').text("Normal");
		$('#buttonToHard').show();
		$('#buttonToNormal').hide();
	} else if (level == DIFFICULTY_LEVEL['HARD']) {
		$('#difficultyLabel').text("Difficile");
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