package string;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/* LeetCode
* 1662. Check If Two String Arrays are Equivalent
* https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
* */
public class TwoStringArraysEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}
