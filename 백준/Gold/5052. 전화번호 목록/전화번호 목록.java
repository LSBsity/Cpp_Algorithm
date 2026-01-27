import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            Trie trie = new Trie();

            boolean ok = true;
            for (int i = 0; i < N; i++) {
                String num = br.readLine();
                if (ok) {
                    if (!trie.insert(num)) {
                        ok = false;
                    }
                }
            }
            sb.append(ok ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }

    static class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public boolean insert(String num) {
            Node current = this.root;

            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);

                if (current.isEnd) {
                    return false;
                }

                if (current.child[c - '0'] == null) {
                    current.child[c - '0'] = new Node();
                }

                current = current.child[c - '0'];
            }

            if (current.hasChild()) {
                return false;
            }

            current.isEnd = true;
            return true;
        }

        static class Node {
            Node[] child = new Node[10];
            boolean isEnd = false;

            public boolean hasChild() {
                for (Node n : child) {
                    if (n != null) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

}
