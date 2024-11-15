class Solution {
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    int lcm(int b) {
        return 6 * b / gcd(6, b);
    }

    public int solution(int n) {
        return lcm(n) / 6;
    }
}
