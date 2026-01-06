import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, K;

    static int[] coins;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            coins = new int[N];
            dp = new long[K + 1];
            dp[0] = 1;

            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            go();
        }

        System.out.print(sb);
    }

    private static void go() {
        for (int i = 0; i < N; i++) {
            int coin = coins[i];

            for (int sum = coin; sum <= K; sum++) {
                dp[sum] += dp[sum - coin];
            }
        }

        sb.append(dp[K]);
    }
}