package arrays.java8;

import arrays.java8.policies.Area;
import arrays.java8.policies.MaxNumberPoliciesFromAllAreas;
import arrays.java8.policies.Policy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MaxNumberPoliciesFromAllAreasTest {
    private List<Policy> policies;

    @BeforeEach
    void setUp() {
        policies = List.of(new Policy(1, new Area("Krakow", "Huta")),
                new Policy(2, new Area("Krakow", "Azory")),
                new Policy(3, new Area("Krakow", "Azory")),
                new Policy(4, new Area("Krakow", "Azory")),
                new Policy(5, new Area("Rzeszow", "Baranowka")),
                new Policy(6, new Area("Rzeszow", "Baranowka")),
                new Policy(7, new Area("Rzeszow", "Podpromie")));
    }

    @Test
    void getMaxNumberOfPoliciesByArea() {
        long actualResult = MaxNumberPoliciesFromAllAreas.getMaxNumberOfPoliciesByArea(policies);
        long expectedResult = 3;
        Assertions.assertEquals(expectedResult, actualResult);
    }
}