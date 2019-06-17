$(document).ready(function() {

	// On ajoute les evenements de change sur les textarea pour determiner le nombre de chiffre à remplacer
	$("#victoryTextArea").change(function() {
		updateReplacingNumberBlock($('#victoryTextArea').val(), $('#replacingNumbersBlock-victory'));
	});
});

$(document).ready(function() {

	// On ajoute les evenements de change sur les textarea pour determiner le nombre de chiffre à remplacer
	$("#addRuleTextArea").change(function() {
		updateReplacingNumberBlock($('#addRuleTextArea').val(), $('#replacingNumbersBlock-addRule'));
	});
});

/**
 * On update : we check if the string contains any special numbers to be replaced.
 * An ajax request is processed for that.
 */
function updateReplacingNumberBlock(text, elementToReplace) {
	url = "/deadofwinter/mainObjective/ajaxNumberToReplace.do";
	params = {'text':text}
	ajaxUpdateElement(elementToReplace, url, params, onSuccess);
}

/**
 * Callback function for updateReplacingNumbersBlock. Show hide element.
 */
function onSuccess(data, elementToUpdate) {
	if ($.trim(data) == '') {
		elementToUpdate.hide();
	} else {
		elementToUpdate.show();
	}
}

/**
 * @returns the block element for a given type
 */
function getBlockElement(type) {
	return $('#replacingNumbersBlock-' + type);
}

/**
 * @returns the hidden input element for a given type
 */
function getInputElement(type) {
	return $('#replacingNumbers-' + type);
}