package string;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* LeetCode 819. Most Common Word
* https://leetcode.com/problems/most-common-word/
* */
public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        String paragraphWithoutPunctuations = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        String[] wordsFromParagraph = paragraphWithoutPunctuations.split("\\s+");


        Set<String> bannedWords = Stream.of(banned).collect(Collectors.toSet());//alternatywnie mozna Collections.addAll(bannedWords, banned);
        HashMap<String, Integer> frequency = new HashMap<>();
        int maxFrequency = 0;
        int currentFrequency = 0;

        String mostCommonWord = "";
        for (String word : wordsFromParagraph) {
            if (!bannedWords.contains(word)) {
                currentFrequency = frequency.merge(word, 1, Integer::sum);
                if (maxFrequency < currentFrequency) {
                    maxFrequency = currentFrequency;
                    mostCommonWord = word;
                }

            }
        }

        return mostCommonWord;
    }

    public static String mostCommonWord2(String paragraph, String[] banned) {
        String paragraphWithoutPunctuations = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        String[] wordsFromParagraph = paragraphWithoutPunctuations.split("\\s+");


        Set<String> bannedWords = Stream.of(banned).collect(Collectors.toSet());//alternatywnie mozna Collections.addAll(bannedWords, banned);
        HashMap<String, Integer> frequency = new HashMap<>();
        int maxFrequency = 0;
        int currentFrequency = 0;


        for (String word : wordsFromParagraph) {
            if (!bannedWords.contains(word)) {
                frequency.merge(word, 1, Integer::sum);
            }
        }

        /*alternatywnie mozna  .max(Comparator.comparing(Map.Entry::getValue))*/
        String mostCommonWord = frequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
        return mostCommonWord;
    }

}
/*
* Opis
* Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
* */
