import java.io.*;
import java.util.*;

public class Main {

    static final int N = 8;
    static char[][] map = new char[N][N];

    static int[] dx = {0, -1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, 1, 0, -1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs() ? 1 : 0);
    }

    static boolean bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{7, 0});

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                if (map[x][y] == '#') continue;
                if (x == 0 && y == 7) return true;

                for (int d = 0; d < 9; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (map[nx][ny] == '#') continue;
                    if (nx - 1 >= 0 && map[nx - 1][ny] == '#') continue;

                    q.offer(new int[]{nx, ny});
                }
            }

            moveWall();
        }

        return false;
    }

    static void moveWall() {
        for (int i = N - 1; i > 0; i--) {
            map[i] = map[i - 1].clone();
        }
        Arrays.fill(map[0], '.');
    }
}
