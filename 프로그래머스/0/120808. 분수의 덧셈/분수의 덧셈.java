class Solution {

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int a = lcm(denom1, denom2);

        numer1 *= a / denom1;
        numer2 *= a / denom2;
        int sumA = numer1 + numer2;

        int gcd = this.gcd(sumA, a);
        
        if (gcd < 2) {
            return new int[]{sumA, a};
        }
        return new int[]{sumA / gcd, a / gcd};
    }
}