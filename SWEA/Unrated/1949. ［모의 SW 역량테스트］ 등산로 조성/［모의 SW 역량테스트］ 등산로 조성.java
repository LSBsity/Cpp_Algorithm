import java.util.*;
import java.io.*;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int T, N, K;

    static int[][] map;
    static boolean[][] visited;

    static int maxDepth;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];
            maxDepth = 0x80000000;

            int maxHeight = 0x80000000;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxHeight) {
                        visited[i][j] = true;
                        go(i, j, 1, false);
                        visited[i][j] = false;
                    }
                }
            }

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(maxDepth)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go(int x, int y, int depth, boolean hasCut) {
        maxDepth = Math.max(maxDepth, depth);

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[nx][ny]) continue;

            if (map[nx][ny] < map[x][y]) {
                visited[nx][ny] = true;
                go(nx, ny, depth + 1, hasCut);
                visited[nx][ny] = false;
            } else if (!hasCut && map[nx][ny] - K < map[x][y]) {
                int origin = map[nx][ny];
                map[nx][ny] = map[x][y] - 1;

                visited[nx][ny] = true;
                go(nx, ny, depth + 1, true);
                visited[nx][ny] = false;

                map[nx][ny] = origin;
            }
        }
    }
}