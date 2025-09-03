import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T;
    static int N, L;

    static int[][] items;

    static int[][] dp;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");

            N = Integer.parseInt(line[0]);
            L = Integer.parseInt(line[1]);

            items = new int[N + 1][2];
            dp = new int[N + 1][L + 1];

            for (int i = 1; i <= N; i++) {
                line = br.readLine().split(" ");

                items[i][0] = Integer.parseInt(line[0]); // score
                items[i][1] = Integer.parseInt(line[1]); // kcal
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= L; j++) {
                    if (items[i][1] <= j) { // 담을 수 있으면
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][1]] + items[i][0]);
                    } else { // 담을 수 없으면
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(dp[N][L])
                    .append('\n');
        }

        System.out.println(sb);
    }
}