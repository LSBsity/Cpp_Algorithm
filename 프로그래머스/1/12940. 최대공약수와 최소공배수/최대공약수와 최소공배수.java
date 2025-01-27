class Solution {

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int[] solution(int n, int m) {
        return new int[]{gcd(n, m), lcm(n, m)};
    }
}