package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * LeetCode 819. Most Common Word
 * https://leetcode.com/problems/most-common-word/
 *
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
   Output: "ball"
 * */
public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        String paragraphWithoutPunctuations = paragraph.replaceAll("[^a-zA-Z0-9]", " ")
                .toLowerCase();
        String[] wordsFromParagraph = paragraphWithoutPunctuations.split("\\s+");


        Set<String> bannedWords = Stream.of(banned)
                .collect(Collectors.toSet());//alternatywnie mozna Collections.addAll(bannedWords, banned);
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
        String paragraphWithoutPunctuations = paragraph.replaceAll("[^a-zA-Z0-9]", " ")
                .toLowerCase();
        String[] wordsFromParagraph = paragraphWithoutPunctuations.split("\\s+");


        Set<String> bannedWords = Stream.of(banned)
                .collect(Collectors.toSet());//alternatywnie mozna Collections.addAll(bannedWords, banned);
        HashMap<String, Integer> frequency = new HashMap<>();
        int maxFrequency = 0;
        int currentFrequency = 0;


        for (String word : wordsFromParagraph) {
            if (!bannedWords.contains(word)) {
                frequency.merge(word, 1, Integer::sum);
            }
        }

        /*alternatywnie mozna  .max(Comparator.comparing(Map.Entry::getValue))*/
        String mostCommonWord = frequency.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
        return mostCommonWord;
    }

}
/*
* Opis
* Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.



Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
* */
