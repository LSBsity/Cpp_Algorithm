import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, K;

    static boolean[] visited = new boolean[222_223];

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        }

        sb.append(go());
        System.out.println(sb);
    }


    private static int go() {
        Deque<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{N, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];

            if (pos == K) return cur[1];
            if (pos < 0 || pos > 222_222 || visited[pos]) continue;

            visited[pos] = true;

            q.offerFirst(new int[]{pos * 2, cur[1]});
            q.offerLast(new int[]{pos - 1, cur[1] + 1});
            q.offerLast(new int[]{pos + 1, cur[1] + 1});
        }

        return -1;
    }
}
