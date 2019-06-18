/**
 * @returns true if the string is empty or blank
 */
function isEmptyOrBlank(string) {
	if (string == '') {
		
	}
	return string && (string = $.trim(string));
}

/**
 * Process a get ajax request
 */
function getAjaxRequest(url, onSuccess, params, onError) {
	ajaxRequest(url, onSuccess, params, onError, "GET");
}

/**
 * Process a post ajax request
 */
function getAjaxRequest(url, onSuccess, params, onError) {
	ajaxRequest(url, onSuccess, params, onError, "POST");
}

/**
 * Process an ajax request
 * @param url url of ajax request
 * @param params
 * @param onSuccess function callback. Type onSucess(data)
 * @param onError function callback. Default error if not provided
 */
function ajaxRequest(url, onSuccess, params, onError, type) {
	if (isUndefined(onError)) {
		onError = defaultOnError;
	}
	
	if (isUndefined(type)) {
		type = "GET";
	}
	
	$.ajax({
		url: url,
		data: params,
		type: type,
		dataType : "html",
		success: onSuccess,
	    error: onError,
	});
}

function getAjaxUpdateElement(elementToUpdate, url, params, onSuccess, onError) {
	ajaxUpdateElement(elementToUpdate, url, params, onSuccess, onError, "GET");
}
	
function postAjaxUpdateElement(elementToUpdate, url, params, onSuccess, onError) {
	ajaxUpdateElement(elementToUpdate, url, params, onSuccess, onError, "POST");
}

/**
 * Update elementToUpdate with the content of the ajax request
 * @param elementToUpdate
 * @param url url of ajax request
 * @param params
 * @param onSuccess function callback. Type onSucess(data, elementToUpdate)
 * @param onError function callback. Default error if not provided
 */
function ajaxUpdateElement(elementToUpdate, url, params, onSuccess, onError, type) {
	if (isUndefined(onError)) {
		onError = defaultOnError;
	}
	
	if (isUndefined(onSuccess)) {
		onSuccess = defaultSuccess;
	}
	
	ajaxRequest(
			url, 
			function(data) {
				elementToUpdate.html(data);
				onSuccess(data, elementToUpdate)}, 
			params, 
			onError,
			type);
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
function defaultSuccess(data, element) {
	
}

/**
 * @returns true if the variable is undefined
 */
function isUndefined(variable) {
	return typeof variable === 'undefined';
}

/**
 * @returns true if the element exist in DOM
 */
function elementExist(element) {
	 return element.length != 0;
}