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
	 * @see com.project.deadofwinter.technical.util.ReplacingNumberUtil#replaceTextWithDifficultyNumbers(List , List)
	 */
	public static List<String> replaceTextWithDifficultyNumbers(List<String> lines, String replacingNumbers) throws ProjectException {
		return replaceTextWithDifficultyNumbers(lines, transformReplacingNumbersIntoList(replacingNumbers));
	}
	
	/**
	 * @param lines concerned description (numberToReplace)
	 * @param replacingNumbers concerned difficulty (replacingNumbers)
	 * @return an array, each element means one line with numbers replaced
	 */
	public static List<String> replaceTextWithDifficultyNumbers(List<String> lines, List<String> replacingNumbers) throws ProjectException {
		String toReplace;
		boolean replacementDone = false;
		int replacedIndex = 0;
		
		for (String replacingNumber : replacingNumbers) {
			replacedIndex++;
			replacementDone = false;
			toReplace = transformIntoReplacedNumbers(replacedIndex);
			
			// On verifie pour chaque element de la liste
			for (int lineIndex = 0; lineIndex < lines.size() && !replacementDone; lineIndex++) {
				
				// Si l'élément à remplacer est dans cette ligne, on le remplace et indique que le remplacement est fait
				if (lines.get(lineIndex).contains(toReplace)) {
					
					// On corrige l'élement avec le nombre correspondant
					String replacedLine = lines.get(lineIndex).replace(toReplace, replacingNumber); 
					
					lines.remove(lineIndex);
					lines.add(lineIndex, replacedLine);
					replacementDone = true;
				}
			}
			
			// Si le remplacement pour cet élément n'a pas été trouvé dans le tableau, alors c'est un problème
			if (!replacementDone) {
				throw new ProjectException("The text doesn't contain the {" + replacedIndex + "} string");
			}
		}
		
		return lines;
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
