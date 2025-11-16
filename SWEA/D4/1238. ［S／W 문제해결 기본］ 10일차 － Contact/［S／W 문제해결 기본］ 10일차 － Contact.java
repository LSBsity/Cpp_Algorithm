import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;

    static int start;

    static List<Integer>[] graph;
    static boolean[] visited;

    static int answer, maxDepth;

    public static void main(String[] args) throws Exception {
        T = 10;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            visited = new boolean[101];
            graph = new ArrayList[101];
            for (int i = 1; i <= 100; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
            }

            answer = 0x80000000;
            maxDepth = 0x80000000;
            go(start);

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(answer)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go(int start) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{start, 1});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int depth = cur[1];

            if (depth > maxDepth) {
                maxDepth = depth;
                answer = node;
            } else if (depth == maxDepth) {
                answer = Math.max(answer, node);
            }

            for (int next : graph[node]) {
                if (visited[next]) continue;

                visited[next] = true;
                q.offer(new int[]{next, depth + 1});
            }
        }
    }
}
