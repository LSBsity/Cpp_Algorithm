import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T, N;

    static int minDist;

    static int[] home = { 0, 0 };
    static int[] company = { 0, 0 };

    static int[][] client;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            client = new int[N][2];
            visited = new boolean[N + 2];
            minDist = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());

            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());

            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                client[i][0] = Integer.parseInt(st.nextToken());
                client[i][1] = Integer.parseInt(st.nextToken());
            }

            go(company[0], company[1], 0, 0);

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(minDist)
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static void go(int x, int y, int depth, int dist) {
        if (depth >= N) {
            dist += Math.abs(x - home[0]) + Math.abs(y - home[1]);
            minDist = Math.min(minDist, dist);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int nx = client[i][0];
                int ny = client[i][1];
                visited[i] = true;
                go(nx, ny, depth + 1, dist + Math.abs(x - nx) + Math.abs(y - ny));
                visited[i] = false;
            }
        }
    }
}
