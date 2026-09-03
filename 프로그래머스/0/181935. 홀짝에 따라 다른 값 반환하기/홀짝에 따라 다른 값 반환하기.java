class Solution {
    public int solution(int n) {
        int answer = 0;

        int rem = n % 2;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == rem) answer += rem == 0 ? i * i : i;
        }
        
        return answer;
    }
}