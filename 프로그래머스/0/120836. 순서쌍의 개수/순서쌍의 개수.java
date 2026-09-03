class Solution {
    public int solution(int n) {
        int answer = 1;
        int a = 1;
        int b = n;
        while (a < b) {
            a++;
            if (n % a == 0) answer++;
        }
        
        return answer;
    }
}