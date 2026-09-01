import java.util.*;

class Solution {

    public int solution(int n) {
        return eratos(n);
    }
    
    public int eratos(int n) {
        boolean[] arr = new boolean[n + 1];
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i]) continue;
            
            for (int j = i * i; j <= n; j += i) {
                arr[j] = true;
            }
        }
        
        int cnt = 0;
        for(int i = 2; i <= n; i++) {
            if (!arr[i]) cnt++;
        }
        
        return cnt;
    }

}