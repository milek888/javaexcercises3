package stack.revision;

import java.util.Set;
import java.util.Stack;

/*
  71. Simplify Path
* https://leetcode.com/problems/simplify-path/
Input: path = "/a/./b/../../c/"
Output: "/c"
* */
public class SimplifyPathRevision {

    public static final Set<String> MININGLESS_CHARS = Set.of("", ".");
    public static final String BACK_DIRECTORY = "..";

    //It works assuming path
    public static String calculateSimplePath(String path) {

        Stack<String> pathItemsStack = new Stack<>();

        String[] dupa = path.split("/");
        for (String element : dupa) {

            if (element.equals(BACK_DIRECTORY) && !pathItemsStack.isEmpty()) {
                pathItemsStack.pop();
            }
            if (!element.equals(BACK_DIRECTORY) && !MININGLESS_CHARS.contains(element)) {
                pathItemsStack.push(element);
            }
        }

        StringBuilder resultPath = new StringBuilder();
        pathItemsStack.forEach(character -> resultPath.append("/")
                .append(character));

        return resultPath.toString().isEmpty() ? "/" : resultPath.toString();
    }
}
