package org.tdd.kata.stringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App 
{
    public static int add(String text) {
    	if (text == null || text.length() <= 0) {
    		return 0;
    	} else {
    		String regex = ",|\n";

    		if (useCustomDelimeterPattern(text)) {
    			List<String> customDelims = splitCustomDelimeter(text);
    			regex = customDelims.get(0);
    			text = customDelims.get(1);
    		}

    		String[] numbers = text.split(regex);
    		int sum = 0;
    		
    		for (int i = 0; i < numbers.length; i++) {
    			sum += Integer.parseInt(numbers[i]);
    		}
    		
    		return sum; 
    	}
    }
    
    private static boolean useCustomDelimeterPattern(String text) {
    	return text.startsWith("//");
    }
    
    private static List<String> splitCustomDelimeter(String text) {
    	ArrayList<String> customDelim = new ArrayList<String>();
    	Matcher matcher = Pattern.compile("//(.)\n(.*)", Pattern.MULTILINE).matcher(text);
		matcher.matches();
		customDelim.add(matcher.group(1));
		customDelim.add(matcher.group(2));
		return customDelim;
    }
}
