class Solution {

    private long fino(int n) {
        long[] dp = new long[100001];
        dp[0] = 0L;
        dp[1] = 1L;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

    public int solution(int n) {
        return (int) this.fino(n);
    }
}