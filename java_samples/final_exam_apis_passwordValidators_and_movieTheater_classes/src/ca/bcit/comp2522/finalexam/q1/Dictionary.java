package ca.bcit.comp2522.finalexam.q1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Represents a dictionary.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class Dictionary {

    private final HashSet<String> dictionary;

    private final String fileName;

    /**
     * Constructor.
     * @param fileName Name of the file to open.
     */
    public Dictionary(final String fileName) {
        this.fileName = fileName;
        this.dictionary = new HashSet<>();
    }

    /**
     * Loads the dictionary with words from the file.
     */
    public void load() {
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                dictionary.add(sc.nextLine().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        }
    }

    /**
     * Returns how many words are in the dictionary as an int.
     * @return How many words are in the dictionary.
     */
    public int wordCount() {
        return dictionary.size();
    }

    /**
     * Returns whether or not the given word is in the dictionary.
     * @param word The word to check for.
     * @return If the word is in the dictionary.
     */
    public boolean contains(final String word) {
        return dictionary.contains(word.toLowerCase());
    }
    public boolean isStringOrSubStringInDictionary(final String word) {
        for (String dictionaryWord : dictionary) {
            if (word.contains(dictionaryWord)) {
                return true;
            }
        }
        return false;
    }
}
