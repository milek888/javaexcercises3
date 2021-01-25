package stack;

import java.util.Set;
import java.util.Stack;

/*
  71. Simplify Path
* https://leetcode.com/problems/simplify-path/
* */
public class SimplifyPathCorrect {

    final Set<String> minninglessOperators = Set.of("", ".");
    final String goBackDirecory = "..";

    public String calculateSimplePath(String path) {
        Stack<String> pathOperations = new Stack<>();
        /*
         * "", "." nothing
         * ".." pop
         * */
        String[] pathArray = path.split("/");
        for (String element : pathArray) {
            if (element.equals(goBackDirecory) && !pathOperations.empty()) {
                pathOperations.pop();
            }
            if(!element.equals(goBackDirecory) && !minninglessOperators.contains(element)){
                pathOperations.push(element);
            }
        }

    /*    String finalPath = "";
        while (!pathOperations.isEmpty()) {
            finalPath = String.join("", "/" + pathOperations.pop(), finalPath);
        }
        return finalPath.isEmpty() ? "/" : finalPath;
        */

        // Stich together all the directory names together
        StringBuilder result = new StringBuilder();
        //TODO !!!! Bardzo ciekawwe https://stackoverflow.com/questions/16992758/is-there-a-bug-in-java-util-stacks-iterator
        //https://www.techiedelight.com/potential-bug-stack-class-workaround/
        for (String dir : pathOperations) {
            result.append("/");
            result.append(dir);
        }

        return result.toString().isEmpty() ? "/" : result.toString();
    }
}
