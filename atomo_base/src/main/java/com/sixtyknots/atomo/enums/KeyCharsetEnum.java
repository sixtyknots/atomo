package com.sixtyknots.atomo.enums;

public enum KeyCharsetEnum {
    LOWER_CASE_LETTERS("abcdefghijklmnopqrstuvwxyz"),
    UPPER_CASE_LETTERS("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    NUMBERS("0123456789"),
    PUNCTUATION("!@#$%^&*.");

    private String validChars;

    private KeyCharsetEnum(String validChars) {
       this.validChars = validChars;
    }

    public String getValidChars() {
       return validChars;
    }

    public static String getValidCharStrings(KeyCharsetEnum... pwChars) {
       StringBuilder validCharsSB = new StringBuilder();

       for (KeyCharsetEnum passwordChar : pwChars) {
          validCharsSB.append(passwordChar.getValidChars());
       }

       return validCharsSB.toString();
    }
}
