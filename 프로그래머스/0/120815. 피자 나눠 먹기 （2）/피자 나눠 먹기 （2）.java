class Solution {
    public int solution(int n) {
        return lcm(n, 6) / 6;
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private int lcm(int a,int b) {
        return a * b / gcd(a, b);
    } 
}