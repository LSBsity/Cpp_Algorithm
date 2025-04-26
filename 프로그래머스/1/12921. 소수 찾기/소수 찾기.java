class Solution {
    
    private int eratos(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    if (!prime[j]) {
                        prime[j] = true;
                    }
                }    
            }
            
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) count++;
        }
        return count;
    }
    
    public int solution(int n) {
        return this.eratos(n);
    }
}