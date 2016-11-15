import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

class Client {
    static int boardSize = 7;
    static HashMap<Integer, Integer> lenCount = new HashMap<>();

    public static void main(String[] args) throws Exception {
        char[] word = {'z','a','c','a','z','f'};
        char[] sortedWord = sortedWord(word);
        for (char c : sortedWord) {
            System.out.print(c);
        }
        System.out.println();
        Trie trie = new Trie();
        Scanner scanner = new Scanner(new File("/home/david/410-Boggle-Solver/smaller.txt"));
        loadDict(scanner, trie);
        System.out.println(trie.isWord("a"));
        System.out.println(trie.isWord("aaron"));
        System.out.println(trie.isWord("raoan"));
        System.out.println(trie.isWord("trendy"));
        System.out.println(trie.isWord("washing"));
        System.out.println(trie.isWord("cryptozoic"));
        System.out.println(trie.isWord("culbertson"));
        System.out.println(trie.isWord("aaliyah"));

        System.out.println();

        System.out.println(trie.isPrefix("waldo"));
        System.out.println(trie.isPrefix("wash"));
        System.out.println(trie.isPrefix("cu"));
        System.out.println(trie.isPrefix("zzz"));

        for (Integer len: lenCount.keySet()) {
            System.out.println("len: " + len + ", count: " + lenCount.get(len));
        }
    }

    public static void loadDict(Scanner input, Trie root) {
        while (input.hasNext()) {
            String line = input.nextLine().toLowerCase();
            int len = line.length();
            if (lenCount.containsKey(len)){
                lenCount.put(len, lenCount.get(len) + 1);
            } else {
                lenCount.put(len, 1);
            }
            if (line.length() <= boardSize) {
//                root.addWord(line);
                permutation(line, root);
            }
        }
    }

    public static void permutation(String str, Trie root) {
        permutation("", str, root);
    }


    private static void permutation(char[] word){
        char[] permutations = new char[word.length];
    }

    private static char[] sortedWord(char[] word){
        char[] sortedWord = new char[word.length];
        int k = 26;
        int[] c = new int[26];
        for (char letter : word) {
            c[letter - 'a'] = c[letter - 'a'] + 1;
        }

        for (int i = 1; i < k; i++) {
            c[i] = c[i] + c[i - 1];
        }

        for (int i = word.length -1; i >= 0; i--) {
            int letterLocation = word[i] - 'a';
            int location = c[letterLocation] - 1;
            sortedWord[location] = word[i];
            c[word[i] - 'a'] = c[word[i] - 'a'] - 1;
        }
        return sortedWord;
    }

    /*
          countingsort(A[], B[], k)
	for i = 1 to k do
	   C[i] = 0

	for j = 1 to length(A) do
	   C[A[j]] = C[A[j]] + 1

	for 2 = 1 to k do
	   C[i] = C[i] + C[i-1]

	for j = 1 to length(A) do
	   B[C[A[j]]] = A[j]
	   C[A[j]] = C[A[j]] - 1
     */


    private static void permutation(String prefix, String str, Trie root) {
        int n = str.length();
        if (n == 0) {
            root.addWord(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), root);
        }
    }


}
