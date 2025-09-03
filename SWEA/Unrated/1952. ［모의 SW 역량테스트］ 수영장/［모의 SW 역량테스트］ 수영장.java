import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T;

    static int[] prices;
    static int[] dp;

    static int result;

    static int day, month, threeMonth, year;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            threeMonth = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());

            prices = new int[13];
            dp = new int[13];

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= 12; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= 12; i++) {
                int thisMonthMinPrice = Math.min(prices[i] * day, month);
                dp[i] = dp[i - 1] + thisMonthMinPrice;

                int threeMonthPrice = dp[Math.max(0, i - 3)] + threeMonth;
                dp[i] = Math.min(dp[i], threeMonthPrice);
            }

            result = Math.min(dp[12], year);

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(result)
                    .append('\n');
        }

        System.out.println(sb);
    }
}