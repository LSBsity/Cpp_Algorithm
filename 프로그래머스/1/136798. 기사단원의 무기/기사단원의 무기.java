class Solution {
    
    public static int go(int number) {
        if (number <= 2) return number;
        
        int count = 2;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) count++;
        }
        
        return count;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int val = go(i);
            if (val > limit) {
                answer += power;
            } else {
                answer += val;
            }
        }
        
        return answer;
    }
}