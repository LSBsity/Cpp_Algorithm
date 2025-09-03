import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int N, M;

    static char[][] map;
    static int[] starts = { 0, 0 };

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j];
                if (map[i][j] == '0') {
                    starts[0] = i;
                    starts[1] = j;
                }
            }
        }

        System.out.println(go(starts[0], starts[1]));
    }

    public static int go(int x, int y) {
        // 1 << 5 -> 111111
        boolean[][][] visited = new boolean[N][M][64];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { x, y, 0, 0 });
        visited[x][y][0] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            if (map[current[0]][current[1]] == '1') {
                return current[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                int keys = current[3];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (map[nx][ny] == '#')
                    continue;

                char c = map[nx][ny];

                // 문
                if (c >= 'A' && c <= 'F') {
                    if ((keys & (1 << (c - 'A'))) == 0) {
                        continue;
                    }
                }

                // 열쇠
                if (c >= 'a' && c <= 'f') {
                    keys |= 1 << (c - 'a');
                }

                if (!visited[nx][ny][keys]) {
                    q.offer(new int[] { nx, ny, current[2] + 1, keys });
                    visited[nx][ny][keys] = true;
                }
            }
        }
        return -1;
    }
}