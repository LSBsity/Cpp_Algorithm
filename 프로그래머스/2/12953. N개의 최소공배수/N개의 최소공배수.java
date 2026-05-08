class Solution {
    
    private int lcm(int a, int b) {
        return a * b / this.gcd(a, b);
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        
        return this.gcd(b, a % b);
    }
    
    public int solution(int[] arr) {
        int answer = 1;
        
        for (int i : arr) {
            answer = this.lcm(answer, i);
        }
        
        return answer;
    }
}