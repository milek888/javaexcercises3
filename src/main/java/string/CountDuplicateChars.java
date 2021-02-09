package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/* Anghel Leonard -> Java Coding Problems Problem 1
* Nalezy zwrocic informacje ile razy powtarza sie dany znak w Stringu wejsciowym
* */
public class CountDuplicateChars {

    //1 sposob
    public Map<String, Long> countDuplicates(String input) {
        return Stream.of(input.split(""))
                .collect(groupingBy(Function.identity(), counting()));
    }

    //2 sposob
    public Map<Character, Long> countDuplicates2(String input) {
        return input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(groupingBy(Function.identity(), counting()));
    }

    //3 sposob
    public Map<Character, Integer> countDuplicates3(String input) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            frequencies.merge(input.charAt(i), 1, Integer::sum);
        }
        return frequencies;
    }

}
