import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T, N;
    static int result;

    static int[][] map;
    static boolean[][] v;

    // block 1 / 3이면 2 & 4면 1
    // block 2 / 1이면 2 & 4면 3
    // block 3 / 1이면 4 & 2면 3
    // block 4 / 3이면 4 & 2면 1

    static int[][] dirMap = {
            { -1, -1, 1, 0 },
            { 1, -1, -1, 2 },
            { 3, 2, -1, -1 },
            { -1, 0, 3, -1 }
    };

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());

            map = new int[N + 2][N + 2];
            v = new boolean[N + 2][N + 2];
            result = 0;

            for (int i = 0; i < N + 2; i++) {
                Arrays.fill(map[i], 5);
            }

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] == 0) {
                        for (int d = 0; d < 4; d++) {
                            result = Math.max(result, go(i, j, d));
                        }
                    }
                }
            }

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(result)
                    .append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static int go(int x, int y, int dir) {
        int sum = 0;

        int nx = x;
        int ny = y;
        int nd = dir;

        while (true) {
            nx += dx[nd];
            ny += dy[nd];

            if (map[nx][ny] == 5) {
                sum++;
                nd = reverse(nd);
                continue;
            }

            if ((nx == x && ny == y) || map[nx][ny] == -1)
                break;

            if (1 <= map[nx][ny] && map[nx][ny] <= 4) {
                sum++;
                nd = changeDir(nd, map[nx][ny]);
            }

            if (6 <= map[nx][ny]) {
                int[] next = findHole(nx, ny);
                nx = next[0];
                ny = next[1];
            }
        }

        return sum;
    }

    private static int changeDir(int d, int blockNum) {
        int newDir = dirMap[blockNum - 1][d];
        return newDir == -1 ? reverse(d) : newDir;
    }

    private static int[] findHole(int x, int y) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if ((i != x || j != y) && map[i][j] == map[x][y]) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { x, y };
    }

    private static int reverse(int dir) {
        if (dir == 0) {
            return 2;
        } else if (dir == 1) {
            return 3;
        } else if (dir == 2) {
            return 0;
        }
        return 1;
    }
}