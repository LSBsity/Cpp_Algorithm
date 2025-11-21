import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;

    static boolean answer;

    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        T = 10;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            N = Integer.parseInt(st.nextToken());
            answer = false;

            graph = new ArrayList[100];
            for (int i = 0; i < 100; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
            }

            go(0);

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(answer ? '1' : '0')
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go(int start) {
        for (int node : graph[start]) {
            if (node == 99) {
                answer = true;
                return;
            }
            go(node);
        }
    }
}
