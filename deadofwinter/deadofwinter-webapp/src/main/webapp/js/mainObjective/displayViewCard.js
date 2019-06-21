/**
 * replace the given text with images for all special words (see constant.js) 
 */
function replaceTextWithImages(text) {
	
	$.each(IMAGES_REPLACE, function(index, IMAGE_REPLACE) {
		var image = '<img src="' + IMAGE_REPLACE['url'] + '"/>';
		
		regExp = new RegExp(IMAGE_REPLACE['text'], 'g');
		
		text = text.replace(regExp, image);
	});
	
	return text;
}