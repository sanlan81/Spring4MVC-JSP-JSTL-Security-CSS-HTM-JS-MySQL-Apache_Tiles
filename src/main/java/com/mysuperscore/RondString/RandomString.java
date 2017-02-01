package com.mysuperscore.RondString;

import java.io.File;
import java.util.Random;

public class RandomString {
    public static void main(String[] args) {

        //string containing allowed characters, modify according to your needs
        //String strAllowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //System.out.println(generateString(new Random(),strAllowedCharacters,20));
        //System.out.println(System.getProperty("user.dir"));

    }

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    private String findDir(File root, String name) {
        if (root.getName().equals(name)) {
            return root.getAbsolutePath();
        }

        File[] files = root.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    String myResult = findDir(f, name);
                    //this just means this branch of the
                    //recursion reached the end of the
                    //directory tree without results, but
                    //we don't want to cut it short here,
                    //we still need to check the other
                    //directories, so continue the for loop
                    if (myResult == null) {
                        continue;
                    }
                    //we found a result so return!
                    else {
                        return myResult;
                    }
                }
            }
        }
        //in this directory) and didn't find the result
        return null;
    }
}
