import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, M;

    static int[][] map;
    static boolean[][] isAir;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = go();

            sb.append(result);
        }

        System.out.println(sb);
    }

    private static int go() {
        int time = 0;

        while (true) {
            time++;

            bfsAir();
            melt();

            if (check()) break;
        }

        return time;
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) return false;
            }
        }
        return true;
    }

    private static void melt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int contactAir = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (isAir[nx][ny]) contactAir++;
                    }

                    if (contactAir >= 2) map[i][j] = 0;
                }
            }
        }
    }

    private static void bfsAir() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        isAir = new boolean[N][M];

        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        isAir[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                isAir[nx][ny] = true;
            }
        }
    }
}
