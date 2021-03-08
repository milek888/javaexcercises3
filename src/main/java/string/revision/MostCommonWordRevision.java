package string.revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/*
 * LeetCode 819. Most Common Word
 * https://leetcode.com/problems/most-common-word/
 * */
public class MostCommonWordRevision {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String paragraphNoSpecChars = paragraph.replaceAll( "[^a-zA-Z1-9]", " ").toLowerCase();
        String[] test = paragraphNoSpecChars.split("\\s+");
        Set<String> bannedSet = Set.of(banned);
        Map<String, Integer> frequency = new HashMap<>();

        String result = Arrays.stream(paragraphNoSpecChars.split("\\s+"))
                .filter(word -> !bannedSet.contains(word))
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");

        return result;

        //Alternatywnie
        /*        for (String word : paragraphNoSpecChars.split(" ")){
            if (!bannedSet.contains(word)) {
                frequency.merge(word, 1, Integer::sum);
            }
        }

       return frequency.entrySet().stream()
               .max(Map.Entry.comparingByValue())
               .map(Map.Entry::getKey)
               .orElse("");*/

    }

}
