package stack;

import java.util.Stack;

/*
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/
 * */
public class DecodeString {
    /*
     * ']' wyzwala operacje dekodowania. Zdejmujemy ze stosu wszystko az do nawiasu otwierajaceggo
     * '[' i zapisujemy w temp. Zdejmujemy jeszcze numer przed nawiasem. Wykonujemy operacje powielenia
     * stringa i wrzucamy rezultat spowrotem na stos.
     * */
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ']') {
                    StringBuilder encoded = new StringBuilder();
                    while (stack.peek() != '[') {
                        encoded.append(stack.pop());
                    }
                    //TODO dekodujemy liczbe
                    int multiply = Integer.valueOf(stack.pop());
                    StringBuilder decoded = new StringBuilder();
                    for (int j = 0; j < multiply; j++) {
                        decoded.append(encoded);
                    }
                    for (int l = 0; l < encoded.length(); l++) {
                        stack.push(encoded.charAt(l));
                    }
                } else {
                    stack.push(s.charAt(i));
                }
        }

        return null;
    }
}
