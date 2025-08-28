import java.io.*;
import java.util.*;

public class Solution {

    static int N, W, H;
    static int answer;
    static final int[] dx = { -1, 1, 0, 0 };
    static final int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] map = new int[H][W];
            int total = 0;
            for (int r = 0; r < H; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if (map[r][c] > 0)
                        total++;
                }
            }

            answer = total;
            dfs(0, map, total);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int depth, int[][] map, int remain) {
        if (remain == 0) { // 다 깬 경우
            answer = 0;
            return;
        }
        if (depth == N) { // 구슬 다 쓴 경우
            answer = Math.min(answer, remain);
            return;
        }
        if (answer == 0)
            return; // 최선이면 종료

        for (int c = 0; c < W; c++) {
            int r = findFirstBrick(map, c);
            if (r == -1) {
                // 빈 열에 쏘는 경우: 변화는 없지만 구슬은 소비됨
                dfs(depth + 1, map, remain);
            } else {
                int[][] next = copy(map);
                int broken = boom(next, r, c);
                fall(next);
                dfs(depth + 1, next, remain - broken);
            }
            if (answer == 0)
                return;
        }
    }

    static int findFirstBrick(int[][] map, int c) {
        for (int r = 0; r < H; r++)
            if (map[r][c] != 0)
                return r;
        return -1;
    }

    static int[][] copy(int[][] src) {
        int[][] dst = new int[H][W];
        for (int i = 0; i < H; i++)
            System.arraycopy(src[i], 0, dst[i], 0, W);
        return dst;
    }

    static int boom(int[][] map, int x, int y) {
        int broken = 0;
        Queue<int[]> q = new ArrayDeque<>();
        if (map[x][y] > 1) {
            q.offer(new int[] { x, y, map[x][y] });
        }
        map[x][y] = 0;
        broken++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], power = cur[2];
            for (int i = 0; i < 4; i++) {
                int nx = r, ny = c;
                for (int j = 1; j < power; j++) {
                    nx += dx[i];
                    ny += dy[i];
                    if (nx < 0 || nx >= H || ny < 0 || ny >= W)
                        break;
                    if (map[nx][ny] == 0)
                        continue;
                    if (map[nx][ny] > 1)
                        q.offer(new int[] { nx, ny, map[nx][ny] });

                    map[nx][ny] = 0;
                    broken++;
                }
            }
        }

        return broken;
    }

    static void fall(int[][] map) {
        for (int c = 0; c < W; c++) {
            int write = H - 1;
            for (int r = H - 1; r >= 0; r--) {
                if (map[r][c] != 0) {
                    int val = map[r][c];
                    map[r][c] = 0;
                    map[write--][c] = val;
                }
            }
        }
    }
}
