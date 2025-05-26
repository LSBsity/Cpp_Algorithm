import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] map = new int[H][N][M];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        System.out.println(solve(map, M, N, H));
    }

    private static int solve(int[][][] map, int M, int N, int H) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] v = new boolean[H][N][M];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[k][i][j] == 1) {
                        q.offer(new int[]{k, i, j});
                        v[k][i][j] = true;
                    }
                }
            }
        }


        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nz = cur[0] + dz[i];
                int nx = cur[1] + dx[i];
                int ny = cur[2] + dy[i];
                if (nz >= 0 && nz < H && nx >= 0 && nx < N && ny >= 0 && ny < M && map[nz][nx][ny] != -1 && !v[nz][nx][ny]) {
                    q.offer(new int[]{nz, nx, ny});
                    map[nz][nx][ny] = map[cur[0]][cur[1]][cur[2]] + 1;
                    v[nz][nx][ny] = true;
                }
            }
        }
        int day = Integer.MIN_VALUE;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    day = Math.max(map[k][i][j], day);
                    if (map[k][i][j] == 0) {
                        return -1;
                    }
                }
            }
        }
        return day - 1;
    }
}
