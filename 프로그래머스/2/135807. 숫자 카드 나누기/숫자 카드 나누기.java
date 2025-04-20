class Solution {
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return this.gcd(b, a % b);
    }
    
    public int lcm(int a, int b) {
        return a * b / this.gcd(a, b);
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(go(arrayA, arrayB), go(arrayB, arrayA));
    }
    
    public int go(int[] arrayA, int[] arrayB) {
        int gcd = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcd = this.gcd(gcd, arrayA[i]);
            if (gcd == 1) return 0;
        }
        
        for (var i : arrayB) {
            if (i % gcd == 0) {
                return 0;
            } 
        }
        return gcd;
    }
}