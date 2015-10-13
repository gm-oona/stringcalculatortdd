package org.workleanmobile;

public class StringParserWithComma implements StringParser {

    public String[] parse(String source) {
        return source.split(":");
    }

}
