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
            try {
                int leftInt = Integer.valueOf(left);
                int rightInt = Integer.valueOf(right);
                if (leftInt >= 0 && rightInt >= 0 && leftInt <= 10 && rightInt <= 10)
                    line = new Line(leftInt, sim, rightInt);
                else
                    throw new IllegalStateException("Number is not included in the range: " + leftInt + " " + rightInt);
            }
            catch (Exception ex) {
                throw new IllegalStateException(ex.getMessage());
            }
        }
        else {
            try {
                int leftInt = romanToArabic(left);
                int rightInt = romanToArabic(right);
                if (leftInt >= 0 && rightInt >= 0 && leftInt <= 10 && rightInt <= 10)
                    line = new Line(leftInt, sim, rightInt, false);
                else
                    throw new IllegalStateException("Number is not included in the range: " + left + " " + right);
            } catch (Exception ex) {
                throw new IllegalStateException(ex.getMessage());
            }
        }
        return line;
    }

    public boolean isNum(String str) {
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

        List<RomanNum> romanNum = RomanNum.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNum.size())) {
            RomanNum currentSymbol = romanNum.get(i);
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
