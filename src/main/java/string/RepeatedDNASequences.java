package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * LeetCode 187. Repeated DNA Sequences
 * https://leetcode.com/problems/repeated-dna-sequences/
 * */
public class RepeatedDNASequences {

    private static final int PATTERN_LENGTH = 10;
    private static final int NUMBER_OF_LETTERS = 4;

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> resultSet = new HashSet<>();
        Map<Integer, String> hashesFrequencies = new HashMap<>();
        int n = s.length();
        int currentHash = 0;

        if (s.length() < 10) {
            return new ArrayList<>();
        }

        for (int i = 0; i < n - PATTERN_LENGTH + 1; i++) {

            if (i == 0) {
                currentHash = calculateInitialHash(s.subSequence(0, PATTERN_LENGTH)
                        .toString());
            } else {
                currentHash = calculateRollingHash(s.substring(i - 1, i + PATTERN_LENGTH), currentHash);
            }

            String currentSequence = s.substring(i, i + PATTERN_LENGTH);
            String prevSequence = hashesFrequencies.putIfAbsent(currentHash, currentSequence);
            if (currentSequence.equals(prevSequence)) {
                resultSet.add(currentSequence);
            }

        }//for

        return new ArrayList<>(resultSet);
    }

    private static int calculateRollingHash(String input, int currentHash) {
        int substract = (int) ((input.charAt(0) - 'a') * Math.pow(NUMBER_OF_LETTERS, PATTERN_LENGTH - 1));
        int add = input.charAt(PATTERN_LENGTH) - 'a';
        return (currentHash - substract) * NUMBER_OF_LETTERS + add;
    }

    private static int calculateInitialHash(String input) {
        int hash = 0;
        for (int i = 0; i < input.length(); i++) {
            hash = hash * NUMBER_OF_LETTERS;
            hash += input.charAt(i) - 'a';
        }
        return hash;
    }

}
/*
* Description
*
* All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
*
* */