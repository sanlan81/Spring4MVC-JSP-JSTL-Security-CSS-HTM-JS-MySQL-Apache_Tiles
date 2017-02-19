package com.mysuperscore.RandString;

import java.util.Random;

public class RandomString {
    public static void main(String[] args) {
    }

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
