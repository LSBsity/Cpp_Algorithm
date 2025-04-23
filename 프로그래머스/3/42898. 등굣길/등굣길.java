class Solution {
    
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for(var i : puddles) {
            map[i[1] - 1][i[0] - 1] = -1;
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        
        return this.dfs(m, n, 0, 0, map, dp);
    }
    
    private int dfs(int m, int n, int i, int j, int[][] map, int[][] dp) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = 0;
        
        for (int d = 0; d < 2; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if (0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length && map[nx][ny] != -1) {
                dp[i][j] = (dp[i][j] + dfs(m, n, nx, ny, map, dp)) % 1_000_000_007;
            }
        }
        
        return dp[i][j];
    }
}