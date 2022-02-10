package ca.bcit.comp2522.finalexam.q1;

import org.junit.Test;
//import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for PasswordValidator
 *
 */
public class PasswordValidatorTest {

    private static final String TEST_VERSION = "V1.1";

    private final ArrayList<String> EMPTY_LIST = new ArrayList<>();
    private final ArrayList<String> ERROR_LIST = new ArrayList<>();

    @Test
    public void testForLowerCase() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("a");

        assertEquals(ERROR_LIST.contains("Password is missing a lowercase letter."),
                passwordErrors.contains("Password is missing a lowercase letter."));
    }
    @Test
    public void testForUpperCase() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("A");

        assertEquals(ERROR_LIST.contains("Password is missing an uppercase letter."),
                passwordErrors.contains("Password is missing an uppercase letter."));
    }
    @Test
    public void testForNumbersOrSymbols() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("$");

        assertEquals(ERROR_LIST.contains("Password must have a number OR a symbol."),
                passwordErrors.contains("Password must have a number OR a symbol."));

        passwordErrors = PasswordValidator.validatePassword("9");

        assertEquals(ERROR_LIST.contains("Password must have a number OR a symbol."),
                passwordErrors.contains("Password must have a number OR a symbol."));
    }
    @Test
    public void testForDoesStartsWithLetter() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("A");

        assertEquals(ERROR_LIST.contains("Password must start with a letter."),
                passwordErrors.contains("Password must start with a letter."));
    }
    @Test
    public void testForGreaterThanOrEqualTo8Characters() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("---------");

        assertEquals(ERROR_LIST.contains("Password is too short, must be at least 8 characters."),
                passwordErrors.contains("Password is too short, must be at least 8 characters."));
    }
    @Test
    public void testForLessThanOrEqualTo25Characters() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("-------------");

        assertEquals(ERROR_LIST.contains("Password is too long, cannot be more than 25 characters."),
                passwordErrors.contains("Password is too long, cannot be more than 25 characters."));
    }
    @Test
    public void testForNoLowerCase() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("A12$9899");
        ERROR_LIST.add("Password is missing a lowercase letter.");

        assertEquals(ERROR_LIST.contains("Password is missing a lowercase letter."),
                passwordErrors.contains("Password is missing a lowercase letter."));
    }
    @Test
    public void testForNoUpperCase() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("a12$9899");
        ERROR_LIST.add("Password is missing an uppercase letter.");

        assertEquals(ERROR_LIST.contains("Password is missing an uppercase letter."),
                passwordErrors.contains("Password is missing an uppercase letter."));
    }
    @Test
    public void testForNoNumbersOrSymbols() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("Aaaaaaaa");
        ERROR_LIST.add("Password must have a number OR a symbol.");

        assertEquals(ERROR_LIST.contains("Password must have a number OR a symbol."),
                passwordErrors.contains("Password must have a number OR a symbol."));
    }
    @Test
    public void testForDoesNotStartWithLetter() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("112$9989");
        ERROR_LIST.add("Password must start with a letter.");

        assertEquals(ERROR_LIST.contains("Password must start with a letter."),
                passwordErrors.contains("Password must start with a letter."));
    }
    @Test
    public void testForLessThan8Characters() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("Aa!1");
        ERROR_LIST.add("Password is too short, must be at least 8 characters.");

        assertEquals(ERROR_LIST.contains("Password is too short, must be at least 8 characters."),
                passwordErrors.contains("Password is too short, must be at least 8 characters."));
    }
    @Test
    public void testForDMoreThan25Characters() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("A12$9899A12$9989A12$9989" +
                "A12$99989A12$9999A12$99899");

        ERROR_LIST.add("Password is too long, cannot be more than 25 characters.");

        assertEquals(ERROR_LIST.contains("Password is too long, cannot be more than 25 characters."),
                passwordErrors.contains("Password is too long, cannot be more than 25 characters."));
    }
    @Test
    public void testForWordInDictionary() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("password");

        ERROR_LIST.add("Password contains a dictionary word.");

        assertEquals(ERROR_LIST.contains("Password contains a dictionary word."),
                passwordErrors.contains("Password contains a dictionary word."));
    }
    @Test
    public void testForReverseWordInDictionary() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("ajnin");

        ERROR_LIST.add("Password contains a reversed dictionary word.");

        assertEquals(ERROR_LIST.contains("Password contains a reversed dictionary word."),
                passwordErrors.contains("Password contains a reversed dictionary word."));
    }
    @Test
    public void testGoodPassword() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("Aa12$9899");
        assertEquals(EMPTY_LIST, passwordErrors);
    }
    @Test
    public void testBadPassword() {
        ArrayList<String> passwordErrors = PasswordValidator.validatePassword("-");
        ERROR_LIST.add("Password is too short, must be at least 8 characters.");
        ERROR_LIST.add("Password is missing a lowercase letter.");
        ERROR_LIST.add("Password is missing an uppercase letter.");
        ERROR_LIST.add("Password must have a number OR a symbol.");
        ERROR_LIST.add("Password must start with a letter");
        ERROR_LIST.add("Password is too long, cannot be more than 25 characters.");

        assertEquals(ERROR_LIST, passwordErrors);
    }
}