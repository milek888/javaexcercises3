package stack.revision;


import java.util.Stack;

/*
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/
 *
 * Dobry opis:
 * In the previous approach, we used a single character stack to store the digits(0-9) as well as letters (a-z).
 * We could instead maintain 2 separate stacks.
       - countStack: The stack would store all the integer k.
       - stringStack: The stack would store all the decoded strings.

 * Iterate over the string s and process each character as follows:
 *
 * Case 1) If the current character is a digit (0-9), append it to the number k.

   Case 2) If the current character is a letter (a-z), append it to the currentString.

   Case 3) If current character is a opening bracket [, push k and currentString into countStack and stringStack respectively.

   Case 4) Closing bracket ]: We must begin the decoding process,

           - We must decode the currentString. Pop currentK from the countStack and decode the pattern currentK[currentString]

           - As the stringStack contains the previously decoded string, pop the decodedString from the stringStack. Update the decodedString = decodedString + currentK[currentString]
 *
 * */
public class DecodeStringRevision {

    public static String decodeString(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> numbersStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {//start catenating number

                k = k * 10 + s.charAt(i) - '0';

            } else if (s.charAt(i) == '[') {//push number and currentString to stacks and reset them

                numbersStack.push(k);
                stringStack.push(currentString);
                k = 0;
                currentString = new StringBuilder();

            } else if (s.charAt(i) == ']') {//start decoding

                int multiplier = numbersStack.pop();
                StringBuilder decodedString = stringStack.pop();
                for (int j = 0; j < multiplier; j++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;

            } else {//letter

                currentString.append(s.charAt(i));
            }
        }

        return currentString.toString();
    }
}
