import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int[] dx = {0, 0, -1};
    static int[] dy = {-1, 1, 0};

    static int T;
    static int N = 100;

    static int[] start = {0, 0};

    static int[][] map;
    static boolean[][] visited;

    static int ans;

    public static void main(String[] args) throws Exception {

        for (int t = 1; t <= 10; t++) {
            T = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N][N];
            ans = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }

            visited[start[0]][start[1]] = true;
            go(start[0], start[1]);

            sb.append('#')
                    .append(T)
                    .append(' ')
                    .append(ans)
                    .append('\n');
        }
        System.out.println(sb);
    }

    private static void go(int x, int y) {
        if (x == 0) {
            ans = y;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (map[nx][ny] == 0 || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            go(nx, ny);
            return;
        }
    }
}