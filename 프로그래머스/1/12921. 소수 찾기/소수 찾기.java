import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n + 1];
        
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) answer++;
        }
        
        return answer;
    }
}