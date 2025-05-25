import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(solve(n));
        }
    }

    private static int solve(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; 

        int[] nums = {1, 2, 3};
        for (int num : nums) {
            for (int i = num; i <= n; i++) {
                dp[i] += dp[i - num];
            }
        }

        return dp[n];
    }
}
