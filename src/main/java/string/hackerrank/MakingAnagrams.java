package string.hackerrank;

import java.util.HashMap;
import java.util.Map;

/*
https://www.hackerrank.com/
* Strings: Making Anagrams
 * */
public class MakingAnagrams {

    static int makeAnagram(String a, String b) {
        Map<Character, Integer> frequenciesA = new HashMap<>();
        Map<Character, Integer> frequenciesB = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            frequenciesA.merge(a.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < b.length(); i++) {
            frequenciesB.merge(b.charAt(i), 1, Integer::sum);
        }

        int countDeletionsA = 0;
        for (Character character : frequenciesA.keySet()) {
            Integer countA = frequenciesA.get(character);
            Integer countB = frequenciesB.getOrDefault(character, 0);
            countDeletionsA += Math.max(countA - countB, 0);
        }

        int countDeletionsB = 0;
        for (Character character : frequenciesB.keySet()) {
            Integer countB = frequenciesB.get(character);
            Integer countA = frequenciesA.getOrDefault(character, 0);
            countDeletionsB += Math.max(countB - countA, 0);
        }

        return countDeletionsA + countDeletionsB;
    }

}
/*
* Opis:
* https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
*
* Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams.
* Any characters can be deleted from either of the strings.
Example
   a ="cde"
   b ="dcf"
   Delete  e from  a and  f from b so that the remaining strings are  and  which are anagrams. This takes  character deletions.
* */