import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int answer = -1;
    static int M, N, H;

    static Queue<int[]> q = new LinkedList<>();
    static boolean[][][] visited;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};


    private static void go(int[][][] arr) {
        while(!q.isEmpty()) {
            int[] current = q.poll();
            visited[current[0]][current[1]][current[2]] = true;

            for (int i = 0; i < 6; i++) {
                int nz = current[0] + dz[i];
                int nx = current[1] + dx[i];
                int ny = current[2] + dy[i];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M || arr[nz][nx][ny] != 0 || visited[nz][nx][ny]) continue;

                q.offer(new int[]{nz, nx, ny, current[3] + 1});
                arr[nz][nx][ny] = current[3] + 1;
                answer = Math.max(answer, arr[nz][nx][ny]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[H][N][M];
        visited = new boolean[H][N][M];
        boolean check = false;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k, 0});
                    }
                    if (arr[i][j][k] == 0) check = true;
                }
            }
        }
        if (!check) {
            System.out.println("0");
            return;
        }

        go(arr);

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
