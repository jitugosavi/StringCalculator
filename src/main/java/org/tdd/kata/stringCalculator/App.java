package org.tdd.kata.stringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App 
{
    public static int add(String text) {
    	if (text == null || text.length() <= 0) {
    		return 0;
    	} else {
    		String regex = ",|\n";
    		String[] numbersString = null;

    		if (useCustomDelimeterPattern(text)) {
    			numbersString = splitCustomDelimeter(text);
    		} else {
    			numbersString = splitUsingDelimeter(text, regex);
    		}
    		
    		int sum = 0;
    		
			List<Integer> numbers = getValidNumbers(numbersString);
			List<Integer> negatives = getNegativeNumbers(numbers);
			
			if (negatives.size() > 0) {
				throw new RuntimeException("Negatives not allowed : " + 
						negatives.stream()
					    .map(String::valueOf).collect(Collectors.joining(",")));
			}
    		
    		for (int i = 0; i < numbers.size(); i++) {
    			sum += numbers.get(i);
    		}
    		
    		return sum; 
    	}
    }
    
    private static List<Integer> getNegativeNumbers(List<Integer> numbers) {
		List<Integer> negatives = new ArrayList<>();
		
		for (Integer number : numbers) {
			if (number < 0) {
				negatives.add(number);
			}
		}
		
		return negatives;
  
	}

	private static List<Integer> getValidNumbers(String[] numbersString) {
    	
    	List<Integer> numbers = new ArrayList<Integer>();
    	
    	for (int i = 0; i < numbersString.length; i++) {
    		int number = Integer.parseInt(numbersString[i]);
    		numbers.add(number);
    	}
    	
		return numbers;
	}

	private static boolean useCustomDelimeterPattern(String text) {
    	return text.startsWith("//");
    }
    
    private static String[] splitCustomDelimeter(String text) {
    	Matcher matcher = Pattern.compile("//(.)\n(.*)", Pattern.MULTILINE).matcher(text);
		matcher.matches();
		String delimeter = matcher.group(1); 
		String numbers = matcher.group(2);
		return splitUsingDelimeter(numbers, delimeter);
    }
    
    private static String[] splitUsingDelimeter(String text, String delimeter) {
    	return text.split("[" + delimeter + "]");
    }
}
