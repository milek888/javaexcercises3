package java8.policies;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* Fajny tutorial z optionalami
*  https://www.nurkiewicz.com/2013/08/optional-in-java-8-cheat-sheet.html
* */
public class MaxNumberPoliciesFromAllAreas {

    public static long getMaxNumberOfPoliciesByArea(List<Policy> policies) {
        return policies.stream()
                .collect(Collectors.groupingBy(Policy::getArea, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getValue)//!!! bardzo faje rozwiazanie zeby wydostac value jak intnieje
                .orElse(0l);
    }

}
