class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 4; i <= n; i++) {
            if (check(i)) answer++;
        }
        
        return answer;
    }
    
    private boolean check(int n) {
        int count = 1;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
            
            if (count >= 3) return true;
        }
        return false;
    }
}