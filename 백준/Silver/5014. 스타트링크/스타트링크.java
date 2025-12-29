import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, F, S, G, U, D;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            F = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            U = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            go();
        }

        System.out.print(sb);
    }

    private static void go() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[F + 1];
        q.offer(new int[]{S, 0});
        visited[S] = true;


        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == G) {
                sb.append(cur[1]);
                return;
            }

            if (cur[0] + U <= F && !visited[cur[0] + U]) {
                visited[cur[0] + U] = true;
                q.offer(new int[]{cur[0] + U, cur[1] + 1});
            }
            if (cur[0] - D >= 1 && !visited[cur[0] - D]) {
                visited[cur[0] - D] = true;
                q.offer(new int[]{cur[0] - D, cur[1] + 1});
            }
        }
        sb.append("use the stairs");

    }
}
