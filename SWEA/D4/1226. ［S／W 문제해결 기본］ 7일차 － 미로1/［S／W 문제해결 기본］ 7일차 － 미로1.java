import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N = 16;
    static int T;

    static boolean check;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] coords = {
            {0, 0},
            {0, 0}
    };


    public static void main(String[] args) throws Exception {
        T = 10;

        for (int t = 1; t <= T; t++) {
            map = new int[N][N];
            visited = new boolean[N][N];
            check = false;

            sb.append('#')
                    .append(Integer.parseInt(br.readLine()))
                    .append(' ');

            for (int i = 0; i < N; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = chars[j] - 48;
                    if (map[i][j] == 2) {
                        coords[0][0] = i;
                        coords[0][1] = j;
                    } else if (map[i][j] == 3) {
                        coords[1][0] = i;
                        coords[1][1] = j;
                    }
                }

            }

            go(coords[0][0], coords[0][1]);

            sb.append(check ? 1 : 0)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go(int x, int y) {
        if (x == coords[1][0] && y == coords[1][1]) {
            check = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (map[nx][ny] == 1) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            go(nx, ny);
        }
    }
}