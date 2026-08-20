class Solution {
    public int solution(int n, int w, int num) {
        int m = n % w != 0 ? (n / w) + 1 : n / w;
        int x = 0, y = 0;
        
        int[][] map = new int[m][w];
        for (int i = 0, idx = 1; i < m; i++) {
            for (int j = 0, sub = w - 1; j < w; j++, idx++, sub -= 2) {
                map[i][j] = i % 2 == 0 ? idx : idx + sub;
                
                if (map[i][j] == num) {
                    x = i;
                    y = j;
                }
            }
        }
        
        int temp = x;
        while (temp < m && map[temp][y] <= n) temp++;

        return temp - x;
    }
}