package org.tdd.kata.stringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App
{
	private static int THRESHOLD = 1000;
	private static String REGEX = ",|\n";

    public static int add(String text) {
		List<Integer> numbers = getValidNumbers(text);
		ensureAllPositives(numbers);
		return getSum(numbers);
    }
    
    private static int getSum(List<Integer> numbers) {
    	int sum = 0;
    
    	for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
		}
		
		return sum; 
		
	}

	private static void ensureAllPositives(List<Integer> numbers) {
    	List<Integer> negatives = getNegativeNumbers(numbers);
		
		if (negatives.size() > 0) {
			throw new RuntimeException("Negatives not allowed : " + 
					negatives.stream()
				    .map(String::valueOf).collect(Collectors.joining(",")));
		}
		
	}

	private static String[] tokenize(String text) {
		if (text == null || text.isEmpty()) {
			return new String[0];
		} else if (useCustomDelimeterPattern(text)) {
			return splitCustomDelimeter(text);
		} else {
			return splitUsingDelimeter(text, null);
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

	private static List<Integer> getValidNumbers(String text) {
		String[] numbersString = tokenize(text);

    	List<Integer> numbers = new ArrayList<Integer>();
    	
    	for (int i = 0; i < numbersString.length; i++) {
    		if (numbersString[i].isEmpty()) {
    			continue;
    		}
  
    		int number = Integer.parseInt(numbersString[i]);
    		
    		if (number > THRESHOLD) {
    			continue;
    		}
    		
    		numbers.add(number);
    	}
    	
		return numbers;
	}

	private static boolean useCustomDelimeterPattern(String text) {
    	return text.startsWith("//");
    }
    
    private static String[] splitCustomDelimeter(String text) {
    	Matcher matcher = Pattern.compile("//(.*)\n(.*)", Pattern.MULTILINE).matcher(text);
		matcher.matches();
		String delimeter = matcher.group(1); 
		String numbers = matcher.group(2);
		return splitUsingDelimeter(numbers, delimeter);
    }
    
    private static String[] splitUsingDelimeter(String text, String delimeter) {
    	if (delimeter == null || delimeter.isEmpty()) {
    		delimeter = REGEX;
    	}
    	
    	return text.split("[" + delimeter + "]");
    }
}
