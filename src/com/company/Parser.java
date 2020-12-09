package com.company;

public final class Parser {

    public final Line parse(String line) {

        String left = "", right = "";
        char sim;

        int i = 0;
        for (; i <= line.length(); i++) {

            if (line.charAt(i) != ' ') {
                left += line.charAt(i);
            }
            else {
                i++;
                break;
            }
        }
        sim = line.charAt(i);
        i = i + 2;
        for (; i < line.length(); i++) {
            right = right + line.charAt(i);
        }

        Line line1 = new Line(Integer.valueOf(left), sim, Integer.valueOf(right));

        return line1;

    }

}
