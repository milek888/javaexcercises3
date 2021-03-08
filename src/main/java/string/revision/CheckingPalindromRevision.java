package string.revision;

import java.util.stream.IntStream;

public class CheckingPalindromRevision {

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j= str.length()-1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome2(String str){
        int n = str.length();
        return IntStream.range(0, n/2)
                .allMatch(i -> str.charAt(i) == str.charAt(n-i-1));
    }

}
