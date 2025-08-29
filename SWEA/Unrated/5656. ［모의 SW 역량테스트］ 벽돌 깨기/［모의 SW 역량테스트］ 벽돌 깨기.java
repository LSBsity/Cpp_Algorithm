import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T, N, W, H;
    static int total, answer;

    static int[][] map;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            total = 0;

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] >= 1) {
                        total++;
                    }
                }
            }

            answer = total;
            go(map, 0, total);

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(answer)
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static void go(int[][] next, int depth, int remain) {
        if (remain == 0) {
            answer = 0;
            return;
        }

        if (depth == N) {
            answer = Math.min(answer, remain);
            return;
        }

        if (answer == 0) {
            return;
        }

        for (int c = 0; c < W; c++) {
            int r = findFirstRow(next, c);
            if (r == -1) {
                go(next, depth + 1, remain);
            } else {
                int[][] newMap = copyMap(next);
                int explosed = explose(newMap, r, c);
                drop(newMap);
                go(newMap, depth + 1, remain - explosed);
                if (answer == 0) {
                    return;
                }
            }
        }
    }

    private static void drop(int[][] newMap) {
        for (int c = 0; c < W; c++) {
            int h = H - 1;
            for (int r = H - 1; r >= 0; r--) {
                if (newMap[r][c] != 0) {
                    int temp = newMap[r][c];
                    newMap[r][c] = 0;
                    newMap[h--][c] = temp;
                }
            }
        }
    }

    private static int explose(int[][] map, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int explosed = 0;

        if (map[x][y] > 1) {
            q.offer(new int[] { x, y, map[x][y] });
        }

        map[x][y] = 0;
        explosed++;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            int cx = current[0], cy = current[1], power = current[2];
            for (int i = 0; i < 4; i++) {
                int nx = cx;
                int ny = cy;
                for (int j = 1; j < power; j++) {
                    nx += dx[i];
                    ny += dy[i];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W)
                        break;
                    if (map[nx][ny] == 0)
                        continue;

                    if (map[nx][ny] > 1) {
                        q.offer(new int[] { nx, ny, map[nx][ny] });
                    }
                    map[nx][ny] = 0;
                    explosed++;
                }
            }

        }

        return explosed;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, W);
        }
        return newMap;
    }

    private static int findFirstRow(int[][] next, int c) {
        for (int r = 0; r < H; r++) {
            if (next[r][c] >= 1) {
                return r;
            }
        }
        return -1;
    }
}