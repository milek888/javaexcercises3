package string;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindAllAnagramsInStringTest {
/*
* "cbaebabacd"
"abc"
* */
    @Test
    void findAnagrams() {
        List<Integer> result = FindAllAnagramsInString.findAnagrams("cbaebabacd", "abc");
        System.out.println("---");
    }
}