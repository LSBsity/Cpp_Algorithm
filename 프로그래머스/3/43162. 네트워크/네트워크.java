class Solution {
    
    private void dfs(int[][] arr, boolean[] v, int s) {
        v[s] = true;
        for (int i = 0; i < arr.length; i++) {
            if (!v[i] && arr[s][i] == 1) {
                this.dfs(arr, v, i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] v = new boolean[n];
        
        for (int i = 0; i < computers.length; i++) {
            if (!v[i]) {
                this.dfs(computers, v, i);
                count++;
            }
        }
        
        return count;
    }
}