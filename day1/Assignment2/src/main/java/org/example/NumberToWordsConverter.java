package org.example;

public class NumberToWordsConverter {

    private static final String[] units = {
            "", "thousand", "lakh", "crore"
    };

    private static final String[] oneToNineteen = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        System.out.println(inWords(12345));
        System.out.println(inWords(10203040));
        System.out.println(inWords(101));
        // Add more test cases as needed
    }

    public static String inWords(int num) {
        if (num == 0) {
            return "zero";
        }

        int index = 0;
        StringBuilder result = new StringBuilder();

        do {
            int threeDigits = num % 1000;
            if (threeDigits != 0) {
                result.insert(0, convertThreeDigitsToWords(threeDigits) + " " + units[index] + " ");
            }

            num /= 1000;
            index++;
        } while (num > 0);

        return result.toString().trim();
    }

    private static String convertThreeDigitsToWords(int num) {
        StringBuilder result = new StringBuilder();

        int hundredDigit = num / 100;
        if (hundredDigit > 0) {
            result.append(oneToNineteen[hundredDigit]).append(" hundred ");
        }

        int lastTwoDigits = num % 100;
        if (lastTwoDigits > 0) {
            if (lastTwoDigits < 20) {
                result.append(oneToNineteen[lastTwoDigits]);
            } else {
                result.append(tens[lastTwoDigits / 10]);
                if (lastTwoDigits % 10 > 0) {
                    result.append(" ").append(oneToNineteen[lastTwoDigits % 10]);
                }
            }
        }

        return result.toString();
    }
}
