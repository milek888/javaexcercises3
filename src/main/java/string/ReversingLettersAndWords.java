package string;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Anghel Leonard -> Java Coding Problems Problem 3,
* 557. Reverse Words in a String III  https://leetcode.com/problems/reverse-words-in-a-string-iii/solution/
*
* Input is String which consists of words. Task is to revert letters for every word and
* return String with reverted words. The order of words should be the same as the input order.
* Example: Input: "Ala ma kota"
*          Output: "alA am atok"
* */
public class ReversingLettersAndWords {

    private static final String WHITESPACE = "\\s";

    public static String reverseWords(String str) {
        String[] words = str.split(WHITESPACE);
        return Stream.of(words).map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .collect(Collectors.joining(" "));
    }
}

