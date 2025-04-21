class Solution {
    public int solution(int n, int[][] arr) {
        int cnt = 0;
        boolean[] v = new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            if (!v[i]) {
                this.dfs(arr, v, i);
                cnt++;
            }
        }
        return cnt;
    }
    
    public void dfs(int[][] arr, boolean[] v, int s) {
        v[s] = true;
        for (int i = 0; i < arr.length; i++) {
            if (!v[i] && arr[s][i] == 1) {
                this.dfs(arr, v, i);
            }
        }
    }
}