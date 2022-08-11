package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password can't be blank.");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password length must have more "
                    + "than 7 and less than 33 symbols");
        }
        if (password.toLowerCase().contains("qwerty") || password.toLowerCase().contains("admin")
                || password.toLowerCase().contains("user")
                || password.toLowerCase().contains("password")
                || password.toLowerCase().contains("12345")) {
            throw new IllegalArgumentException("Password must be more complicated.");
        }
        char[] passArray = password.toCharArray();
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (char c : passArray) {
            if (isDigit(c)) {
                hasDigit = true;
            }
            if (isUpperCase(c)) {
                hasUpper = true;
            }
            if (isLowerCase(c)) {
                hasLower = true;
            }
            if (!isLetterOrDigit(c)) {
                hasSpecial = true;
            }
            if (hasUpper && hasLower && hasDigit && hasSpecial) {
                break;
            }
        }
        if (!hasUpper || !hasLower || !hasDigit || !hasSpecial) {
            throw new IllegalArgumentException("Password must have at least one special symbol,"
                    + " one uppercase letter, one lowercase letter and one digit.");
        }
        return "Password is acceptable.";
    }
}
