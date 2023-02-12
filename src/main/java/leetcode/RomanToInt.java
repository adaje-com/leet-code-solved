package leetcode;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanToInt {

    private static final Map<Character, Integer> romanToInt = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    public static int solve(String s) {
        return new RomanToInt().solveBackToFrontUsingMap(s);
    }

    public int solveBackToFrontUsingMap(String s) {
        int index = s.length() - 1;
        int answer;
        int current, prior;
        answer = romanToInt.get(s.charAt(index));
        index--;
        while (index >= 0) {
            current = romanToInt.get(s.charAt(index));
            prior = romanToInt.get(s.charAt(index + 1));
            if (current < prior) {
                answer -= current;
            } else {
                answer += current;
            }
            index--;
        }
        return answer;
    }

    private int solveUsingRegex(String s) {
        String romanNumeralsPattern = "(M{0,4})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})";
        Matcher matcher = Pattern.compile(romanNumeralsPattern)
                .matcher(s);
        if (!matcher.find()) {
            return -1; //or throw exception?
        }
        return thousands(matcher.group(1)) + hundreds(matcher.group(2)) + tens(matcher.group(3)) + ones(matcher.group(4));
    }

    private int thousands(String roman) {
        return roman.length() * 1000;
    }

    private int hundreds(String roman) {
        if (roman.length() == 0) {
            return 0;
        }
        if (roman.equals("CM")) {
            return 900;
        }
        if (roman.equals("CD")) {
            return 400;
        }
        if (roman.startsWith("D")) {
            return 500 + (roman.length() - 1) * 100;
        }
        return roman.length() * 100;
    }

    private int tens(String roman) {
        if (roman.length() == 0) {
            return 0;
        }
        if (roman.equals("XC")) {
            return 90;
        }
        if (roman.equals("XL")) {
            return 40;
        }
        if (roman.startsWith("L")) {
            return 50 + (roman.length() - 1) * 10;
        }
        return roman.length() * 10;
    }

    private int ones(String roman) {
        if (roman.length() == 0) {
            return 0;
        }
        if (roman.equals("IX")) {
            return 9;
        }
        if (roman.equals("IV")) {
            return 4;
        }
        if (roman.startsWith("V")) {
            return 5 + (roman.length() - 1);
        }
        return roman.length();
    }
}
