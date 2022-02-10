package ca.bcit.comp2522.finalexam.q1;

import java.util.ArrayList;

/**
 *   Class Password Validator
 *   Use the validatePassword method to validate Passwords
 */
public class PasswordValidator {

    private static final Dictionary dictionary = new Dictionary("res/password_dictionary.txt");

    private static boolean containsLower(String string) {
        return string.matches("^(?=.*[a-z]).+$");
    }

    private static boolean containsUpper(String string) {
        return string.matches("^(?=.*[A-Z]).+$");
    }

    private static boolean containsNumberOrSymbol(String string) {
        return string.matches("^(?=.*\\d).+$") || string.matches("^(?=.*[!@#$%^&*()\\[\\]{},.<>?]).+$");
    }

    private static boolean startsWithLetter(String string) {
        return string.matches("^[a-z].*$") || string.matches("^[A-Z].*$");
    }

    private static String reverseString(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    private static boolean isWordInDictionary(String string) {
        return dictionary.isStringOrSubStringInDictionary(string.toLowerCase());
    }

    private static boolean isReverseWordInDictionary(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.reverse();
        String reverseString = stringBuilder.toString();
        return isWordInDictionary(reverseString);
    }

    /**
     *   validatePassword is a method that will validate
     *   the given password. It will return a list of all
     *   the problems found in the password according to
     *   this list:
     *    - must be at least 8 characters but not more than 25 characters
     *    - must start with a letter (upper or lowercase)
     *    - must contain lowercase letter
     *    - must contain uppercase letter
     *    - must contain a number OR a symbol !@#$%^&*()[]{},.<>?/\
     *    - must not contain a word from the dictionary list
     *    - must not contain a reversed word from the dictionary list
     *
     * @param aPassword This is the password as a String
     *        that will be validated
     *
     * @return An ArrayList with Strings for each problem
     *         found inside the password.
     *         Example if a password is otherwise ok, but doesn't
     *         have an uppercase and doesn't contain a number
     *         Return an empty list if completely valid
     *           NOTE: an empty list is not the same as null
     *
     */
    public static ArrayList<String> validatePassword(String aPassword) {
        ArrayList<String> problems = new ArrayList<>();

        dictionary.load();
        if (aPassword.length() < 8) {
            problems.add("Password is too short, must be at least 8 characters.");
        }
        if (aPassword.length() > 25) {
            problems.add("Password is too long, cannot be more than 25 characters.");
        }
        if (!startsWithLetter(aPassword)) {
            problems.add("Password must start with a letter.");
        }
        if (!containsLower(aPassword)) {
            problems.add("Password is missing a lowercase letter.");
        }
        if (!containsUpper(aPassword)) {
            problems.add("Password is missing an uppercase letter.");
        }
        if (!containsNumberOrSymbol(aPassword)) {
            problems.add("Password must have a number OR a symbol.");
        }
        if (isWordInDictionary(aPassword)) {
            problems.add("Password contains a dictionary word.");
        }
        if (isReverseWordInDictionary(aPassword)) {
            problems.add("Password contains a reversed dictionary word.");
        }
        return problems;
    }


    /**
     *   Override the no parameter constructor and make
     *   private to prevent instantiating an object.
     *   Use the static validatePassword method instead.
     */
    private PasswordValidator() {

    }

}