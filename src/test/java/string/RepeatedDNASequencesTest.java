package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RepeatedDNASequencesTest {

    @Test
    void findRepeatedDnaSequences() {
        String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> expectedResult = List.of("AAAAACCCCC","CCCCCAAAAA");

        List<String> actualResult = RepeatedDNASequences.findRepeatedDnaSequences(input);
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }


    @Test
    void findRepeatedDnaSequences2() {
        String input = "AAAAAAAAAAAAA";
        List<String> expectedResult = List.of("AAAAAAAAAA");

        List<String> actualResult = RepeatedDNASequences.findRepeatedDnaSequences(input);
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }


    @Test
    void findRepeatedDnaSequences3() {
        String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTTCCCCCCCCACCCCCCCCCAC";
        List<String> expectedResult = List.of("AAAAACCCCC","CCCCCAAAAA", "CCCCCCCCAC");

        List<String> actualResult = RepeatedDNASequences.findRepeatedDnaSequences(input);
        assertThat(expectedResult).hasSameElementsAs(actualResult);
    }
}