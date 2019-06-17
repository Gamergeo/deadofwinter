/**
 * @returns true if the string is empty or blank
 */
function isEmptyOrBlank(string) {
	if (string == '') {
		
	}
	return string && (string = $.trim(string));
}

/**
 * Process an ajax request
 * @param url url of ajax request
 * @param params
 * @param onSuccess function callback. Type onSucess(data)
 * @param onError function callback. Default error if not provided
 */
function ajaxRequest(url, onSuccess, params, onError) {
	if (isUndefined(onError)) {
		onError = defaultOnError;
	}
	
	$.ajax({
		url: url,
		data: params,
		type: "GET",
		dataType : "html",
		success: onSuccess,
	    error: onError,
	});
}

/**
 * Update elementToUpdate with the content of the ajax request
 * @param elementToUpdate
 * @param url url of ajax request
 * @param params
 * @param onSuccess function callback. Type onSucess(data, elementToUpdate)
 * @param onError function callback. Default error if not provided
 */
function ajaxUpdateElement(elementToUpdate, url, params, onSuccess, onError) {
	if (isUndefined(onError)) {
		onError = defaultOnError;
	}
	
	if (isUndefined(onSuccess)) {
		defaultSuccess = defaultSuccess;
	}
	
	ajaxRequest(url, function(data) {elementToUpdate.html(data);onSuccess(data, elementToUpdate)}, params, onError);
}

/**
 * Default error ajax callback function
 */
function defaultOnError() {
	alert( "Sorry, there was a problem!" );
}

/**
 * Default success ajax callback function
 */
function defaultSuccess(data) {
	
}

/**
 * @returns true if the variable is undefined
 */
function isUndefined(variable) {
	return typeof variable === 'undefined';
}