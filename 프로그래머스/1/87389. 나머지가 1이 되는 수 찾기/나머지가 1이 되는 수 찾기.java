class Solution {
    public int solution(int n) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 1) {
                answer = Math.min(answer, i);
            }
        }
        
        return answer;
    }
}