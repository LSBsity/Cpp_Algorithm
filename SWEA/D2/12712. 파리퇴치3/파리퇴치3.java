import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] ax = {-1, -1, 1, 1};
    static int[] ay = {-1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = solve(map, N, M - 1);
            System.out.printf("#%d %d\n", t, result);
        }
    }

    private static int solve(int[][] map, int n, int m) {
        int max = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum1 = map[i][j];
                int sum2 = map[i][j];

                for (int l = 1; l <= m; l++) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + (dx[k] * l);
                        int ny = j + (dy[k] * l);
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        sum1 += map[nx][ny];
                    }
                    for (int k = 0; k < 4; k++) {
                        int nx = i + (ax[k] * l);
                        int ny = j + (ay[k] * l);
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        sum2 += map[nx][ny];
                    }
                }
                max = Math.max(max, Math.max(sum1, sum2));
            }
        }
        return max;
    }
}

