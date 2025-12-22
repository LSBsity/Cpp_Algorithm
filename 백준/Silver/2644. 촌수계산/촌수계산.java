import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, M;
    static int answer, start, end;

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            visited = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            answer = -1;

            visited[start] = true;
            go(start, 0);

            sb.append(answer);
        }

        System.out.print(sb);
    }

    private static void go(int start, int depth) {
        if (start == end) {
            answer = depth;
            return;
        }

        for (int node : graph[start]) {
            if (!visited[node]) {
                visited[node] = true;
                go(node, depth + 1);
            }
        }
    }
}
