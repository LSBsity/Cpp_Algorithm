import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int L, R, C;

    static char[][][] map;
    static boolean[][][] visited;

    // 상, 하, 북, 남, 서, 동
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, 0, -1, 0};
    static int[] dy = {0, 0, 0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L + R + C == 0) break;

            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            int[] start = {-1, -1, -1};
            for (int l = 0; l < L; l++) {
                for (int i = 0; i < R; i++) {
                    char[] chars = br.readLine().toCharArray();
                    for (int j = 0; j < C; j++) {
                        map[l][i][j] = chars[j];
                        if (map[l][i][j] == 'S') {
                            start[0] = l;
                            start[1] = i;
                            start[2] = j;
                        }
                    }
                }
                br.readLine();
            }

            int result = go(start);
            if (result == -1) {
                sb.append("Trapped!")
                        .append('\n');
            } else {
                sb.append(String.format("Escaped in %d minute(s).", result))
                        .append('\n');
            }
        }

        System.out.print(sb);
    }

    private static int go(int[] start) {
        if (start[0] == -1 && start[1] == -1 && start[2] == -1) return -1;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1], start[2], 0});
        visited[start[0]][start[1]][start[2]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (map[cur[0]][cur[1]][cur[2]] == 'E') {
                return cur[3];
            }

            for (int i = 0; i < 6; i++) {
                int nz = cur[0] + dz[i];
                int nx = cur[1] + dx[i];
                int ny = cur[2] + dy[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= R || ny >= C || nz >= L) continue;
                if (map[nz][nx][ny] == '#') continue;
                if (visited[nz][nx][ny]) continue;

                visited[nz][nx][ny] = true;
                q.offer(new int[]{nz, nx, ny, cur[3] + 1});
            }
        }

        return -1;
    }
}
