package com.company;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Parser parser = new Parser();
    static Math math = new Math();

    public static void main(String[] args) {
        // Принимаем строку
        String textIn = in.nextLine();

        // Парсим строку
        Line result = parser.parseString(textIn);

        // Считаем и выводим резльтат
        if (result.isArabic())
            System.out.println(math.calc(result.getFirst(), result.getZnak(), result.getSecond()));
        else
            System.out.println(parser.arabicToRoman(math.calc(result.getFirst(), result.getZnak(), result.getSecond())));
    }

}
