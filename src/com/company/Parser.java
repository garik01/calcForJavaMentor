package com.company;

import java.util.List;

public final class Parser {

    public final Line parseString(String str) {

        String left = "", right = "";
        char sim;

        int i = 0;
        for (; i <= str.length(); i++) {

            if (str.charAt(i) != ' ') {
                left += str.charAt(i);
            }
            else {
                i++;
                break;
            }
        }
        sim = str.charAt(i);
        i = i + 2;
        for (; i < str.length(); i++) {
            right = right + str.charAt(i);
        }

        Line line;
        if (isNum(left) && isNum(right)) {
            line = new Line(Integer.valueOf(left), sim, Integer.valueOf(right));
        } else {
            line = new Line(romanToArabic(left), sim, romanToArabic(right));
        }
        return line;

    }

    private boolean isNum(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    public int romanToArabic(String str) {
        String romanNumeral = str.toUpperCase();
        int result = 0;

        List<RomanNum> romanNum = RomanNum.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNum.size())) {
            RomanNum symbol = romanNum.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(str + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

    public String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNum> romanNumerals = RomanNum.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNum currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

}
