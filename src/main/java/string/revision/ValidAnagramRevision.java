package string.revision;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.groupingBy;

/*
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 * */
public class ValidAnagramRevision {

    public static boolean isAnagram(String s, String t) {
        Map<Character, Long> freqS = s.chars()
                .mapToObj(ch -> (char)ch)
                .collect(groupingBy(Function.identity(), counting()));

        for (int i = 0; i < t.length(); i++) {
            long updatedFreq = freqS.merge(t.charAt(i), -1l, Long::sum);
            if (updatedFreq < 0){
                return false;
            }
            if (updatedFreq == 0){
                freqS.remove(t.charAt(i));
            }
        }
        return freqS.size() == 0;
    }

}
