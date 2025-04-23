class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n][m];
        
        for (var i : puddles) {
            dp[i[1] - 1][i[0] - 1] = -1;
        }
        
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i >= 1) dp[i][j] += dp[i - 1][j] % 1_000_000_007;    
                if (j >= 1) dp[i][j] += dp[i][j - 1] % 1_000_000_007;
            }
        }
        
        return dp[n - 1][m - 1] % 1_000_000_007;
    }
}