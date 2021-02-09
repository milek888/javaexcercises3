package string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/* Anghel Leonard -> Java Coding Problems Problem 2
 * Task is to find the first letter in a given String which doesn't repeat. It means it occurs only
 * once.
 * Example: input: "Alamakota" output: l explanation: l is the fiRst letter which doesn't have duplicate
 * in String.
 * */
public class FindingFirstNonRepeated {
 /*  Solution that's presented here relies on LinkedHashMap. This Java map is an insertion-order map
            *  (it maintains the order in which the keys were inserted into the map) and is very convenient for
            *  this solution
  *  */

    //TODO Uzywamy LinkedHashMap
    public static Optional<Character> find1(String input) {
        LinkedHashMap<Character, Integer> frequency = new LinkedHashMap<>();

        input.chars().forEach(ch -> frequency.merge((char)ch, 1, Integer::sum));

        return frequency.entrySet().stream()
                .findFirst()
                .map(Map.Entry::getKey);//TODO fajne zastosowanie mappingu w Optionalu
    }

    //LinkedHashMap
    public static Optional<Character> find2(String input) {
        return input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .findFirst()
                .map(Map.Entry::getKey);//TODO w grouping by mozna sobie okreslic jaka mape chcemy dzieki temu mamy uporzadkowana LinkedHashMap
    }
}
