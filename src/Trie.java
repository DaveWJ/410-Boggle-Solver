import java.util.HashMap;

/**
 * Created by david on 11/8/16.
 */
class Trie {
    private HashMap<Character, Trie> branches;
    private char[] isWord = null;

    public Trie() {
        this.branches = new HashMap<>(4, 1);
    }

    boolean isPrefix(String word) {
        return isPrefix(word.toCharArray());
    }

    boolean isPrefix(char[] chars) {
        return findMaxDepth(chars) != null;
    }

    Trie findMaxDepth(char[] chars) {
        Trie currentLevel = this;
        for (int i = 0; i < chars.length; i++) {
            char currentLetter = chars[i];
            if (currentLevel.branches.containsKey(currentLetter)) {
                currentLevel = currentLevel.branches.get(currentLetter);
            } else {
                return null;
            }
        }
        return currentLevel;
    }

    char[] isWord(String word) {
        return isWord(word.toCharArray());
    }

    char[] isWord(char[] chars) {
        Trie maxLevel = findMaxDepth(chars);
        return (maxLevel == null) ? null : maxLevel.isWord ;
    }

    void addWord(String word, char[] original) {
        addWord(word.toCharArray(), 0, original);
    }

    void addWord(char[] word, char[] orginal) {
        addWord(word, 0, orginal);
    }

    void addWord(char[] word, int start, char[] original) {
        if (start == word.length) {
            isWord = original;
        } else {
            char firstLetter = word[start];
            if (!branches.containsKey(firstLetter)) {
                Trie newBranch = new Trie();
                branches.put(firstLetter, newBranch);
                newBranch.addWord(word, start + 1, original);
            } else {
                branches.get(firstLetter).addWord(word, start + 1, original);
            }
        }
    }
}
