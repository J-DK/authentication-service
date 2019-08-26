package com.auth.login.util;

import java.util.stream.IntStream;

public class PasswordGeneratorUtil {

    public static String generatePassword(String firstName) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(5);


        IntStream.range(0,5).forEach(i -> {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        });

        return firstName+sb.toString();
    }
}
