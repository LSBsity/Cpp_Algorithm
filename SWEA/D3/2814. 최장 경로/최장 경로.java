import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, M;

    static int length;

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            visited = new boolean[N + 1];
            length = 0;

            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }


            for (int i = 1; i <= N; i++) {
                visited[i] = true;
                go(i, 1);
                visited[i] = false;
            }


            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(length)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go(int x, int depth) {
        length = Math.max(length, depth);

        for (int node : graph[x]) {
            if (!visited[node]) {
                visited[node] = true;
                go(node, depth + 1);
                visited[node] = false;
            }
        }
    }
}
