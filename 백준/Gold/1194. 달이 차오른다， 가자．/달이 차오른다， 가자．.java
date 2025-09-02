import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0') {
                    startX = i;
                    startY = j;
                }
            }
        }

        int result = go(startX, startY);
        System.out.println(result);
    }

    private static int go(int startX, int startY) {
        boolean[][][] visited = new boolean[N][M][64];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { startX, startY, 0, 0 });
        visited[startX][startY][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (map[cur[0]][cur[1]] == '1') return cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int keys = cur[3];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == '#') continue;

                char c = map[nx][ny];

                if (c >= 'A' && c <= 'F') {
                    int doorBit = 1 << (c - 'A');
                    if ((keys & doorBit) == 0) continue;
                }

                if (c >= 'a' && c <= 'f') {
                    keys |= 1 << (c - 'a');
                }

                if (!visited[nx][ny][keys]) {
                    visited[nx][ny][keys] = true;
                    q.offer(new int[] { nx, ny, cur[2] + 1, keys });
                }
            }
        }

        return -1;
    }

}
