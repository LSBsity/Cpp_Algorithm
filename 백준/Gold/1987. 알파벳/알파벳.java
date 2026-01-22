import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, R, C;
    static char[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] visited;
    static Set<Character> set;

    static int max;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());


            map = new char[R][C];
            visited = new boolean[R][C];
            set = new HashSet<>();
            max = 0x80000000;

            for (int i = 0; i < R; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                    map[i][j] = chars[j];
                }
            }

            go(0, 0, 1);

            sb.append(max);
        }

        System.out.print(sb);
    }

    private static void go(int x, int y, int depth) {
        max = Math.max(max, depth);
        set.add(map[x][y]);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (set.contains(map[nx][ny])) continue;

            go(nx, ny, depth + 1);
        }

        set.remove(map[x][y]);
    }
}
