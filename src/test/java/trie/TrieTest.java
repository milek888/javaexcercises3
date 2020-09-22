package trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {//TODO refactor tests

    @Test
    void insert() {
        Trie trie = new Trie();
        trie.insert("milosz");
        boolean actualResult = trie.search("milosz");
        assertTrue(actualResult);
    }

    @Test
    void search() {
        Trie trie = new Trie();
        trie.insert("milosz");
        boolean actualResult = trie.search("milosz");
        assertTrue(actualResult);
    }

    @Test
    void startsWith() {
        Trie trie = new Trie();
        trie.insert("milosz");
        boolean actualResult = trie.startsWith("milo");
        assertTrue(actualResult);
    }
}