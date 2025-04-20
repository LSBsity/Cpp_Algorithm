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
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = this.gcd(gcdA, arrayA[i]);
        }
        
        boolean check = false;
        for (var i : arrayB) {
            if (i % gcdA == 0) {
                check = true;
                break;
            } 
        }
        if (!check) return gcdA;
        
        return 0;
    }
}