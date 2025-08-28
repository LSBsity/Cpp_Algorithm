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
                    if (map[i][j] > 0)
                        total++;
                }
            }

            answer = total;
            dfs(0, map, total);

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(answer)
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static void dfs(int depth, int[][] map, int remain) {
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
            int r = findFirst(map, c);
            if (r == -1) {
                dfs(depth + 1, map, remain);
            } else {
                int[][] newMap = copyMap(map);
                int explosed = explose(r, c, newMap);
                drop(newMap);
                dfs(depth + 1, newMap, remain - explosed);
            }

            if (answer == 0)
                break;
        }
    }

    public static void drop(int[][] newMap) {
        for (int c = 0; c < W; c++) {
            int pos = H - 1;
            for (int r = H - 1; r >= 0; r--) {
                if (newMap[r][c] != 0) {
                    int temp = newMap[r][c];
                    newMap[r][c] = 0;
                    newMap[pos--][c] = temp;
                }
            }
        }
    }

    public static int explose(int x, int y, int[][] newMap) {
        int explosed = 0;
        Queue<int[]> q = new LinkedList<>();

        if (newMap[x][y] >= 1) {
            q.offer(new int[] { x, y, newMap[x][y] });
        }

        newMap[x][y] = 0;
        explosed++;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0], c = current[1], power = current[2];
            for (int i = 0; i < 4; i++) {
                int nx = r;
                int ny = c;
                for (int j = 1; j < power; j++) {
                    nx += dx[i];
                    ny += dy[i];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W)
                        break;
                    if (newMap[nx][ny] == 0)
                        continue;
                    if (newMap[nx][ny] > 1)
                        q.offer(new int[] { nx, ny, newMap[nx][ny] });

                    newMap[nx][ny] = 0;
                    explosed++;
                }
            }
        }

        return explosed;
    }

    public static int findFirst(int[][] map, int c) {
        for (int r = 0; r < H; r++) {
            if (map[r][c] > 0)
                return r;
        }
        return -1;
    }

    public static int[][] copyMap(int[][] srcMap) {
        int[][] newMap = new int[H][W];

        for (int i = 0; i < H; i++) {
            System.arraycopy(srcMap[i], 0, newMap[i], 0, W);
        }

        return newMap;
    }
}