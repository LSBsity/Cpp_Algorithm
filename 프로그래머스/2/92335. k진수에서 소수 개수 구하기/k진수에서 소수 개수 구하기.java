import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] result = Integer.toString(n, k).split("0");
        
        for (String str : result) {
            if (str.equals("")) continue;
            
            if (isPrime(Long.parseLong(str))) answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(long n) {
        if (n < 2) return false;
        
        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}