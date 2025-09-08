import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int K, H, W;

    static int[][] map;

    static int result;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int[] jx = { -2, -2, -1, -1, 1, 1, 2, 2 };
    static int[] jy = { -1, 1, -2, 2, -2, 2, -1, 1 };

    public static void main(String[] args) throws Exception {
        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go();
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void go() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] v = new boolean[H][W][K + 1];

        q.offer(new int[] { 0, 0, 0, 0 });
        v[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            if (current[0] == H - 1 && current[1] == W - 1) {
                result = Math.min(result, current[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W)
                    continue;
                if (v[nx][ny][current[3]] || map[nx][ny] == 1)
                    continue;

                q.offer(new int[] { nx, ny, current[2] + 1, current[3] });
                v[nx][ny][current[3]] = true;
            }

            if (current[3] >= K)
                continue;

            for (int i = 0; i < 8; i++) {
                int nx = current[0] + jx[i];
                int ny = current[1] + jy[i];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W)
                    continue;
                if (v[nx][ny][current[3] + 1] || map[nx][ny] == 1)
                    continue;

                q.offer(new int[] { nx, ny, current[2] + 1, current[3] + 1 });
                v[nx][ny][current[3] + 1] = true;
            }
        }

        return;
    }

}
