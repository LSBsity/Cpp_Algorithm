class Solution {
    
    private void go(int[][] computers, boolean[] v, int node) {
        v[node] = true;
        for (int i = 0; i < computers[0].length; i++) {
            if (!v[i] && computers[node][i] == 1) {
                this.go(computers, v, i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] v = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                this.go(computers, v, i);
                answer++;
            }
        }
        
        return answer;
    }
}