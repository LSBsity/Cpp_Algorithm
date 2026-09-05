class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        boolean aEven = a % 2 == 0;
        boolean bEven = b % 2 == 0;
        
        if (aEven && bEven) {
            answer = Math.abs(a - b);
        } else if (!aEven && !bEven) {
            answer = (a * a) + (b * b);
        } else {
            answer = 2 * (a + b);
        }
        
        
        return answer;
    }
}