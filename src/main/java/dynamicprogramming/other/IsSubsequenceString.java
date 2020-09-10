package dynamicprogramming.other;


import java.util.ArrayList;
import java.util.stream.Collectors;

/*
 * LeetCode ---> 392. Is Subsequence
 *   https://leetcode.com/problems/is-subsequence/
 *   Given a string s and a string t, check if s is subsequence of t.
 *   A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *   Follow up:
 *   If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has
 *  its subsequence. In this scenario, how would you change your code?
 * */
public class IsSubsequenceString {//TODO zmienic nazwe testow na poprawne i przypadki brzegowe

    ArrayList<CharStatistic> charStatistics = new ArrayList<>();

    public boolean isSubsequence(String s, String t) {

        charStatistics = s.chars()
                .mapToObj(ch -> new CharStatistic((char) ch, Integer.MAX_VALUE, -1))
                .collect(Collectors.toCollection(ArrayList::new));

        int i = 0;
        while (charStatistics.size() > 1 && i < t.length()) {//iteration t
            char currentChar = t.charAt(i);

            for (int j = 0; j < charStatistics.size(); j++) {//iteration s
                final CharStatistic current = charStatistics.get(j);
                if (current.getCharacter() == currentChar) {
                    current.setMinIndex(Integer.min(current.getMinIndex(), j));
                    current.setLastIndex(i);
                    if (j != 0 && current.getLastIndex() > charStatistics.get(j - 1).getMinIndex()) {
                        charStatistics.remove(j - 1);
                    }
                }
            }

            i++;
        }

        return charStatistics.size() == 1;
    }

    /*
     * Better solution from leet code
     * */
    public boolean isSubsequence2(String s, String t) {
        if(s == null || t == null) {
           return false;
        }
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            while (j < t.length() && s.charAt(i) != t.charAt(j)) {
                j++;
            }
            if(j == t.length()) {//wyczerplaismy String t i nie znalexlismy dopasowania dla litery z s => caly wynik false;
                return false;
            }
            i++;
        }

        return true;
    }


}
