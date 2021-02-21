package string;

public class CheckingPalindrom {

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length()-1;
        while (left <= right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }

}
