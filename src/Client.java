import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Client {
    static int boardSize = 7;
    static HashMap<Integer, Integer> lenCount = new HashMap<>();

    public static void main(String[] args) throws Exception {
        stressTest();
//        tests();
    }

    private static void stressTest() throws FileNotFoundException {
        File outPut = new File("results.txt");
        PrintStream out = new PrintStream(outPut);
        int numWords = 0;
        Scanner scanner = new Scanner(new File("/home/david/410-Boggle-Solver/smaller.txt"));
        Trie root = new Trie();
        loadDict(scanner, root);
        System.out.println("FINISHED");
        scanner = new Scanner(new File("/home/david/410-Boggle-Solver/bigger.txt"));
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim().toLowerCase();
            char[] chars = line.toCharArray();
            SequenceOfChars currentSeq = new SequenceOfChars(32);
            for (int i = 0; i < chars.length; i++) {
                currentSeq.append(chars[i]);
                char[] sorted = currentSeq.asCharArray();
                Arrays.sort(sorted);
                if (!root.isPrefix(sorted)) {
                    break;
                }
            }
            char[] sorted = currentSeq.asCharArray();
            Arrays.sort(sorted);
            if (root.isWord(sorted) != null) {
                numWords++;
            } else {
//                System.out.println();
            }
        }
        System.out.println(numWords);
        char[] ard = "aardvark".toCharArray();
        Arrays.sort(ard);
        System.out.println(root.isPrefix(Arrays.copyOfRange(ard, 0, ard.length - 5)));
    }

    private static void tests() throws FileNotFoundException {
        char[] word = {'z', 'a', 'c', 'a', 'z', 'f'};
        char[] sortedWord = sortedWord(word);
        for (char c : sortedWord(word)) {
            System.out.print(c);
        }
        System.out.println();
        Trie trie = new Trie();
        Scanner scanner = new Scanner(new File("/home/david/410-Boggle-Solver/bigger.txt"));
        loadDict(scanner, trie);
//        System.out.println(trie.isWord("a"));
//        System.out.println(trie.isWord("aaron"));
//        System.out.println(trie.isWord("raoan"));
//        System.out.println(trie.isWord("trendy"));
//        System.out.println(trie.isWord("washing"));
        char[] cryptozoic = "cryptozoic".toLowerCase().toCharArray();
        Arrays.sort(cryptozoic);
        System.out.println(cryptozoic);
        System.out.println(trie.isWord(cryptozoic));
//        System.out.println(trie.isWord("culbertson"));
//        System.out.println(trie.isWord("aaliyah"));

        System.out.println();

        System.out.println(trie.isPrefix("waldo"));
        System.out.println(trie.isPrefix("wash"));
        System.out.println(trie.isPrefix("cu"));
        System.out.println(trie.isPrefix("zzzzzz"));

        for (Integer len : lenCount.keySet()) {
            System.out.println("len: " + len + ", count: " + lenCount.get(len));
        }
    }

    public static void loadDict(Scanner input, Trie root) {
        int numWords = 0;
        while (input.hasNext()) {
            String line = input.nextLine().toLowerCase().trim();
            int len = line.length();
            if (lenCount.containsKey(len)) {
                lenCount.put(len, lenCount.get(len) + 1);
            } else {
                lenCount.put(len, 1);
            }
            if (line.length() <= boardSize) {
                char[] word = line.toLowerCase().trim().toCharArray();
                Arrays.sort(word);
                root.addWord(word, line.toCharArray());
//                permutation(line, root);
            }
            numWords++;
            if (numWords % 100 == 0) {
                System.out.println("numwords: " + numWords);
            }
        }
        System.out.println(numWords);
    }

    public static void permutation(String str, Trie root) {
        permutation("", str, root);
    }


    private static void permutation(char[] word) {
        char[] permutations = new char[word.length];
    }

    private static char[] sortedWord(char[] word) {
        char[] sortedWord = new char[word.length];
        int k = 26;
        int[] c = new int[26];
        for (char letter : word) {
            c[letter - 'a'] = c[letter - 'a'] + 1;
        }

        for (int i = 1; i < k; i++) {
            c[i] = c[i] + c[i - 1];
        }

        for (int i = word.length - 1; i >= 0; i--) {
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
//            root.addWord(prefix);
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), root);
        }
    }


}
