import java.io.*;
import java.util.*;

public class Main {
    static int R, C, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        char[][] init = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            init[i] = line.toCharArray();
        }

        if (N == 1) {
            printGrid(init);
            return;
        }

        if (N % 2 == 0) {
            // 모든 칸이 폭탄
            char[][] full = new char[R][C];
            for (int i = 0; i < R; i++) Arrays.fill(full[i], 'O');
            printGrid(full);
            return;
        }

        // N은 홀수이고 N >= 3
        char[][] g1 = explode(init);      // t = 3 상태
        if (N % 4 == 3) {
            printGrid(g1);
            return;
        } else {
            // N % 4 == 1 (N >= 5)
            char[][] g2 = explode(g1);
            printGrid(g2);
            return;
        }
    }

    // 주어진 grid에 있는 폭탄들이 폭발했을 때의 결과를 반환
    static char[][] explode(char[][] grid) {
        char[][] res = new char[R][C];
        // 처음은 모두 'O'로 채운 뒤, 폭발로 파괴되는 곳을 '.'으로 바꾼다.
        for (int i = 0; i < R; i++) Arrays.fill(res[i], 'O');

        int[] dr = {0, 0, 0, 1, -1};
        int[] dc = {0, 1, -1, 0, 0};

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 'O') {
                    // 이 칸과 인접한 4칸을 파괴
                    for (int k = 0; k < 5; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                            res[nr][nc] = '.';
                        }
                    }
                }
            }
        }
        return res;
    }

    static void printGrid(char[][] g) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(g[i]);
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
