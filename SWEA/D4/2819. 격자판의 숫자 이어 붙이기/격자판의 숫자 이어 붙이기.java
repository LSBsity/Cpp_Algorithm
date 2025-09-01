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

    static Set<String> set;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            map = new int[4][4];

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                set = new HashSet<>();
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, "");
                }
            }

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(set.size())
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static void dfs(int x, int y, String str) {
        if (str.length() == 7) {
            set.add(str);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)
                continue;

            dfs(nx, ny, str + map[nx][ny]);
        }
    }
}
