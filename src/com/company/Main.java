package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Parser parser = new Parser();
        Math math = new Math();

        String line = in.nextLine();

        Line line1 = parser.parse(line);
        int result;
        switch (line1.getZnak()) {
            case ('+'):
                result = math.plus(line1.getFirst(), line1.getSecond());
                break;
            case ('-'):
                result = math.minus(line1.getFirst(), line1.getSecond());
                break;
            case ('*'):
                result = math.mult(line1.getFirst(), line1.getSecond());
                break;
            case ('/'):
                result = math.div(line1.getFirst(), line1.getSecond());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + line1.getZnak());
        }

        System.out.println(result);

    }
}
