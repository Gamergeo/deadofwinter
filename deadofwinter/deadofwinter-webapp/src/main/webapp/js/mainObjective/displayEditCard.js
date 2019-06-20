/**
 * On update : we check if the string contains any special numbers to be replaced.
 * An ajax request is processed for that.
 */
function updateReplacingNumberBlock(text, type, difficulty) {
	url = "/deadofwinter/mainObjective/ajaxNumberToReplace.do";
	
	var elementToReplace = getBlockElement(type);
	
	params = {'text':text, 'type': type, 'difficulty': difficulty}
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
function getInputElement(type, difficulty) {
	return $('#replacingNumbers-' + difficulty + '-' + type);
}

/**
 * Actualise the replacing numbers
 */
function actualiseReplacingNumbers(type, difficulty) {
	var index = 1;
	var replacingNumbers ='';
	
	while(true) {
		 
		 var replacingNumberElement = $("#replacingNumber-" + difficulty + "-" + type + "-" + index);
		 
		 // If element is not found, it doesnt exist. We set up the hidden field and stop the function
		 if (!elementExist(replacingNumberElement)) {
			 getInputElement(type, difficulty).val(replacingNumbers);
			 return;
		 }
		 
		 // We dont change the field if value is not set yet
		 if (index == 1) {
			 replacingNumbers += replacingNumberElement.val();
			 
		 } else {
			 replacingNumbers += REPLACING_NUMBERS_SEPARATION + replacingNumberElement.val();
		 }
		 
		 index++;
	}
}

/**
 * @returns the actual replacing number for type, difficulty and index
 */
function getReplacingNumber(type, difficulty, index) {
	var replacingNumbers = getInputElement(type, difficulty).val().split(REPLACING_NUMBERS_SEPARATION);
	
	return replacingNumbers[index - 1];
}