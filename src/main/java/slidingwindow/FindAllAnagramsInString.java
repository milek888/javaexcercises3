package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 438. Find All Anagrams in a String
* https://leetcode.com/problems/find-all-anagrams-in-a-string/
* Fajne wytlumaczenie sliding window techniq
*    https://www.geeksforgeeks.org/window-sliding-technique/
* */
public class FindAllAnagramsInString {
/*
* Wazne -> Zlozonosc porowanania dwoch HashMap
*          -> It's probably worth noting: we can compare p_count and s_count in constant time because they are both
*             at most size 26 (as they only contain the 26 lowercase characters). This makes comparing an O(26) operation
*              i.e. O(1)
* */
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character , Integer> pFrequencies = new HashMap<>();
        Map<Character , Integer> sFrequencies = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        //reference pattern window calculation
        for (Character ch : p.toCharArray()){
            pFrequencies.merge(ch, 1, Integer::sum);
        }

        for (int i = 0; i < s.length(); i++) {
            //next char
            sFrequencies.merge(s.charAt(i), 1, Integer::sum);

            //previous char
            if(i >= p.length()) {
                char prevChar = s.charAt(i - p.length());
                int updatedFrequency = sFrequencies.merge(prevChar, -1, Integer::sum);
                if (updatedFrequency == 0){
                    sFrequencies.remove(prevChar);
                }
            }

            if (pFrequencies.equals(sFrequencies)){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }

}
