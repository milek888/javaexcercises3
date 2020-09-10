package stack;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimplifyPath {//TODO This is incorrect because doesn't work for "/..."
    //TODO poczytac o zlozonosci operacji StringBuildra insert append.

    private static Pattern directoryOrBack = Pattern.compile("/\\.\\.|/\\w+");
    private static String directory = "/\\w+";
    private static String back = "/\\.\\.";
    /* 1) remove all '/.'
     *  2) replace all '////' with single '/'
     *  3) remove '/' in the end if exists
     *  4) iterate path and push on stack every '/a', '/b' '/c' ...
     *     if '/..' pop from stack, if stack empty do nothing
     * */

    public static String calculateSimplePath(String path) {
        Stack<String> pathOperations = new Stack<>();

        String normalizedPath = path.replaceAll("/\\.(?!\\.)", "")
                .replaceAll("/+", "/")
                .replaceAll("/$", "");

        Matcher matcher = directoryOrBack.matcher(normalizedPath);
        while (matcher.find()) {
    /*        System.out.print("Start index: " + matcher.start());//TODO this is only for debug purposes
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());*/

            if (matcher.group().matches(directory)) {
                pathOperations.push(matcher.group());
            } else {
                if(!pathOperations.isEmpty()) {//TODO get rid of this nested if
                    pathOperations.pop();
                }
            }
        }

        String finalPath = "";
        while (!pathOperations.isEmpty()) {
            finalPath = String.join("", pathOperations.pop(), finalPath);
            /*  finalPath = pathOperations.pop().concat(finalPath);*/
        }

        return finalPath.isEmpty() ? "/" : finalPath;
    }

/*    Powiazane i ciekawe
https://stackoverflow.com/questions/31817290/string-join-vs-other-string-concatenation-operations
https://dzone.com/articles/two-ways-to-join-string-in-java-8-stringjoiner-and
*
* */

}













