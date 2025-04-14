class Solution {
    
    public int eratos(int n) {
        boolean[] check = new boolean[n + 1];
        
        for (int i = 2; i * i<= n; i++) {
            if (!check[i]) {
                for (int j = i * i; j <= n; j += i) {
                    check[j] = true;
                }    
            }
        }
        
        int count = 0;
        for (var i : check) {
            if (i == false) count++;
        }
        
        return count - 2;
    }
    
    public int solution(int n) {
        return this.eratos(n);
    }
}