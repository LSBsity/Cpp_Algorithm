import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int answer = Integer.MAX_VALUE;

    static int[] paper = { 5, 5, 5, 5, 5 };
    static int[][] map = new int[10][10];

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void go(int x, int y) {
        if (x == 10) {
            int used = 25 - Arrays.stream(paper).sum();
            answer = Math.min(answer, used);
            return;
        }

        int used = 25 - Arrays.stream(paper).sum();
        if (used >= answer)
            return;

        int nextX = x;
        int nextY = y + 1;
        if (nextY >= 10) {
            nextY = 0;
            nextX += 1;
        }

        if (map[x][y] == 1) {
            for (int cnt = 4; cnt >= 0; cnt--) {
                if (paper[cnt] == 0)
                    continue;

                boolean check = true;
                Loop: for (int i = x; i < x + (cnt + 1); i++) {
                    for (int j = y; j < y + (cnt + 1); j++) {
                        if (i < 0 || j < 0 || i >= 10 || j >= 10 || map[i][j] == 0) {
                            check = false;
                            break Loop;
                        }
                    }
                }

                if (check) {
                    paper[cnt]--;
                    for (int i = x; i < x + (cnt + 1); i++) {
                        for (int j = y; j < y + (cnt + 1); j++) {
                            map[i][j] = 0;
                        }
                    }

                    go(nextX, nextY);

                    paper[cnt]++;
                    for (int i = x; i < x + (cnt + 1); i++) {
                        for (int j = y; j < y + (cnt + 1); j++) {
                            map[i][j] = 1;
                        }
                    }
                }
            }
        } else {
            go(nextX, nextY);
        }
    }
}
