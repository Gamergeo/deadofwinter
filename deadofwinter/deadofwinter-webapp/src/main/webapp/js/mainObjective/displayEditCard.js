$(document).ready(function() {
  
  	// On ajoute les evenements de change sur les textarea pour determiner le nombre de chiffre à remplacer
  	$("#victoryTextArea").change(function() {
  		updateReplacingNumberBlock($('#victoryTextArea').val(), DESCRIPTION_TYPE["VICTORY"]);
  	});
  
  	// On ajoute les evenements de change sur les textarea pour determiner le nombre de chiffre à remplacer
  	$("#addRuleTextArea").change(function() {
  		updateReplacingNumberBlock($('#addRuleTextArea').val(), DESCRIPTION_TYPE["ADDITIONAL_RULE"]);
  	});
});


/**
 * On update : we check if the string contains any special numbers to be replaced.
 * An ajax request is processed for that.
 */
function updateReplacingNumberBlock(text, type) {
	url = "/deadofwinter/mainObjective/ajaxNumberToReplace.do";
	
	var elementToReplace = getBlockElement(type);
	
	params = {'text':text, 'type': type}
	getAjaxUpdateElement(elementToReplace, url, params, onSuccess);
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

function actualiseReplacingNumbers(type) {
	var index = 1;
	var replacingNumbers ='';
	
	while(true) {
		 
		 var replacingNumberElement = $("#replacingNumber-" + type + "-" + index);
		 
		 // If element is not found, it doesnt exist. We set up the hidden field and stop the function
		 if (!elementExist(replacingNumberElement)) {
			 getInputElement(type).val(replacingNumbers);
			 return;
		 }
		 
		 // We dont change the field if value is not set yet
		 if (replacingNumberElement.val()) {
			 
			 if (index == 1) {
				 replacingNumbers += replacingNumberElement.val();
				 
			 } else {
				 replacingNumbers += REPLACING_NUMBERS_SEPARATION + replacingNumberElement.val();
			 }
		 }
		 index++;
	}
}