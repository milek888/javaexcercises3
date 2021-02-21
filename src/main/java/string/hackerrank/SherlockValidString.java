package string.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Sherlock and the Valid String
 * */
public class SherlockValidString {

    static String isValid(String s) {
        if (s == null) {
            return "NO";
        }
        if (s.length() <= 1) {
            return "YES";
        }
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequencies.merge(s.charAt(i), 1, Integer::sum);
        }

        Map<Integer, Integer> freqFreq = new HashMap<>();
        for (int value : frequencies.values()) {
            freqFreq.merge(value, 1, Integer::sum);
        }
        if (freqFreq.size() > 2) {
            return "NO";
        }
        if (freqFreq.size() == 1) {
            return "YES";
        }

        if (freqFreq.size() == 2) {
            List<Map.Entry<Integer, Integer>> freqFreqEntries = new ArrayList<>(freqFreq.entrySet());
            int key1 = freqFreqEntries.get(0).getKey();
            int key2 = freqFreqEntries.get(1).getKey();
            int val1 = freqFreqEntries.get(0).getValue();
            int val2 = freqFreqEntries.get(1).getValue();
            if (Math.abs(key1 - key2) == 1 && (val1 == 1 || val2 == 1)) {
                return "YES";
            }
        }

        return "NO";
    }

}

/*
* Opis
* https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
* Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if
*  he can remove just  character at  index in the string, and the remaining characters will occur the same number of times.
* Given a string , determine if it is valid. If so, return YES, otherwise return NO.

   Example
   abc
  This is a valid string because frequencies are 1

  abcc
 This is a valid string because we can remove one  c

 * abccc - not valid String
* */