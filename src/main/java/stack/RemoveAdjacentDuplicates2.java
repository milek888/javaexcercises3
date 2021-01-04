package stack;

import java.util.Stack;

public class RemoveAdjacentDuplicates2 {

    /*
     * Better solution with 1 stack - kolejne ulepszenie
     * */
    public static String removeDuplicatesOneStack2(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;//po iteracji w ktorej usuniemy elementy ze stosu (StringBuildera) zmienia sie rozmiar StringBuildera
                              // wiec elemenbty po prawej stronie przesuna sie w lewo. Wiec musimy odpowiednio cofnac licznik
                              // o to przesuniecie zeby uwzglednic te elementy. Inaczej bysmy je pomineli.
                } else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }


    /*
     * Better solution with 1 stack
     * */
    public static String removeDuplicatesOneStack(String s, int k) {
        Stack<Integer> counterStack = new Stack<>();
        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            int size = result.length();

            if (counterStack.isEmpty()) {
                result.append(s.charAt(i));//dodajemy znak
                counterStack.push(1);//inicjujemy licznik
            } else {
                if (s.charAt(i) == result.charAt(size-1)) {
                    if (counterStack.peek() == k - 1) {
                        //zdjemujemy ze stosu k-1 elementow
                        result.delete(size - k + 1, size);
                        counterStack.pop();//usuwamy licznik dla znaku
                    } else {
                        counterStack.push(counterStack.pop() + 1);//zwiekszamy licznik
                        result.append(s.charAt(i));//dodajemy znak
                    }
                } else {
                    result.append(s.charAt(i));//dodajemy znak
                    counterStack.push(1);//inicjujemy licznik
                }
            }
        }

        return result.toString();
    }

    /*
     * Solution with 2 stacks
     * */
    public static String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> counterStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));//dodajemy znak
                counterStack.push(1);//inicjujemy licznik
            } else {
                if (s.charAt(i) == stack.peek()) {
                    if (counterStack.peek() == k - 1) {
                        //zdjemujemy ze stosu k - 1 elementow
                        for (int j = 0; j < k - 1; j++) {
                            stack.pop();
                        }
                        counterStack.pop();//usuwamy licznik dla znaku
                    } else {
                        counterStack.push(counterStack.pop() + 1);//zwiekszamy licznik
                        stack.push(s.charAt(i));//dodajemy znak
                    }
                } else {
                    stack.push(s.charAt(i));//dodajemy znak
                    counterStack.push(1);//inicjujemy licznik
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
