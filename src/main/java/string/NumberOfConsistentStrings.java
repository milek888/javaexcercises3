package string;

import java.util.Set;
import java.util.stream.Collectors;

/*
 * 1684. Count the Number of Consistent Strings
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/
 *
 * */
public class NumberOfConsistentStrings {

    public static int countConsistentStrings(String allowed, String[] words) {
        if (allowed == null || words == null){
            return 0;
        }
        Set<Character> allowedSet = allowed.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());
        int counter = 0;
        for (String word : words) {
       /*     int i = 0;
            while (i < word.length() && allowedSet.contains(word.charAt(i))) {
                i++;
            }

            if (i == word.length()) {
                counter++;
            }*/
            //Alternatywnie mozna tak
            boolean isConsistent = word.chars().mapToObj(ch -> (char)ch)
                    .allMatch(allowedSet::contains);
            if (isConsistent) {
                counter++;
            }
        }
        return counter;
    }

}
/*
* Opis
* You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent
* if all characters in the string appear in the string allowed.
Return the number of consistent strings in the array words.
*
Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
*
*
* */