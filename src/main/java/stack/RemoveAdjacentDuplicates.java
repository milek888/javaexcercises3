package stack;

/*
 *1047. Remove All Adjacent Duplicates In String
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * */
public class RemoveAdjacentDuplicates {

    public static String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
            StringBuilder result = new StringBuilder();// Stack<String> stack = new Stack<>();}

            for (int i = 0; i < S.length(); i++) {
                int resLength = result.length();

                if (resLength > 0 && S.charAt(i) == result.charAt(resLength - 1)) {// if ( !stack.isEmpty() && stack.peek().equals(currChar) )
                    result.deleteCharAt(result.length() - 1);//stack.pop();
                } else {
                    result.append(S.charAt(i));//stack.push(currChar);
                }
            }

            return result.toString();
        }

}
