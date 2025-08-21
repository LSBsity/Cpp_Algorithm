import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int flag = 0;
    static int[] start = {0, 0};

    public static void main(String[] args) throws Exception {
        T = 10;

        for (int t = 1; t <= T; t++) {
            map = new int[100][100];
            visited = new boolean[100][100];
            flag = 0;

            Integer.parseInt(br.readLine());

            for (int i = 0; i < 100; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = line[j] - '0';
                    if (map[i][j] == 2) {
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }
            go(start[0], start[1]);
            sb.append(String.format("#%d %d\n", t, flag));
        }
        System.out.println(sb);
    }

    private static void go(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == 3) {
            flag = 1;
            System.out.println(flag);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100) continue;
            if (visited[nx][ny] || map[nx][ny] == 1) continue;
            
            go(nx, ny);
        }
    }
}