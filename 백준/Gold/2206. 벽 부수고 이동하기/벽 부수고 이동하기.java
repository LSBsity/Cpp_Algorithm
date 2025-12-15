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
    static int answer;

    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M][2];
            answer = 0x7fffffff;

            for (int i = 0; i < N; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    map[i][j] = chars[j] - '0';
                }
            }
            go();

            sb.append(answer == 0x7fffffff ? -1 : answer);
        }

        System.out.print(sb);
    }

    private static void go() {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                answer = Math.min(answer, cur[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 1) {
                    if (!visited[nx][ny][1] && cur[3] == 0) { // 문을 부수지 않았으면
                        visited[nx][ny][1] = true;
                        q.offer(new int[]{nx, ny, cur[2] + 1, 1}); //부수고 진행
                    }
                } else {
                    if (!visited[nx][ny][cur[3]]) {
                        visited[nx][ny][cur[3]] = true;
                        q.offer(new int[]{nx, ny, cur[2] + 1, cur[3]});
                    }
                }

            }
        }
    }
}
