package org.workleanmobile;

public class StringCalculator {

    public int add(String string) {

        int totalResult = 0;
        String[] numberStrings = string.split(",");
        for (String numberString : numberStrings) {
            if (!numberString.isEmpty()) {
                Integer result = Integer.valueOf(numberString.trim());
                totalResult += result.intValue();
            }
        }
        return totalResult;
    }

}
