import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;

    static int[] start = {0, 0};
    static int[] end = {0, 0};

    static int[][] store;
    static boolean[] visited;


    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            store = new int[N][2];
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                store[i][0] = Integer.parseInt(st.nextToken());
                store[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            go();
        }

        System.out.print(sb);
    }

    private static void go() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1]});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (dist(cur, end) <= 1000) {
                sb.append("happy")
                        .append('\n');
                return;
            }

            for (int i = 0; i < N; i++) {
                if (!visited[i] && dist(cur, store[i]) <= 1000) {
                    visited[i] = true;
                    q.offer(new int[]{store[i][0], store[i][1]});
                }
            }
        }

        sb.append("sad")
                .append('\n');
    }

    private static int dist(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }

}
