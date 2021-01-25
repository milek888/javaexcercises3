package stack.revision;

import java.util.ArrayDeque;
import java.util.Stack;

/*
 * /*
 *1047. Remove All Adjacent Duplicates In String
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * */
public class RemoveAdjacentDuplicatesRevision {
    public static String removeDuplicates(String S) {

        ArrayDeque<Character> characters = new ArrayDeque<>();
        if (S.length() > 0) {
            characters.push(S.charAt(0));
        } else {
            return S;
        }
        for (int i = 1; i < S.length(); i++) {
            if (!characters.isEmpty() && S.charAt(i) == characters.peek()) {
                characters.pop();
            } else {
                characters.push(S.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();

        characters.descendingIterator()
                .forEachRemaining(result::append);
        return result.toString();
    }

}
