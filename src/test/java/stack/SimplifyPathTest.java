package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplifyPathTest {

    @Test
    void shouldReturnCorrectPath() {
        String actualPath = SimplifyPath.calculateSimplePath("/a//b////c/d//././/..");
        assertEquals(actualPath, "/a/b/c");
    }

    @Test
    void shouldReturnCorrectPath2() {
        String actualPath = SimplifyPath.calculateSimplePath("/a/../../b/../c//.//");
        assertEquals(actualPath, "/c");
    }

    @Test
    void shouldReturnCorrectPath3() {
        String actualPath = SimplifyPath.calculateSimplePath("/a/./b/../../c/");
        assertEquals(actualPath, "/c");
    }

    @Test
    void shouldReturnCorrectPath4() {
        String actualPath = SimplifyPath.calculateSimplePath("/home//foo/");
        assertEquals(actualPath, "/home/foo");
    }

    @Test
    void shouldReturnCorrectPath5() {
        String actualPath = SimplifyPath.calculateSimplePath("/../");
        assertEquals(actualPath, "/");
    }

    @Test
    void shouldReturnWhenEmptyString() {
        String actualPath = SimplifyPath.calculateSimplePath("");
        assertEquals(actualPath, "/");
    }

}