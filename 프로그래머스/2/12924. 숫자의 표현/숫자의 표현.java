class Solution {

    public int solution(int n) {
        int answer = 0, start = 0;
        
        while (start < n) {
            int sum = 0;
            for (int i = start++; i < n; i++) {
                sum += i + 1;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum >= n) {
                    break;
                }
            }
        }

        return answer;
    }
}