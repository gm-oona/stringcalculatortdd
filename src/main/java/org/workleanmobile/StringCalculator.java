package org.workleanmobile;

public class StringCalculator {
    private StringParser parser;

    public StringCalculator(StringParser parse) {
        this.parser = parse;
    }

    public int add(String string) {

        int returnVal = 0;
        String[] splitNumbers = parser.parse(string);
        for (String numberString : splitNumbers) {
            numberString = numberString.trim();
            if (!numberString.isEmpty()) {
                returnVal += Integer.valueOf(numberString);
            }
        }
        return returnVal;

    }

    public static void methodRankPoints(double points) {
        if (points >= 202.5) {
// writer.
// Writer.("Rank:A1");
        }
        else if (points >= 122.4) {
            System.out.println("Rank:A2");
        }
        else {
            throw new RuntimeException("Too low of a point range");
// System.out.println("Rank:A3");
        }
    }

}
