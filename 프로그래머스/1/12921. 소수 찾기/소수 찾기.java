class Solution {
    
    public int eratos(int n) {
        boolean prime[] = new boolean[n + 1];
        
        prime[0] = prime[1] = true;
        
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!prime[i]) count++;
        }
        
        return count;
    }
    
    public int solution(int n) {
        return this.eratos(n);
    }
}