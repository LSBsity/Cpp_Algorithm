import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int T, N;

    static int[][] map;
    static boolean[][] visited;

    static int maxTaste;
    static int answer;
    static int cnt;


    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            maxTaste = 0x80000000;
            answer = 0x80000000;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxTaste = Math.max(maxTaste, map[i][j]);
                }
            }
            go();

            for (int d = 1; d <= maxTaste; d++) {
                cnt = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] == d) map[i][j] = 0;
                    }
                }

                go();

            }

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(answer)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go() {
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        answer = Math.max(answer, cnt);
    }

    private static void dfs(int x, int y) {
        if (visited[x][y]) return;

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (map[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }
}
