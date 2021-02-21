package string.hackerrank;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        if (s == null || s.length() == 1) {
            return 0;
        }
        int counter = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)){
                counter++;
            }
        }
        return counter;
    }

}
/*
* Description
* https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
*
Alternating Characters

*
* */
