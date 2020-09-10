package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplifyPathCorrectTest {

    SimplifyPathCorrect simplifyPathCorrect;

    @BeforeEach
    void setUp() {
        simplifyPathCorrect = new SimplifyPathCorrect();
    }

    @Test
    void shouldReturnCorrectPath() {
        String actualPath = simplifyPathCorrect.calculateSimplePath("/a//b////c/d//././/..");
        assertEquals(actualPath, "/a/b/c");
    }

    @Test
    void shouldReturnCorrectPath2() {
        String actualPath = simplifyPathCorrect.calculateSimplePath("/a/../../b/../c//.//");
        assertEquals(actualPath, "/c");
    }

    @Test
    void shouldReturnCorrectPath3() {
        String actualPath = simplifyPathCorrect.calculateSimplePath("/a/./b/../../c/");
        assertEquals(actualPath, "/c");
    }

    @Test
    void shouldReturnCorrectPath4() {
        String actualPath = simplifyPathCorrect.calculateSimplePath("/home//foo/");
        assertEquals(actualPath, "/home/foo");
    }

    @Test
    void shouldReturnCorrectPath5() {
        String actualPath = simplifyPathCorrect.calculateSimplePath("/../");
        assertEquals(actualPath, "/");
    }

    @Test
    void shouldReturnDirectoryThreeDots() {
        String actualPath = simplifyPathCorrect.calculateSimplePath("/...");
        assertEquals(actualPath, "/...");
    }
}