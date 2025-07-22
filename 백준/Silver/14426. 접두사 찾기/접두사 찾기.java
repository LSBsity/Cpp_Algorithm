import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Trie root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        root = new Trie();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            insert(word);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (search(query)) answer++;
        }

        System.out.println(answer);
    }

    private static void insert(String word) {
        Trie temp = root;
        for (char c : word.toCharArray()) {
            temp.child.putIfAbsent(c, new Trie());
            temp = temp.child.get(c);
        }
        temp.isEndOfWord = true;
    }

    private static boolean search(String query) {
        Trie temp = root;
        for (char c : query.toCharArray()) {
            if (!temp.child.containsKey(c)) return false;
            temp = temp.child.get(c);
        }

        return true;
    }
}

class Trie {
    Map<Character, Trie> child;
    boolean isEndOfWord;

    public Trie() {
        this.child = new HashMap<>();
        this.isEndOfWord = false;
    }
}
