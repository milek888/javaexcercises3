package other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentWordsTest {//TODO refactor tests

    TopKFrequentWords topKFrequentWords;

    @BeforeEach
    void setUp() {
        topKFrequentWords = new TopKFrequentWords();
    }

    @Test
    void topKFrequent() {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        List<String> actualResult = topKFrequentWords.topKFrequent(words, 2);
        List<String> expectedResult = List.of("i", "love");
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void topKFrequent2() {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> actualResult = topKFrequentWords.topKFrequent(words, 4);
        List<String> expectedResult = List.of("the", "is", "sunny", "day");
        assertIterableEquals(expectedResult, actualResult);
    }

    //------------------------------------------------------------------------------------------------------------

    @Test
    void topKFrequent3() {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        List<String> actualResult = topKFrequentWords.topKFrequentPriorityQueue(words, 2);
        List<String> expectedResult = List.of("i", "love");
        assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void topKFrequent4() {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> actualResult = topKFrequentWords.topKFrequentPriorityQueue(words, 4);
        List<String> expectedResult = List.of("the", "is", "sunny", "day");
        assertIterableEquals(expectedResult, actualResult);
    }
}