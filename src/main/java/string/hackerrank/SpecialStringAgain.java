package string.hackerrank;

public class SpecialStringAgain {
    // Complete the substrCount function below.
    public static long substrCount(int n, String s) {
        int count = 0;
        if(s.length() <=1){
            return 1;
        }
        for (int i = 0; i < s.length()-1; i++) {
            count += centreCount(s, i, i);
            count += centreCount(s, i, i+1);
        }
return count;

    }

    private static int centreCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)) {
                break;
            }
            count++;
            left--;
            right++;
        }
        return count;
    }

}
/*
 * https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 * */
