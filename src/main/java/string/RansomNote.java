package string;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
* 383. Ransom Note
*https://leetcode.com/problems/ransom-note/
* */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null){
            return false;
        }
/*        Map<Character, Long> magazineFrequencies = magazine.chars()
                .mapToObj(ch -> (char)ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));*/

        Map<Character, Long> magazineFrequencies = new HashMap<>();
        for (int i = 0; i< magazine.length(); i++){
            magazineFrequencies.merge(magazine.charAt(i), 1l, Long::sum);
        }

        for (int i = 0; i< ransomNote.length(); i++){
            long updatedValue = magazineFrequencies.merge(ransomNote.charAt(i), -1l, Long::sum);
            if (updatedValue < 0){
                return false;
            }
        }
        return true;
    }
}
/*
* Opis
* Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function
* that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
  Each letter in the magazine string can only be used once in your ransom note.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
*
*
* */
