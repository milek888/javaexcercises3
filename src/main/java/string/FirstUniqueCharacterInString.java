package string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * */
public class FirstUniqueCharacterInString {

    //lebsze rozwiazanie z LeetCode
    public int firstUniqChar2(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> indexesMap = new LinkedHashMap<>();
        if (s == null || s.length() == 0) {
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (indexesMap.containsKey(s.charAt(i))) {
                indexesMap.put(s.charAt(i), -1);
            } else {
                indexesMap.put(s.charAt(i), i);
            }
        }
        return indexesMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > -1)
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(-1);

    }
}
