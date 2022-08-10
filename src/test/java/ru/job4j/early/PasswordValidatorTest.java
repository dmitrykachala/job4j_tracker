package ru.job4j.early;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordValidatorTest {

    @Test
    public void whenPassEmptyEx() throws IllegalArgumentException {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate("");
        });
        Assertions.assertEquals("Password can't be blank.", thrown.getMessage());
    }

    @Test
    public void whenPassLessNeed() throws IllegalArgumentException {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate("111");
        });
        Assertions.assertEquals("Password length must have more "
                        + "than 7 and less than 33 symbols", thrown.getMessage());
    }

    @Test
    public void whenPassMoreThanNeed() throws IllegalArgumentException {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate("11111111111111111111111111111111135");
        });
        Assertions.assertEquals("Password length must have more "
                + "than 7 and less than 33 symbols", thrown.getMessage());
    }

    @Test
    public void whenPassNotComplicated() throws IllegalArgumentException {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate("Admin1#dd");
        });
        Assertions.assertEquals("Password must be more complicated.", thrown.getMessage());
    }

    @Test
    public void whenPassHasNotSpecial() throws IllegalArgumentException {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate("jd1hgjgD");
        });
        Assertions.assertEquals("Password must have at least one special symbol,"
                + " one uppercase letter, one lowercase letter and one digit.",
                thrown.getMessage());
    }

    @Test
    public void whenPassIsValid() {
        assertEquals(PasswordValidator.validate("j#d1hgjgD"), "Password is acceptable.");
    }
}