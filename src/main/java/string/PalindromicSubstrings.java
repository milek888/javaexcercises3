package string;


/*
 * Leetcode 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * */
public class PalindromicSubstrings {

    //the best method
    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += centreCount(s, i, i);
            count += centreCount(s, i, i + 1);
        }
        return count;
    }

    private static int centreCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static int countSubstringsBrutForce(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                counter += isPalindrome(s.substring(i, j)) ? 1 : 0;
            }
        }
        return counter;
    }


    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }

    public static int countSubstringsDynamicProg(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {//dla jednej litery
            isPalindrome[i][i] = true;
            counter++;
        }

        //musimy sprawdzic dla duliterowych bo to potrzebne w warunku (*)
        //dla 2 liter - tylko wpisujemy dla [i][i+1] bo nie moze byc [i+1][i] bo mamy substr od mniejszej do wiekszej
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                isPalindrome[i][i+1] = true;
                counter++;
            } else {
                isPalindrome[i][i+1] = false;
            }

        }

        for (int len = 2; len <= s.length(); len++) {
            for (int j=0; j < s.length()-len; j++) {
                if(isPalindrome[j+1][j+len-1] && s.charAt(j) == s.charAt(j+len)) {//(*)
                    isPalindrome[j][j+len] = true;
                    counter ++;
                }
            }
        }
        return counter;
    }

}
