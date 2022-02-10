package ca.bcit.comp2522.assignments.a5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Processes a file, and provides utility functions for the file.
 *
 * @author Eric Dong
 * @version 1.0
 */
public class FileProcessor {
    private static final int INCREMENT_AMOUNT_PER_WORD = 1;
    private final String fileName;
    private final HashMap<String, Integer> listOfWords = new HashMap<>();

    /**
     * Constructor.
     * @param fileName The file to use.
     */
    public FileProcessor(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Return the number of lines in the file.
     * @return Number of lines in the file.
     */
    public long getNumLines() {
        try {
            Path path = Paths.get(fileName);
            return Files.lines(path).count();
        } catch (IOException ioe) {
            System.out.println("File not found? Bad Permissions?");
            ioe.printStackTrace();
        }
        return 0;
    }

    private void parseLine(final String[] line, final Dictionary dictionary) {
        for (String word: line) {
            String formattedWord = word.toLowerCase();
            if (dictionary.contains(formattedWord)) {
                addWordToWordList(formattedWord);
            }
        }
    }

    private void addWordToWordList(final String word) {
        listOfWords.computeIfPresent(word, (k, v) -> v + INCREMENT_AMOUNT_PER_WORD);
        if (!listOfWords.containsKey(word)) {
            listOfWords.put(word, INCREMENT_AMOUNT_PER_WORD);
        }
    }

    /**
     * Parses the file, and counts how many times each word occurs in the file.
     * @param dictionary Dictionary of words to check for.
     */
    public void calcWordCount(final Dictionary dictionary) {
        try {
            Scanner sc2 = new Scanner(new File(fileName));
            while (sc2.hasNextLine()) {
                String[] words = sc2.nextLine().split("[^\\p{L}']+");
                parseLine(words, dictionary);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * How many different words are in the file.
     * @return How many different words are in the file as an int.
     */
    public int distinctWordCount() {
        return listOfWords.size();
    }

    /**
     * Returns how many words there are in total in the file.
     * @return How many words the file contains.
     */
    public int totalWordCount() {
        int wordCount = 0;
        for (Integer value : listOfWords.values()) {
            wordCount += value;
        }
        return wordCount;
    }

    /**
     * Returns how many times a given word occurs in the file.
     * @param word The word to get the occurrences of.
     * @return How many times the given words occure.
     */
    public int getNumOccurrences(final String word) {
        return listOfWords.get(word);
    }
}
