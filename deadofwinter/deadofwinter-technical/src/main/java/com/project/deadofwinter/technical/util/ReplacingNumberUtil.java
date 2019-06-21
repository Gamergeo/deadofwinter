package com.project.deadofwinter.technical.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.StringUtils;

import com.project.deadofwinter.technical.constant.DeadOfWinterConstants;
import com.project.deadofwinter.technical.exception.ProjectException;

public abstract class ReplacingNumberUtil {
	
	/**
	 * @return a String in the format of a replaced number
	 * Deafault is {number}
	 */
	public static String transformIntoReplacedNumbers(int number) {
		return DeadOfWinterConstants.REPLACED_NUMBER_LEFT_MARK + number + DeadOfWinterConstants.REPLACED_NUMBER_RIGHT_MARK;
	}
	
	/**
	 * @return a list composed by replacing Numbers
	 */
	public static List<String> transformReplacingNumbersIntoList(String replacingNumbers) {
		return Arrays.asList(StringUtils.delimitedListToStringArray(replacingNumbers, DeadOfWinterConstants.REPLACING_NUMBERS_SEPARATION));
	}
	
	/**
	 * @see com.project.deadofwinter.technical.util.ReplacingNumberUtil#replaceTextWithDifficultyNumbers(String , List)
	 */
	public static String replaceTextWithDifficultyNumbers(String text, String replacingNumbers) throws ProjectException {
		return replaceTextWithDifficultyNumbers(text, transformReplacingNumbersIntoList(replacingNumbers));
	}
	
	/**
	 * @return text, replaced with replacing numbers
	 */
	public static String replaceTextWithDifficultyNumbers(String text, List<String> replacingNumbers) throws ProjectException {
		String toReplace;
		int replacedIndex = 0;
		
		for (String replacingNumber : replacingNumbers) {
			replacedIndex++;
			toReplace = transformIntoReplacedNumbers(replacedIndex);
			
			// Text doesnt contain toReplace string : exception
			if (!text.contains(toReplace)) {
				throw new ProjectException("The text doesn't contain the {" + replacedIndex + "} string");
			}
			
			text = text.replace(toReplace, replacingNumber);
		}
		
		return text;
	}
	
	
	/**
	 * @return number of replaced number in a text 
	 */
	public static int getReplacedNumberNumber(String text) {
		int number = 1;
		
		while(true) {

			if (!text.contains(transformIntoReplacedNumbers(number))) {
				return number - 1;
			}
			
			number++;
		}
	}

	/**
	 * @return number of replacing number in a string 
	 */
	public static int getReplcingdNumberNumber(String replacingNumbersString) {
		int size = getReplacingNumberAsList(replacingNumbersString).size();
		
		// Warning : there is no separator but still one item
		if (size == 0 && !StringUtils.isEmpty(replacingNumbersString)) {
			return 1;
		}
		
		return getReplacingNumberAsList(replacingNumbersString).size();
	}
	
	/**
	 * Return a string of replacing number to a list
	 */
	public static List<String> getReplacingNumberAsList(String replacingNumbersString) {
		String[] array = StringUtils.split(replacingNumbersString, DeadOfWinterConstants.REPLACING_NUMBERS_SEPARATION);
		
		if (array == null) {
			return new ArrayList<String>();
		}
		
		return Arrays.asList(array);
	}
}
