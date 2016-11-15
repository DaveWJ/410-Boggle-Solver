/**
 * Created by david on 11/8/16.
 */
class Trie {
    private Trie[] branches = new Trie[26];
    private boolean isWord = false;

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
            if (currentLevel.branches[currentLetter - 'a'] != null) {
                currentLevel = currentLevel.branches[currentLetter - 'a'];
            } else {
                return null;
            }
        }
        return currentLevel;
    }

    boolean isWord(String word) {
        return isWord(word.toCharArray());
    }

    boolean isWord(char[] chars) {
        Trie maxLevel = findMaxDepth(chars);
        return maxLevel != null && maxLevel.isWord;
    }

    void addWord(String word) {
        addWord(word.toCharArray(), 0);
    }

    void addWord(char[] word) {
        addWord(word, 0);
    }

    void addWord(char[] word, int start) {
        if (start == word.length) {
            isWord = true;
        } else {
            int firstLetter = word[start];
            if (this.branches[firstLetter - 'a'] == null) {
                Trie newBranch = new Trie();
                this.branches[firstLetter - 'a'] = newBranch;
                newBranch.addWord(word, start + 1);
            } else {
                this.branches[firstLetter - 'a'].addWord(word, start + 1);
            }
        }
    }
}
