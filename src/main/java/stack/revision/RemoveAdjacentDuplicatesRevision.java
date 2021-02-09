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

        StringBuilder characters = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (characters.length() > 0 && S.charAt(i) == characters.charAt(characters.length()-1)) {
                characters.deleteCharAt(characters.length()-1);
            } else {
                characters.append(S.charAt(i));
            }
        }
        return characters.toString();
    }

}
