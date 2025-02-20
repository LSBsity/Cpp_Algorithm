class Solution {
    
    public int lcm(int a, int b) {
        return (a * b) / this.gcd(a, b);
    }
    
    public int gcd(int a, int b) {
        return b == 0 ? a : this.gcd(b, a % b);
    }
    
    public int solution(int[] arr) {
        int lcm = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            lcm = this.lcm(lcm, arr[i]);
        }
        
        return lcm;
    }
}