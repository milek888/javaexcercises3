package stack.revision;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplifyPathRevisionTest {

    @Test
    void shouldReturnCorrectPath() {
        String actualPath = SimplifyPathRevision.calculateSimplePath("/a//b////c/d//././/..");
        assertEquals(actualPath, "/a/b/c");
    }

    @Test
    void shouldReturnCorrectPath2() {
        String actualPath = SimplifyPathRevision.calculateSimplePath("/a/../../b/../c//.//");
        assertEquals(actualPath, "/c");
    }

    @Test
    void shouldReturnCorrectPath3() {
        String actualPath = SimplifyPathRevision.calculateSimplePath("/a/./b/../../c/");
        assertEquals(actualPath, "/c");
    }

    @Test
    void shouldReturnCorrectPath4() {
        String actualPath = SimplifyPathRevision.calculateSimplePath("/home//foo/");
        assertEquals(actualPath, "/home/foo");
    }

    @Test
    void shouldReturnCorrectPath5() {
        String actualPath = SimplifyPathRevision.calculateSimplePath("/../");
        assertEquals(actualPath, "/");
    }

    @Test
    void shouldReturnDirectoryThreeDots() {
        String actualPath = SimplifyPathRevision.calculateSimplePath("/...");
        assertEquals(actualPath, "/...");
    }
}