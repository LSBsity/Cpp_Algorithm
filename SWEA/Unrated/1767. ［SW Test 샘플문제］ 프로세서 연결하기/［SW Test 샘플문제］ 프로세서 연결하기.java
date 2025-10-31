import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int T, N;

    static int maxCore, minLen;

    static int[][] map;

    static List<int[]> cores;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            cores = new ArrayList<>();
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 0) continue;
                    if (i == 0 || j == 0 || i == N - 1 || j == N - 1) continue;

                    cores.add(new int[]{i, j});
                }
            }

            maxCore = 0;
            minLen = 0x7fffffff;

            go(0, 0, 0);

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(minLen)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go(int idx, int length, int connected) {
        if (connected + (cores.size() - idx) < maxCore) return;

        if (idx == cores.size()) {
            if (connected > maxCore) {
                maxCore = connected;
                minLen = length;
            } else if (connected == maxCore) {
                minLen = Math.min(minLen, length);
            }
            return;
        }

        int i = cores.get(idx)[0];
        int j = cores.get(idx)[1];

        for (int d = 0; d < 4; d++) {
            int x = i;
            int y = j;

            List<int[]> path = new ArrayList<>();
            int cnt = 0;

            boolean can = true;
            while (true) {
                x += dx[d];
                y += dy[d];

                if (x < 0 || y < 0 || x >= N | y >= N) break;
                if (map[x][y] != 0) {
                    can = false;
                    break;
                }

                path.add(new int[]{x, y});
                cnt++;
            }

            if (can) {
                for (int[] p : path) {
                    map[p[0]][p[1]] = 2;
                }
                go(idx + 1, length + cnt, connected + 1);
                for (int[] p : path) {
                    map[p[0]][p[1]] = 0;
                }
            }
        }
        go(idx + 1, length, connected);
    }
}
