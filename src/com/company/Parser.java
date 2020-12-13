package com.company;

import java.util.List;
import java.util.regex.Pattern;

public final class Parser {

    public final Line parseString(String str) {
        Pattern p = Pattern.compile(" ");
        String[] equation = p.split(str);

        Line line;
        if (isNum(equation[0]) && isNum(equation[2])) {
            try {
                int leftInt = Integer.valueOf(equation[0]);
                int rightInt = Integer.valueOf(equation[2]);
                if (leftInt >= 0 && rightInt >= 0 && leftInt <= 10 && rightInt <= 10)
                    line = new Line(leftInt, equation[1].charAt(0), rightInt);
                else
                    throw new IllegalStateException("Number is not included in the range: " + leftInt + " " + rightInt);
            }
            catch (Exception ex) {
                throw new IllegalStateException(ex.getMessage());
            }
        }
        else {
            try {
                int leftInt = romanToArabic(equation[0]);
                int rightInt = romanToArabic(equation[2]);
                if (leftInt >= 0 && rightInt >= 0 && leftInt <= 10 && rightInt <= 10)
                    line = new Line(leftInt, equation[1].charAt(0), rightInt, false);
                else
                    throw new IllegalStateException("Number is not included in the range: " + equation[0] + " " + equation[2]);
            } catch (Exception ex) {
                throw new IllegalStateException(ex.getMessage());
            }
        }
        return line;
    }

    public final boolean isNum(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    public final int romanToArabic(String str) {
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

    public final String arabicToRoman(int number) {
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
