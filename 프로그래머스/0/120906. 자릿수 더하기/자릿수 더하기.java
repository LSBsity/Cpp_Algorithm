class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while (n > 0) {
            int rem = n % 10;
            n /= 10;
            answer += rem;
        }
        
        return answer;
    }
}