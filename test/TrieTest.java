import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by david on 11/8/16.
 */
public class TrieTest {
    @Test
    public void isPrefix() throws Exception {
        Trie trie = new Trie();
        trie.addWord("hello");
        trie.addWord("helloworld");
        trie.addWord("hello");
        assertTrue(trie.isPrefix(""));
        assertTrue(trie.isPrefix("h"));
        assertTrue(trie.isPrefix("he"));
        assertTrue(trie.isPrefix("hel"));
        assertTrue(trie.isPrefix("hell"));
        assertTrue(trie.isPrefix("hello"));

        assertFalse(trie.isPrefix("hello world"));
        assertFalse(trie.isPrefix("ello"));
    }

    @Test
    public void isWord() throws Exception {
        Trie trie = new Trie();
        trie.addWord("hello");
        trie.addWord("helloworld");

        assertTrue(trie.isWord("hello"));
        assertTrue(trie.isWord("helloworld"));

        assertFalse(trie.isWord("hell"));
        assertFalse(trie.isWord("hellow"));
    }
}
