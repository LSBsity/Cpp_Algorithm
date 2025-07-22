import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static TrieNode root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        root = new TrieNode();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            insert(word);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (search(query)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void insert(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode.children.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.children.get(c);
        }
        currentNode.isEndOfWord = true;
    }

    private static boolean search(String prefix) {
        TrieNode currentNode = root;
        for (char c : prefix.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.children.get(c);
        }
        return true;
    }

}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        this.children = new HashMap<>();
        isEndOfWord = false;
    }
}
