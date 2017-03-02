package com.mysuperscore.utils;

public class PasswordChecker {
    private static final int WEAK_STRENGTH = 5;
    private static final int MEDIUM_STRENGTH = 9;

    public String getStrength(String password) {
        if (password.length() <= WEAK_STRENGTH) {
            return "WEAK";
        } else if (password.length() <= MEDIUM_STRENGTH) {
            return "MEDIUM";
        } else {
            return "STRONG";
        }
    }
}
