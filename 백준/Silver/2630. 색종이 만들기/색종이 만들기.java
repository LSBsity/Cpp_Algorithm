import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static StringBuilder sb;

    static int[][] map;
    static int N;

    static int[] cnt = { 0, 0 };

    public static int go(int x, int y, int size) {
        if (size == 1) {
            cnt[map[x][y]]++;
            return map[x][y];
        }

        int a = go(x + size / 2, y + size / 2, size / 2);
        int b = go(x + size / 2, y, size / 2);
        int c = go(x, y + size / 2, size / 2);
        int d = go(x, y, size / 2);

        if (a == b && b == c && c == d) {
            if (a == 0) {
                cnt[0] -= 3;
            } else if (a == 1) {
                cnt[1] -= 3;
            }
            return a;
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, 0, N);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
    }
}